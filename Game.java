
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
  
      Place squareOne = new Place("1",null, 200, 0);
      Place squareTwo = new Place("2",null, 0, 100);
      Place squareThree = new Place("3",null, 0, 150);
      Place squareFour = new Place("4",null, 0, 120);
  
      Place[] board = {squareOne, squareTwo, squareThree, squareFour};
      Player[] order = {playerOne, playerTwo};
    
      int turn = 0;
     //Game loop
      while(!gameOver){
         
         System.out.println("What do you want to do player " +(turn%2+1)+"?");
         action = myObj.next();
         //moves player and moves to next turn.
         
         //actions
         if(action.toLowerCase().equals("move")){
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
         //fail method
         else{
            System.out.println("Inavlid Command");
         }
         
        
         
     
      }
  
   }  
 

}
