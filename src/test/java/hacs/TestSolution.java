package hacs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolutionTest {
	Solution solution;

	@BeforeEach
	void start() {
		solution = new Solution();
		solution.theAuthor = "suhas";
		solution.solutionFileName = "sol.txt";
		solution.theGrade = 1;
		solution.reported = true;
	}

	@Test
	void testingGetGradeString() {
		assertEquals(solution.getGradeString(), "1");
		solution.reported = false;
		assertEquals(solution.getGradeString(), "-1");
	}
	
	@Test
	void testingToString() {
		assertEquals(solution.toString(), "suhas  sol.txt Grade=1  reported");
	}

	@Test
	void getGradeString() {
		assertEquals(solution.getGradeString(), Integer.toString(solution.theGrade));
	}
	
	@Test
	void testingGetGradeInt() {
		assertEquals(solution.getGradeInt(), solution.theGrade);
	}

	@Test
	void isReported() {
		assertEquals(solution.isReported(), solution.reported);
	}


}
