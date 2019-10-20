package mothership;

import java.util.ArrayList;
import java.util.List;
import sql_API.sql_API_FAKE;

public class Mothership extends sql_API_FAKE {
	
	sql_API_FAKE dataBase;
	
	public Mothership(sql_API_FAKE db) {
		this.dataBase = db;
	}
	
	public List<String[]> getGroupmemberInfo(String userID){
		String groupName = dataBase.usergroupsGetGroup(userID);
		List<String> groupMembers = dataBase.getGroupMembers(groupName);
		List<String[]> groupInfo = new ArrayList<String[]>();
		for(String ID: groupMembers) {
			String memberInfo[] = new String[4];
			memberInfo[0] = ID;
			memberInfo[1] = dataBase.usersGetName(userID); //Name
			memberInfo[2] = dataBase.usersGetEmail(userID); //Email
			memberInfo[3] = dataBase.usersGetAccountStatus(userID); //Account Status
			memberInfo[4] = dataBase.usersGetLastLogin(userID); //Last Login
			groupInfo.add(memberInfo);
		}
		return groupInfo;
	}
}
