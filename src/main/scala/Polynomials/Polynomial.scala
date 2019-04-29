package Polynomials

import java.io.{File, PrintWriter}

import scala.annotation.tailrec
import scala.io.StdIn
import scala.util.Properties

/**
  * A worksheet generator for two major topics in Pure Math 20 that students often struggle with:
  * 1. Factoring polynomials
  * 2. Solving quadratic equations.
  */
object Polynomial extends App {
  // The maximum number of question per worksheet.
  val maxNumQuestion = 100

  /**
    * Get the worksheet type from user: Factoring or Quadratic and make sure
    * the input is valid. And returns the corresponding generator.
    *
    * @return a WorksheetGenerator object
    */
  @tailrec
  def createGenerator(): WorksheetGenerator = {
    val worksheetType = StdIn.readLine("Please specify the type of worksheet (Factoring or Quadratic): ")
    worksheetType match {
      case "Factoring" => Factoring()
      case "Quadratic" => Quadratic()
      case _ => println(s"$worksheetType is not supported. Please specify Factoring or Quadratic")
        createGenerator()
    }
  }

  /**
    * Get the number of question per worksheet from the user and
    * make sure the input is a positive integer between 1 and the maximum number of question
    *
    * @return an integer for the number of questions to be generated
    */
  def extractNumQuestion(): Int = {
    val input = StdIn.readLine(s"Please specify the number of questions in worksheet (1 to $maxNumQuestion): ")
    try {
      val numQuestions = input.toInt
      if (numQuestions >= 1 && numQuestions <= maxNumQuestion) {
        numQuestions
      } else {
        println(s"Invalid input $input.")
        extractNumQuestion()
      }
    } catch {
      case _: Exception => println(s"Unable to convert input $input to Integer. Please enter the number of questions (1 to $maxNumQuestion)")
        extractNumQuestion()
    }
  }

  // Create a worksheet generator based on the user input
  val worksheetGenerator = createGenerator()
  // Create output files for the questions and answers
  val questionFile = new File(s"${worksheetGenerator.getWorksheetType}-Questions.txt")
  val answerFile = new File(s"${worksheetGenerator.getWorksheetType}-Answers.txt")
  val questionWriter = new PrintWriter(questionFile)
  val answerWriter = new PrintWriter(answerFile)

  try {
    // Write headers
    questionWriter.write(s"QUESTIONS:${Properties.lineSeparator}")
    answerWriter.write(s"ANSWERS:${Properties.lineSeparator}")

    // Ask the user for the number of questions and answers to generate
    // Generate and write the questions and answers into their respective files.
    (1 to extractNumQuestion()).foreach { index => {
      val questionAndAnswer = worksheetGenerator.generate()
      questionWriter.write(s"$index. ${questionAndAnswer._1}${Properties.lineSeparator}")
      answerWriter.write(s"$index. ${questionAndAnswer._2.head}${Properties.lineSeparator}")
      questionAndAnswer._2.tail.foreach(a => answerWriter.write(s"   $a${Properties.lineSeparator}"))
    }
    }
    println(s"Question worksheet: ${questionFile.getAbsolutePath}")
    println(s"Answer worksheet: ${answerFile.getAbsolutePath}")
  } catch {
    case e: Throwable => println(s"Unable to generate worksheet for ${worksheetGenerator.getWorksheetType}. ${e.getMessage}")
  } finally {
    questionWriter.close()
    answerWriter.close()
  }
}