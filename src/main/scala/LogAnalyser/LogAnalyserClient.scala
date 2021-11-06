package LogAnalyser

//#import
import scala.concurrent.duration._
import scala.concurrent.{ExecutionContext, Future}
import scala.util.Failure
import scala.util.Success
import akka.Done
import akka.NotUsed
import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import akka.grpc.GrpcClientSettings
import akka.stream.scaladsl.Source
import com.google.protobuf.timestamp.Timestamp

//#import

//#client-request-reply
object LogAnalyserClient {

  def main(args: Array[String]): Unit = {
    implicit val sys: ActorSystem[_] = ActorSystem(Behaviors.empty, "LogAnalyserClient")
    implicit val ec: ExecutionContext = sys.executionContext

    val client = LogFinderServiceClient(GrpcClientSettings.fromConfig("LogFinderService"))

    val args_list = args.toList
    val timestamp = args_list(0)
    val delta = args_list(1)

    LogFindingReply(timestamp, delta)
    //#client-request-reply

    def LogFindingReply(timestamp: String, delta: String): Unit = {
      println(s"Performing request: $timestamp with delta $delta")
      val reply = client.findLog(FindLogRequest(timestamp, delta))
      reply.onComplete {
        case Success(msg) =>
          println(msg)
        case Failure(e) =>
          println(s"Error: $e")
      }
    }

  }

}
//#client-request-reply
