package Kanban;

import java.util.Map;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import sql_API.sql_API_FAKE;

final class StageObj implements Stage {
	private Map<Goal, Data> stageData;
	private final String name;
	
	StageObj(String name) {
		this.name = name;
		stageData = new HashMap<Goal, Data>();
	}
	
	public String name() {
		return name;
	} 
	
	public int size() {
		if (stageData != null) {
			return stageData.size();
		} else {
			throw new IllegalArgumentException();
		}
	}
	
	public Data get(Goal goal) {
		try {
			return stageData.get(goal);
		} catch (Exception e) {
			throw new IllegalArgumentException();
		}
	}
	
	public Iterator<Goal> iterator() {
		return Collections.unmodifiableCollection(stageData.keySet()).iterator();
	} 
	  
	public void add(Goal goal) {
		DataObj data = (DataObj) stageData.get(goal);
		if (data == null) {
			stageData.put(goal, new DataObj(goal, 0));
		} else {
			stageData.put(goal, data);
		} 
	}
	
	public void edit(Goal goal, int stage, String name, String description, String projectID, String assignorID,
			String assigneeID, String endDate, String status, String grade) {
		DataObj data = (DataObj) stageData.get(goal);
		if (data == null) {
			throw new IllegalArgumentException();
		}
		sql_API_FAKE.goalsedit(goal.goalID(), name, description, projectID, assignorID, assigneeID, endDate, status,
				grade);
		stageData.put(goal, new DataObj(goal, stage));
	}

	public void remove(Goal goal) {
		try {
			stageData.remove(goal);
		} catch (Exception e) {
			throw new IllegalArgumentException();
		}
	}
	
	public void delete(Goal goal) {
		try {
			// Try to remove goal, it is possible that it has already been removed but not deleted.
			stageData.remove(goal);
		} catch (Exception e) { }
		try {
			sql_API_FAKE.goalsdelete(goal.goalID());
		} catch (Exception e) {
			throw new IllegalArgumentException();
		}
	}
	
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(name+"\n"); 
		Iterator<Data> i = stageData.values().iterator();
		while(i.hasNext()) {
			buffer.append(i.next() + "\n");
		}
		return buffer.toString();
	}
	
	private static final class DataObj implements Data {
		Goal goal;
		int currentStage;
		String name, description, assignor, assignee, startDate, endDate, remainingDate, status, grade;
		
		DataObj(Goal goal, int currentStage) {
			this.goal = goal;
			this.currentStage = currentStage;
			name 		  = sql_API_FAKE.goalsgetName(goal.goalID());
			description   = sql_API_FAKE.goalsgetDescription(goal.goalID());
			assignor 	  = sql_API_FAKE.goalsgetAssignor(goal.goalID());
			assignee 	  = sql_API_FAKE.goalsgetAssignee(goal.goalID());
			startDate 	  = sql_API_FAKE.goalsgetStartDate(goal.goalID());
			endDate 	  = sql_API_FAKE.goalsgetEndDate(goal.goalID());
			remainingDate = sql_API_FAKE.goalsgetRemainingDate(goal.goalID());
			status 		  = sql_API_FAKE.goalsgetStatus(goal.goalID());
			grade 		  = sql_API_FAKE.goalsgetGrade(goal.goalID());
		}
		
		public Goal goal() {
			return goal;
		}
		
		public int currentStage() {
			return currentStage;
		}
		
		public String name() {
			return name;
		}
		
		public String description() {
			return description;
		}
		
		public String assignor() {
			return assignor;
		}
		
		public String assignee() {
			return assignee;
		}
		
		public String startDate() {
			return startDate;
		}
		
		public String endDate() {
			return endDate;
		}
		
		public String remainingDate() {
			return remainingDate;
		}
		
		public String status() {
			return status;
		}
		
		public String grade() {
			return grade;
		}
		
		public int hashCode() {
			return goal.hashCode();
		}
		
		public String toString() {
			return String.format("%s: %s [%s, %s, %s, %s, %s, %s, %s]", name, description, assignor, assignee,
					startDate, endDate, remainingDate, status, grade);
		}
	}
}