package smartRemoteControl;

public class SmartRemoteControl {
    Command[] slots; // Array of commands

    public SmartRemoteControl() {
        slots = new Command[9]; 
    }

    public void setCommand(int slot, Command command) {
        if (slot >= 0 && slot < slots.length) {
            slots[slot] = command;
        } else {
            System.out.println("Invalid slot number!");
        }
    }

    public void buttonWasPressed(int slot) {
        if (slot >= 0 && slot < slots.length && slots[slot] != null) {
            slots[slot].execute();
        } else {
            System.out.println("No command assigned to this slot!");
        }
    }
}