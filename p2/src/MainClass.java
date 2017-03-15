import java.lang.reflect.*;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Date;
class MainClass
{
	public static ArrayList returnObj(ArrayList l)
	{
		// create array of class objects
		ArrayList objects = new ArrayList();
		for(int i = 0; i < l.size(); i++) {
			// test each string to see if it is equal to a formal Class Name 
			// If it matches make that object and add it to the objects arrayList
			if(l.get(i) == "Fruit"){
				Fruit f = new Fruit();
				objects.add(f);
			}
			else if(l.get(i) == "Food") {
				Food foo = new Food();
				objects.add(foo);
			}
			else if(l.get(i) == "Orange") {
				Orange or = new Orange();
				objects.add(or);
			}
			else if(l.get(i) == "Apple") {
				Apple app = new Apple();
				objects.add(app);
			}
		}
		return objects;
	}
	public static void main(String args[]) {
		
		Date d = new Date(2000000000);
		Food gum = new Food("gum");                     
		Food las = new Food("lasagna");                 
		Fruit pom = new Fruit("pomegranate",d);         
		Fruit app = new Apple(d);                       
		Orange o = new Orange(d);                       
		Shrimp sh = new Shrimp();
		Seafood p = new Prawn();
		Seafood l = new Seafood("lobster");		
		
		ArrayList list = new ArrayList();                   // list will store all non-Seafood objects
		ArrayList<String> input = new ArrayList<String>();  // input will take list's object's name and parameters as Strings
		ArrayList list2 = new ArrayList();					// list2 is the final list that stores all objects  
		
		list.add(gum); 										// 0 Food gum
		list.add(las); 										// 1 Food lasagna
		list.add(pom); 										// 2 Fruit pomegranate DATE
		list.add(app);            							// 3 Apple Fruit DATE
		list.add(o);                                        // 4 orange orange DATE
		list.add("test");						 			// 5 String
		list.add(1234);										// 6 Integer
		list.add(d); 										// 7 Date
		
		for(int i=0; i<list.size(); i++){
			// get element
			Object obj = list.get(i);
			if (obj instanceof Apple) {
				System.out.println(i+ " is an Apple");
				// cast to class Apple
				Apple a = (Apple)obj;
				// add Apple's class name and it's parameters
				input.add(a.getClass().getName());
				input.add(a.ripe.toString());
			}
			else if (obj instanceof Orange) {
			    System.out.println(i+" is an Orange");
			    // cast to class Orange
			    Orange or = (Orange)obj;
			    // add Orange's class name and it's parameters
			    input.add(or.getClass().getName());
				input.add(or.ripe.toString());
			}
			else if (obj instanceof Fruit) {
				System.out.println(i+ " is a Fruit");
				// cast to class Fruit
				Fruit f = (Fruit)obj;
				// add Fruit's class name and it's parameters
				input.add(f.getClass().getName());
				input.add(f.name);
				input.add(f.ripe.toString());
			}
			else if (obj instanceof Integer) {
				System.out.println(i+" is an Integer");
				// cast to class String
				String str = obj.toString();
				// add String
				input.add(str);
			}
			else if (obj instanceof Date) {
				System.out.println(i+" is a Date");
				// cast to class String
				String day = obj.toString();
				// add str
				input.add(day);
			}
			else if (obj instanceof String) {
				System.out.println(i+ " is a String");
				// cast to class String
				String str2 = obj.toString();
				// add str
				input.add(str2);
			}
			else{
				System.out.println(i+" is a Food");
				// cast to class Food
				Food foo = (Food)obj;
				// add Fruit's class name 
				input.add(foo.getClass().getName());
				input.add(foo.name);
			}
		}
		System.out.println();
		System.out.println("Input ArrayList sent to returnObj: ");
		// Testing purposes: display the input array 
		for(int i = 0; i < input.size(); i++) {
			System.out.print(input.get(i)+ " ");
		}
		System.out.println();
		System.out.println();
		
		// call function with input ArrayList and place result in list2
		list2 = returnObj(input);
		
		System.out.println("Final ArrayList returned from returnObj: ");
		// Print all the objects in list2
		for(int i = 0; i < list2.size(); i++) {
			System.out.print(list2.get(i).getClass().getName()+ " ");
		}
	}
}