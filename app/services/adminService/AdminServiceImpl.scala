package services.adminService

import com.google.inject.Singleton
import dbInterfaces.{DBConnect, Hospital, HospitalTable}
import slick.jdbc.PostgresProfile.api._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.language.implicitConversions

@Singleton
class AdminServiceImpl extends AdminService {

  val hospitalQuery = HospitalTable.query;
  val db = DBConnect.db

  def addHospitalDBIO(): DBIO[String] =
    (hospitalQuery += Hospital(-1L, "qw", "qw", "Qw")).map {
      i: Int => "Success" + i;
    }


  override def addHospital(): Future[String] =
    DBConnect.exec(addHospitalDBIO())

}

