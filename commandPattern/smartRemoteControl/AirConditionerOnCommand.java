package smartRemoteControl;

public class AirConditionerOnCommand implements Command {
	AirConditioner ac;
    
    public AirConditionerOnCommand(AirConditioner ac) {
        this.ac = ac;
    }
    
    public void execute(){
        ac.on();
    }
    
    @Override
    public void undo() {
        ac.off();
    }
}
