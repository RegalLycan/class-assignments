/* 
 Written By: Bryan Bustillos
 Date: August 30, 2019
 Class: CS 272
 Purpose: Read a csv file then write specific data from that csv to a new csv file
 File Name: EmployeeFileOp.java
 
 Description: The read and write functions work but I'm unable to print data as my eData can't
 			  be read from outside of the read function. I have, however, isolated the young
 			  employees just unable to write them. 
*/

package showtime;

import	java.io.FileReader;
import	java.io.FileWriter;
import	java.io.IOException;

// Line oriented I/O
import	java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;

class employee{
	String lastName, name, ID, state, zip, age, sex;
} // End of employee data class

public class EmployeeFileOp {
	private static employee[] eData = null; 
	
	
	
	// Beginning of read function
	public static void read(String fname) {
		// Declare & Initialize
        String line = "";
        int count = 0;
         
        //Delimiter used in CSV file
        final String DELIMITER = ",";
        
        // Go through the file and read it
        try
        {
           // FileReader
        	FileReader fileReader = new FileReader(fname);
            
            //Create the file reader
        	BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            //Read the file line by line
            while ((line = bufferedReader.readLine()) != null)
            {
            	String[] eInfo = line.split(DELIMITER);
                 
            	// Read the first row from CSV then write it
                if( count == 0) {
                    System.out.println(eInfo[0] + " \t " + eInfo[1] + " \t " + eInfo[2] + " \t " + eInfo[3] + " \t " + eInfo[5] + " \t " + eInfo[6]);
                	eData = new employee[350];
                    //eWrite[0] = (eInfo[0] + " \t " + eInfo[1] + " \t " + eInfo[2] + " \t " + eInfo[3] + " \t " + eInfo[5] + " \t " + eInfo[6]);
                } // End of if
                
                // Read subsequent rows and write them
                else{
                	//eInfo[0] = eInfo[0].replaceAll("\\p{Punct}", " ");
                    //eInfo[1] = eInfo[1].replaceAll("\\p{Punct}", "");
                	if(Integer.parseInt(eInfo[6]) <= 30) {
                		eData[count] = new employee();
                     	eData[count].lastName = eInfo[0];
                     	eData[count].name = eInfo[1];
                     	eData[count].ID = eInfo[2];
                     	eData[count].state = eInfo[3];
                     	eData[count].zip = eInfo[4];
                     	eData[count].age = eInfo[6];
                     	eData[count].sex = eInfo[7];
                    	
                        System.out.println(eInfo[0] + " " + eInfo[1] + "\t " + eInfo[2] + "\t " + eInfo[3] + "\t " + eInfo[4] + "\t " + eInfo[6] + "\t " + eInfo[7]);
                	} // End of age if
                	
                } // End of else
                count++;
            } // End of while
            bufferedReader.close();
            //write("young_employee.csv"); // Couldn't get the write to work as it can't access eData and thus gives null pointer exception
        } // End of try
        catch(FileNotFoundException ex) {
        	System.out.println("Unable to open file '" + fname + "'");
        } // End of file not found catch
        catch(IOException ex) {
        	System.out.println("Error reading file '" + fname + "'");
        } // End of IO exception catch
	} // End of read
	
	// Start of write function
	public static void write(String fname){
		try {
			File file = new File(fname);
			
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			
			bw.write(eData.length - 1);
			for(int i = 0; i < eData.length; i++) {
				bw.write(eData[i].lastName + eData[i].name + eData[i].ID + eData[i].state + eData[i].zip + eData[i].age + eData[i].sex);
			} // End of for loop
			bw.close();
			fw.close();
		} // End of try
		catch( IOException e) { 
			e.printStackTrace();
		} // End of catch

//		Writer writer = null; 
//	    try {
//			writer = new BufferedWriter(new FileWriter(fname));
//		    String line;
//		    for(int i = 0; i <= Array.length + 1; i++) {
//		    	
//			    writer.write(Array[i]);
//			    
//		    }
//	    } catch (IOException ex) {
//	    	
//	    }finally {
//	    	try {writer.close();} catch (Exception ex) {}
//	    }
//		
//		File csv = new File("young_employee.csv");
//		Scanner scnr = new Scanner(csv);
//		
//		for(int i = 0; i <= Array.length + 1; i++) {
//			System.out.println(Array[i]);
//		}

	} // End of write
	
//	public static void store(int N, String[] eInfo) {
//		eData = new employee[N];
//		for(int i = 0; i < N; i++) {
//			eData[i] = new employee();
//        	eData[i].lastName = eInfo[0];
//        	eData[i].name = eInfo[1];
//        	eData[i].ID = eInfo[2];
//        	eData[i].state = eInfo[3];
//        	eData[i].zip = eInfo[4];
//        	eData[i].age = eInfo[6];
//        	eData[i].sex = eInfo[7];
//        	
//        	System.out.println(eData[i].lastName + eData[i].name + eData[i].ID + eData[i].state + eData[i].zip + eData[i].age + eData[i].sex);
//		}
//		write("young_employee.csv");
//	}
	
	   // Beginning of main
		public static void main(String[] args){
			
			// Test read & write
			read("core_dataset.csv");
			//write("young_employee.csv");	// Couldn't get the write to work as it can't access eData and thus gives null pointer exception
			
		} // End of main

} // End of class
