import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void WelcomeScreen()
    {
        System.out.println("******************************************");
        System.out.println("WELCOME TO GROUP 7's FIRST PROJECT FOR OOP");
        System.out.println("Our group members are as follows:");
        System.out.println("1) Canan Albarazi");
        System.out.println("2) Emir Furkan Gökdemir");
        System.out.println("3) Nur Kambasar");
        System.out.println("4) Kaan Yılmaz");
        System.out.println("******************************************\n");
    }

    public static void PrintMainMenu()
    {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~ MAIN MENU ~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("[A] Primary School\n" +
                "[B] Secondary School\n" +
                "[C] High School\n" +
                "[D] University\n" +
                "[E] Terminate");
        System.out.print("Please select a letter corresponding with your submenu choice: ");
    }

    public static boolean ValidSubmenu(char c)
    {
        if (c == 'a' || c == 'b' || c == 'c' || c == 'd' || c == 'e')
            return true;
        return false;
    }

    // Supposedly clears console on cmd
    public static void clearScreen()
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // Displays Submenu B
    public static void PrintSubmenuB() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~ SUBMENU B ~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("[1] Prime Numbers");
        System.out.println("[2] Step-by-step Evaluation of Expression");
        System.out.println("[3] Return to Main Menu");
        System.out.print("Please select a number corresponding with your choice: ");
    }

    /*--------------------------------------------------SubMenu B: Part 1----------------------------------------------------*/
    // Main method for handling Prime Numbers submenu option.

    public static void PrimeNumbers() {
        Scanner input = new Scanner(System.in);
        int n;

        do {
            System.out.print("Enter an integer n (n ≥ 12): ");
            n = input.nextInt();
            input.nextLine();
            if (n < 12)
                System.out.println("Invalid input! Try again.");
        } while (n < 12);

        // Algorithm 1: Eratosthenes
        long startE = System.nanoTime();
        boolean[] primeE = Eratosthenes(n);
        long endE = System.nanoTime();

        // Algorithm 2: Sundaram
        long startS = System.nanoTime();
        boolean[] primeS = Sundaram(n);
        long endS = System.nanoTime();

        // Algorithm 3: Atkin
        long startA = System.nanoTime();
        boolean[] primeA = Atkin(n);
        long endA = System.nanoTime();

        // Display results for the first algorithm (Eratosthenes)
        int countE = 0;
        int[] primesE = new int[n];
        for (int i = 2; i <= n; i++) {
            if (primeE[i]) {
                primesE[countE++] = i;
            }
        }

        System.out.println("\nAlgorithm: Eratosthenes");
        System.out.println("Found " + countE + " prime numbers up to " + n + ".");
        System.out.print("First up to 3 primes: ");
        for (int i = 0; i < Math.min(3, countE); i++)
            System.out.print(primesE[i] + " ");
        System.out.println();

        System.out.print("Last up to 2 primes: ");
        for (int i = Math.max(0, countE - 2); i < countE; i++)
            System.out.print(primesE[i] + " ");
        System.out.println();

        // Display results for the second algorithm (Sundaram)
        int countS = 0;
        int[] primesS = new int[n];
        for (int i = 2; i <= n; i++) {
            if (primeS[i]) {
                primesS[countS++] = i;
            }
        }

        System.out.println("\nAlgorithm: Sundaram");
        System.out.println("Found " + countS + " prime numbers up to " + n + ".");
        System.out.print("First up to 3 primes: ");
        for (int i = 0; i < Math.min(3, countS); i++)
            System.out.print(primesS[i] + " ");
        System.out.println();

        System.out.print("Last up to 2 primes: ");
        for (int i = Math.max(0, countS - 2); i < countS; i++)
            System.out.print(primesS[i] + " ");
        System.out.println();

        // Display results for the third algorithm (Atkin)
        int countA = 0;
        int[] primesA = new int[n];
        for (int i = 2; i <= n; i++) {
            if (primeA[i]) {
                primesA[countA++] = i;
            }
        }

        System.out.println("\nAlgorithm: Atkin");
        System.out.println("Found " + countA + " prime numbers up to " + n + ".");
        System.out.print("First up to 3 primes: ");
        for (int i = 0; i < Math.min(3, countA); i++)
            System.out.print(primesA[i] + " ");
        System.out.println();

        System.out.print("Last up to 2 primes: ");
        for (int i = Math.max(0, countA - 2); i < countA; i++)
            System.out.print(primesA[i] + " ");
        System.out.println();

        System.out.println("\n--- Execution time comparison ---");
        System.out.printf("Eratosthenes: %.3f ms%n", (endE - startE) / 1_000_000.0);
        System.out.printf("Sundaram: %.3f ms%n", (endS - startS) / 1_000_000.0);
        System.out.printf("Atkin: %.3f ms%n", (endA - startA) / 1_000_000.0);
    }

    // 1: Eratosthenes algorithm
    public static boolean[] Eratosthenes(int n) {
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= n; j += i)
                    prime[j] = false;
            }
        }
        return prime;
    }

    // 2: Sundaram algorithm
    public static boolean[] Sundaram(int n) {
        int k = (n - 1) / 2;
        boolean[] marked = new boolean[k + 1];

        for (int i = 1; i <= k; i++) {
            for (int j = i; (i + j + 2 * i * j) <= k; j++)
                marked[i + j + 2 * i * j] = true;
        }

        boolean[] prime = new boolean[n + 1];
        if (n > 2) prime[2] = true;

        for (int i = 1; i <= k; i++) {
            if (!marked[i])
                prime[2 * i + 1] = true;
        }
        return prime;
    }

    // 3: Atkin algorithm
    public static boolean[] Atkin(int n) {
        boolean[] prime = new boolean[n + 1];
        if (n > 2) prime[2] = true;
        if (n > 3) prime[3] = true;

        for (int x = 1; x * x <= n; x++) {
            for (int y = 1; y * y <= n; y++) {

                // formula 1: 4x² + y²
                int num = (4 * x * x) + (y * y);
                if (num <= n && (num % 12 == 1 || num % 12 == 5))
                    prime[num] = !prime[num];

                // formula 2: 3x² + y²
                num = (3 * x * x) + (y * y);
                if (num <= n && num % 12 == 7)
                    prime[num] = !prime[num];

                // formula 3: 3x² - y²
                num = (3 * x * x) - (y * y);
                if (x > y && num <= n && num % 12 == 11)
                    prime[num] = !prime[num];
            }
        }

        for (int i = 5; i * i <= n; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= n; j += i * i)
                    prime[j] = false;
            }
        }
        return prime;
    }


    // StepByStepExpression() (simple math evaluator)
    /*--------------------------------------------------SubMenu B: Part 2----------------------------------------------------*/
    // Handles submenu option 2: Step-by-step evaluation of a simple arithmetic expression.
    // Accepts expressions with +, -, *, /, and parentheses.
    public static void StepByStepExpression() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a simple arithmetic expression (e.g., (3+5)*2 ):");
        String expr = input.nextLine();
        expr = expr.replaceAll("\\s+", "");

        // basic input validation
        if (!expr.matches("[0-9+\\-*/()]+")) {
            System.out.println("Invalid characters!");
            return;
        }

        try {
            // if the expression contains parentheses, evaluate the inner part first
            if (expr.contains("(")) {
                int open = expr.lastIndexOf('(');
                int close = expr.indexOf(')', open);
                String inside = expr.substring(open + 1, close);

                // evaluate inside parentheses and replace it with result
                int result = SimpleEval(inside);
                System.out.println("= " + expr.substring(0, open) + result + expr.substring(close + 1));
                expr = expr.substring(0, open) + result + expr.substring(close + 1);
            }

            int finalResult = SimpleEval(expr);
            System.out.println("= " + finalResult);
        } catch (Exception e) {
            System.out.println("Invalid expression!");
        }
    }

    // Evaluates a simple arithmetic expression (no parentheses) from left to right,
    // respecting operator precedence (* and / before + and -).
    private static int SimpleEval(String expr) {
        ArrayList<Integer> nums = new ArrayList<>();
        ArrayList<Character> ops = new ArrayList<>();

        String num = "";
        // parse expression into numbers and operators
        for (char c : expr.toCharArray()) {
            if (Character.isDigit(c)) num += c;
            else {
                nums.add(Integer.parseInt(num));
                num = "";
                ops.add(c);
            }
        }
        nums.add(Integer.parseInt(num));

        // handle * and / first
        for (int i = 0; i < ops.size();) {
            char op = ops.get(i);
            if (op == '*' || op == '/') {
                int a = nums.get(i);
                int b = nums.get(i + 1);
                int res = (op == '*') ? a * b : a / b;
                nums.set(i, res);
                nums.remove(i + 1);
                ops.remove(i);
            } else i++;
        }

        // handle + and - next
        int result = nums.get(0);
        for (int i = 0; i < ops.size(); i++) {
            char op = ops.get(i);
            int b = nums.get(i + 1);
            if (op == '+') result += b;
            else if (op == '-') result -= b;
        }
        return result;
    }

    public static void main(String[] args)
    {
        WelcomeScreen();

        char letter = 'j'; // dummy value
        do
        {
            PrintMainMenu();
            Scanner input = new Scanner(System.in);
            String submenu_choice = input.nextLine();
            if (submenu_choice.length() == 1) // to prevent input of "ENTER" key and to prevent input as words
                letter = Character.toLowerCase(submenu_choice.charAt(0));

            switch(letter)
            {
                case 'a':
                    System.out.println("Display Submenu A\n");
                    break;
                case 'b':
                    clearScreen();
                    short choiceB = 0;
                    do {
                        PrintSubmenuB();
                        choiceB = input.nextShort();
                        input.nextLine();
                        switch (choiceB) {
                            case 1:
                                PrimeNumbers();
                                break;
                            case 2:
                                StepByStepExpression();
                                break;
                            case 3:
                                letter = 'j'; // return to main menu
                                System.out.println();
                                break;
                            default:
                                System.out.println("Invalid choice. Try again!\n");
                        }
                    } while (choiceB > 3 || choiceB < 1);
                    break;
                case 'c':
                    System.out.println("Display Submenu C\n");
                    break;
                case 'd':
                    System.out.println("Display Connect Four Game\n");
                    break;
                case 'e':
                    System.out.println("You chose to exit the program.\n");
                    break;
                default:
                    System.out.println("\nYou entered an invalid choice. Try again!\n");
            }
        } while (!ValidSubmenu(letter));


    }
}
