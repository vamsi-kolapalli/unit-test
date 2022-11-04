package hacs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hacs.UserInfoItem.USER_TYPE;

class TestFacade {
    Facade facade;

    @BeforeEach
    void start() {
        facade = new Facade();
    }

    @Test
    void testSubmitSolution() {
        Assignment assignment = new Assignment();
        Solution solution = new Solution();
        facade.submitSolution(assignment, solution);
        assertTrue(assignment.theSolutionList.contains(solution));
    }

    @Test
    void testReportSolutions() {
        Assignment assignment = new Assignment();
        assignment.theSolutionList.add(new Solution());
        facade.reportSolutions(assignment);
        assertTrue(assignment.theSolutionList.get(0).reported);
    }

    void testCreateUserType() {
        UserInfoItem user = new UserInfoItem();
        user.strUserName = "MFindler";
        user.userType = USER_TYPE.Instructor;
        facade.createUser(user);
        assertTrue(facade.thePerson instanceof Instructor);
        user.strUserName = "vamsi_kolapalli";
        user.userType = USER_TYPE.Student;
        facade.createUser(user);
        assertFalse(facade.thePerson instanceof Instructor);

    }

    @Test
    void testAttachCourseToUser() {
        facade.thePerson = new Student();
        facade.thePerson.UserName = "bbbb";
        facade.createCourseList();
        facade.attachCourseToUser();
        assertEquals(facade.thePerson.CourseList.get(1).courseName, "CSE563");
    }

    @Test
    void testCreateCourseList() {
        facade.createCourseList();
        assertEquals(facade.theCourseList.size(), 3);
    }
}
