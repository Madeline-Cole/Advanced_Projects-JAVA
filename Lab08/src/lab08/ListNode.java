/**
 * Package lab08 contains classes for implementing a linked list of integer values.
 * The ListNode class is responsible for representing individual nodes in the list.
 */
package lab08;

/**
 * The {@code ListNode} class represents a single node in a linked list of integer values.
 * Each node contains an integer value and a reference (link) to the next node in the list.
 * This class is commonly used in implementations of singly linked lists.
 * 
 * Instances of this class can be created with or without specifying the integer value and the next node.
 * The default constructor initializes the data to 0 and the next node to {@code null}.
 * 
 * Usage Example:
 * ListNode node1 = new ListNode(5);        // Create a node with data 5 and next as null
 * ListNode node2 = new ListNode(10, node1); // Create a node with data 10 and next pointing to node1
 * 
 * @see LinkedIntList
 * @see LinkedIntListTester
 * @author Your Name
 */
public class ListNode {
    /**
     * The integer data stored in this node.
     */
    public int data;

    /**
     * The reference to the next {@code ListNode} in the list.
     * If this is the last node, {@code next} will be {@code null}.
     */
    public ListNode next;

    /**
     * Constructs a new node with data initialized to 0 and the next reference set to {@code null}.
     */
    public ListNode() {
        this(0, null);
    }

    /**
     * Constructs a new node with the specified integer data and the next reference set to {@code null}.
     * 
     * @param data the integer data to store in this node
     */
    public ListNode(int data) {
        this(data, null);
    }

    /**
     * Constructs a new node with the specified integer data and the specified reference to the next node.
     * 
     * @param data the integer data to store in this node
     * @param next the reference to the next node in the list, or {@code null} if this is the last node
     */
    public ListNode(int data, ListNode next) {
        this.data = data;
        this.next = next;
    }
}
