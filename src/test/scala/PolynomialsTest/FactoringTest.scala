package PolynomialsTest

import Polynomials._
import org.scalatest.FunSuite

/**
  * Unit tests for Factoring worksheet generator
  */
class FactoringTest extends FunSuite {

  val factoringGenerator = Factoring()

  test("Factoring.generateQuestion and generateAnswer with positive parameters") {
    val params = (1,2,3,2)
    assert(factoringGenerator.generateQuestion(params) == "x^2 + 3x + 2")
    assert(factoringGenerator.generateAnswer(params) == "(x + 1)(x + 2)")
  }

  test("Factoring.generateQuestion and generateAnswer with negative parameters") {
    val params = (1,-3,-2,-3)
    assert(factoringGenerator.generateQuestion(params) == "x^2 - 2x - 3")
    assert(factoringGenerator.generateAnswer(params) == "(x + 1)(x - 3)")
  }

  test("Factoring.generateQuestion and generateAnswer with mixed parameters") {
    val params = (-1, 3, 2, -3)
    assert(factoringGenerator.generateQuestion(params) == "x^2 + 2x - 3")
    assert(factoringGenerator.generateAnswer(params) == "(x - 1)(x + 3)")
  }


}