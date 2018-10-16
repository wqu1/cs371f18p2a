package edu.luc.cs.laufer.cs372.shapes

import edu.luc.cs.laufer.cs372.shapes._
// TODO: implement this behavior

object scale {
  def apply(s: Shape, factor: Double): Double = s match {
    case Rectangle(x, y) => x * y * factor
    case Ellipse(a, b) => math.Pi * a * b * factor
    case Location(x, y, shape) => scale(shape, factor)
    case Group(children@_*) => children.map(scale(_, factor)).sum
  }
}
