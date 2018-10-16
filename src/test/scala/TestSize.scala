package edu.luc.cs.laufer.cs372.shapes

import org.scalatest.FunSuite

import TestFixtures._

class TestSize extends FunSuite {

  def testSize(description: String, s: Shape, predictedSize: Int) = {
    test(description) {
      val countSize = size(s)
      assert(predictedSize === countSize)
    }
  }

  // TODO comment these tests back in

  testSize("simple ellipse", simpleEllipse, 1)
  testSize("simple rectangle", simpleRectangle, 1)
  testSize("simple location", simpleLocation, 1)
  testSize("basic group", basicGroup, 2)
  testSize("simple group", simpleGroup, 2)
  testSize("complex group", complexGroup, 5)
}
