import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.lang.Math;

public class MaxPriorityQueueTest {
	static MaxPQHeap<Integer> empty;
	static MaxPQHeap<Integer> smalltolarge;
	static MaxPQHeap<Integer> largetosmall;
	static MaxPQHeap<Integer> allsame;
	static MaxPQHeap<Integer> randomgen;
	static MaxPQHeap<Integer>[] differentsizes;

    @Before
    public void initialize() {
    	/* To test empty heap. */
        empty = new MaxPQHeap();

        /* More than 1 to make sure heap order is maintained regardless
         * of what order the heap is built in, and tests when repeated
         * priority values are present. */
        smalltolarge = new MaxPQHeap();
        largetosmall = new MaxPQHeap();
        allsame = new MaxPQHeap();
        randomgen = new MaxPQHeap();
        differentsizes = new MaxPQHeap[100];

        for (int i = 0; i < 100; i++) {
            smalltolarge.insert((Integer) i);
            largetosmall.insert((Integer) (99 - i));
            allsame.insert((Integer) 1);
        }

        int random = 99;
        for (int i = 0; i < 100; i++) {
        	randomgen.insert((Integer) random);
        	// Ensures repeats and that 99 is the largest value
        	random = (Integer)(int)(Math.random() * 50 + 1);
        }

        for (int i = 0; i < differentsizes.length; i++) {
        	for (int j = 0; j <= i; j++) {
        		differentsizes[i].insert((Integer) j);
        	}
        }
    }

    /* TODO: Test size() on empty MaxPQ */

    /* Test size() on non-empty MaxPQ */
    @Test
    public void testSizeNonEmpty() {
    	// Correct size regardless of how heap is built
    	assertTrue("MaxPQ not the correct size", smalltolarge.size() == 100);
    	assertTrue("MaxPQ not the correct size", largetosmall.size() == 100);

    	// Correct size regardless of presence of equal priorities
    	assertTrue("MaxPQ not the correct size", allsame.size() == 100);
    	assertTrue("MaxPQ not the correct size", randomgen.size() == 100);

    	// Check all sizes 0 - 99, covers cases where heap is different # of levels
    	for (int i = 0; i < differentsizes.length; i++) {
    		assertTrue(differentsizes[i].size() == i);
    	}
    }
    /* TODO: Test isEmpty() on empty MaxPQ */

    /* Test isEmpty() on non-empty MaxPQ */
    public void testIsEmptyNonEmpty() {
    	// Correct result regardless of how heap is built    	
    	assertTrue("isEmpty() return empty when is non-empty", !smalltolarge.isEmpty());
    	assertTrue("isEmpty() return empty when is non-empty", !largetosmall.isEmpty());
    	// Correct result regardless of how heap is built
     	assertTrue("isEmpty() return empty when is non-empty", !allsame.isEmpty());
    	assertTrue("isEmpty() return empty when is non-empty", !randomgen.isEmpty());

    	// Checks all sizes of MaxPQ 1 - 99, size 1 is boundary condition
    	for (int i = 0; i < differentsizes.length; i++) {
    		assertTrue("isEmpty() returns empty when MaxPQ is not empty", !differentsizes[i].isEmpty());
    	}
    }

    /* TODO: Test clear() on empty MaxPQ */

    /* Test clear() on non-empty MaxPQ */
    public void testClearNonEmpty() {
    	smalltolarge.clear();
    	assertTrue("Size not updated correctly on clear()", smalltolarge.size() == 0);
		assertTrue("MaxPQ is not empty after clear()", smalltolarge.isEmpty());

    	largetosmall.clear();
    	assertTrue("Size not updated correctly on clear()", largetosmall.size() == 0);
		assertTrue("MaxPQ is not empty after clear()", largetosmall.isEmpty());

    	allsame.clear();
    	assertTrue("Size not updated correctly on clear()", allsame.size() == 0);
		assertTrue("MaxPQ is not empty after clear()", allsame.isEmpty());

    	randomgen.clear();
    	assertTrue("Size not updated correctly on clear()", randomgen.size() == 0);
		assertTrue("MaxPQ is not empty after clear()", randomgen.isEmpty());

		// Checks clear on a range of different sized MaxPQs, size 1 is boundary condition
		for (int i = 0; i < differentsizes.length; i++) {
	    	differentsizes[i].clear();
	    	assertTrue("Size not updated correctly on clear()", differentsizes[i].size() == 0);
			assertTrue("MaxPQ is not empty after clear()", differentsizes[i].isEmpty());			
		}
    }

    /* TODO: Test getMax() on empty MaxPQ (check that error is thrown) */

    /* Test getMax() on non-empty MaxPQ */
    public void testGetMaxNonEmpty() {
    	assertTrue("Max element is incorrect for heap built from small to large values",
    					smalltolarge.getMax() == (Integer) 99);
    	assertTrue("Max element is incorrect for heap built from large to small values",
    					largetosmall.getMax() == (Integer) 99);
    	assertTrue("Max element is incorrect for heap built with all identical values",
    					allsame.getMax() == (Integer) 99);
    	assertTrue("Max element is incorrect for heap built with largest value put in first",
    					randomgen.getMax() == (Integer) 99);
    	// Insert another value on random to check largest-inserted-last condition
    	randomgen.insert((Integer) 100); 
    	assertTrue("Max element is incorrect for heap built with largest value put in last",
    					randomgen.getMax() == (Integer) 100);

    	// Now check that the max value is true over a range of values
    	for (int i = 0; i < differentsizes.length; i++) {
    		assertTrue("Max element was incorrect when values vary.", differentsizes[i].getMax() == (Integer) i);
    	}
    }

    /* TODO: Test removeMax() on empty MaxPQ (check that error is thrown) */

    /* Test removeMax() on non-empty MaxPQ */
    public void removeMaxSmallToLarge() {
    	// Note the removed value should also be the size of the remaining MaxPQ
    	// This construction means we don't have to rely on getMax() to know what size to check for
    	// This construction allows us to not rely on size() to know the size of the remaining PQ
    	// but still requires us to use size() to check that the size is as expected.
    	// Tests the range of values up to but not including empty MaxPQ
    	Integer removed = smalltolarge.removeMax();
    	assertTrue("Remove Max didn't return correct value.", removed == (99));
		assertTrue("Remove Max didn't update size.", smalltolarge.size() == (99));
    	while(!smalltolarge.isEmpty()) {
    		removed--;
    		assertTrue("Remove Max didn't return correct value.", smalltolarge.removeMax() == (removed));
    		assertTrue("Remove Max didn't update size.", smalltolarge.size() == (removed));
    	}
    }
    public void removeMaxLargeToSmall() {
    	// Note the removed value should also be the size of the remaining MaxPQ
    	// This construction means we don't have to rely on getMax() to know what size to check for
    	// This construction allows us to not rely on size() to know the size of the remaining PQ
    	// but still requires us to use size() to check that the size is as expected.
    	// Tests the range of values up to but not including empty MaxPQ
    	Integer removed = largetosmall.removeMax();
    	assertTrue("Remove Max didn't return correct value.", removed == (99));
		assertTrue("Remove Max didn't update size.", largetosmall.size() == (99));
    	while(!largetosmall.isEmpty()) {
    		removed--;
    		assertTrue("Remove Max didn't return correct value.", largetosmall.removeMax() == (removed));
    		assertTrue("Remove Max didn't update size.", largetosmall.size() == (removed));
    	}
    }
    public void removeMaxAllSame() {
    	int size = 100;
    	while(!allsame.isEmpty()) {
    		size--;
    		assertTrue("Remove Max didn't return correct value.", allsame.removeMax() == (1));
    		assertTrue("Remove Max didn't update size.", largetosmall.size() == (size));
    	}
    }
    public void removeMaxRemovesSameAsGetMax() {
    	// Removes from the random list. This test is quite interdependent.
    	int random, removed;
    	while(!randomgen.isEmpty()) {
    		random = randomgen.getMax();
	    	removed = randomgen.removeMax();
	    	assertTrue("The value returned by removeMax() was not the same as that returned by getMax()",
	    					random == (removed));	
    	}
    }

    /* TODO test insert from empty list */

    /* Test insert() on non-empty lists */

    /* Inserts values smaller than the max value */
    public void testInsertSmallerValsNonEmpty() {
    	for (int i = 1; i <= 20; i++) {
    		smalltolarge.insert(i - 11);
    		largetosmall.insert(i - 11);
    		randomgen.insert(i - 11);

    		// Check that size gets updated
    		assertTrue("Size not updated on insert", smalltolarge.size() == (100 + i));
    		assertTrue("Size not updated on insert", largetosmall.size() == (100 + i));
    		assertTrue("Size not updated on insert", randomgen.size() == (100 + i));

    		// Check that maxVal is unchanged
    		assertTrue("MaxVal changed on insert of value < max", smalltolarge.getMax() == (99));
    		assertTrue("MaxVal changed on insert of value < max", largetosmall.getMax() == (99));
    		assertTrue("MaxVal changed on insert of value < max", randomgen.getMax() == (99));

    	}
    }

    /* Inserts values larger than/ equal to the max value */
    public void testInsertLargerValsNonEmpty() {
    	for (int i = 1; i <= 11; i++) {
    		smalltolarge.insert(i + 99);
    		largetosmall.insert(i + 99);
    		randomgen.insert(i + 99);

    		// Check that size gets updated
    		assertTrue("Size not updated on insert", smalltolarge.size() == (100 + i));
    		assertTrue("Size not updated on insert", largetosmall.size() == (100 + i));
    		assertTrue("Size not updated on insert", randomgen.size() == (100 + i));

    		// Check that maxVal is correct
    		assertTrue("MaxVal not updated when insert value >= max", smalltolarge.getMax() == (99 + i));
    		assertTrue("MaxVal not updated when insert value >= max", largetosmall.getMax() == (99 + i));
    		assertTrue("MaxVal not updated when insert value >= max", randomgen.getMax() == (99 + i));

    	}
    }

    public void testInertionOfDuplicates() {
    	// Repeatedly insert 1's to allsame
    	for (int i = 1; i <= 11; i++) {
    		allsame.insert(1);
    		assertTrue("Size not updated when inserting duplicates", allsame.size() == (100 + i));
    		assertTrue("MaxVal changed when inserting a duplicate value", allsame.getMax() == 1);
    	}

    	//Repeatedly insert duplicate random values to randomgen
        int random;
        for (int i = 1; i < 100; i++) {
            // Ensures repeats and that 99 is the largest value
        	random = (Integer)(int)(Math.random() * 50 + 1);
        	randomgen.insert((Integer) random);

    		assertTrue("Size not updated when inserting duplicates", allsame.size() == (100 + i));
    		assertTrue("MaxVal changed when inserting submaximal duplicate value", allsame.getMax() == 99);
        }
    }
}