package com.afgc.routing

import akka.http.scaladsl.server.Directives
import com.afgc.domain.entities.User
import com.afgc.routing.dtos.UserResponse
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import spray.json._

trait JsonSupport extends SprayJsonSupport with DefaultJsonProtocol {
  implicit val orderFormat = jsonFormat1(UserResponse) // contains List[Item]
}

trait Transformations  extends Directives with JsonSupport{

  def user2UserResponse: User => UserResponse = {
    user => UserResponse(user.id)
  }


}
