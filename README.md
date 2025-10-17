# CMPE343-OOP-Project1-Group7
Here we will be making our main menu, as well as submenus made by each member of the group.

---------------------------------------------------------------------------------------------------------------------------------

**MAIN MENU**

Our main menu will look something like this:

*PLEASE SELECT A SUBMENU BY TYPING THE CORRESPONDING LETTER:*
- [A] Primary School
- [B] Secondary School
- [C] High School
- [D] University
- [E] Terminate

---------------------------------------------------------------------------------------------------------------------------------

**SUBMENU A**

*Option A*, the screen is cleared, and a submenu appears with the operations: 
- (1) Age and Zodiac Sign Detection.
- (2) Reverse the Words.
- (3) Return to Main Menu. 

***DESCRIPTIONS OF EACH OPTION***

1) Age and Zodiac Sign Detection:
- The user must enter their date of birth (day, month, year). 
- The program then calculates and displays their age in years, months, and days, along with the zodiac sign, using custom-coded methods instead of built-in date/time functions. 
- Note that you have to get the current date information.

2) Reverse the Words: 
- The user provides a text input (including Turkish characters). 
- The program reverses every word containing two or more letters, while leaving punctuation marks and digits unchanged. 
- This task must be completed with a recursive method.

3) Return to Main Menu:
- Dislay the Main Menu.

---------------------------------------------------------------------------------------------------------------------------------

**SUBMENU B**

*Option B*, clears the console and displays: 
- (1) Prime Numbers
- (2) Step by step Evaluation of Expression
- (3) Return to Main Menu.

***DESCRIPTIONS OF EACH OPTION***

1) Prime Numbers:
- The user inputs an integer n ≥ 12. 
- The program generates all primes up to n using the Sieve of Eratosthenes, Sieve of Sundaram, and Sieve of Atkin algorithms. 
- It then shows the first three and last two primes from each method, along with their execution times for comparison. 

2) Step-by-step Evaluation of Expression:
- The user enters a mathematical expression made up of digits and symbols (+, −, ×, :, (, )). 
- Invalid characters or mismatched parentheses trigger a prompt to re-enter a valid expression. 
- The program then evaluates the expression step by step, following operator precedence, and prints each stage recursively until the final result.

3) Return to Main Menu:
- Dislay the Main Menu.

---------------------------------------------------------------------------------------------------------------------------------

**SUBMENU C**

*Option C*, clears the console and presents: 
- (1) Statistical Information about an Array.
- (2) Distance between Two Arrays.
- (3) Return to Main Menu. 

***DESCRIPTIONS OF EACH OPTION***

1) Statistical Information about an Array:
- The user specifies the array size and elements (DATATYPE: double values). 
- The program calculates and displays the median, arithmetic mean, geometric mean, and harmonic mean - the latter computed 
recursively.
- For even-sized arrays, the appropriate median-finding method must be applied. 

2) Distance between Two Arrays:
- The user first enters the dimension, then the elements of both arrays (integers within [0–9]). 
- Invalid entries trigger a warning and a retry. 
- The program then computes and displays the Manhattan Distance, Euclidean Distance, and Cosine Similarity between the arrays.

3) Return to Main Menu:
- Dislay the Main Menu.

---------------------------------------------------------------------------------------------------------------------------------

**SUBMENU D**

*Option D*, starts the Connect Four game. Asking for two inputs: 
- 1- The user first selects the board size (5×4, 6×5, or 7×6) 
- 2- And game mode (single-player vs. computer or two-players). 

***RULES:***
- Players take turns dropping discs into columns full columns must be reselected. After each move, the 
screen refreshes and displays the updated board. 
- The game ends when a player connects four discs, the board fills (draw), or one player quits (forfeit). 
- In single-player mode, the computer’s moves may be generated randomly or via AI algorithms such as Minimax or Alpha Beta Pruning, optionally supported by a heuristic evaluation function. 
