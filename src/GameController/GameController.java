package GameController;

import HistoryPanelComponent.HistoryPanel;

import java.util.*;

public class GameController {


    public int gameStatus;  //0 - in progress, 1 - victory, -1 - loss
    public int mistakesMade;
    public final int possibleMistakes = 6;

    public String userWord;
    public String guessedWord;

    public final String[] wordsList = {"apple","tower","machine","guitar","bucket","water","shovel","track","giraffe","rocket",
                                       "music","paper","winter","portal","armor","plate","camel","chicken","timer","kettle",
                                       "weapon","friend","letter","coffee","market","world","money","singer","laptop","crowd",
                                       "scream","novel","author","builder","lawyer","doctor","prince","banana","thief","candle",
                                       "player","victim","needle","carrot","spoon","figure","shelf","pistol","brand","sword"};

    //giving access to history panel
    public HistoryPanel hp;

    public GameController(HistoryPanel hp){

        this.hp = hp;

        this.gameStatus = 0;
        this.mistakesMade = 0;

        //choosing random word from the list

        Random rnd = new Random();
        guessedWord = wordsList[rnd.nextInt(0, wordsList.length+1)];
        userWord = "";
        for(int i = 1; i <= guessedWord.length();i++){
            this.userWord += "_";
        }

        //opening 2 letters for player

        int iter = 1;
        while(iter <= 2){
            int index = rnd.nextInt(0,guessedWord.length());
            //avoids hitting the same place twice
            if(userWord.charAt(index) != '_'){
                continue;
            }
            else{
                char ch = guessedWord.charAt(index);
                userWord = userWord.substring(0,index) + ch + userWord.substring(index+1);

                //counting selected letter occurrences

                int count = 0;
                for(int i = 0;i < guessedWord.length();i++){
                    if(guessedWord.charAt(i) == ch){
                        count++;
                    }
                }
                if(count == 1){
                    //adding letter to history if it is already open
                    hp.addLetter(ch);
                }
                iter++;
            }
        }
    }

    //checks game status
    public int checkStatus(){
        if(mistakesMade >= possibleMistakes){
            return -1;
        }
        else if((mistakesMade < possibleMistakes) && (userWord.equals(guessedWord))){
            return 1;
        }
        else{
            return 0;
        }
    }
}
