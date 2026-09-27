package org.example;

import java.util.Stack;

public class ReversePolishNotationImpl implements ReversePolishNotation {

    @Override
    public double process(String expression) {
        Stack<Double> pila = new Stack<>();
        String[] elementos = expression.split(" ");
        for (String elemento : elementos) {
            switch (elemento) {
                case "+":
                    pila.push(pila.pop() + pila.pop());
                    break;
                case "-":
                    double sustraendo = pila.pop();
                    double minuendo = pila.pop();
                    pila.push(minuendo - sustraendo);
                    break;
                case "*":
                    pila.push(pila.pop() * pila.pop());
                    break;
                case "/":
                    double divisor = pila.pop();
                    double dividendo = pila.pop();
                    pila.push(dividendo / divisor);
                    break;
                default:
                    pila.push(Double.parseDouble(elemento));
                    break;
            }
        }
        return pila.pop();
    }
}