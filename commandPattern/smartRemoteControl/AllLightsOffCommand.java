package smartRemoteControl;

public class AllLightsOffCommand implements Command{
	private Light[] lights;
	
	public AllLightsOffCommand(Light[] lights) {
		this.lights = lights;
	}
	
	@Override
	public void execute() {
		for(Light light: lights) {
			light.off();
		}
	}

}
