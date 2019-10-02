package sql_API;

import java.util.Arrays;
import java.util.List;

/**
 * Class for accessing Goal attributes
 * 
 * Tommy Bart
 * 
 */
final class Goals {
	private List<String[]> GOALS;
	
	Goals(List<String[]> GOALS) {
		this.GOALS = GOALS;
	}
	
	private String get(String goalID, int index) {
		for(String[] goalList : GOALS) {		
			if(Arrays.deepToString(goalList).contains("["+goalID+",")) {
				return goalList[index];
			}
		}
		return "";
	} 
	
	public String getName(String goalID) {
		return get(goalID, 1);
	}
	
	public String getDescription(String goalID) {
		return get(goalID, 2);
	}
	
	public String getAssignor(String goalID) {
		return get(goalID, 4);
	}
	
	public String getAssignee(String goalID) {
		return get(goalID, 5);
	}
	
	public String getStartDate(String goalID) {
		return get(goalID, 6);
	}
	
	public String getEndDate(String goalID) {
		return get(goalID, 7);
	}
	
	/* TODO: We should refactor the way datetime is formatted:
	 * 	 old = "yyyy-MM-dd HH-mm-ss.SSS"
	 *	 new = "yyyy-MM-ddTHH-mm-ss.SSSZ"
	 * This is the more common way and it makes parsing easier when using java's date libraries
	 */
	public String getRemainingDate(String goalID) {
		return ""; 
	}
	
	public String getStatus(String goalID) {
		return get(goalID, 8);
	}
	
	public String getGrade(String goalID) {
		return get(goalID, 9);
	}
	
	public String getGoalID(String goalID) {
		return getAssignee(goalID) + " / " + get(goalID, 3);
	}
	
	public void create(String goalID) {
		
	}
	
	public void edit(String goalID) {
			
	}
	
	public void delete(String goalID) {
		
	}
}
