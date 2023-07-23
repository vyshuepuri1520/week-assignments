import java.util.Scanner;

public class question8 {

    public static boolean isBalanced(String s) {
        char[] stack = new char[s.length()];
        int top = -1;

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack[++top] = c;
            } else {
                if (top == -1) {
                    return false;
                }

                char topChar = stack[top--];
                if ((c == ')' && topChar != '(') || (c == ']' && topChar != '[') || (c == '}' && topChar != '{')) {
                    return false;
                }
            }
        }

        return top == -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            boolean isBalanced = isBalanced(input);
            System.out.println(isBalanced);
        }

        scanner.close();
    }
}


