



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
            System.out.println("Overlake cafeteria gave you salmonella. Hospital bills are expensive. Kim Stevens needs a raise after your projectile vomit. School sues.");
            play.take(play.getBank() - 1);
         }
         if(randNum == 2){
            System.out.println("No more depression! Summer time.");
            play.give(1000);
         }
         if(randNum == 3){
         //add Game.getBoard 
            System.out.println("Chris wants to give you donuts! You've been moved to Mathsci Conference Room");
            //play.move(INSERT BOARD LENGTH- 1 - play.getPos());
         }
         if(randNum == 4){
            System.out.println("You were caught cheating, and get sent to SRB.");
            //add jail location and test
            //play.forceMove(INSERTBOARD LENGTH/ 4 + 1);
         }
      }
      
      //Company cards 
      if(this.isSpecial.toLowerCase().equals("company")){
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

                  }
                  else {
                     System.out.println("Not a valid response");
                  }
              }
               
         }
         else if(this.owner == play){
 
         }
         else{
            int randomRent = (int)(Math.random()*6)+(int)(Math.random()*6)+2;
            System.out.println("You rolled: " + randomRent + "  and must pay: " + randomRent * 4);
            play.take(randomRent * 4);
            owner.give(randomRent * 4);
         }
         
      }
      
      //jail
      if(this.isSpecial.toLowerCase().equals("jail")){
      
      
         if(play.isJail()){
         
            if(play.getTimeJail() == 3){
               play.take(50);
               System.out.println("You stayed in jail too long. Pay $50 bail and leave.");
            }
            
            else{
               int roll1 = (int)(Math.random()*6) + 1;
               int roll2 = (int)(Math.random()*6) + 1;
               System.out.println(roll1);
               System.out.println(roll2);
            
               if(roll1 == roll2){
                  play.outJail();
                  System.out.println("Lucky! You are out of jail");
               }
               else{
                  System.out.println("Unlucky! You are still in jail.");
               }
               
            }
            
         } 
      
      }
      
      if(this.isSpecial.toLowerCase().equals("gojail")){
         
         System.out.println("You moms going to jail. Bye bye.");
         play.goToJail();
      
      }
      
      
   }
   
   //Railroad Cards
   if(this.isSpecial.toLowerCase().equals("railroad")){
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

                  }
                  else {
                     System.out.println("Not a valid response");
                  }
              }
               
         }
         else if(this.owner == play){
 
         }
         else{
            for(Place a: this.ownPlace()){
            //fix later (multiply by the number of railroads owned)
               if(a.isSpecial.toLowerCase().equals("railroad")
            
            }
         }
         
      }

   public String getName(){
      return this.name;
   }
 
 }
 
 

 
 
