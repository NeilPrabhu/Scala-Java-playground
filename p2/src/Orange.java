import java.util.Date;

public class Orange extends Fruit {
	public Orange() {
		name = "orange";
	}
	public Orange(Date r){
		ripe = r;
	}
	public void prepare() {
		System.out.println("Peel the orange");
	}
}
