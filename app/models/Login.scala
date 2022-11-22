package models
import scalikejdbc._
import slick._
import play.api.data.Form
import play.api.data.Forms._
import slick.jdbc.JdbcProfile

import javax.inject.Inject
import play.api.db.Database
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global


case class User(Userid:Int, LastName: String,FirstName: String, Address: String, City:String)
case class UserForm(LastName: String,Firstname: String, Address: String, City:String)

object UserForm{

    val form = Form(
    mapping(
        "LastName" -> text,
        "FirstName" -> text,
        "Address" -> text,
        "City" -> text,
    )(UserForm.apply)(UserForm.unapply)
)

}
import slick.jdbc.MySQLProfile.api._

class UserTableDef(tag:Tag) extends Table[User](tag,"user"){
    def Userid = column[Long]("Userid", O.PrimaryKey,O.AutoInc)
    def LastName = column[String]("LastName")
    def FirstName = column[String]("FirstName")
    def Address = column[String]("Address")
    def City = column[String]("City")
}

class Users @Inject() (db: Database, databaseExecutionContext: DatabaseExecutionContext) {
    val users = TableQuery[UserTableDef]
    def updateSomething(user:User): Unit = {
        Future {
        db.withConnection { conn =>
            (users += user).map(res => "User successfully added")
            }
        }
    }
}