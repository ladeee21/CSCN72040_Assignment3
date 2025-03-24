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
        AirConditionerOnCommand acOn = new AirConditionerOnCommand(ac);
        AirConditionerOffCommand acOff = new AirConditionerOffCommand(ac);
        GarageDoorOpenCommand doorOpen = new GarageDoorOpenCommand(garageDoor);
        GarageDoorCloseCommand doorClose = new GarageDoorCloseCommand(garageDoor);
        LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
        LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);
        LightOnCommand outdoorLightOn = new LightOnCommand(outdoorLight);
        LightOffCommand outdoorLightOff = new LightOffCommand(outdoorLight);
        

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
        remote.buttonWasPressed(2);
        remote.buttonWasPressed(3); // Living Room Light ON
        remote.buttonWasPressed(4); // Outdoor Light ON
        remote.buttonWasPressed(5);
        remote.buttonWasPressed(8);
    }
}
