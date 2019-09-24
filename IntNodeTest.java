/**
 @author Bryan Bustillos
 Date: September 22, 2019
 File Name: IntNodeTest.java
 Purpose: Test methods of IntNode.java
 */
public class IntNodeTest {
	/** Test methods inherited from IntNode class
	 * @param args
	 */
	public static void main(String[] args) {
		// Declaring and initializing IntNode objects
		IntNode a = new IntNode(); 
		IntNode b = new IntNode(34, null);
		
		// Printing default constructed IntNode object
		System.out.println("Default Linked-List 'A':\n" + a);
		
		// Testing addNode method and printing result
		a.addNodeAfterThis(19);
		a.getLink().addNodeAfterThis(27);
		a.getLink().addNodeAfterThis(32);
		System.out.println("\nLinked-List 'A' After Add:\n" + a);
		
		// Testing removeNode method and printing result
		a.removeNodeAfterThis();
		a.removeNodeAfterThis();
		System.out.println("\nLinked-List 'A' After Remove:\n" + a);
		
		// Testing removeNode method until object is empty and with nothing to remove
		a.removeNodeAfterThis();
		a.removeNodeAfterThis();
		System.out.println("\nLinked-List 'A' After Remove:\n" + a);
		
		// Testing addNode to null IntNode object
		a.addNodeAfterThis(56);
		a.getLink().addNodeAfterThis(31);
		a.getLink().getLink().addNodeAfterThis(42);
		System.out.println("\nLinked-List 'A' After Add:\n" + a);
		
		// Printing parameter constructed IntNode object
		System.out.println("\nParameter Linked-List 'B':\n" + b);
		
		// Testing method listLength with list B
		System.out.println("\nLinked-List 'B' Size:\n" + IntNode.listLength(b));
		
		// Testing method listLength with list A
		System.out.println("\nLinked-List 'A' Size:\n" + IntNode.listLength(a));
		
		// Testing method search with list A from beginning
		System.out.println("\nLinked-List 'A' holds 42: " + IntNode.search(a, 42));
		
		// Testing method search with list A from end (after last node)
		System.out.println("\nLinked-List 'A' holds 42: " + IntNode.search(a.getLink().getLink().getLink().getLink(), 42));
		
		// Testing method search with list B from beginning
		System.out.println("\nLinked-List 'B' holds 34: " + IntNode.search(b, 34));
		
		// Testing method search with list B with a value that's not present
		System.out.println("\nLinked-List 'B' holds 37: " + IntNode.search(b, 37));
	} // End of main
} // End of IntNodeTest class