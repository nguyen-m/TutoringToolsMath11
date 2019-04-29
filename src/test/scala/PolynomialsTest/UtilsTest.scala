package PolynomialsTest

import Polynomials.Utils
import org.scalatest.FunSuite

/**
  * Unit tests for common utilities
  */
class UtilsTest extends FunSuite {
  test("Utils.getSign with positive and negative Double"){
    assert(Utils.writeSign(7.7) == "+")
    assert(Utils.writeSign(-7.7) == "-")
  }

  test("Utils.formatDouble with Double"){
    assert(Utils.formatDouble(1.0/3.0) == "0.33" )
  }

  test("Utils.formatDouble with Int"){
    assert(Utils.formatDouble(7) == "7.00" )
  }
}
