package poc.shruti.operations;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;



public class ReadLoginCredentials {

	Properties p = new Properties();

	public Properties getObjectRepository() throws IOException{
		// Read object repository file
		InputStream stream = ClassLoader.getSystemClassLoader().getResourceAsStream("credentials.properties");
		// load all objects
		p.load(stream);
		return p;
	}

}
