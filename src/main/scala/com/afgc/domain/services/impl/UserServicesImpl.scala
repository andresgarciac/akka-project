package com.afgc.domain.services.impl

import cats.data.EitherT
import com.afgc.{ServiceError, ServiceResponse}
import com.afgc.domain.entities.User
import com.afgc.domain.services.UserServices
import monix.eval.Task

import scala.collection.mutable.ListBuffer

class UserServicesImpl extends UserServices[User, ServiceResponse, ListBuffer] {

  var users: ListBuffer[User] = fillUsersList()

  override def createUser(user: User): ServiceResponse[User] = {
    val u = getUser(user).flatMap(x => createLUser(user))
    println(users)
    EitherT.fromOptionF[Task, ServiceError, User](
      Task.now(u),
      "User already created"
    )
  }

  override def getUserById(id: String): ServiceResponse[User] = ???

  override def getUsers(): ServiceResponse[ListBuffer[User]] = {
    EitherT.fromOptionF[Task, ServiceError, ListBuffer[User]](
      Task.now(Option(users)),
      ""
    )
  }

  private def getUser(user: User): Option[User] ={
    users.find(_.id == user.id) match {
      case Some(u) => None
      case None => Some(user)
    }
  }

  private def createLUser(user: User): Option[User] ={
    users += user
    println(users)
    Some(user)
  }

  private def fillUsersList(): ListBuffer[User] = {
    ListBuffer(User(id = "111", name = "andres", lastName = "garcia", address = "fake st 123"),
      User(id = "112", name = "felipe", lastName = "cifuentes", address = "fake st 123")
    )
  }

}
