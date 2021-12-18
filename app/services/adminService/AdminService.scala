package services.adminService
import com.google.inject.ImplementedBy
import dbInterfaces.{Hospital, HospitalTable}
import slick.jdbc.PostgresProfile.api._

import scala.concurrent.Future


@ImplementedBy(classOf[AdminServiceImpl])
trait AdminService {
  def addHospital(): Future[String]
}


