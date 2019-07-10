package demo

import wvlet.airframe.http.finagle.FinagleServer
import wvlet.airframe.http.{Endpoint, HttpMethod, Router}
import wvlet.airframe._
import wvlet.log.LogSupport

case class ServerInfo(name: String, version: String = "0.1")


case class DataRequest(name:String)
case class DataRequestResponse(name:String, data:String)
/**
  *
  */
trait DemoApp extends LogSupport {
  @Endpoint(method = HttpMethod.GET, path = "/v1/info", description = "return the server version")
  def serverInfo: ServerInfo = {
    ServerInfo(name = "demo-app")
  }

  @Endpoint(method = HttpMethod.POST, path = "/v1/hello")
  def hello(data:Int): Int = {
    data
  }

  @Endpoint(method = HttpMethod.POST, path = "/v1/data")
  def getData(dataRequest:DataRequest): DataRequestResponse = {
    DataRequestResponse(dataRequest.name, "xxxxxxx")
  }

  private val session = bind[Session]

  @Endpoint(method = HttpMethod.GET, path = "/admin/shutdown")
  def shutdown: Unit = {
    warn(s"Shutting down the server")
    session.shutdown
  }
}

object DemoApp {

  def runServer(port:Int) {
    val router = Router.add[DemoApp]
    val design = wvlet.airframe.http.finagle.newFinagleServerDesign(router, port = port)
    design.build[FinagleServer] { server =>
      server.waitServerTermination
    }
  }
}
