package smartRemoteControl;
import java.util.Stack;

public class SmartRemoteControl {

    Command[] slots; // Array of commands
    private Stack<UndoRecord> undoStack = new Stack<>();

    private class UndoRecord {
        int slot;
        Command command;

        UndoRecord(int slot, Command command) {
            this.slot = slot;
            this.command = command;
        }
    }
    
    public SmartRemoteControl() {
        slots = new Command[9];
        for (int i = 0; i < slots.length; i++) {
            slots[i] = null;
        }
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
            undoStack.push(new UndoRecord(slot, slots[slot]));
        } else {
            System.out.println("No command assigned to this slot!");
        }
    }
    
    public void undoLastCommand() {
        if (!undoStack.isEmpty()) {
            UndoRecord lastRecord = undoStack.pop();
            lastRecord.command.undo();
            System.out.println("Undid command in slot " + lastRecord.slot);
        } else {
            System.out.println("No commands to undo.");
        }
    }

    public void resetAllButtons() {
        undoStack.clear();
        for (int i = 0; i < slots.length; i++) {
            slots[i] = null;
        }
        System.out.println("all buttons have been reset.");
    }
}

