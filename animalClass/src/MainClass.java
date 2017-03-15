public class MainClass {
	public static void main(String[] args) {
		Animal animal = new Animal("Bob");
		Bird bird = new Bird();
		Dog dog = new Dog();
		
		System.out.println();
		
		animal.sleep();
		animal.eat();
		
		bird.sleep();
		bird.eat();
		
		dog.sleep();
		dog.eat();
		
		 //Animal animal2 = new Animal();
		 //dog  = animal2;  //Doesn't work
		animal = bird;//works
		 
		 animal.eat();//Does Bird's eat function - this is polymorphism
		
		
		//Maybe this will help...
		Animal a1 = new Dog();
		//Dog d = new Animal();//Doesn't work
 

		a1.eat();//Does Dog's eat and sleep
		a1.sleep();
		//a1.bark();//This is weird, so you can't do it 
		
		/*
		d.eat();
		d.sleep();
		d.bark();//And this is weird.  Which is worse?  
		 *This one is worse, and  dog = animal is the problem; just not letting bark be called 
		 * wouldn't fix it because NOT being able to call bark on a dog variable is just as bad
		 * as being able to call bark on a variable that doesn't really hold a dog.
		 * And that's why you can't do dog=animal.
		*/
		
		//End polymorphism
		
		//Illustrating that animal and bird are references to objects
		animal.eat();
		bird.eat();
		
		 animal = bird;
		 animal.name = "Fluffy";//Changes the name of BOTH animal and bird
		 
		 animal.eat();
		 bird.eat();
		

		
	}
}

