package edu.escuelaing.arem;

/**
 * Class of a Node
 * @author Sergio Ruiz
 */
public class Node {
    
    Node next;
    private Double data;
    
    /**
     * Constructor of Node
     * @param data Node's value
     */
    public Node(Double data) {
        this.data = data;
    }
    
    /**
     * Give next node
     * @return next Next node 
     */
    public Node getNext() {
        return next;
    }

    /**
     * Set next node
     * @param next New node to set
     */
    public void setNext(Node next) {
        this.next = next;
    }

    /**
     * Give Node's value
     * @return data Node's value
     */
    public Double getData() {
        return data;
    }

    /**
     * Set Node's value
     * @param data Value to set the node
     */
    public void setData(Double data) {
        this.data = data;
    }

    /**
     * @return Result of set String calling for a non-null argument
     */
    @Override
    public String toString() {
        return "Node{" + "next=" + next + ", data=" + data + '}';
    }
    
}
