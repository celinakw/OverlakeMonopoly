//Final Project
//Alec Zoe Felix Celina Gavin
//Overlake Monopoly
//Game  class runs the game loop
import java.util.*;


public class Game {
    //player track creater call this when you want add a new player
    public static void makePlayerTrack(Place[] board, ArrayList < String > output) {
        for (int i = 0; i < board.length; i++) {
            String temp = "";
            for (int j = 0; j < board[i].getName().length(); j++) {
                temp += "_";
            }
            output.add(temp);
        }
    }
    //changes position on a track
    public static void updatePos(Player player, ArrayList < String > track, ArrayList < String > position, int moveAmount, int playerNum) {
        track.set(player.getPos(), position.get(player.getPos()));
        player.move(moveAmount);
        track.set(player.getPos(), (position.get(player.getPos()).substring(0, (int)(position.get(player.getPos()).length() / 2)) + playerNum + position.get(player.getPos()).substring((int)(position.get(player.getPos()).length() / 2 + 1), (int)(position.get(player.getPos()).length()))));

    }
    public static void updatePos2D(String[][] board, Player player, int moveAmount, int playerNum) {
        if(playerNum==1){
            if((player.getPos()+moveAmount)==0){
                
                if(Math.floor(player.getPos()/6)==3){
                    System.out.println("Channel 3");
                    System.out.println(board[9-(player.getPos()-18)][1]);
                    board[9-(player.getPos()-18)][1]="_";
                    
                }
                else if(Math.floor(player.getPos()/6)==2){
                    System.out.println("Channel 2");
                    board[9][9-(player.getPos()-12)]=board[1][9-(player.getPos()-12)];
                }
                else if(Math.floor(player.getPos()/6)==1){
                    System.out.println("Channel 1");
                    board[1+(player.getPos()-6)][9]="_";
                }
                else if(Math.floor(player.getPos()/6)==0){
                    System.out.println("Channel 0");
                    board[1][1+player.getPos()]=board[9][1+(player.getPos())];
                    
                }
                board[1][1]="1";

            }
            else if((player.getPos()+moveAmount)==18){
                board[9][1]="1";
            }
            else if(player.getPos()+moveAmount==12){
                board[9][9]="1";
            }
            else if(player.getPos()+moveAmount==6){
                board[1][9]="1";
                if(Math.floor(player.getPos()/6)==3){
                    System.out.println("Channel 3");
                    System.out.println(board[9-(player.getPos()-18)][1]);
                    board[9-(player.getPos()-18)][1]="_";
                    
                }
                else if(Math.floor(player.getPos()/6)==2){
                    System.out.println("Channel 2");
                    board[9][9-(player.getPos()-12)]=board[1][9-(player.getPos()-12)];
                }
                else if(Math.floor(player.getPos()/6)==1){
                    System.out.println("Channel 1");
                    board[1+(player.getPos()-6)][9]="_";
                }
                else if(Math.floor(player.getPos()/6)==0){
                    System.out.println("Channel 0");
                    board[1][1+player.getPos()]=board[9][1+(player.getPos())];
                }
            }
            else{
                if(((player.getPos()+moveAmount)/6)>=3){
                    System.out.println(Math.floor(player.getPos()/6));
                    
                    board[(9-moveAmount)][1]="1";
                    if(Math.floor(player.getPos()/6)==3){
                        System.out.println("Channel 3");
                        System.out.println(board[9-(player.getPos()-18)][1]);
                        board[9-(player.getPos()-18)][1]="_";
                        
                    }
                    else if(Math.floor(player.getPos()/6)==2){
                        System.out.println("Channel 2");
                        board[9][9-(player.getPos()-12)]=board[1][9-(player.getPos()-12)];
                    }
                    else if(Math.floor(player.getPos()/6)==1){
                        System.out.println("Channel 1");
                        board[1+(player.getPos()-6)][9]="_";
                    }
                    else if(Math.floor(player.getPos()/6)==0){
                        System.out.println("Channel 0");
                        board[1][1+player.getPos()]=board[9][1+(player.getPos())];
                    }
                }
                else if(((player.getPos()+moveAmount)/6)>=2){

                    board[9][9-moveAmount]=board[1][2+(player.getPos()-12)].substring(0,board[1][2+(player.getPos()-12)].length()/2)+playerNum+board[1][2+(player.getPos()-12)].substring(board[1][2+(player.getPos()-12)].length()/2);
                        if(board[9][9-moveAmount].length()<board[1][2+(player.getPos()-12)].length()){
                            board[9][9-moveAmount]+="_";
                            System.out.println("Extending");
                        }
                        else if(board[9][9-moveAmount].length()>board[1][2+(player.getPos()-12)].length()){
                            board[9][9-moveAmount].substring(board[9][9-moveAmount].length()-2);
                            System.out.println("Removing");
                        }
                    if(Math.floor(player.getPos()/6)==3){
                        System.out.println("Channel 3");
                        System.out.println(board[9-(player.getPos()-12)][1]);
                        board[9-(player.getPos()-18)][1]="_";
                        
                    }
                    else if(Math.floor(player.getPos()/6)==2){
                        System.out.println("Channel 2");
                        board[9][9-(player.getPos()-12)]=board[1][9-(player.getPos()-12)];
                        
                    }
                    else if(Math.floor(player.getPos()/6)==1){
                        System.out.println("Channel 1");
                        board[1+(player.getPos()-6)][9]="_";
                    }
                    else if(Math.floor(player.getPos()/6)==0){
                        System.out.println("Channel 0");
                        board[1][1+player.getPos()]=board[9][1+(player.getPos())];
                    }
                }
                else if(((player.getPos()+moveAmount)/6)>=1){
                    board[9][1+moveAmount]="1";
                    
                    if(Math.floor(player.getPos()/6)==3){
                        System.out.println("Channel 3");
                        System.out.println(board[9-(player.getPos())][1]);
                        board[9-(player.getPos())][1]="_";
                        
                    }
                    else if(Math.floor(player.getPos()/6)==2){
                        System.out.println("Channel 2");
                        board[1][1+(player.getPos())]=board[1][1+(player.getPos())];
                        
                    }
                    else if(Math.floor(player.getPos()/6)==1){
                        System.out.println("Channel 1");
                        board[1+(player.getPos())][9]="_";
                    }
                    else if(Math.floor(player.getPos()/6)==0){
                        System.out.println("Channel 0");
                        board[1][1+player.getPos()]=board[9][1+(player.getPos())];
                        board[1][2+player.getPos()]=board[9][2+(player.getPos())];
                    }
            }
            else if(((player.getPos()+moveAmount)/6)>=0){
                
                board[1][2+moveAmount+player.getPos()]=board[1][2+(moveAmount+player.getPos())].substring(0,board[1][2+(moveAmount+player.getPos())].length()/2)+playerNum+board[1][2+(moveAmount+player.getPos())].substring(board[1][2+(moveAmount+player.getPos())].length()/2);
                while(board[1][2+moveAmount+player.getPos()].length()!=board[9][2+moveAmount+player.getPos()].length()){
                    if(board[1][2+moveAmount+player.getPos()].length()>board[9][2+moveAmount+player.getPos()].length()){
                        board[1][2+moveAmount+player.getPos()]=board[1][2+moveAmount+player.getPos()].substring(0,board[1][2+moveAmount+player.getPos()].length()-1);
                    }
                    else if(board[1][2+moveAmount].length()<board[9][2+moveAmount].length()){
                        board[1][2+moveAmount]+="_";
                    }

                    
                }
                
                    
                if(Math.floor(player.getPos()/6)==3){
                    System.out.println("Channel 3");
                    System.out.println(board[9-(player.getPos())][1]);
                    board[9-(player.getPos())][1]="_";
                    
                }
                else if(Math.floor(player.getPos()/6)==2){
                    System.out.println("Channel 2");
                    board[1][1+(player.getPos())]=board[1][1+(player.getPos())];
                    
                }
                else if(Math.floor(player.getPos()/6)==1){
                    System.out.println("Channel 1");
                    board[1+(player.getPos())][9]="_";
                }
                else if(Math.floor(player.getPos()/6)==0){
                    System.out.println("Channel 0");
                    board[1][1+player.getPos()]=board[9][1+(player.getPos())];
                    board[1][2+player.getPos()]=board[9][2+(player.getPos())];
                }
            }
        }
    }
    }
    public static void boardMakerTopBot(String[][] gameBoard, int arrayMod, Place[] board, int collumnMod, int rowMod, int lengthMinus, int opp, int grabMod, boolean bot) {
        for (int i = 0; i < gameBoard.length - lengthMinus; i++) {
            String temp = "";
            if (bot == false) {
                
                if (i == 0) {
                    String longest = "";
                    for (int a = 0; a < gameBoard[i].length - lengthMinus; a++) {
                        
                        if (longest.length() < board[a + arrayMod].getName().length()) {
                            longest = board[a + arrayMod].getName();

                        }
                        if (longest.length() < board[23 - a].getName().length()) {
                            longest = board[23 - a].getName();
                        }
                    }
                    
                    for (int x = 0; x < (longest.length() - board[i + opp].getName().length()) / 2; x++) {
                        temp += " ";
                    }
                    gameBoard[2 + rowMod][i + collumnMod] = temp + board[i].getName() + temp;
                    while (gameBoard[2 + rowMod][i + collumnMod].length() != longest.length()) {
                        if (gameBoard[2 + rowMod][i + collumnMod].length() > longest.length()) {
                            gameBoard[2 + rowMod][i + collumnMod] = gameBoard[2 + rowMod][i + collumnMod].substring(0, gameBoard[2 + rowMod][i + collumnMod].length() - 2);
                        } else if (gameBoard[2 + rowMod][i + collumnMod].length() < longest.length()) {
                            gameBoard[2 + rowMod][i + collumnMod] += " ";
                        }
                    }
                } else if (i == 6) {

                    String longest = "";
                    for (int a = 0; a < gameBoard[i].length - lengthMinus; a++) {

                        if (longest.length() < board[a + (24 - arrayMod)].getName().length()) {
                            longest = board[a + (24 - arrayMod)].getName();

                        }
                    }
                    for (int x = 0; x < (longest.length() - board[opp - i].getName().length()) / 2; x++) {
                        temp += " ";
                    }
                    gameBoard[2 + rowMod][i + collumnMod] = temp + board[opp - i].getName() + temp;
                    while (gameBoard[2 + rowMod][i + collumnMod].length() != longest.length()) {
                        if (gameBoard[2 + rowMod][i + collumnMod].length() > longest.length()) {
                            gameBoard[2 + rowMod][i + collumnMod] = gameBoard[2 + rowMod][i + collumnMod].substring(0, gameBoard[2 + rowMod][i + collumnMod].length() - 2);
                        } else if (gameBoard[2 + rowMod][i + collumnMod].length() < longest.length()) {
                            gameBoard[2 + rowMod][i + collumnMod] += " ";
                        }
                    }
                } 
                
                else if (board[i + grabMod].getName().length() < board[18-i].getName().length()) {
                    System.out.println(board[18-i].getName());
                    for (int x = 0; x < (board[18-i].getName().length() - board[i].getName().length()) / 2 + 1; x++) {
                        temp += " ";
                    }
                    gameBoard[2][i + collumnMod] = temp + board[i].getName() + temp;
                    while (gameBoard[2][i + collumnMod].length() != (board[18-i].getName().length())) {
                        if (gameBoard[2 + rowMod][i + collumnMod].length() > (board[18-i].getName().length())) {
                            gameBoard[2 + rowMod][i + collumnMod] = gameBoard[2 + rowMod][i + collumnMod].substring(0, gameBoard[2 + rowMod][i + collumnMod].length() - 2);
                        } else if (gameBoard[2 + rowMod][i + collumnMod].length() < (board[18-i].getName().length())) {
                            gameBoard[2 + rowMod][i + collumnMod] += " ";
                        }
                    }
                } else {
                    gameBoard[2][i + collumnMod] = board[i].getName();
                }
            } else {
                if (i == 0) {
                    String longest = "";
                    for (int a = 0; a < gameBoard[i].length - lengthMinus; a++) {

                        if (longest.length() < board[a + arrayMod].getName().length()) {
                            longest = board[a + arrayMod].getName();

                        }
                    }
                    for (int x = 0; x < (longest.length() - board[opp - i].getName().length()) / 2; x++) {
                        temp += " ";
                    }
                    gameBoard[2 + rowMod][i + collumnMod] = temp + board[opp - i].getName() + temp;
                } else if (i == 6) {
                    String longest = "";
                    for (int a = 0; a < gameBoard[i].length - lengthMinus; a++) {

                        if (longest.length() < board[a + (24 - opp)].getName().length()) {
                            longest = board[a + (24 - opp)].getName();
                        }
                    }
                    for (int x = 0; x < (longest.length() - board[opp - i].getName().length()) / 2; x++) {
                        temp += " ";
                    }
                    gameBoard[2 + rowMod][i + collumnMod] = temp + board[opp - i].getName() + temp+" ";
                    
                    
                } 
                
                else if (board[i + grabMod].getName().length() > board[opp - i].getName().length()) {

                    for (int x = 0; x < (board[i + grabMod].getName().length() - board[opp - i].getName().length()) / 2; x++) {
                        temp += " ";
                    }

                    gameBoard[2 + rowMod][i + collumnMod] = temp + board[opp - i].getName() + temp;
                    if(i==5){
                        gameBoard[2 + rowMod][i + collumnMod] +=" ";
                    }

                } else {

                    gameBoard[2 + rowMod][i + collumnMod] = board[opp - i].getName();


                }
            }


        }
    }
    //SideBoardMaker(gameBoard, 7, board, 2, 3,6,23,0, true);
    public static void SideBoardMaker(String[][] gameBoard, int arrayMod, Place[] board, int collumnMod, int rowMod, int lengthMinus, int opp, int grabMod, boolean left) {
        for (int i = 0; i < gameBoard.length - lengthMinus; i++) {
            String temp = "";
            if (left == false) {

                String longest = "";
                for (int a = 0; a < gameBoard[i].length - lengthMinus; a++) {

                    if (longest.length() < board[a + arrayMod].getName().length()) {
                        longest = board[a + arrayMod].getName();

                    }
                }
                for (int x = 0; x < (longest.length() - board[i + opp].getName().length()) / 2; x++) {
                    temp += " ";
                }
                gameBoard[i + rowMod][collumnMod] = temp + board[i + arrayMod].getName() + temp;
               while(gameBoard[i + rowMod][collumnMod].length()!=longest.length()){
                  if(gameBoard[i + rowMod][collumnMod].length()>longest.length()){
                     if(gameBoard[i + rowMod][collumnMod].substring(gameBoard[i + rowMod][collumnMod].length()-2,gameBoard[i + rowMod][collumnMod].length()-1).equals(" ")){
                        gameBoard[i + rowMod][collumnMod] = gameBoard[i + rowMod][collumnMod].substring(0,gameBoard[i + rowMod][collumnMod].length()-2);
                     }
                     else{
                        gameBoard[i + rowMod][collumnMod] = gameBoard[i + rowMod][collumnMod].substring(1);
                     }
                  }
                  else if(gameBoard[i + rowMod][collumnMod].length()<longest.length()){
                     gameBoard[i + rowMod][collumnMod]+=" ";
                  }
               }
               gameBoard[i + rowMod][collumnMod] += "";


            } else {

                String longest = "";
                for (int a = 0; a < gameBoard[i].length - lengthMinus; a++) {


                    if (longest.length() < board[opp - a].getName().length()) {
                        longest = board[opp - a].getName();

                    }
                }
                for (int x = 0; x < (longest.length() - board[opp - i].getName().length()) / 2; x++) {
                    temp += " ";
                }
                gameBoard[i + rowMod][collumnMod] = temp + board[opp - i].getName() + temp;
                while(gameBoard[i + rowMod][collumnMod].length() != longest.length()){
                  if(gameBoard[i + rowMod][collumnMod].length()>longest.length()){
                     gameBoard[i + rowMod][collumnMod] = gameBoard[i + rowMod][collumnMod].substring(0,gameBoard[i + rowMod][collumnMod].length()-2);
                  }
                  else if(gameBoard[i + rowMod][collumnMod].length()<longest.length()){
                     gameBoard[i + rowMod][collumnMod]+=" ";
                  }
                }
              }
            }
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



        Place[] board = {
            squareOne,
            squareTwo,
            squareThree,
            squareFour,
            squareFive,
            squareSix,
            squareSeven,
            squareEight,
            squareNine,
            squareTen,
            squareEleven,
            squareTwelve,
            squareThirteen,
            squareFourteen,
            squareFifteen,
            squareSixteen,
            squareSeventeen,
            squareEighteen,
            squareNineteen,
            squareTwenty,
            squareTwentyOne,
            squareTwentyTwo,
            squareTwentyThree,
            squareTwentyFour
        };
        Player[] order = {
            playerOne,
            playerTwo
        };
        ArrayList < String > positions = new ArrayList < String > ();
        makePlayerTrack(board, positions);
        ArrayList < String > positionsPOne = new ArrayList < String > ();
        makePlayerTrack(board, positionsPOne);
        ArrayList < String > positionsPTwo = new ArrayList < String > ();
        makePlayerTrack(board, positionsPTwo);

        /*Making 2d array game board to do this i need to make a 11by 11 game board*/
        String[][] gameBoard = new String[11][11];



        //top board spaces
        boardMakerTopBot(gameBoard, 17, board, 2, 0, 4, 12, 0, false);

        //bottom board space
        boardMakerTopBot(gameBoard, 0, board, 2, 6, 4, 18, 0, true);

        //left side board space
        SideBoardMaker(gameBoard, 7, board, 2, 3, 6, 23, 0, true);


        //right side board space
        SideBoardMaker(gameBoard, 7, board, 8, 3, 6, 0, 0, false);
        //top
        for (int x = 0; x < gameBoard[x].length - 4; x++) {
            String temp = "";

            for (int a = 0; a < gameBoard[2][x + 2].length(); a++) {
                temp += "_";
            }
            gameBoard[0][x + 2] = temp;
            gameBoard[1][x + 2] = temp;
        }
        //bottom
        for (int x = 0; x < gameBoard[x].length - 4; x++) {
            String temp = "";

            for (int a = 0; a < gameBoard[8][x + 2].length(); a++) {
                temp += "_";
            }
            gameBoard[9][x + 2] = temp;
            gameBoard[10][x + 2] = temp;
        }
        //side
        for (int x = 0; x < gameBoard[x].length - 1; x++) {
            String temp = "_";
            gameBoard[x][0] = temp;
            gameBoard[x][1] = temp;
        }
        //side 2
        for (int x = 0; x < gameBoard[x].length - 1; x++) {
            String temp = "_";
            gameBoard[x][9] = temp;
            gameBoard[x][10] = temp;
        }
        gameBoard[10][0] = "_";
        gameBoard[10][1] = "_";
        gameBoard[10][9] = "_";
        gameBoard[10][10] = "_";
        //middle
        for (int x = 0; x < gameBoard[x].length - 6; x++) {
            String temp = "";

            for (int a = 0; a < gameBoard[8][x + 3].length(); a++) {
                temp += " ";
            }
            gameBoard[3][x + 3] = temp;
            gameBoard[4][x + 3] = temp;
            gameBoard[5][x + 3] = temp;
            gameBoard[6][x + 3] = temp;
            gameBoard[7][x + 3] = temp;
        }
        

        positionsPOne.set(0, "_1_");
        positionsPTwo.set(0, "_2_");
        int turn = 0;
        updatePos2D(gameBoard, order[turn%2],0, 1);
        //Game loop
        while (!gameOver) {
            //need to change the board to work on a 2d array list probaby or use an abreviation system as the board is huge
            for (int i = 0; i < gameBoard.length; i++) {
                System.out.print("|");
                for (int j = 0; j < gameBoard[i].length; j++) {
                    System.out.print(gameBoard[i][j] + "|");
                }
    
                System.out.println();
            }

            System.out.println(positionsPOne);
            System.out.println(positionsPTwo);
            System.out.println("What do you want to do " + order[(turn % 2)].getName() + "?");
            action = myObj.next();

            //moves player and moves to next turn.

            //actions
            if (action.toLowerCase().equals("move")) {
                if (order[turn % 2].isJail()) {
                    board[order[turn % 2].getPos()].runPlace(order[turn % 2]);
                    if (!(order[turn % 2].isJail())) {
                        int moveAmount = (int)(Math.random() * 6) + (int)(Math.random() * 6) + 2;
                        if (turn % 2 == 0) {
                            updatePos2D(gameBoard, order[turn%2],moveAmount, 1);
                            updatePos(order[turn % 2], positionsPOne, positions, moveAmount, turn % 2 + 1);
                            board[order[turn % 2].getPos()].runPlace(order[turn % 2]);
                            turn++;
                        } else if (turn % 2 == 1) {
                            updatePos(order[turn % 2], positionsPTwo, positions, moveAmount, turn % 2 + 1);
                            board[order[turn % 2].getPos()].runPlace(order[turn % 2]);
                            turn++;
                        }
                    }
                    turn++;
                } else {
                    int moveAmount = (int)(Math.random() * 6) + (int)(Math.random() * 6) + 2;
                    if (turn % 2 == 0) {
                        updatePos2D(gameBoard, order[turn%2],moveAmount, 1);
                        updatePos(order[turn % 2], positionsPOne, positions, moveAmount, turn % 2 + 1);
                        board[order[turn % 2].getPos()].runPlace(order[turn % 2]);
                        turn++;
                    } else if (turn % 2 == 1) {
                        updatePos(order[turn % 2], positionsPTwo, positions, moveAmount, turn % 2 + 1);
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
                System.out.println("You have $" + order[(turn - 1) % 2].getBank() + " left in your bank account.");
            }
            //get money of current player
            else if (action.toLowerCase().equals("money")) {
                System.out.println(order[turn % 2].getBank());
            }
            //tester method
            else if (action.toLowerCase().equals("position")) {
                System.out.println(order[turn % 2].getPos());
            }
            //prints all owned properties 
            else if (action.toLowerCase().equals("owned")) {
                System.out.print("[");
                for (int i = 0; i < order[turn % 2].ownPlace().size(); i++) {
                    //broken adds an extra space and might want to be re formated
                    System.out.print(order[turn % 2].ownPlacePosition(i).getName() + " ");
                }
                System.out.print("]");

            } else if (action.toLowerCase().equals("forcemove")) {
                int moveAmount = myObj.nextInt();
                if (turn % 2 == 0) {
                    updatePos2D(gameBoard, order[turn%2],moveAmount, 1);
                    updatePos(order[turn % 2], positionsPOne, positions, moveAmount, turn % 2 + 1);
                    board[order[turn % 2].getPos()].runPlace(order[turn % 2]);
                    
                    turn++;
                } else if (turn % 2 == 1) {
                    updatePos(order[turn % 2], positionsPTwo, positions, moveAmount, turn % 2 + 1);
                    board[order[turn % 2].getPos()].runPlace(order[turn % 2]);
                    turn++;
                }
            }
            //fail method
            else {
                System.out.println("Inavlid Command");
            }

            if (order[turn % 2].getBank() == 0) {
                gameOver = true;
            }
            if (order[(turn + 1) % 2].getBank() == 0) {
                gameOver = true;
            }




        }

    }
}
/*
          int xValOne = 0;
            
          int yValOne = 0;
         
            int rowOne = playerOne.getPos() / 6;
            
            int placeOnRowOne = playerOne.getPos() % 6;
         
            if(rowOne == 0){
            
               yValOne = 0;
               
               xValOne = placeOnRowOne;
            
            }
            
            else if(rowOne == 1){
            
               xValOne = 6;
               
               yValOne = placeOnRowOne;
            
            }
            
            else if(rowOne == 2){
            
               yValOne = 6;
               
               xValOne = 6 - placeOnRowOne;
            
            }
            
            else if(rowOne == 3){
            
               xValOne = 0;
               
               yValOne = 6 - placeOnRowOne;
            
            }

         
         int xValTwo = 0;
         
         int yValTwo = 0;
         
          int rowTwo = playerTwo.getPos() / 6;
            
            int placeOnRowTwo = playerTwo.getPos() % 6;
                
            if(rowTwo == 0){
            
               yValTwo = 0;
               
               xValTwo = placeOnRowTwo;
            
            }
            
            else if(rowTwo == 1){
            
               xValTwo = 6;
               
               yValTwo = placeOnRowTwo;
           
            }
            
            else if(rowTwo == 2){
            
               yValTwo = 6;
               
               xValTwo = 6 - placeOnRowTwo;
            
            }
            
            else if(rowTwo == 3){
            
               xValTwo = 0;
               
               yValTwo = 6 - placeOnRowTwo;
            
            }
         
         for(int i = 0; i < 7; i++){
         
            for(int k = 0; k < 7; k++){
            
               if(i == yValOne && k == xValOne){
               
                  System.out.print(1 + "   ");
               
               }
               
               else if(i == 0 || i == 6 || k == 0 || k == 6){
               
                  System.out.print("___ ");
               
               }
               
               else{
               
                  System.out.print("    ");
               
               }
            
            }
            
            System.out.println();
            
         }
         
         System.out.println();
         
         for(int i = 0; i < 7; i++){
         
            for(int k = 0; k < 7; k++){
            
               if(i == yValTwo && k == xValTwo){
               
                  System.out.print(2 + "   ");
               
               }
               
               else if(i == 0 || i == 6 || k == 0 || k == 6){
               
                  System.out.print("___ ");
               
               }
               
               else{
               
                  System.out.print("    ");
               
               }
            
            }
            
            System.out.println();
            
         }
         */
        /* System.out.println(positionsPOne);
         System.out.println(positionsPTwo);*/
        
