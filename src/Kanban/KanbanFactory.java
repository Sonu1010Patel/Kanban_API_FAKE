package Kanban;

public class KanbanFactory {
	
	private KanbanFactory() { }
	
	/**
	 * Factory method for creating a new Kanban sheet
	 */
	static public final Kanban newKanban(String name) {
		/* TODO: create with project id... and have a "KanbanSheetSet" class that would be a set of all sheets / projects
		 * which also have data attributes (name, projectID, [users], class... etc) similar to the way StageSet operates
		 */
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
		  
		String goalID = sql_API.Goals.generateGoalID();
		Goal goal = new GoalObj(goalID, projectID);
		sql_API.Goals.create(goalID, name, description, projectID, assignorID, assigneeID, endDate);

		return goal;
	} 
}
