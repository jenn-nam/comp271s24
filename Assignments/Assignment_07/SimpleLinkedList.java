
/**
 * A basic linked list that offers stack-like and queue-like behavior.
 */
public class SimpleLinkedList implements Stack271<String>, Queue271<String> {

    /** The first node of the linked list */
    private Node head;

    /** The last node of the linked list */
    private Node tail;

    /**Initialize empty array */

    /**
     * A node will be added at the beginning with this method 
     * element will be moved to the front of LL
     *   
     */
    public boolean push(String data) {
        //new node 
        Node createdNode = new Node(data);
        //check if list is empty 
        if (isEmpty()) {
            //head and taill will se set to the created node
            head = tail = createdNode; 
        }else{//if list is not empty,
            //created node's reference set to head
            createdNode.setNext(head);
            //update the head to pt to created node
            head = createdNode; 
        }
        return true; 
    }

    /**
     * removes element from front of LL 
     */

    public void pull() {
        result = "";
        if (head != null) {
            // data from head node 
            result = head.toString();
            //pointer of hed will point to next node 
            head = head.getNext();
            //tail set to null if list is empty 
            if(head == null) {
                tail = null; 
            }
        }
    }

    /**
     * adds node to end of list
     */
    publis boolean add (String data) {
        //new node with given information 
        Node createdNode = new Node(data);
        //if list is empty, head and trail = created node 
        if (head == null) {
            head = tail = createdNode;
        //if not empty, current tail ref. will be set to created node and tail will be updated 
        }else {
            tail.setNext(createdNode);
            tail = createdNode; 
        }
        return true; 
    }

    /**
     * node will be removed at the beg. of list 
     */

    public void remove () {
        result = " ";
        //data from head node 
        if (head != null) {
            //head pointer --> next node
            //tail = null if list empty 
            result = head.toString();
            head = head.getNext();
            if (head ==null) {
                tail = null; 
            }
        }
        
    }
    //to see is LL is empty 
    public boolaen isEmpty() {
        return head == null; 
    }
    //retrieves result
    public String getResult() {
        return result; 
    }

    public static void main(String[] args) {

        SimpleLinkedListSolution demoQueue = new SimpleLinkedListSolution();
        SimpleLinkedListSolution demoStack = new SimpleLinkedListSolution();

        demoQueue.add("A");
        demoQueue.add("B");
        demoQueue.add("C");
       
        boolean queueWorks = demoQueue.remove().equals("A") &&
                demoQueue.remove().equals("B") &&
                demoQueue.remove().equals("C") &&
                demoQueue.remove() == null;

        demoStack.push("A");
        demoStack.push("B");
        demoStack.push("C");

        boolean stackWorks = demoStack.pull().equals("C") &&
                demoStack.pull().equals("B") &&
                demoStack.pull().equals("A") &&
                demoStack.pull() == null;

        System.out.println(queueWorks);
        System.out.println(stackWorks);
    }


} // class SimpleLinkedList
