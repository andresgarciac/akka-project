package com

import cats.data.EitherT
import monix.eval.Task

package object afgc {

  type ServiceError = String
  type ServiceResponse[A] = EitherT[Task, ServiceError, A]

}
