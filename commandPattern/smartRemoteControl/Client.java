package smartRemoteControl;

public class Client {
    public static void main(String[] args) {
        // INVOKER (REMOTE CONTROL)
        SmartRemoteControl remote = new SmartRemoteControl();
        
        // RECEIVERS
        AirConditioner ac = new AirConditioner();
        GarageDoor garageDoor = new GarageDoor();
        Light livingRoomLight = new Light("Living Room");
        Light outdoorLight = new Light("Outdoor");
        Unused unusedCall = new Unused();

        // COMMANDS
        Command acOn = new UndoDecorator(new AirConditionerOnCommand(ac));
        Command acOff = new UndoDecorator(new AirConditionerOffCommand(ac));
        Command doorOpen = new UndoDecorator(new GarageDoorOpenCommand(garageDoor));
        Command doorClose = new UndoDecorator(new GarageDoorCloseCommand(garageDoor));
        Command livingRoomLightOn = new UndoDecorator(new LightOnCommand(livingRoomLight));
        Command livingRoomLightOff = new UndoDecorator(new LightOffCommand(livingRoomLight));
        Command outdoorLightOn = new UndoDecorator(new LightOnCommand(outdoorLight));
        Command outdoorLightOff = new UndoDecorator(new LightOffCommand(outdoorLight));
        

        Light[] allLights = {livingRoomLight, outdoorLight};
        AllLightOnCommand allLightsOn = new AllLightOnCommand(allLights);
        AllLightsOffCommand allLightsOff = new AllLightsOffCommand(allLights);
        UnusedSlotCall unusedSlotCall = new UnusedSlotCall(unusedCall);
        
        // ASSIGN COMMANDS TO REMOTE SLOTS
        remote.setCommand(1, acOn);
        remote.setCommand(2, doorOpen);
        remote.setCommand(3, livingRoomLightOn);
        remote.setCommand(4, outdoorLightOn);
        remote.setCommand(5, allLightsOff);
        remote.setCommand(8, unusedSlotCall);

        // EXECUTE COMMANDS USING BUTTON PRESS
        remote.buttonWasPressed(1);
        remote.undoLastCommand(); //undo ac on (ac off)
        remote.buttonWasPressed(2);
        remote.buttonWasPressed(3); // Living Room Light ON
        remote.buttonWasPressed(4); // Outdoor Light ON
        remote.buttonWasPressed(5);
        remote.buttonWasPressed(8);
        remote.resetAllButtons();
        remote.buttonWasPressed(4);

    }
}
