import java.util.*;

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

    // Supposedly clears console on cmd
    public static void clearScreen()
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }


    /*=========================== SUBMENU D — CONNECT FOUR ===========================*/

    enum Mode { PVP, PVC_RANDOM }

    private static int[][] createBoard(int rows, int cols) {
        return new int[rows][cols]; // 0 empty, 1 P1, 2 P2
    }

    private static boolean isColumnFull(int[][] board, int c) {
        return board[0][c] != 0;
    }

    private static boolean drop(int[][] board, int c, int player) {
        int rows = board.length;
        int cols = board[0].length;
        if (c < 0 || c >= cols || isColumnFull(board, c)) return false;
        for (int r = rows - 1; r >= 0; r--) {
            if (board[r][c] == 0) {
                board[r][c] = player;
                return true;
            }
        }
        return false;
    }

    private static boolean hasMoves(int[][] board) {
        int cols = board[0].length;
        for (int c = 0; c < cols; c++) if (!isColumnFull(board, c)) return true;
        return false;
    }

    private static void printBoard(int[][] board) {
        Main.clearScreen();
        int rows = board.length;
        int cols = board[0].length;

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

    private static boolean isWinningMove(int[][] board, int player) {
        int rows = board.length;
        int cols = board[0].length;

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

    private static List<Integer> legalMoves(int[][] board) {
        int cols = board[0].length;
        List<Integer> moves = new ArrayList<>();
        for (int c = 0; c < cols; c++)
            if (!isColumnFull(board, c))
                moves.add(c);
        return moves;
    }

    // --- AI: Random ---
    private static int aiMoveRandom(int[][] board) {
        List<Integer> moves = legalMoves(board);
        Random rng = new Random();
        return moves.get(rng.nextInt(moves.size()));
    }

    // --------- Running Function ---------
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

        int[][] board = createBoard(rows, cols);
        int current = 1; // 1 = X (Player 1), 2 = O (Player 2/Computer)
        boolean humanIsP1 = true; // PvC'de insan X oynar (varsayılan)

        while (true) {
            printBoard(board);
            if (!hasMoves(board)) {
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
                    printBoard(board);
                    System.out.printf("Player %d forfeited. The other player wins!\n", current);
                    break;
                }
                try {
                    int col = Integer.parseInt(in) - 1;
                    if (col < 0 || col >= cols || isColumnFull(board, col)) {
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
                moveCol = aiMoveRandom(board);
                sleep(300); // small delay for UX
            }

            // Apply move
            drop(board, moveCol, current);

            // Check win
            if (isWinningMove(board, current)) {
                printBoard(board);
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
                    clearScreen(); // IntelliJ does not have a way to clear console with code
                    System.out.println("Display Submenu C\n");
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
    }
}
