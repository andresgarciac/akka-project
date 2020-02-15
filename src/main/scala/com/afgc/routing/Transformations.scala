package com.afgc.routing

import akka.http.scaladsl.server.Directives
import com.afgc.domain.entities.User
import com.afgc.routing.dtos.UserResponse
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import spray.json._

import scala.collection.mutable.ListBuffer

trait JsonSupport extends SprayJsonSupport with DefaultJsonProtocol {
  implicit val orderFormat = jsonFormat1(UserResponse)
}

trait Transformations  extends Directives with JsonSupport{

  def user2UserResponse: User => UserResponse = {
    user => UserResponse(user.id)
  }

  def users2UsersResponse: ListBuffer[User] => List[UserResponse] = {
    users => users.map(user2UserResponse(_)).toList
  }


}
