package Kanban;

final class GoalObj implements Goal {
	private final String goalID;
	private final String projectID;
	
	GoalObj(String goalID, String projectID) {
		this.goalID = goalID;
		this.projectID = projectID;
	} 
	
	public String goalID() {
		return goalID;
	}
	
	public String projectID() {
		return projectID; 
	}
	
	public boolean equals(Object thatObject) {
		if (thatObject == this) {
			return true;
		} else if (!(thatObject instanceof Goal)) {
			return false;
		} 
		Goal g = (Goal) thatObject;
		return  g.goalID().equals(goalID) &&
				g.projectID().equals(projectID);
	}
	
	private int hcode;
	public int hashCode() {
		if (hcode == 0) {
			hcode = 17;
			hcode = 37 * hcode + goalID.hashCode();
			hcode = 37 * hcode + projectID.hashCode();
		}
		return hcode;
	}
	
	public String toString() {
		return String.format("%s: %s", goalID, projectID);
	}
}