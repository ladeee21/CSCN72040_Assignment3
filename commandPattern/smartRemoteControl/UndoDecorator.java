package smartRemoteControl;

public class UndoDecorator implements Command {
    private Command command;
    private Command previousCommand;

    public UndoDecorator(Command command) {
        this.command = command;
    }

    @Override
    public void execute() {
        previousCommand = command;
        command.execute();
    }

    @Override
    public void undo() {
        if (previousCommand != null) {
            previousCommand.undo();
        }
    }
}