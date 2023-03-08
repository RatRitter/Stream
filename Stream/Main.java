import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		displayMenu();
	}
	public static void contact(String name) {
		String s[] = findNumber(name);
		if(s != null) {
			System.out.println("Call " + name + s[1]);
		}else {
			System.out.println("Not found " + name);
		}
		
	}
	public static void saveContact(String name,int number) {
		System.out.println("Save contact " + name + " : " + number);
		//File file = new File("file.txt");
		
		try {
		
		//if(file.exists()) 
			//file.createNewFile();
		
		PrintWriter pw = new PrintWriter(new FileWriter("file,txt",true));
		pw.println(name + " : " + number);
		pw.close();
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
		
	}
	public static String[] findNumber(String name) {
		
		try(Scanner sc = new Scanner(new File("file.txt"))){
			String[] s = new String[0];
			
			boolean foundPerson = false; 
			while(sc.hasNextLine()) {
				s = sc.nextLine().split(":");
				if(s[0].equals(name)) {
					System.out.println("Number " + name + " is " + s[1]);
					foundPerson = true;
					break;
				}
			}
			if(!foundPerson) {
				System.out.println("Coudn't find " + name);
				s = null;
			}return s;
		}
			catch(IOException e) {
				System.out.println(e.getMessage());}
		return null;
	}

		
	
	
		
	public static void displayMenu() {
		try(Scanner sc = new Scanner(System.in)){
		

		String name;
		System.out.println("1.Call");
		System.out.println("2.Save contact");
		System.out.println("3.Find number");
		int choice = sc.nextInt();
		sc.nextLine();
		switch(choice) {
		case 1:
			System.out.println("Name and surname");
			name = sc.nextLine();
			contact(name);
			break;
		case 2:
			System.out.println("Name and surname");
			 name = sc.nextLine();
			 System.out.println("Number");
			 int number = sc.nextInt();
			 sc.nextLine();
			 saveContact(name,number);
			break;
		case 3:
			System.out.println("Name and surname");
			findNumber(sc.nextLine());
			break;
			default:
				break;
		}
	}catch(Exception e) {
		System.out.println(e.getMessage());
	}

}}
