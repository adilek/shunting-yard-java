package az.adil.science.math;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author Adil Aliyev <adilaliev[at]gmail.com>
 */
public class ShuntingYard {

    public double evaluate(String expression) {
        return evaluatePostfix(infixToPostfix(expression));
    }

    public double evaluatePostfix(List<String> postfix) {

        Stack<Double> operands = new Stack<>();
        Double o1, o2;
        for (String s : postfix) {
            if (isInteger(s)) {
                operands.add(Double.parseDouble(s));
            } else {
                o2 = operands.pop();
                o1 = operands.pop();
                operands.push(calculate(o1, o2, s.charAt(0)));
            }
        }

        return operands.pop();
    }

    /**
     *
     * @param o1 operand1
     * @param o2 operand2
     * @param op operator (+,-,*,/,^
     * @return
     */
    protected double calculate(double o1, double o2, char op) {
        switch (op) {
            case '+':
                return o1 + o2;
            case '-':
                return o1 - o2;
            case '*':
                return o1 * o2;
            case '/':
                return o1 / o2;
            case '^':
                return Math.pow(o1, o2);
        }
        return 0;
    }

    /**
     * Converts infix expression to postfix expression (RPN)
     *
     * @param expression infix expression
     * @return
     */
    public List<String> infixToPostfix(String expression) {

        List<String> output = new ArrayList<>();
        Stack<Character> operators = new Stack<>();
        StringBuilder currentNumber = new StringBuilder();

        char lastDigit;

        for (int i = 0; i < expression.length(); i++) {
            char currentCharacter = expression.charAt(i);
            if (currentCharacter >= '0' && currentCharacter <= '9') {
                lastDigit = currentCharacter;
                currentNumber.append(lastDigit);
            } else {
                if (currentNumber.length() > 0) {
                    output.add(currentNumber.toString());
                    currentNumber = new StringBuilder();
                }
                if (currentCharacter == '+' || currentCharacter == '-' || currentCharacter == '*' || currentCharacter == '/' || currentCharacter == '^') {
                    while (!operators.empty() && operatorPriority(currentCharacter) <= operatorPriority(operators.lastElement())) {
                        output.add(operators.pop().toString());
                    }
                    operators.add(currentCharacter);

                } else if (currentCharacter == '(') {
                    operators.add(currentCharacter);

                } else if (currentCharacter == ')') {
                    while (!operators.empty() && operators.lastElement() != '(') {
                        output.add(operators.pop().toString());
                    }
                    operators.pop();
                }
            }

        }

        if (currentNumber.length() > 0) {
            output.add(currentNumber.toString());
        }

        while (!operators.empty()) {
            output.add(operators.pop().toString());
        }

        return output;
    }

    /**
     * Operator priority
     *
     * @param operator (+,-,*,/,^)
     * @return
     */
    public short operatorPriority(char operator) {
        short p;
        switch (operator) {
            case '+':
                p = 1;
                break;
            case '-':
                p = 1;
                break;
            case '*':
                p = 2;
                break;
            case '/':
                p = 2;
                break;
            case '^':
                p = 3;
                break;
            default:
                p = 0;
                break;
        }
        return p;
    }

    protected boolean isInteger(String number) {
        for (int i = 0; i < number.length(); i++) {
            if (!(number.charAt(i) >= '0' && number.charAt(i) <= '9')) {
                return false;
            }
        }
        return true;
    }

}
