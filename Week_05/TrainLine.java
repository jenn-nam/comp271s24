public class TrainLine {
    
    private Station head;

    /**
     * Add a new station at the end of this trainline. The method creates
     * a new station object, first, with the given name. Then it checks to
     * if this line has a head station yet; if not, the new station becomes
     * the head station. If this line has a head station, the method begins
     * traversing this line from its head station, following the next points
     * untils it finds a station whose next is null. That station, by definition
     * is presently the last station in the line. The new station is added after 
     * that last station. 
     * 
     * @param name String with name of new station to add
     */
    public void addStation(String name) {
        // Create a new station object with the given name
        Station newStation = new Station(name);
        // Check if this trainline has a head station yet or not
        if (this.head == null) {
            // There is no head station in this trainline. Make the 
            // new station, just created, the head station and end.
            this.head = newStation;
        } else {
            // This line has a head station. Let's start traversing this line,
            // one station at a time, to find its last station. The station we
            // visit, in each step, is called the current station. We begin
            // with this trainline's head station.
            Station currentStation = this.head;
            // The while-loop below hops from station to station, until
            // it finds a station that points to null. That's the last
            // station of the line.
            while (currentStation.hasNext()) {
                currentStation = currentStation.getNext();
            }
            // When loop is over, currentStation is the last station. We want
            // to add the new station after the current station. All we have
            // to do is to make the current station point to the new station 
            // as its next station. Notice that the new station was created,
            // earlier, using the Station(String) constructor that left its
            // field next to null. Effectively, it is now the last station
            // this line because its field next is null.
            currentStation.setNext(newStation);
        }
    } // method addStation

/**
 * Contains method will accept a given name 
 * Intinalize a boolean var, inLine, to keep track of station names.
 * Start iterating at the beginning (head).
 * While current Station is not null/not at the end of train line AND inLine is false, 
 * will then check if name at current iteration is equal to the given Station name, 
 * then inline will become true, then return inline. 
 * 
 *  */
    public boolean contains(String givenStationName){
        //initialize boolean to keep track of wether or not a name matches
        boolean inLine = false; 

        //will begin iterating at the head (start of Train Line)
        Station currentStation = this.head; 
        
        //a while loop that check wether or not a given name is in train line 
        while (currentStation != null && !inLine){
            if(currentStation.getName().equals(givenStationName)){
                //if there is a match, then inLine becomes true 
                inLine = true; 
            }
            //moves to next station to be compared 
            currentStation = currentStation.getNext();
        }
        //returns inLine 
        return inLine; 
    }
}
