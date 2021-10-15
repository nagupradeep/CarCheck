package carcheck.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

import carcheck.base.carcheckBase;

public class carcheckUtil extends carcheckBase {

	
	public static ArrayList<String> listFiles(String inPut)
	{
		ArrayList<String> files = new ArrayList<String>();
		String filePath = System.getProperty("user.dir");
			if (inPut == "Input") {
				filePath = filePath + "\\src\\main\\java\\carcheck\\data\\input\\";
			} else if (inPut == "Validate")
			{
				filePath = filePath + "\\src\\main\\java\\carcheck\\data\\validation\\";
			}
		String[] pathNames;
		File filelist = new File (filePath);
		pathNames = filelist.list();
		
		for (String path : pathNames) {
			files.add(path);
		}	
		return files;
	}
	
	public static File fileOpener(String type, String fileName) throws FileNotFoundException {		
		String path = System.getProperty("user.dir");
		
		if (type == "Input") {
			path = path + "\\src\\main\\java\\carcheck\\data\\input\\";
		} else if (type == "Validate")
		{
			path = path + "\\src\\main\\java\\carcheck\\data\\validation\\";
		}
		File fileObject = new File(path + fileName);
		return fileObject;
		}
	
	
	public static ArrayList<String> readInputFile(String folderType) {		
		ArrayList<String> registrationList = new ArrayList<String>();
		try {
			  /*String path = System.getProperty("user.dir");
		      File fObject = new File(path + "\\src\\main\\java\\carcheck\\data\\input\\car_input.txt");*/
			  ArrayList<String> filesList = new ArrayList<String>();
			  filesList = listFiles(folderType);
			  System.out.println("Size of" +  filesList.size() );
			  for (int lF = 0; lF <  filesList.size(); lF++) {
				  
			  File fObject = fileOpener(folderType, filesList.get(lF));
		      Scanner inputReader = new Scanner(fObject);
		      String spartial = "";
		      String partial ="";
		      String t = "";
		      while (inputReader.hasNextLine()) {
		        String data = inputReader.nextLine();
		        if (data.contains("registration")) {		        	
		        	partial = data.substring(data.indexOf("registration")+13);        	         	
		        	if (partial.substring(0,partial.indexOf(" ")).trim().length() < 7) {		
		        		
		        		spartial = partial.substring(partial.indexOf(" ")).trim() ;
		        		t = partial.substring(0,partial.indexOf(" ")) + spartial.substring(0,spartial.indexOf(" ")) ;
		        		//registrationList.add(t.replace(" ", ""));
		        		registrationList.add(t);
	        		
		        	}
		        	else {
		        			        		
		        	    t= partial.substring(0,partial.indexOf(" ")).trim();
		        		//registrationList.add(t.replace(" ", ""));
		        		registrationList.add(t);		        	
		        	}
		        		
		        } else if (data.contains("registraions") & data.contains("and")) {
		        	
		        	String searchStr = "registraions";
		        	for (int i=0; i<=1; i++) {
		        
		        		
		        	partial = data.substring(data.indexOf(searchStr)+searchStr.length());
		        	

		        	if (partial.substring(0,partial.indexOf(" ")).trim().length() < 7) {		
		        		 
		        		spartial = partial.substring(partial.indexOf(" ")).trim() ;
		        		
		        		if (searchStr == "and") {
		        			t = spartial.substring(0,spartial.indexOf(".")) ;
		        		}
		        		else
		        			t = partial.substring(0,partial.indexOf(" ")) + spartial.substring(0,spartial.indexOf(" ")) ;
		        		
		        				
		        		//registrationList.add(t.replace(" ", ""));
		        		registrationList.add(t);
	        		
		        	}
		        	else {
		        			        		
		        		 t= partial.substring(0,partial.indexOf(" ")).trim();
			        	 //registrationList.add(t.replace(" ", ""));
		        		 registrationList.add(t);
		        	}
		        	searchStr = "and";
		        	partial = "";
		        	spartial = "";
		        	t = "";
		        	}
	        	} 
	        	
		        
		      }
		      inputReader.close();
		}
			} catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		return registrationList;
	}

	public ArrayList<String> readOutputFileValidation(String regNumber) {		
	      
		ArrayList<String> datavalidations = new ArrayList<String>();
		String retData = "";
	      try {
		      File validationObj = fileOpener("Validate", "car_output.txt");
		      Scanner readValidator = new Scanner(validationObj);
		      while (readValidator.hasNextLine()) {
		        String data = readValidator.nextLine();
		        if (data.contains(regNumber)) {		
			        retData =  data;
			        break;
				  }	         	   
			        
		      } readValidator.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();	  
		    }
		//return retData;
		String[] arr = retData.split(","); 
		
		for (int y = 0; y < arr.length; y++ )
		{
			if (y==0) {
				datavalidations.add("Registration");				
			}else if (y == 1) {
				datavalidations.add("Make");	
			}else if (y == 2) {
				datavalidations.add("Model");	
			}else if (y == 3) {
				datavalidations.add("Colour");	
			}else if (y == 4) {
				datavalidations.add("Year");	
			}					
			datavalidations.add(arr[y]);
		}
			
		
		return datavalidations;
	}
	
	
		
}


