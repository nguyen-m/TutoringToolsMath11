package Polynomials

import Polynomials.Utils._

import scala.annotation.tailrec
// import java.io._  But more specifically for efficiency, import above only.

case class Factoring() extends WorksheetGenerator {

  /**
    * Generate parameters for the question and answer.
    * Make sure the sum of parameters A and B is non-zero
    *
    * @return a tuple of 4 Int
    */
  @tailrec
  final def generateFactorParams(): (Int, Int, Int, Int) = {
    val AB = generateParams(2)
    // Making sure that the sum of the parameters are not zero
    if (AB.sum != 0) {
      val b = AB.sum
      val c = AB.product
      (AB.head, AB(1), b, c)
    }
    else {
      generateFactorParams()
    }
  }

  /**
    * Generate a factoring question from given parameters
    *
    * @param params parameters to be used in writing the question
    * @return a string - the question written in the right format
    */
  def generateQuestion(params: (Int, Int, Int, Int)): String = {
    s"x^2 ${writeSign(params._3)} ${params._3.abs}x ${writeSign(params._4)} ${params._4.abs}"
  }

  /**
    * Generate an answer corresponding to the factoring question
    *
    * @param params parameters to be used in writing the answer
    * @return a string - the answer written in the right format
    */
  def generateAnswer(params: (Int, Int, Int, Int)): String = {
    s"(x ${writeSign(params._1)} ${params._1.abs})(x ${writeSign(params._2)} ${params._2.abs})"
  }

  /**
    * Get the name/topic of the worksheet
    *
    * @return a string - the topic of the worksheet. In this case, "Factoring"
    */
  override def getWorksheetType: String = "Factoring"

  /**
    * Generate a factoring polynomial question and a corresponding answer
    *
    * @return a tuple of a string (question), and a sequence of strings (answer)
    */
  override def generate(): (String, Seq[String]) = {
    val params = generateFactorParams()
    (generateQuestion(params), Seq(generateAnswer(params)))
  }
}
