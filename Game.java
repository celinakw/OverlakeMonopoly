//Final Project
//Alec Zoe Felix Celina Gavin
//Overlake Monopoly
//Game  class runs the game loop
import java.util.*;

public class Game{
   //player track creater call this when you want add a new player
   public static void makePlayerTrack(Place[] board, ArrayList<String> output){
      for(int i = 0; i < board.length; i++){
         String temp = "";
         for(int j = 0; j < board[i].getName().length(); j++){
            temp+="_";
         }
         output.add(temp);
      }
   }
   //changes position on a track
   public static void updatePos(Player player, ArrayList<String> track, ArrayList<String> position, int moveAmount, int playerNum){
         track.set(player.getPos(), position.get(player.getPos()));
         player.move(moveAmount);
         track.set(player.getPos(), (position.get(player.getPos()).substring(0,(int)(position.get(player.getPos()).length()/2))+playerNum+position.get(player.getPos()).substring((int)(position.get(player.getPos()).length()/2+1),(int)(position.get(player.getPos()).length()))));
         
   }
   

   public static void main(String args[]){
  
      Scanner myObj = new Scanner(System.in);
      String action;
      boolean gameOver = false;
      
      Player playerOne = new Player();
      Player playerTwo = new Player();
      
      System.out.println("Each of you start with $1500");
      System.out.println("Player 1 enter your name: ");
      action = myObj.nextLine();
      playerOne.changeName(action);
      System.out.println("Player 2 enter your name: ");
      action = myObj.nextLine();
      playerTwo.changeName(action);      
      
  
      Place squareOne = new Place("Go!", null, 0, 0, false, "go");
      Place squareTwo = new Place("Junior Lot", null, 50, 2, true, 1, 0,"useless");
      //make railroad
      Place squareThree = new Place("Field 1 port-a-potty", null, 200, 25, false, "railroad");
      Place squareFour = new Place("Chance Card 1", null, 0, 0, false, "card");
      Place squareFive = new Place("DEJI", null, 150, 0, false, "company");
      Place squareSix = new Place("Stairs (from junior lot)", null, 100, 6, true, 1, 0,"useless");
      
      Place squareSeven= new Place("SRB", null, 0, 0, false, "jail");
      Place squareEight= new Place("Gola Room", null, 150, 12, true, 2, 0,"useless");
      Place squareNine= new Place("Chance Card 2", null, 0, 0, false, "card");
      //make railroad
      Place squareTen= new Place("Humanities Bathroom", null, 200, 25, false, "railroad");
      Place squareEleven= new Place("College Counseling", null, 170, 14, true, 2, 0, "academics");
      Place squareTwelve= new Place("Mia's Classroom", null, 200, 16, true, 2, 0,"academics");
      
      Place squareThirteen= new Place("Flagpole", null, 0, 0, false, "flagpole");
      Place squareFourteen= new Place("Library", null, 250, 18, true, 3, 0,"academics");
      //make railroad
      Place squareFifteen= new Place("TLC Bathroom", null, 200, 25, false, "railroad");
      Place squareSixteen= new Place("ASB", null, 150, 0, false, "company");
      Place squareSeventeen= new Place("Student Center", null, 270, 22, true, 3, 0, "favPlaces");
      Place squareEighteen= new Place("Fishbowl", null, 290, 22, true, 3, 0,"favPlaces");
      
      Place squareNineteen= new Place("Go to SRB", null, 0, 0, false, "gojail");
      Place squareTwenty= new Place("Gerald's Classroom", null, 300, 26, true, 4, 0,"favPlaces");
      //make railroad
      Place squareTwentyOne= new Place("MathSci Bathroom", null, 200, 25, false, "railroad");
      Place squareTwentyTwo= new Place("Chance Card 3", null, 0, 0, false, "card");
      Place squareTwentyThree= new Place("Idea Lab", null, 350, 35, true, 4, 0,"boogie");
      Place squareTwentyFour= new Place("MathSci Conference Room", null, 400, 50, true, 4, 0,"boogie");
      Place squareTwentyFive= new Place("Matt Hovatt's House", null, 500, 100, true, 4, 0, "boogie");
      
  
      Place[] board = {squareOne, squareTwo, squareThree, squareFour, squareFive, squareSix, squareSeven,squareEight,squareNine,squareTen,squareEleven,squareTwelve,squareThirteen,squareFourteen,
         squareFifteen,squareSixteen,squareSeventeen,squareEighteen,squareNineteen,squareTwenty,squareTwentyOne,squareTwentyTwo,squareTwentyThree,squareTwentyFour};
      Player[] order = {playerOne, playerTwo};
      ArrayList<String> positions = new ArrayList<String>();
      makePlayerTrack(board, positions);
      ArrayList<String> positionsPOne = new ArrayList<String>();
      makePlayerTrack(board, positionsPOne);
      ArrayList<String> positionsPTwo = new ArrayList<String>();
      makePlayerTrack(board, positionsPTwo);
      positionsPOne.set(0,"_1_");
      positionsPTwo.set(0,"_2_");
      int turn = 0;
     //Game loop
      while(!gameOver){
         //need to change the board to work on a 2d array list probaby or use an abreviation system as the board is huge
         System.out.print("[");
         for(int i = 0; i < board.length-1; i++){
            System.out.print(board[i].getName()+", ");
         }
         System.out.println(board[board.length-1].getName()+"]");
         System.out.println(positionsPOne);
         System.out.println(positionsPTwo);
         System.out.println();
         System.out.println("What do you want to do " + order[(turn%2)].getName() +"? Please enter ");
         System.out.print("\"Move\": roll the dice and change position");
         System.out.println("    \"Position\": check where you are");
         System.out.println("\"Owned\": check what you own");
         System.out.println("You have: $" + order[turn % 2].getBank());
         action = myObj.nextLine();
         
         //moves player and moves to next turn.
         
         //actions
         if(action.toLowerCase().equals("move")){
            if(order[turn % 2].isJail()){
               board[order[turn % 2].getPos()].runPlace(order[turn % 2]);
               if(!(order[turn % 2].isJail())){
                  int moveAmount = (int)(Math.random()*3)+(int)(Math.random()*3)+2;
                  if(turn%2==0){
                     updatePos(order[turn%2], positionsPOne, positions, moveAmount, turn%2+1);
                     board[order[turn % 2].getPos()].runPlace(order[turn % 2]);
                     turn++;
                  }
                  else if(turn%2==1){
                     updatePos(order[turn%2], positionsPTwo, positions, moveAmount, turn%2+1);
                     board[order[turn % 2].getPos()].runPlace(order[turn % 2]);
                     turn++;
                  }
               }
               turn++;
            }
            else{
               int moveAmount = (int)(Math.random()*3)+(int)(Math.random()*3)+2;
               if(turn%2==0){
                  updatePos(order[turn%2], positionsPOne, positions, moveAmount, turn%2+1);
                  board[order[turn % 2].getPos()].runPlace(order[turn % 2]);
                  turn++;
               }
               else if(turn%2==1){
                  updatePos(order[turn%2], positionsPTwo, positions, moveAmount, turn%2+1);
                  board[order[turn % 2].getPos()].runPlace(order[turn % 2]);
                  turn++;
               }
               
            }
            System.out.println("You have $" + order[(turn - 1)%2].getBank() + " left in your bank account.");
            System.out.println();
         }
         //get money of current player
         else if(action.toLowerCase().equals("money")){
            System.out.println(order[turn%2].getBank());
            
            System.out.println();
         }
         //tester method
         else if(action.toLowerCase().equals("position")){
            System.out.println(order[turn%2].getPos());
            System.out.println();
         }
         //prints all owned properties 
         else if (action.toLowerCase().equals("owned")){
            System.out.print("[");
            for(int i = 0; i<order[turn%2].ownPlace().size(); i++){
               //broken adds an extra space and might want to be re formated
               System.out.print(order[turn%2].ownPlacePosition(i).getName()+" ");
            }
            
            if(order[turn % 2].ownPlace().size() == 0){
            
               System.out.print("none owned");
            
            }
            System.out.println("]");
            
            System.out.println();
            
         }
         else if(action.toLowerCase().equals("forcemove")){
            int moveAmount = myObj.nextInt();
            if(turn%2==0){
               updatePos(order[turn%2], positionsPOne, positions, moveAmount, turn%2+1);
               board[order[turn % 2].getPos()].runPlace(order[turn % 2]);
               turn++;
            }
            else if(turn%2==1){
               updatePos(order[turn%2], positionsPTwo, positions, moveAmount, turn%2+1);
               board[order[turn % 2].getPos()].runPlace(order[turn % 2]);
               turn++;
            }
         }
         //fail method
         else{
            System.out.println("Invalid Command");
            
            System.out.println();
         }
         
         if(order[turn % 2].getBank() <= 0){
            gameOver = true;
            System.out.println(order[turn % 2].getName() + " lost what a  loser");
         }
         if(order[(turn + 1) % 2].getBank() <= 0){
            gameOver = true;
            System.out.println(order[turn + 1% 2].getName() + " lost what a loser");
         }
     
      }
  
   } 
   
}

