package sql_API;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class sql_API_FAKE {

  static String[][] USERS1 = {
      {"UserID", "first name", "last name", "email", "last login", "account status"},
      {"u1", "John", "Smith", "johnsmith100@gmail.com", "2019-09-26 12:12:12.000", "ACTIVE"},
      {"u100", "Doris", "Moore", "DorisKMoore@dayrep.com", "2019-09-25 09:05:45.000", "ACTIVE"},
      {"u2", "Sally", "Johnson", "sj549395@yahoo.com", "2019-09-25 09:05:45.000", "ACTIVE"},
      {"u34", "David", "Lima", "DavidJLima@jourrapide.com", "2019-09-25 09:05:45.000", "INACTIVE"},
      {"u456", "Janice", "Schoen", "JanicePSchoen@rhyta.com", "2019-09-25 09:05:45.000", "ACTIVE"},
      {"u5496", "Sammie", "White", "SammieMWhite@armyspy.com", "2019-09-25 09:05:45.000", "ACTIVE"},
      {"u6", "John", "Smith", "johnsmith@apple.com", "2019-09-25 09:05:45.000", "ACTIVE"},
      {"u76", "Carl", "Perez", "CarlMPerez@teleworm.us", "2019-09-25 09:05:45.000", "ACTIVE"},
      {"u856", "Katelin", "Hannum", "KathleenDHannum@teleworm.us", "2019-09-25 09:05:45.000",
          "ACTIVE"},
      {"u9545", "Grant", "Justice", "GrantAJustice@armyspy.com", "2019-09-25 09:05:45.000",
          "ACTIVE"}};

  static List<String[]> USERS = new ArrayList<String[]>(Arrays.asList(USERS1));

  static String[][] GROUPS1 = {{"GroupID", "Group Name", "CreatorID"}, {"g001", "Group1", "u34"},
      {"g249543", "Group2", "u34"}, {"g2495432", "Group3", "u34"}};

  static List<String[]> GROUPS = new ArrayList<String[]>(Arrays.asList(GROUPS1));

  static String[][] USERGROUPS1 =
      {{"UserID", "GroupID"}, {"u34", "g001"}, {"u34", "g249543"}, {"u34", "g2495432"},
          {"u1", "g001"}, {"u6", "g001"}, {"u2", "g001"}, {"u100", "g249543"}, {"u456", "g249543"},
          {"u856", "g249543"}, {"u9545", "g2495432"}, {"u5496", "g2495432"}, {"u76", "g2495432"},};

  static List<String[]> USERGROUPS = new ArrayList<String[]>(Arrays.asList(USERGROUPS1));

  static String[][] PROJECTS1 = {
      {"ProjectID", "Project Name", "Project Description", "CreatorID", "start date", "end date",
          "GroupID", "Project Status", "Project Grade"},
      {"p93495", "Project1", "Do Something", "u34", "2019-09-30 09:05:45.000",
          "2019-10-10 09:05:45.000", "g001", "IN PROGRESS", "TBD"},
      {"p34852", "Project1", "Do Something", "u34", "2019-09-30 09:05:45.000",
          "2019-10-10 09:05:45.000", "g249543", "IN PROGRESS", "TBD"},
      {"p234", "Project1", "Do Something", "u34", "2019-09-30 09:05:45.000",
          "2019-10-10 09:05:45.000", "g2495432", "IN PROGRESS", "TBD"},
      {"p238483", "Project2", "Do More Stuff", "u34", "2019-10-20 09:05:45.000",
          "2019-10-30 09:05:45.000", "g249543", "NOT STARTED", "TBD"},
      {"p23848", "Project2", "Do More Stuff", "u34", "2019-10-20 09:05:45.000",
          "2019-10-30 09:05:45.000", "g2495432", "NOT STARTED", "TBD"}};

  static List<String[]> PROJECTS = new ArrayList<String[]>(Arrays.asList(PROJECTS1));

  static String[][] GOALS1 = {
      {"GoalD", "Goal Name", "Goal Description", "ProjectID", "AssignorID", "AssigneeID",
          "start date", "end date", "Goal Status", "Goal Grade"},
      {"s2345", "Goal1", "Do Subgoal", "p93495", "u1", "u2", "2019-09-30 09:05:45.000",
          "2019-10-10 09:05:45.000", "IN PROGRESS", "TBD"},
      {"s12", "Goal2", "Do Another Subgoal", "p93495", "u1", "u1", "2019-09-30 09:05:45.000",
          "2019-10-10 09:05:45.000", "COMPLETED", "A-"},
      {"s24535", "Goal3", "And Another One", "p93495", "u1", "u6", "2019-09-30 09:05:45.000",
          "2019-10-10 09:05:45.000", "IN PROGRESS", "TBD"},
      {"s95843", "Goal4", "And More", "p93495", "u1", "u2", "2019-09-30 09:05:45.000",
          "2019-10-10 09:05:45.000", "NOT STARTED", "TBD"},
      {"s3463", "Goal5", "Second TO Last", "p93495", "", "", "2019-09-30 09:05:45.000",
          "2019-10-10 09:05:45.000", "NOT STARTED", "TBD"},
      {"s59205", "Goal6", "Final Subgoal", "p93495", "u1", "u1", "2019-09-30 09:05:45.000",
          "2019-10-10 09:05:45.000", "IN PROGRESS", "TBD"},
      {"s2003", "Goal1", "Do Subgoal", "p34852", "u100", "u100", "2019-09-30 09:05:45.000",
          "2019-10-10 09:05:45.000", "IN PROGRESS", "TBD"},
      {"s24053", "Goal2", "Do Another Subgoal", "p34852", "u100", "u856", "2019-09-30 09:05:45.000",
          "2019-10-10 09:05:45.000", "COMPLETED", "TBD"},
      {"s73253", "Goal3", "And Another One", "p34852", "u100", "u856", "2019-09-30 09:05:45.000",
          "2019-10-10 09:05:45.000", "IN PROGRESS", "TBD"},
      {"s25253", "Goal4", "And More", "p34852", "u100", "u456", "2019-09-30 09:05:45.000",
          "2019-10-10 09:05:45.000", "IN PROGRESS", "TBD"},
      {"s02850", "Goal5", "Second TO Last", "p34852", "u100", "u856", "2019-09-30 09:05:45.000",
          "2019-10-10 09:05:45.000", "NOT STARTED", "TBD"},
      {"s201", "Goal6", "Final Subgoal", "p34852", "u100", "u100", "2019-09-30 09:05:45.000",
          "2019-10-10 09:05:45.000", "IN PROGRESS", "TBD"},
      {"s24642", "Goal1", "Do Subgoal", "p234", "u9545", "u5496", "2019-09-30 09:05:45.000",
          "2019-10-10 09:05:45.000", "NOT STARTED", "TBD"},
      {"s5039", "Goal2", "Do Another Subgoal", "p234", "u9545", "u5496", "2019-09-30 09:05:45.000",
          "2019-10-10 09:05:45.000", "IN PROGRESS", "TBD"},
      {"s345", "Goal3", "And Another One", "p234", "u9545", "u9545", "2019-09-30 09:05:45.000",
          "2019-10-10 09:05:45.000", "COMPLETED", "B+"},
      {"s3", "Goal4", "And More", "p234", "", "", "2019-09-30 09:05:45.000",
          "2019-10-10 09:05:45.000", "NOT STARTED", "TBD"},
      {"s34646", "Goal5", "Second TO Last", "p234", "u9545", "u9545", "2019-09-30 09:05:45.000",
          "2019-10-10 09:05:45.000", "IN PROGRESS", "TBD"},
      {"s3564", "Goal6", "Final Subgoal", "p234", "u9545", "u76", "2019-09-30 09:05:45.000",
          "2019-10-10 09:05:45.000", "NOT STARTED", "TBD"},};

  static List<String[]> GOALS = new ArrayList<String[]>(Arrays.asList(GOALS1));

  static String[][] COMMENTS1 =
      {{"CommentID", "Comment", "CommentorID", "ProjectID or GoalID", "Posted Time"},
          {"c4235", "This is a comment", "s25253", "2019-10-05 09:05:45.000"}};

  static List<String[]> COMMENTS = new ArrayList<String[]>(Arrays.asList(COMMENTS1));

  // -----USERS--------------------------------------------------------------------------

  public static String usersGetName(String userID) {
    return get(USERS, userID, 1) + " " + get(USERS, userID, 2);
  }

  public static String usersGetLastLogin(String userID) {
    return get(USERS, userID, 4);
  }

  public static String usersGetEmail(String userID) {
    return get(USERS, userID, 3);
  }

  public static String usersGetAccountStatus(String userID) {
    return get(USERS, userID, 5);
  }

  public static void usersCreateUser(String firstname, String lastname, String email,
      String accountStatus) { // NOT TESTED
    String[] newaccount = new String[6];
    int i = 0;
    while (ifIDexists(USERS, "u" + i)) {
      i++;
    }
    newaccount[0] = "u" + i;
    newaccount[1] = firstname;
    newaccount[2] = lastname;
    newaccount[3] = email;
    newaccount[4] = "";
    newaccount[5] = accountStatus;

    USERS.add(newaccount);
  }

  public static void usersEditUser(String userID, String firstname, String lastname, String email,
      String accountStatus) { // NOT TESTED
    String[] existing = {};
    for (String[] userlist : USERS) {
      if (Arrays.deepToString(userlist).contains("[" + userID + ",")) {
        existing = userlist;
        break;
      }
    }
    if (firstname == "") {
      firstname = existing[1];
    }
    if (lastname == "") {
      lastname = existing[2];
    }
    if (email == "") {
      email = existing[3];
    }
    if (accountStatus == "") {
      accountStatus = existing[5];
    }

    String[] edittedaccount = {userID, firstname, lastname, email, "", accountStatus};
    USERS.remove(existing);
    USERS.add(existing);
  }

  public static void usersDeleteUser(String userID) { // NOT TESTED
	  USERS.remove(get(USERS, userID));
  }
  
  public static String generateUserID() {
	  return generateID(USERS, "u");
  }

  // ------------------------------------------------------------------------------------

  // -----GROUPS-------------------------------------------------------------------------

  public static String groupsgetGroupName(String groupID) {
    return get(GROUPS, groupID, 1);
  }

  public static String groupsgetGroupOwner(String groupID) {
    return get(GROUPS, groupID, 2);
  }

  // TODO ?
  public static String[] groupsgetAllGroups() {
    return null;
  }

  public static void groupsdeleteGroup(String groupID) {
    GROUPS.remove(get(GROUPS, groupID));
  }

  public static void groupscreate(String groupID, String groupName, String creatorID) {

    String[] newGroup = new String[3];

    newGroup[0] = groupID;
    newGroup[1] = groupName;
    newGroup[2] = creatorID;

    GROUPS.add(newGroup);
  }

  public static void groupsedit(String groupID, String groupName, String creatorID) {
    String[] groupInfo = get(GROUPS, groupID);
    if (groupName != null) {
      groupInfo[1] = groupName;
    }
    if (creatorID != null) {
      groupInfo[2] = creatorID;
    }
  }
  
  public static String generateGroupID() {
	  return generateID(GROUPS, "g");
  }

  // ------------------------------------------------------------------------------------

  // -----USERGROUPS---------------------------------------------------------------------

  public static void usergroupsCreate(String userID, String groupID) {
    String[] usergroup = {userID, groupID};
    USERGROUPS.add(usergroup);
  }

  public static void usergroupsRemove(String userID, String groupID) {
    String[] usergroup = {userID, groupID};
    USERGROUPS.remove(usergroup);
  }

  // ------------------------------------------------------------------------------------

  // -----PROJECTS-----------------------------------------------------------------------

  public String projectsgetName(String projectID) {
    return get(PROJECTS, projectID, 1);
  }

  public String projectsgetDescription(String projectID) {
    return get(PROJECTS, projectID, 2);
  }

  public String projectsgetCreatorID(String projectID) {
    return get(PROJECTS, projectID, 3);
  }

  public String projectsgetStartDate(String projectID) {
    return get(PROJECTS, projectID, 4);
  }

  public String projectsgetEndDate(String projectID) {
    return get(PROJECTS, projectID, 5);
  }

  public String projectsgetGroupID(String projectID) {
    return get(PROJECTS, projectID, 6);
  }
  
  public String projectsgetRemainingDate(String projectID) {
    return "";
  }

  public String projectsgetStatus(String projectID) {
    return get(PROJECTS, projectID, 7);
  }

  public String projectsgetGrade(String projectID) {
    return get(PROJECTS, projectID, 8);
  }

  public ArrayList<String[]> projectsgetProjectIDs(String ID) {
    ArrayList<String[]> projects = new ArrayList<String[]>();
    for (String[] project : PROJECTS) {
      if (projectsgetCreatorID(project[0]).equals(ID)
          || projectsgetGroupID(project[0]).equals(ID)) {
        projects.add(project);
      }
    }
    return projects;
  }

  // TODO: Implement date
  public void projectscreate(String name, String description, String creatorID, String startdate,
      String enddate, String groupID) {
    String[] newProject = new String[9];
    int i = 0;
    while (sql_API_FAKE.ifIDexists(PROJECTS, "s" + i)) {
      i++;
    }
    newProject[0] = "p" + i;
    newProject[1] = name;
    newProject[2] = description;
    newProject[3] = creatorID;
    newProject[4] = startdate;
    newProject[5] = enddate;
    newProject[6] = groupID;
    newProject[7] = "NOT STARTED";
    newProject[8] = "TBD";

    PROJECTS.add(newProject);
  }

  public void projectsedit(String projectID, String name, String description, String creatorID,
      String startDate, String endDate, String groupID, String status, String grade) {
    String[] projectList = get(PROJECTS, projectID);

    if (!name.isEmpty()) {
      projectList[1] = name;
    }
    if (!description.isEmpty()) {
      projectList[2] = description;
    }
    if (!creatorID.isEmpty()) {
      projectList[3] = creatorID;
    }
    if (!startDate.isEmpty()) {
      projectList[4] = startDate;
    }
    if (!endDate.isEmpty()) {
      projectList[5] = endDate;
    }
    if (!groupID.isEmpty()) {
      projectList[6] = groupID;
    }
    if (!status.isEmpty()) {
      projectList[7] = status;
    }
    if (!grade.isEmpty()) {
      projectList[8] = grade;
    }

    projectsdelete(projectID);
    PROJECTS.add(projectList);
  }

  public void projectsdelete(String projectID) {
    PROJECTS.remove(get(PROJECTS, projectID));
  }
  
  public static String generateProjectID() {
	  return generateID(PROJECTS, "p");
  }

  // ------------------------------------------------------------------------------------

  // -----GOALS--------------------------------------------------------------------------

  public String goalsgetName(String goalID) {
    return get(GOALS, goalID, 1);
  }

  public String goalsgetDescription(String goalID) {
    return get(GOALS, goalID, 2);
  }

  public String goalsgetAssignor(String goalID) {
    return get(GOALS, goalID, 4);
  }

  public String goalsgetAssignee(String goalID) {
    return get(GOALS, goalID, 5);
  }

  public String goalsgetStartDate(String goalID) {
    return get(GOALS, goalID, 6);
  }

  public String goalsgetEndDate(String goalID) {
    return get(GOALS, goalID, 7);
  }

  /*
   * TODO: We should refactor the way datetime is formatted:
   * 
   * old = "yyyy-MM-dd HH-mm-ss.SSS" new = "yyyy-MM-ddTHH-mm-ss.SSSZ"
   * 
   * This is the more common way and it makes parsing easier when using java's date libraries
   */
  public String goalsgetRemainingDate(String goalID) {
    return "";
  }

  public String goalsgetStatus(String goalID) {
    return get(GOALS, goalID, 8);
  }

  public String goalsgetGrade(String goalID) {
    return get(GOALS, goalID, 9);
  }

  public String[] goalsgetGoalID(String goalID) {
    String[] result = { goalsgetAssignee(goalID), get(GOALS, goalID, 3) };
    return result;
  }

  // TODO: Implement date
  public void goalscreate(String name, String description, String projectID, String assignorID,
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

  public void goalsedit(String goalID, String name, String description, String projectID,
      String assignorID, String assigneeID, String endDate, String status, String grade) {
    String[] goalList = get(GOALS, goalID);

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

  public void goalsdelete(String goalID) {
    GOALS.remove(get(GOALS, goalID));
  }
  
  public static String generateGoalID() {
	  return generateID(GOALS, "s");
  }

  // ------------------------------------------------------------------------------------
  // -----COMMENTS-----------------------------------------------------------------------

  public static String commentsgetCommentText(String commentID) {
    return get(COMMENTS, commentID, 1);
  }

  public static String commentsgetCommentor(String commentID) {
    return get(COMMENTS, commentID, 2);
  }

  public static String commentsgetParentID(String commentID) {
    return get(COMMENTS, commentID, 3);
  }

  public static String commentsgetDate(String commentID) {
    return get(COMMENTS, commentID, 4);
  }

  // TODO: Given the parent object ID, get all of the comments. maybe we want to use an arraylist?
  public static String[] commentsgetComments(String parentID) {
    String[] meow = new String[10];
    return meow;
  }

  public static void commentscreate(String commentID, String commentText, String commentor,
      String parentID, String date) {

    String[] newComment = new String[5];

    newComment[0] = commentID;
    newComment[1] = commentText;
    newComment[2] = commentor;
    newComment[3] = parentID;
    newComment[4] = date;

    COMMENTS.add(newComment);
  }

  // doesn't really seem necessary to be able to update the commentor or the thing it is commented
  // on...
  public static void commentsedit(String commentID, String commentText) {
    String[] commentInfo = get(COMMENTS, commentID);

    if (commentText != null) {
      commentInfo[1] = commentText;
    }
  }

  public static void commentsdelete(String commentID) {
    COMMENTS.remove(get(COMMENTS, commentID));
  }
  
  public static String generateCommentID() {
	  return generateID(COMMENTS, "c");
  }



  // ------------------------------------------------------------------------------------

  // -----Generic------------------------------------------------------------------------
  public static boolean ifIDexists(List<String[]> object, String id) {
    for (String[] list : object) {
      if (Arrays.deepToString(list).contains("[" + id + ",")) {
        return true;
      }
    }
    return false;
  }
  
  private static String[] get(List<String[]> list, String id) {
	    for (String[] listRow : list) {
	      if (Arrays.deepToString(listRow).contains("[" + id + ",")) {
	        return listRow;
	      }
	    }
	    throw new NoSuchElementException();
	  }

  // get single element from comment with ID and element #
  private static String get(List<String[]> list, String id, int index) {
    for (String[] listRow : list) {
      if (Arrays.deepToString(listRow).contains("[" + id + ",")) {
        return listRow[index];
      }
    }
    throw new NoSuchElementException();
  }
  
  public static String generateID(List<String[]> list, String idPrefix) {
		int i = 0;
		while (sql_API_FAKE.ifIDexists(list, idPrefix + i)) {
			i++;
		}
		return idPrefix + i;
	}
  
  
  // ------------------------------------------------------------------------------------

  public static void main(String args[]) {

  }

}

