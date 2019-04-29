package Polynomials

/**
  * Common methods that every worksheet generator has to provide implementation for
  */
trait WorksheetGenerator {
  /**
    * Generate question and answers
    *
    * @return a tuple of a string (question), and a sequence of strings (answer)
    */
  def generate(): (String, Seq[String])

  /**
    * Get the name/topic of the worksheet
    *
    * @return a string - the topic of the worksheet
    */
  def getWorksheetType: String

}
