import java.util.Collection;
import java.util.ArrayList;

public class MaxPQHeap extends MaxPriorityQueue<T extends Comparable<? super T>> {
	
	private ArrayList<T> heap;

	public MaxPQHeap() {
		this.heap = new ArrayList();
	}

    /** Get the number of elements in the priority queue.
     *  @return the size
     */
    int size() {
    	return 0;
    }

    /** Determine if the priority queue is empty or not.
     *  @return true if empty, false otherwise
     */
    boolean isEmpty() {
    	return false;
    }

    /** Dump the contents of the priority queue.
     */
    void clear() {
    	return;
    }

    /** Find out the maximum value in the queue (no removal).
     *  @return the max value (throw exception if empty)
     */
    T getMax() throws QueueEmptyException {
    	return null;
    }

    /** Remove the maximum value in the queue.
     *  @return the value removed (throw exception if empty)
     */
    T removeMax() throws QueueEmptyException {
    	return null;
    }

    /** Add a value to the priority queue.
     *  @param val the value to be added (duplicates ok)
     */
    void insert(T val) {
    	return;
    }

    /** Initialize a priority queue from a container of values.
     *  @param values the collection of starting values
     */
    void init(Collection<T> values) {
    	return;
    }
}