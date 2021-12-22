package controllers

import play.api.mvc._
import services.adminService.AdminService
import com.google.inject.{Inject, Singleton}


import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.concurrent.duration._
import play.api.libs.concurrent.Futures._

@Singleton
class HomeController @Inject()(val controllerComponents: ControllerComponents, adminService: AdminService) extends BaseController {

  def index(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    Ok("SUCCESS")
  }


  def test(): Action[AnyContent] = Action.async { implicit request: Request[AnyContent] =>
    adminService.addHospital().map(x => Ok(x))
  }


}



