package arithmetic

enum ArithmeticExpression{
  case Num(value : Int) extends ArithmeticExpression
  case Minus(value : ArithmeticExpression) extends ArithmeticExpression
  case Plus(value1 : ArithmeticExpression, value2 : ArithmeticExpression) extends ArithmeticExpression
  case Mult(value1 : ArithmeticExpression, value2 : ArithmeticExpression) extends ArithmeticExpression
  case Div(value1 : ArithmeticExpression, value2 : ArithmeticExpression) extends ArithmeticExpression
}


