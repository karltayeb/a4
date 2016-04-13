import java.util.Collection;

/** Interface for a generic maximum based priority queue. 
 *  @param <T> the generic type of the elements in the queue
 */
public interface MaxPriorityQueue<T extends Comparable<? super T>> {

    /** Get the number of elements in the priority queue.
     *  @return the size
     */
    int size();

    /** Determine if the priority queue is empty or not.
     *  @return true if empty, false otherwise
     */
    boolean isEmpty();

    /** Dump the contents of the priority queue.
     */
    void clear();

    /** Find out the maximum value in the queue (no removal).
     *  @return the max value (throw exception if empty)
     */
    T getMax() throws QueueEmptyException;

    /** Remove the maximum value in the queue.
     *  @return the value removed (throw exception if empty)
     */
    T removeMax() throws QueueEmptyException;

    /** Add a value to the priority queue.
     *  @param val the value to be added (duplicates ok)
     */
    void insert(T val);

    /** Initialize a priority queue from a container of values.
     *  @param values the collection of starting values
     */
    void init(Collection<T> values);

}
