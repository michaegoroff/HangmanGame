package InputPanelComponent;

import GameController.GameController;
import GibbetPanelComponent.GibbetPanel;
import HistoryPanelComponent.HistoryPanel;
import ResultPanelComponent.ResultPanel;
import WordPanelComponent.WordPanel;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputPanel extends JPanel {
    public JTextField inputField;
    public JButton inputButton;

    //giving access to game controller
    private GameController gc;

    //giving access to panels
    private ResultPanel rp;
    private WordPanel wp;
    private  GibbetPanel gp;
    private HistoryPanel hp;

    public InputPanel(GameController gc,JFrame mainFrame,ResultPanel rp,WordPanel wp,HistoryPanel hp,GibbetPanel gp){

        this.setBounds(400,200,400,150);
        this.setBorder(new TitledBorder(new EtchedBorder() , "Enter your letter"));
        mainFrame.add(this);

        this.gc = gc;
        this.rp = rp;
        this.wp = wp;


        //input field
        inputField = new JTextField("",20);
        this.add(inputField);

        //input button
        inputButton = new JButton("Input");
        inputButton.setBounds(470,310,150,50);
        inputButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //logic of the game

                //input validation via regex
                String userInput = inputField.getText();
                Pattern pattern = Pattern.compile("[a-z]");
                Matcher matcher = pattern.matcher(userInput);
                try{
                    if((userInput.length() > 1) ||(!matcher.find())){
                        throw new Exception("Please,enter one lowercase letter only");
                    }
                }
                //catching an exception
                catch (Exception ex){
                    rp.SetText("Please, enter one lowercase letter only");
                    return;
                }
                //if guessed word contains a letter, open all these letters for user
                if(gc.guessedWord.contains(userInput)){
                    for(int i = 0;i < gc.userWord.length();i++){
                        if(gc.guessedWord.charAt(i) == userInput.charAt(0)){
                            gc.userWord = gc.userWord.substring(0,i) + userInput.charAt(0) + gc.userWord.substring(i+1);
                        }
                    }
                    wp.displayWord(gc.userWord);
                    rp.SetText("");

                    //adding move to history

                    hp.addMove(true,userInput);
                    hp.addLetter(userInput.charAt(0));
                    hp.showHistory();
                }
                //if guess is false,mistake is made(6 max mistakes)
                else if(!gc.guessedWord.contains(userInput) && !hp.lettersHistory.contains(userInput.charAt(0))){
                    rp.SetText("");
                    //adding move to history
                    hp.addMove(false,userInput);
                    hp.addLetter(userInput.charAt(0));
                    hp.showHistory();

                    gc.mistakesMade++;
                    gp.setImage(gc.mistakesMade + 1);
                }
                else if(!gc.guessedWord.contains(userInput) && hp.lettersHistory.contains(userInput.charAt(0))){
                    rp.SetText("");
                    hp.addMove(false,userInput);
                    hp.showHistory();
                }
                inputField.setText("");
                //checking status
                int status = gc.checkStatus();
                if(status == -1){
                    rp.SetText("You lost!");
                    wp.displayWord(gc.guessedWord);
                    inputField.setEditable(false);
                }
                else if(status == 1){
                    rp.SetText("You won!");
                    inputField.setEditable(false);
                }
            }
        });
        this.add(inputButton);
    }


}
