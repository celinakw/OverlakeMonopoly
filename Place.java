

//Final Project
//Alec Zoe Felix Celina Gavin
//Overlake Monopoly
//place class creates the place objects of the game
import java.util.*;
public class Place{

   private Player owner;
   private int cost;
   private int rent;
   private String name;
   private boolean isPlace;
   private String isSpecial = "no";
   private boolean finished = false;
   //special place constructor
   public Place(String placeName ,Player person, int costs, int rents, boolean place, String special){
      owner = person;
      cost = costs;
      rent = rents;
      name = placeName;
      isPlace = place;
      isSpecial = special;
      
    }
    //non special constructor
   public Place(String placeName ,Player person, int costs, int rents, boolean place){
      owner = person;
      cost = costs;
      rent = rents;
      name = placeName;
      isPlace = place;
      
      
    }
   
    public void runPlace(Player play){
       if(this.isPlace){
         if(this.owner ==  null){
              System.out.println("Do you want to buy "+this.name+ "? Cost to buy: " + cost);
              Scanner myObj = new Scanner(System.in);
              String response = myObj.nextLine();
              finished = false;
              while(finished == false){
                  if(response.toLowerCase().equals("yes")){
                     play.take(cost);
                     this.owner = play;
                     play.addPlace(this);
                     finished = true;
                  }
                  else if (response.toLowerCase().equals("no")){
                     finished = true;
                     //auction or does nothing
                     //I dont think auctions are the best idea, maybe we can add it later
                  }
                  else {
                     System.out.println("Not a valid response");
                  }
              }
               
         }
         else if(this.owner == play){
 
         }
         else{
            play.take(rent);
            owner.give(rent);
         }
       }

       //Chance cards
       if(this.isSpecial.toLowerCase().equals("card")){
         int randNum = (int)(Math.random() * 5);

         if(randNum == 0){
            System.out.println("You fail ap calc exam, Rhonda wants 50 dollars back. ");
            play.take(50);
         }
         if(randNum == 1){
            System.out.println("Overlake cafeteria gave you salmonella. Hospital bills are expensive. Kim Stevens needs a raise after your projectile vomid. School sues.");
            play.take(play.getBank() - 1);
         }
         if(randNum == 2){
            System.out.println("No more depression! Summer time.");
            play.give(1000);
         }
         if(randNum == 3){
         //add Game.getBoard 
            System.out.println("Chris wants to give you donuts! You've been moved to Mathsci Conference Room");
            play.move(Game.getBoard() - 1 - play.getPos());
         }
         if(randNum == 4){
            System.out.println("You're caught cracking your mom jokes, get sent to SRB.");
            //add jail location and test
            play.forceMove(Game.getBoard.length / 4 + 1);
         }
      }
   }
   
   public String getName(){
      return this.name;
   }
 
 }
 
 
