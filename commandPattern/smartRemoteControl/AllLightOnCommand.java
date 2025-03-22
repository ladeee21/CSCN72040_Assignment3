package smartRemoteControl;

public class AllLightOnCommand implements Command{
	private Light[] lights;
	
	public AllLightOnCommand(Light[] lights) {
		this.lights = lights;
	}
	
	@Override
    public void execute() {
        for (Light light : lights) {
            light.on();
        }
    }
	
}
