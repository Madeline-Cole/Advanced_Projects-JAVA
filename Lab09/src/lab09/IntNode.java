package lab09;

/**
 * The IntNode class represents a single node in a binary tree
 * where each node stores an integer value. Each node has references to its left
 * and right child nodes, forming the structure of the binary tree.
 * 
 * This class provides constructors to create both leaf and branch nodes.
 * 
 * Chapter 17.1 - page 1021
 */
public class IntNode {

    /**
     * The integer data stored in the node.
     */
    public int data;

    /**
     * The reference to the left child node in the binary tree.
     * If there is no left child, this will be null.
     */
    public IntNode left;

    /**
     * The reference to the right child node in the binary tree.
     * If there is no right child, this will be null.
     */
    public IntNode right;

    /**
     * Constructs a leaf node with the given integer data. The left and right
     * child nodes are initialized to null.
     * 
     * @param data the integer value to be stored in the node
     */
    public IntNode(int data) {
        this(data, null, null);
    }

    /**
     * Constructs a branch node with the given integer data, left subtree, and
     * right subtree. This allows the creation of a node with child references.
     * 
     * @param data  the integer value to be stored in the node
     * @param left  the left child node of this node, or null if there is no left child
     * @param right the right child node of this node, or null if there is no right child
     */
    public IntNode(int data, IntNode left, IntNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
