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
        int size = GetArraySize((short)0);
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

    public static int GetArraySize(short ith_array)
    {
        int size = 0;
        Scanner input = new Scanner(System.in);
        do {
            if (ith_array == 0)
                System.out.print("\nEnter the size of the array: ");
            else
                System.out.print("\nEnter the size of array " + ith_array + ": ");

            size = input.nextInt();
            input.nextLine(); // to remove "ENTER" key buffer
            if (size < 1)
                System.out.println("Invalid input!");
        } while (size < 1);
        return size;
    }

    static public void DisplayArray(double[] arr)
    {
        for (double element : arr)
            System.out.print(element + " ");
        System.out.println();
    }
    
    public static double ArrayMedian(double[] arr, int size) // NOT DONE
    {
        double median = 0;
        // sort array

        if (size % 2 == 1)
            median = arr[(size+1)/2 - 1];
        else
            median = (arr[size/2 - 1] + arr[size/2 + 1] - 1) / 2;
        return median;
    }

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

    public static double HarmonicMean(double[] arr, int size) // SHOULD BE DONE RECURSIVELY
    {
        double avg = 0;
        for (double element : arr)
        {
            avg += (double)1/element;
        }

        avg = size/avg;
        return avg;
    }

    /*--------------------------------------------------SubMenu C: Part 2----------------------------------------------------*/
    public static void TwoArraysDistance()
    {
        int size1 = GetArraySize((short)1);
        int size2 = GetArraySize((short)2);
        short[] arr1 = new short[size1];
        short[] arr2 = new short[size2];

        
        System.out.println("Proceed with entering " + size1 + " number(s) for the first array (integers 0 to 9): ");
        GetArrayElements(arr1, size1);

        System.out.println("Proceed with entering " + size2 + " number(s) for the second array (integers 0 to 9): ");
        GetArrayElements(arr2, size2);

        DisplayArray(arr1);
        DisplayArray(arr2);

        int manhattan_distance = ManhattanDistance(arr1, arr2, size1, size2);
        int euclidean_distance = EuclideanDistance(arr1, arr2, size1, size2);
        int cosine_distance = CosineDistance(arr1, arr2, size1, size2);

        System.out.println("The manhattan distance of the two arrays is: " + manhattan_distance);
        System.out.println("The euclidean distance of the two arrays is: " + euclidean_distance);
        System.out.println("The cosine distance of the two arrays is: " + cosine_distance);
        
    }

    static public void DisplayArray(short[] arr)
    {
        for (short element : arr)
            System.out.print(element + " ");
        System.out.println();
    }

    public static void GetArrayElements(short[] arr, int size)
    {
        Scanner input = new Scanner(System.in);
        
        for (int i = 0; i < size; i++)
        {
            arr[i] = input.nextShort();
            if (arr[i] > 9 || arr[i] < 0)
            {
                System.out.println("Invalid input. Try again!");
                i--;
            }
            input.nextLine(); // to remove "ENTER" key buffer
        }
    }

    public static int ManhattanDistance(short[] a1, short[] a2, int size1, int size2)
    {
        int ans = 0;

        return ans;
    }

    public static int EuclideanDistance(short[] a1, short[] a2, int size1, int size2)
    {
        int ans = 0;
        return ans;
    }

    public static int CosineDistance(short[] a1, short[] a2, int size1, int size2)
    {
        int ans = 0;
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
                    System.out.println("Display Submenu A\n");
                    break;
                case 'b':
                    System.out.println("Display Submenu B\n");
                    break;
                case 'c':
                    System.out.println("\nCLEAR CONSOLE");
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
