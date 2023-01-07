package storage;

import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Group implements Comparable<Group>{
	private User creator;
	private ArrayList<User> users = new ArrayList<User>();
	private ArrayList<Content> contents = new ArrayList<Content>();
	private static ArrayList<String> names = new ArrayList<String>();
	private static ArrayList<Group> groups = new ArrayList<Group>();
	private ArrayList<String> hobbies;
	private String country;
	private String name;
	private int similarityPoint;
	
	
	public Group(String name, String country, ArrayList<String> hobbies, User creator) {
		similarityPoint = 0;
		this.creator = creator;
		this.name = name;
		this.country = country;
		this.hobbies = hobbies;
	}
	
	public int getSimilarityPoint() {
		return similarityPoint;
	}
	
	public void setSimilarityPoint(int similarityPoint) {
		this.similarityPoint = similarityPoint;
	}
	
	public static ArrayList<Group> getGroups(){
		return groups;
	}
	
	public static ArrayList<String> getNames(){
		return names;
	}
	
	public ArrayList<Content> getContents(){
		return contents;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<String> getHobbies() {
		return hobbies;
	}

	public void setHobbies(ArrayList<String> hobbies) {
		this.hobbies = hobbies;
	}
	
	

	/**
	 * 
	 * @param title
	 * @param text
	 * @param author
	 * @param image
	 * 
	 * add a content to group with indicated parameters
	 * 
	 * it has the same function with User class' addContentGroup method
	 * 
	 */
	public void addContent(String title, String text, User author, ImageIcon image) {
		Content newContent = new Content(title, text, author);
		if (image != null) {
			newContent.setImage(image);
		}
	}
	
	/**
	 * 
	 * @param content
	 * 
	 * deletes the indicated content from the group
	 * 
	 */
	
	public void deleteContent(Content content) {
		contents.remove(content);
	}
	
	/**
	 * 
	 * @param name
	 * @param country
	 * @param hobbies
	 * @param creator
	 * @return 0 if it not successful, 1 if it is successful
	 * 
	 * creates a group
	 * 
	 * it is static
	 * 
	 */
	
	public static int createGroup(String name, String country, ArrayList<String> hobbies, User creator) {
		if (Group.getNames().contains(name)) {
			return 0;
		}	else {
			Group newGroup = new Group(name,country,hobbies,creator);
			names.add(name);
			groups.add(newGroup);
			creator.getIntoGroup(newGroup);
			return 1;
		}
		
		
	}
	
	/**
	 * 
	 * @param group
	 * 
	 * delete the indicated group
	 * 
	 * it is static
	 * 
	 */
	
	public static void deleteGroup(Group group) {
		names.remove(group.getName());
		groups.remove(group);
		ArrayList<User> userToLeave = new ArrayList<User>();
		for (User user : group.getUsers()) {
			userToLeave.add(user);
		}
		for(User user: userToLeave) {
			user.leaveGroup(group);
		}
		
	}
	
	/**
	 * Compare groups according to their similarity points which are integer 
	 * and their comparing is same with integer comparing
	 * 
	 */
	
	@Override
	public int compareTo(Group o) {
		if(similarityPoint < o.getSimilarityPoint()) {
			return -1;
		} else if (similarityPoint > o.getSimilarityPoint()) {
			return 1;
		}
		return 0;
	}
	
	

	
}
