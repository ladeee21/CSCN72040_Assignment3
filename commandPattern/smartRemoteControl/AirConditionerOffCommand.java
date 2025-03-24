package smartRemoteControl;

public class AirConditionerOffCommand implements Command {
AirConditioner ac;
    
    public AirConditionerOffCommand(AirConditioner ac) {
        this.ac = ac;
    }
    
    public void execute(){
        ac.off();
    }
    
    @Override
    public void undo() {
        ac.on();
    }
}
