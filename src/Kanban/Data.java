package Kanban;

/**
 * Contains all data relating to a Goal object
 * @author Tommy
 */
public interface Data {

	/**
	 * @return Goal object
	 */
	public Goal goal();
	
	/**
	 * @return Goal's current Stage
	 */
	public int currentStage();
	
	/**
	 * @return Goal name
	 */
	public String name();
	
	/**
	 * @return Goal description
	 */
	public String description();
	
	/** 
	 * @return Goal assignor
	 */
	public String assignor();
	
	/**
	 * @return Goal assignee
	 */
	public String assignee();
	
	/**
	 * @return Goal start date
	 */
	public String startDate();
	
	/**
	 * @return Goal end date
	 */
	public String endDate();
	
	/**
	 * @return remaining time until Goal end date
	 */
	public String remainingDate();
	
	/**
	 * @return Goal's current stage
	 */
	public String status();
	
	/**
	 * @return grade for Goal completion
	 */
	public String grade();
	
	/**
	 * @return hcode for Goal object using Bloch's algorithm
	 */
	public int hashCode();
	
	/**
	 * @return String representation of all Goal attributes
	 */
	public String toString();

}
