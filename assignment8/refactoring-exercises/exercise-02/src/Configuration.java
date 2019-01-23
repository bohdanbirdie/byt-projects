import java.util.*;

public class Configuration {
	public int interval;

	public int duration;

	public int departure;

	public void load(Properties props) throws ConfigurationException {
		// Extracted methods and reused code
		interval = evaluatePropery(props, "interval");
		duration = evaluatePropery(props, "duration");
		departure = evaluatePropery(props, "departure");
	}
	
	private int evaluatePropery(Properties props, String propertyName) throws ConfigurationException {
		String valueString;

		valueString = props.getProperty(propertyName);
		checkForNull(valueString);
		int value = Integer.parseInt(valueString);
		checkForNegative(value);
		if (!propertyName.equals("interval")) {			
			checkForInterval(value);
		}
		return value;
	}
	
	private void checkForNull(String prop) throws ConfigurationException {
		if (prop == null) {
			throw new ConfigurationException("monitor interval");
		}
	}
	
	private void checkForNegative(int value) throws ConfigurationException {
		if (value <= 0) {
			throw new ConfigurationException("monitor interval > 0");
		}
	}
	
	private void checkForInterval(int value) throws ConfigurationException {
		if ((value % interval) != 0) {
			throw new ConfigurationException("duration % interval");
		}
	}
	
	
}
