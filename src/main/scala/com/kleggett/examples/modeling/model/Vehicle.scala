package com.kleggett.examples.modeling.model

import com.kleggett.persistence.Persistable

import scala.util.Random

/**
 * Example models for CASE domain modeling presentation.
 *
 * @author K. Leggett
 * @since 1.0 (6/7/15 4:55 PM)
 */
sealed trait Vehicle
{
  def vin: String

  def make: String

  def model: String
}

object Vehicle
{
  def newVIN() = Random.nextString(17)
}

trait DBVehicle extends Vehicle with Persistable[String]
{
  override def id: Option[String] = Option(vin)
}

case class Car(vin: String, make: String, model: String, nDoors: Int)
  extends DBVehicle

case class Truck(vin: String, make: String, model: String, weight: Int, nWheels: Int)
  extends DBVehicle
