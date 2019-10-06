package sql_API;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import sql_API.sql_API_FAKE;

/**
 * Class for accessing Group attributes
 * 
 * Chris Grau
 * 
 */

final class Groups {
	private static List<String[]> GROUPS = sql_API_FAKE.GROUPS;
	
	Groups(List<String[]> GROUPS) {
		this.GROUPS = GROUPS;
	}
	
	//get group object with ID
	private static String[] get(String groupID) {
		for (String[] groupList : GROUPS) {
			if (Arrays.deepToString(groupList).contains("[" + groupID + ",")) {
				return groupList;
			}
		}
		throw new NoSuchElementException();
	}
	
	//get single element from comment with ID and element #
	private static String get(String groupID, int index) {
		for (String[] groupList : GROUPS) {
			if (Arrays.deepToString(groupList).contains("[" + groupID + ",")) {
				return groupList[index];
			}
		}
		throw new NoSuchElementException();
	}
	
	
	private static String getGroupName(String groupID){
		return get(groupID, 1);
	}
	
	private static String getGroupOwner(String groupID){
		return get(groupID, 2);
	}
	
	// TODO ?
	private static String[] getAllGroups(){
		return null;
	}
	
	private static void deleteGroup(String groupID){
		GROUPS.remove(get(groupID));
	}
	
	public static void create(String groupID, String groupName, String creatorID){
		
		String[] newGroup = new String[3];
		
		newGroup[0] = groupID;
		newGroup[1] = groupName;
		newGroup[2] = creatorID;
		
		GROUPS.add(newGroup);
	}
	
	public static void edit(String groupID, String groupName, String creatorID){
		String[] groupInfo = get(groupID);
		if(groupName != null){
			groupInfo[1] = groupName;
		}
		if(creatorID != null){
			groupInfo[2] = creatorID;
		}
	}
}