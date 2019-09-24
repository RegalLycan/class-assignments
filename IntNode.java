/** 
 * @author Bryan Bustillos
 * Date: September 22, 2019
 * File Name: IntNode.java
 * Purpose: Create an IntNode class with constructors and methods to be used by another program
 */
public class IntNode {
	// Declare instance variables
	int val;
	IntNode link;
	
	/** Constructors
	 * @precondition none
	 * @postcondition make a default IntNode object
	 */
	IntNode(){
		val = 0;
		link = null;
	} // End of default constructor
	
	/**
	 * @precondition none
	 * @postcondition make an IntNode object with given parameters
	 * @param _data
	 * @param _node
	 */
	IntNode(int _data, IntNode _node){
		setLink(_node);
		setVal(_data);
	} // End of parameter constructor
	
	/** Sets link node
	 * @postcondition set IntNode to passed parameter
	 * @param _node
	 */
	public void setLink(IntNode _node) {
		link = _node;
	} // End of link mutator
	
	/** Sets value
	 * @postcondition set value instance to passed parameter
	 * @param _data
	 */
	public void setVal(int _data) {
		val = _data;
	} // End of value mutator
	
	/** Accesses value from current node
	 * @return int
	 */
	public int getVal() {
		return(this.val);
	} // End of value accessor
	
	/** Accesses link/node
	 * @return IntNode
	 */
	public IntNode getLink() {
		return(this.link);
	} //  End of link accessor
	
	/** Creates String in order to print IntNode objects
	 * @precondition IntNode object
	 * @return Printable String
	 */
	public String toString() {
		// Declare and initialize local variables
		IntNode tmp = this.getLink();
		String s = "";
		
		// Iterate through a linked list and add to a string any values at those valid nodes
		if(tmp != null) {
			while(tmp != null) {
				s += tmp.getVal();
				tmp = tmp.getLink();
				if(tmp != null)
					s += "->";
			} // End of iterating loop
		} // End of null precondition check
		else 
			s += this.getVal();
		
		// Return printable string
		return(s);
	} // End of toString method
	
	/** Add method which adds a node with value after given node
	 * @postcondition adds a node with a value after given node
	 * @param newdata
	 */
	public void addNodeAfterThis(int newdata) {
		link = new IntNode(newdata, link);
	} // End of addNode method
	
	/** Remove method which removes node after given node
	 * @precondition node isn't null
	 * @postcondition removes following node
	 */
	public void removeNodeAfterThis() {
		if(this.getLink() != null)
			link = this.getLink().getLink();
		else
			return;
	} // End of removeNode method
	
	/** listLength method which iterates through list and counts number of nodes
	 * @precondition head isn't null
	 * @param head
	 * @return int
	 */
	public static int listLength(IntNode head) {
		// Declare and initialize variables
		IntNode cursor = head.getLink(); 
		int cnt = 0;
		
		// Iterate through list and count number of nodes
		if(cursor != null) {
			while(cursor != null) {
				cursor = cursor.getLink();
				cnt++;
			} // End of iterating loop
		} // End of null precondition check
		else
			cnt++;
		return(cnt);
	} // End of listLength method
	
	/** Search method which iterates through list until value is found or is discovered to be missing
	 * 
	 * @param head
	 * @param data
	 * @return boolean
	 */
	public static boolean search(IntNode head, int data) {
		// Declare and initialize IntNode variable
		IntNode cursor = head; 
		
		// Iterate through list until value is found else return false
		while(cursor != null) {
			if(cursor.getVal() == data) {
				return(true);
			} // End of value check
			cursor = cursor.getLink();
		} // End of iterating loop
		return(false);
	} // End of search method
	
	/** Start of main
	 * @param args
	 */
	public static void main(String[] args) {
	} // End of main
} // End of IntNode class