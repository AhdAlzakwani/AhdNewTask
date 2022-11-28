package apipackage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {
	 public void parseFile(String fileName,String searchStr) throws FileNotFoundException{
	        Scanner scan = new Scanner(new File(fileName));
	        while(scan.hasNext()){
	            String line = scan.nextLine().toLowerCase().toString();
	            if(line.contains(searchStr)){
	                System.out.println(line);
	            }
	        }
	    }


	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);

		boolean menuExit = true;
		boolean SearchExit = true;

		while (menuExit) {
			System.out.println("1- Reading File");
			System.out.println("2- Create Directary");
			System.out.println("3- Search Words");
			
			int option = scanner.nextInt();
			switch (option) {
			case 1:

				
				Main filereade = new Main();
				try {
					filereade.parseFile("C:\\Users\\User009\\Desktop\\School\\JsonFileInformation.txt", "");
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				break;

			case 2:
   
				File f = new File("C:\\Users\\User009\\Desktop\\JavaApiProject\\ApiDirectryTest"); 

				// check if the directory can be created 
				// using the specified path name 
				if (f.mkdir() == true) { 
					System.out.println("Directory has been created successfully"); 
				} 
				else { 
					System.out.println("Directory cannot be created"); 
				} 
			         
				break;
			case 3:
		        while(SearchExit) {
				File dir = new File("C:\\Users\\User009\\Desktop\\School");
				 FilenameFilter textFilter = new FilenameFilter() {
			            public boolean accept(File dir, String name) {
			                return name.toLowerCase().endsWith(".txt");
			            }
			        };
			        File[] files = dir.listFiles(textFilter);
			        for (File file : files) {
			            if (file.isDirectory()) {
			                System.out.print("directory:");
			            } else {
			                System.out.print("     file:");
			            }
			            System.out.println(file.getCanonicalPath());
			        }
				
				
				File f1=new File("C:\\Users\\User009\\Desktop\\School\\APIDocument.txt"); //Creation of File Descriptor for input file
			      String[] words=null;  //Intialize the word Array
			      FileReader fr = new FileReader(f1);  //Creation of File Reader object
			      BufferedReader br = new BufferedReader(fr); //Creation of BufferedReader object
			      String s;     
			         System.out.println("Please Write word to be Search :");

			      String input=scanner.next();   // Input word to be searched
			      int count=0;   //Intialize the word to zero
			      while((s=br.readLine())!=null)   //Reading Content from the file
			      {
			         words=s.split(" "); //Split the word using space
			         
			         for(File c: files) {
			          for (String word : words) 
			          {
			                 if (word.equals(input))   //Search for the given word
			                 {
						         System.out.println("The Word is : \t"+input+"\t the file is :\t "+c);
						 
			                   count++;    
			                  File filefirst = new File(c.getPath());
			 			      //Creating a destination Path object
			 			      File toFile = new File("C:\\Users\\User009\\Desktop\\JavaApiProject\\ApiDirectryTest\\"+c.getName());
			 			      //copying the file
			 			      Files.copy(filefirst.toPath(),toFile.toPath(),StandardCopyOption.REPLACE_EXISTING);
			 			      
			                 }
			                 
			          }
			         }
			      }
			     
			      if(count!=0)  //Check for count not equal to zero
			      {
			         System.out.println("The given word is present for "+count+ " Times in the file");
			         System.out.println("File moved successfully ........");

			         
			      }
			      else
			      {
			         System.out.println("The given word is not present in the file");
			      }
			      
			         System.out.println("If You want to Continue Searching press 1 , If Not Press 0");
			         int search = scanner.nextInt();
			         if(search == 0)
			         {
			        	 SearchExit = false;
			         }
			         else {
			        	 SearchExit = true;
			         }
			         
			         fr.close();
			         
		        }SearchExit = false;
		        
		        
								break;
								
			case 0 :
				 System.out.println("Thank You");
					menuExit = false;
					SearchExit = false;
				break;
		        			
								
			}
		}menuExit = false;
	}

}
