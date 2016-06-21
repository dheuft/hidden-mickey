/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.hiddenMickeys.view;

/**
 *
 * @author Hannah Mars
 */
public class GameMenuView extends View {
    
public GameMenuView(){
    super("\n"
            +"\n---------------------------------------------------"
            +"\n|  Game Menu                                      |"
            +"\n---------------------------------------------------"
            +"\nM - View Map or Move  (to move to new location)"
            +"\nE - Explore/enter the current location"
            +"\nB-  View backpack"
            +"\nT - View Time spent/Time remaining"
            +"\nL - View Energy Level"
            +"\nR - Rest for 15 minutes (charges Energy level +20%)"
            +"\nS - Save game"
            +"\nH - Help"
            +"\nQ - Quit"
            +"\n---------------------------------------------------"
            +"\n\n\nWhat would you like to do?");
}

    @Override
     public boolean doAction(String choice) {
        choice = choice.toUpperCase();
       // System.out.println("The choice you entered is " + choice);
        switch (choice) {
            case "M": //view map or move
                this.mapAndMove();
                this.quitTheOption();
                break;
            case "E": //explore/enter current location
                this.exploreLocation();
                break;   
            case "B": //view Backpack
                this.viewBackpack();
                break;
            case "T": //view time spent/remaining
                this.viewTime();
                this.quitTheOption();
                break;
            case "L": //view energy level
                this.energyLevel();
                this.quitTheOption();
                break;
            case "R": //rest for 15 minutes (charges energy level +20)
                this.restAndRecharge();
                this.quitTheOption();
                break;
            case "S": //save current game
                this.saveGame();
                this.quitTheOption();
                break;
            case "H": //save current game
                this.showHelpMenu();
                break;
            case "Q":
                break;
            default:
                System.out.println("\n***Invalid selection. Try again.");
                break;
        }
        return false;
    }

    private void mapAndMove() {
        System.out.println("\n***mapAndMove()function called***");
    }

    private void exploreLocation() {
     //Below is temp code for testing purposes
     TMPExploreLocationView exploreLocation = new TMPExploreLocationView();
         exploreLocation.display();    
        /* String locationType;   
        //get the type of location that the user is currently on
        locationType = this.getLocationType();
        //R=Ride, S=Shop, F=Food
        switch (locationType) {
            case "R":
                //open the menu for a ride location 
                ExploreRideLocationView exploreRideView = new ExploreRideLocationView();
                exploreRideView.display();
                break;
            case "S":
                //open menu for a shop location
                ExploreShopLocationView exploreShopView = new ExploreShopLocationView();
                exploreShopView.display();
                break;
            case "F":
                //open menu for a food location
                ExploreFoodLocationView exploreFoodView = new ExploreFoodLocationView();
                exploreFoodView.display();
                break;
            default:
                System.out.println("Invalid Location Type");
                break;
         }
*/
    }
    
    private String getLocationType() {
       //we can use this function for testing  R=Ride, S=Shop, F=Food
       //when testing your code, change the return value to your menu type 
       return "S";
    }
        
    private void viewBackpack() {
       BackpackView backpack = new BackpackView();
       backpack.display();
        System.out.println("\n***viewBackpack()function called***");
    }

    private void viewTime() {
        System.out.println("\n***viewTime()function called***");
    }

    private void energyLevel() {
        System.out.println("\n***energyLevel()function called***");
    }

    private void restAndRecharge() {
        System.out.println("\n***restAndRecharge()function called***");
    }

    private void saveGame() {
        System.out.println("\n***saveGame()function called***");
    }

    private void showHelpMenu() {
        HelpMenuView helpMenu = new HelpMenuView();
        helpMenu.display();
    }

   


    
}

   

        