package mothership;

import java.util.ArrayList;
import java.util.List;
import sql_API.sql_API_FAKE;

public class Mothership extends sql_API_FAKE {
	
	sql_API_FAKE dataBase;
	
	public Mothership(sql_API_FAKE db) {
		this.dataBase = db;
	}
	
	//given a userID, create a list of all the groupmember info
	public List<String[]> getGroupmemberInfo(String userID){
		String groupName = sql_API_FAKE.usergroupsGetGroup(userID);
		List<String> groupMembers = sql_API_FAKE.getGroupMembers(groupName);
		List<String[]> groupInfo = new ArrayList<String[]>();
		for(String ID: groupMembers) {
			String memberInfo[] = new String[4];
			memberInfo[0] = ID;
			memberInfo[1] = sql_API_FAKE.usersGetName(userID); //Name
			memberInfo[2] = sql_API_FAKE.usersGetEmail(userID); //Email
			memberInfo[3] = sql_API_FAKE.usersGetAccountStatus(userID); //Account Status
			memberInfo[4] = sql_API_FAKE.usersGetLastLogin(userID); //Last Login
			groupInfo.add(memberInfo);
		}
		return groupInfo;
	}
	
	//given a goalID, get the detailed goal info
	public String[] getDetailedGoalInfo(String goalID) {
		String[] goalInfo = new String[9];
		goalInfo[0] = goalID;
		goalInfo[1] = sql_API_FAKE.goalsgetName(goalID); //Name
		goalInfo[2] = sql_API_FAKE.goalsgetDescription(goalID); //Desciption
		goalInfo[3] = sql_API_FAKE.goalsgetAssignor(goalID); //Assignor
		goalInfo[4] = sql_API_FAKE.goalsgetAssignee(goalID); //Assignee
		goalInfo[5] = sql_API_FAKE.goalsgetStartDate(goalID); //Start Date
		goalInfo[6] = sql_API_FAKE.goalsgetEndDate(goalID); //End Date
		goalInfo[7] = sql_API_FAKE.goalsgetRemainingDate(goalID); //Remaining Date
		goalInfo[8] = sql_API_FAKE.goalsgetStatus(goalID); //Status
		goalInfo[9] = sql_API_FAKE.goalsgetGrade(goalID); //Grade
		return goalInfo;
	}
	
	//given a goalID, create a goal preview
	public String[] getPreviewGoalInfo(String goalID) {
		String[] goalInfo = new String[4];
		goalInfo[0] = sql_API_FAKE.goalsgetName(goalID); //Name
		String description	= sql_API_FAKE.goalsgetDescription(goalID);
		goalInfo[1] = description.substring(0, 150);  //150 char description -- length can be changed
		goalInfo[2] = sql_API_FAKE.goalsgetAssignee(goalID); //Assignee
		goalInfo[3] = sql_API_FAKE.goalsgetRemainingDate(goalID); //Remaining Date
		goalInfo[4] = sql_API_FAKE.goalsgetStatus(goalID); //Status
		return goalInfo;
	}
	
	//get all of the goal previews of goals assigned to userID
	public List<String[]> getPreviewGoalInfoUser(String userID){
		List<String> userGoals = getGoalsUser(userID);
		List<String[]> answer = new ArrayList<String[]>();
		for(String goalID: userGoals) {
			answer.add(getPreviewGoalInfo(goalID));
		}
		return answer;
	}
	
	//get all of the goal previews of goals under projectID
	public List<String[]> getPreviewGoalInfoProject(String projectID){
		List<String> projectGoals = getGoalsProject(projectID);
		List<String[]> answer = new ArrayList<String[]>();
		for(String goalID: projectGoals) {
			answer.add(getPreviewGoalInfo(goalID));
		}
		return answer;
	}
		
	//given the projectID, get detailed info on the project
	public String[] getDetailedProjectInfo(String projectID) {
		String[] projectInfo = new String[9];
		projectInfo[0] = projectID;
		projectInfo[1] = sql_API_FAKE.projectsgetName(projectID); //Name
		projectInfo[2] = sql_API_FAKE.projectsgetDescription(projectID); //Desciption
		projectInfo[3] = sql_API_FAKE.projectsgetCreatorID(projectID); //Creator
		projectInfo[4] = sql_API_FAKE.projectsgetStartDate(projectID); //Start Date
		projectInfo[5] = sql_API_FAKE.projectsgetEndDate(projectID); //End Date
		projectInfo[6] = sql_API_FAKE.projectsgetRemainingDate(projectID); //Remaining Date
		projectInfo[7] = sql_API_FAKE.projectsgetGroupID(projectID); //Group ID
		projectInfo[8] = sql_API_FAKE.projectsgetStatus(projectID); //Status
		projectInfo[9] = sql_API_FAKE.projectsgetGrade(projectID); //Grade
		return projectInfo;
	}
	
	//given the projectID, get project preview info
	public String[] getPreviewProjectInfo(String projectID) {
		String[] projectInfo = new String[5];
		projectInfo[0] = sql_API_FAKE.projectsgetName(projectID); //Name
		String description	= sql_API_FAKE.projectsgetDescription(projectID);
		projectInfo[1] = description.substring(0, 150);  //150 char description -- length can be changed
		projectInfo[2] = sql_API_FAKE.projectsgetCreatorID(projectID); //Creator
		projectInfo[3] = sql_API_FAKE.projectsgetRemainingDate(projectID); //Remaining Date
		projectInfo[4] = sql_API_FAKE.projectsgetGroupID(projectID); //Group ID
		projectInfo[5] = sql_API_FAKE.projectsgetStatus(projectID); //Status
		return projectInfo;
	}
	
	//TODO
	public List<String> getGoalsDueIn(String userID, String time){
		
		return null;
	}
	
	//TODO
	public List<String> getGoalsByStatus(String userID, String status){
		
		return null;
	}
}
