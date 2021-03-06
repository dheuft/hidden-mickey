
package byui.cit260.hiddenMickeys.view;

import byui.cit260.hiddenMickeys.control.GameControl;
import byui.cit260.hiddenMickeys.model.Game;
import hiddenmickeys.HiddenMickeys;
import static hiddenmickeys.HiddenMickeys.getCurrentGame;

public class MainMenuView extends View {

    
    
public MainMenuView() {
    super("\n---------------------------------------------------"
        +"\n|  Main Menu                                      |"
        +"\n---------------------------------------------------"
        +"\nN - Start new game                                 "
        +"\nG - Get and start saved game"
        +"\nH - Get help on how to play the game"
        +"\nR - Return to current game"    
        +"\nS - Save Game"
        +"\nQ - Quit"
        +"\n---------------------------------------------------"
        +"\n"
        +"\n"
        +"\nPlease enter your choice: ");
    
}

    @Override
    public boolean doAction(String choice) {
        choice = choice.toUpperCase();
        
        switch (choice) {
            case "N": //create and start a new game
                this.startNewGame();
                break;
            case "G": //get and start an existing game
                this.startExistingGame();
                this.quitTheOption();
                break;   
            case "H": //display help menu
                this.showHelpMenu();
                break;
            case "R": //return to current game
                this.viewGameMenu();
                break;
            case "S": //save current game
                this.saveGame();
                this.quitTheOption();
                break;
            case "Q":
                 break;
            default:
                ErrorView.display(this.getClass().getName(),
                        "\n***Invalid selection. Try again.");
                break;
        }
        return false;
    }

    private void startNewGame() {
        //create new game
        GameControl.createNewGame(HiddenMickeys.getPlayer());
        
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }

    private void startExistingGame() {
       //prompt for and get the name of the file to save the game in
       this.console.println("\n\nEnter the file path for fole where the game "
       + "is to be saved.");
       
       String filePath = this.getInput();
       
       try {
           //start a saved game
           GameControl.getSavedGame(filePath);
       } catch (Exception ex) {
           ErrorView.display("MainMenuView", ex.getMessage());
       }
       //display the game menu
       GameMenuView gameMenu = new GameMenuView();
       gameMenu.display();
    }

    private void showHelpMenu() {
       //display help menu
       // GameControl.createNewGame(HiddenMickeys.getPlayer());
        
        HelpMenuView helpMenu = new HelpMenuView();
        helpMenu.display();
    }

    private void saveGame() {
      //prompt for and get the name of the file to save the game in
      this.console.println("\n\nEnter the file path for file where the game "
      + "is to be saved.");
      String filePath = this.getInput();
      
      try {
          //save the game to the specified file
          GameControl.saveGame(HiddenMickeys.getCurrentGame(), filePath);
      } catch (Exception ex) {
          ErrorView.display("MainMenuView", ex.getMessage());
      }
    }

    private void viewGameMenu() {
        try{
            Game game= getCurrentGame();
            int gameCheck = game.getTimeRemaining();
            if(gameCheck>0){
                GameMenuView gameMenu = new GameMenuView();
                gameMenu.display();}
        }catch (Exception e){
            ErrorView.display(this.getClass().getName(), "You have not begun a game yet.\nStart a New Game");
        }
    }

   
    
    
    
    
}
    
