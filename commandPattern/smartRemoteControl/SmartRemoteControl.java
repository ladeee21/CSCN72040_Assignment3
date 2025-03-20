package smartRemoteControl;

public class SmartRemoteControl {
	 Command slot;
	    
	    public void setCommand(Command command) {
	        slot = command;
	    }
	    
	    public void buttonWasPressed() {
	        slot.execute();
	    }
}
