/*
 Written By: Bryan Bustillos
 Date: September 6, 2019
 File Name: Employee.java
 Description: Creates employee objects, copies of employee objects, checks whether objects are the same, and retrieves data from a variable within separate objects and joins them
 */

import java.util.Arrays;

public class Employee {
	
	// Create variables
	String name, state; // String variables
	int no, age, zip; // Int variables
	
	// Create advisors array
	int[] advisors;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		// Initializing variables
		int[] Adv = new int[3];
		int[] Adv2 = {84661, 75142, 75142};
		int[] Adv3 = {84661, 70234};
		int max, min; 
		max = 100000; // Max advisor ID
		min = 1; // Min advisor ID
		
		// Create advisors 
		for(int i = 0; i < 3; i++) {
			Adv[i] = (int)(Math.random() * ((max - min) + 1) + min);
		} // End of loop 
		
		// Create and initialize employee object with default construtor
		Employee a = new Employee();
		
		// Create and initialize employee objects with variables
		Employee b = new Employee("Bryan Bustillos", "New Mexico", 19, 88081, 115, Adv);
		
		Employee c = new Employee("Alex Hernandez", "NM", 19, 88081, 114, Adv2);
		
		Employee d = new Employee("The Rock", "CA", 47, 94540, 570, Adv2);
		
		Employee e = new Employee(d); // Copying contents from object d
		
		Employee f = new Employee("Matt Damon", "MI", 42, 94524, 771, Adv3);
		
		// Testing default constructor
		System.out.println("Employee Null:\n\n" + a);
		
		// Testing value constructor
		System.out.println("Employee 01:\n\n" + b);
		System.out.println("Employee 02:\n\n" + c);
		
		// Testing equals method with false
		System.out.println("Same Employee No: " + b.equals(a) + "\n");	
		
		// Testing equals method with true
		System.out.println("Same Employee No: " + d.equals(e) + "\n");
		
		// Testing getAllAdvisors method with duplicate in one array
		System.out.println("All advisors:\n");
		printArray(getAllAdvisors(d, b));
		
		// Testing getAllAdvisors method with duplicates in both arrays
		System.out.println("\nAll advisors 2:\n");
		printArray(getAllAdvisors(d, f));
		
		// Testing getAllAdvisors method with same array
		System.out.println("\nAll advisors 3:\n");
		printArray(getAllAdvisors(c, c));
		
		// Testing copy
		System.out.println("\nThe original is:\n" + d);
		System.out.println("The copy is:\n" + e);
	} // End of main
	
	// Start of default constructor
	Employee() {
		setName(null);
		setState(null);
		setAge(0);
		setZip(0);
		setNo(0);
		advisors = null;
	} // End of default constructor
	
	// Start of parameter constructor
	Employee(String n, String s, int a, int z, int num, int[] A) {
		setName(n);
		setState(s);
		setAge(a);
		setZip(z);
		setNo(num);
		setAdvisors(A);
	} // End of parameter constructor
	
	Employee(String n, String s, int a, int z, int num) {
		setName(n);
		setState(s);
		setAge(a);
		setZip(z);
		setNo(num);
	} // End of parameter constructor
	
	// Copy values from given object to current object
	 Employee(Object obj) {
		if((obj != null) && (obj instanceof Employee)) { // Precodition of obj not being null and being an instance of employee
			Employee loc = (Employee) obj;
			this.name = loc.getName(); 
			this.state = loc.getState();
			this.age = loc.getAge();
			this.zip = loc.getZip();
			this.no = loc.getNo();
			this.advisors = loc.getAdvisors();
		} // End of if
	} // End of copy construtor
	
	// Accessor functions
	public int getNo() {
		return(no);
	} // End of employee number accessor
	
	public int getAge() {
		return(age);
	} // End of age accessor
	
	public int getZip() {
		return(zip);
	} // End of zip accessor
	
	public String getState() {
		return(state);
	} // End of state accessor
	
	public String getName() {
		return(name);
	} // End of name accessor
	
	public int[] getAdvisors() {
		return(advisors);
	} // End of advisors accessor
	
	// Mutator functions
	public void setNo(int n) {
		no = n; 
	} // End of employee number mutator
	
	public void setAge(int a) {
		age = a;
	} // End of age mutator
	
	public void setZip(int z) {
		zip = z;
	} // End of zip mutator
	
	public void setState(String s) {
		state = s;
	} // End of state mutator
	
	public void setName(String n) {
		name = n;
	} // End of name mutator
	
	public void setAdvisors(int[] A) {
		if(A.length <= 3 && A.length >= 0) {
			advisors = A;
		}
		else 
			System.out.println("You can't have more than three advisors or less than zero advisors! Please fix!"); 
	} // End of advisor mutator
	
	// Start of toString method
	// Allows the printing of an Employee object
	public String toString() {
		return("Employee Name: " + name + "\nEmployee Number: " + no + "\nAge: " + age + "\nState: " + state + "\nZip: " + zip + "\nAdvisors: " + Arrays.toString(advisors) + "\n");
	} // End of toString
	
	// Array print function
	public static void printArray(int[] m) {
		for(int i = 0; i < m.length; i++) {
			System.out.println(m[i]);
		} // End of loop
	} // End of array print function
	
	// Start of equals function
	// Checks if employee no is the same
	public boolean equals(Object obj) {
		if(this == obj) // If both are the same then no is the same
			return(true);
		else if(obj == null || obj.getClass() != this.getClass()) // If null or not of same class then no is different, checks for precondition of object not being null nor not an instance of employee
			return(false);
		else { 
			// Test if parsed object's no is the same as calling object
			Employee rand = (Employee) obj;
			return(rand.no == this.no);
		} // End of else	
	} // End of equals
	
	// Start of getAllAdvisors method
	// Returns all unique advisors
	public static int[] getAllAdvisors(Employee e1, Employee e2) { // Zero indicates null
		// Create return array and initialize to size of both passed objects' arrays
		int[] z = new int[e1.advisors.length + e2.advisors.length]; 
		int count = 0;
		
		if(e1 != null && e2 != null) { // Precondition of neither objects being null
			for(int i = 0; i < e1.advisors.length; i++) { // For loop that copies all unique contents from first array to new array
				if(i != 0) {
					if(z[i - 1] != e1.advisors[i]) {
						z[i] = e1.advisors[i];
						count++;
					} // End of if that checks there are no duplicates within first array and copies unique values
				} // End of if that checks whether checking last element will lead to out of bounds error
				else {
					z[i] = e1.advisors[i];
					count++;
				} // End of else that copies first element from first array
					
			} // End of e1 loop
			
			for(int j = 0; j < e2.advisors.length; j++) { // For loop that copies remaining, no repeats, advisors from second array to new array
				if(j != 0) {
					if(z[j - 1] != e2.advisors[j] && (e2.advisors[j - 1] != e2.advisors[j])) { // Checks that no values the new array has are copied again
						z[count + j] = e2.advisors[j];
					} // End of compare if
				} // End of if that checks out of bound error doesn't occur
				else {
					if(z[j] != e2.advisors[j]) { // Checks that no values the new array has are copied again
						z[count + j] = e2.advisors[j];
					} // End of compare if
				} // End of else that checks first element in second array doesn't equal an element in new array
			} // End of e2 loop
		} // End of null check
			
		return(z);
	} // End of getAllAdvisors method

} // End of Employee class