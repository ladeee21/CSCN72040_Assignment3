package smartRemoteControl;

public class GarageDoorOpenCommand implements Command {
    GarageDoor door;
    
    public GarageDoorOpenCommand(GarageDoor door) {
        this.door = door;
    }
    
    public void execute(){
        door.up();
    }
}