package sql_API;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import sql_API.sql_API_FAKE;
import sql_API.Goals;

class APITest {

	
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

		  Groups grTest = new Groups(GROUPS);

		  
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
		  
		  String[][] COMMENTS1 =
		      {{"CommentID", "Comment", "CommentorID", "ProjectID or GoalID", "Posted Time"},
		          {"c4235", "This is a comment", "s25253", "p34852", "2019-10-05 09:05:45.000"}};

		  List<String[]> COMMENTS = new ArrayList<String[]>(Arrays.asList(COMMENTS1));
		  
		  Comments cTest = new Comments(COMMENTS);
		  
		  String[][] GOALS1 = {
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

		   List<String[]> GOALS = new ArrayList<String[]>(Arrays.asList(GOALS1));
		   
		   Goals gTest = new Goals(GOALS);


	@Test
	void testComments() {
		Assertions.assertThrows(NoSuchElementException.class, () -> {cTest.getCommentor("c910");});
		
		assertEquals("This is a comment",cTest.getCommentText("c4235"));
		assertEquals("s25253",cTest.getCommentor("c4235"));
		assertEquals("p34852",cTest.getParentID("c4235"));
		assertEquals("2019-10-05 09:05:45.000",cTest.getDate("c4235"));

		cTest.create("c1000", "This is a test", "s1234", "p10101", "2019-10-10 09:05:45.000");
		assertEquals("This is a test", cTest.getCommentText("c1000"));
		assertEquals("s1234",cTest.getCommentor("c1000"));
		assertEquals("p10101",cTest.getParentID("c1000"));
		assertEquals("2019-10-10 09:05:45.000",cTest.getDate("c1000"));
		
		cTest.create("c1001", "This is also a test", "s2222", "p01010", "2019-10-11 09:05:45.000");
		cTest.edit("c1001", "I'm done testing", "2019-10-11 09:05:45.000");
		assertEquals("I'm done testing", cTest.getCommentText("c1001"));
		
		cTest.delete("c1001");
		Assertions.assertThrows(NoSuchElementException.class, () -> {cTest.getCommentor("c1001");});
		
//		Not finished String[] meow = new String[10];
//		assertArrayEquals(meow,cTest.getComments("s25253"));
	}
	
	@Test
	void testGoals() {
		//"s2345"
		//GetName, GetDescription assignor, assignee, start date, end date, getstatus, get grade
		//get goalid, create, edit, delete
		//generate goalID
		// {"s2345", "Goal1", "Do Subgoal", "p93495", "u1", "u2", "2019-09-30 09:05:45.000",
       // "2019-10-10 09:05:45.000", "IN PROGRESS", "TBD"}
		Assertions.assertThrows(NoSuchElementException.class, () -> {gTest.getName("s1000");});
		
		 assertEquals("Goal1",gTest.getName("s2345"));
		 assertEquals("Do Subgoal",gTest.getDescription("s2345"));
		 assertEquals("u1",gTest.getAssignor("s2345"));
		 assertEquals("u2",gTest.getAssignee("s2345"));
		 assertEquals("2019-09-30 09:05:45.000",gTest.getStartDate("s2345"));
		 assertEquals("2019-10-10 09:05:45.000",gTest.getEndDate("s2345"));
		 assertEquals("IN PROGRESS",gTest.getStatus("s2345"));
		 assertEquals("TBD",gTest.getGrade("s2345"));
		 
		 assertEquals("u2 / p93495",gTest.getGoalID("s2345"));
		 
		 //Test if create works as intended
		 gTest.create("s90", "Goal100", "Test if it works", "p101", "u10", "u100", "2020-02-20 09:05:45.000");
		 assertEquals("Goal100",gTest.getName("s90"));
		 assertEquals("Test if it works",gTest.getDescription("s90"));
		 assertEquals("u10",gTest.getAssignor("s90"));
		 assertEquals("u100",gTest.getAssignee("s90"));
		//Not implemented yet assertEquals("2019-09-30 09:05:45.000",gTest.getStartDate("s90"));
		 assertEquals("2020-02-20 09:05:45.000",gTest.getEndDate("s90"));
		 assertEquals("NOT STARTED",gTest.getStatus("s90"));
		 assertEquals("TBD",gTest.getGrade("s90"));
		 
		 gTest.edit("s90", "Goal101", "", "", "", "");
		 gTest.edit("s90", "", "", "", "IN PROGRESS", "");
		 assertEquals("Goal101",gTest.getName("s90"));
		 assertEquals("Test if it works",gTest.getDescription("s90"));
		 assertEquals("IN PROGRESS",gTest.getStatus("s90"));
		 
		 gTest.delete("s90");
		 Assertions.assertThrows(NoSuchElementException.class, () -> {gTest.getName("s90");});
		 //Not finished: getremainingdate
	}
	
	@Test
	void testGroups() {
		
		Assertions.assertThrows(NoSuchElementException.class, () -> {grTest.getGroupName("g101");});
		//Getgroupname group owner, create, edit, delete
		assertEquals("Group1",grTest.getGroupName("g001"));
		assertEquals("u34",grTest.getGroupOwner("g001"));
		assertEquals("Group2",grTest.getGroupName("g249543"));
		assertEquals("u34",grTest.getGroupOwner("g249543"));
		
		grTest.create("g101", "TestGroup", "u100");
		assertEquals("TestGroup",grTest.getGroupName("g101"));
		assertEquals("u100",grTest.getGroupOwner("g101"));
		
		grTest.edit("g101", "GroupTest", "");
		assertEquals("GroupTest",grTest.getGroupName("g101"));
		// DOESN'T WORK. in edit, should be is empty. assertEquals("u100",grTest.getGroupOwner("g101"));
		
		grTest.deleteGroup("g101");
		Assertions.assertThrows(NoSuchElementException.class, () -> {grTest.getGroupName("g101");});
		//Not finished: getallgroups
	}

}
/**
 * Add to Goals.java?

Goals(List<String[]> GOALS) {
	this.GOALS = GOALS;

Comment Example in API_FAKE does not match parameters of comment, missing Parent/Project ID, that's just for me though

Should things need to be trimmed? like goal, comment, ect?

Implement start date for created goals

Parameters for goals. Only accept NOT STARTED, IN PROGRESS, ect.
Accept only valid/existing users,projects, ect.

Group edit should have isEmpty if only changing one thing
 */

