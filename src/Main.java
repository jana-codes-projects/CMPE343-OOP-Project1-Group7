<<<<<<< Updated upstream
import java.util.Scanner;
=======
import java.util.*;
>>>>>>> Stashed changes

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
                "[D] University (Connect Four)\n" +
                "[E] Terminate");
        System.out.print("Please select a letter corresponding with your submenu choice: ");
    }

    public static boolean ValidSubmenu(char c)
    {
        return (c == 'a' || c == 'b' || c == 'c' || c == 'd' || c == 'e');
    }

<<<<<<< Updated upstream
=======
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
        double median;
        Arrays.sort(arr);

        if (size % 2 == 1) // when array size is odd
            median = arr[(size + 1) / 2 - 1];
        else // when array size is even
            median = (arr[size / 2 - 1] + arr[size / 2]) / 2.0;
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
        double ans;
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
        ans = (double)dotProduct/Math.sqrt((long)prod1*prod2);
        return ans;
    }

    /*=========================== SUBMENU D — CONNECT FOUR (Integrated) ===========================*/

    enum Mode {
        PVP, PVC_RANDOM
    }

    static class Game {
        final int cols;
        final int rows;
        final int[][] board; // 0 empty, 1 P1, 2 P2
        final Random rng = new Random();

        Game(int cols, int rows) {
            this.cols = cols;
            this.rows = rows;
            this.board = new int[rows][cols];
        }

        boolean isColumnFull(int c) {
            return board[0][c] != 0;
        }

        boolean drop(int c, int player) {
            if (c < 0 || c >= cols || isColumnFull(c)) return false;
            for (int r = rows - 1; r >= 0; r--) {
                if (board[r][c] == 0) {
                    board[r][c] = player;
                    return true;
                }
            }
            return false;
        }

        boolean hasMoves() {
            for (int c = 0; c < cols; c++) if (!isColumnFull(c)) return true;
            return false;
        }

        void print() {
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

        boolean isWinningMove(int player) {
            // Horizontal
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c <= cols - 4; c++) {
                    if (board[r][c] == player && board[r][c+1] == player &&
                        board[r][c+2] == player && board[r][c+3] == player)
                        return true;
                }
            }
            // Vertical
            for (int c = 0; c < cols; c++) {
                for (int r = 0; r <= rows - 4; r++) {
                    if (board[r][c] == player && board[r+1][c] == player &&
                        board[r+2][c] == player && board[r+3][c] == player)
                        return true;
                }
            }
            // Diagonal down-right
            for (int r = 0; r <= rows - 4; r++) {
                for (int c = 0; c <= cols - 4; c++) {
                    if (board[r][c] == player && board[r+1][c+1] == player &&
                        board[r+2][c+2] == player && board[r+3][c+3] == player)
                        return true;
                }
            }
            // Diagonal up-right
            for (int r = 3; r < rows; r++) {
                for (int c = 0; c <= cols - 4; c++) {
                    if (board[r][c] == player && board[r-1][c+1] == player &&
                        board[r-2][c+2] == player && board[r-3][c+3] == player)
                        return true;
                }
            }
            return false;
        }

        List<Integer> legalMoves() {
            List<Integer> moves = new ArrayList<>();
            for (int c = 0; c < cols; c++) if (!isColumnFull(c)) moves.add(c);
            return moves;
        }

        // --- AI: Random ---
        int aiMoveRandom() {
            List<Integer> moves = legalMoves();
            return moves.get(rng.nextInt(moves.size()));
        }
    }

    // Submenu D runner
    static void SubmenuD_ConnectFour() {
        Scanner sc = new Scanner(System.in);

        int[] cOpts = {5, 6, 7};
        int[] rOpts = {4, 5, 6};

        System.out.println("SUBMENU D — Connect Four");
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

        while (true) {
            g.print();
            if (!g.hasMoves()) {
                System.out.println("Board is full. It's a draw!");
                break;
            }

            boolean isHumansTurn = true;
            if (mode == Mode.PVC_RANDOM) {
                isHumansTurn = (current == 1 && humanIsP1) || (current == 2 && !humanIsP1);
            }

            int moveCol = -1;

            if (mode == Mode.PVP || isHumansTurn) {
                // Human turn
                System.out.printf("Player %d (%s), choose a column (1-%d) or 'q' to forfeit: ",
                        current, (current == 1 ? "X" : "O"), cols);
                String in = sc.nextLine().trim();
                if (in.equalsIgnoreCase("q")) {
                    g.print();
                    System.out.printf("Player %d forfeited. The other player wins!\n", current);
                    break;
                }
                try {
                    int col = Integer.parseInt(in) - 1;
                    if (col < 0 || col >= cols || g.isColumnFull(col)) {
                        System.out.println("Invalid choice or the column is full. Try again.");
                        pause(sc);
                        continue;
                    }
                    moveCol = col;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Try again.");
                    pause(sc);
                    continue;
                }
            } else {
                // Computer turn
                System.out.println("Computer is thinking...");
                moveCol = g.aiMoveRandom();
                sleep(300); // small delay for UX
            }

            // Apply move
            g.drop(moveCol, current);

            // Check win
            if (g.isWinningMove(current)) {
                g.print();
                if (mode == Mode.PVP || isHumansTurn) {
                    System.out.printf("Congratulations! Player %d (%s) wins!\n", current, (current == 1 ? "X" : "O"));
                } else {
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

    static int askInt(Scanner sc, String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            try {
                int v = Integer.parseInt(s);
                if (v >= min && v <= max) return v;
            } catch (NumberFormatException ignored) {}
            System.out.println("Invalid input. Please try again.");
        }
    }

    static void pause(Scanner sc) {
        System.out.print("Press Enter to continue...");
        sc.nextLine();
    }

    static void sleep(long ms) {
        try { Thread.sleep(ms); } catch (InterruptedException ignored) {}
    }

    /*--------------------------------------------------MAIN FUNCTION----------------------------------------------------*/
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
                    System.out.println("Display Submenu C\n");
=======
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
>>>>>>> Stashed changes
                    break;
                case 'd':
                    // Integrated Connect Four
                    SubmenuD_ConnectFour();
                    letter = 'j'; // return to main menu afterwards
                    break;
                case 'e':
                    System.out.println("You chose to exit the program.\n");
                    break;
                default:
                    System.out.println("\nYou entered an invalid choice. Try again!\n");
            }
        } while (!ValidSubmenu(letter));
<<<<<<< Updated upstream


=======
>>>>>>> Stashed changes
    }
}
