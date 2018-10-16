package edu.luc.cs.laufer.cs372.shapes

// TODO: implement this behavior

object boundingBox {
  def apply(s: Shape): Location = s match {
    case Rectangle(x, y) => Location(0, 0, Rectangle(x, y))
    case Ellipse(a, b) => Location(-a, -b, Rectangle(a * 2, b * 2))
    case Location(x, y, shape) => {
      val bound = boundingBox(shape)
      Location(x + bound.x, y + bound.y, bound.shape)
    }
    case Group(children@_*) => {
      val childrenRect = children
        // get children bounding
        .map(boundingBox(_))
        // map to (Array(x, width), Array(y, height))
        .map(item => {
        val rect = item.shape.asInstanceOf[Rectangle]
        (Array(item.x, rect.width), Array(item.y, rect.height))
      })
        // get (minLeft, minTop, maxRight, maxBottom)
        .foldLeft((Int.MaxValue, Int.MaxValue, Int.MinValue, Int.MinValue))((result, item) =>
        (
          result._1.min(item._1(0)), // minLeft
          result._2.min(item._2(0)), // minTop
          result._3.max(item._1.sum), // maxRight
          result._4.max(item._2.sum), // maxBottom
        )
      )
      // get width and height
      val width = childrenRect._3 - childrenRect._1
      val height = childrenRect._4 - childrenRect._2
      // return location
      Location(childrenRect._1, childrenRect._2, Rectangle(width, height))
    }
  }
}
