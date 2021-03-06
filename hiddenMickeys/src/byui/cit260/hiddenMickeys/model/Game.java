
package byui.cit260.hiddenMickeys.model;
import byui.cit260.hiddenMickeys.view.ErrorView;
import hiddenmickeys.HiddenMickeys;
import java.io.Serializable;

public class Game implements Serializable{
   
    private int currentRow;
    private int currentColumn;
    private int currentLocationNo;

    private int energyLevel;
    private int timeExpired;
    private int timeRemaining;
    private int fastPassReturnTime;
    private int fastPassReturnInterval;
    private int mickeysCollected;
    private Character character;
    private Backpack backpack;
    private Player player;
    private Map map;
    private boolean gameOver;

   
   
    
    

   //Getter and Setter functions 
    public int getCurrentRow() {
        return currentRow;
    }

    
    public void setCurrentRow(int currentRow) {
        this.currentRow = currentRow;
    }
    
    
    public int getCurrentColumn() {
        return currentColumn;
    }

   
    public void setCurrentColumn(int currentColumn) {
        this.currentColumn = currentColumn;
    }

    
    public int getCurrentLocationNo() {
        return currentLocationNo;
    }

    public void setCurrentLocationNo(int currentLocationNo) {
        this.currentLocationNo = currentLocationNo;
    }
    
    public int getEnergyLevel() {
        return energyLevel;
    }

    public void setEnergyLevel(int energyLevel) {
        if( energyLevel > 100) {
            this.energyLevel = 100;
        }else if(energyLevel <=0) {
            ErrorView.display(this.getClass().getName(),"You have run out of energy!  "
                   + "\nNumber of Mickeys: " + Integer.toString(this.mickeysCollected) + "\nGAME OVER");
            Game game = HiddenMickeys.getCurrentGame();
            game.setGameOver(true); 
        }else{
        this.energyLevel = energyLevel;}
    }

    public int getTimeExpired() {
        return timeExpired;
    }

    public void setTimeExpired(int timeExpired) {
        this.timeExpired = timeExpired;
    }

    public int getTimeRemaining() {
        return timeRemaining;
    }

    public void setTimeRemaining(int timeRemaining) {
        if(timeRemaining <=0) {
            ErrorView.display(this.getClass().getName(),"You have run out of time!  "
                    + "\nNumber of Mickeys: " + Integer.toString(this.mickeysCollected) + "\nGAME OVER");
            Game game = HiddenMickeys.getCurrentGame();
            game.setGameOver(true);
        }else{
        this.timeRemaining = timeRemaining;}
    }

    public int getFastPassReturnTime() {
        return fastPassReturnTime;
    }

    public void setFastPassReturnTime(int fastPassReturnTime) {
        this.fastPassReturnTime = fastPassReturnTime;
    }

    public int getFastPassReturnInterval() {
        return fastPassReturnInterval;
    }

    public void setFastPassReturnInterval(int fastPassReturnInterval) {
        this.fastPassReturnInterval = fastPassReturnInterval;
    }

    public int getMickeysCollected() {
        return mickeysCollected;
    }

    public void setMickeysCollected(int mickeysCollected) {
        this.mickeysCollected = mickeysCollected;
    }
    
        public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public Backpack getBackpack() {
        return backpack;
    }

    public void setBackpack(Backpack backpack) {
        this.backpack = backpack;
    }
    
     public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.currentRow;
        hash = 47 * hash + this.currentColumn;
        hash = 47 * hash + this.energyLevel;
        hash = 47 * hash + this.timeExpired;
        hash = 47 * hash + this.timeRemaining;
        hash = 47 * hash + this.mickeysCollected;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Game other = (Game) obj;
        if (this.currentRow != other.currentRow) {
            return false;
        }
        if (this.currentColumn != other.currentColumn) {
            return false;
        }
        if (this.energyLevel != other.energyLevel) {
            return false;
        }
        if (this.timeExpired != other.timeExpired) {
            return false;
        }
        if (this.timeRemaining != other.timeRemaining) {
            return false;
        }
        if (this.mickeysCollected != other.mickeysCollected) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Game{" + "currentRow=" + currentRow + ", currentColumn=" + currentColumn + ", energyLevel=" + energyLevel + ", timeExpired=" + timeExpired + ", timeRemaining=" + timeRemaining + ", mickeysCollected=" + mickeysCollected + '}';
    }

   

}
