public class Animal {
	public String name;
    public Animal(String _name) {
    	name = _name;
        System.out.println("A new animal has been created!");
    }
    public Animal() {
    	name = "";
        System.out.println("A new animal has been created!");
    }
    public void sleep() {
        System.out.println("An animal sleeps..."+name);
    }

    public void eat() {
        System.out.println("An animal eats..."+name);
    }

}


