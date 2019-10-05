package Kanban;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

final class KanbanSheet implements Kanban {
	private List<Stage> kanbanData;
	private final String name;
	
	KanbanSheet(String name) {
		kanbanData = new ArrayList<Stage>();
		kanbanData.add(new StageObj("REQUESTED"));
		kanbanData.add(new StageObj("IN PROGRESS"));
		kanbanData.add(new StageObj("DONE"));
		this.name = name;
	}
	 
	public int size() {
		return kanbanData.size();
	} 
	
	public Stage getStage(int index) {
		return kanbanData.get(index);
	}
	
	public void addGoal(Goal goal) {
		if (goal == null) {
			throw new IllegalArgumentException();
		}
		getStage(0).add(goal);
	}
	
	public void removeGoal(Goal goal) {
		Stage stage = stageForGoal(goal); 
		if (stage == null) { 
			throw new IllegalArgumentException();
		}
		stage.remove(goal);
	}
	
	public void moveGoal(Goal goal, int change) {
		Stage stage = stageForGoal(goal);
		if (stage == null) { 
			throw new IllegalArgumentException();
		}
		Data data = stage.get(goal);
		int oldStage = data.currentStage();
		int newStage = oldStage + change;
		if (newStage < 0 || newStage > kanbanData.size()) {
			throw new IllegalArgumentException();
		}
		String status = kanbanData.get(newStage).name();
		stage.edit(goal, newStage, "", "", "", status, "");
		kanbanData.get(oldStage).remove(goal);
		kanbanData.get(newStage).add(goal);
	}
	 
	public Stage stageForGoal(Goal goal) {
		for (Stage stage: kanbanData) {
			Iterator<Goal> i = stage.iterator();
			while (i.hasNext()) {
				if (goal.equals(i.next())){
					return stage;
				}
			}
		}
		return null; 
	}
	
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("============================================================================================================\n");
		buffer.append(name + "\n\n"); 
		for (Stage s: kanbanData) {
			buffer.append(s.toString()+"\n");
		}
		buffer.append("============================================================================================================");
		return buffer.toString();
	}
}
