package sql_API;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import sql_API.sql_API_FAKE;

/**
 * Class for accessing Comment attributes
 * 
 * Chris Grau
 * 
 */

final class Comments {
	private static List<String[]> COMMENTS = sql_API_FAKE.COMMENTS;
	
	Comments(List<String[]> COMMENTS) {
		this.COMMENTS = COMMENTS;
	}
	
	//get comment object with ID
	private static String[] get(String commentID) {
		for (String[] commentList : COMMENTS) {
			if (Arrays.deepToString(commentList).contains("[" + commentID + ",")) {
				return commentList;
			}
		}
		throw new NoSuchElementException();
	}
	
	//get single element from comment with ID and element #
	private static String get(String commentID, int index) {
		for (String[] commentList : COMMENTS) {
			if (Arrays.deepToString(commentList).contains("[" + commentID + ",")) {
				return commentList[index];
			}
		}
		throw new NoSuchElementException();
	}
	
	public static String getCommentText(String commentID){
		return get(commentID, 1);
	}
	
	public static String getCommentor(String commentID){
		return get(commentID, 2);
	}
	
	public static String getParentID(String commentID){
		return get(commentID, 3);
	}	
	
	public static String getDate(String commentID){
		return get(commentID,4);
	}
	
	//TODO: Given the parent object ID, get all of the comments. maybe we want to use an arraylist?
	public static String[] getComments(String parentID){
		String[] meow = new String[10];
		return meow;
	}
	
	public static void create(String commentID, String commentText, String commentor, String parentID, string date){
		
		String[] newComment = new String[5];
		
		newComment[0] = commentID;
		newComment[1] = commentText;
		newComment[2] = commentor;
		newComment[3] = parentID;
		newComment[4] = date;
		
		COMMENTS.add(newComment);
	}
	
	//doesn't really seem necessary to be able to update the commentor or the thing it is commented on...
	public static void edit(String commentID, String commentText){
		String[] commentInfo = get(commentID);
		
		if(commentText != null){
			commentInfo[1] = commentText;
		}
	}
	public static void delete(String commentID){
		COMMENTS.remove(get(commentID));
	}
	
}