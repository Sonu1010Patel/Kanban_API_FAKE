package sql_API;

package sql_API;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class SQL_API {
	 
	// -----USERS--------------------------------------------------------------------------

	  public static String usersGetName(String userID) {
		String output = runquery("SELECT first_name, last_name FROM USERS WHERE userID = '" + userID + "';");
		if(!output.isEmpty()) {
			return output.replace(", ", "");
		}
		else {
			return "ERROR";
		}
	  }

	  public static String usersGetLastLogin(String userID) {
		  String output = runquery("SELECT last_login FROM USERS WHERE userID = '" + userID + "';");
			if(!output.isEmpty()) {
				return output.replace(", ", "");
			}
			else {
				return "ERROR";
			}
	  }

	  public static String usersGetEmail(String userID) {
		  String output = runquery("SELECT email FROM USERS WHERE userID = '" + userID + "';");
			if(!output.isEmpty()) {
				return output.replace(", ", "");
			}
			else {
				return "ERROR";
			}
	  }

	  public static String usersGetAccountStatus(String userID) {
		  String output = runquery("SELECT account_status FROM USERS WHERE userID = '" + userID + "';");
			if(!output.isEmpty()) {
				return output.replace(", ", "");
			}
			else {
				return "ERROR";
			}
	  }

	  public static String usersCreateUser(String firstname, String lastname, String email, String accountStatus) { 
	    
		  runquery("INSERT INTO USERS VALUES(NEWID(), \'"+firstname+"\', \'"+lastname+"\', \'"+email+"\', NULL, \'"+accountStatus+"\');");
		  
		  String output = runquery("SELECT * FROM USERS WHERE first_name = '" + firstname + "' AND last_name = '" + lastname + "' AND email = '" + email + "' AND account_status = '" + accountStatus + "';");
			if(!output.isEmpty()) {
				return "SUCCESS";
			}
			else {
				return "ERROR";
			}
	  }

	  public static String usersEditUser(String userID, String firstname, String lastname, String email, String accountStatus) {
	     runquery("UPDATE USERS SET first_name = \'"+firstname+"\', last_name = \'"+lastname+"\', email = \'"+email+"\', last_login = NULL, account_status = \'"+accountStatus+"\' WHERE userID = \'"+userID+"\';");
	     String output = runquery("SELECT * FROM USERS WHERE first_name = '" + firstname + "' AND last_name = '" + lastname + "' AND email = '" + email + "' AND account_status = '" + accountStatus + "';");
			if(!output.isEmpty()) {
				return "SUCCESS";
			}
			else {
				return "ERROR";
			}
	  }

	  public static String usersDeleteUser(String userID) { // NOT TESTED
		  runquery("REMOVE * FROM USERS WHERE userID = '" + userID + "';");
		  String output = runquery("SELECT * FROM USERS WHERE userID = '" + userID + "';");
			if(output.isEmpty()) {
				return "SUCCESS";
			}
			else {
				return "ERROR";
			}
	  }
	  
	  public static String getUserID(String email) {
		  String output = runquery("SELECT userID FROM USERS WHERE email = '" + email + "';");
			if(!output.isEmpty()) {
				return output.replace(", ", "");
			}
			else {
				return "ERROR";
			}
	  }
	
	// ------------------------------------------------------------------------------------
	  
	  
	// -----GROUPS-------------------------------------------------------------------------

	  public static String groupsgetGroupName(String groupID) {
	    String output = runquery("SELECT group_name FROM GROUPS WHERE groupID = '" + groupID + "';");
		if(!output.isEmpty()) {
			return output.replace(", ", "");
		}
		else {
			return "ERROR";
		}
	  }

	  public static String groupsgetGroupOwner(String groupID) {
		  String output = runquery("SELECT creatorID FROM GROUPS WHERE groupID = '" + groupID + "';");
			if(!output.isEmpty()) {
				return output.replace(", ", "");
			}
			else {
				return "ERROR";
			}
	  }

	  // TODO ?
	  public static String[] groupsgetAllGroups() {
		  String output = runquery("SELECT * FROM GROUPS;");
			if(!output.isEmpty()) {
				return output.split(", ");
			}
			else {
				return null;
			}
	  }

	  public static String groupsdeleteGroup(String groupID) {
		  runquery("REMOVE * FROM GROUPS WHERE groupID = '" + groupID + "';");
		  String output = runquery("SELECT * FROM GROUPS WHERE groupID = '" + groupID + "';");
			if(output.isEmpty()) {
				return "SUCCESS";
			}
			else {
				return "ERROR";
			}
	  }

	  public static String groupscreate(String groupID, String groupName, String creatorID) {
	    
	    runquery("INSERT INTO GROUPS VALUES(NEWID(), \'"+groupName+"\', \'"+creatorID+"\');");
		  
		String output = runquery("SELECT * FROM GROUPS WHERE group_name = '" + groupName + "' AND creatorID = '" + creatorID + "';");
			if(!output.isEmpty()) {
				return "SUCCESS";
			}
			else {
				return "ERROR";
			}
	  }

	  public static String groupsedit(String groupID, String groupName, String creatorID) {
	    runquery("UPDATE GROUPS SET group_name = \'"+groupName+"\', creatorID = \'"+creatorID+"\' WHERE groupID = \'" + groupID + "';");
	     String output = runquery("SELECT * FROM GROUPS WHERE group_name = \'"+groupName+"\', creatorID = \'"+creatorID+"\';");
			if(!output.isEmpty()) {
				return "SUCCESS";
			}
			else {
				return "ERROR";
			}
	  }
	  
	  //public static String generateGroupID() {
	//	  return generateID(GROUPS, "g");
	  //}

	  // ------------------------------------------------------------------------------------
	  
	  
	// -----USERGROUPS---------------------------------------------------------------------

	  public static String usergroupsCreate(String userID, String groupID) {

	    runquery("INSERT INTO USERGROUPS VALUES(\'"+userID+"\', \'"+groupID+"\');");
		  
		String output = runquery("SELECT * FROM USERGROUPS WHERE userID = '" + userID + "' AND groupID = '" + groupID + "';");
			if(!output.isEmpty()) {
				return "SUCCESS";
			}
			else {
				return "ERROR";
			}
	  }

	  public static String usergroupsRemove(String userID, String groupID) {
	    
	    runquery("REMOVE * FROM USERGROUPS WHERE userID = '" + userID + "' AND groupID = '" + groupID + "';");
		  String output = runquery("SELECT * FROM GROUPS WHERE groupID = '" + groupID + "';");
			if(output.isEmpty()) {
				return "SUCCESS";
			}
			else {
				return "ERROR";
			}
	  }

	  // ------------------------------------------------------------------------------------
	  
	// -----PROJECTS-----------------------------------------------------------------------

	  public static String projectsgetName(String projectID) {
	    String output = runquery("SELECT project_name FROM PROJECTS WHERE projectID = '" + projectID + "';");
		if(!output.isEmpty()) {
			return output.replace(", ", "");
		}
		else {
			return "ERROR";
		}
	  }

	  public static String projectsgetDescription(String projectID) {
	    String output = runquery("SELECT project_description FROM PROJECTS WHERE projectID = '" + projectID + "';");
		if(!output.isEmpty()) {
			return output.replace(", ", "");
		}
		else {
			return "ERROR";
		}
	  }

	  public static String projectsgetCreatorID(String projectID) {
	    String output = runquery("SELECT creatorID FROM PROJECTS WHERE projectID = '" + projectID + "';");
		if(!output.isEmpty()) {
			return output.replace(", ", "");
		}
		else {
			return "ERROR";
		}
	  }

	  public static String projectsgetStartDate(String projectID) {
	    String output = runquery("SELECT project_start_date FROM PROJECTS WHERE projectID = '" + projectID + "';");
		if(!output.isEmpty()) {
			return output.replace(", ", "");
		}
		else {
			return "ERROR";
		}
	  }

	  public static String projectsgetEndDate(String projectID) {
		  String output = runquery("SELECT project_end_date FROM PROJECTS WHERE projectID = '" + projectID + "';");
			if(!output.isEmpty()) {
				return output.replace(", ", "");
			}
			else {
				return "ERROR";
			}
	  }

	  public static String projectsgetGroupID(String projectID) {
	    String output = runquery("SELECT groupID FROM PROJECTS WHERE projectID = '" + projectID + "';");
		if(!output.isEmpty()) {
			return output.replace(", ", "");
		}
		else {
			return "ERROR";
		}
	  }
	  
	  public static String projectsgetRemainingDate(String projectID) {
		  String start = currentTime();
		  String end = projectsgetEndDate(projectID);
		  return remainingDate(start, end);
	  }

	  public static String projectsgetStatus(String projectID) {
		  String output = runquery("SELECT project_status FROM PROJECTS WHERE projectID = '" + projectID + "';");
			if(!output.isEmpty()) {
				return output.replace(", ", "");
			}
			else {
				return "ERROR";
			}
	  }

	  public static String projectsgetGrade(String projectID) {
		  String output = runquery("SELECT project_grade FROM PROJECTS WHERE projectID = '" + projectID + "';");
			if(!output.isEmpty()) {
				return output.replace(", ", "");
			}
			else {
				return "ERROR";
			}
	  }

	  public static ArrayList<String> projectsgetProjectIDs(String ID) {
	    ArrayList<String> projects = new ArrayList<String>();
	    String output = runquery("SELECT projectID FROM PROJECTS WHERE groupID = '" + ID + "' OR creatorID = '" + ID + "';");
		if(!output.isEmpty()) {
			for(String projectID : output.split(", ")) {
				projects.add(projectID);
			}
			return projects;
		}
		else {
			return null;
		}
	  }

	  // TODO: Implement date
	  public static String projectscreate(String name, String description  , String creatorID, String enddate, String groupID) {
	    
	    runquery("INSERT INTO PROJECTS VALUES(NEWID(), \'"+name+"\', \'"+description+"\', \'"+creatorID+"\', NULL, \'"+enddate+"\', \'" + groupID+"\', \'NOT STARTED\', \'NA\');");
		  
		  String output = runquery("SELECT * FROM USERS WHERE project_name = \'" + name + "\' AND project_description = \'" + description + "\' AND creatorID = \'" + creatorID + "\' AND project_start_date = \'" + currentTime() + "\' AND project_end_date = '" + enddate + "' AND groupID = '" + groupID + "' AND project_status = 'NOT STARTED' AND project_grade = 'NA';");
			if(!output.isEmpty()) {
				return "SUCCESS";
			}
			else {
				return "ERROR";
			}
	  }

	  public static String projectsedit(String projectID, String name, String description, String creatorID, String startDate, String endDate, String groupID, String status, String grade) {
		String[] projectList;
		String output = runquery("SELECT * FROM PROJECTS WHERE projectID = '" + projectID + "';");
		if(!output.isEmpty()) {
			projectList = output.split(", ");
		}
		else {
			return "ERROR";
		}

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

	    runquery("UPDATE USERS SET project_name = \'" + projectList[1] + "\' AND project_description = \'" + projectList[2] + "\' AND creatorID = \'" + projectList[3] + "\' AND project_start_date = \'" + projectList[4] + "\' AND project_end_date = \'" + projectList[5] + "\' AND groupID = \'" + projectList[6] + "\' AND project_status = '" + projectList[7] + "' AND project_grade = '" + projectList[8] + "'' WHERE projectID = \'" + projectID + "\';");
	    output = runquery("SELECT * FROM USERS WHERE project_name = \'" + projectList[1] + "\' AND project_description = \'" + projectList[2] + "\' AND creatorID = \'" + projectList[3] + "\' AND project_start_date = \'" + projectList[4] + "\' AND project_end_date = '" + projectList[5] + "' AND groupID = '" + projectList[6] + "' AND project_status = '" + projectList[7] + "' AND project_grade = '" + projectList[8] + "';");
			if(!output.isEmpty()) {
				return "SUCCESS";
			}
			else {
				return "ERROR";
			}
	  }

	  public static String projectsdelete(String projectID) {
		  runquery("REMOVE * FROM PROJECTS WHERE userID = '" + projectID + "';");
		  String output = runquery("SELECT * FROM PROJECTS WHERE projectID = '" + projectID + "';");
			if(output.isEmpty()) {
				return "SUCCESS";
			}
			else {
				return "ERROR";
			}
	  }
	  
	  //public static String generateProjectID() {
		//  return generateID(PROJECTS, "p");
	  //}

	  // ------------------------------------------------------------------------------------
	  
	// -----GOALS--------------------------------------------------------------------------

	  public static String goalsgetName(String goalID) {
	    String output = runquery("SELECT goal_name FROM GOALS WHERE goalID = '" + goalID + "';");
		if(!output.isEmpty()) {
			return output.replace(", ", "");
		}
		else {
			return "ERROR";
		}
	  }

	  public static String goalsgetDescription(String goalID) {
	    String output = runquery("SELECT goal_description FROM GOALS WHERE goalID = '" + goalID + "';");
		if(!output.isEmpty()) {
			return output.replace(", ", "");
		}
		else {
			return "ERROR";
		}
	  }

	  public static String goalsgetAssignor(String goalID) {
		  String output = runquery("SELECT assignorID FROM GOALS WHERE goalID = '" + goalID + "';");
			if(!output.isEmpty()) {
				return output.replace(", ", "");
			}
			else {
				return "ERROR";
			}
	  }

	  public static String goalsgetAssignee(String goalID) {
		  String output = runquery("SELECT assigneeID FROM GOALS WHERE goalID = '" + goalID + "';");
			if(!output.isEmpty()) {
				return output.replace(", ", "");
			}
			else {
				return "ERROR";
			}
	  }

	  public static String goalsgetStartDate(String goalID) {
		  String output = runquery("SELECT goal_start_date FROM GOALS WHERE goalID = '" + goalID + "';");
			if(!output.isEmpty()) {
				return output.replace(", ", "");
			}
			else {
				return "ERROR";
			}
	  }

	  public static String goalsgetEndDate(String goalID) {
		  String output = runquery("SELECT goal_end_date FROM GOALS WHERE goalID = '" + goalID + "';");
			if(!output.isEmpty()) {
				return output.replace(", ", "");
			}
			else {
				return "ERROR";
			}
	  }

	  public static String goalsgetRemainingDate(String goalID) {
		  String start = currentTime();
		  String end = goalsgetEndDate(goalID);
		  return remainingDate(start, end);
	  }

	  public static String goalsgetStatus(String goalID) {
		  String output = runquery("SELECT goal_status FROM GOALS WHERE goalID = '" + goalID + "';");
			if(!output.isEmpty()) {
				return output.replace(", ", "");
			}
			else {
				return "ERROR";
			}
	  }

	  public static String goalsgetGrade(String goalID) {
		  String output = runquery("SELECT goal_grade FROM GOALS WHERE goalID = '" + goalID + "';");
			if(!output.isEmpty()) {
				return output.replace(", ", "");
			}
			else {
				return "ERROR";
			}
	  }

	  //public static String[] goalsgetGoalID(String goalID) {
	    //String[] result = { goalsgetAssignee(goalID), get(GOALS, goalID, 3) };
	    //return result;
	  //}

	  public static String goalscreate(String goalID, String name, String description, String projectID, String assignorID, String assigneeID, String endDate) {

	    runquery("INSERT INTO GOALS VALUES(NEWID(), \'"+name+"\', \'"+description+"\', \'"+projectID+"\', NULL, \'"+ assignorID +"\', \'" + assigneeID+"\', \'" + currentTime() + "\', \'" + endDate + "\', \'NOT STARTED\', \'NA\');");

		  String output = runquery("SELECT * FROM USERS WHERE goal_name = \'" + name + "\' AND goal_description = \'" + description + "\' AND projectID = \'" + projectID + "\' AND assignorID = \'" + assignorID + "\' AND assigneeID = \'" + assigneeID + "\' AND goal_end_date = \'" + endDate + "\' AND goal_status = \'NOT STARTED\' AND goal_grade = \'NA\';");
		  
			if(!output.isEmpty()) {
				return "SUCCESS";
			}
			else {
				return "ERROR";
			}
	  }

	  public static String goalsedit(String goalID, String name, String description, String projectID,
	      String assignorID, String assigneeID, String endDate, String status, String grade) {
		  
		  String[] goalList;
		  
		  String output = runquery("SELECT * FROM PROJECTS WHERE projectID = '" + projectID + "';");
			if(!output.isEmpty()) {
				goalList = output.split(", ");
			}
			else {
				return "ERROR";
			}
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
	    

	    runquery("UPDATE USERS SET goal_name = \'" + goalList[1] + "\' AND goal_description = \'" + goalList[2] + "\' AND projectID = \'" + goalList[3] + "\' AND assignorID = \'" + goalList[4] + "\' AND assigneeID = \'" + goalList[5] + "\' AND goal_start_date = \'" + goalList[6] + "\' AND goal_end_date = \'" + goalList[7] + "\' AND goal_status = \'" + goalList[8] + "\' AND goal_grade = \'" + goalList[9] + "\' WHERE goalID = '" + goalID + "';");
	    output = runquery("SELECT * FROM USERS WHERE goal_name = \'" + name + "\' AND goal_description = \'" + description + "\' AND projectID = \'" + projectID + "\' AND assignorID = \'" + assignorID + "\' AND assigneeID = \'" + assigneeID + "\' AND goal_end_date = \'" + endDate + "\' AND goal_status = \'NOT STARTED\' AND goal_grade = \'NA\';");
			if(!output.isEmpty()) {
				return "SUCCESS";
			}
			else {
				return "ERROR";
			}
	  }

	  public static String goalsdelete(String goalID) {
		  runquery("REMOVE * FROM PROJECTS WHERE userID = '" + goalID + "';");
		  String output = runquery("SELECT * FROM PROJECTS WHERE projectID = '" + goalID + "';");
			if(output.isEmpty()) {
				return "SUCCESS";
			}
			else {
				return "ERROR";
			}
	  }
	  
	  //public static String generateGoalID() {
		//  return generateID(GOALS, "s");
	  //}

	  // ------------------------------------------------------------------------------------
	  
	// -----COMMENTS-----------------------------------------------------------------------

	  public static String commentsgetCommentText(String commentID) {
		  String output = runquery("SELECT comment FROM COMMENTS_PROJECTS UNION COMMENTS_GOALS WHERE commentID = '" + commentID + "';");
			if(!output.isEmpty()) {
				return output.replace(", ", "");
			}
			else {
				return "ERROR";
			}
	  }

	  public static String commentsgetCommentor(String commentID) {
		  String output = runquery("SELECT commentorID FROM COMMENTS_PROJECTS UNION COMMENTS_GOALS WHERE commentID = '" + commentID + "';");
			if(!output.isEmpty()) {
				return output.replace(", ", "");
			}
			else {
				return "ERROR";
			}
	  }

	  public static String commentsgetDate(String commentID) {
		  String output = runquery("SELECT timeposted FROM COMMENTS_PROJECTS UNION COMMENTS_GOALS WHERE commentID = '" + commentID + "';");
			if(!output.isEmpty()) {
				return output.replace(", ", "");
			}
			else {
				return "ERROR";
			}
	  }

	  // TODO: Given the parent object ID, get all of the comments. maybe we want to use an arraylist?
	  public static String commentsgetComments(String subjectID) {
		  String output = runquery("SELECT * FROM COMMENTS_PROJECTS UNION COMMENTS_GOALS WHERE subjectID = '" + subjectID + "';");
			if(!output.isEmpty()) {
				return output.replace(", ", "");
			}
			else {
				return "ERROR";
			}
	  }

	  public static String commentscreate(String commentID, String commentText, String commentor, String parentID, String date) {

	    runquery("INSERT INTO COMMENTS VALUES(NEWID(), \'"+commentText+"\', \'"+commentor+"\', \'"+parentID+"\', NULL, \'"+date+"\');");
		  
		  String output = runquery("SELECT * FROM COMMENTS WHERE comment = '" + commentText + "' AND commentorID = '" + commentor + "' AND subjectID = '" + parentID + "' AND timeposted = '" + date + "';");
			if(!output.isEmpty()) {
				return "SUCCESS";
			}
			else {
				return "ERROR";
			}
	  }

	  // doesn't really seem necessary to be able to update the commentor or the thing it is commented
	  // on...
	  public static String commentsedit(String commentID, String commentText) {
		  runquery("UPDATE COMMENTS SET comment = \'"+commentText+"\' WHERE commentID = \'"+commentID+"\';");
		     String output = runquery("SELECT * FROM COMMENTS WHERE commentID = '" + commentID + "' AND comment = '" + commentText + "';");
				if(!output.isEmpty()) {
					return "SUCCESS";
				}
				else {
					return "ERROR";
				}
	  }

	  public static String commentsdelete(String commentID) {
		  runquery("REMOVE * FROM COMMENTS WHERE userID = '" + commentID + "';");
		  String output = runquery("SELECT * FROM COMMENTS WHERE userID = '" + commentID + "';");
			if(output.isEmpty()) {
				return "SUCCESS";
			}
			else {
				return "ERROR";
			}
	  }
	  
	  //public static String generateCommentID() {
		//  return generateID(COMMENTS, "c");
	  //}

	  // ------------------------------------------------------------------------------------
	  
	  //-----ROSTERS-------------------------------------------------------------------------
	  
	  public static String rostercreate(String rosterID, String name, String teacherID) {
		  runquery("INSERT INTO ROSTERS VALUES(NEWID(), \'"+name+"\', \'"+teacherID+"\');");
		  
		  String output = runquery("SELECT * FROM ROSTERS WHERE roster_name = '" + name + "' AND teacherID = '" + teacherID + "';");
			if(!output.isEmpty()) {
				return "SUCCESS";
			}
			else {
				return "ERROR";
			}
		  
	  }
	  
	  public static String rosteredit(String rosterID, String name, String teacherID) {
		  runquery("UPDATE ROSTERS SET roster_name = \'"+name+"\', teacherID = \'" + teacherID + "\' WHERE rosterID = \'"+rosterID+"\';");
		  String output = runquery("SELECT * FROM ROSTERS WHERE roster_name = '" + name + "' AND teacherID = '" + teacherID + "';");
			if(!output.isEmpty()) {
				return "SUCCESS";
			}
			else {
				return "ERROR";
			}
	  }
	  
	  public static String rostersdelete(String rosterID) {
		  runquery("REMOVE * FROM ROSTERS WHERE rosterID = '" + rosterID + "';");
		  String output = runquery("SELECT * FROM ROSTERS WHERE rosterID = \'" + rosterID + "\';");
			if(!output.isEmpty()) {
				return "SUCCESS";
			}
			else {
				return "ERROR";
			}
	  }
	  
	  
	  //-------------------------------------------------------------------------------------
	  
	  
	  //-----STUDENTROSTERS------------------------------------------------------------------
	  
	  public static String studentrostercreate(String studentID, String rosterID) {
		  runquery("INSERT INTO STUDENTROSTERS VALUES(\'"+studentID+"\', \'"+rosterID+"\');");
		  
		  String output = runquery("SELECT * FROM ROSTERS WHERE studentID = '" + studentID + "' AND rosterID = '" + rosterID + "';");
			if(!output.isEmpty()) {
				return "SUCCESS";
			}
			else {
				return "ERROR";
			}
	  }
	  
	  public static String studentrosterdelete(String studentID, String rosterID) {
		  runquery("REMOVE * FROM USERS WHERE rosterID = '" + rosterID + "';");
		  String output = runquery("SELECT * FROM ROSTERS WHERE rosterID = \'" + rosterID + "\' AND studentID = \'" + studentID + "';");
			if(!output.isEmpty()) {
				return "SUCCESS";
			}
			else {
				return "ERROR";
			}
	  }
	  
	  //FN: return rosterID based on studentID.
	  
	  //-------------------------------------------------------------------------------------

	  
	  // -----Generic------------------------------------------------------------------------

	  public static String currentTime() {
		  DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		  Date date = new Date();
		  return dateFormat.format(date);
	  }
	  
	  public static String remainingDate(String start, String end) {
		  try {
			  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
			  LocalDateTime dateTime1= LocalDateTime.parse(start, formatter);
			  LocalDateTime dateTime2= LocalDateTime.parse(end, formatter);
			  
			  long diffInSeconds = java.time.Duration.between(dateTime1, dateTime2).getSeconds();
			  
			  long days = diffInSeconds / (24 * 3600);
			  
			  diffInSeconds %= (24 * 3600);
			  long hours = diffInSeconds / 3600;
			  
			  diffInSeconds %= 3600;
			  long minutes = diffInSeconds / 60;
			  
			  diffInSeconds %= 60;
			  long seconds = diffInSeconds;
			  
			  return String.format("%d:%d:%d:%d", days, hours, minutes, seconds);
		  } catch (Exception e) {
			  return "";
		  }
	  }
	    
	  public static String runquery (String query) {
		  
		  String output = null;
		  
		  try {
		    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			      
			    String url = "jdbc:sqlserver://192.168.231.130:1433;database=KANBAN_CREW_DB;user=JavaReader;password=JavaReader_100";
			    Connection conn = DriverManager.getConnection(url);
			    Statement stmt = conn.createStatement();
			    ResultSet resultSet;
			      
			    resultSet = stmt.executeQuery(query);
			      
			    ResultSetMetaData rsmd = resultSet.getMetaData();
		
		        int columnsNumber = rsmd.getColumnCount();
		        output = "";
		        while (resultSet.next()) {
		            for (int i = 1; i <= columnsNumber; i++) {
		                if (i > 1) output += ",  ";
		                String columnValue = resultSet.getString(i);
		                output += columnValue;
		            }
		            output += "\n";
		        }

		    } catch (Exception e) {
		    	if(!query.startsWith("SELECT")) {
		    		//Shh! Say Nothing
		    		//e.printStackTrace();
		    	}
		    	else {
		            System.err.println("Got an exception! ");
		            e.printStackTrace();
		    	}
		    }
		  
		  return output;
	  }
	  
}
