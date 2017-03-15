public class Dog extends Animal {
	public Dog() {
		System.out.println("A new dog has been created!");
	}
	
	//Override
	public void sleep() {
		System.out.println("A dog sleeps..."+name);
	}
	
	//Override
	public void eat() {
		System.out.println("A dog eats..."+name);
	}
	
	public void bark(){
		System.out.println("Woof!  Woof!");
	}
}