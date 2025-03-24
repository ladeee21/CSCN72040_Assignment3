package smartRemoteControl;

public class UnusedSlotCall implements Command {
	private Unused Call;
	
	public UnusedSlotCall(Unused unusedCall) {
		this.Call = unusedCall;
	}
	
	@Override
	public void execute() {
		Call.call();
	}
	
	 @Override
	    public void undo() {
	    	return;
	    }

}
