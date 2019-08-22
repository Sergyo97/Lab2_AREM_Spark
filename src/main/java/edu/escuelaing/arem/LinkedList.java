package edu.escuelaing.arem;

/**
 * Class of a LinkedList
 * @author Sergio Ruiz
 */
public class LinkedList {
    
    private Node head;
    
    /**
     * Class LinkedList Constructor
     */
    public LinkedList() {  	
    }
    
    /**
     * Method that add a new node to LinkedList end
     * @param data New node value
     */
    public void append(Double data) {
        if(head == null) {
            head = new Node(data);
            return;
        }
    
        Node current = head;
        while(current.getNext() != null) {
            current = current.getNext();
        }
        current.next = new Node(data);
    }
    
    /**
     * Method that add a new node to LinkedList begin
     * @param data 
     */
    public void prepend(Double data) {
    
        Node newHead = new Node(data);
        newHead.next = head;
        head = newHead;
        
    }
    
    /**
     * Method that delete a node from the LinkedList
     * @param data Value to find the node to delete
     */
    public void delete(Double data) {
    
        if(head == null) return;
        if(head.getData() == data) {
            head = head.getNext();
            return;
        }
        
        Node current = head;
        while(current.getNext() != null) {
            if (current.getNext().getData() == data) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        } 
        
    }

    /**
     * Give node's head
     * @return head Node's head 
     */
    public Node getHead() {
        return head;
    }

    /**
     * Set new node head
     * @param head Head to set
     */
    public void setHead(Node head) {
        this.head = head;
    }

    /**
     * @return Result of set String calling for a non-null argument
     */
    @Override
    public String toString() {
        return "LinkedList{" + "head=" + head + '}';
    }
    
}