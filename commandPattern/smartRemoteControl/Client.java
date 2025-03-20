package smartRemoteControl;

public class Client {

    public static void main(String[] args) {
        
        //INVOKER
        SmartRemoteControl remote  = new SmartRemoteControl();
        
        //RECEIVER
        AirConditioner ac 	=		new AirConditioner();
        GarageDoor garageDoor   =  new GarageDoor();
        
        //COMMAND
        AirConditionerOnCommand acOn = new AirConditionerOnCommand(ac);
        AirConditionerOffCommand acOff = new AirConditionerOffCommand(ac);
        GarageDoorOpenCommand doorOpen  = new GarageDoorOpenCommand(garageDoor);
        GarageDoorCloseCommand doorClose  = new GarageDoorCloseCommand(garageDoor);
        
        remote.setCommand(acOn);
        remote.buttonWasPressed();
        remote.setCommand(doorOpen);
        remote.buttonWasPressed();
    }
    
}