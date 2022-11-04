package hacs;


import static org.junit.jupiter.api.Assertions.*;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AssignmentTest {
    Assignment assignment;

    @BeforeEach
    void start() {
        assignment = new Assignment();
    }

    @Test
    void testingGetSuggestedSolution() {
        Solution solution = new Solution();
        assignment.suggestedSolution = solution;
        assertEquals(assignment.getSuggestedSolution(), solution);
    }

    @Test
    void testingGetSolutionIterator() {
        assertTrue(assignment.getSolutionIterator() instanceof SolutionIterator);
    }

    @Test
    void testingIsOverDue() {
        Date dueDate = new GregorianCalendar(2022, Calendar.MARCH, 20).getTime();
        assignment.setDueDate(dueDate);
        assertTrue(assignment.isOverDue());
        dueDate = new GregorianCalendar(2023, Calendar.NOVEMBER, 20).getTime();
        assignment.setDueDate(dueDate);
        assertFalse(assignment.isOverDue());
    }

    @Test
    void testingGetDueDateString() {
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
        assignment.dueDate = new Date();
        assertEquals(assignment.getDueDateString(), dateFormat.format(new Date()));
    }

    @Test
    void testingSetDueDate() {
        Date today = new Date();
        assignment.setDueDate(today);
        assertEquals(today, assignment.dueDate);
    }

    @Test
    void testingGetSolution() {
        Solution solution = new Solution();
        solution.theAuthor = "suhas";
        assignment.addSolution(solution);
        assertEquals(solution, assignment.getSolution("suhas"));
    }

    @Test
    void testingSetAssignmentSpec() {
        assignment.setAssignmentSpec("STRING");
        assertEquals("STRING", assignment.assignmentSpec);
    }
}
