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
   private int set;
   private int numHouses;
   private String monopolies;
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
   public Place(String placeName ,Player person, int costs, int rents, boolean place, int sets, int houses, String mono){
      owner = person;
      cost = costs;
      rent = rents;
      name = placeName;
      isPlace = place;
      set = sets;
      numHouses = houses;
      monopolies = mono;
    }
   
    public void runPlace(Player play){
      
      
       if(isSpecial.equals("no")){
         System.out.println("You landed on the place, " + this.getName());
       }
       else{
         System.out.println("You landed on, " + this.getName() + ". Which is: " + this.getIsSpecial());
       }
       
       if(this.isPlace){
         if(this.owner ==  null){
              System.out.println("Do you want to buy " + this.name + "? Cost to buy: " + cost +". Rent is: " + this.rent + ". \"yes\" or \"no\"");
              Scanner myObj = new Scanner(System.in);
              finished = false;
              while(finished == false){
                  String response = myObj.nextLine();
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
                     System.out.println("Do you want to buy "+this.name+ "? Cost to buy: " + cost + ". \"yes\" or \"no\"");
                  }
              }
               
         }
         else if(this.owner == play){
         
            int counter = 0;
            for(Place item : (this.owner).ownPlace()){
               if(item.getMono().equals(this.getMono())){
               counter++;
               }
            }
            if(counter == 3){
               Scanner myObj = new Scanner(System.in);
               
               int housePrice = cost;
               
               if(numHouses == 3){
                  System.out.println("Do you want to buy a hotel? It costs " + housePrice);
         
                  String input = myObj.nextLine();
         
                  if(input.toLowerCase().equals("yes")){
         
                     owner.take(housePrice);
            
                     rent *= 3;
            
                     numHouses++;
            
                     System.out.println("Rent is now $" + rent);
            
                     System.out.println("You now have $" + this.owner.getBank());
            
                  }
               }
               
               else{
               
                  System.out.println("Do you want to buy a house? It costs " + housePrice);
         
                  String input = myObj.nextLine();
         
                  if(input.toLowerCase().equals("yes")){
         
                     owner.take(housePrice);
            
                     rent *= 2;
            
                     numHouses++;
            
                     System.out.println("Rent is now $" + rent);
            
                     System.out.println("You now have $" + this.owner.getBank());
            
                  }

               }
            }
         }
         else{
            int counter = 0;
            for(Place item : (this.owner).ownPlace()){
               if(item.getMono().equals(this.getMono())){
                  counter++;
               }
            }
            if(counter == 3){
               System.out.println("You landed on " + owner.getName() +"'s monopoly and must pay rent: " + rent);
               play.take(rent * 3);
               owner.give(rent * 3);
            }
            else{
               System.out.println("You landed on " + owner.getName() +"'s house and must pay rent: " + rent);
               play.take(rent);
               owner.give(rent);
            }

         }
       }

       //Chance cards
       if(this.isSpecial.toLowerCase().equals("card")){
         double randNum = (Math.random() * 5);

         if(randNum < 1){
            System.out.println("You fail ap calc exam, Rhonda wants 50 dollars back. ");
            play.take(50);
         }
         else if(randNum < 1.25){
            System.out.println("Overlake cafeteria gave you salmonella. Hospital bills are expensive. Kim Stevens needs a raise after your projectile vomit. School sues.");
            if(play.getBank() <= 1){
               play.take(1);
            }
            else{
               play.take(play.getBank()-1);
            }
            
         }
         else if(randNum < 1.5 ){
            System.out.println("No more depression! Summer time.");
            play.give(1000);
         }
         else if(randNum < 1.6){
            System.out.println("u lost.");
            play.take(play.getBank());
         }
         else if(randNum < 3){
         //add Game.getBoard 
            System.out.println("Chris wants to give you donuts! You've been moved to Mathsci Conference Room");
            //play.move(INSERT BOARD LENGTH- 1 - play.getPos());
         }
         else if(randNum < 4){
            System.out.println("You were caught cheating, and get sent to SRB.");
            play.goToJail();
         }
         else if(randNum < 5){
         //fix this and the one above 
            System.out.println("Your computer died, you go to the TLC tech center, but they break your computer, and you must pay $500");
            play.take(500);
            //play.move(INSERT BOARD LENGTH- 1 - play.getPos());
         }
      }
      
      //Company cards 
      if(this.isSpecial.toLowerCase().equals("company")){
         if(this.owner ==  null){
              System.out.println("Do you want to buy "+this.name+ "? Cost to buy: " + cost + ". \"yes\" or \"no\"");
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
                     System.out.println("Do you want to buy "+this.name+ "? Cost to buy: " + cost + ". \"yes\" or \"no\"");
                     response = myObj.nextLine();

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
         
            if(play.getTimeJail() == 2){
               play.take(50);
               System.out.println("You stayed in jail too long. Pay $50 bail and leave.");
               play.outJail();
            }
            
            else{
               int roll1 = (int)(Math.random()*6) + 1;
               int roll2 = (int)(Math.random()*6) + 1;
               System.out.println(roll1);
               System.out.println(roll2);
            
               if(roll1 == roll2){
                  play.outJail();
                  System.out.println("Lucky! You are out of jail. Make your move.");
                  
               }
               else{
                  System.out.println("Unlucky! You are still in jail.");
                  play.jailNextTurn();
               }
               
            }
            
         } 
      
      }
      
      if(this.isSpecial.toLowerCase().equals("gojail")){
         
         System.out.println("Your mom's going to jail. Bye bye.");
         play.goToJail();
      
      }
      
   

   
   
   //Railroad Cards
   if(this.isSpecial.toLowerCase().equals("railroad")){
         if(this.owner ==  null){
              System.out.println("Do you want to buy "+this.name+ "? Cost to buy: " + cost + ". \"yes\" or \"no\"");
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
                     System.out.println("Do you want to buy "+this.name+ "? Cost to buy: " + cost + ". \"yes\" or \"no\"");
                     response = myObj.nextLine();
                  }
              }
               
         }
        
         else if(this.owner == play){
 
         }
         else{
            int numRailroads = 0;
            for(Place a: owner.ownPlace()){
            //fix later (multiply by the number of railroads owned)
               if(a.isSpecial.toLowerCase().equals("railroad")) {
               
                  numRailroads++;
               
               }
            
            }
            
            System.out.println("You pay: " + (rent * Math.pow(2, numRailroads)));
            owner.give(rent * (int)(Math.pow(2, numRailroads)));
            play.take(rent * (int)(Math.pow(2, numRailroads)));
            
         }
         
      }
      
  }
   
  /*public void house(){
  
   Scanner sc = new Scanner(System.in);
   
   if(this.getIsSpecial().equals("no") && this.owner.ownPlace().size() > 1){
   
      boolean checkAllOwned = true;

  
      for(Place a: this.owner.ownPlace()){
        
         if(a.getSet() == this.getSet() || a.getOwner() != owner){
         
             checkAllOwned = false;
             
             break;
         
         }
      
      }
      
      if(checkAllOwned && numHouses < 4){
      
         int housePrice = cost / 2;
      
         System.out.println("Do you want to buy a house? It costs " + housePrice);
         
         String input = sc.nextLine();
         
         if(input.toLowerCase().equals("yes")){
         
            owner.take(housePrice);
            
            rent *= 3;
            
            numHouses++;
            
            System.out.println("Rent is now $" + rent);
            
            System.out.println("You now have $" + this.owner.getBank());
         
         }
      
      }
   
   }
  
  
  }*/
   
   
   
   public String getName(){
      return this.name;
   }
   public String getIsSpecial(){
      return this.isSpecial;
   }
   
   public int getSet(){
      return this.set;
   
   }
   
   public Player getOwner(){
      return this.owner;
   }
   
   public String getMono(){
      return monopolies;
   
   }
 
 }
 
 
 
 

 
 

 
 
