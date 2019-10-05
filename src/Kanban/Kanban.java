package Kanban;

/**
 * Kanban Object
 * @author Tommy
 */
public interface Kanban {
	
	/**
	 * @return number of Stages in the Kanban
	 */
	public int size();
	
	/**
	 * Add a Goal to the Kanban sheet's first stage
	 * @param g the Goal object to add
	 */
	public void addGoal(Goal goal);
	
	/**
	 * Remove a Goal from the Kanban sheet
	 * @param name the name of the Goal object to be removed
	 */
	public void removeGoal(Goal goal);
	
	/** 
	 * Move a Goal object between stages
	 * 
	 * @param name the name of the Goal object to be moved
	 * @param change the number of Stages to move the Goal by
	 */
	public void moveGoal(Goal goal, int change);
	
	/**
	 * @return a String representation of the Kanban Sheet which includes all Stages and Goals
	 */
	public String toString();
}