import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static final int MAX_ARRAY_SIZE = 10_000_000; // arbitrary safety cap for arrays

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

        System.out.println("Proceed with entering " + size + " number(s) (accepts double values): ");
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
    public static int GetArraySize(int i)
    {
        int size = 0;
        Scanner input = new Scanner(System.in);
        do {
            if (i == 1)
                System.out.print("\nEnter the size of the array: ");
            else
                System.out.print("\nEnter the dimension of the two arrays: ");

            try {
                size = input.nextInt();
                input.nextLine(); // to remove "ENTER" key buffer
            } catch (InputMismatchException ex) { // to handle overflow/underflow
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
            median = arr[((size+1)/2) - 1];
        else // when array size is even
            median = (arr[(size/2) - 1] + arr[size/2]) / 2.0;
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
        avg /= size; // input size will never be 0 or negative so this is okay
        return avg;
    }

    // calculates and returns the geometric mean
    public static double GeometricMean(double[] arr, int size)
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
    public static double HarmonicMean(double[] arr, int size)
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


        System.out.println("Proceed with entering " + size + " number(s) for the first array (integers 0 to 9): ");
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
        System.out.printf("The Euclidean Distance of the two arrays is: %.3f", euclidean_distance);
        System.out.printf("The Cosine Similarity of the two arrays is: %.3f", cosine_similarity);
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
            while (true) {
                System.out.print("Element " + (i+1) + ": "); // to track which element is being asked
                try {
                    short val = input.nextShort();
                    input.nextLine(); // to remove "ENTER" key buffer
                    if (val > 9 || val < 0) {
                        System.out.println("Invalid input. Try again! (integers 0 to 9)");
                        continue;
                    }
                    arr[i] = val;
                    break;
                } catch (InputMismatchException ex) { // to handle overflow/underflow
                    System.out.println("Input generated Overflow/Underflow. Try again! (integers 0 to 9)");
                    input.nextLine(); // to remove "ENTER" key buffer
                }
            }
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
                    System.out.println("\nCLEAR CONSOLE");
                    clearScreen();
                    System.out.println("Display Submenu A\n");
                    break;
                case 'b':
                    System.out.println("\nCLEAR CONSOLE");
                    clearScreen();
                    System.out.println("Display Submenu B\n");
                    break;
                case 'c':
                    System.out.println("\nCLEAR CONSOLE");
                    clearScreen(); // IntelliJ does not have a way to clear console with code
                    short choice = 0;
                    do {
                        PrintSubmenuC();
                        try {
                            choice = input.nextShort();
                            input.nextLine(); // to remove "ENTER" key buffer
                        } catch (InputMismatchException ex) { // to handle overflow/underflow
                            System.out.println("Input generated Overflow/Underflow");
                            input.nextLine(); // to remove "ENTER" key buffer
                            choice = -1;
                            continue;
                        }
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
                    System.out.println("\nCLEAR CONSOLE");
                    clearScreen();
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

