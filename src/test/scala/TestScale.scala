package edu.luc.cs.laufer.cs372.shapes

import org.scalatest.FunSuite

import TestFixtures._

class TestScale extends FunSuite {

  def testScale(description: String, s: Shape, factor: Double, predictedDimensions: Double) = {
    test(description) {
      val countDimensions = scale(s, factor)
      assert(predictedDimensions === countDimensions)
    }
  }

  // TODO comment these tests back in

  testScale("simple ellipse", simpleEllipse, 0.5, 750 * math.Pi)
  testScale("simple rectangle", simpleRectangle, 0.5, 4800)
  testScale("simple location", simpleLocation, 0.5, 4800)
  testScale("basic group", basicGroup, 0.5, 750 * math.Pi + 400)
  testScale("simple group", simpleGroup, 0.5, 750 * math.Pi + 2500)
  testScale("complex group", complexGroup, 0.5, 400 * math.Pi + 750 + 9000 + 750 * math.Pi + 10000)
}
