package sql_API;

import java.util.ArrayList;
import java.util.Arrays; 
import java.util.List;
import java.util.NoSuchElementException;

public class sql_API_FAKE {
	
	static String[][] USERS1 = {
			{"UserID","first name", "last name", "email", "last login", "account status"},
			{"u1","John","Smith","johnsmith100@gmail.com","2019-09-26 12:12:12.000","ACTIVE"},
			{"u100","Doris","Moore","DorisKMoore@dayrep.com","2019-09-25 09:05:45.000","ACTIVE"},
			{"u2","Sally","Johnson","sj549395@yahoo.com","2019-09-25 09:05:45.000","ACTIVE"},
			{"u34","David","Lima","DavidJLima@jourrapide.com","2019-09-25 09:05:45.000","INACTIVE"},
			{"u456","Janice","Schoen","JanicePSchoen@rhyta.com","2019-09-25 09:05:45.000","ACTIVE"},
			{"u5496","Sammie","White","SammieMWhite@armyspy.com","2019-09-25 09:05:45.000","ACTIVE"},
			{"u6","John","Smith","johnsmith@apple.com","2019-09-25 09:05:45.000","ACTIVE"},
			{"u76","Carl","Perez","CarlMPerez@teleworm.us","2019-09-25 09:05:45.000","ACTIVE"},
			{"u856","Katelin","Hannum","KathleenDHannum@teleworm.us","2019-09-25 09:05:45.000","ACTIVE"},
			{"u9545","Grant","Justice","GrantAJustice@armyspy.com","2019-09-25 09:05:45.000","ACTIVE"}
	};
	
	static List<String[]> USERS = new ArrayList<String[]>(Arrays.asList(USERS1));
	
	static String[][] GROUPS1 = {
			{"GroupID","Group Name","CreatorID"},
			{"g001","Group1","u34"},
			{"g249543","Group2","u34"},
			{"g2495432","Group3","u34"}
	};
	
	static List<String[]> GROUPS = new ArrayList<String[]>(Arrays.asList(GROUPS1));
	
	static String[][] USERGROUPS1 = {
			{"UserID","GroupID"},
			{"u34","g001"},
			{"u34","g249543"},
			{"u34","g2495432"},
			{"u1","g001"},
			{"u6","g001"},
			{"u2","g001"},
			{"u100","g249543"},
			{"u456","g249543"},
			{"u856","g249543"},
			{"u9545","g2495432"},
			{"u5496","g2495432"},
			{"u76","g2495432"},
	};
	
	static List<String[]> USERGROUPS = new ArrayList<String[]>(Arrays.asList(USERGROUPS1));
	
	static String[][] PROJECTS1 = {
			{"ProjectID","Project Name","Project Description","CreatorID","start date","end date","GroupID","Project Status","Project Grade"},
			{"p93495","Project1","Do Something","u34","2019-09-30 09:05:45.000","2019-10-10 09:05:45.000","g001","IN PROGRESS","TBD"},
			{"p34852","Project1","Do Something","u34","2019-09-30 09:05:45.000","2019-10-10 09:05:45.000","g249543","IN PROGRESS","TBD"},
			{"p234","Project1","Do Something","u34","2019-09-30 09:05:45.000","2019-10-10 09:05:45.000","g2495432","IN PROGRESS","TBD"},
			{"p238483","Project2","Do More Stuff","u34","2019-10-20 09:05:45.000","2019-10-30 09:05:45.000","g249543","NOT STARTED","TBD"},
			{"p23848","Project2","Do More Stuff","u34","2019-10-20 09:05:45.000","2019-10-30 09:05:45.000","g2495432","NOT STARTED","TBD"}
	};
	
	static List<String[]> PROJECTS = new ArrayList<String[]>(Arrays.asList(PROJECTS1));
	
	static String[][] GOALS1 = {
			{"GoalID","Goal Name","Goal Description","ProjectID","AssignorID","AssigneeID","start date","end date","Goal Status","Goal Grade"},
			{"s2345"	,"Goal1","Do Subgoal"			,"p93495"	,"u1","u2"			,"2019-09-30 09:05:45.000","2019-10-10 09:05:45.000","IN PROGRESS","TBD"},
			{"s12"		,"Goal2","Do Another Subgoal"	,"p93495"	,"u1","u1"			,"2019-09-30 09:05:45.000","2019-10-10 09:05:45.000","COMPLETED","A-"},
			{"s24535"	,"Goal3","And Another One"		,"p93495"	,"u1","u6"			,"2019-09-30 09:05:45.000","2019-10-10 09:05:45.000","IN PROGRESS","TBD"},
			{"s95843"	,"Goal4","And More"				,"p93495"	,"u1","u2"			,"2019-09-30 09:05:45.000","2019-10-10 09:05:45.000","NOT STARTED","TBD"},
			{"s3463"	,"Goal5","Second TO Last"		,"p93495"	,"",""				,"2019-09-30 09:05:45.000","2019-10-10 09:05:45.000","NOT STARTED","TBD"},
			{"s59205"	,"Goal6","Final Subgoal"		,"p93495"	,"u1","u1"			,"2019-09-30 09:05:45.000","2019-10-10 09:05:45.000","IN PROGRESS","TBD"},
			{"s2003"	,"Goal1","Do Subgoal"			,"p34852"	,"u100","u100"		,"2019-09-30 09:05:45.000","2019-10-10 09:05:45.000","IN PROGRESS","TBD"},
			{"s24053"	,"Goal2","Do Another Subgoal"	,"p34852"	,"u100","u856"		,"2019-09-30 09:05:45.000","2019-10-10 09:05:45.000","COMPLETED","TBD"},
			{"s73253"	,"Goal3","And Another One"		,"p34852"	,"u100","u856"		,"2019-09-30 09:05:45.000","2019-10-10 09:05:45.000","IN PROGRESS","TBD"},
			{"s25253"	,"Goal4","And More"				,"p34852"	,"u100","u456"		,"2019-09-30 09:05:45.000","2019-10-10 09:05:45.000","IN PROGRESS","TBD"},
			{"s02850"	,"Goal5","Second TO Last"		,"p34852"	,"u100","u856"		,"2019-09-30 09:05:45.000","2019-10-10 09:05:45.000","NOT STARTED","TBD"},
			{"s201"		,"Goal6","Final Subgoal"		,"p34852"	,"u100","u100"		,"2019-09-30 09:05:45.000","2019-10-10 09:05:45.000","IN PROGRESS","TBD"},
			{"s24642"	,"Goal1","Do Subgoal"			,"p234"		,"u9545","u5496"	,"2019-09-30 09:05:45.000","2019-10-10 09:05:45.000","NOT STARTED","TBD"},
			{"s5039"	,"Goal2","Do Another Subgoal"	,"p234"		,"u9545","u5496"	,"2019-09-30 09:05:45.000","2019-10-10 09:05:45.000","IN PROGRESS","TBD"},
			{"s345"		,"Goal3","And Another One"		,"p234"		,"u9545","u9545"	,"2019-09-30 09:05:45.000","2019-10-10 09:05:45.000","COMPLETED","B+"},
			{"s3"		,"Goal4","And More"				,"p234"		,"",""				,"2019-09-30 09:05:45.000","2019-10-10 09:05:45.000","NOT STARTED","TBD"},
			{"s34646"	,"Goal5","Second TO Last"		,"p234"		,"u9545","u9545"	,"2019-09-30 09:05:45.000","2019-10-10 09:05:45.000","IN PROGRESS","TBD"},
			{"s3564"	,"Goal6","Final Subgoal"		,"p234"		,"u9545","u76"		,"2019-09-30 09:05:45.000","2019-10-10 09:05:45.000","NOT STARTED","TBD"},
	};
	
	static List<String[]> GOALS = new ArrayList<String[]>(Arrays.asList(GOALS1));
	
	static String[][] COMMENTS1 = {
			{"CommentID","Comment","CommentorID","ProjectID or GoalID","Posted Time"},
			{"c4235","This is a comment","s25253","2019-10-05 09:05:45.000"}
	};
	
	static List<String[]> COMMENTS = new ArrayList<String[]>(Arrays.asList(COMMENTS1));
	
	public static List<String> getGroups(String userID) {
		List<String> groupslist = new ArrayList<String>();
		for(String[] group : USERGROUPS) {		
			if(Arrays.deepToString(group).contains("["+userID+",")) {
				System.out.println(Arrays.deepToString(group));
			}
		}
		return groupslist;
	}
	
	//-----USERS--------------------------------------------------------------------------
	
	public static String usersGetName(String userID) {
		for(String[] Userlist : USERS) {		
			if(Arrays.deepToString(Userlist).contains("["+userID+",")) {
				return Userlist[1]+" "+Userlist[2];
			}
		}
		return "";
	}
	
	public static String usersGetLastLogin(String userID) {
		for(String[] Userlist : USERS) {		
			if(Arrays.deepToString(Userlist).contains("["+userID+",")) {
				return Userlist[4];
			}
		}
		return "";
	}
	
	public static String usersGetEmail(String userID) {
		for(String[] Userlist : USERS) {		
			if(Arrays.deepToString(Userlist).contains("["+userID+",")) {
				return Userlist[3];
			}
		} 
		return "";
	}
	
	public static String usersGetAccountStatus(String userID) {
		for(String[] Userlist : USERS) {		
			if(Arrays.deepToString(Userlist).contains("["+userID+",")) {
				return Userlist[5];
			}
		}
		return "";
	}
	
	public static void usersCreateUser(String firstname, String lastname, String email, String accountStatus) {  //NOT TESTED
		String[] newaccount = new String[6];
		int i = 0;
		while(ifIDexists(USERS, "u"+i)) {
			i++;
		}
		newaccount[0]="u"+i;
		newaccount[1]=firstname;
		newaccount[2]=lastname;
		newaccount[3]=email;
		newaccount[4]="";
		newaccount[5]=accountStatus;
		 
		USERS.add(newaccount);
	}
	
	public static void usersEditUser(String userID, String firstname, String lastname, String email, String accountStatus) {  //NOT TESTED
		String[] existing = {};
		for(String[] userlist: USERS) {
			if(Arrays.deepToString(userlist).contains("["+userID+",")) {
				existing = userlist;
				break;
			}
		}
		if(firstname == "") {
			firstname = existing[1];
		}
		if(lastname == "") {
			lastname = existing[2];
		}
		if(email == "") {
			email = existing[3];
		}
		if(accountStatus == "") {
			accountStatus = existing[5];
		}
		
		String[] edittedaccount = {userID, firstname, lastname, email, "", accountStatus};
		USERS.remove(existing);
		USERS.add(existing);
	}
	
	public static void usersDeleteUser(String userID) {  //NOT TESTED
		for(String[] userlist: USERS) {
			if(Arrays.deepToString(userlist).contains("["+userID+",")) {
				USERS.remove(userlist);
			}
		}
	}
	
	//------------------------------------------------------------------------------------
	
	//-----GROUPS-------------------------------------------------------------------------
	
	//CODE HERE
	
	//------------------------------------------------------------------------------------
	
	//-----USERGROUPS---------------------------------------------------------------------
	
	//CODE HERE
	
	//------------------------------------------------------------------------------------
	
	//-----PROJECTS-----------------------------------------------------------------------
	
	//CODE HERE
	
	//------------------------------------------------------------------------------------
	
	//-----GOALS--------------------------------------------------------------------------
	
		// See Goals.java
	
	//------------------------------------------------------------------------------------
	//-----COMMENTS-----------------------------------------------------------------------
	
	//CODE HERE
	
	//------------------------------------------------------------------------------------
	
	//-----Generic------------------------------------------------------------------------
	public static boolean ifIDexists(List<String[]> object, String id) {
		for(String[] list : object) {
			if(Arrays.deepToString(list).contains("["+id+",")) {
				return true;
			}
		}
		return false;
	}
	//------------------------------------------------------------------------------------
	
	public static void main(String args[]) {
		System.out.println("\nUser \n------------------------------");
		//getGroups("u34");
		System.out.println(usersGetName("u34"));
		System.out.println(usersGetLastLogin("u34"));
		System.out.println(usersGetEmail("u34"));
		System.out.println(usersGetAccountStatus("u34"));
		
		// GOALS: Test create, edit, delete
		System.out.println("\nGoals \n------------------------------");
		String id = sql_API.Goals.generateGoalID();
		sql_API.Goals.create(id, "Eat Dinner", "Make some pasta!", "p93495", "u1", "u2", "2019-10-10 09:05:45.000");
		System.out.println(sql_API.Goals.getName(id));
		System.out.println(sql_API.Goals.getDescription(id));
		System.out.println(sql_API.Goals.getAssignor(id));
		System.out.println(sql_API.Goals.getAssignee(id));
		System.out.println(sql_API.Goals.getStartDate(id));
		System.out.println(sql_API.Goals.getEndDate(id));
	    System.out.println(sql_API.Goals.getRemainingDate(id)); // Not implemented yet, see function
		System.out.println(sql_API.Goals.getStatus(id));
		System.out.println(sql_API.Goals.getGrade(id));
		System.out.println(sql_API.Goals.getGoalID(id));
		
		// Edit 
		sql_API.Goals.edit(id, "Eat Lunch", "", "", "", "");
		System.out.println("\n"+sql_API.Goals.getName(id));
		
		// Delete
		sql_API.Goals.delete(id);
		try {
			System.out.println("\n"+sql_API.Goals.getName(id));
		} catch (NoSuchElementException e) {
			System.out.println("No goal by the id " + id);
		}
	}
}
