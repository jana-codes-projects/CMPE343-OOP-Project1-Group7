import java.util.Arrays;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;
import java.util.List;
import java.util.Date;
import java.util.Calendar;


public class Main
{
    private static final int MAX_USER_INPUT = 60_000; // for safety array size
    private static final double CONVERT_NANO_TO_MILLISECOND = 1_000_000.0;

    // Displays a welcome screen of the project
    public static void WelcomeScreen()
    {
        // ANSI color codes
        final String RESET = "\u001B[0m";
        final String CYAN = "\u001B[36m";
        final String MAGENTA = "\u001B[35m";
        final String BLUE = "\u001B[34m";
        final String PURPLE = "\u001B[35m";

        // Bright versions
        final String BRIGHT_GREEN = "\u001B[92m";
        final String BRIGHT_YELLOW = "\u001B[93m";
        final String BRIGHT_BLUE = "\u001B[94m";
        final String BRIGHT_PURPLE = "\u001B[95m";
        final String BRIGHT_CYAN = "\u001B[96m";
        final String BRIGHT_WHITE = "\u001B[97m";


        System.out.println(BRIGHT_YELLOW +
                           "╔════════════════════════════════════════════════════════════╗");
        System.out.println("║                                                            ║");
        System.out.println("║  " + PURPLE + "██╗    ██╗███████╗██╗      ██████╗ ███╗   ███╗ ███████╗" + BRIGHT_YELLOW + "   ║");
        System.out.println("║  " + BRIGHT_WHITE + "██║    ██║██╔════╝██║     ██╔═══██╗████╗ ████║ ██╔════╝" + BRIGHT_YELLOW + "   ║");
        System.out.println("║  " + CYAN + "██║ █╗ ██║█████╗  ██║     ██║   ██║██╔████╔██║ █████╗  " + BRIGHT_YELLOW + "   ║");
        System.out.println("║  " + BRIGHT_CYAN + "██║███╗██║██╔══╝  ██║     ██║   ██║██║╚██╔╝██║ ██╔══╝  " + BRIGHT_YELLOW + "   ║");
        System.out.println("║  " + BRIGHT_BLUE + "╚███╔███╔╝███████╗███████╗╚██████╔╝██║ ╚═╝ ██║ ███████╗" + BRIGHT_YELLOW + "   ║");
        System.out.println("║  " + BRIGHT_PURPLE + " ╚══╝╚══╝ ╚══════╝╚══════╝ ╚═════╝ ╚═╝     ╚═╝ ╚══════╝" + BRIGHT_YELLOW + "   ║");
        System.out.println("║                                                            ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝" + RESET);

        System.out.println(BRIGHT_GREEN + "\n★ WELCOME TO GROUP 7's FIRST PROJECT FOR OOP ★" + RESET);
        System.out.println(MAGENTA + "\nOur group members are as follows:" + RESET);
        System.out.println(BLUE + "1) Canan Albarazi" + RESET);
        System.out.println(BLUE + "2) Emir Furkan Gökdemir" + RESET);
        System.out.println(BLUE + "3) Nur Kambasar" + RESET);
        System.out.println(BLUE + "4) Kaan Yılmaz" + RESET);
        System.out.println(BRIGHT_YELLOW + "\n>>> Let's begin the project! <<<\n" + RESET);
    }

    // Displays Main Menu
    public static void PrintMainMenu()
    {
        final String BRIGHT_WHITE = "\u001B[97m";

        System.out.println(BRIGHT_WHITE + "~~~~~~~~~~~~~~~~~~~~~~~~~~ MAIN MENU ~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("[A] Primary School\n" +
                "[B] Secondary School\n" +
                "[C] High School\n" +
                "[D] University\n" +
                "[E] Terminate");
        System.out.print("Please select a letter corresponding with your submenu choice: ");
    }

    // Checks if the user input is valid for a submenu
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
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }

    /*--------------------------------------------------SubMenu Displays----------------------------------------------------*/

    // Displays Submenu (Option) A
    public static void PrintSubmenuA()
    {
        final String BRIGHT_PURPLE = "\u001B[95m";

        System.out.println(BRIGHT_PURPLE + "~~~~~~~~~~~~~~~~~~~~~~~~~~ Primary School Menu ~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("[1] Age and Zodiac Sign Detection");
        System.out.println("[2] Reverse the Words");
        System.out.println("[3] Return to Main Menu");
        System.out.print("Please select an option: ");
    }

    // Displays Submenu (Option) B
    public static void PrintSubmenuB()
    {
        final String CYAN = "\u001B[36m";

        System.out.println(CYAN + "~~~~~~~~~~~~~~~~~~~~~~~~~~ Secondary School Menu ~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("[1] Prime Numbers");
        System.out.println("[2] Step-by-step Evaluation of Expression");
        System.out.println("[3] Return to Main Menu");
        System.out.print("Please select a number corresponding with your choice: ");
    }

    // Displays Submenu (Option) C
    public static void PrintSubmenuC()
    {
        final String MAGENTA = "\u001B[35m";

        System.out.println(MAGENTA + "~~~~~~~~~~~~~~~~~~~~~~~~~~ High School Menu ~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("[1] Statistical Information about an Array\n" +
                "[2] Distance between Two Arrays\n" +
                "[3] Return to Main Menu");
        System.out.print("Please select a number corresponding with your choice: ");
    }

    /*--------------------------------------------------SubMenu A: Part 1----------------------------------------------------*/

    public static void AgeAndZodiac()
    {
        int currentDay, currentMonth, currentYear;

        Date currentDate = new Date(); // current date and time
        Calendar cal = Calendar.getInstance();
        cal.setTime(currentDate);

        currentDay = cal.get(Calendar.DAY_OF_MONTH);
        currentMonth = cal.get(Calendar.MONTH) + 1; // Month is 0-based (Jan = 0)
        currentYear = cal.get(Calendar.YEAR);

        short birthDay, birthMonth, birthYear;
        short[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; // days in each month

        while (true)
        {
            birthDay = GetDay();
            birthMonth = GetMonth();
            birthYear = GetYear(currentYear);
            if (!isValidDate(birthDay, birthMonth, birthYear, daysInMonth))
                System.out.println("Invalid Date! Day, month, or year do not align. Try again.");
            else
                break;
        };

        int[] age = calculateAge(birthDay, birthMonth, birthYear, currentDay, currentMonth, currentYear, daysInMonth);
        System.out.println("\nYour Age: " + age[0] + " years, " + age[1] + " months, " + age[2] + " days");
        String zodiac = calculateZodiac(birthDay, birthMonth);
        System.out.println("Your Zodiac Sign: " + zodiac);
    }

    // asks user for birth day and checks if it is valid
    public static short GetDay()
    {
        short day = 0;
        Scanner input = new Scanner(System.in);
        do
        {
            System.out.print("\nEnter day of birth (1-31): ");
            try
            {
                day = input.nextShort();
                input.nextLine(); // to remove "ENTER" key buffer
            }
            catch (InputMismatchException ex) // to handle overflow/underflow
            {
                System.out.println("Input generated Overflow/Underflow. Try again.");
                input.nextLine(); // to remove "ENTER" key buffer
                day = 0;
                continue;
            }

            if (day < 1)
                System.out.println("Invalid input! Day cannot be zero or negative.");
            else if (day > 31)
            {
                System.out.println("Maximum number of days in a month is 31. Try again.");
                day = 0;
            }

        } while (day < 1 || day > 31);
        return day;
    }

    // asks user for birth month and checks if it is valid
    public static short GetMonth()
    {
        short month = 0;
        Scanner input = new Scanner(System.in);
        do
        {
            System.out.print("Enter month of birth (1-12): ");
            try
            {
                month = input.nextShort();
                input.nextLine(); // to remove "ENTER" key buffer
            }
            catch (InputMismatchException ex) // to handle overflow/underflow
            {
                System.out.println("Input generated Overflow/Underflow. Try again.");
                input.nextLine(); // to remove "ENTER" key buffer
                month = 0;
                continue;
            }

            if (month < 1)
                System.out.println("Invalid input! Month cannot be zero or negative.");
            else if (month > 12)
            {
                System.out.println("Maximum number for a month is 12. Try again.");
                month = 0;
            }

        } while (month < 1 || month > 12);
        return month;
    }

    // asks user for birth year and checks if it is valid
    public static short GetYear(int CurrentYear)
    {
        short year = 0;
        Scanner input = new Scanner(System.in);
        do
        {
            System.out.print("Enter year of birth (< " + CurrentYear + "): ");
            try
            {
                year = input.nextShort();
                input.nextLine(); // to remove "ENTER" key buffer
            }
            catch (InputMismatchException ex) // to handle overflow/underflow
            {
                System.out.println("Input generated Overflow/Underflow. Try again.");
                input.nextLine(); // to remove "ENTER" key buffer
                year = 0;
                continue;
            }

            if (year < 1)
                System.out.println("Invalid input! Year cannot be zero or negative. Try again.");
            else if (year > CurrentYear)
            {
                System.out.println("Invalid input! Year cannot be greater than the current year. Try again.");
                year = 0;
            }

        } while (year < 1 || year > CurrentYear);
        return year;
    }

    // checks if the date is valid based on day corresponding to month and if it is a leap year
    private static boolean isValidDate(short day, short month, short year, short[] daysInMonth)
    {
        // Adjust for leap year
        boolean isLeap = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        if (isLeap && month == 2)
            daysInMonth[1] = 29;

        if (day > daysInMonth[month - 1])
            return false;

        return true;
    }

    //Function Calculating Age Based on Date of Birth
    private static int[] calculateAge(short birthDay, short birthMonth, short birthYear, int currentDay, int currentMonth, int currentYear, short[] daysInMonth)
    {
        if (birthDay > currentDay)
        {
            currentDay += daysInMonth[currentMonth - 2 < 0 ? 11 : currentMonth - 2];
            currentMonth -= 1;
        }

        if (birthMonth > currentMonth)
        {
            currentYear -= 1;
            currentMonth += 12;
        }

        int calculatedDay = currentDay - birthDay;
        int calculatedMonth = currentMonth - birthMonth;
        int calculatedYear = currentYear - birthYear;

        return new int[] { calculatedYear, calculatedMonth, calculatedDay };
    }

    //Function Calculating Zodiac Sign Based on Date of Birth
    private static String calculateZodiac(int day, int month)
    {
        String zodiac = "";

        if ((month == 1 && day >= 20) || (month == 2 && day <= 18))
            zodiac = "Aquarius";
        else if ((month == 2 && day >= 19) || (month == 3 && day <= 20))
            zodiac = "Pisces";
        else if ((month == 3 && day >= 21) || (month == 4 && day <= 19))
            zodiac = "Aries";
        else if ((month == 4 && day >= 20) || (month == 5 && day <= 20))
            zodiac = "Taurus";
        else if ((month == 5 && day >= 21) || (month == 6 && day <= 20))
            zodiac = "Gemini";
        else if ((month == 6 && day >= 21) || (month == 7 && day <= 22))
            zodiac = "Cancer";
        else if ((month == 7 && day >= 23) || (month == 8 && day <= 22))
            zodiac = "Leo";
        else if ((month == 8 && day >= 23) || (month == 9 && day <= 22))
            zodiac = "Virgo";
        else if ((month == 9 && day >= 23) || (month == 10 && day <= 22))
            zodiac = "Libra";
        else if ((month == 10 && day >= 23) || (month == 11 && day <= 21))
            zodiac = "Scorpio";
        else if ((month == 11 && day >= 22) || (month == 12 && day <= 21))
            zodiac = "Sagittarius";
        else if ((month == 12 && day >= 22) || (month == 1 && day <= 19))
            zodiac = "Capricorn";

        return zodiac;
    }

    /*--------------------------------------------------SubMenu A: Part 2----------------------------------------------------*/

    public static void ReverseWords()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("\n=== Reverse the Words ===");
        System.out.print("Enter your sentence: ");
        String sentence = input.nextLine();

        String reversed = reverseSentence(sentence);
        System.out.println("\nReversed Sentence:");
        System.out.println(reversed);
    }

    //Recursive Function That Reverses a Sentence Word by Word
    private static String reverseSentence(String sentence)
    {
        if (sentence.isEmpty())
            return "";

        int spaceIndex = sentence.indexOf(' ');
        if (spaceIndex == -1)
            return reverseWord(sentence);

        String firstWord = sentence.substring(0, spaceIndex);
        String rest = sentence.substring(spaceIndex + 1);
        return reverseWord(firstWord) + " " + reverseSentence(rest);
    }

    //Single Word Reversal Function
    private static String reverseWord(String word)
    {
        if (word.length() < 2)
            return word;
        return reverseWordRecursive(word, 0, word.length() - 1);
    }

    //Function to Recursively Reverse the Letters in a Word
    private static String reverseWordRecursive(String word, int left, int right)
    {
        char[] chars = word.toCharArray();
        if (left >= right)
            return new String(chars);

        if (Character.isLetter(chars[left]) && Character.isLetter(chars[right]))
        {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            return reverseWordRecursive(new String(chars), left + 1, right - 1);
        }
        else if (!Character.isLetter(chars[left]))
            return reverseWordRecursive(word, left + 1, right);
        else
            return reverseWordRecursive(word, left, right - 1);
    }


    /*--------------------------------------------------SubMenu B: Part 1----------------------------------------------------*/
    public static void PrimeNumbers()
    {
        Scanner input = new Scanner(System.in);
        int n;

        do {
            System.out.print("\nEnter an integer n (n ≥ 12): ");
            try
            {
                n = input.nextInt();
                input.nextLine(); // to remove "ENTER" key buffer
            }
            catch (InputMismatchException ex) // to handle overflow/underflow
            {
                System.out.println("Input generated Overflow/Underflow. Try again.");
                input.nextLine(); // to remove "ENTER" key buffer
                n = 0;
                continue;
            }
            if (n < 12)
                System.out.println("Invalid input! Try again.");
            else if (n > MAX_USER_INPUT)
                System.out.println("Input too large! Limit is " + MAX_USER_INPUT);

        } while (n < 12 || n > MAX_USER_INPUT);

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
        System.out.printf("Sieve of Eratosthenes: %.3f ms%n", (endE - startE) / CONVERT_NANO_TO_MILLISECOND);
        System.out.printf("Sieve of Sundaram: %.3f ms%n", (endS - startS) / CONVERT_NANO_TO_MILLISECOND);
        System.out.printf("Sieve of Atkin: %.3f ms%n", (endA - startA) / CONVERT_NANO_TO_MILLISECOND);
    }

    // 1: Eratosthenes algorithm
    private static boolean[] Eratosthenes(int n)
    {
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
    private static boolean[] Sundaram(int n)
    {
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
    private static boolean[] Atkin(int n)
    {
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


    /*--------------------------------------------------SubMenu B: Part 2----------------------------------------------------*/

    private static boolean isValidExpression(String expr)
    {
        // An empty expression is invalid
        if (expr.isEmpty())
            return false;

        // Check 1: Invalid Characters
        if (!expr.matches("[0-9+\\-x:()]+"))
            return false;

        // Check 2: Mismatched Parentheses
        int parenthesesCounter = 0;
        for (char c : expr.toCharArray()) {
            if (c == '(')
                parenthesesCounter++;
            else if (c == ')')
                parenthesesCounter--;

            // If we try to close a parenthesis that was never opened
            if (parenthesesCounter < 0)
                return false;
        }

        // If the loop finishes and the count isn't zero
        if (parenthesesCounter != 0)
            return false;


        // Check 3: Consecutive operators
        for (int i = 0; i < expr.length() - 1; i++)
        {
            char current = expr.charAt(i);
            char next = expr.charAt(i + 1);
            if ("+-x:".indexOf(current) != -1 && "+-x:".indexOf(next) != -1)
                return false;

            // Check for empty parentheses
            if (current == '(' && next == ')')
                return false;
        }

        // Check 4: Invalid start/end characters
        char firstChar = expr.charAt(0);
        char lastChar = expr.charAt(expr.length() - 1);

        if (firstChar == '+' || firstChar == 'x' || firstChar == ':')
            return false;

        // Expressions ending in an operator are invalid
        if ("+-x:".indexOf(lastChar) != -1)
            return false;

        return true; // Passed all checks
    }

    private static String evaluateStepByStep(String expr, boolean printSteps)
    {
        // Base Case: If the expression is just a single number (positive or negative)
        if (expr.matches("^-?[0-9]+$"))
            return expr; // Stop recursion

        // Solve Parentheses First
        if (expr.contains("("))
        {
            // Find the first closing parenthesis
            int close = expr.indexOf(')');
            // Find the last opening parenthesis before that closing one
            int open = expr.substring(0, close).lastIndexOf('(');

            String before = expr.substring(0, open);
            String inside = expr.substring(open + 1, close);
            String after = expr.substring(close + 1);

            // RECURSIVE CALL 1: Solve what's inside
            String insideResult = evaluateStepByStep(inside, false);

            // Rebuild the expression with the result from inside
            String newExpr = before + insideResult + after;

            // Only print the step if this is the main call
            if (printSteps)
                System.out.println("= " + newExpr); // Print the step

            // RECURSIVE CALL 2: Solve the newly simplified expression, passing the flag
            return evaluateStepByStep(newExpr, printSteps);
        }

        // Solve with Operator Precedence
        ArrayList<String> nums = new ArrayList<>();
        ArrayList<Character> ops = new ArrayList<>();

        String num = "";

        if (expr.startsWith("-"))
        {
            num = "-";
            expr = expr.substring(1);
        }

        for (char c : expr.toCharArray())
        {
            if (Character.isDigit(c))
                num += c;
            else if (c == '-')
            {
                if (num.isEmpty())
                    num = "-";
                else
                {
                    nums.add(num);
                    num = "";
                    ops.add(c);
                }
            }
            else
            {
                nums.add(num);
                num = "";
                ops.add(c);
            }
        }
        nums.add(num);

        // Solve Multiplication and Division
        for (int i = 0; i < ops.size(); i++)
        {
            char op = ops.get(i);
            if (op == 'x' || op == ':')
            {
                int a = Integer.parseInt(nums.get(i));
                int b = Integer.parseInt(nums.get(i + 1));

                int res = (op == 'x') ? a * b : a / b;

                String newExpr = "";
                for(int j=0; j < i; j++)
                    newExpr += nums.get(j) + ops.get(j);

                newExpr += res;

                for(int j=i+1; j < ops.size(); j++)
                    newExpr += ops.get(j) + nums.get(j+1);

                if (printSteps)
                    System.out.println("= " + newExpr);

                return evaluateStepByStep(newExpr, printSteps);
            }
        }

        // Solve Addition and Subtraction
        for (int i = 0; i < ops.size(); i++)
        {
            char op = ops.get(i);
            if (op == '+' || op == '-')
            {
                int a = Integer.parseInt(nums.get(i));
                int b = Integer.parseInt(nums.get(i + 1));
                int res = (op == '+') ? a + b : a - b;

                String newExpr = "";
                for(int j=0; j < i; j++)
                    newExpr += nums.get(j) + ops.get(j);

                newExpr += res;

                for(int j=i+1; j < ops.size(); j++)
                    newExpr += ops.get(j) + nums.get(j+1);

                if (printSteps)
                    System.out.println("= " + newExpr);

                return evaluateStepByStep(newExpr, printSteps);
            }
        }

        return expr;
    }

    public static void StepByStepExpression()
    {
        Scanner input = new Scanner(System.in);
        String expr;

        // VALIDATION LOOP
        while (true)
        {
            System.out.print("\nEnter an arithmetic expression (e.g., (3+5)x2 ): ");
            expr = input.nextLine();
            expr = expr.replaceAll("\\s+", "");

            if (!isValidExpression(expr) && !expr.isEmpty())
                System.out.println("Expression was incorrect. Re-enter a valid expression.");
            else
                break;
        }

        // RECURSIVE EVALUATION
        System.out.println(expr); // Print the original, valid expression

        try
        {
            // Start the recursive call, setting printSteps to TRUE
            evaluateStepByStep(expr, true);
        }
        catch (ArithmeticException e)
        {
            System.out.println("Error during evaluation: Division by zero!");
        }
        catch (Exception e)
        {
            System.out.println("Error during evaluation: " + e.getMessage());
        }
    }

    /*--------------------------------------------------SubMenu C: Part 1----------------------------------------------------*/
    public static void StatisticalArray()
    {
        int part = 1; // to display the correct message for GetArraySize Method
        int size = GetArraySize(part);
        double[] arr = new double[size];

        Scanner input = new Scanner(System.in);

        System.out.println("\nProceed with entering " + size + " number(s) (accepts double values like 6.5): ");
        for (int i = 0; i < size; i++)
        {
            while (true) {
                System.out.print("Element " + (i+1) + ": "); // to track which element is being asked
                try {
                    arr[i] = input.nextDouble();
                    input.nextLine(); // to remove "ENTER" key buffer
                    break;
                } catch (InputMismatchException ex) { // to handle overflow/underflow
                    System.out.println("Input generated Overflow/Underflow. Try again.");
                    input.nextLine(); // to remove "ENTER" key buffer
                }
            }
        }

        System.out.print("\nThe elements of the array: ");
        DisplayArray(arr);
        double median = ArrayMedian(arr, size);
        double Arith_mean = ArithmeticMean(arr, size);
        double Geo_mean = GeometricMean(arr, size);
        double Har_mean = HarmonicMean(arr, size);

        // Display median
        System.out.println("\nThe median of the array is: " + median);

        // Display Arithmetic mean
        System.out.printf("The Arithmetic Mean of the array is: %.3f\n", Arith_mean);

        // Display Geometric mean
        if (Geo_mean > 0)
            System.out.printf("The Geometric Mean of the array is: %.3f\n", Geo_mean);
        else if (Geo_mean == 0)
            System.out.println("Geometric mean cannot be defined with one of the numbers being zero.");
        else
            System.out.println("Geometric mean cannot be defined with an odd number of negative numbers.");

        // Display Harmonic mean
        if (Har_mean > 0)
            System.out.printf("The Harmonic Mean of the array is: %.3f\n", Har_mean);
        else if (Har_mean == 0)
            System.out.println("Harmonic mean cannot be defined with the divisor (sum of reciprocals of elements) being zero.");
        else
            System.out.printf("The harmonic mean of the array is: %.3f\n(Usually harmonic mean does not allow negative numbers, but the answer above shows the answer if it did.)", Har_mean);
    }

    // Asks user for array size and checks if the input is valid
    private static int GetArraySize(int i)
    {
        int size = 0;
        Scanner input = new Scanner(System.in);
        do
        {
            if (i == 1)
                System.out.print("\nEnter the size of the array: ");
            else
                System.out.print("\nEnter the dimension of the two arrays: ");

            try
            {
                size = input.nextInt();
                input.nextLine(); // to remove "ENTER" key buffer
            }
            catch (InputMismatchException ex) // to handle overflow/underflow
            {
                System.out.println("Input generated Overflow/Underflow. Try again.");
                input.nextLine(); // to remove "ENTER" key buffer
                size = 0;
                continue;
            }

            if (size < 1)
                System.out.println("Invalid input! Size must be at least 1.");
            else if (size > MAX_USER_INPUT)
            {
                System.out.println("Requested size is too large; limit is " + MAX_USER_INPUT + ".");
                size = 0;
            }

        } while (size < 1);
        return size;
    }

    // prints all the array of double elements to visualize
    private static void DisplayArray(double[] arr)
    {
        for (double element : arr)
            System.out.print(element + " ");
        System.out.println();
    }

    // sorts the array and returns the middle element or median of the array
    private static double ArrayMedian(double[] arr, int size)
    {
        double median = 0;
        // sort array to find middle element
        Arrays.sort(arr);

        if (size % 2 == 1) // when array size is odd
            median = arr[((size+1)/2) - 1];
        else // when array size is even
            median = (arr[(size/2) - 1] + arr[size/2]) / 2.0;
        return median;
    }

    // calculates and returns the arithmetic mean
    private static double ArithmeticMean(double[] arr, int size)
    {
        double avg = 0;
        for (double element : arr)
        {
            avg += element;
        }
        avg /= size; // input size will never be 0 or negative so this is okay
        return avg;
    }

    // calculates and returns the geometric mean
    private static double GeometricMean(double[] arr, int size)
    {
        double avg = 1;
        for (double element : arr)
        {
            if (element == 0)
                return 0.0;
            avg *= element;
        }
        if (avg < 0)
            return Double.NaN; // since the number would have a negative sign inside a square root, the number does not exist
        avg = Math.pow(avg, (double)1/size);
        return avg;
    }

    // calls private recursive function to calculate the harmonic mean and returns its value
    private static double HarmonicMean(double[] arr, int size)
    {
        double sumReciprocals = harmonicHelper(arr, size, 0);
        if (sumReciprocals == 0)
            return 0.0;
        return size / sumReciprocals;
    }

    // private recursive function which calculates the harmonic mean
    private static double harmonicHelper(double[] arr, int size, int index)
    {
        if (index == size) // check if last element is reached
            return 0;

        double current = arr[index];
        if (current == 0)  // This element is zero, so it is skipped to avoid a zero divisor
            return harmonicHelper(arr, size, index + 1); // go to next element

        return (1.0 / current) + harmonicHelper(arr, size, index + 1); // add current element to next element
    }

    /*--------------------------------------------------SubMenu C: Part 2----------------------------------------------------*/
    public static void TwoArraysDistance()
    {
        int part = 2; // to display the correct message for GetArraySize Method
        int size = GetArraySize(part);
        short[] arr1 = new short[size];
        short[] arr2 = new short[size];


        System.out.println("\nProceed with entering " + size + " number(s) for the first array (integers 0 to 9): ");
        GetArrayElements(arr1, size);

        System.out.println("Proceed with entering " + size + " number(s) for the second array (integers 0 to 9): ");
        GetArrayElements(arr2, size);

        System.out.print("\nThe elements of the first array: ");
        DisplayArray(arr1);
        System.out.print("\nThe elements of the second array: ");
        DisplayArray(arr2);

        int manhattan_distance = ManhattanDistance(arr1, arr2, size);
        double euclidean_distance = EuclideanDistance(arr1, arr2, size);
        double cosine_similarity = CosineSimilarity(arr1, arr2, size);

        System.out.println("\nThe Manhattan Distance of the two arrays is: " + manhattan_distance);
        System.out.printf("The Euclidean Distance of the two arrays is: %.3f\n", euclidean_distance);
        System.out.printf("The Cosine Similarity of the two arrays is: %.3f\n", cosine_similarity);
    }

    // prints all the array of integers 0 to 9 elements to visualize
    private static void DisplayArray(short[] arr)
    {
        for (short element : arr)
            System.out.print(element + " ");
        System.out.println();
    }

    // Asks user for array elements as input and checks if they are valid integers 0 to 9
    private static void GetArrayElements(short[] arr, int size)
    {
        Scanner input = new Scanner(System.in);

        for (int i = 0; i < size; i++)
        {
            while (true) {
                System.out.print("Element " + (i+1) + ": "); // to track which element is being asked
                try
                {
                    short val = input.nextShort();
                    input.nextLine(); // to remove "ENTER" key buffer
                    if (val > 9 || val < 0) {
                        System.out.println("Invalid input. Try again! (integers 0 to 9)");
                        continue;
                    }
                    arr[i] = val;
                    break;
                }
                catch (InputMismatchException ex)  // to handle overflow/underflow
                {
                    System.out.println("Input generated Overflow/Underflow. Try again! (integers 0 to 9)");
                    input.nextLine(); // to remove "ENTER" key buffer
                }
            }
        }
    }

    // calculates and returns Manhattan distance of the two arrays
    private static int ManhattanDistance(short[] a1, short[] a2, int size)
    {
        int ans = 0;
        for (int i = 0; i < size; i++)
        {
            ans += Math.abs(a1[i] - a2[i]);
        }
        return ans;
    }

    // calculates and returns Euclidean distance of the two arrays
    private static double EuclideanDistance(short[] a1, short[] a2, int size)
    {
        double ans = 0;
        for (int i = 0; i < size; i++)
        {
            ans += Math.pow((a1[i] - a2[i]), 2);
        }
        ans = Math.sqrt(ans);
        return ans;
    }

    // calculates and returns Cosine similarity of the two arrays
    private static double CosineSimilarity(short[] a1, short[] a2, int size)
    {
        double ans = 0;
        int dotProduct = 0;
        int prod1 = 0;
        int prod2 = 0;
        for (int i = 0; i < size; i++)
        {
            dotProduct += a1[i]*a2[i];
            prod1 += Math.pow(a1[i], 2);
            prod2 += Math.pow(a2[i], 2);
        }
        // to eliminate divisor being 0 if both elements are 0
        if (prod1 == 0 || prod2 == 0)
        {
            System.out.println("Divisor was zero!");
            return 0.0;
        }
        ans = (double)dotProduct/Math.sqrt(prod1*prod2);
        return ans;
    }

    /*--------------------------------------------------SubMenu D: Connect Four----------------------------------------------------*/

    enum Mode
    {
        PVP, PVC_RANDOM
    }

    static class Game // class issue
    {
        final int cols;
        final int rows;
        final int[][] board; // 0 empty, 1 P1, 2 P2
        final Random rng = new Random();

        Game(int cols, int rows)
        {
            this.cols = cols;
            this.rows = rows;
            this.board = new int[rows][cols];
        }

        boolean isColumnFull(int c)
        {
            return board[0][c] != 0;
        }

        boolean drop(int c, int player)
        {
            if (c < 0 || c >= cols || isColumnFull(c)) return false;
            for (int r = rows - 1; r >= 0; r--) {
                if (board[r][c] == 0) {
                    board[r][c] = player;
                    return true;
                }
            }
            return false;
        }

        boolean hasMoves()
        {
            for (int c = 0; c < cols; c++) if (!isColumnFull(c)) return true;
            return false;
        }

        void print()
        {
            Main.clearScreen();
            System.out.println();
            System.out.println("   CONNECT FOUR  (" + cols + "x" + rows + ")");
            System.out.println();
            for (int r = 0; r < rows; r++) {
                System.out.print("  |");
                for (int c = 0; c < cols; c++) {
                    char ch = '.';
                    if (board[r][c] == 1) ch = 'X';
                    if (board[r][c] == 2) ch = 'O';
                    System.out.print(" " + ch + " ");
                }
                System.out.println("|");
            }
            System.out.print("   ");
            for (int c = 0; c < cols; c++) System.out.print("---");
            System.out.println();
            System.out.print("    ");
            for (int c = 0; c < cols; c++) System.out.printf("%d  ", (c + 1));
            System.out.println("\n");
        }

        boolean isWinningMove(int player)
        {
            // Horizontal
            for (int r = 0; r < rows; r++)
            {
                for (int c = 0; c <= cols - 4; c++)
                {
                    if (board[r][c] == player && board[r][c+1] == player &&
                            board[r][c+2] == player && board[r][c+3] == player)
                        return true;
                }
            }
            // Vertical
            for (int c = 0; c < cols; c++)
            {
                for (int r = 0; r <= rows - 4; r++)
                {
                    if (board[r][c] == player && board[r+1][c] == player &&
                            board[r+2][c] == player && board[r+3][c] == player)
                        return true;
                }
            }
            // Diagonal down-right
            for (int r = 0; r <= rows - 4; r++)
            {
                for (int c = 0; c <= cols - 4; c++)
                {
                    if (board[r][c] == player && board[r+1][c+1] == player &&
                            board[r+2][c+2] == player && board[r+3][c+3] == player)
                        return true;
                }
            }
            // Diagonal up-right
            for (int r = 3; r < rows; r++)
            {
                for (int c = 0; c <= cols - 4; c++)
                {
                    if (board[r][c] == player && board[r-1][c+1] == player &&
                            board[r-2][c+2] == player && board[r-3][c+3] == player)
                        return true;
                }
            }
            return false;
        }

        List<Integer> legalMoves()
        {
            List<Integer> moves = new ArrayList<>();
            for (int c = 0; c < cols; c++)
                if (!isColumnFull(c))
                    moves.add(c);
            return moves;
        }

        // --- AI: Random ---
        int aiMoveRandom()
        {
            List<Integer> moves = legalMoves();
            return moves.get(rng.nextInt(moves.size()));
        }
    }

    // Submenu D runner
    public static void SubmenuD_ConnectFour()
    {
        Scanner sc = new Scanner(System.in);
        final String BRIGHT_BLUE = "\u001B[94m";

        int[] cOpts = {5, 6, 7};
        int[] rOpts = {4, 5, 6};

        System.out.println(BRIGHT_BLUE + "SUBMENU D — Connect Four");
        System.out.println("Choose Board Size:");
        System.out.println("  1) 5 x 4");
        System.out.println("  2) 6 x 5");
        System.out.println("  3) 7 x 6");
        int sizeChoice = askInt(sc, "Your choice (1-3): ", 1, 3);
        int cols = cOpts[sizeChoice - 1];
        int rows = rOpts[sizeChoice - 1];

        System.out.println("\nChoose Game Mode:");
        System.out.println("  1) 2 Players (PvP)");
        System.out.println("  2) Single Player — Computer (Random)");
        int modeChoice = askInt(sc, "Your choice (1-2): ", 1, 2);

        Mode mode = (modeChoice == 1) ? Mode.PVP : Mode.PVC_RANDOM;

        Game g = new Game(cols, rows);
        int current = 1; // 1 = X (Player 1), 2 = O (Player 2/Computer)
        boolean humanIsP1 = true; // in PvC, human plays X by default

        while (true)
        {
            g.print();
            if (!g.hasMoves())
            {
                System.out.println("Board is full. It's a draw!");
                break;
            }

            boolean isHumansTurn = true;
            if (mode == Mode.PVC_RANDOM)
            {
                isHumansTurn = (current == 1 && humanIsP1) || (current == 2 && !humanIsP1);
            }

            int moveCol = -1;

            if (mode == Mode.PVP || isHumansTurn)
            {
                // Human turn
                System.out.printf("Player %d (%s), choose a column (1-%d) or 'q' to forfeit: ",
                        current, (current == 1 ? "X" : "O"), cols);
                String in = sc.nextLine().trim();
                if (in.equalsIgnoreCase("q"))
                {
                    g.print();
                    System.out.printf("Player %d forfeited. The other player wins!\n", current);
                    break;
                }

                try
                {
                    int col = Integer.parseInt(in) - 1;
                    if (col < 0 || col >= cols || g.isColumnFull(col)) {
                        System.out.println("Invalid choice or the column is full. Try again.");
                        pause(sc);
                        continue;
                    }
                    moveCol = col;
                }
                catch (NumberFormatException e)
                {
                    System.out.println("Invalid input. Try again.");
                    pause(sc);
                    continue;
                }
            }
            else
            {
                // Computer turn
                System.out.println("Computer is thinking...");
                moveCol = g.aiMoveRandom();
                sleep(300); // small delay for UX
            }

            // Apply move
            g.drop(moveCol, current);

            // Check win
            if (g.isWinningMove(current))
            {
                g.print();
                if (mode == Mode.PVP || isHumansTurn)
                {
                    System.out.printf("Congratulations! Player %d (%s) wins!\n", current, (current == 1 ? "X" : "O"));
                }
                else
                {
                    System.out.printf("Computer (%s) wins!\n", (current == 1 ? "X" : "O"));
                }
                break;
            }

            // Next player
            current = (current == 1) ? 2 : 1;
        }

        System.out.println("\nGame over. Thanks for playing!");
        System.out.print("Press Enter to return to Main Menu...");
        sc.nextLine();
    }

    private static int askInt(Scanner sc, String prompt, int min, int max)
    {
        while (true)
        {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            try
            {
                int v = Integer.parseInt(s);
                if (v >= min && v <= max) return v;
            } catch (NumberFormatException ignored) {}
            System.out.println("Invalid input. Please try again.");
        }
    }

    private static void pause(Scanner sc)
    {
        System.out.print("Press Enter to continue...");
        sc.nextLine();
    }

    private static void sleep(long ms)
    {
        try
        {
            Thread.sleep(ms);
        }
        catch (InterruptedException ignored) {}
    }

    /*--------------------------------------------------MAIN FUNCTION----------------------------------------------------*/
    public static void main(String[] args)
    {
        WelcomeScreen();
        Scanner input = new Scanner(System.in);
        char letter = 'j'; // dummy value

        final String BRIGHT_WHITE = "\u001B[97m";

        do
        {
            PrintMainMenu();
            String submenu_choice = input.nextLine();
            if (submenu_choice.length() == 1) // to prevent input of "ENTER" key and to prevent input as words
                letter = Character.toLowerCase(submenu_choice.charAt(0));

            switch(letter)
            {
                case 'a':
                    clearScreen();
                    short choiceA = 0;
                    do
                    {
                        PrintSubmenuA();
                        try
                        {
                            choiceA = input.nextShort();
                            input.nextLine(); // to remove "ENTER" key buffer
                        }
                        catch (InputMismatchException ex) // to handle overflow/underflow
                        {
                            System.out.println("Input generated Overflow/Underflow");
                            input.nextLine(); // to remove "ENTER" key buffer
                            choiceA = 0;
                            continue;
                        }
                        switch (choiceA) {
                            case 1:
                                AgeAndZodiac();
                                choiceA = 0; // loop back to submenu A
                                System.out.print(BRIGHT_WHITE + "\nPress Enter to return to Primary School Menu:");
                                input.nextLine(); // to remove "ENTER" key buffer
                                clearScreen();
                                break;
                            case 2:
                                ReverseWords();
                                choiceA = 0; // loop back to submenu A
                                System.out.print(BRIGHT_WHITE + "\nPress Enter to return to Primary School Menu:");
                                input.nextLine(); // to remove "ENTER" key buffer
                                clearScreen();
                                break;
                            case 3:
                                letter = 'j'; // loop back to main menu
                                clearScreen();
                                break;
                            default:
                                clearScreen();
                                System.out.println("Invalid choice. Try again!\n");
                        }
                    } while (choiceA > 3 || choiceA < 1);
                    break;
                case 'b':
                    clearScreen();
                    short choiceB = 0;
                    do
                    {
                        PrintSubmenuB();
                        try
                        {
                            choiceB = input.nextShort();
                            input.nextLine(); // to remove "ENTER" key buffer
                        }
                        catch (InputMismatchException ex) // to handle overflow/underflow
                        {
                            System.out.println("Input generated Overflow/Underflow");
                            input.nextLine(); // to remove "ENTER" key buffer
                            choiceB = 0;
                            continue;
                        }
                        switch (choiceB) {
                            case 1:
                                PrimeNumbers();
                                choiceB = 0; // loop back to submenu B
                                System.out.print(BRIGHT_WHITE + "\nPress Enter to return to Secondary School Menu:");
                                input.nextLine(); // to remove "ENTER" key buffer
                                clearScreen();
                                break;
                            case 2:
                                StepByStepExpression();
                                choiceB = 0; // loop back to submenu B
                                System.out.print(BRIGHT_WHITE + "\nPress Enter to return to Secondary School Menu:");
                                input.nextLine(); // to remove "ENTER" key buffer
                                clearScreen();
                                break;
                            case 3:
                                letter = 'j'; // loop back to main menu
                                clearScreen();
                                break;
                            default:
                                clearScreen();
                                System.out.println("Invalid choice. Try again!\n");
                        }
                    } while (choiceB > 3 || choiceB < 1);
                    break;
                case 'c':
                    clearScreen();
                    short choiceC = 0;
                    do
                    {
                        PrintSubmenuC();
                        try
                        {
                            choiceC = input.nextShort();
                            input.nextLine(); // to remove "ENTER" key buffer
                        }
                        catch (InputMismatchException ex) // to handle overflow/underflow
                        {
                            System.out.println("Input generated Overflow/Underflow");
                            input.nextLine(); // to remove "ENTER" key buffer
                            choiceC = 0;
                            continue;
                        }
                        switch (choiceC) {
                            case 1:
                                StatisticalArray();
                                choiceC = 0; // loop back to submenu C
                                System.out.print(BRIGHT_WHITE + "\nPress Enter to return to High School Menu:");
                                input.nextLine(); // to remove "ENTER" key buffer
                                clearScreen();
                                break;
                            case 2:
                                TwoArraysDistance();
                                choiceC = 0; // loop back to submenu C
                                System.out.print(BRIGHT_WHITE + "\nPress Enter to return to High School Menu:");
                                input.nextLine(); // to remove "ENTER" key buffer
                                clearScreen();
                                break;
                            case 3:
                                letter = 'j'; // loop back to main menu
                                clearScreen();
                                break;
                            default:
                                clearScreen();
                                System.out.println("Invalid choice. Try again!\n");
                        }
                    } while (choiceC > 3 || choiceC < 1);
                    break;
                case 'd':
                    clearScreen();
                    SubmenuD_ConnectFour();
                    letter = 'j'; // loop back to main menu
                    clearScreen();
                    break;
                case 'e':
                    System.out.println("You chose to exit the program.");
                    break;
                default:
                    clearScreen();
                    System.out.println("\nYou entered an invalid choice. Try again!\n");
            }
        } while (!ValidSubmenu(letter));

    }
}




