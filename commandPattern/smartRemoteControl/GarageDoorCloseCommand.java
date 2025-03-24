package smartRemoteControl;

public class GarageDoorCloseCommand implements Command {
	    GarageDoor door;
	    
	    public GarageDoorCloseCommand(GarageDoor door) {
	        this.door = door;
	    }
	    
	    public void execute(){
	        door.down();
	    }
	    
	    @Override
	    public void undo() {
	        door.up();
	    }
}
