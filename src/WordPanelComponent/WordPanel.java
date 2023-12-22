package WordPanelComponent;

import GameController.GameController;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class WordPanel extends JPanel {

    private final JLabel currentWord;

    public WordPanel(GameController gc,JFrame mainFrame){

        //setting label and panel properties

        this.setBounds(400,450,400,150);
        this.setBorder(new TitledBorder(new EtchedBorder() , "Word"));
        mainFrame.add(this);

        currentWord = new JLabel();
        currentWord.setBounds(410,460,380,130);
        displayWord(gc.userWord);
        currentWord.setFont(new Font("result",Font.BOLD,24));
        this.add(currentWord);
    }

    public void displayWord(String word){
        String str = "";
        for(int i = 0;i < word.length();i++){
            str += (word.charAt(i) + " ");
        }
        str = str.substring(0,str.length() - 1);
        currentWord.setText(str);
    }


}
