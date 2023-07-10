import java.util.Random;
import java.util.Scanner;

class Board { // this is the our main public class
    // board means the 3 by 3 matrix where the game played
    public int[][] board = new int[3][3];

    /*
     * -----------
     * | 1 | 2 | 3 |
     * -----------
     * | 4 | 5 | 6 |
     * -----------
     * | 7 | 8 | 9 |
     * -----------
     */
    // this is the board where we have to ask,change, occurence of O or X etc

    public void Print() {
        System.out.println("");
        int x = 1;
        System.out.println(" -----------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(x + " | ");
                x++;
            }
            System.out.println("");
            System.out.println(" -----------");//
        }
    }

    public void printkro() { 
        System.out.println("");
        System.out.println(" -----------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 0) {
                    System.out.print(" ");
                  
                } else {
                    if (board[i][j] == 1) {
                        System.out.print("X");
                    
                    } else {
                        System.out.print("O");
                        
                    }
                }
                System.out.print(" | ");
            }
            System.out.println("");
            System.out.println(" -----------");
        }
    }

   
    public int Check(int pos) {
        pos -= 1;
        int i = pos / 3;
        int j = pos % 3;
        if (board[i][j] == 0) {
            return 1; 
        } else {
            return 0; 
        }
    }

   
    public int Win() {
        int sum;

        
        for (int i = 0; i < 3; i++) {
            sum = 0;
            for (int j = 0; j < 3; j++) {
                sum += board[i][j];
            }
            if (sum == 3) {         
                return 1;
            } else if (sum == -3) {
                return -1;
            }
        }

        
        for (int i = 0; i < 3; i++) {
            sum = 0;
            for (int j = 0; j < 3; j++) {
                sum += board[j][i];
            }
            if (sum == 3) {
                return 1;
            } else if (sum == -3) {
                return -1;
            }
        }

        sum = 0;

        
        for (int i = 0; i < 3; i++) {
            sum += board[i][i];  // Asking the mode again
        }
        if (sum == 3) {
            return 1;
        } else if (sum == -3) {
            return -1;
        }

        sum = 0;

        for (int i = 0; i < 3; i++) {
            sum += board[i][2 - i];
        }
        if (sum == 3) {
            return 1;
        } else if (sum == -3) {
            return -1;
        }

        return 0;
    }

   
    public void Update(int pos, int val) {
        pos -= 1;
        int i = pos / 3;
        int j = pos % 3;
        board[i][j] = val;
    }

   
    public void Clear() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = 0;
            }
        }
    }

    public int Computer() {
        int pos;

       
        // computer win
        for (int i = 0; i < 3; i++) {          
            for (int j = 0; j < 3; j++) {
                pos = 3 * i + j + 1;
                if (Check(pos) == 1) {
                    board[i][j] = -1;
                    
                   
                    if (Win() == -1) {
                        return pos;
                    }
                    board[i][j] = 0;
                }
            }
        }

        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                pos = 3 * i + j + 1;
                if (Check(pos) == 1) {
                    board[i][j] = 1;
                    if (Win() == 1) {        
                       
                        board[i][j] = -1;
                        return pos;
                    }
                    board[i][j] = 0;
                }
            }
        }

       
        Random random = new Random();
        pos = random.nextInt(9) + 1;
        while (Check(pos) == 0) {
            pos = random.nextInt(9) + 1;
        }
        Update(pos, -1);
        return pos;
    }
}

public class ques {
    public static void main(String args[]) {

        Scanner input = new Scanner(System.in);

        System.out.println("*******let's some fun with tic toc toe game *****");

        // Printing the various modes for playing game

        System.out.println("if you want to play with multiplayer presss 1");
        System.out.println("if you want to play with computer presss 2");
        System.out.println("Enter 0 To Quit");
        System.out.print("in which mode which you want to play : ");

        // Tells the mode in which player wish to play
        int mode = input.nextInt();

        Board board = new Board(); // here a board of 3 by 3
        // 1 means X and -1 means O here and 0 means empty position

        while (mode != 0) {
            if (mode == 1) {
               // if mode is 1 then game start with player vs player
               // assuming that first player is with X and second player is 2
                System.out.println("here the game start with multiplayer mode *** ");
                System.out.println("Player 1 Is X And Player 2 is O");
                board.Print();

                int location;
                int counter = 0;

                while (board.Win() == 0) {
            
                     // if nobody player wins the game means then no places left to fill
                    if (counter % 2 == 0) {
                        // if counter even number then Player 1 makes a move means player 1 start the game 
                        System.out.println("player 1 choosing a location : ");
                        location = input.nextInt();

                        while (location < 1 || location > 9) {
                            // Invalid positions occurr if location is beyond the board means location > 9 || location < 1
                            System.out.println("Choose A Valid Position : ");
                            location = input.nextInt();
                        }

                        while (board.Check(location) == 0) {
                            // Occupied Postion error
                            System.out.println("please choose a unocupied location : ");
                            location = input.nextInt();  // we have not find unocupied the location until we takes the valid input 

                            while (location < 1 || location >  9) {
                                System.out.print("\nChoose A Valid Position : ");
                                location = input.nextInt();  // then again check beyond the board condition
                            }
                        }
                        
                        board.Update(location, 1); // update the board by player 1 movement
                        
                    } else {
                        // if counter is odd then player 2 move with their turn
                        System.out.print("\nPlayer 2 Choose A Position : ");
                        location = input.nextInt();

                        while (location < 1 || location > 9) {
                            // Invalid positions occurr if location is beyond the board means location > 9 || location < 1
                            System.out.println("Choose A Valid Position : ");
                            location = input.nextInt();
                        }

                        while (board.Check(location) == 0) {
                           // Occupied Postion error
                           System.out.println("please choose a unocupied location : ");
                           location = input.nextInt();  // we have not find unocupied the location until we takes the valid input 

                            while (location < 1 || location > 9) {
                                System.out.print("\nChoose A Valid Position : ");
                                location = input.nextInt();  // then again check beyond the board condition
                            }
                        }
                        // Updating the board with the move made by Player 2
                        board.Update(location, -1);
                    }

                    board.printkro();// print the board after every movement in the game

                    counter++;

                    if (board.Win() == 1) {
                        // if win function give 1 then player has been won the game
                        System.out.println("**congrats!!,player 1 has won the game");
                        break;
                    } else if (board.Win() == -1) {
                        // If Output of Win is -1 that means Player 2 has won the game
                        System.out.println("congrats!!, player 2 has won The Game !!");
                        break;
                    }

                    // If counter is 9 then no move further
                    if (counter == 9) {
                        // game drawm
                        System.out.println("next try!! , game drawn");
                        break;
                    }
                }

               
                board.Clear(); // after completion one game board cleared

                // lets play another game
                System.out.println("lets play another game press Y: ");
                char another_game = input.next().charAt(0);

                // If Y that means play same mode again
                if (another_game == 'Y') {
                    continue;
                }
            } else if (mode == 2) {
                 // computer vs human player
                System.out.println("human Player is X And Computer is O");
                board.Print();

                int location2;
                int counter2 = 0;

                while (board.Win() == 0) {
                  // if nobody player wins the game means then no places left to fill
                    if (counter2 % 2 == 0) {
                      // if counter even number then Player makes a move means player start the game 
                        System.out.println("human player choosing a location : ");
                        location2 = input.nextInt();

                        while (location2 > 9 || location2 < 1) {
                            // Invalid positions occurr if location is beyond the board means location > 9 || location < 1
                            System.out.println("Choose a Valid Position : ");
                            location2 = input.nextInt();
                        }

                        while (board.Check(location2) == 0) {
                            // Occupied position error
                            System.out.println("please choose a unocupied location  ");
                            location2 = input.nextInt();

                            while (location2 > 9 || location2 < 1) {
                                System.out.println("Choose A Valid Position : ");
                                location2 = input.nextInt();
                            }
                        }
                        // Updating the board by the movement of human player
                        board.Update(location2, 1);
                    } else {
                       
                        location2 = board.Computer(); // location choosen by computer using random funvtion
                        System.out.println("\nComputer Chose Position : " + location2);
                    }

                    // clear the board after one game completion
                    board.printkro();

                    counter2++;

                    if (board.Win() == 1) {
                        // If Output of Win is 1 that means human Player has won the game
                        System.out.println("congrats!!, human player win !!");
                        break;
                    } else if (board.Win() == -1) {
                        
                        System.out.println("shitt!!,human player lost");
                        break;
                    }

                    
                    if (counter2 == 9) {
                     
                        System.out.println("next try, The game has draw !!");
                        break;
                    }
                }

       
                board.Clear();

             
                System.out.print("lets play another game press Y : ");
                char another = input.next().charAt(0);

               
                if (another == 'Y') {
                    continue;
                }
            } 

            // asking for another one
            System.out.println("\nEnter 1 For MultiPlayer");
            System.out.println("Enter 2 To Play With Computer");
            System.out.println("Enter 0 To Quit\n");
            System.out.print("How Do You Wish To Play : ");

            mode = input.nextInt();
        }

        System.out.println("");
        input.close();
    }
}