package storage;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;

public class Content {
	private static final ArrayList<String> titles = new ArrayList<String>();
	private static final HashMap<String, Content> contents = new HashMap<String, Content>();
	private String title;
	private LocalDateTime creationTime;
	private String text;
	private ImageIcon image;
	private User author;
	
	
	
	
	public Content(String title, String text, User author) {
		this.title = title;
		this.creationTime = LocalDateTime.now();
		this.text = text;
		this.author = author;
		titles.add(title);
	}
	
	public static HashMap<String, Content> getContents(){
		return contents;
	}
	
	public LocalDateTime getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(LocalDateTime creationTime) {
		this.creationTime = creationTime;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public ImageIcon getImage() {
		return image;
	}
	public void setImage(ImageIcon image) {
		this.image = image;
	}
	public User getAuthor() {
		return author;
	}
	public void setAuthor(User author) {
		this.author = author;
	}
	public static ArrayList<String> getTitles() {
		return titles;
	}
	
	
	
	
}
