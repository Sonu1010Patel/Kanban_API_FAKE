package Kanban;

import java.util.Iterator;

/**
 * Stage Object holding Goals that represents their progress
 * @author Tommy
 */
public interface Stage {
	
	/**
	 * @return name of the Stage
	 */
	public String name();
	
	/**
	 * @return number of Goal Objects in the Stage
	 */
	public int size();
	
	/**
	 * @param g the Goal to get Data for
	 * @return the Data for the Goal g
	 * @throws IllegalArgumentException if no Data matching g is found
	 */
	public Data get(Goal g);
	
	/**
	 * @return Iterator over Goals in stage
	 */
	public Iterator<Goal> iterator();
	
	/**
	 * Add Goal to Stage
	 * @param goal the Goal to add
	 * @param stage the Goal's new current stage
	 */
	public void add(Goal goal); 
	
	/**
	 * Edit data attributes for Goal. Pass the empty String for attributes you do not wish to change.
	 */
	public void edit(Goal goal, int stage, String name, String description, String projectID, String assignorID,
			String assigneeID, String endDate, String status, String grade);
	
	/**
	 * Remove Goal from Stage
	 * NOTE: This only removes the goal from the stage, it does NOT delete the goal
	 * from the database. See delete(Goal goal).
	 * @param goal the Goal to remove
	 */
	public void remove(Goal goal);
	
	/**
	 * Remove Goal from Stage and delete it from the Database
	 * @param goal the Goal to remove
	 */
	public void delete(Goal goal);
	
	/**
	 * @return String representation of each Goal in the Stage
	 */
	public String toString();
}