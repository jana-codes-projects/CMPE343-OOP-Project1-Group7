import java.util.Arrays;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;
import java.util.List;
import java.util.Date;
import java.util.Calendar;

/**
 * Main class for Group 7 OOP Project.
 * Contains all menus, games, and utilities for the program.
 */
public class Group7
{
    private static final int MAX_USER_INPUT = 60_000; // for safety array size
    private static final double CONVERT_NANO_TO_MILLISECOND = 1_000_000.0;

    /**
     * Displays a welcome screen of the project.
     * <p>
     * Prints a colorful ASCII art welcome banner with group information and
     * project title using ANSI color codes.
     * </p>
     */
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

    /**
     * Displays the main menu options on the console.
     * <p>
     * Shows submenu choices for different school levels and an option to terminate
     * the program. Prompts the user to select an option by entering a letter.
     * </p>
     */
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

    /**
     * Checks if the given character represents a valid submenu choice.
     *
     * @param c the user input character to validate
     * @return {@code true} if the character is one of 'a', 'b', 'c', 'd', or 'e';
     *         {@code false} otherwise
     */
    public static boolean ValidSubmenu(char c)
    {
        if (c == 'a' || c == 'b' || c == 'c' || c == 'd' || c == 'e')
            return true;
        return false;
    }

    /**
     * Attempts to clear the console screen.
     * <p>
     * This method prints ANSI escape codes and several blank lines to simulate
     * clearing the terminal window for better readability between sections.
     * </p>
     */
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

    /**
     * Displays a "THANK YOU" ASCII art message at the end of the program.
     */
    public static void ThankYouScreen() 
    {
        // ANSI color codes
        final String RESET = "\u001B[0m";
        final String YELLOW = "\u001B[93m";
        final String RED = "\u001B[91m";
        final String BRIGHT_WHITE = "\u001B[97m";


        System.out.println(YELLOW +
                           "╔═══════════════════════════════════════════════════════════════════╗");
        System.out.println("║                                                                   ║");
        System.out.println("║  " + RED + "TTTTTTTT  H   H  AAAAA  N   N  K   K       Y   Y  OOOO  U   U" + YELLOW + "    ║");
        System.out.println("║  " + RED + "   TT     H   H  A   A  NN  N  K  K         Y Y  O    O U   U" + YELLOW + "    ║");
        System.out.println("║  " + RED + "   TT     HHHHH  AAAAA  N N N  KKK           Y   O    O U   U" + YELLOW + "    ║");
        System.out.println("║  " + RED + "   TT     H   H  A   A  N  NN  K  K          Y   O    O U   U" + YELLOW + "    ║");
        System.out.println("║  " + RED + "   TT     H   H  A   A  N   N  K   K         Y    OOOO   UUU" + YELLOW + "     ║");
        System.out.println("║                                                                   ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════════╝" + RESET);

        System.out.println(BRIGHT_WHITE + "\n★ THANK YOU FOR USING OUR PROGRAM ★" + RESET);
        System.out.println(BRIGHT_WHITE + "\n      We hope you enjoyed it!" + RESET);
        System.out.println(RED + "\n>>> GROUP 7 - OOP PROJECT 2025 <<<\n" + RESET);
    }
    
    /*--------------------------------------------------SubMenu Displays----------------------------------------------------*/

    /**
     * Displays Submenu (Option) A for the Primary School section.
     * <p>
     * Prints submenu options for Primary School, including:
     * <ul>
     *   <li>Age and Zodiac Sign Detection</li>
     *   <li>Reverse the Words</li>
     *   <li>Return to Main Menu</li>
     * </ul>
     * Prompts the user to select one of the options.
     * </p>
     */
    public static void PrintSubmenuA()
    {
        final String BRIGHT_PURPLE = "\u001B[95m";

        System.out.println(BRIGHT_PURPLE + "~~~~~~~~~~~~~~~~~~~~~~~~~~ Primary School Menu ~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("[1] Age and Zodiac Sign Detection");
        System.out.println("[2] Reverse the Words");
        System.out.println("[3] Return to Main Menu");
        System.out.print("Please select an option: ");
    }

    /**
     * Displays Submenu (Option) B for the Secondary School section.
     * <p>
     * Prints submenu options for Secondary School, including:
     * <ul>
     *   <li>Prime Numbers</li>
     *   <li>Step-by-step Evaluation of Expression</li>
     *   <li>Return to Main Menu</li>
     * </ul>
     * Prompts the user to select a number corresponding to their choice.
     * </p>
     */
    public static void PrintSubmenuB()
    {
        final String CYAN = "\u001B[36m";

        System.out.println(CYAN + "~~~~~~~~~~~~~~~~~~~~~~~~~~ Secondary School Menu ~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("[1] Prime Numbers");
        System.out.println("[2] Step-by-step Evaluation of Expression");
        System.out.println("[3] Return to Main Menu");
        System.out.print("Please select a number corresponding with your choice: ");
    }

    /**
     * Displays Submenu (Option) C for the High School section.
     * <p>
     * Prints submenu options for High School, including:
     * <ul>
     *   <li>Statistical Information about an Array</li>
     *   <li>Distance between Two Arrays</li>
     *   <li>Return to Main Menu</li>
     * </ul>
     * Prompts the user to select a number corresponding to their choice.
     * </p>
     */
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

    /**
     * Calculates and displays the user's age and zodiac sign.
     * <p>
     * Prompts the user to enter their birth date (day, month, year), validates the date,
     * and then computes their current age based on the system date. It also determines
     * the user's zodiac sign based on their birth date.
     * </p>
     */
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

    /**
     * Prompts the user to enter the day of birth and validates the input.
     *
     * @return the valid day of birth (1–31)
     */
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

    /**
     * Prompts the user to enter the month of birth and validates the input.
     *
     * @return the valid month of birth (1–12)
     */
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

    /**
     * Prompts the user to enter the year of birth and validates the input.
     *
     * @param CurrentYear the current year, used to ensure the birth year is valid
     * @return the valid birth year (must be less than or equal to the current year)
     */
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

    /**
     * Validates whether a given date is legitimate.
     * <p>
     * Considers the number of days in each month and adjusts for leap years.
     * </p>
     *
     * @param day the day of the month
     * @param month the month (1–12)
     * @param year the year
     * @param daysInMonth array representing the number of days in each month
     * @return {@code true} if the date is valid; {@code false} otherwise
     */
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

    /**
     * Calculates the user's age based on birth date and current date.
     *
     * @param birthDay day of birth
     * @param birthMonth month of birth
     * @param birthYear year of birth
     * @param currentDay current day
     * @param currentMonth current month
     * @param currentYear current year
     * @param daysInMonth array containing number of days per month
     * @return an integer array containing {years, months, days} of age
     */
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

    /**
     * Determines the zodiac sign based on the user's birth day and month.
     *
     * @param day the day of birth
     * @param month the month of birth
     * @return the zodiac sign as a string (e.g., "Aries", "Taurus")
     */
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

    /**
     * Prompts the user to enter a sentence and displays the sentence
     * with each word reversed.
     * <p>
     * This method takes user input, calls the {@code reverseSentence()} method
     * to reverse each word in the sentence recursively, and prints the result.
     * </p>
     */
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

    /**
     * Recursively reverses a sentence word by word.
     * <p>
     * Splits the sentence at the first space, reverses the first word using
     * {@code reverseWord()}, and then recursively processes the rest of the sentence.
     * </p>
     *
     * @param sentence the sentence to reverse
     * @return a new string where each word in the sentence is reversed
     */
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

    /**
     * Reverses a single word by calling a recursive helper function.
     * <p>
     * If the word length is less than 2, it returns the word unchanged.
     * Otherwise, it calls {@code reverseWordRecursive()} to reverse
     * the characters in the word.
     * </p>
     *
     * @param word the word to reverse
     * @return the reversed word
     */
    private static String reverseWord(String word)
    {
        if (word.length() < 2)
            return word;
        return reverseWordRecursive(word, 0, word.length() - 1);
    }

    /**
     * Recursively reverses the characters in a word.
     * <p>
     * Swaps letters from both ends of the word until the middle is reached.
     * Non-letter characters are skipped and remain in place.
     * </p>
     *
     * @param word  the word to reverse
     * @param left  the current left index
     * @param right the current right index
     * @return the word with its letters reversed
     */
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

    /**
     * Prompts the user for an integer n (n ≥ 12) and compares three different
     * prime number generation algorithms: Eratosthenes, Sundaram, and Atkin.
     * <p>
     * For each algorithm, the method:
     * <ul>
     *   <li>Generates all prime numbers up to n</li>
     *   <li>Displays the total count of primes found</li>
     *   <li>Prints the first 3 and last 2 prime numbers</li>
     *   <li>Measures and compares execution time</li>
     * </ul>
     * Handles invalid, small, and excessively large inputs with appropriate messages.
     * </p>
     */
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
            else if (n > MAX_ARRAY_SIZE)
                System.out.println("Input too large! Limit is " + MAX_ARRAY_SIZE);

        } while (n < 12 || n > MAX_ARRAY_SIZE);

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

    /**
     * Implements the Sieve of Eratosthenes algorithm for finding all prime numbers up to n.
     * <p>
     * Marks multiples of each prime as non-prime, starting from 2.
     * </p>
     *
     * @param n the upper limit for prime number generation
     * @return a boolean array where {@code true} indicates a prime number
     */
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

    /**
     * Implements the Sieve of Sundaram algorithm for generating prime numbers up to n.
     * <p>
     * Eliminates numbers of the form i + j + 2ij and maps remaining values
     * to primes using the formula 2i + 1.
     * </p>
     *
     * @param n the upper limit for prime number generation
     * @return a boolean array where {@code true} indicates a prime number
     */
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

    /**
     * Implements the Sieve of Atkin algorithm for generating prime numbers up to n.
     * <p>
     * Uses quadratic forms to identify prime candidates and eliminates composites.
     * </p>
     *
     * @param n the upper limit for prime number generation
     * @return a boolean array where {@code true} indicates a prime number
     */
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

    /**
     * Prompts the user to enter an arithmetic expression, validates it, and then
     * evaluates it step-by-step using recursion.
     * <p>
     * If the expression is invalid, the user is asked to re-enter it. The evaluation
     * process prints each simplification step to the console.
     */
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

    /**
     * Validates whether a given arithmetic expression is correctly formatted.
     * <p>
     * The method checks for:
     * <ul>
     *   <li>Empty expressions</li>
     *   <li>Invalid characters (only digits, '+', '-', 'x', ':', and parentheses are allowed)</li>
     *   <li>Mismatched or unbalanced parentheses</li>
     *   <li>Consecutive operators (e.g., "++", "x:")</li>
     *   <li>Empty parentheses (e.g., "()")</li>
     *   <li>Invalid starting or ending characters (e.g., "+3", "3x")</li>
     * </ul>
     *
     * @param expr the arithmetic expression entered by the user
     * @return {@code true} if the expression is valid; {@code false} otherwise
     */
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

    /**
     * Recursively evaluates a mathematical expression step-by-step while respecting operator precedence
     * and parentheses. Each recursive call simplifies one layer of the expression.
     * <p>
     * The method supports the following operations:
     * <ul>
     *   <li>Addition (+)</li>
     *   <li>Subtraction (-)</li>
     *   <li>Multiplication (x)</li>
     *   <li>Division (:)</li>
     * </ul>
     * Parentheses are evaluated first. Each simplification step can be printed
     * if the {@code printSteps} flag is set to {@code true}.
     *
     * @param expr the arithmetic expression to evaluate
     * @param printSteps if {@code true}, prints each step of the evaluation
     * @return the simplified or fully evaluated expression as a {@code String}
     * @throws ArithmeticException if division by zero occurs
     */
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


    /*--------------------------------------------------SubMenu C: Part 1----------------------------------------------------*/

    /**
     * Prompts the user to enter an array of double values and then calculates and displays
     * the median, arithmetic mean, geometric mean, and harmonic mean of the array.
     * <p>
     * The method handles invalid or overflow inputs, computes each statistical measure,
     * and prints the results with appropriate explanations.
     */
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

    /**
     * Prompts the user to enter a valid array size and performs validation on the input.
     * Ensures the size is at least 1 and does not exceed the predefined maximum.
     *
     * @param i an integer used to determine which prompt message to display (1 for array size, otherwise for dimensions)
     * @return a valid integer representing the array size
     */
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
            else if (size > MAX_ARRAY_SIZE)
            {
                System.out.println("Requested size is too large; limit is " + MAX_ARRAY_SIZE + ".");
                size = 0;
            }

        } while (size < 1);
        return size;
    }

    /**
     * Prints all elements of an array of type double separated by spaces.
     *
     * @param arr the array of double values to be displayed
     */
    private static void DisplayArray(double[] arr)
    {
        for (double element : arr)
            System.out.print(element + " ");
        System.out.println();
    }

    /**
     * Sorts the array and returns its median value.
     *
     * @param arr  the array of double values
     * @param size the size of the array
     * @return the median value of the sorted array
     */
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

    /**
     * Calculates and returns the arithmetic mean of the given array.
     *
     * @param arr  the array of double values
     * @param size the size of the array
     * @return the arithmetic mean of the array elements
     */
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

    /**
     * Calculates and returns the geometric mean of the given array.
     * <p>
     * Returns 0 if any element is zero, and NaN if the product is negative
     * (i.e., when an odd number of elements are negative).
     *
     * @param arr  the array of double values
     * @param size the size of the array
     * @return the geometric mean of the array elements, or NaN if undefined
     */
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

    /**
     * Calculates the harmonic mean of the array by calling a recursive helper function.
     *
     * @param arr  the array of double values
     * @param size the size of the array
     * @return the harmonic mean of the array elements
     */
    private static double HarmonicMean(double[] arr, int size)
    {
        double sumReciprocals = harmonicHelper(arr, size, 0);
        if (sumReciprocals == 0)
            return 0.0;
        return size / sumReciprocals;
    }

    /**
     * Recursively computes the sum of reciprocals of array elements to help calculate the harmonic mean.
     * Skips elements that are zero to avoid division by zero errors.
     *
     * @param arr   the array of double values
     * @param size  the size of the array
     * @param index the current index in the recursive traversal
     * @return the sum of reciprocals of non-zero elements
     */
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

    /**
     * Prompts the user to enter two arrays of equal size (integers between 0 and 9),
     * then calculates and displays the Manhattan distance, Euclidean distance,
     * and Cosine similarity between them.
     * <p>
     * The method validates all user inputs and ensures both arrays have the same dimension.
     */
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

    /**
     * Displays the elements of an array of type short separated by spaces.
     *
     * @param arr the array of short integers (expected range 0–9)
     */
    private static void DisplayArray(short[] arr)
    {
        for (short element : arr)
            System.out.print(element + " ");
        System.out.println();
    }

    /**
     * Prompts the user to input valid short integer elements (0–9) into the given array.
     * Re-prompts until all entries are valid, handling invalid, overflow, and underflow inputs.
     *
     * @param arr  the array to populate with user input
     * @param size the number of elements to read
     */
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

    /**
     * Calculates the Manhattan distance between two arrays.
     * <p>
     * Manhattan distance is defined as the sum of the absolute differences
     * between corresponding elements.
     *
     * @param a1   the first array
     * @param a2   the second array
     * @param size the size of both arrays
     * @return the Manhattan distance as an integer
     */
    private static int ManhattanDistance(short[] a1, short[] a2, int size)
    {
        int ans = 0;
        for (int i = 0; i < size; i++)
        {
            ans += Math.abs(a1[i] - a2[i]);
        }
        return ans;
    }

    /**
     * Calculates the Euclidean distance between two arrays.
     * <p>
     * Euclidean distance is defined as the square root of the sum of squared differences
     * between corresponding elements.
     *
     * @param a1   the first array
     * @param a2   the second array
     * @param size the size of both arrays
     * @return the Euclidean distance as a double
     */
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

    /**
     * Calculates the Cosine similarity between two arrays.
     * <p>
     * Cosine similarity is defined as the dot product of the vectors divided by
     * the product of their magnitudes. Returns 0 if either array has a magnitude of zero.
     *
     * @param a1   the first array
     * @param a2   the second array
     * @param size the size of both arrays
     * @return the Cosine similarity as a double in the range [-1, 1], or 0 if undefined
     */
    private static double CosineSimilarity(short[] a1, short[] a2, int size)
    {
        double ans = 0;
        int dotProduct = 0;
        int prod1 = 0;
        int prod2 = 0;
        for (int i = 0; i < size; i++)
        {
            dotProduct += a1[i]*a2[i];
            prod1 += Math.powExact(a1[i], 2);
            prod2 += Math.powExact(a2[i], 2);
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

    /**
     * Represents the available game modes for Connect Four.
     * <p>
     * The game supports two modes:
     * <ul>
     *   <li>{@link #PVP} — Player vs. Player (two human players)</li>
     *   <li>{@link #PVC_RANDOM} — Player vs. Computer with random move selection</li>
     * </ul>
     */
    enum Mode
    {
        PVP, PVC_RANDOM
    }

    /**
     * Creates and initializes a new Connect Four board with the given number of rows and columns.
     * <p>
     * Each cell of the board is initially set to 0, where:
     * <ul>
     *   <li>0 = empty cell</li>
     *   <li>1 = Player 1's piece</li>
     *   <li>2 = Player 2's piece</li>
     * </ul>
     *
     * @param rows the number of rows in the board
     * @param cols the number of columns in the board
     * @return a 2D integer array representing the empty game board
     */
    private static int[][] createBoard(int rows, int cols)
    {
        return new int[rows][cols]; // 0 empty, 1 P1, 2 P2
    }

    /**
     * Checks whether the specified column in the board is already full.
     * <p>
     * A column is considered full if its topmost cell (row 0) is not empty (i.e., not equal to 0).
     *
     * @param board the 2D game board array
     * @param c the column index to check
     * @return {@code true} if the column is full, {@code false} otherwise
     * @throws ArrayIndexOutOfBoundsException if the column index is invalid
     */
    private static boolean isColumnFull(int[][] board, int c)
    {
        return board[0][c] != 0;
    }

    /**
     * Attempts to drop a player's piece into the specified column on the board.
     * <p>
     * The function checks if the column index is valid and not full.
     * Starting from the bottom row, it finds the first empty cell (value 0)
     * and places the player's piece (1 or 2) there.
     *
     * @param board  the 2D array representing the game board, where 0 = empty, 1 = player 1, and 2 = player 2
     * @param c      the column index where the player wants to drop their piece
     * @param player the player number (1 or 2)
     * @return {@code true} if the piece was successfully placed; {@code false} if the column is invalid or full
     */
    private static boolean drop(int[][] board, int c, int player)
    {
        int rows = board.length;
        int cols = board[0].length;
        if (c < 0 || c >= cols || isColumnFull(board, c))
            return false;
        for (int r = rows - 1; r >= 0; r--)
        {
            if (board[r][c] == 0)
            {
                board[r][c] = player;
                return true;
            }
        }
        return false;
    }

    /**
     * Checks whether there are any valid moves left on the board.
     * <p>
     * The function iterates over all columns and returns {@code true}
     * if at least one column is not full (i.e., has an empty space).
     * Otherwise, it returns {@code false}, indicating that the game board
     * is completely filled and no further moves can be made.
     *
     * @param board the 2D array representing the game board
     * @return {@code true} if there is at least one available move; {@code false} if all columns are full
    */
    private static boolean hasMoves(int[][] board)
    {
        int cols = board[0].length;
        for (int c = 0; c < cols; c++)
            if (!isColumnFull(board, c))
                return true;
        return false;
    }

    /**
     * Prints the current state of the game board to the console.
     * <p>
     * The function first clears the screen and then displays the board
     * with its dimensions. Each cell is represented as:
     * <ul>
     *   <li><code>.</code> for an empty cell</li>
     *   <li><code>X</code> for player 1</li>
     *   <li><code>O</code> for player 2</li>
     * </ul>
     * At the bottom of the printed board, column numbers are shown to
     * guide the player for input selection.
     *
     * @param board the 2D array representing the game board
     */
    private static void printBoard(int[][] board)
    {
        Main.clearScreen();
        int rows = board.length;
        int cols = board[0].length;

        System.out.println();
        System.out.println("   CONNECT FOUR  (" + cols + "x" + rows + ")");
        System.out.println();
        for (int r = 0; r < rows; r++)
        {
            System.out.print("  |");
            for (int c = 0; c < cols; c++)
            {
                char ch = '.';
                if (board[r][c] == 1)
                    ch = 'X';
                if (board[r][c] == 2)
                    ch = 'O';
                System.out.print(" " + ch + " ");
            }
            System.out.println("|");
        }
        System.out.print("   ");

        for (int c = 0; c < cols; c++)
            System.out.print("---");
        System.out.println();
        System.out.print("    ");

        for (int c = 0; c < cols; c++)
            System.out.printf("%d  ", (c + 1));
        System.out.println("\n");
    }

    /**
     * Checks whether the given player has achieved a winning condition on the board.
     * <p>
     * A winning move occurs when the player has four consecutive pieces aligned
     * horizontally, vertically, or diagonally (either down-right or up-right).
     * <p>
     * The function scans all possible directions on the board to detect such a sequence.
     *
     * @param board  the 2D array representing the game board, where 0 = empty, 1 = player 1, and 2 = player 2
     * @param player the player number (1 or 2) to check for a winning condition
     * @return {@code true} if the player has four consecutive pieces in any direction; {@code false} otherwise
     */
    private static boolean isWinningMove(int[][] board, int player)
    {
        int rows = board.length;
        int cols = board[0].length;

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

    /**
     * Returns a list of all legal (available) column moves on the board.
     * <p>
     * The function iterates through all columns and adds the indices
     * of those that are not full, meaning a player can still drop a piece there.
     * This is typically used by AI decision logic or to validate player input.
     *
     * @param board the 2D array representing the game board
     * @return a list of column indices where a piece can legally be dropped
     */
    private static List<Integer> legalMoves(int[][] board)
    {
        int cols = board[0].length;
        List<Integer> moves = new ArrayList<>();
        for (int c = 0; c < cols; c++)
            if (!isColumnFull(board, c))
                moves.add(c);
        return moves;
    }

    /**
     * Selects a random legal column for the computer player.
     * <p>
     * The method gathers all legal moves via {@link #legalMoves(int[][])}
     * and returns one uniformly at random.
     *
     * @param board the 2D array representing the game board
     * @return the chosen column index (0-based) among the legal moves
     * @throws IllegalArgumentException if there are no legal moves available
     */
    private static int aiMoveRandom(int[][] board)
    {
        List<Integer> moves = legalMoves(board);
        Random rng = new Random();
        return moves.get(rng.nextInt(moves.size()));
    }

    /**
     * Runs the Connect Four submenu flow (board size selection, mode selection, and game loop).
     * <p>
     * Features:
     * <ul>
     *   <li>Board sizes: 5x4, 6x5, 7x6</li>
     *   <li>Modes: 2 Players (PvP) or Single Player vs. Random AI</li>
     *   <li>Human can forfeit by entering <code>q</code> on their turn</li>
     *   <li>Game ends on win or draw (full board)</li>
     * </ul>
     * The board uses <code>0</code> for empty, <code>1</code> for Player&nbsp;1 (X),
     * and <code>2</code> for Player&nbsp;2 (O).
     *
     * @implNote Uses helper methods such as {@link #askInt(Scanner, String, int, int)},
     * {@link #printBoard(int[][])}, {@link #hasMoves(int[][])}, {@link #isColumnFull(int[][], int)},
     * {@link #aiMoveRandom(int[][])}, {@link #drop(int[][], int, int)}, and
     * {@link #isWinningMove(int[][], int)}. Clears the screen via {@code Main.clearScreen()}.
     */
    static void SubmenuD_ConnectFour()
    {
        Scanner sc = new Scanner(System.in);
        final String BRIGHT_BLUE = "\u001B[94m";

        int[] cOpts = {5, 6, 7};
        int[] rOpts = {4, 5, 6};

        System.out.println(BRIGHT_BLUE + "~~~~~~~~~~~~~~~~~~~~~~~~~~ Connect Four Menu ~~~~~~~~~~~~~~~~~~~~~~~~~~");
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

        int[][] board = createBoard(rows, cols);
        int current = 1; // 1 = X (Player 1), 2 = O (Player 2/Computer)
        boolean humanIsP1 = true;

        while (true)
        {
            printBoard(board);
            if (!hasMoves(board))
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
                System.out.printf("Player %d (%s), choose a column (1-%d) or 'q' to forfeit: ", current, (current == 1 ? "X" : "O"), cols);
                String in = sc.nextLine().trim();
                if (in.equalsIgnoreCase("q"))
                {
                    printBoard(board);
                    System.out.printf("Player %d forfeited. The other player wins!\n", current);
                    break;
                }

                try
                {
                    int col = Integer.parseInt(in) - 1;
                    if (col < 0 || col >= cols || isColumnFull(board, col))
                    {
                        System.out.println("Invalid choice or the column is full. Try again.");
                        pause(sc);
                        continue;
                    }
                    moveCol = col;
                } catch (NumberFormatException e)
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
                moveCol = aiMoveRandom(board);
                sleep(300); // small delay for UX
            }

            // Apply move
            drop(board, moveCol, current);

            // Check win
            if (isWinningMove(board, current))
            {
                printBoard(board);
                if (mode == Mode.PVP || isHumansTurn)
                    System.out.printf("Congratulations! Player %d (%s) wins!\n", current, (current == 1 ? "X" : "O"));
                else
                    System.out.printf("Computer (%s) wins!\n", (current == 1 ? "X" : "O"));
                break;
            }

            // Next player
            current = (current == 1) ? 2 : 1;
        }

        System.out.println("\nGame over. Thanks for playing!");
        System.out.print("Press Enter to return to Main Menu...");
        sc.nextLine();
    }

    /**
     * Prompts the user for an integer within a closed interval and validates the input.
     *
     * @param sc     the scanner used to read input from the console
     * @param prompt the prompt message to display
     * @param min    the minimum accepted value (inclusive)
     * @param max    the maximum accepted value (inclusive)
     * @return the validated integer entered by the user in the range [min, max]
     */
    static int askInt(Scanner sc, String prompt, int min, int max)
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

    /**
     * Waits for the user to press Enter before continuing.
     *
     * @param sc the scanner used to read the newline from the console
     */
    static void pause(Scanner sc)
    {
        System.out.print("Press Enter to continue...");
        sc.nextLine();
    }

    /**
     * Pauses execution for the specified number of milliseconds.
     * <p>
     * This method wraps {@link Thread#sleep(long)} and ignores any {@link InterruptedException}.
     * It is primarily used in the Connect Four game to add a small delay when the computer
     * makes a move, improving the user experience by making the game feel more natural.
     *
     * @param ms the duration to sleep in milliseconds
     */
    static void sleep(long ms)
    {
        try
        {
            Thread.sleep(ms);
        } catch (InterruptedException ignored) {}
    }

    /*--------------------------------------------------MAIN FUNCTION----------------------------------------------------*/

    /**
     * Entry point of the program.
     * <p>
     * This method displays the welcome screen and the main menu, then handles
     * user interaction for all submenus, including:
     * <ul>
     *     <li>Primary School Menu (Submenu A): Age and Zodiac, Reverse Words</li>
     *     <li>Secondary School Menu (Submenu B): Prime Numbers, Step-by-Step Expression Evaluation</li>
     *     <li>High School Menu (Submenu C): Statistical Array, Two Arrays Distance</li>
     *     <li>Connect Four Menu (Submenu D): Play Connect Four game</li>
     * </ul>
     * The method loops continuously until the user chooses to exit.
     * <p>
     * User input is validated to handle invalid choices, overflow/underflow, and
     * attempts to enter text when numbers are expected.
     * Submenu options typically return to their menu after execution unless the
     * user chooses to go back to the main menu.
     * <p>
     * The method uses {@link #clearScreen()} to refresh the console for better UX,
     * and prompts the user to press Enter to continue between submenu executions.
     *
     * @param args command-line arguments (ignored in this program)
     */
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
                    clearScreen();
                    System.out.println("\nYou chose to exit the program.\n");
                    ThankYouScreen();
                    break;
                default:
                    clearScreen();
                    System.out.println("\nYou entered an invalid choice. Try again!\n");
            }
        } while (!ValidSubmenu(letter));

    }
    
}

