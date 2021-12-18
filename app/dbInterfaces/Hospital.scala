package dbInterfaces
import slick.jdbc.PostgresProfile.api._

case class Hospital(id: Long,
                    name:  String,
                    email: String,
                    address: String
                    )

class HospitalTable(tag: Tag) extends Table[Hospital](tag, "hospital") {
  def id      = column[Long]("id", O.PrimaryKey, O.AutoInc)
  def name  = column[String]("name")
  def email = column[String]("email")
  def address = column[String]("address")

  def * = (id, name, email,address).<>((Hospital.apply _).tupled, Hospital.unapply)
}

object HospitalTable {
  lazy val query = TableQuery[HospitalTable]
}

