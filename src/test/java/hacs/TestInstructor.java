package hacs;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class InstructorTest {

	@Test
	void testingCreateCourseMenu() {
		Course course = new Course("SER515", 1);
		Instructor instructor = new Instructor();
		assertTrue(instructor.createCourseMenu(course, 1) instanceof LowLevelCourseMenu);
	}

}
