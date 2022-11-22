import mill._
import $ivy.`com.lihaoyi::mill-contrib-playlib:`,  mill.playlib._

object testing extends PlayModule with SingleModule {

  def scalaVersion = "3.2.1"
  def playVersion = "2.8.18"
  def twirlVersion = "1.5.1"

  object test extends PlayTests
}
