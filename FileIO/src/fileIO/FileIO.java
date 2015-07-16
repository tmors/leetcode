package fileIO;

import java.io.File;

public class FileIO {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File root=new File("F://ME workspace3//.metadata//.me_tcat//webapps//iskyshop14//upload//store");
		search(root);
	}
	public static void search(File files){
		File[] file_list=files.listFiles();
		for(File file:file_list){
			if(file.isDirectory()){
				search(file);
			}
			else if(file.getName().contains("jpg")){
				if(file.getName().contains("small")||file.getName().contains("middle")){
					
				}
				else{
					System.out.println(file.getAbsolutePath());
				}
				
			}
		}
	}

}
