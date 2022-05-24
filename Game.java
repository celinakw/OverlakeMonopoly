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
      
      Place squareOne = new Place("Go!",null, 0, 0, false);
      Place squareTwo = new Place("place 1",null, 300, 100, true);
      Place squareThree = new Place("place 2",null, 400, 150,true);
      Place squareFour = new Place("Chance Card 3",null, 0, 0, false, "card");
      Place squareFive = new Place("Water Works",null, 150, 0, false, "company");
      Place squareSix = new Place("SRB",null, 0, 0, false, "jail");
      Place squareSeven= new Place("Go to SRB",null, 0, 0, false, "gojail");
      
  
      Place[] board = {squareOne, squareTwo, squareThree, squareFour, squareFive, squareSix, squareSeven};
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
         System.out.print("[");
         for(int i = 0; i < board.length-1; i++){
            System.out.print(board[i].getName()+", ");
         }
         System.out.println(board[board.length-1].getName()+"]");
         System.out.println(positionsPOne);
         System.out.println(positionsPTwo);
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
               // use forcemove instead of changing this function
               int moveAmount = (int)(Math.random()*6)+(int)(Math.random()*6)+2;
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
               
               /*if(turn%2==0){
                  positionsPOne.set(playerOne.getPos(), positions.get(playerOne.getPos()));
                  order[turn % 2].move(moveAmount);
                  positionsPOne.set(playerOne.getPos(), (positions.get(playerOne.getPos()).substring(0,(int)(positions.get(playerOne.getPos()).length()/2))+"1"+positions.get(playerOne.getPos()).substring((int)(positions.get(playerOne.getPos()).length()/2+1),(int)(positions.get(playerOne.getPos()).length()))));
                  turn++;
               }
               else if(turn%2==1){
                  positionsPTwo.set(playerTwo.getPos(), positions.get(playerTwo.getPos()));
                  order[turn % 2].move(moveAmount);
                  positionsPOne.set(playerTwo.getPos(), (positions.get(playerTwo.getPos()).substring(0,(int)(positions.get(playerTwo.getPos()).length()/2))+"1"+positions.get(playerTwo.getPos()).substring((int)(positions.get(playerTwo.getPos()).length()/2+1),(int)(positions.get(playerTwo.getPos()).length()))));
                  turn++;
               }*/
               
               
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
            System.out.println("Inavlid Command");
         }
         
        
         
     
      }
  
   } 
   
 

}

