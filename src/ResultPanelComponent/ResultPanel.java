package ResultPanelComponent;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class ResultPanel extends JPanel {

    private final JLabel resultLabel;

    public ResultPanel(JFrame mainFrame){

        //setting label and panel properties

        this.setBounds(400,350,400,100);
        this.setBorder(new TitledBorder(new EtchedBorder() , "Game result"));
        mainFrame.add(this);

        resultLabel = new JLabel("");
        resultLabel.setBounds(405,355,390,90);
        resultLabel.setFont(new Font("result",Font.BOLD,16));
        this.add(resultLabel);
    }

    public void SetText(String text){
        this.resultLabel.setText(text);
    }

}
