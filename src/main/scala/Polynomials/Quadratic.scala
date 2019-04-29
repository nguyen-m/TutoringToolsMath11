package Polynomials

import Polynomials.Utils._

case class Quadratic() extends WorksheetGenerator {

  // Domain of the quadratic. In the scope of Math 20, the domain is always all Real number
  val domain = "Domain: x ∈ R"

  /**
    * Calculate the vertex of the quadratic from the input parameters
    *
    * @param A Coefficient of the x squared term
    * @param B Coefficient of the x term
    * @param C The constant
    * @return A tuple of 2 Double - The x and y coordinate of the vertex
    */
  def calcVertex(A: Double, B: Double, C: Double): (Double, Double) = {
    val Vx = -B / (2 * A)
    val Vy = -(B * B - 4 * A * C) / (4 * A)
    (Vx, Vy)
  }

  /**
    * Calculate the Discriminant to determine the number of real x-intercepts and
    * use the Discriminant to calculate the real x-intercepts (if they exist)
    *
    * @param A Coefficient of the x squared term
    * @param B Coefficient of the x term
    * @param C The constant
    * @return A tuple of 2 Option[Double] - values of the x-intercepts
    */
  def calcXIntercept(A: Double, B: Double, C: Double): (Option[Double], Option[Double]) = {
    // Calculate the discriminant to determine the number of real x-intercept:
    //    If the discriminant < 0, there is no real x-intercept
    //    If the discriminant = 0, there is 1 real x-intercept
    //    If the discriminant >0, there are 2 real x-intercepts
    val discriminant: Double = B * B - 4 * A * C
    if (discriminant < 0) (None, None)
    else if (discriminant == 0) {
      val x = -B / (2 * A)
      (Some(x), None)
    } else {
      val x1 = (-B + Math.sqrt(discriminant)) / (2 * A)
      val x2 = (-B - Math.sqrt(discriminant)) / (2 * A)
      (Some(x1), Some(x2))
    }
  }

  /**
    * Generate a Quadratic question from given parameters
    *
    * @param A Coefficient of the x squared term
    * @param B Coefficient of the x term
    * @param C The constant
    * @return a string - the question written in the right format
    */
  def generateQuestion(A: Double, B: Double, C: Double): String = {
    s"${A.toInt}x^2 ${writeSign(B)} ${B.toInt.abs}x ${writeSign(C)} ${C.toInt.abs} = 0"
  }

  /**
    * Generate an answer corresponding to the question
    *
    * @param A Coefficient of the x squared term
    * @param B Coefficient of the x term
    * @param C The constant
    * @return A sequence of strings - Includes Vertex, x-intercepts, axis of symmetry, domain and range of the quadratic function
    */
  def generateAnswer(A: Double, B: Double, C: Double): Seq[String] = {
    // Write the vertex in the right format
    val vertex = calcVertex(A, B, C)
    val writeVertex = s"Vertex: (${formatDouble(vertex._1)}, ${formatDouble(vertex._2)})"
    // Specify the number of real x-intercepts and list them if they exist
    val xIntercept = calcXIntercept(A, B, C)
    val writeXIntercept = {
      // calcXIntercept only returns 3 possible combination below
      (xIntercept: @unchecked) match {
        case (None, None) => "No real x-intercept"
        case (Some(x1), None) => s"1 real x-intercept at ${formatDouble(x1)}"
        case (Some(x1), Some(x2)) => s"2 real x-intercepts at ${formatDouble(x1)} and ${formatDouble(x2)}"
      }
    }
    // Determine the range and write to a string
    val range = {
      if (A < 0) s"Range: y ∈ (-∞, ${formatDouble(vertex._2)}]"
      else s"Range: y ∈ [${formatDouble(vertex._2)}, ∞)"
    }
    // Determine the axis of symmetry and write to a string
    val sym = s"Axis of symmetry: y = ${formatDouble(vertex._1)}"
    Seq(writeVertex, writeXIntercept, sym, domain, range)
  }

  /**
    * Get the name/topic of the worksheet
    *
    * @return a string - the topic of the worksheet. In this case, "Quadratic"
    */
  override def getWorksheetType: String = "Quadratic"

  /**
    * Generate a Quadratic question and a corresponding list of answers
    *
    * @return a tuple of a string (question), and a sequence of strings (answers)
    */
  override def generate(): (String, Seq[String]) = {
    val params = generateParams(3).map(x => x.toDouble) // Convert each element of params into Double for accurate calculations
    val A = params.head
    val B = params(1)
    val C = params(2)
    (generateQuestion(A, B, C), generateAnswer(A, B, C))
  }
}