package polish;

import java.security.InvalidParameterException;
import java.util.Scanner;
import java.util.Stack;

public class Polish {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        in.close();

        System.out.println(calculate(str));
    }

    public static int calculate(String input) {
        String operators = "-−+/÷*×";

        Stack<Integer> st = new Stack<Integer>();
        for (String elem : input.split(" ")) {
            if (operators.contains(elem)) {
                int var1 = st.pop();
                int var2 = st.pop();
                st.push(makeOperation(var2, var1, elem.toCharArray()[0]));
            } else if (!elem.matches("^\\D*$")) {
                st.push(Integer.parseInt(elem));
            } else {
                throw new InvalidParameterException("Input was incorrect");
            }
        }

        return st.pop();
    }

    private static int makeOperation(int var1, int var2, char op) {
        switch (op) {
            case '-':
            case '−': {
                return var1 - var2;
            }
            case '+': {
                return var1 + var2;
            }
            case '/':
            case '÷': {
                return var1 / var2;
            }
            case '*':
            case '×':{
                return var1 * var2;
            }
        }
        return 0;
    }
}
