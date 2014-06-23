package Main;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class JsonFilter extends FileFilter {
	
	@Override
	public boolean accept(File f) {
		if (f.isDirectory())
			return false;
		else {
			String filename = f.getName();
			String extension = null;
			
			int i = filename.lastIndexOf('.');
			if (i > 0 && i < filename.length() - 1) {
				extension = filename.substring(i + 1);
			}
			
			if (extension != null) {
				return extension.equals("json");
			}
		}
		return false;
	}
	
	@Override
	public String getDescription() {
		return "Only JSON files";
	}
	
}
