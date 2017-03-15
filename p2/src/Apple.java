import java.util.Date;

public class Apple  extends Fruit {
	public Apple() {
		name = "apple";
	}
	public Apple(Date r) {
		ripe = r;
	}
	public void prepare() {
		System.out.println("Core the apple");
	}
	
}
