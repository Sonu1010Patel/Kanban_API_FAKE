package sql_API;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import sql_API.sql_API_FAKE;

/**
 * Class for accessing Goal attributes
 * 
 * Tommy Bart
 * 
 * TODO: Implement dates where needed and maybe clean up code with generics / template pattern?
 * 		 Also: for consistency between database and prototype decide whether to call it a "Goal" or a "Task"
 */
final class Goals {
	private List<String[]> GOALS;

	Goals(List<String[]> GOALS) {
		this.GOALS = GOALS;
	}
	
	private String[] get(String goalID) {
		for (String[] goalList : GOALS) {
			if (Arrays.deepToString(goalList).contains("[" + goalID + ",")) {
				return goalList;
			}
		} 
		throw new NoSuchElementException();
	}
	
	private String get(String goalID, int index) {
		for (String[] goalList : GOALS) {
			if (Arrays.deepToString(goalList).contains("[" + goalID + ",")) {
				return goalList[index];
			}
		}
		throw new NoSuchElementException();
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

	/*
	 * TODO: We should refactor the way datetime is formatted: 
	 * 
	 * 	old = "yyyy-MM-dd HH-mm-ss.SSS" 
	 * 	new = "yyyy-MM-ddTHH-mm-ss.SSSZ" 
	 * 
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

	// TODO: Implement date
	public void create(String name, String description, String projectID, String assignorID, 
			String assigneeID, String endDate) {
		String[] newGoal = new String[10];
		int i = 0;
		while (sql_API_FAKE.ifIDexists(GOALS, "s" + i)) {
			i++;
		}
		newGoal[0] = "s" + i;
		newGoal[1] = name;
		newGoal[2] = description; 
		newGoal[3] = projectID;
		newGoal[4] = assignorID;
		newGoal[5] = assigneeID;
		newGoal[6] = "implement";
		newGoal[7] = endDate;
		newGoal[8] = "NOT STARTED";
		newGoal[9] = "TBD";

		GOALS.add(newGoal);
	}

	public void edit(String goalID, String name, String description, String projectID, String assignorID,
			String assigneeID, String endDate, String status, String grade) {
		String[] goalList = get(goalID);

		if (!name.isEmpty()) {
			goalList[1] = name;
		}
		if (!description.isEmpty()) {
			goalList[2] = description;
		}
		if (!projectID.isEmpty()) {
			goalList[3] = projectID;
		}
		if (!assignorID.isEmpty()) {
			goalList[4] = assignorID;
		}
		if (!assigneeID.isEmpty()) {
			goalList[5] = assigneeID;
		}
		if (!endDate.isEmpty()) {
			goalList[7] = endDate;
		}
		if (!status.isEmpty()) {
			goalList[8] = status;
		}
		if (!grade.isEmpty()) {
			goalList[9] = grade;
		}
	}

	public void delete(String goalID) {
		GOALS.remove(get(goalID));
	}
}
