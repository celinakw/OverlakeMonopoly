//Final Project
//Alec Zoe Felix Celina Gavin
//Overlake Monopoly
//Game  class runs the game loop
import java.util.*;

public class Game{

   public static void getBoard(){
      //not sure what this is supposed to do but made it anyways 
   }

   public static void main(String args[]){
  
      Scanner myObj = new Scanner(System.in);
      String action;
      boolean gameOver = false;
      
      Player playerOne = new Player();
      Player playerTwo = new Player();
      
      Place squareOne = new Place("Go! 0", null, 0, 0, false);
      Place squareTwo = new Place("Junior Lot", null, 50, 2, true);
      //make railroad
      Place squareThree = new Place("Field 1 port-a-potty", null, 200, 25, false, "rairoad");
      Place squareFour = new Place("Chance Card 1", null, 0, 0, false, "card");
      Place squareFive = new Place("DEJI", null, 150, 0, false, "company");
      Place squareSix = new Place("Stairs (from junior lot)", null, 100, 6, true);
      Place squareSeven= new Place("SRB", null, 0, 0, false, "jail");
      Place squareEight= new Place("Gola Room", null, 150, 12, true);
      Place squareNine= new Place("Chance Card 2", null, 0, 0, false, "card");
      //make railroad
      Place squareTen= new Place("Humanities Bathroom", null, 200, 25, false, "railroad");
      Place squareEleven= new Place("College Counseling", null, 170, 14, true);
      Place squareTwelve= new Place("Mia's Classroom", null, 200, 16, true);
      Place squareThirteen= new Place("Flagpole", null, 0, 0, false);
      Place squareFourteen= new Place("Library", null, 250, 18, true);
      //make railroad
      Place squareFifteen= new Place("TLC Bathroom", null, 200, 25, false, "railroad");
      Place squareSixteen= new Place("ASB", null, 150, 0, false, "comapny");
      Place squareSeventeen= new Place("Student Center", null, 270, 22, true);
      Place squareEighteen= new Place("Fishbowl", null, 290, 22, true);
      Place squareNineteen= new Place("Go to SRB",null, 0, 0, false, "gojail");
      Place squareTwenty= new Place("Gerald's Classroom", null, 300, 26, true);
      //make railroad
      Place squareTwentyOne= new Place("MathSci Bathroom", null, 200, 25, false, "railroad");
      Place squareTwentyTwo= new Place("Chance Card 3", null, 0, 0, false, "card");
      Place squareTwentyThree= new Place("Idea Lab", null, 350, 35, true);
      Place squareTwentyFour= new Place("MathSci Conference Room", null, 400, 50, true);
      
  
      Place[] board = {squareOne, squareTwo, squareThree, squareFour, squareFive, squareSix, squareSeven};
      Player[] order = {playerOne, playerTwo};
      ArrayList<String> positions = new ArrayList<String>();
      for(int i = 0; i < board.length; i++){
         String temp = "";
         for(int j = 0; j < board[i].getName().length(); j++){
            temp+="_";
         }
         positions.add(temp);
      }
      positions.set(0,"1&2");
      int turn = 0;
     //Game loop
      while(!gameOver){
         System.out.print("[");
         for(int i = 0; i < board.length-1; i++){
            System.out.print(board[i].getName()+", ");
         }
         System.out.println(board[board.length-1].getName()+"]");
         System.out.println(positions);
         System.out.println("What do you want to do player " +(turn%2+1)+"?");
         action = myObj.next();
         //moves player and moves to next turn.
         
         //actions
         if(action.toLowerCase().equals("move")){
            if(order[turn % 2].isJail()){
               board[order[turn % 2].getPos()].runPlace(order[turn % 2]);
               turn++;
            }
            else{
               //needs to have a section that edits player position.
               //int moveAmount = (int)(Math.random()*6)+(int)(Math.random()*6)+2;
               int moveAmount= myObj.nextInt();
               order[turn % 2].move(moveAmount);
               board[order[turn % 2].getPos()].runPlace(order[turn % 2]);
               turn++;
            }
         }
         //get money of current player
         else if(action.toLowerCase().equals("money")){
            System.out.println(order[turn%2].getBank());
         }
         //tester method
         else if(action.toLowerCase().equals("position")){
            System.out.println(order[turn%2].getPos());
         }
         //prints all owned properties 
         else if (action.toLowerCase().equals("owned")){
            System.out.print("[");
            for(int i = 0; i<order[turn%2].ownPlace().size(); i++){
               //broken adds an extra space and might want to be re formated
               System.out.print(order[turn%2].ownPlacePosition(i).getName()+" ");
            }
            System.out.print("]");
            
         }
         else if(action.toLowerCase().equals("forcemove")){
            int moveAmount = myObj.nextInt();
            order[turn % 2].move(moveAmount);
            board[order[turn % 2].getPos()].runPlace(order[turn % 2]);
            turn++;
         }
         //fail method
         else{
            System.out.println("Inavlid Command");
         }
         
        
         
     
      }
  
   }  
 

}

