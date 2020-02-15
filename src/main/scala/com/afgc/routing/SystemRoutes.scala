package com.afgc.routing

import java.time.ZonedDateTime

import akka.http.javadsl.model.headers.HttpOriginRange
import akka.http.scaladsl.model.{ContentTypes, HttpEntity}
import akka.http.scaladsl.model.headers.HttpOrigin
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import ch.megard.akka.http.cors.scaladsl.settings.CorsSettings
import ch.megard.akka.http.cors.scaladsl.CorsDirectives.cors


trait SystemRoutes extends UserRoutes {

  protected def now = ZonedDateTime.now

  def routes: Route =
    cors(CorsSettings.defaultSettings.withAllowedOrigins(HttpOriginRange.create(HttpOrigin("http://localhost:3000")))) {
      extractRequest { req =>
        healthRoute ~ createUser ~ getUsers
      }
    }

  def healthRoute: Route = path("health") {
    get {
      complete(HttpEntity(ContentTypes.`application/json`, HealthResponse(now).toString()))
    }
  }
}

case class HealthResponse(time: ZonedDateTime)
