package arithmetic

import arithmetic.ArithmeticExpression.{evaluate, pretty}

import scala.collection.mutable.ListBuffer

enum ArithmeticExpression{
  case Num(value : Int) extends ArithmeticExpression
  case Minus(value : ArithmeticExpression) extends ArithmeticExpression
  case Plus(value1 : ArithmeticExpression, value2 : ArithmeticExpression) extends ArithmeticExpression
  case Mult(value1 : ArithmeticExpression, value2 : ArithmeticExpression) extends ArithmeticExpression
  case Div(value1 : ArithmeticExpression, value2 : ArithmeticExpression) extends ArithmeticExpression
  case Pow(value1 : ArithmeticExpression, value2 : ArithmeticExpression) extends ArithmeticExpression
}

object ArithmeticExpression{

  def evaluate(expression: ArithmeticExpression): Double = expression match
    case Num(value) => value
    case Minus(value) => - evaluate(value)
    case Plus(value1,value2) => evaluate(value1) + evaluate(value2)
    case Mult(value1,value2) => evaluate(value1) * evaluate(value2)
    case Div(value1, value2) => evaluate(value1) / evaluate(value2)
    case Pow(value1, value2) if evaluate(value2) > 0 => evaluate(value1).toInt * evaluate(Pow(value1, Num(evaluate(value2).toInt - 1)))
    case Pow(value1, value2) if evaluate(value2) < 0 => 1/evaluate(value1).toInt * evaluate(Pow(value1, Num(evaluate(value2).toInt + 1)))
    case Pow(value1, value2) if evaluate(value2) == 0 => 1

  def evaluate(expressions: List[ArithmeticExpression]): List[Double] =
    expressions.map(evaluate(_))

  def showResults(expressions: List[ArithmeticExpression]): String =

    val tupList = ListBuffer[(String,String)]()
    for (expression <- expressions)
      val tup = (pretty(expression), evaluate(expression).toString)
      tupList += tup

    val resultString: String = tupList.map { case (str1, str2) => s"$str1 = $str2" }.mkString("\n")


    return resultString


  def pretty(expression: ArithmeticExpression): String = expression match
    case Num(value) => s"${value}"
    case Minus(value) => s"- ${evaluate(value)}"
    case Plus(value1, value2) => s"${evaluate(value1)} + ${evaluate(value2)}"
    case Mult(value1, value2) => s"${evaluate(value1)} * ${evaluate(value2)}"
    case Div(value1, value2) => s"${evaluate(value1)} / ${evaluate(value2)}"
    case Pow(value1, value2) => s"${evaluate(value1).toInt}^${evaluate(value2).toInt}"

}
@main def Main() = println()