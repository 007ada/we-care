package dbInterfaces

import slick.jdbc.PostgresProfile.api._
import scala.concurrent.Future

object DBConnect {
  val db = Database.forConfig("mydb")

  def exec[T](action: DBIO[T]): Future[T] = {
    db.run(action)
  }

}

