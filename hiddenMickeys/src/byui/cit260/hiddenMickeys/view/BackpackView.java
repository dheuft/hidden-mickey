/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.hiddenMickeys.view;

/**
 *
 * @author Dawn
 */
public class BackpackView extends View{
   
   public BackpackView() {
       super("\n"
            +"\n----------------------------------------------"
            +"\nView Backpack Menu"
            +"\n----------------------------------------------"
            +"\nP - Check number of fast passes"
            +"\nM - Check Money Balance "
            +"\nW - Use Emergency Water"
            +"\nS - Use Emergency Snack"
            +"\nq - Return to menu"   
            +"\n----------------------------------------------"
            +"\n\n\nYou have several items in your backpack,"
            + " which one would you like to check?");
    }
   
   @Override
   public boolean doAction(String choice) {
        choice = choice.toUpperCase();
        switch (choice) {
            case "P": //View Fast Passes
                this.viewFastPass();
                break;
            case "M": //Check Money balance
                this.viewMoneyBalance();
                break;   
            case "W": //Use emergency water
                this.useEmergencyWater();
                break;
            case "S": //Use emergency snack
                this.useEmergencyWater();
                break;    
            case "Q": //go back to menu
                break;
            default:
                System.out.println("\n***Invalid selection. Try again.");
                break;
        }
        return false;
    }
   
    private void viewFastPass() {
         System.out.println("\n***viewFastPasses()function called***");
    }

    

    private void viewMoneyBalance() {
         System.out.println("You have ______ money in your backpack");
    }

    private void useEmergencyWater() {
        UseEmergencyWaterView useWater = new UseEmergencyWaterView();
        useWater.display();
        
    }

    private void useEmergencySnack() {
        System.out.println("\nYummy, You have eaten your emergency snack and "
                + " it was delicious.");
    }
    
}


