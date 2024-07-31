public class Hash271 {

    /** Default size for foundation array */
    private static final int DEFAULT_SIZE = 4;

    /** Foundation array of node objects */
    Node[] foundation;

    /** Basic constructor */
    public Hash271(int size) {
        this.foundation = new Node[size];
    } // basic constructor

    /** Default constructor */
    public Hash271() {
        this(DEFAULT_SIZE);
    } // default constructor

    /** Default for load factor */
    private static final int double DEFAULT_THRESHOLD = 0.75; 

    /** Number of nodes */
    private int nodeNumber; //tracking number of nodes 

    /** Threshhold for load factor */
    private double threshold; //based on this treshold, resizing will happen 

    /** Constructor for node size AND threshold */
    public Hash271(int size, double threshold) {
        this.foundation = new Node[size];
    
        //node counting will start at 0 
        this.threshold = 0; 

        //threshold will be set
        this.nodeNumber = threshold; 
    }

    /**
     * Map an integer number to one of the positions of the underlying array. This
     * will come handy we need to find the place to chain a node.
     * 
     * @param value int to map to one of the array positions
     * @return int with the integer division remainder between the input value and
     *         the length of the array
     */
    private int computeArrayPosition(int value) {

         //adds length of array for positive index, then takes modulus 
        return (value % this.foundation.length + this.foundation.length) % this.foundation.length;
    } // method computeArrayPosition

    /**
     * Chain a node to the underlying array
     * 
     * @param node Node to chain to the underlying array
     */
    public void put(Node node) {
        // Operate only is node is not null
        if (node != null) {
            //divide number of nodes by length of array (checking load factor). If load factor is > threshold, then resize. 

            if ((double) nodeNumber / foundation.length > threshold) {
                rehash();//calling rehash method to resize
            }
            //node count will have to increase (++)

            // Use the node's hashcode to determine is position in
            // the underlying array
            int destination = computeArrayPosition(node.hashCode());
            // If the position in the array is occupied by another node,
            // place that node under the new node we wish to insert
            if (this.foundation[destination] != null) {
                node.setNext(this.foundation[destination]);
            }
            // Put the new node to the array position
            this.foundation[destination] = node;

            nodeNumber ++; 
        }
    } // method put

    /**
     * Wrapper for put(Node). Accepts a string, creates a Node object and passes it
     * to the put(Node) method.
     * 
     * @param string String to create a node for, then chain that node to the
     *               underlying array.
     */
    public void put(String string) {
        if (string != null && string.length() > 0) {
            Node node = new Node(string);
            this.put(node);
        }
    } // method put

    /** String representation of this object */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.foundation.length; i++) {
            sb.append(String.format("[ %03d ]: ", i));
            Node current = this.foundation[i];
            while (current != null) {
                sb.append(String.format("<%s> ", current.toString()));
                current = current.getNext();
            }
            sb.append("\n");
        }
        return sb.toString();
    } // method toString

    /**
     * method doubles array and then puts nodes back 
     */
    private void rehash() {
        //keep old array, then make a bigger array
        Node [] prevFoundation = this.foundation;
        //double array 
        this.foundation = new Node[prevFoundation.length * 2];
        this.nodeNumber = 0; //node count initialized at 0 

        //iterate through old array
            //initialize a counter for iteration
        int index = 0; 
            //while loop for iteration 
        while (index < prevFoundation.length) {
            Node atNode = prevFoundation[index];
        
         //then traverse LL at whichever index at                   
            while (atNode != null) {
                 //nodes saved while traversing
                Node nodeNext = atNode.getNext();

                //sperate whichever node is being traversed 
                atNode.setNext(null);
                
                //take the node and put it back into new array (foundation)
                this.put(atNode);
                //move to next node 
                atNode = nodeNext;
            }
            index++; 
        }                           
    }
    /** Driver code */
    public static void main(String[] args) {
        Hash271 h = new Hash271();
        h.put(new Node("Java"));
        h.put(new Node("Python"));
        h.put(new Node("Lisp"));
        h.put(new Node("Fortran"));
        h.put(new Node("Prolog"));
        h.put(new Node("Cobol"));
        h.put(new Node("C++"));
        h.put(new Node("C"));
        h.put(new Node("C#"));
        System.out.println(h);
    }
}
