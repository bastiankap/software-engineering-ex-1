import arithmetic.ArithmeticExpression
import arithmetic.ArithmeticExpression.evaluate
import arithmetic.ArithmeticExpression.pretty
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


