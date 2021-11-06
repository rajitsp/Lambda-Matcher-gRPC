
// Generated by Akka gRPC. DO NOT EDIT.
package LogAnalyser

import scala.concurrent.ExecutionContext

import akka.actor.ClassicActorSystemProvider

import akka.grpc.GrpcClientSettings

import akka.grpc.scaladsl.AkkaGrpcClient

import akka.grpc.internal.NettyClientUtils
import akka.grpc.internal.ClientState

import akka.grpc.scaladsl.SingleResponseRequestBuilder
import akka.grpc.internal.ScalaUnaryRequestBuilder

// Not sealed so users can extend to write their stubs
trait LogFinderServiceClient extends LogFinderService with LogFinderServiceClientPowerApi with AkkaGrpcClient

object LogFinderServiceClient {
  def apply(settings: GrpcClientSettings)(implicit sys: ClassicActorSystemProvider): LogFinderServiceClient =
    new DefaultLogFinderServiceClient(settings)
}

final class DefaultLogFinderServiceClient(settings: GrpcClientSettings)(implicit sys: ClassicActorSystemProvider) extends LogFinderServiceClient {
  import LogFinderService.MethodDescriptors._

  private implicit val ex: ExecutionContext = sys.classicSystem.dispatcher
  private val options = NettyClientUtils.callOptions(settings)
  private val clientState = new ClientState(settings, akka.event.Logging(sys.classicSystem, classOf[DefaultLogFinderServiceClient]))

  
  private def findLogRequestBuilder(channel: akka.grpc.internal.InternalChannel) =
  
    new ScalaUnaryRequestBuilder(findLogDescriptor, channel, options, settings)
  
  

  
  /**
   * Lower level "lifted" version of the method, giving access to request metadata etc.
   * prefer findLog(LogAnalyser.FindLogRequest) if possible.
   */
  
  override def findLog(): SingleResponseRequestBuilder[LogAnalyser.FindLogRequest, LogAnalyser.FindLogReply] =
    findLogRequestBuilder(clientState.internalChannel)
  

  /**
   * For access to method metadata use the parameterless version of findLog
   */
  def findLog(in: LogAnalyser.FindLogRequest): scala.concurrent.Future[LogAnalyser.FindLogReply] =
    findLog().invoke(in)
  

  override def close(): scala.concurrent.Future[akka.Done] = clientState.close()
  override def closed: scala.concurrent.Future[akka.Done] = clientState.closed()

}

object DefaultLogFinderServiceClient {

  def apply(settings: GrpcClientSettings)(implicit sys: ClassicActorSystemProvider): LogFinderServiceClient =
    new DefaultLogFinderServiceClient(settings)
}

trait LogFinderServiceClientPowerApi {
  
  /**
   * Lower level "lifted" version of the method, giving access to request metadata etc.
   * prefer findLog(LogAnalyser.FindLogRequest) if possible.
   */
  
  def findLog(): SingleResponseRequestBuilder[LogAnalyser.FindLogRequest, LogAnalyser.FindLogReply] = ???
  
  

}