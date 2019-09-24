import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 Written By: Bryan Bustillos
 Date:September 12, 2019
 File Name: EmployeeSet.java
 Purpose: Make an array of Employee objects and manage them, also be able to read from a csv and create employee objects
 */

public class EmployeeSet {
	
	// Declare essential variables for EmployeeSet to function
	Employee[] employees;
	int eCount = 0; 
	
	// Default EmployeeSet instance constructor
	public EmployeeSet() {
		eCount = 0;
		employees = new Employee[10]; 
	} // End of default constructor
	
	// Copies an EmployeeSet instance to a new instance
	public EmployeeSet(Object obj) {
		if((obj != null) && (obj instanceof EmployeeSet)) {
			// Declare locale instance to serve as temp for new instance to be copied from
			EmployeeSet loc = (EmployeeSet) obj; 
			employees = new Employee[loc.employees.length]; 
			
			// Copies objects from passed array to new array, increases element size/count
			for(int u = 0; u < employees.length; u++) {
				if(loc.employees[u] != null) {
					employees[u] = new Employee(loc.employees[u]);
					eCount++;
				} // End of if that checks only actual elements are copied
					
			} // End of object copy loop
		} // End of precondition check
	} // End of copy constructor
	
	// Accessor for actual amount of elements in array
	public int size() {
		return(eCount); 
	} // End of number of elements accessor
	
	// Accessor for array length
	public int capacity() {
		return(employees.length);
	} // End of collection instance capacity accessor
	
	// Adds employee an object to an EmployeeSet's Employee array
	public void add(Employee a) {
		// Ensure array doesn't run out of space
		if(eCount == employees.length) {
			ensureCapacity(eCount * 2 + 1);
		} // End of if
		
		// Add employee and increase element size/count
		employees[eCount] = a;
		eCount++;
	} // End of EmployeeSet instance mutator
	
	// Check whether an employee exist in an instance's array by matching ID's
	public boolean contains(Employee a) {
		if(a != null) {
			for(int h = 0; h < employees.length; h++) {
				if(employees[h].getNo() == a.getNo())
					return(true); 
			} // End of for
			return(false);
		} // End of if
		return(false);
	} // End of input parameter accessor
	
	// Removes specified employee from array by ID
	public boolean remove(int eno) {
		int index = 0; 
		while((index < eCount) && (eno != employees[index].getNo()))
			index++;
		
		if(index == eCount)
			return(false);
		else {
			employees[index] = employees[eCount]; // Might not work, see self-test exercise 22
			eCount--;
			return(true);
		} // End of else
	} // End of remove method
	
	// Ensures that array never goes out of bounds and size is allocated as needed
	private void ensureCapacity(int minimumCapacity) {
		Employee[] bigA;
		
		if(employees.length < minimumCapacity) {
			bigA = new Employee[minimumCapacity];
			System.arraycopy(employees, 0, bigA, 0, eCount);
			employees = bigA;
		} // End of if
	} // End of ensureCapacity method
	
	// 
	public void addOrdered(Employee a) {
		
		// Null precondition check
		if(a == null)
			return;
		
//		// Already in order precondition check
//		for(int i = 0; i < employees.length && employees[i] != null; i++) {
//			if(employees[i].getNo() > employees[i + 1].getNo())
//				return;
//		} // End of for
		
		// Array capacity precondition check
		if(eCount == employees.length) {
			ensureCapacity(eCount * 2 + 1);
		} // End of if
		
//		// Loop through array until employee may be inserted
//		int n;
//		for(n = employees.length; ((n >= 0) && (employees[n].getNo() > a.getNo())); n--) {
//			employees[n + 1] = employees[n]; 
//		} // End of for
//		
//		// Add new employee and increment element size/count
//		employees[n + 1] = a;
//		eCount++;
	} // End of addOrdered method
	
	// Assisting method which allows the printing of Employee arrays
	public static void printArray(Employee[] m) {
		for(int i = 0; i < m.length; i++) {
			//if(m[i] != null)
				System.out.println(m[i]);
		} // End of loop
	} // End of array print function
	
	// Read method reads a csv file then uses data gathered to make Employee objects which are then added 
	// to the local EmployeeSet instance which is then returned for use in main after all employees have been
	// recorded
	public static EmployeeSet read(String fname) {
		EmployeeSet a = new EmployeeSet(); // Initializing and declaring instance with default constructor
		
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
                 
            	// Read the first row from CSV, ensures that first row info is not copied
                if( count == 0) {
                    //System.out.println(eInfo[0] + " \t " + eInfo[1] + " \t " + eInfo[2] + " \t " + eInfo[3] + " \t " + eInfo[5] + " \t " + eInfo[6]);
                    //eWrite[0] = (eInfo[0] + " \t " + eInfo[1] + " \t " + eInfo[2] + " \t " + eInfo[3] + " \t " + eInfo[5] + " \t " + eInfo[6]);
                } // End of if
                
                // Read subsequent rows, ensures we only read the actual employee information
                else{
                	// Creates new Employee objects from read data and adds it to an instance's object array
            		a.add(new Employee(eInfo[0] + eInfo[1], eInfo[3], Integer.parseInt(eInfo[6]), 
            				Integer.parseInt(eInfo[4]), Integer.parseInt(eInfo[2]) ));                  	
 
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
        return(a);
	} // End of read method
	
	// Test above methods and constructors
	public static void main(String[] args) {
		// Declaring EmployeeSet instance and initializing with default constructor
		EmployeeSet c = new EmployeeSet();
		
		// Declaring EmployeeSet instance and testing copy constructor
		EmployeeSet b = new EmployeeSet(read("core_dataset.csv"));
		
		// Declaring EmployeeSet instance and testing copy constructor
		EmployeeSet d = new EmployeeSet(b);
		
		// Declaring EmployeeSet instance for addOrdered
		EmployeeSet e = new EmployeeSet();
		e.employees[0] = new Employee("Bryan Bustillos", "New Mexico", 19, 88081, 115);
		e.employees[1] = new Employee("Alex Hernandez", "NM", 19, 88081, 114);
		e.employees[2] = new Employee("The Rock", "CA", 47, 94540, 570);
		
		// Declaring EmployeeSet instance for addOrdered
		EmployeeSet f = new EmployeeSet();
		f.employees[0] = new Employee("Alex Hernandez", "NM", 19, 88081, 114);
		f.employees[1] = new Employee("Bryan Bustillos", "New Mexico", 19, 88081, 115);
		f.employees[2] = new Employee("The Rock", "CA", 47, 94540, 570);
		
		
		// Printing results of copy constructor
		printArray(b.employees);
		
		// Testing size() method with data from csv
        System.out.println(read("core_dataset.csv").size());
        
        // Testing size() method with instance created through copy constructor
        System.out.println("Size of instance b: " + b.size() + "\n");
        
        // Testing capacity() method with instance created through copy constructor
        System.out.println("Capacity of instance b: " + b.capacity() + "\n");
        
        //Testing remove() method
        System.out.println("Testing remove method:\n\n" + "ID Exist: " + b.remove(1001644719) + "\n");
        printArray(b.employees);
        System.out.println("\nSize of instance b after removal: " + b.size());
        
        // Testing remove() method with invalid ID
        System.out.println("\nTesting remove method:\n\n" + "ID Exist: " + b.remove(1102024058) + "\n");
        printArray(b.employees);
        System.out.println("\nSize of instance b after removal: " + b.size());
        
        // Testing contains() method with matching employees
        System.out.println("\nDoes the first object match: " + b.contains(d.employees[0]));
        
        // Testing contains() method with different employees, the removed employee
        System.out.println("\nDoes the first object match: " + b.contains(d.employees[d.eCount]));
        
        // Testing addOrdered() method, doesn't do it because not ordered
        System.out.println("\nTesting addOrdered: \n");
        e.addOrdered(new Employee("Matt Damon", "MI", 42, 94524, 371));
        printArray(e.employees);
        
//        // Testing addOrdered() method, array is ordered
//        System.out.println("\nTesting addOrdered: \n");
//        f.addOrdered(new Employee("Matt Damon", "MI", 42, 94524, 371));
//        printArray(f.employees);
        
        // Testing default constructor
     	System.out.println("\nNull EmployeeSet:");
     	printArray(c.employees);
	} // End of main
} // End of EmployeeSet class

// For help with functions see Figure 3.7 or pages 137 to 141