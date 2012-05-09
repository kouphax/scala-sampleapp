package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import play.api.data.validation.Constraints._
import models._

// STEP 2:
object Register extends Controller {
  def registrationForm = Form(
    mapping(
      "username" -> nonEmptyText,
      "password" -> nonEmptyText,
      "confirm" -> nonEmptyText,
      "realName" -> text
    )(Registration.apply)(Registration.unapply)
      verifying("Passwords must match", fields => fields match {
        case Registration(_, password, confirmation, _) => password.equals(confirmation)
      })
  )

  def index = Action {
    Ok(views.html.register(registrationForm.fill(Registration("","","",""))))
  }

  def register = Action { implicit request =>
    registrationForm.bindFromRequest.fold(
      form => BadRequest(views.html.register(form)),
      registration => Redirect(routes.Application.index())
    )
  }
}
