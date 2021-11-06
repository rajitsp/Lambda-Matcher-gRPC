package test_loganalyser

import HelperUtils.ObtainConfigReference
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers

class Test extends AnyFlatSpec with Matchers{

  val config = ObtainConfigReference("akka.grpc.client.LogFinderService") match {
    case Some(value) => value
    case None => throw new RuntimeException("Cannot obtain a reference to the config data.")

  }
  it should "Check if the host is given" in {
    val host = config.getString("host")
    val host_len = host.length
    assert(host_len != 0)
  }

  it should "Check if the API Gateway Link is given" in {
    val link = config.getString("AWS_APIGateway_Endpoint")
    assert(link.getClass == classOf[String])
    //assert(link.isInstanceOf[String])

  }

  it should "Check if correct input format of time stamp is being sent" in {
    val tstamp = config.getString("timestamp")
    val len = tstamp.length
    println(len)
    assert(len == 12)
  }


  it should "Check if last two characters of delta are numbers" in {
    val delt = config.getString("delta")
    val l = delt.length
    val lastchar = delt.slice(l-2,l)
    assert(lastchar.isInstanceOf[Int])
  }

  it should "Check if port has value assigned" in {
    val port = config.getInt("port")
    assert(port != 0)
  }
}


