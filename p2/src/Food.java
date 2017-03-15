
public class Food extends MainClass {
	String name;
	public Food() {
		name = "Food";
	}
	public Food(String n) {
		name = n;
	}
	public void prepare()
	{
		System.out.println("Prepare the "+name);
	}
}