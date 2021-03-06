
package byui.cit260.hiddenMickeys.view;


public class RestAndRechargeView extends View {
    
    public RestAndRechargeView(){
        super("Resting for 15 minutes will recharge your energy by 20%.  \n Continue? (Y/N)\n");
    }
    
    @Override
       public boolean doAction(String choice){
       choice = choice.toUpperCase();
       boolean returnToMenu = false;
       switch(choice){
           case "Y":
               this.console.println("\n Whew!  You feel much better after resting! \n Your energy has increased 20%. \n");
               this.quitTheOption();
               break;
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
}