package com.afgc.domain.services

trait UserServices [UserT, T[_], S[E] <: Seq[E]] {

  def createUser(user: UserT): T[UserT]
  def getUserById(id: String): T[UserT]
  def getUsers(): T[S[UserT]]
}
