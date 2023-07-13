# Tic Tac Toe Game

This is a simple Tic Tac Toe game implemented in Java. It allows players to play the classic game of Tic Tac Toe on the command line, either against another player or against the computer.

## Getting Started

To run the game, you need to have Java Development Kit (JDK) installed on your system. You can download it from the official Oracle website or use any other compatible JDK.

1. Clone this repository to your local machine using the following command:

git clone https://github.com/your-username/tic-tac-toe.git

2. Navigate to the project directory:

cd tic-tac-toe

3. Compile the Java source code:

javac TicTacToe.java

4. Run the game:

java TicTacToe

*******lets see how to play*******

## How to Play

1. The game is played on a 3x3 grid.

2. Each player takes turns to mark an empty cell on the grid with their respective symbol (X or O).

3. The first player to get three of their symbols in a row (horizontally, vertically, or diagonally) wins the game.

4. If all cells are filled and no player has won, the game is considered a draw.

## Features

- Simple and intuitive command line interface.
- Two-player mode for competitive gameplay.
- Single-player mode against the computer for practice.
- Error handling for invalid moves and input.
- Display of game results (win, draw, or ongoing).

## Game Modes

### Two-Player Mode

- Select the "Two-Player Mode" option from the menu.
- Players take turns entering their moves.
- The game board is represented by numbers from 1 to 9 as shown below:
  
1 | 2 | 3

4 | 5 | 6

7 | 8 | 9


- Players enter the number corresponding to the cell they want to mark.  (it may different message in my actual code given above but intiution is same)

### Single-Player Mode (Against the Computer)

- Select the "Single-Player Mode" option from the menu.
- You will play against the computer, which will make its moves automatically.
- Follow the same rules as in the two-player mode to enter your moves.

## Example Gameplay
Welcome to Tic Tac Toe!

Please select a game mode:

Two-Player Mode
Single-Player Mode
Enter your choice: 2

You selected Single-Player Mode.

Player (X), enter your move: 5
Game board after your move:

1 | 2 | 3

4 | X | 6

7 | 8 | 9

Computer's turn (O):
Game board after the computer's move:

1 | 2 | 3

4 | X | 6

7 | 8 | O


Player (X), enter your move: 1
Game board after your move:

X | 2 | 3

4 | X | 6

7 | 8 | O

Player (X) wins!

Thanks for playing!

If you find any issues or have suggestions for improvements, please feel free to open an issue or submit a pull request. (other than frontend develop in future i will make frontend as well)


