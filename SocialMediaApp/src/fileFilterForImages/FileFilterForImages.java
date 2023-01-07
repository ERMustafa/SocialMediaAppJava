package fileFilterForImages;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class FileFilterForImages extends FileFilter{
	
	/**
	 * 
	 * It filters the images with extension .jpg
	 * 
	 */

	@Override
	public boolean accept(File f) {
		if (f.isDirectory()) {
	           return true;
	       } else {
	           String filename = f.getName().toLowerCase();
	           return filename.endsWith(".jpg") || filename.endsWith(".jpeg") ;
	       }
	   }
	

	/**
	 * it is overridden method for FileFilter
	 * 
	 * it helps JFileChooser to filter .jpeg files
	 */
	
	@Override
	public String getDescription() {
		return "JPG Images (*.jpg)";
	}
	
}
