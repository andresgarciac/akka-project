package com.afgc.routing.dtos

case class CreateUserRequest(id: String, name: String, lastName: String, address: String)

case class UserResponse(id: String)