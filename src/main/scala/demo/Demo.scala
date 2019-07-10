package demo

import wvlet.airframe.launcher.{Launcher, command, option}
import wvlet.log.{LogLevel, LogSupport, Logger}

object Demo {
  def main(args: Array[String]): Unit = {
    Logger.init

    Launcher.of[Demo].execute(args)
  }
}

class Demo(
    @option(prefix = "-h,--help", description = "show help messages", isHelp = true)
    displayHelp: Boolean
) extends LogSupport {

  @command(isDefault = true)
  def defaultCommand: Unit = {
    info("Type --help to show the list of sub commands")
  }

  @command(description = "launch a demo web server")
  def server(@option(prefix = "-p", description = "set the server port number") port: Int = 8080): Unit = {
    info("Launch a demo web server")
    DemoApp.runServer(port)
  }
}
