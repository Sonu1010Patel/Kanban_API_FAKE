package main;

import Kanban.KanbanFactory;
import Kanban.Kanban;
import Kanban.Goal;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MainTest {

	@Test
	void kanTest() {
		//Kanban/KanbanSheet
		Kanban kanban = KanbanFactory.newKanban("Project Test");
		
		Goal goal1 = KanbanFactory.newGoal("Kanban Prototype", "Create a working prototype for class", "p93495", "u1", "u2", "2019-10-10 09:05:45.000");
		Goal goal2 = KanbanFactory.newGoal("Database", "Create a database for the capstone project", "p93495", "u1", "u2", "2019-10-10 09:05:45.000");
		Goal goal3 = KanbanFactory.newGoal("Weekly log", "Turn in weekly log this monday", "p93495", "u1", "u2", "2019-10-10 09:05:45.000");
		Goal goal4 = KanbanFactory.newGoal("Eat lunch", "Find something to eat for lunch", "p93495", "u1", "u2", "2019-10-10 09:05:45.000");
		Goal goal5 = KanbanFactory.newGoal("Test Things", "Test out the new code", "p10101", "u1", "u2", "2019-10-12 09:05:50:000");
		Goal goal6 = KanbanFactory.newGoal("      Test if you trimmed this     ", " Well did you? ", "p54321", "u1", "u2", "2019-10-10 09:05:45.000");
		Goal goal7 = KanbanFactory.newGoal("Group Meeting", "All of us meet together to discuss project", "p93495", "u1", "u2", "2018-10-10 10:19:05.000");
		
		kanban.addGoal(goal1);
		kanban.addGoal(goal2);
		kanban.addGoal(goal3);
		kanban.addGoal(goal4);
		kanban.addGoal(goal6);
		kanban.addGoal(goal7);
		
		
		//Working as intended
		assertEquals(3,kanban.size());

		assertEquals("s0",goal1.goalID());
		assertEquals("s1",goal2.goalID());
		
		assertEquals("p93495", goal1.projectID());
		assertEquals("p10101", goal5.projectID());
		
		assertEquals("s0: p93495", goal1.toString());
		assertEquals("s5: p10101", goal5.toString());
		
		kanban.moveGoal(goal2, 1);
		kanban.moveGoal(goal6, 2);
		kanban.moveGoal(goal7, 2);
		System.out.print(kanban.toString());
		kanban.moveGoal(goal7, 1);
		kanban.removeGoal(goal1);
		System.out.print(kanban.toString());
		
		//Error testing
		Assertions.assertThrows(IllegalArgumentException.class, () -> {kanban.addGoal(null);});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {kanban.removeGoal(goal5);});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {kanban.moveGoal(goal2,4);});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {kanban.moveGoal(goal2,-1);});
		
	}

}

/**
 * Personal Notes
 * Will need to test calendar and times later. Entering an invalid or past date/time should throw an error.
 * We have a removeGoal and deleteGoal with the same code. Specify which one is for database
 * Detect if user/project is not valid?
 * 
 */