package org.example.calculator.tobe;

import org.example.calculator.domain.EnumArithmeticOperator;
import org.example.calculator.domain.PositiveNumber;

public class SubtractionOperator implements EnumArithmeticOperator {
    @Override
    public boolean supports(String operator) {
        return operator.equals("-");
    }

    @Override
    public int calculate(PositiveNumber operand1, PositiveNumber operand2) {
        return operand1.toInt() - operand2.toInt();
    }
}
