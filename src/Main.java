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

    /**
     * Represents the available game modes for Connect Four.
     * <p>
     * The game supports two modes:
     * <ul>
     *   <li>{@link #PVP} — Player vs. Player (two human players)</li>
     *   <li>{@link #PVC_RANDOM} — Player vs. Computer with random move selection</li>
     * </ul>
     */
    enum Mode { PVP, PVC_RANDOM }

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
    private static int[][] createBoard(int rows, int cols) {
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
    private static boolean isColumnFull(int[][] board, int c) {
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
    private static boolean hasMoves(int[][] board) {
        int cols = board[0].length;
        for (int c = 0; c < cols; c++) if (!isColumnFull(board, c)) return true;
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
    private static List<Integer> legalMoves(int[][] board) {
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
    private static int aiMoveRandom(int[][] board) {
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
        boolean humanIsP1 = true; 

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

    /**
     * Prompts the user for an integer within a closed interval and validates the input.
     *
     * @param sc     the scanner used to read input from the console
     * @param prompt the prompt message to display
     * @param min    the minimum accepted value (inclusive)
     * @param max    the maximum accepted value (inclusive)
     * @return the validated integer entered by the user in the range [min, max]
     */
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

    /**
     * Waits for the user to press Enter before continuing.
     *
     * @param sc the scanner used to read the newline from the console
     */
    static void pause(Scanner sc) {
        System.out.print("Press Enter to continue...");
        sc.nextLine();
    }

    /**
     * Sleeps the current thread for the given number of milliseconds.
     *
     * @param ms the duration to sleep in milliseconds
     */
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
