package edu.luc.cs.laufer.cs372.shapes

/**
  * data Shape = Rectangle(w, h) | Location(x, y, Shape)
  */
sealed trait Shape

case class Rectangle(width: Int, height: Int) extends Shape {
  require(width > 0 && height > 0, "invalid width or height in ellipse")
}

case class Location(x: Int, y: Int, shape: Shape) extends Shape {
  require(shape != null, "null shape in location")
}

// TODO add missing case classes (see test fixtures)
// TODO must include validity checking for constructor arguments
case class Ellipse(a: Int, b: Int) extends Shape {
  require(a > 0 && b > 0, "invalid axis in ellipse")
}

case class Group(children: Shape*) extends Shape {
  require(children != null && children.nonEmpty, "null children in group")
}
