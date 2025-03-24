package smartRemoteControl;
import java.util.Stack;

public class SmartRemoteControl {
	 Command slot;
	 private Stack<Command> commandHistory = new Stack<>();
  
	    public void setCommand(Command command) {
	        slot = command;
	        commandHistory.push(command);
	    }
	    
	    public void buttonWasPressed() {
	    	if (this.slot == null) {
	    		System.out.println("no command has been set to the button");
	    		return;
	    	}
	        slot.execute();
	    }    
	 
	    public void undoLastCommand() {
	        if (!commandHistory.isEmpty()) {
	            Command lastCommand = commandHistory.pop();
	            lastCommand.undo();
	        }
	    }
	    public void resetAllButtons() {
	        commandHistory.clear();
	        slot = null;
	        System.out.println("all buttons have been reset.");
	    }
}
