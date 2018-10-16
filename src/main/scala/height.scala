package edu.luc.cs.laufer.cs372.shapes

import edu.luc.cs.laufer.cs372.shapes._
// TODO: implement this behavior

object height {
  def apply(s: Shape): Int = s match {
    case Rectangle(x, y) => 1
    case Ellipse(a, b) => 1
    case Location(x, y, shape) => height(shape)
    case Group(children@_*) => children.map(height(_) + 1).max
  }
}
