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

    // Displays Submenu (Option) B
    public static void PrintSubmenuB() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~ SUBMENU B ~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("[1] Prime Numbers");
        System.out.println("[2] Step-by-step Evaluation of Expression");
        System.out.println("[3] Return to Main Menu");
        System.out.print("Please select a number corresponding with your choice: ");
    }

    /*--------------------------------------------------SubMenu B: Part 1----------------------------------------------------*/
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

        long startTime = System.nanoTime();
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        long endTime = System.nanoTime();

        int count = 0;
        int[] primes = new int[n];
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primes[count++] = i;
            }
        }

        System.out.println("\nFound " + count + " prime numbers up to " + n + ".");
        System.out.print("First up to 3 primes: ");
        for (int i = 0; i < Math.min(3, count); i++)
            System.out.print(primes[i] + " ");
        System.out.println();

        System.out.print("Last up to 2 primes: ");
        for (int i = Math.max(0, count - 2); i < count; i++)
            System.out.print(primes[i] + " ");
        System.out.println();

        double ms = (endTime - startTime) / 1_000_000.0;
        System.out.printf("Execution time: %.3f ms%n", ms);
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
                                // StepByStepExpression();
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
