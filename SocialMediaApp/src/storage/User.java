package storage;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;

public class User implements Comparable<User>{
	private static final ArrayList<User> users = new ArrayList<User>();
	private static final ArrayList<String> nicknames = new ArrayList<String>();
	private final ArrayList<Content> contents = new ArrayList<Content>();
	private ArrayList<String> hobbies = new ArrayList<String>();
	private ArrayList<Group> groups = new ArrayList<Group>();
	private ArrayList<User> followings = new ArrayList<User>();
	private Map<Content, Group> groupContents = new HashMap<Content, Group>();
	private final String nickname;
	private String password;
	private String realName;
	private String realSurname;
	private String age;
	private String email;
	private boolean isPremium;
	private ImageIcon profilePhoto;
	private String country;
	private int similarityPoint;
	
	public User(String nickname, String password, String realName, String realSurname, String age, String email, String country, boolean isPremium) {
		similarityPoint = 0;
		this.country = country;
		this.nickname = nickname;
		this.password = password;
		this.realName = realName;
		this.realSurname = realSurname;
		this.age = age;
		this.email = email;
		this.isPremium = isPremium;
		users.add(this);
		nicknames.add(nickname);
	}
	
	public int getSimilarityPoint() {
		return similarityPoint;
	}
	
	public void setSimilarityPoint(int similarityPoint) {
		this.similarityPoint = similarityPoint;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public Map<Content, Group> getGroupContents(){
		return groupContents;
	}
	
	public ArrayList<User> getFollowings(){
		return followings;
	}
	
	public ArrayList<Group> getGroups(){
		return groups;
	}
	
	public ArrayList<Content> getContents(){
		return contents;
	}
	
	public static ArrayList<User> getUsers(){
		return users;
	}
	
	public boolean getIsPremium() {
		return isPremium;
	}
	
	public void setIsPremium(boolean isPremium) {
		this.isPremium = isPremium;
	}

	public ArrayList<String> getHobbies() {
		return hobbies;
	}

	public void setHobbies(ArrayList<String> hobbies) {
		this.hobbies = hobbies;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getRealSurname() {
		return realSurname;
	}

	public void setRealSurname(String realSurname) {
		this.realSurname = realSurname;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ImageIcon getProfilePhoto() {
		return profilePhoto;
	}

	public void setProfilePhoto(ImageIcon profilePhoto) {
		this.profilePhoto = profilePhoto;
	}

	public static ArrayList<String> getNicknames() {
		return nicknames;
	}

	public String getNickname() {
		return nickname;
	}
	
	/**
	 * 
	 * @param nickname
	 * @param password
	 * @param realName
	 * @param realSurname
	 * @param age
	 * @param email
	 * @param country
	 * @param isPremium
	 * @return a number to indicate whether the process is successful or not
	 * 
	 * if nickname exists in nicknames list it returns -1 which indicates that the process failed
	 * 
	 * else indicator remains same as 0
	 * 
	 * then, if all fields are filled, it executes and create a new User with parameters and returns 1
	 * which indicates that the process was successful
	 * 
	 * else it returns 0 which indicates that not all the blanks are filled
	 * 
	 * 
	 */
	
	public static int register(String nickname, String password, String realName, String realSurname, String age, String email, String country, boolean isPremium) {
		
		int indicator = 0;
		
		for (String n : nicknames) {
			if (n.equals(nickname)) {
				indicator = -1;
			}
		}
		
		if (indicator == 0) {
			nickname.strip();
			password.strip();
			realName.strip();
			realSurname.strip();
			age.strip();
			email.strip();
			country.strip();
			
			if (nickname.length() == 0|| password.length() == 0|| realName.length() == 0|| realSurname.length() == 0 || age.length() == 0 || email.length() == 0 || country.length() == 0) {
				return 0;
			} 
			else {
				User user = new User(nickname, password, realName, realSurname, age, email, country, isPremium);
				User.users.add(user);
				User.nicknames.add(nickname);
				return 1;
			}
		} else {
			return -1;
		}
		
	} 
	
	/**
	 * 
	 * @param title
	 * @param text
	 * 
	 * User adds a content with indicated parameters  
	 * 
	 */
	
	public void addContent(String title, String text) {
		Content newContent = new Content(title, text, this);
		contents.add(newContent);
		Content.getContents().put(title, newContent);
	}
	
	/**
	 * 
	 * @param title
	 * @param text
	 * @param image
	 * 
	 * User adds a content with indicated parameters  
	 * 
	 * Also overloaded method with addition which is image
	 * 
	 */
	public void addContent(String title, String text, ImageIcon image) {
		Content newContent = new Content(title, text, this);
		newContent.setImage(image);
		contents.add(newContent);
		Content.getContents().put(title, newContent);
	}
	/**
	 * 
	 * @param title
	 * @param text
	 * @param group
	 * 
	 * User adds a content to group with indicated parameters 
	 * 
	 */
	public void addContentGroup(String title, String text, Group group) {
		Content newContent = new Content(title, text, this);
		contents.add(newContent);
		groupContents.put(newContent, group);
		group.getContents().add(newContent);
		Content.getContents().put(title, newContent);
	}
	/**
	 * 
	 * @param title
	 * @param text
	 * @param group
	 * @param image
	 * 
	 * User adds a content to group with indicated parameters 
	 * 
	 * Also overloaded method with parameter addition which is image
	 * 
	 * 
	 */
	public void addContentGroup(String title, String text, Group group, ImageIcon image) {
		Content newContent = new Content(title, text, this);
		newContent.setImage(image);
		contents.add(newContent);
		groupContents.put(newContent, group);
		group.getContents().add(newContent);
		Content.getContents().put(title, newContent);
	}
	
	/**
	 * 
	 * @param content
	 * @param text
	 * @param image
	 * 
	 * user edits his content via indicated parameters.
	 * 
	 */
	
	public void editContent(Content content, String text, ImageIcon image) {
		content.setText(text);
		if (image != null) {
			content.setImage(image);
		}
	}
	
	/**
	 * 
	 * @param content
	 * 
	 * 
	 * this user deletes his indicated content 
	 * 
	 */
	public void deleteContent(Content content) {
		contents.remove(content);
	}
	
	/**
	 * 
	 * @param content
	 * @param group
	 * 
	 * this user deletes his indicated content in the indicated group
	 * 
	 * 
	 */
	public void deleteContentGroup(Content content, Group group) {
		contents.remove(content);
		group.getContents().remove(content);
		groupContents.remove(content);
	}
	
	/**
	 * 
	 * @param user
	 * 
	 * 
	 * this user follows the indicated user with this method
	 * 
	 * 
	 * 
	 */
	public void follow(User user) {
		followings.add(user);
	}
	/**
	 * 
	 * @param user
	 * 
	 * this user unfollows the indicated user with this method
	 * 
	 */
	public void unfollow(User user) {
		followings.remove(user);
	}
	/**
	 * 
	 * @param group
	 * 
	 * This user joins the indicated group with this method
	 * 
	 */
	public void getIntoGroup(Group group) {
		if (!group.getUsers().contains(this)) {
			group.getUsers().add(this);
			groups.add(group);
		}
		
	}
	/**
	 * 
	 * @param group
	 * 
	 * this user leaves the indicated group with this method
	 * 
	 */
	public void leaveGroup(Group group) {
		group.getUsers().remove(this);
		groups.remove(group);
	}
	/**
	 * 
	 * @param user
	 * 
	 * deleting the user from application
	 * 
	 */
	public static void deleteAccount(User user) {
		nicknames.remove(user.getNickname());
		users.remove(user);
	}
	/**
	 * 
	 * @param other user
	 * 
	 * calculate similarity points and set the similarity points of the users
	 * for further processing in getSuggestedUsers method
	 * 
	 * 
	 */
	public void similarityPoint(User other) {
		
		int similarityPoint = 0;
		
		if (country.equals(other.getCountry())) {
			similarityPoint ++;
		}
		
		for (String hobby : hobbies) {
			for (String othersHobby : other.getHobbies()) {
				if (hobby.equals(othersHobby)) {
					similarityPoint ++;
				}
			}
		}
		
		if (Math.abs(Integer.parseInt(age)-Integer.parseInt(other.getAge()))<5){
			similarityPoint ++;
		} else {
			similarityPoint = 0;
		}
		
		if (followings.contains(other)) {
			similarityPoint = 0;
		}
		
		other.setSimilarityPoint(similarityPoint);
	}
	
	/**
	 * 
	 * @return 5 user to suggest
	 * 
	 * the method uses the similarity points of users
	 * sort them according to their similarity points
	 * 
	 * get first 5 users from the list
	 * 
	 * and return the array list of them
	 * 
	 */
	public ArrayList<String> getSuggestedUsers(){
		for(User other : users) {
			similarityPoint(other);
		}
		
		Collections.sort(users);
		
		ArrayList<String> mostFive = new ArrayList<String>();
		 
		for (int i = 0; i < 5; i++) {
			mostFive.add(users.get(i).getNickname());
		}
		
		return mostFive;
	}
	
	/**
	 * 
	 * @return 5 or less groups to user to join
	 * 
	 * the method uses the similarity points of groups
	 * sort them according to their similarity points
	 * 
	 * get first 5 groups from the list
	 * 
	 * and return the array list of them
	 * 
	 */
	
	public ArrayList<String> getSuggestedGroups(){
		for(Group group : Group.getGroups()) {
			similarityPointGroup(group);
		}
		
		Collections.sort(Group.getGroups());
		
		ArrayList<String> mostFiveGroups = new ArrayList<String>();
		if (Group.getGroups().size()< 5) {
			for (int i = 0; i < Group.getGroups().size(); i++) {
				mostFiveGroups.add(Group.getGroups().get(i).getName());
			}
		}else {
			for (int i = 0; i < 5; i++) {
				mostFiveGroups.add(Group.getGroups().get(i).getName());
			}
		}
		
		
		return mostFiveGroups;
		
	}
	
	/**
	 * 
	 * @param group
	 * 
	 * calculate similarity points and set the similarity points of the group
	 * for further processing in getSuggestedGroups method
	 * 
	 * 
	 */
	public void similarityPointGroup(Group group) {
		int similarityPoint = 0;
		
		if (country.equals(group.getCountry())) {
			similarityPoint ++;
		}
		
		for (String hobby : hobbies) {
			for (String groupsHobby : group.getHobbies()) {
				if (hobby.equals(groupsHobby)) {
					similarityPoint ++;
				}
			}
		}
		
		if(groups.contains(group)) {
			similarityPoint = 0;
		}
		
		group.setSimilarityPoint(similarityPoint);
	}
	
	
	

	@Override
	public int compareTo(User other) {
		if(similarityPoint < other.getSimilarityPoint()) {
			return -1;
		}
		else if (similarityPoint > other.getSimilarityPoint()) {
			return 1;
		} else {
			return 0;
		}
		
	}
	
	
	
}
