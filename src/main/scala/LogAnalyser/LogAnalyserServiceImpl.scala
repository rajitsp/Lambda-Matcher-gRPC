package LogAnalyser

//#import
import HelperUtils.ObtainConfigReference

import scala.concurrent.Future
import akka.NotUsed
import akka.actor.typed.ActorSystem
import scalaj.http.{Http, HttpOptions, HttpRequest}
import akka.stream.scaladsl.BroadcastHub
import akka.stream.scaladsl.Keep
import akka.stream.scaladsl.MergeHub
import akka.stream.scaladsl.Sink
import akka.stream.scaladsl.Source

//#import

//#service-request-reply
//#service-stream
class LogAnalyserServiceImpl(system: ActorSystem[_]) extends LogFinderService {
  private implicit val sys: ActorSystem[_] = system

  val config = ObtainConfigReference("input_data") match {
    case Some(value) => value
    case None => throw new RuntimeException("Cannot obtain a reference to the config data.")

  }
  //#service-request-reply
  val (inboundHub: Sink[FindLogRequest, NotUsed], outboundHub: Source[FindLogReply, NotUsed]) =
    MergeHub.source[FindLogRequest]
      .map(request => FindLogReply(s"Log Time stamp, ${request.timestamp}"))
      .toMat(BroadcastHub.sink[FindLogReply])(Keep.both)
      .run()
  //#service-request-reply

  override def findLog(request: FindLogRequest): Future[FindLogReply] = {

    val end_point = config.getString("input_data.AWS_APIGateway_Endpoint")

    val timestamp_req = s"""{
                           |  "timestamp": "${request.timestamp}",
                           |  "delta": "${request.delta}"
                           |}""".stripMargin

    val r = Http(end_point).postData(data = timestamp_req)
      .header("Content-Type", "application/json")
      .header("Charset", "UTF-8")
      .option(HttpOptions.readTimeout(10000)).asString

    //val response = Http(end_point).postData(timestamp_req).header("content-type", "application/json").option(HttpOptions.method("POST"))
    //val final_res = read(r.text().toString)
    println("Final result", r)
    Future.successful(FindLogReply(s"Timestamp, ${r}"))


  }

  //#service-request-reply

}
//#service-stream
//#service-request-reply
