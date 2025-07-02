/**
 * Object adjusts the size of underlying array to accommodate any number of new
 * elements added to it. The class is written as generic.
 */
public class DynamicArray {

    private static final int DEFAULT_SIZE = 4;
    private static final int RESIZE_FACTOR = 2;

    /** The underlying array of the data structure */
    private String[] underlying;
    /** How many elements have been added to the underlying array */
    private int occupancy;

    /** Basic constructor */
    public DynamicArray(int size) {
        // Guard statement here to ensure that the user-provided size is legit.
        if (size < 1) {
            size = DEFAULT_SIZE;
        }
        // Create an Object array of the requested size, then cast it
        // as an array of objects E
        this.underlying = new String[size];
        // At the beginning the underlying array is empty
        this.occupancy = 0;
    } // basic constructor

    /** Default constructor */
    public DynamicArray() {
        this(DEFAULT_SIZE);
    } // default constructor

    /**
     * Resize the underlying array as needed.
     * 
     * @param resize_by int factor multiply the size of the underlying array
     */
    private void resize() {
        // Create temporary array of DOUBLE the size of the underlying array
        String[] temp = new String[2 * this.underlying.length];
        for (int i = 0; i < this.underlying.length; i++) {
            temp[i] = this.underlying[i];
        }
        this.underlying = temp;
    } // method resize

    public void add(String string) {
        // Is there room in the underlying array?
        if (this.occupancy == this.underlying.length) {
            this.resize();
        }
        // At this point there is guaranteed room in the array, either
        // because we just doubled it in size or because there was enough
        // room for one more element to begin with.
        this.underlying[this.occupancy] = string;
        this.occupancy++;
    } // method add

    /**
     * method to find the position of an element in the underlying array
     * 
     * @return -1 if string not present, otherwise underlying array position of
     *         first occurrence of string.
     */

     /**
      * Returns the inde of the first occurence of a string in the array 
      * Uses a while-loop to stop early when the targer is found 
      * This is to avoid unecessary iterations 
      */

    public int indexOf(String string) {
        int i = 0; 
        boolean found = false; 
        while (i < this.occupancy && !found) { 
            found = string.equals(this.underlying[i]);
            if (!found) i++; 
        }
        return found ? i : -1;  
    } // method indexOf

    /** Method to tell if a string exists in the underlying array */
    /**
     * Determines if a string exists in the array 
     * Simply calls indexOf which avoids double codes
     */
    public boolean contains(String string) {
        return this.indexOf(string) > -1; 
    }

    /** Method to count how many times a string appears in the underlying array*/
    /**
     * Counts how many times the given string appears in the array
     * Traverse only up to occupancy which avoids searching unused slots 
     */
    public int countOf(String string) {
        int count = 0; 
        for (int i = 0; i < this.occupancy; i++) { 
            if (string.equals(this.underlying[i])) {
                count++; 
            }
        }
        return count; 
    }

    /** method to remove items from the underlying array */
    /**
     * Removes and reurns the string at a given index 
     * Shifts all later elements left by one to close the gap 
     * Ensures no dangling values; adjusts occupancy accordingly 
     * Includes guard clause for invalid index 
     */
    public String remove(int index) {
        if (index < 0 || index >= this.occupancy) return null; 
        String removed = this.underlying[index]; 
        for (int i = index; i < this.occupancy - 1; i++) {
            this.underlying[i] = this.underlying[i + 1]; 
        }
        this.underlying[this.occupancy - 1] = null; 
        this.occupancy--; 
        return removed; 
    }

    /** overload remove */ 
    /**
     * Removes the firs occurence of the specified string from the array
     * Uses indexOf + remove(int) 
     */
    public String remove(String string) {
        int index = this.indexOf(string); 
        if (index > -1) {
            return this.remove(index); 
        }
        return null; 
    }

    /** Complete this method */
    /**
     * Returns a comma separated list of strings currently in the array 
     * Does not print unused nulls
     * Handles empty arrays easily 
     */
    public String toString() {
        if (this.occupancy == 0) return "[empty]"; 
        String result = this.underlying[0]; 
        for (int i = 1; i < this.occupancy; i++) { 
            result += ", " + this.underlying[i]; 
        }
        return "[" + result + "]"; 
    }

} // class DynamicArray