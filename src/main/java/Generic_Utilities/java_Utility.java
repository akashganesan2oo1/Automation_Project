package Generic_Utilities;

import java.util.Date;

public class java_Utility {
	
	public static String getName() {
		
		return new Date().toString().replace(' ', '-').replace(':', '-');
	}

}
