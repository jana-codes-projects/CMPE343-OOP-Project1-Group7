import java.util.Arrays;
import java.util.Scanner;

public class Main {

    // Displays a welcome screen of the project
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

    // Displays Main Menu
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
    }

    /*--------------------------------------------------SubMenu A: ----------------------------------------------------------*/

    public class PrimarySchoolMenu {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean exitSubMenu = false;

        while (!exitSubMenu) {
            System.out.println("\n=== Primary School Menu ===");
            System.out.println("1) Age and Zodiac Sign Detection");
            System.out.println("2) Reverse the Words");
            System.out.println("3) Return to Main Menu");
            System.out.print("Please select an option: ");

            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("\n--- Age and Zodiac Sign Detection ---");
                    AgeAndZodiac.main(null);
                    break;
                case 2:
                    System.out.println("\n--- Reverse the Words ---");
                    ReverseWords.main(null);
                    break;
                case 3:
                    System.out.println("\nReturning to Main Menu...");
                    exitSubMenu = true;
                    break;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }

        input.close();
    }
}

    /*--------------------------------------------------SubMenu A Part 1: ----------------------------------------------------------*/

public class AgeAndZodiac {

    //Static Array for Keeping Track of the Number of Days in Each Month
    static int[] daysInMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };


    //function that takes a date from the user and displays the result
    public static void runAgeAndZodiac() {
        Scanner input = new Scanner(System.in);

        System.out.println("=== Age and Zodiac Sign Detection ===");

        System.out.print("Enter day of birth: ");
        int birthDay = input.nextInt();
        System.out.print("Enter month of birth: ");
        int birthMonth = input.nextInt();
        System.out.print("Enter year of birth: ");
        int birthYear = input.nextInt();

        int currentDay, currentMonth, currentYear;

        //User Date Retrieval and Confirmation Loop
        while (true) {
            System.out.print("Enter current day: ");
            currentDay = input.nextInt();
            System.out.print("Enter current month: ");
            currentMonth = input.nextInt();
            System.out.print("Enter current year: ");
            currentYear = input.nextInt();

            input.nextLine();

            System.out.println("You entered current date as: " + currentDay + "/" + currentMonth + "/" + currentYear);
            System.out.print("Is this correct? (Y/N): ");
            String confirm = input.nextLine().trim().toUpperCase();

            if (confirm.equals("Y")) {
                break;
            } else {
                System.out.println("Please enter the correct current date again.");
            }
        }

        int[] age = calculateAge(birthDay, birthMonth, birthYear, currentDay, currentMonth, currentYear);
        System.out.println("\nYour Age: " + age[0] + " years, " + age[1] + " months, " + age[2] + " days");

        String zodiac = calculateZodiac(birthDay, birthMonth);
        System.out.println("Your Zodiac Sign: " + zodiac);

        System.out.println("\n(Press Enter to return to Submenu A)");
        input.nextLine();

    }

    //Function Calculating Age Based on Date of Birth
    public static int[] calculateAge(int birthDay, int birthMonth, int birthYear, int currentDay, int currentMonth, int currentYear) {
        if (birthDay > currentDay) {
            currentDay += daysInMonth[currentMonth - 2 < 0 ? 11 : currentMonth - 2];
            currentMonth -= 1;
        }

        if (birthMonth > currentMonth) {
            currentYear -= 1;
            currentMonth += 12;
        }

        int calculatedDay = currentDay - birthDay;
        int calculatedMonth = currentMonth - birthMonth;
        int calculatedYear = currentYear - birthYear;

        return new int[] { calculatedYear, calculatedMonth, calculatedDay };
    }

    //Function Calculating Zodiac Sign Based on Date of Birth
    public static String calculateZodiac(int day, int month) {
        String zodiac = "";

        if ((month == 1 && day >= 20) || (month == 2 && day <= 18)) zodiac = "Aquarius";
        else if ((month == 2 && day >= 19) || (month == 3 && day <= 20)) zodiac = "Pisces";
        else if ((month == 3 && day >= 21) || (month == 4 && day <= 19)) zodiac = "Aries";
        else if ((month == 4 && day >= 20) || (month == 5 && day <= 20)) zodiac = "Taurus";
        else if ((month == 5 && day >= 21) || (month == 6 && day <= 20)) zodiac = "Gemini";
        else if ((month == 6 && day >= 21) || (month == 7 && day <= 22)) zodiac = "Cancer";
        else if ((month == 7 && day >= 23) || (month == 8 && day <= 22)) zodiac = "Leo";
        else if ((month == 8 && day >= 23) || (month == 9 && day <= 22)) zodiac = "Virgo";
        else if ((month == 9 && day >= 23) || (month == 10 && day <= 22)) zodiac = "Libra";
        else if ((month == 10 && day >= 23) || (month == 11 && day <= 21)) zodiac = "Scorpio";
        else if ((month == 11 && day >= 22) || (month == 12 && day <= 21)) zodiac = "Sagittarius";
        else if ((month == 12 && day >= 22) || (month == 1 && day <= 19)) zodiac = "Capricorn";

        return zodiac;
    }
}

    /*--------------------------------------------------SubMenu A Part 2: ----------------------------------------------------------*/
public class ReverseWords {

    public static void main(String[] args) {
        runReverseWords();
    }

    //input and output
    public static void runReverseWords() {
        Scanner input = new Scanner(System.in);
        System.out.println("=== Reverse the Words ===");
        System.out.println("Enter your sentence:");
        String sentence = input.nextLine();

        String reversed = reverseSentence(sentence);
        System.out.println("\nReversed Sentence:");
        System.out.println(reversed);

        System.out.println("\n(Press Enter to return to Submenu A)");
        input.nextLine();
    }

    //Recursive Function That Reverses a Sentence Word by Word
    public static String reverseSentence(String sentence) {
        if (sentence.isEmpty()) return "";

        int spaceIndex = sentence.indexOf(' ');
        if (spaceIndex == -1) return reverseWord(sentence);

        String firstWord = sentence.substring(0, spaceIndex);
        String rest = sentence.substring(spaceIndex + 1);
        return reverseWord(firstWord) + " " + reverseSentence(rest);
    }

    //Single Word Reversal Function
    public static String reverseWord(String word) {
        if (word.length() < 2) return word;
        return reverseWordRecursive(word, 0, word.length() - 1);
    }

    //Function to Recursively Reverse the Letters in a Word
    private static String reverseWordRecursive(String word, int left, int right) {
        char[] chars = word.toCharArray();

        if (left >= right) return new String(chars);

        if (Character.isLetter(chars[left]) && Character.isLetter(chars[right])) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            return reverseWordRecursive(new String(chars), left + 1, right - 1);
        } else if (!Character.isLetter(chars[left])) {
            return reverseWordRecursive(word, left + 1, right);
        } else {
            return reverseWordRecursive(word, left, right - 1);
        }
    }
}


    // Displays Submenu (Option) C 
    public static void PrintSubmenuC()
    {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~ SUBMENU C ~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("[1] Statistical Information about an Array\n" +
                "[2] Distance between Two Arrays\n" +
                "[3] Return to Main Menu");
        System.out.print("Please select a number corresponding with your choice: ");
    }

    /*--------------------------------------------------SubMenu C: Part 1----------------------------------------------------*/
    public static void StatisticalArray()
    {
        int part = 1; // to display the correct message for GetArraySize Method
        int size = GetArraySize(part);
        double[] arr = new double[size];

        Scanner input = new Scanner(System.in);

        System.out.println("Proceed with entering " + size + " number(s): ");
        for (int i = 0; i < size; i++)
        {
            arr[i] = input.nextDouble();
            input.nextLine(); // to remove "ENTER" key buffer
        }

        DisplayArray(arr);
        double median = ArrayMedian(arr, size);
        double Arithmetic_mean = ArithmeticMean(arr, size);
        double Geo_mean = GeometricMean(arr, size);
        double Harmonic_mean = HarmonicMean(arr, size);

        System.out.println("The median of the array is: " + median);
        System.out.println("The arithmetic mean of the array is: " + Arithmetic_mean);
        System.out.println("The geometric mean of the array is: " + Geo_mean);
        System.out.println("The harmonic mean of the array is: " + Harmonic_mean);
    }

    // Asks user for array size and checks if the input is valid
    public static int GetArraySize(int i)
    {
        int size = 0;
        Scanner input = new Scanner(System.in);
        do {
            if (i == 1)
                System.out.print("\nEnter the size of the array: ");
            else
                System.out.print("\nEnter the dimension of the two arrays: ");

            size = input.nextInt();
            input.nextLine(); // to remove "ENTER" key buffer
            if (size < 1)
                System.out.println("Invalid input!");
        } while (size < 1);
        return size;
    }

    // prints all the array of double elements to visualize
    public static void DisplayArray(double[] arr)
    {
        for (double element : arr)
            System.out.print(element + " ");
        System.out.println();
    }

    // sorts the array and returns the middle element or median of the array
    public static double ArrayMedian(double[] arr, int size)
    {
        double median = 0;
        // sort array to find middle element
        Arrays.sort(arr);

        if (size % 2 == 1) // when array size is odd
            median = arr[(size+1)/2 - 1];
        else // when array size is even
            median = (arr[size/2 - 1] + arr[size/2 + 1] - 1) / 2;
        return median;
    }

    // calculates and returns the arithmetic mean
    public static double ArithmeticMean(double[] arr, int size)
    {
        double avg = 0;
        for (double element : arr)
        {
            avg += element;
        }
        avg /= size;
        return avg;
    }

    // calculates and returns the geometric mean
    public static double GeometricMean(double[] arr, int size)
    {
        double avg = 1;
        for (double element : arr)
        {
            avg *= element;
        }

        avg = Math.pow(avg, (double)1/size);
        return avg;
    }

    // calls private recursive function to calculate the harmonic mean and returns its value
    public static double HarmonicMean(double[] arr, int size)
    {
        double sumReciprocals = harmonicHelper(arr, size, 0);
        return size / sumReciprocals;
    }

    // private recursive function which calculates the harmonic mean
    private static double harmonicHelper(double[] arr, int size, int index)
    {
        if (index == size) {
            return 0;
        }

        double current = arr[index];
        if (current == 0) {
            System.out.println("This element is zero, so it is skipped to avoid a zero divisor.");
            return harmonicHelper(arr, size, index + 1);
        }

        return (1.0 / current) + harmonicHelper(arr, size, index + 1);
    }

    /*--------------------------------------------------SubMenu C: Part 2----------------------------------------------------*/
    public static void TwoArraysDistance()
    {
        int part = 2; // to display the correct message for GetArraySize Method
        int size = GetArraySize(part);
        short[] arr1 = new short[size];
        short[] arr2 = new short[size];


        System.out.println("Proceed with entering " + size + " number(s) for the first array (integers 0 to 9): ");
        GetArrayElements(arr1, size);

        System.out.println("Proceed with entering " + size + " number(s) for the second array (integers 0 to 9): ");
        GetArrayElements(arr2, size);

        DisplayArray(arr1);
        DisplayArray(arr2);

        int manhattan_distance = ManhattanDistance(arr1, arr2, size);
        double euclidean_distance = EuclideanDistance(arr1, arr2, size);
        double cosine_similarity = CosineSimilarity(arr1, arr2, size);

        System.out.println("The manhattan distance of the two arrays is: " + manhattan_distance);
        System.out.println("The euclidean distance of the two arrays is: " + euclidean_distance);
        System.out.println("The cosine similarity of the two arrays is: " + cosine_similarity);

    }

    // prints all the array of integers 0 to 9 elements to visualize
    static public void DisplayArray(short[] arr)
    {
        for (short element : arr)
            System.out.print(element + " ");
        System.out.println();
    }

    // Asks user for array elements as input and checks if they are valid integers 0 to 9
    public static void GetArrayElements(short[] arr, int size)
    {
        Scanner input = new Scanner(System.in);

        for (int i = 0; i < size; i++)
        {
            arr[i] = input.nextShort();
            if (arr[i] > 9 || arr[i] < 0)
            {
                System.out.println("Invalid input. Try again! (integers 0 to 9)");
                i--;
            }
            input.nextLine(); // to remove "ENTER" key buffer
        }
    }

    // calculates and returns Manhattan distance of the two arrays
    public static int ManhattanDistance(short[] a1, short[] a2, int size)
    {
        int ans = 0;
        for (int i = 0; i < size; i++)
        {
            ans += Math.abs(a1[i] - a2[i]);
        }
        return ans;
    }

    // calculates and returns Euclidean distance of the two arrays
    public static double EuclideanDistance(short[] a1, short[] a2, int size)
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
    public static double CosineSimilarity(short[] a1, short[] a2, int size)
    {
        double ans = 0;
        int dotProduct = 0;
        int prod1 = 0;
        int prod2 = 0;
        for (int i = 0; i < size; i++)
        {
            dotProduct += a1[i]*a2[i];
            prod1 += (int)Math.pow(a1[i], 2);
            prod2 += (int)Math.pow(a2[i], 2);
        }
        // to eliminate divisor being 0 if both elements are 0
        if (prod1 == 0 || prod2 == 0)
        {
            System.out.println("Divisor was zero!");
            return 0;
        }
        ans = (double)dotProduct/Math.sqrt(prod1*prod2);
        return ans;
    }

    /*--------------------------------------------------MAIN FUNCTION----------------------------------------------------*/
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
                    boolean exitSubMenuA = false;//activation control

                    //receiving user input 
                    while(!exitSubMenuA) {
                        System.out.println("\n=== Primary School Menu ===");
                        System.out.println("1) Age and Zodiac Sign Detection");
                        System.out.println("2) Reverse the Words");
                        System.out.println("3) Return to Main Menu");
                        System.out.print("Please select an option: ");

                        String line = input.nextLine();
                        int submenuChoice = 0;

                        try {
                            submenuChoice = Integer.parseInt(line);
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input! Please enter a number.");
                            continue;
                        }

                        //submenu screen
                        switch(submenuChoice) {
                            case 1:
                                AgeAndZodiac.runAgeAndZodiac();
                                break;
                            case 2:
                                ReverseWords.runReverseWords();
                                break;
                            case 3:
                                exitSubMenuA = true;//activation true 
                                letter = ' ';
                                break;
                            default:
                                System.out.println("Invalid option! Try again.");
                        }
                    }
                    break;
                case 'b':
                    System.out.println("Display Submenu B\n");
                    break;
                case 'c':
                    System.out.println("\nCLEAR CONSOLE");
                    clearScreen(); // IntelliJ does not have a way to clear console with code
                    short choice = 0;
                    do {
                        PrintSubmenuC();
                        choice = input.nextShort();
                        input.nextLine(); // to remove "ENTER" key buffer
                        switch (choice) {
                            case 1:
                                StatisticalArray();
                                break;
                            case 2:
                                TwoArraysDistance();
                                break;
                            case 3:
                                letter = 'j'; // loop back to main menu
                                System.out.println();
                                break;
                            default:
                                System.out.println("Invalid choice. Try again!\n");

                        }
                    } while (choice > 3 || choice < 1);
                    break;
                case 'd':
                    System.out.println("Display Connect Four Game\n");
                    break;
                case 'e':
                    System.out.println("You chose to exit the program.");
                    break;
                default:
                    System.out.println("\nYou entered an invalid choice. Try again!\n");
            }
        } while (!ValidSubmenu(letter));

    }
}
