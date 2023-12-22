package HistoryPanelComponent;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.util.ArrayList;

public class HistoryPanel extends JPanel {
    private final JTextArea textArea;

    //all made moves
    public ArrayList<String> movesHistory = new ArrayList<String>();

    //all letters used by user

    public ArrayList<Character> lettersHistory = new ArrayList<Character>();

    public HistoryPanel(JFrame mainFrame){

        //setting panel properties

        this.setBounds(400,0,400,200);
        this.setBorder(new TitledBorder(new EtchedBorder() , "Moves history"));
        mainFrame.add(this);

        //setting textarea properties
        textArea = new JTextArea(10,25);
        textArea.setBounds(405,5,390,190);
        textArea.setEditable(false);
        JScrollPane scroll = new JScrollPane(textArea);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        this.add(scroll);
    }

    //adds players move to history
    public void addMove(boolean ifGuess,String input){
        if(!lettersHistory.contains(input.charAt(0))){
            movesHistory.add("Guess " + input + " is " + ifGuess + "\n");
        }
        else{
            movesHistory.add("Guess " + input + " is " + ifGuess +" and have been already used" + "\n");
        }

    }

    //add letter to history
    public void addLetter(Character input){
        lettersHistory.add(input);
    }

    //shows history
    public void showHistory(){
        String history = "";
        for(String elem: movesHistory){
            history += elem;
        }
        textArea.setText(history);
    }
}
