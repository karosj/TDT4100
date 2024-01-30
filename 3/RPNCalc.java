import java.util.Stack;

public class RPNCalc {
    private Stack<Double> stack;

    public RPNCalc() {
        stack = new Stack<>();
    }

    public void push(double value) {
        stack.push(value);
    }

    public double pop() {
        if (!stack.isEmpty()) {
            return stack.pop();
        }
        return Double.NaN;
    }

    public double peek(int position) {
        int index = stack.size() - position - 1;
        if (index >= 0 && index < stack.size()) {
            return stack.get(index);
        }
        return Double.NaN;
    }

    public int getSize() {
        return stack.size();
    }

    public void performOperation(char operator) {
        if (stack.size() < 2) {
            throw new IllegalArgumentException("Stack must contain at least two elements");
        }
        double a = stack.pop();
        double b = stack.pop();
        switch (operator) {
            case '+':
                stack.push(a + b);
                break;
            case '-':
                stack.push(b - a);
                break;
            case '*':
                stack.push(a * b);
                break;
            case '/':
                stack.push(b / a);
                break;
            default:
                throw new IllegalArgumentException("Operator must be one of +, -, * or /");
        }
    }

}
