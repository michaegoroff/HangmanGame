package GibbetPanelComponent;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class GibbetPanel extends JPanel{
    private final ImageIcon[] gibbetImages = {
            new ImageIcon("images/1.png"),
            new ImageIcon("images/2.png"),
            new ImageIcon("images/3.png"),
            new ImageIcon("images/4.png"),
            new ImageIcon("images/5.png"),
            new ImageIcon("images/6.png"),
            new ImageIcon("images/7.png")
    };

    private final JLabel imageLabel;

    public GibbetPanel(JFrame mainFrame){

        //setting label and panel properties

        this.setBounds(0,0,400,600);
        this.setBorder(new TitledBorder(new EtchedBorder() , "Gibbet"));
        mainFrame.add(this);


        imageLabel = new JLabel();
        imageLabel.setBounds(25,25,350,550);
        imageLabel.setIcon(gibbetImages[0]);
        this.add(imageLabel);
    }

    //images '1' to '7'
    public void setImage(int i){
        this.imageLabel.setIcon(gibbetImages[i - 1]);
    }

}
