/**
 Matthew Parra
 6/8/2018
 ICS3U1
 Mr. D'Addario
This program displays a game. The Nim Game.
*/


import java.util.*;//imports the util package containing the scanner and random function
class Main {
  
  //This method focuses on the CPU's play
  public static int computerMove(int TotalStones,int Computermove, String Playername) {
    Random r = new Random();//enables random runction

    int ComputerTakeValue = r.nextInt(3-1+1)+1;//generates the value that the computer will take
  
     //The statements below are for when their only 4 or less stones left in the pile, it makes the CPU make smart moves
      if(TotalStones == 4){ 
        ComputerTakeValue = 3; 
      }else if(TotalStones == 3){ 
        ComputerTakeValue = 2; 
      }else if(TotalStones == 2){ 
        ComputerTakeValue = 1;
      }

//The code below is for when the computer takes n number of stones, and how much stones are left in the pile, and also displays how many it took
      for (int i = 0;i<TotalStones + 3;i++){ //loop for computerMove
       System.out.println("There are " + TotalStones + " stones left, the CPU takes " +  ComputerTakeValue + " stones!");
     System.out.println("");//adds empty line

       TotalStones = (TotalStones - ComputerTakeValue);//TotalStones after computer takes some stones

if(TotalStones == 1){//if totalstones = 1, then computer wins
 System.out.println("Computer Wins!!!"); //displays CPU wins
 System.out.println("You lost :( ");//displays, the player lost
  System.exit(0);//ends the program
   }

     PlayerMove(TotalStones, Playername);//Calls the playermove method, and sendds the variables TotalStones, and Playername
   
   
   }

    return(TotalStones); //returns TotalStones

  }
  
//The method below is called Validentry which determines whether the input value the player enters, is valid or not.

   public static boolean isValidEntry(int Player,int TotalStones, String Playername) {

//a boolean variable
     boolean a = true;
       int NewPlayer = Player;//this creates a new variable for what player inputs
       if (NewPlayer == 9) {
         System.out.println("Would you like help?");
         getHelp(TotalStones, Playername);
       }
       int NewNumStones = TotalStones;//sets NewNumStones equal to totalstones
         while(Player > 3 || Player < 1){//loops that checks Player's input is valid
            System.out.print(Playername + " enter a number between 1 and 3: "); //Prompts user to enter a valid input
             PlayerMove(NewNumStones, Playername);//calls upon player, sending NewNumStones and Platername 
             a = false;//a would be false until this loops ends/stops
         }
     if(NewNumStones == 3 && NewPlayer== 3){ //checks that  player doesn't take all stones
       System.out.print( Playername + ", you cannot take 3 stones");//prompts player
       PlayerMove(NewNumStones, Playername); //calls Player move method, and sends variables
     }else if(NewNumStones == 2 && NewPlayer== 2){ //checks player doesnt take all stones
        System.out.print("You cannot take 2 stones"); //prompts user
       PlayerMove(NewNumStones, Playername);//calls Playermove method
     }
   return(a);//returns a boolean

  }

    //The method below focuses on the player's move
  public static void getHelp(int TotalStones, String Playername) { 
      Scanner scanner = new Scanner(System.in);//scanner function
      int Player = 0;//This is the variable for the player's move
      String reply = "n";
      int NewNumStones = TotalStones;//sets the new number of stones up to date
      boolean Valid = false;//boolean variable is its not valid
      reply = scanner.next();//input variable
      if (reply.equals("y")) {//checks to see if their are 1 stone left 
        System.out.println("End your turn on a multiple of 4, plus 2. So you'd like to end on 6, because 4 is a multiple of 4, plus 2.");
      }
     PlayerMove(NewNumStones, Playername);  //calls the PlayerMove method
 }
  
  //The method below focuses on the player's move
  public static int PlayerMove(int TotalStones, String Playername) { 
      Scanner scanner = new Scanner(System.in);//scanner function
      int Player = 0;//This is the variable for the player's move
  
      int NewNumStones = TotalStones;//sets the new number of stones up to date
  
     boolean Valid = false;//boolean variable is its not valid

        for(int m = 0; m < TotalStones + 3; m++){ //loop for player input
          System.out.print("\nThere are "+ NewNumStones +" stones left, how stones would you like to take " + Playername + "?");//informs user
          Player = scanner.nextInt();//input variable
          isValidEntry(Player, NewNumStones, Playername);//sends information to valid entry so it checks if the input is valid or not
  

          NewNumStones = (TotalStones - Player);//sets the new number of stones equal again
  
            if (NewNumStones == 1){//checks to see if their are 1 stone left 
              System.out.println(Playername + " You Won!");//prompts the user that he won
             System.exit(0);//ends program
         }
     playNim(Player, NewNumStones, Playername);//calls the PlayNm method
  
  
      }

   return(Player);//returns players value

 }
//this method basically sends information to computer move method
  public static int playNim(int Player,int TotalStones, String Playername) {
    
    
    computerMove(TotalStones, Player, Playername);//Calls upon Computer move method, and then sends variables Player, Playername,  and total stones
   return(TotalStones);//returns TotalStones
  
  }

 
 
 //This is the main method. In this method it basically generates the total number of stones in the game, and asks the player for his or her name
  public static void main(String[] args) {
     Random rd = new Random();//enables Random functio
     Scanner sc = new Scanner(System.in);//Scanner function is now enabled
   

      int TotalStones = rd.nextInt(30 - 15 +1) + 15; //generates and saves a random number between 15 and 30, and saves it for the game
  

  System.out.println("Player name:   ");//prompts player for their name
  String Playername = sc.nextLine();//input name for player
  System.out.println("");//adds an empty line
   
   //Below, prompts the Player with the rules of the Nim Game
 	 System.out.println("Welcome to the Nim Game. In this Nim Game you will be facing a CPU player. The game begins with a random number of stones in a pile. You can only take from 1 to 3 stones, in each turn. Any other input will be invalid. The pile will randomly have  from 15 to 30 stones, and the person taking the last stone loses the game. The goal of the game is to force the other player to take the last stone. Good luck " + Playername);
  
  

      System.out.print(""); // adds an empty line
  
   drawStones(TotalStones, Playername);//Calls upon the drawStones method, sending the total number of stones value, and the name of the player
    
  
  }
//This method generates the number of stones the CPU wil take
  public static int drawStones(int TotalStones, String Playername) {
   
     Random r = new Random();

     int Computermove = r.nextInt(3-1+1)+1;//variable for the number of stones CPU will take 
      int NewNumStones = TotalStones;//Variable for the new total number of stones after each turn
  
     PlayerMove(NewNumStones, Playername);//Calls upon the PlayerMove method, sending the new number of stones variable, and the Player's name

   computerMove(NewNumStones,Computermove, Playername);//calls upon the Computer move method, sending the variable for the new total number of stones, the number of stones the CPU will take from the pile, and finally the player's 
    return(Computermove);//returns computer move
  }
  
}

