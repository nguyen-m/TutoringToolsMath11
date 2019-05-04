package PolynomialsTest

import Polynomials.Quadratic
import Polynomials.Utils._
import org.scalatest.FunSuite

/**
  * Unit tests for Quadratic worksheet generator
  */
class QuadraticTest extends FunSuite {
  val quadraticGenerator = Quadratic()

  test("Quadratic.calcVertex with various parameters") {
    // All positive parameters
    val positiveParamsResult = quadraticGenerator.calcVertex(2.0, 5.0, 8.0)
    assert((formatDouble(positiveParamsResult._1), formatDouble(positiveParamsResult._2)) == ("-1.25", "4.88"))
    // All negative parameters
    val negativeParamsResult = quadraticGenerator.calcVertex(-2.0, -5.0, -8.0)
    assert((formatDouble(negativeParamsResult._1), formatDouble(negativeParamsResult._2)) == ("-1.25", "-4.88"))
    // Mixed of positive and negative parameters
    val mixedParamsResult = quadraticGenerator.calcVertex(-2.0, 5.0, 8.0)
    assert((formatDouble(mixedParamsResult._1), formatDouble(mixedParamsResult._2)) == ("1.25", "11.13"))
  }

  test("Quadratic.calcRoots with various parameters") {
    // No real root, 2 complex roots
    assert(quadraticGenerator.calcRoots(2.0, 2.0, 5.0) == (0, Some(-0.5), Some(1.5)))
    // 1 real root
    assert(quadraticGenerator.calcRoots(-2.0, 4.0, -2.0) == (1, Some(1.0), None))
    // 2 real roots
    assert(quadraticGenerator.calcRoots(1.0, 1.0, -6.0) == (2, Some(2.0), Some(-3.0)))
  }

  test("Quadratic.generateQuestion and generateAnswer") {
    // No real x-intercept
    val A0 = 2.0
    val B0 = 2.0
    val C0 = 5.0
    assert(quadraticGenerator.generateQuestion(A0, B0, C0) == "2x^2 + 2x + 5 = 0")
    assert(quadraticGenerator.generateAnswer(A0, B0, C0) == Seq("Vertex: (-0.50, 4.50)",
      "No real root. 2 complex roots at -0.50 +/- 1.50i",
      "Axis of symmetry: y = -0.50",
      "Domain: x ∈ R",
      "Range: y ∈ [4.50, ∞)"))

    // 1 real x-intercept
    val A1 = 4.0
    val B1 = -8.0
    val C1 = 4.0
    assert(quadraticGenerator.generateQuestion(A1, B1, C1) == "4x^2 - 8x + 4 = 0")
    assert(quadraticGenerator.generateAnswer(A1, B1, C1) == Seq("Vertex: (1.00, -0.00)",
      "1 real root at 1.00",
      "Axis of symmetry: y = 1.00",
      "Domain: x ∈ R",
      "Range: y ∈ [-0.00, ∞)"))

    // 2 real x-intercepts
    val A2 = -2.0
    val B2 = 5.0
    val C2 = 8.0
    assert(quadraticGenerator.generateQuestion(A2, B2, C2) == "-2x^2 + 5x + 8 = 0")
    assert(quadraticGenerator.generateAnswer(A2, B2, C2) == Seq("Vertex: (1.25, 11.13)",
      "2 real roots at -1.11 and 3.61",
      "Axis of symmetry: y = 1.25",
      "Domain: x ∈ R",
      "Range: y ∈ (-∞, 11.13]"))
  }
}