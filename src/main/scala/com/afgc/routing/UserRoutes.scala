package com.afgc.routing

import java.util.UUID

import akka.http.scaladsl.model.{ContentTypes, HttpEntity, StatusCodes}
import akka.http.scaladsl.model.StatusCodes.{Created, InternalServerError}
import akka.http.scaladsl.server.Directives.{as, entity, get, path, post}
import akka.http.scaladsl.server.Route
import com.afgc.ServiceResponse
import com.afgc.domain.entities.User
import com.afgc.domain.services.UserServices
import com.afgc.routing.dtos.CreateUserRequest
import akka.http.scaladsl.server.Directives.{complete, onComplete}
import monix.execution.Scheduler
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport._


import scala.collection.mutable.ListBuffer
import scala.util.{Failure, Success}
import spray.json.DefaultJsonProtocol._


trait UserRoutes extends Transformations {

  def userServices: UserServices[User, ServiceResponse, ListBuffer]
  implicit val createUserFormat = jsonFormat4(CreateUserRequest)
  implicit def sc: Scheduler


  def createPackage: Route = path("user") {
    post {
      entity(as[CreateUserRequest]) { p =>
          val u = userServices.createUser(User(p.id, p.name, p.lastName, p.address))
        onComplete (u.fold(
            err => complete(err),
              us => complete(user2UserResponse(us))
          ).runAsync
        ){
            case Success(route) => route
            case Failure(exception) =>
              complete(InternalServerError)
          }
      }
      }
    }

}
