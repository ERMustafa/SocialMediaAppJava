package Demo;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import pages.SignInPage;
import pages.SignUpPage;
import storage.Group;
import storage.User;

public class Main {

	public static void main(String[] args) {
		//(String nickname, String password, String realName, String realSurname, String age, String email, boolean isPremium)
		
		//Adding 12 users
		
		User user1 = new User("test", "password", "Johnny", "Test", "34", "johhnytest@gmail.com", "England", true);
		User user2 = new User("timmy", "secury", "Tim", "Secure", "25", "timsecure@gmail.com", "Scotland", false);
		User user3 = new User("funny", "guy", "Adam", "Smith", "27", "adamsmith@gmail.com", "Scotland", false);
		User user4 = new User("boring", "no1234", "Helena", "Geller", "22", "helenageller@gmail.com", "England",false);
		User user5 = new User("coolNick", "019230", "James", "Bond", "23", "jamesbond@gmail.com", "USA" , false);
		User user6 = new User("dostoyevski", "russian", "Bukski", "Power", "42", "bukskipower@gmail.com", "USA" , false);
		User user7 = new User("kullanici", "34567", "Hasan", "Yanbasan", "34", "hasanyanbasan@gmail.com", "Turkey", false);
		User user8 = new User("Excalibur", "ttt333", "Mustafa", "Torunoglu", "30", "mustafatorunoglu@gmail.com", "Turkey", false);
		User user9 = new User("neYazsamBilemedim", "sifre", "Selin", "Kaya", "32", "selinkaya@gmail.com", "Turkey", false);
		User user10 = new User("Donald", "21312321", "Donald", "Duck", "28", "donaldDuck@gmail.com", "England", true);
		User user11 = new User("Mickey", "sdadas", "Mickey", "Mouse", "37", "mickeymouse@gmail.com", "Scotland", true);
		User user12 = new User("karsu", "34531", "Karsu", "Muzisyen", "25", "karsu@gmail.com", "Turkey", true);
		
		user1.setProfilePhoto(new ImageIcon("./images/1.jpg"));
		user2.setProfilePhoto(new ImageIcon("./images/2.jpg"));
		user3.setProfilePhoto(new ImageIcon("./images/3.jpg"));
		user4.setProfilePhoto(new ImageIcon("./images/4.jpg"));
		user5.setProfilePhoto(new ImageIcon("./images/5.jpg"));
		user6.setProfilePhoto(new ImageIcon("./images/6.jpg"));
		user7.setProfilePhoto(new ImageIcon("./images/7.jpg"));
		user8.setProfilePhoto(new ImageIcon("./images/8.jpg"));
		user9.setProfilePhoto(new ImageIcon("./images/9.jpg"));
		user10.setProfilePhoto(new ImageIcon("./images/10.jpg"));
		user11.setProfilePhoto(new ImageIcon("./images/11.jpg"));
		user12.setProfilePhoto(new ImageIcon("./images/12.jpg"));
		
		
		//Adding 4 Groups
		
		ArrayList<String> hobbiesOfGroup1 = new ArrayList<String>();
		hobbiesOfGroup1.add("Speaking");
		hobbiesOfGroup1.add("Sed eget imperdiet");
		Group.createGroup("English Center", "England", hobbiesOfGroup1, user1);
		Group group1 = Group.getGroups().get(0);
		
		ArrayList<String> hobbiesOfGroup2 = new ArrayList<String>();
		hobbiesOfGroup2.add("Cycling");
		hobbiesOfGroup2.add("Wandering");
		Group.createGroup("suscipit", "Turkey", hobbiesOfGroup2, user10);
		Group group2 = Group.getGroups().get(1);
		
		ArrayList<String> hobbiesOfGroup3 = new ArrayList<String>();
		hobbiesOfGroup3.add("Speaking");
		hobbiesOfGroup3.add("Swimming");
		Group.createGroup("Eut", "Scotland", hobbiesOfGroup3, user11);
		Group group3 = Group.getGroups().get(2);
		
		ArrayList<String> hobbiesOfGroup4 = new ArrayList<String>();
		hobbiesOfGroup4.add("Running");
		hobbiesOfGroup4.add("Wondering");
		Group.createGroup("Praesent", "England", hobbiesOfGroup4, user12);
		Group group4 = Group.getGroups().get(3);
		
		//Adding Content
		user1.addContent("heyyoooo", "Whatsssuppp");
		user1.addContent("example", "comeon");
		user1.addContent("Lorem ipsum dolor sit amet", "onsectetur adipiscing eli", new ImageIcon("./images/1.jpg"));
		
		user2.addContent("what", "firstt");
		user2.addContent("whatthe", "what the hack, it is working!!");
		user2.addContent("Aliquam vulputate", "ulputate eros at accumsan. Cras venenatis nunc ", new ImageIcon("./images/2.jpg"));
		
		user3.addContent("firstTitle", "hellloooooo!");
		user3.addContent("secondTitle", "I'm not creative though :(");
		user3.addContent("fermentum tincidunt", "Nullam aliquet mattis augue in venenatis. Suspendisse scelerisque, justo et ornare suscipit, velit dolor interdum nibh, id efficitur erat orci quis ante.", new ImageIcon("./images/3.jpg"));
		
		
		user4.addContent("myFirst", "Ok, it is working!");
		user4.addContent("mySecond", "Let's goooo!!!");
		user4.addContent("Aenean quis", "Nam lectus mauris, ullamcorper in blandit ac, sagittis at lorem. ", new ImageIcon("./images/11.jpg"));
		
		user5.addContent("herewego", "Here we goooo!", new ImageIcon("./images/12.jpg"));
		user5.addContent("okokokok", "I was a goat in my dream!");
		user5.addContent("Donec pharetra faucibus", " metus in faucibus. Nulla vel leo porta, interdum urna a, molestie elit. Nullam vitae neque luctus, iaculis metus in, euismod velit. Integer tincidunt, nisl et porta euismod, risus elit pellentesque risus, et efficitur tellus ligula ultrices tortor. Nullam non pulvinar risus.");
		
		
		user6.addContent("life", "What is life btw?");
		user6.addContent("death", "I know pretty much about death O.o");
		user6.addContent("Etiam ", "Vivamus nisl ligula, rhoncus at facilisis id, viverra nec lorem. Aliquam tristique ante lorem, sit amet accumsan nibh bibendum in. Morbi vitae suscipit lectus. Ut eget nunc lectus.", new ImageIcon("./images/4.jpg"));
		
		user7.addContent("Curabitur molestie turpis id", "Fusce odio quam, pulvinar sit amet felis eget, facilisis eleifend mi. Fusce odio sem, lobortis id venenatis nec, tincidunt feugiat justo.");
		user7.addContent("Cras ornare, erat eu finibus tempus, ", "Donec porttitor luctus risus, id dignissim tellus vestibulum sit amet. Nam accumsan ante a odio mattis, eget condimentum erat dictum. Nam non orci mi. Sed sodales vulputate dolor sed dapibus. Sed luctus efficitur mattis. ");
		user7.addContent("Nullam id aliquet augue", "Integer at nisl ut metus faucibus fringilla at sed risus.", new ImageIcon("./images/5.jpg"));
		
		user8.addContent("Nullam ultricies blandit nunc imperdiet eleifend. ", "Proin nec mi justo. Cras eros enim, accumsan et sapien sed, sollicitudin auctor mauris. Nam nec porta diam, quis efficitur orci. Quisque dapibus, tortor at aliquam interdum, mi massa accumsan quam, sed sagittis erat nunc sed sem. Vestibulum egestas tellus sed mi convallis, vel sollicitudin nulla elementum.");
		user8.addContent("Vestibulum purus sem,", ". Sed viverra, diam eget pharetra ornare, erat massa finibus nisl, tempus fringilla risus urna a magna.");
		user8.addContent("Fusce mattis orci ut ornare pellentesque.", "Praesent vel egestas erat. Integer condimentum semper enim ac accumsan. Nunc ut purus sed justo ultrices vestibulum. Quisque ornare magna eu leo convallis, vel mollis nunc tristique. ",new ImageIcon("./images/6.jpg"));
		
		user9.addContent("Sed tristique eget dolor a mollis", "Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Quisque tincidunt tempor velit et vulputate. ");
		user9.addContent("Duis pharetra eu risus non ",". Donec scelerisque velit at congue ultrices. Integer ornare, metus eget pretium elementum, nibh nisl blandit arcu, maximus porttitor dui massa in justo. Vivamus convallis mi ligula, non pharetra eros lobortis non. Nullam pulvinar, nulla ac porta efficitur, ante ante vehicula ipsum");
		user9.addContent("Quisque sit amet ju","Nullam pulvinar, nulla ac porta efficitur, ante ante vehicula ipsum, a suscipit felis mauris vitae purus. Praesent nec sodales mi. Curabitur porttitor mollis mauris vitae condimentum.", new ImageIcon("./images/7.jpg"));
		
		user10.addContent("Aenean mollis commodo nisl, "," a convallis dui ultricies commodo. Cras egestas tortor non lacus viverra, ultricies euismod neque venenatis. Nulla nisi neque, semper vitae ante ac, fermentum mattis justo. Sed imperdiet dolor dolor, a semper libero dictum nec. Nullam et mi metus. Cras in mollis nibh, a vulputate elit. Ut velit justo, blandit id aliquet condimentum, scelerisque non lorem. Phasellus laoreet felis at eros fermentum porttitor. Proin convallis pellentesque lobortis");
		user10.addContent("Ut tempor porta massa vel posuere. Integer aliquam viverra velit et ultrices.","Suspendisse potenti. Aliquam erat volutpat. Nullam eget ante ac eros viverra suscipit vel eget nunc. Vestibulum tempus, erat non tempus euismod, eros dui tincidunt diam, in euismod nisi diam vitae dui. Vestibulum congue neque vitae iaculis tempus. Proin lobortis dapibus elit id dictum.");
		user10.addContent("aecenas tempus null",". Cras sodales, nisi eget feugiat vehicula, elit arcu auctor lacus, in bibendum lectus odio faucibus purus. Sed lacus orci, sodales vehicula velit sit amet, maximus lacinia elit.", new ImageIcon("./images/8.jpg"));
		
		user11.addContent("In quis neque sit amet ex suscipit bibendum.","Nulla lacinia mattis congue.");
		user11.addContent("Aenean luctus ","nteger ipsum quam, suscipit eu mi in, efficitur finibus nisi. Etiam eu augue id ligula ultrices dapibus a non lectus. In arcu ex, ultricies et ligula ac, eleifend blandit ipsum. Integer gravida et tellus at congue. Integer finibus massa mi, eu elementum massa fermentum sit amet. Fusce tristique purus eu dignissim posuere. Mauris nec consequat tellus, eget fermentum dolor. ");
		user11.addContent("Donec mattis urna sit amet augue condimentum","non laoreet enim varius. Pellentesque mattis, velit in eleifend blandit, augue diam posuere orci, nec scelerisque orci urna non magna. Praesent fermentum imperdiet leo, vel laoreet enim luctus sit amet. Proin imperdiet velit at nisi gravida pulvinar. Suspendisse tincidunt cursus lacus eget rhoncus.",new ImageIcon("./images/9.jpg"));
		
		user12.addContent("Duis dictum vitae metus at porttitor.","Nunc condimentum libero quis ante vehicula vulputate. Ut et orci eros. Fusce viverra urna egestas lacus feugiat, vitae molestie velit feugiat.");
		user12.addContent("Cras condimentum justo velit","",new ImageIcon("./images/10.jpg"));
		user12.addContent("semper ut a libero.","at vestibulum ex facilisis non. Quisque vel sapien et magna accumsan tempus et ac risus. Maecenas gravida massa eu massa finibus semper. Praesent neque ex, faucibus ac neque in, tristique molestie mauris. Mauris vel pellentesque enim. Suspendisse interdum fermentum nibh nec aliquam. ");
		
		
		// 3 users for each group
		
		user2.getIntoGroup(group1);
		user3.getIntoGroup(group1);
		
		user4.getIntoGroup(group2);
		user5.getIntoGroup(group2);
		
		user6.getIntoGroup(group3);
		user7.getIntoGroup(group3);
		
		user8.getIntoGroup(group4);
		user9.getIntoGroup(group4);
		
		// group contents
		
		user1.addContentGroup("Is it?", "Trial" , group1);
		
		user2.addContentGroup("Nunc condimentum libero quis ", "Pellentesque mattis, velit in eleifend blandit, augue diam posuere orci, nec scelerisque orci urna non magna. Praesent fermentum imperdiet leo" , group1);
		
		user3.addContentGroup("ex facilisis non. Quisque vel sapien et magna accumsan tempus et ac risus. Maecenas gravida massa eu massa finibus semper. Praesent neque ex,", "justo velit, at vestibulum" , group1);
		
		user4.addContentGroup("Duis dictum vitae metus at porttitor", "Nunc condimentum libero quis ante vehicula vulputate. Ut et orci eros. Fusce viverra urna egestas lacus feugiat, vitae molestie velit feugiat." , group2, new ImageIcon("./images/1.jpg"));
		
		user5.addContentGroup("Mauris vel pellentesque enim", "Suspendisse interdum fermentum nibh nec aliquam. Ut quis sem nec arcu placerat semper ut a libero." , group2);
		
		user6.addContentGroup("Sed eget imperdiet ", "Suspendisse congue blandit consectetur. Nullam suscipit enim sed semper porttitor. Nulla ac massa vitae erat imperdiet maximus. Donec eu lectus ac nisl pellentesque elementum sed quis purus. S" , group2);
		
		user7.addContentGroup("Curabitur et libero erat", "Quisque convallis dui non nisi ornare feugiat. Suspendisse fringilla pretium augue id ultrices. Phasellus sem urna, posuere ut est in, sollicitudin placerat lacus. Nullam a mattis nulla, condimentum blandit lectus. In sed nulla vel nibh porttitor accumsan. Suspendisse justo sapien, mollis eget faucibus rhoncus, convallis id elit. " , group3, new ImageIcon("./images/2.jpg"));
		
		user8.addContentGroup("Nunc vel tortor at orci scelerisque sollicitudin", " Nulla vel ante leo. Sed at purus magna. Fusce convallis massa est, at sagittis ipsum aliquam at. Nullam venenatis mattis dolor vel lacinia. Etiam aliquam" , group3);
		
		user9.addContentGroup("Nullam non lectus lacinia", " Sed pellentesque risus quis metus mollis, in ultricies diam iaculis." , group3);
		
		user10.addContentGroup("Mauris iaculis blandit ", "Vestibulum ante ipsum primis in faucibus or" , group4, new ImageIcon("./images/3.jpg"));
		
		user11.addContentGroup("Nullam placerat dapibus elit,", "Nullam finibus urna eget urna luctus, et feugiat metus dapibus. Proin egestas nisi urna, sit amet pretium eros sagittis eget. Ut malesuada quis est eu sodales. Nulla facilisi. Vivamus consectetur sem purus, eu varius nibh sodales tincidunt. Pellentesque hendrerit placerat pretium. " , group4);
		
		user12.addContentGroup("Integer nec est eget elit", "Aenean sit amet dui at diam varius interdum" , group4);
		
		
		// 3 followed users for each user
		
		user1.follow(user2);
		user1.follow(user3);
		user1.follow(user4);
		
		user2.follow(user2);
		user2.follow(user3);
		user2.follow(user4);
		
		user3.follow(user2);
		user3.follow(user3);
		user3.follow(user4);
		
		user4.follow(user2);
		user4.follow(user3);
		user4.follow(user4);
		
		user5.follow(user2);
		user5.follow(user3);
		user5.follow(user4);

		user6.follow(user2);
		user6.follow(user3);
		user6.follow(user4);
		
		user7.follow(user2);
		user7.follow(user3);
		user7.follow(user4);
		
		user8.follow(user2);
		user8.follow(user3);
		user8.follow(user4);
		
		user9.follow(user2);
		user9.follow(user3);
		user9.follow(user4);
		
		user10.follow(user2);
		user10.follow(user3);
		user10.follow(user4);
		
		user11.follow(user2);
		user11.follow(user3);
		user11.follow(user4);
		
		user12.follow(user2);
		user12.follow(user3);
		user12.follow(user4);
		
	
		// Starts the app
		
		SignInPage signIn = new SignInPage();
		
	}

}
