package main;

import Kanban.KanbanFactory;
import Kanban.Kanban;
import Kanban.Goal;

public class Main {
	public static void main(String[] args) {
		
		Kanban kanban = KanbanFactory.newKanban("Project #1");
		
		Goal goal1 = KanbanFactory.newGoal("Kanban Prototype", "Create a working prototype for class", "p93495", "u1", "u2", "2019-10-10 09:05:45.000");
		Goal goal2 = KanbanFactory.newGoal("Database", "Create a database for the capstone project", "p93495", "u1", "u2", "2019-10-10 09:05:45.000");
		Goal goal3 = KanbanFactory.newGoal("Weekly log", "Turn in weekly log this monday", "p93495", "u1", "u2", "2019-10-10 09:05:45.000");
		Goal goal4 = KanbanFactory.newGoal("Eat lunch", "Find something to eat for lunch", "p93495", "u1", "u2", "2019-10-10 09:05:45.000");
		
		
		kanban.addGoal(goal1);
		kanban.addGoal(goal2);
		kanban.addGoal(goal3);
		kanban.addGoal(goal4);
		 
		kanban.moveGoal(goal1, 1); 
		kanban.moveGoal(goal2, 1);
		kanban.moveGoal(goal4, 2);
		
		//kanban.removeGoal(goal2);
		
		System.out.print(kanban.toString());
	}
}