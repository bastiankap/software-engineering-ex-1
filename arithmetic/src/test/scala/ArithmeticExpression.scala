import arithmetic.ArithmeticExpression
import arithmetic.ArithmeticExpression.{evaluate, pretty, showResults}
import org.scalatest.funsuite.AnyFunSuite

class ArithmeticExpressionTestEvaluate extends AnyFunSuite:
  test("ArithmeticExpression.evaluate"){
    val val1 = ArithmeticExpression.Num(3)
    assert(evaluate(val1) == 3.0)
    val val2 = ArithmeticExpression.Num(4)
    assert(evaluate(ArithmeticExpression.Pow(val1,val2)) == 81)
  }

class ArithmeticExpressionTestPretty extends AnyFunSuite:
  test("ArithmeticExpression.pretty"){
    val val1 = ArithmeticExpression.Num(3)
    assert(pretty(val1) == "3")
    val val2 = ArithmeticExpression.Num(4)
    assert(pretty(ArithmeticExpression.Pow(val1, val2)) == "3^4")
  }

class ArithmeticExpressionTestEvaluateList extends AnyFunSuite:
  test("ArithmeticExpression.evaluateList"){
    val val1 = ArithmeticExpression.Num(3)
    val val2 = ArithmeticExpression.Num(4)
    val val3 = ArithmeticExpression.Mult(val1, val2)
    val valList: List[ArithmeticExpression] = List(val1, val2, val3)

    assert(evaluate(valList) == List(3.0, 4.0, 12.0))
  }

class ArithmeticExpressionTestShowResults extends AnyFunSuite:
  test("ArithmeticExpression.showResults"){
    val val1 = ArithmeticExpression.Num(1)
    val val2 = ArithmeticExpression.Num(2)


    val sum1 = ArithmeticExpression.Plus(val1, val2)
    val mult1 = ArithmeticExpression.Mult(val1, val2)
    val div1 = ArithmeticExpression.Div(val1, val2)

    val testList: List[ArithmeticExpression] = List(sum1, div1, mult1)

    assert(showResults(testList) == "1.0 + 2.0 = 3.0\n1.0 / 2.0 = 0.5\n1.0 * 2.0 = 2.0")
  }


