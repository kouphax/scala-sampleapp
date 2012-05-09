package models

import com.mongodb.casbah.Imports._
import com.mongodb.casbah.commons.ValidBSONType.BasicDBList
import com.novus.salat._
import com.novus.salat.global._
import com.mongodb.casbah.Imports._
import com.novus.salat.annotations._

case class Registration(username: String, password: String, confirm: String, realName: String)

object Registrations {
  val registrations = MongoConnection()("sampleapp")("registrations")

  def all = registrations.map(grater[Registration].asObject(_)).toList
  def create(registration: Registration) {
    registrations += grater[Registration].asDBObject(registration)
  }
}