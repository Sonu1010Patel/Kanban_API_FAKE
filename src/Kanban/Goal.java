package Kanban;

/**
 * An immutable Goal Object
 * @author Tommy
 */
public interface Goal {
	
	/**
	 * @return Goal identifier
	 */
	public String goalID();
	
	/**
	 * @return project identifier that Goal belongs to
	 */
	public String projectID();
	
	/**
	 * Compare the name of this Object to that Object
	 * @param thatObject the Object to be compared to this Object
	 * @return true if thatObject is the same as thatObject
	 */
	public boolean equals(Object thatObject);
	
	/**
	 * @return a hash value for Goal object using Bloch's algorithm:
	 */
	public int hashCode();
	
	/**
	 * @returns a formatted string of a Goal of the following format:
	 * <code>"name: description"</code>.
	 */
	public String toString();
}
