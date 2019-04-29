package Polynomials

import scala.annotation.tailrec
import scala.util.Random

object Utils {
  // Maximum and minimum values of the parameters
  val paramMin: Int = -10
  val paramMax: Int = 10

  /**
    * Extract and write the sign of an input number into a string
    *
    * @param x input number
    * @return the sign of the input
    */
  def writeSign(x: Double): String = if (x > 0) "+" else "-"

  /**
    * Format numbers of type Double to 3 decimal places
    *
    * @param x input Double
    * @return a string of the formatted input
    */
  def formatDouble(x: Double): String = f"$x%.2f"

  /**
    * Generate a sequence of non-zero, random parameters
    *
    * @param numParams Amount of parameters to be generated
    * @return a Sequence of randomly generated integers
    */
  def generateParams(numParams: Int): Seq[Int] = {
    /* Since version 2.12.8 Scala.util.Random.nextInt() only allows user to input the upper bound,
     * and the lower bound (default) is 0, the following process must be used to generate
     * a random integer between min and max:
     *   1. Calculate the range between min and max.
     *   2. Add 1 to the range due to Random.nextInt(max) generates Int from 0(inclusive) to max(EXCLUSIVE)
     *   3. Generate a random integer from 0 to the new range value
     *   4. Shift the integer by the min value, effectively making it between min and max (inclusive)
     */
    val range = paramMax - paramMin + 1

    /**
      * Randomly generate a non-zero parameter within the range
      *
      * @return a non-zero integer
      */
    @tailrec
    def generateNonZeroParam(): Int = {
      val r = Random.nextInt(range) + paramMin
      if (r != 0) r
      else generateNonZeroParam()
    }
    // Create a sequence of non-zero parameters of type Int.
    (0 until numParams).map(_ => generateNonZeroParam())
  }
}