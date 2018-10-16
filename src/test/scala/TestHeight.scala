package edu.luc.cs.laufer.cs372.shapes

import org.scalatest.FunSuite

import TestFixtures._

class TestHeight extends FunSuite {

  def testHeight(description: String, s: Shape, predictedHeight: Int) = {
    test(description) {
      val countHeight = height(s)
      assert(predictedHeight === countHeight)
    }
  }

  // TODO comment these tests back in

  testHeight("simple ellipse", simpleEllipse, 1)
  testHeight("simple rectangle", simpleRectangle, 1)
  testHeight("simple location", simpleLocation, 1)
  testHeight("basic group", basicGroup, 2)
  testHeight("simple group", simpleGroup, 2)
  testHeight("complex group", complexGroup, 3)
}
