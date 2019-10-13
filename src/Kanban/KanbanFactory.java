package Kanban;

import sql_API.sql_API_FAKE;

public class KanbanFactory {
	
	private KanbanFactory() { }
	
	/**
	 * Factory method for creating a new Kanban sheet
	 */
	static public final Kanban newKanban(String name) {
		return new KanbanSheet(name);
	}
	
	/**
	 * Factory method for creating new task
	 * TODO: Develop rules for title/description length
	 */
	static public Goal newGoal(String name, String description, String projectID, String assignorID, String assigneeID, String endDate) {
		if (name == null || description == null) {
			throw new IllegalArgumentException();
		}
		name = name.trim();
		description = description.trim();
		
		if (name.isEmpty() || description.isEmpty() || name.length() > 32 || description.length() > 256) {
			throw new IllegalArgumentException();
		}
		
		
		
		String goalID = sql_API_FAKE.generateGoalID();
		Goal goal = new GoalObj(goalID, projectID);
		sql_API_FAKE.goalscreate(goalID, name, description, projectID, assignorID, assigneeID, endDate);
		
		return goal;
	}
}
