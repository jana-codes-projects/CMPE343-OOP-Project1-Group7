import java.util.Arrays;
import java.util.InputMismatchException;
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

    // Displays SubMenu A
    public static void PrintSubmenuA()
    {
        System.out.println("\n=== Primary School Menu ===");
        System.out.println("1) Age and Zodiac Sign Detection");
        System.out.println("2) Reverse the Words");
        System.out.println("3) Return to Main Menu");
        System.out.print("Please select an option: ");
    }

    /*--------------------------------------------------SubMenu A Part 1: ----------------------------------------------------------*/

    public static void AgeAndZodiac()
    {
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
            if (confirm.equals("Y"))
                break;
            else
                System.out.println("Please enter the correct current date again.");
        }

        int[] age = calculateAge(birthDay, birthMonth, birthYear, currentDay, currentMonth, currentYear);
        System.out.println("\nYour Age: " + age[0] + " years, " + age[1] + " months, " + age[2] + " days");
        String zodiac = calculateZodiac(birthDay, birthMonth);
        System.out.println("Your Zodiac Sign: " + zodiac);
    }

    //Function Calculating Age Based on Date of Birth
    public static int[] calculateAge(int birthDay, int birthMonth, int birthYear, int currentDay, int currentMonth, int currentYear)
    {
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
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
    public static String calculateZodiac(int day, int month)
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

    /*--------------------------------------------------SubMenu A Part 2: ----------------------------------------------------------*/
    public static void ReverseWords()
    {
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
    public static String reverseSentence(String sentence)
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
    public static String reverseWord(String word)
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
                    short choiceA = 0;
                    do {
                        PrintSubmenuA();
                        try {
                            choiceA = input.nextShort();
                            input.nextLine(); // to remove "ENTER" key buffer
                        } catch (InputMismatchException ex) { // to handle overflow/underflow
                            System.out.println("Input generated Overflow/Underflow");
                            input.nextLine(); // to remove "ENTER" key buffer
                            choiceA = -1;
                            continue;
                        }
                        switch (choiceA) {
                            case 1:
                                AgeAndZodiac();
                                break;
                            case 2:
                                ReverseWords();
                                break;
                            case 3:
                                letter = 'j'; // loop back to main menu
                                System.out.println();
                                break;
                            default:
                                System.out.println("Invalid choice. Try again!\n");
                        }
                    } while (choiceA > 3 || choiceA < 1);
                    break;
                case 'b':
                    System.out.println("\nCLEAR CONSOLE");
                    clearScreen(); // IntelliJ does not have a way to clear console with code
                    System.out.println("Display Submenu B\n");
                    break;
                case 'c':
                    System.out.println("\nCLEAR CONSOLE");
                    clearScreen(); // IntelliJ does not have a way to clear console with code
                    System.out.println("Display Submenu C\n");
                    break;
                case 'd':
                    System.out.println("\nCLEAR CONSOLE");
                    clearScreen(); // IntelliJ does not have a way to clear console with code
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


