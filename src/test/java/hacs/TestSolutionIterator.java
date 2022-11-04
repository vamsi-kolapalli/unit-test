package hacs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolutionIteratorTest {

	SolutionIterator itr;
	SolutionList solList;
	Solution sol;

	@BeforeEach
	void start() {
		sol = new Solution();
		solList = new SolutionList();

		sol.theAuthor = "suhas";
		sol.solutionFileName = "sol.txt";
		sol.theGrade = 1;
		sol.reported = true;

		solList.add(sol);
		itr = new SolutionIterator(solList);
	}

	@Test
	void testingHasNext() {
		assertTrue(itr.hasNext());
		itr.next();
		assertFalse(itr.hasNext());
	}
	
	@Test
	void testingNextString() {
		assertEquals(itr.next("suhas").theAuthor, "suhas");
		assertNull(itr.next("suhas"));
	}
	
	@Test
	void testingNext() {
		assertEquals(itr.next().theAuthor, "suhas");
		assertNull(itr.next());
	}

	@Test
	void testingRemove() {
		int length = itr.solutionList.size();
		itr.remove();
		assertEquals(itr.solutionList.size(), length - 1);
	}

	@Test
	void testingNextNull() {
		solList = new SolutionList();
		itr = new SolutionIterator(solList);
		assertNull(itr.next());
	}

}
