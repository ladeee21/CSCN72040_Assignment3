package smartRemoteControl;

public class Client {

    public static void main(String[] args) {
        
        //INVOKER
        SmartRemoteControl remote  = new SmartRemoteControl();
        
        //RECEIVER
        AirConditioner ac 	=		new AirConditioner();
        GarageDoor garageDoor   =  new GarageDoor();
        
        //COMMAND
        Command acOn = new UndoDecorator(new AirConditionerOnCommand(ac));
        Command acOff = new UndoDecorator(new AirConditionerOffCommand(ac));
        Command doorOpen = new UndoDecorator(new GarageDoorOpenCommand(garageDoor));
        Command doorClose = new UndoDecorator(new GarageDoorCloseCommand(garageDoor));
        
        remote.setCommand(acOn);
        remote.buttonWasPressed();
        remote.undoLastCommand();
        remote.setCommand(doorOpen);
        remote.buttonWasPressed();
        
        remote.resetAllButtons();
        remote.buttonWasPressed();
    }
    
}