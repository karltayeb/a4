import java.util.Collection;
import java.util.ArrayList;

public class MaxPQHeap<T extends Comparable<? super T>> implements MaxPriorityQueue<T> {
	
	private ArrayList<T> heap;

	public MaxPQHeap() {
		this.heap = new ArrayList();
	}

    /** Get the number of elements in the priority queue.
     *  @return the size
     */
    @Override
    public int size() {
    	return 0;
    }

    /** Determine if the priority queue is empty or not.
     *  @return true if empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
    	return false;
    }

    /** Dump the contents of the priority queue.
     */
    @Override
    public void clear() {
    	return;
    }

    /** Find out the maximum value in the queue (no removal).
     *  @return the max value (throw exception if empty)
     */
    @Override
    public T getMax() throws QueueEmptyException {
    	if (false) {
    		throw new QueueEmptyException();
    	}
    	return null;
    }

    /** Remove the maximum value in the queue.
     *  @return the value removed (throw exception if empty)
     */
    @Override
    public T removeMax() throws QueueEmptyException {
    	if (false) {
    		throw new QueueEmptyException();
    	}
    	return null;
    }

    /** Add a value to the priority queue.
     *  @param val the value to be added (duplicates ok)
     */
    @Override
    public void insert(T val) {
    	return;
    }

    /** Initialize a priority queue from a container of values.
     *  @param values the collection of starting values
     */
    @Override
    public void init(Collection<T> values) {
    	return;
    }
}