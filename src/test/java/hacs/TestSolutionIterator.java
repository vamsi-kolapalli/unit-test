package hacs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestSolutionIterator {

    SolutionIterator iterator;
    SolutionList solutionList;
    Solution solution;

    @BeforeEach
    void start() {
        solution = new Solution();
        solutionList = new SolutionList();

        solution.theAuthor = "vamsi_kolapalli";
        solution.solutionFileName = "solution.txt";
        solution.theGrade = 1;
        solution.reported = true;

        solutionList.add(solution);
        iterator = new SolutionIterator(solutionList);
    }

    @Test
    void testHasNext() {
        assertTrue(iterator.hasNext());
        iterator.next();
        assertFalse(iterator.hasNext());
    }

    @Test
    void testNextString() {
        assertEquals(iterator.next("vamsi_kolapalli").theAuthor, "vamsi_kolapalli");
        assertNull(iterator.next("vamsi_kolapalli"));
    }

    @Test
    void testNext() {
        assertEquals(iterator.next().theAuthor, "vamsi_kolapalli");
        assertNull(iterator.next());
    }

    @Test
    void testRemove() {
        int length = iterator.solutionList.size();
        iterator.remove();
        assertEquals(iterator.solutionList.size(), length - 1);
    }

    @Test
    void testNextNull() {
        solutionList = new SolutionList();
        iterator = new SolutionIterator(solutionList);
        assertNull(iterator.next());
    }

}
