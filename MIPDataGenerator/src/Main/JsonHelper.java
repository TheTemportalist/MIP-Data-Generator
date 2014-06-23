package Main;

public class JsonHelper {
	
	public static String toReadableString(String jsonString) {
		String ret = "";
		
		char[] characters = jsonString.toCharArray();
		
		int tabSet = 0;
		for (int i = 0; i < characters.length; i++) {
			char c = characters[i];

			if (c == '}' || c == ']') {
				tabSet--;
				ret += '\n';
				for (int tab = 1; tab <= tabSet; tab++) {
					ret += "  ";
				}
			}
			
			ret += c;
			
			if (c == '{' || c == '[') {
				tabSet++;
				ret += '\n';
				
				for (int tab = 1; tab <= tabSet; tab++) {
					ret += "  ";
				}
			}
			
			if (c == ',') {
				ret += '\n';
				
				for (int tab = 1; tab <= tabSet; tab++) {
					ret += "  ";
				}
			}
			
			/*
			if (i != 0) if (c == '{' || c == '[') {
				tabSet++;
				ret += '\n';
				for (int tab = 1; tab <= tabSet; tab++) {
					ret += "  ";
				}
			}
			
			if (c == '}' || c == ']') {
				tabSet--;
				ret += '\n';
				for (int tab = 1; tab <= tabSet; tab++) {
					ret += "  ";
				}
			}
			
			if (c == '"') {
				char prevChar = characters[i - 1];
				if (prevChar == '{' || prevChar == '[' || prevChar == ',')
					for (int tab = 1; tab <= tabSet; tab++) {
						ret += "  ";
					}
			}
			
			ret += c;
			
			if (c == '{' || c == '[') {
				ret += '\n';
			}
			else if (c == ',') {
				ret += '\n';
			}
			 */
		}
		
		return ret;
	}
	
}
