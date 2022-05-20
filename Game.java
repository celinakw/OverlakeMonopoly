
//Final Project
//Alec Zoe Felix Celina Gavin
//Overlake Monopoly
//Game  class runs the game loop
import java.util.*;

public class Game{


   public static void main(String args[]){
  
      Scanner myObj = new Scanner(System.in);
      String action;
      boolean gameOver = false;
      
      Player playerOne = new Player();
      Player playerTwo = new Player();
      
      Place squareOne = new Place("Go!",null, 0, 0, false);
      Place squareTwo = new Place("Place 1",null, 300, 100, true);
      Place squareThree = new Place("Place 2",null, 400, 150,true);
      Place squareFour = new Place("Chance Card",null, 0, 0, false, "card");
  
      Place[] board = {squareOne, squareTwo, squareThree, squareFour};
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
            //needs to have a section that edits player position.
            int moveAmount = (int)(Math.random()*6)+(int)(Math.random()*6)+2;
            order[turn % 2].move(moveAmount);
            board[order[turn % 2].getPos()].runPlace(order[turn % 2]);
            turn++;
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

