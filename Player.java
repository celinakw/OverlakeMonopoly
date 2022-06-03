//Final Project
//Alec Zoe Felix Celina Gavin
//Overlake Monopoly
//Player class Creates players
import java.util.*;
public class Player{

    private int bank;
    private int pos;
    private boolean inJail;
    private int timeJail;
    private String name;
    private ArrayList<Place> owned = new ArrayList<Place>();
   
    public Player(){
   
       bank = 1500;
       pos = 0;
       inJail= false;
       timeJail = 0;
   
    }
   
    public void give(int num){
   
       bank += num;
   
    }
   
    public void take(int num){
   
       bank -= num;
   
    }
   
    public void move(int num){
   
       for(int i = num; i > 0; i--){
          if(pos == 23){
            pos = 0;
            bank+= 200;
            System.out.println("You passed go! ");
          }
          else{
             pos++;
          }
            
       }
   
    }
    
    public void forceMove(int loc){
    
      pos = loc;
    
    }
 
    public ArrayList<Place> ownPlace(){
      return owned;
    }
    public Place ownPlacePosition(int num){
      return owned.get(num);
    }
    public void addPlace(Place input){
      owned.add(input);
    }
   
    public int getBank(){
       return bank;
    }
    public int getPos(){
       return pos;
    }
    
    public void goToJail(){
    
      inJail = true;
      forceMove(6);
    
    }
    
    public boolean isJail(){
    
      return inJail;
    
    }
    
    public void outJail(){
    
      inJail = false;
      timeJail = 0;
      
    }
    
    public int getTimeJail(){
    
      return timeJail;
    
    }
    
    public void jailNextTurn(){
    
      this.timeJail ++;
    
    }
    
    public String getName(){
      return name;
    }
   
   
    public void changeName(String newName){
      name = newName;
    }
    

 
 
 }