
package byui.cit260.hiddenMickeys.view;

import byui.cit260.hiddenMickeys.control.GameControl;
import byui.cit260.hiddenMickeys.control.LocationControl;
import byui.cit260.hiddenMickeys.control.MapControl;
import byui.cit260.hiddenMickeys.exceptions.GameControlException;
import byui.cit260.hiddenMickeys.exceptions.LocationControlException;
import byui.cit260.hiddenMickeys.exceptions.MapControlException;
import byui.cit260.hiddenMickeys.model.Game;
import byui.cit260.hiddenMickeys.model.Location;
import hiddenmickeys.HiddenMickeys;


public class ProceedView extends View {
    private int locationNum;
    
    public ProceedView(int locationNum){
        super("Continue? (Y/N)");
        this.locationNum = locationNum;
    }

       
    @Override
       public boolean doAction(String choice){
       choice = choice.toUpperCase();
       boolean returnToMenu = false;
       switch(choice){
           case "Y":
               this.movePlayer();
               
           case "N":
               break;   
           case "Q":
               break;
           default:
               ErrorView.display(this.getClass().getName(),"/nInvalid choice try again");
               returnToMenu = true;
               break;
       }
       return !returnToMenu;
   } 

    private void movePlayer() {
        Game game = HiddenMickeys.getCurrentGame(); // retreive the game
        int curRow = game.getCurrentRow();
        int curColumn = game.getCurrentColumn();
        
         // create array to hold location coordinates
        int[] coordArray = new int[2];
        
        int newRow = 0;
        int newColumn = 0;
        // get location coordinates
        //LocationControl lc = new LocationControl();
        coordArray = LocationControl.getLocationCoordinates(this.locationNum);
        
        newRow = coordArray[0];
        newColumn = coordArray[1];
        
        //move player
        
        game.setCurrentRow(newRow);
        game.setCurrentColumn(newColumn);
        game.setCurrentLocationNo(this.locationNum);
        String strLocationName = LocationControl.lookupLocationName(this.locationNum);
        this.console.println("\n---------------------------------------------------"
                + ("\nYou are now at " + strLocationName + ".").toUpperCase() +
                "\n---------------------------------------------------");
        
        //update time left in game
        MapControl mc = new MapControl();
        int moveTime = 0;
        try {
        moveTime = mc.calcMoveTime(curRow, curColumn, newRow, newColumn);
        int curTimeRemain = game.getTimeRemaining();
        game.setTimeRemaining(curTimeRemain - moveTime);
        try {
            GameControl.updateEnergyLevels(moveTime);
            } catch (GameControlException ge){
                ErrorView.display(this.getClass().getName(), ge.getMessage());
            }
        if(!game.isGameOver()) {
        this.displayCurrentTimeAndEnergy();
        // explore the location based on the location type 
        this.exploreLocationType();}
        } catch (MapControlException me) {
                ErrorView.display(this.getClass().getName(), me.getMessage());
         }
      
  
    }
    
    
    public void exploreLocationType() {
        
    try{
       
        // determine whether location is food, ride or shop
    Location myloc = LocationControl.getLocationByNumber(this.locationNum);
    String locationType = myloc.getScene().getLocationType();
    
    switch (locationType) {
            case "R": //Ride
                int waitTime = myloc.getScene().getWaitTime();
                int fastPassTime = LocationControl.calcFastPassTime(waitTime);
                ExploreRideLocationView rideView = new ExploreRideLocationView(waitTime, fastPassTime);
                rideView.display();
                break;
            case "T": //Rest View
                ExploreRestView restView = new ExploreRestView();
                restView.display();
                break;  
            case "S": //Shop View
                ExploreShopLocationView shopView = new ExploreShopLocationView(myloc.getScene());
                shopView.display();
                break;
            case "P": //Fast Pass View
                
                //check to see if the user is allowed a fast pass yet
                boolean proceed = this.checkFastPassAvailability();
                if(proceed){
                    FastPassStationLocationView fastPassView = new FastPassStationLocationView();
                    fastPassView.display();}
                else{
                    //tell user "sorry, you cannot get another fast pass for another ___ minutes
                    this.notifyNextFastPassTime();
                }
                break;
            case "F": //Food View
                ExploreFoodLocationView foodView = new ExploreFoodLocationView(myloc.getScene());
                foodView.display();
                break;
            default:
                ErrorView.display(this.getClass().getName(), "\n***Invalid selection. Try again.");
                break;
        }
               
        } catch (LocationControlException le) {
        ErrorView.display(this.getClass().getName(), "Error reading input: " + le.getMessage());
        }
    }

    private boolean checkFastPassAvailability() {
        Game game = HiddenMickeys.getCurrentGame();
        int timeRemaining = game.getTimeRemaining();
        int returnTime = game.getFastPassReturnTime();
        if(timeRemaining<=returnTime){
           return true;}
        else{
            return false;
        }
               
    }

  private void notifyNextFastPassTime() {
       this.displayFastPassInfo();
    }
   }
