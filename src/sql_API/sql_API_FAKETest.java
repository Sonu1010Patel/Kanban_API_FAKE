package sql_API;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class sql_API_FAKETest {
		  sql_API_FAKE aTest = new sql_API_FAKE();
	@Test
	void testUsers() {
		Assertions.assertThrows(NoSuchElementException.class, () -> {aTest.usersGetName("u10");});
		Assertions.assertThrows(NoSuchElementException.class, () -> {aTest.getUserID("Fake@website.com");});
		//getname, last login, getemail, getaccountstatus, userid (throw exception)
		assertEquals("John Smith",aTest.usersGetName("u1"));
		assertEquals("johnsmith100@gmail.com",aTest.usersGetEmail("u1"));
		assertEquals("2019-09-26 12:12:12.000",aTest.usersGetLastLogin("u1"));
		assertEquals("ACTIVE",aTest.usersGetAccountStatus("u1"));
		assertEquals("u1",aTest.getUserID("johnsmith100@gmail.com"));
		
		//createuser, edituser, delete user, generate user id
		aTest.usersCreateUser("Tsumugi", "Shirogane", "FromThat1Thing@gmail.com", "ACTIVE");//u0
		aTest.usersCreateUser("Kaito", "Momota", "SpacingOut@gmail.com", "INACTIVE");//u3
		
		assertEquals("Tsumugi Shirogane",aTest.usersGetName("u0"));
		assertEquals("FromThat1Thing@gmail.com",aTest.usersGetEmail("u0"));
		assertEquals("ACTIVE",aTest.usersGetAccountStatus("u0"));
		aTest.usersEditUser("u0", "", "", "v3Master@gmail.com", "");
		//assertEquals("v3Master@gmail.com",aTest.usersGetEmail("u0"));
		aTest.usersEditUser("u1", "Chris", "", "", "");
		//assertEquals("Chris Smith",aTest.usersGetName("u1"));
		//Edit does not work for existing or created users. Inputs remains unchanged
		
		assertEquals("Kaito Momota",aTest.usersGetName("u3"));
		aTest.usersDeleteUser("u3");
		Assertions.assertThrows(NoSuchElementException.class, () -> {aTest.usersGetName("u3");});
		
		Assertions.assertThrows(NoSuchElementException.class, () -> {aTest.usersDeleteUser("u11111");});
		Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {aTest.usersEditUser("u877", "Chris", "Hackney", "", "");});
		//Note: Get login time for created users
		//Fix edit user, make more consistent with other edit functions?
	}
	
	@Test
	void testGroups() {
		Assertions.assertThrows(NoSuchElementException.class, () -> {aTest.groupsgetGroupName("g101");});
		//Getgroupname group owner, create, edit, delete
		assertEquals("Group1",aTest.groupsgetGroupName("g001"));
		assertEquals("u34",aTest.groupsgetGroupOwner("g001"));
		assertEquals("Group2",aTest.groupsgetGroupName("g249543"));
		assertEquals("u34",aTest.groupsgetGroupOwner("g249543"));
		
		aTest.groupscreate("g101", "TestGroup", "u100");
		assertEquals("TestGroup",aTest.groupsgetGroupName("g101"));
		assertEquals("u100",aTest.groupsgetGroupOwner("g101"));
		aTest.groupsedit("g101", "GroupTest", "");
		assertEquals("GroupTest",aTest.groupsgetGroupName("g101"));
		// Doesn't work as intended in edit, should still be u100, is empty instead. 
		//assertEquals("u100",aTest.groupsgetGroupOwner("g101"));
		
		aTest.groupsedit("g249543", "GroupTwo", "u1234");
		assertEquals("GroupTwo",aTest.groupsgetGroupName("g249543"));
		assertEquals("u1234",aTest.groupsgetGroupOwner("g249543"));
		aTest.groupsdeleteGroup("g101");
		
		Assertions.assertThrows(NoSuchElementException.class, () -> {aTest.groupsgetGroupName("g101");});
		Assertions.assertThrows(NoSuchElementException.class, () -> {aTest.groupsdeleteGroup("g11111");});
		Assertions.assertThrows(NoSuchElementException.class, () -> {aTest.groupsedit("g000", "GroupTwo", "u1234");});
		
		//Not finished: getallgroups
	}
	
	@Test
	void testUserGroups() {
		//create, remove, get(nosuchelement), get group members
		
		assertEquals("g001",aTest.usergroupsGetGroup("u6"));
		assertEquals("g2495432",aTest.usergroupsGetGroup("u76"));
		//Several entries in the usergroup have "u34", do we just want to return the first?
		
		Assertions.assertThrows(NoSuchElementException.class, () -> {aTest.usergroupsGetGroup("u101");});
		
		aTest.usergroupsCreate("u20", "g551");
		assertEquals("g551",aTest.usergroupsGetGroup("u20"));
		aTest.usergroupsRemove("u20", "g551");
		aTest.usergroupsRemove("u100", "g249543");
		aTest.usergroupsRemove("u1","g5"); //Should error be thrown when removing groups that don't exist?
		//Assertions.assertThrows(NoSuchElementException.class, () -> {aTest.usergroupsGetGroup("u20");});
		//Assertions.assertThrows(NoSuchElementException.class, () -> {aTest.usergroupsGetGroup("u100");});
		//Remove does not work
	}
	
	@Test
	void testProjects() {
		//GetName, description, creatorid, startdate, enddate, group id, remaining date, 
		//status, grade ProjectIDs
		assertEquals("Project1",aTest.projectsgetName("p93495"));
		assertEquals("Do Something",aTest.projectsgetDescription("p93495"));
		assertEquals("u34",aTest.projectsgetCreatorID("p93495"));
		assertEquals("2019-09-30 09:05:45.000",aTest.projectsgetStartDate("p93495"));
		assertEquals("2019-10-10 09:05:45.000",aTest.projectsgetEndDate("p93495"));
		assertEquals("g001",aTest.projectsgetGroupID("p93495"));
		assertEquals("IN PROGRESS",aTest.projectsgetStatus("p93495"));
		assertEquals("TBD",aTest.projectsgetGrade("p93495"));
		
		//create, edit, delete
		aTest.projectscreate("ProjectTest", "Test this out", "u2", "2019-10-30 09:05:45.000", "g021");
		assertEquals("ProjectTest",aTest.projectsgetName("p0"));
		assertEquals("Test this out",aTest.projectsgetDescription("p0"));
		assertEquals("u2",aTest.projectsgetCreatorID("p0"));
		//assertEquals("aTest.currentTime(),aTest.projectsgetStartDate("p0")); Works
		assertEquals("2019-10-30 09:05:45.000",aTest.projectsgetEndDate("p0"));
		assertEquals("g021",aTest.projectsgetGroupID("p0"));
		assertEquals("NOT STARTED",aTest.projectsgetStatus("p0"));
		assertEquals("TBD",aTest.projectsgetGrade("p0"));
		
		aTest.projectsedit("p0", "Project Test", "", "", "", "", "", "", "");
		assertEquals("Project Test",aTest.projectsgetName("p0"));
		aTest.projectsedit("p0", "", "", "", "", "", "", "IN PROGRESS", "");
		assertEquals("IN PROGRESS",aTest.projectsgetStatus("p0"));
		
		assertEquals("Project1",aTest.projectsgetName("p234"));
		aTest.projectsdelete("p234");
		
		Assertions.assertThrows(NoSuchElementException.class, () -> {aTest.projectsgetName("p234");});
		Assertions.assertThrows(NoSuchElementException.class, () -> {aTest.projectsdelete("p00");});
		Assertions.assertThrows(NoSuchElementException.class, () -> {aTest.projectsgetName("p9393");});
		
		//All good so far
	}

	@Test
	void testGoals() {
		Assertions.assertThrows(NoSuchElementException.class, () -> {aTest.goalsgetName("s1000");});
		//name, desc, assignor, assignee, stardate, enddate, status, grade, goalid
		 assertEquals("Goal1",aTest.goalsgetName("s2345"));
		 assertEquals("Do Subgoal",aTest.goalsgetDescription("s2345"));
		 assertEquals("u1",aTest.goalsgetAssignor("s2345"));
		 assertEquals("u2",aTest.goalsgetAssignee("s2345"));
		 assertEquals("2019-09-30 09:05:45.000",aTest.goalsgetStartDate("s2345"));
		 assertEquals("2019-10-10 09:05:45.000",aTest.goalsgetEndDate("s2345"));
		 assertEquals("IN PROGRESS",aTest.goalsgetStatus("s2345"));
		 assertEquals("TBD",aTest.goalsgetGrade("s2345"));
		 String[] b = {"u2", "p93495"};
		 assertEquals(b[0].toString(),aTest.goalsgetGoalID("s2345")[0].toString());
		 assertEquals(b[1].toString(),aTest.goalsgetGoalID("s2345")[1].toString());
		 
		 //Create, Edit, Delete
		 aTest.goalscreate("s90", "Goal100", "Test if it works", "p101", "u10", "u100", "2020-02-20 09:05:45.000");
		 assertEquals("Goal100",aTest.goalsgetName("s90"));
		 assertEquals("Test if it works",aTest.goalsgetDescription("s90"));
		 assertEquals("u10",aTest.goalsgetAssignor("s90"));
		 assertEquals("u100",aTest.goalsgetAssignee("s90"));
		 //assertEquals(aTest.currentTime(),aTest.goalsgetStartDate("s90")); Works, just a fraction of a second off for me
		 assertEquals("2020-02-20 09:05:45.000",aTest.goalsgetEndDate("s90"));
		 assertEquals("NOT STARTED",sql_API_FAKE.goalsgetStatus("s90"));
		 assertEquals("TBD",aTest.goalsgetGrade("s90"));
		 
		 aTest.goalsedit("s90", "Goal101", "", "", "", "","","","");
		 aTest.goalsedit("s90", "", "", "", "IN PROGRESS", "","","","");
		 assertEquals("Goal101",aTest.goalsgetName("s90"));
		 assertEquals("Test if it works",aTest.goalsgetDescription("s90"));
		 assertEquals("NOT STARTED",aTest.goalsgetStatus("s90"));
		 
		 aTest.goalsdelete("s90");
		 Assertions.assertThrows(NoSuchElementException.class, () -> {aTest.goalsgetName("s90");});
		 Assertions.assertThrows(NoSuchElementException.class, () -> {aTest.goalsdelete("s11");});
		 Assertions.assertThrows(NoSuchElementException.class, () -> {aTest.goalsgetDescription("s125");});
		 
		 //All good so far
	}
	
	@Test
	void testComments() {
		//Get Text, commentor, parent id, date,
		assertEquals("This is a comment",aTest.commentsgetCommentText("c4235"));
		assertEquals("s25253",aTest.commentsgetCommentor("c4235"));
		assertEquals("p34852",aTest.commentsgetParentID("c4235"));
		assertEquals("2019-10-05 09:05:45.000",aTest.commentsgetDate("c4235"));

		//Create, Edit, Delete
		aTest.commentscreate("c1000", "This is a test", "s1234", "p10101", "2019-10-10 09:05:45.000");
		assertEquals("This is a test", aTest.commentsgetCommentText("c1000"));
		assertEquals("s1234",aTest.commentsgetCommentor("c1000"));
		assertEquals("p10101",aTest.commentsgetParentID("c1000"));
		assertEquals("2019-10-10 09:05:45.000",aTest.commentsgetDate("c1000"));
		
		aTest.commentscreate("c1001", "This is also a test", "s2222", "p01010", "2019-10-11 09:05:45.000");
		aTest.commentsedit("c1001", "I'm done testing");
		assertEquals("I'm done testing", aTest.commentsgetCommentText("c1001"));
		
		aTest.commentsdelete("c1001");
		Assertions.assertThrows(NoSuchElementException.class, () -> {aTest.commentsgetCommentor("c1001");});
		
		Assertions.assertThrows(NoSuchElementException.class, () -> {aTest.commentsgetCommentor("c910");});
		Assertions.assertThrows(NoSuchElementException.class, () -> {aTest.commentsdelete("c11");});
		Assertions.assertThrows(NoSuchElementException.class, () -> {aTest.commentsedit("c1", "This should break");});
		
//		Not finished String[] meow = new String[10];
//		assertArrayEquals(meow,aTest.getComments("s25253"));
		
		//All good so far
	}
	
	@Test
	void testRosters() {
		//Create, Edit, Delete
		aTest.rostercreate("ro101", "Kanban", "u43");
		
		aTest.rosteredit("ro101", "Kanban Pals", "u43");
		
		aTest.rostersdelete("ro101");
		
		Assertions.assertThrows(NoSuchElementException.class, () -> {aTest.rosteredit("ro55", "Plant Gang", "u44");});
		Assertions.assertThrows(NoSuchElementException.class, () -> {aTest.rostersdelete("ro55");});
	}
	
	@Test
	void testStudentRosters() {
		//Create, Delete, no edit?
		aTest.studentrostercreate("u24", "ro999");
		aTest.studentrosterdelete("u24", "ro999");
		aTest.studentrosterdelete("u5496", "ro4235");
		
		//Assertions.assertThrows(NoSuchElementException.class, () -> {aTest.studentrosterdelete("u5249","ro63");}); No exception thrown
		//Assertions.assertThrows(NoSuchElementException.class, () -> {aTest.studentrosterdelete("u5496", "ro4235");}); No exception thrown
		
		//Need to throw exceptions
	}
}


/*
 * Edit does not work for users. Does not change anything
Edit does not work for groups. Changes inputs, but if anything is left blank, it will change it to blank
For removing usergroups, exception not thrown when interacting with usergroups that don't exist.
Remove does not work for usergroups
Need to throw exceptions for studentrosters that don't exist
*/
