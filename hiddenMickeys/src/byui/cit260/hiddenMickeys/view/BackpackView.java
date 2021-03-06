
package byui.cit260.hiddenMickeys.view;
import byui.cit260.hiddenMickeys.control.BackpackControl;
import byui.cit260.hiddenMickeys.exceptions.BackpackControlException;
import byui.cit260.hiddenMickeys.model.Backpack;
import byui.cit260.hiddenMickeys.model.Game;
import byui.cit260.hiddenMickeys.model.Mickey;
import hiddenmickeys.HiddenMickeys;
import java.util.ArrayList;
  

public class BackpackView extends View{
   
   public BackpackView() {
       super("--------------------------------------------------"
            +"\nView Backpack Menu"
            +"\n--------------------------------------------------"
            +"\n1 - Check # Fast passes and minutes until next pass"
            +"\n2 - Check Money Balance"
            +"\n3 - Use Emergency Water"
            +"\n4 - Use Emergency Snack"
            +"\n5 - Display List of Mickeys Found" 
            +"\nQ - Return to menu"   
            +"\n--------------------------------------------------"
            +"\n\n\nYou have several items in your backpack,"
            + " which one would you like to check?");
    }
   
   @Override
   public boolean doAction(String choice) {
        choice = choice.toUpperCase();
        switch (choice) {
            case "Q":
                break;
            default:
                int number = 0;
                try {
                number = Integer.parseInt(choice);
                } catch (NumberFormatException nf) {
                ErrorView.display(this.getClass().getName(),
                        "\n***You must enter a valid number or option.");
                }
                switch (choice) {
            case "1": //View Fast Passes
                this.viewFastPass();
                break;
            case "2": //Check Money balance
                this.viewMoneyBalance();
                break;   
            case "3": //Use emergency water
                this.useEmergencyWater();
                break;
            case "4": //Use emergency snack
                this.useEmergencySnack();
                break;    
            case "5": //Display Hidden Mickey's Found
                this.displayMickeys();
                break;
            default:
                ErrorView.display(this.getClass().getName(),
                        "\n***Invalid selection. Try again.");
                break;
                }
        }
        return false;
        
    }
   
    private void viewFastPass() {
        this.displayFastPassInfo();
    }

    

    private void viewMoneyBalance() {
        try{
        BackpackControl backpack = new BackpackControl();
        double newBalance = backpack.calcNewBalance(0);
        this.console.println("Your current balance is $" + Double.toString(newBalance) + "0");
        }catch (BackpackControlException be) {
            ErrorView.display(this.getClass().getName(),be.getMessage());
        }
    }
  
    private void useEmergencyWater() {
        try{
            BackpackControl backpack = new BackpackControl();
            Game game = HiddenMickeys.getCurrentGame();
            Backpack emergencyWater = game.getBackpack();
            int newEnergy = backpack.updateEnergy();
            this.console.println("\n Whew, you are feeling refreshed after drinking"
                + " your emergency water. Your current energy balance is " + Integer.toString(newEnergy) + "%."
                    + "\nReminder - Your energy balance cannot exceed 100%.");
            emergencyWater.setEmergencyWaterUsed(true);
            
        }catch (BackpackControlException be) {
            ErrorView.display(this.getClass().getName(),be.getMessage());
        }
    }

    private void useEmergencySnack() {
        try{
            BackpackControl bc = new BackpackControl();
            Game game = HiddenMickeys.getCurrentGame();
            Backpack emergencySnack = game.getBackpack();
            int newEnergy = bc.updateSnackEnergy();
            this.console.println("\nYummy, you have eaten your emergency snack and "
                + "it was delicious. Your current energy balance is " + Integer.toString(newEnergy) + "%."
                    + "\nReminder - Your energy balance cannot exceed 100%.");
            emergencySnack.setEmergencySnackUsed(true); 
        
        }catch (BackpackControlException be) {
            ErrorView.display(this.getClass().getName(),be.getMessage());
    }
    }

    private void displayMickeys() {
        Game game = HiddenMickeys.getCurrentGame();
        Backpack backpack = game.getBackpack();
        ArrayList<Mickey> mickeys =  backpack.getMickeysCollected();
        int numMickeys = mickeys.size();
        //this.console.println("# of Mickeys Found: " + Integer.toString(numMickeys));
        MickeysFoundReportView reportMenu = new MickeysFoundReportView();
        reportMenu.display();
    }
    
}


