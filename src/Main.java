import GameController.GameController;
import GibbetPanelComponent.GibbetPanel;
import HistoryPanelComponent.HistoryPanel;
import InputPanelComponent.InputPanel;
import ResultPanelComponent.ResultPanel;
import WordPanelComponent.WordPanel;

import javax.swing.*;

public class Main {
    public static void main(String[] args){

        //setting the window
        JFrame mainFrame = SetMainFrame();

        //constructing the application:

        //panel with a gibbet image
        GibbetPanel gibbetPanel = new GibbetPanel(mainFrame);

        //moves history panel
        HistoryPanel historyPanel = new HistoryPanel(mainFrame);

        //game controller
        GameController gameController = new GameController(historyPanel);

        //result panel
        ResultPanel resultPanel = new ResultPanel(mainFrame);

        //word panel
        WordPanel wordPanel = new WordPanel(gameController,mainFrame);

        //input panel
        InputPanel inputPanel = new InputPanel(gameController,mainFrame,resultPanel,wordPanel,historyPanel,gibbetPanel);
    }

    public static JFrame SetMainFrame(){
        JFrame mainFrame = new JFrame("Gibbets");
        mainFrame.setSize(850,650);
        mainFrame.setLayout(null);
        mainFrame.setVisible(true);
        return mainFrame;
    }


}
