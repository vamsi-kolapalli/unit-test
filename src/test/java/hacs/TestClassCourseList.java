package hacs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClassCourseListTest {
	ClassCourseList classCourseList;

	@BeforeEach
	void start() {
		classCourseList = new ClassCourseList();
	}
	
	@Test
	void testingInitializationFromFile() {
		classCourseList.initializeFromFile("CourseInfo.txt");
		assertEquals(classCourseList.get(0).courseName, "SER515");
		assertEquals(classCourseList.get(1).courseName, "SER502");
		assertEquals(classCourseList.get(2).courseName, "CSE563");
	}

	@Test
	void testingCoursefindingByCourseName() {
		Course course = new Course("SER502", 0);
		assertEquals(classCourseList.findCourseByCourseName("SER502"), null);
		classCourseList.add(course);
		assertEquals(classCourseList.findCourseByCourseName("SER502"), course);
	}

	

}
