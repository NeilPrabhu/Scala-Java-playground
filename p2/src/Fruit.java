import java.util.Date;

public class Fruit extends Food {
	Date ripe;
	public Fruit()
	{
		name = "Fruit";
	}
	public Fruit( String n, Date r) {
		ripe = r;
		name = n;
	}
	public void ripeTime() {
		System.out.println("You can eat it on "+ripe);
	}
}
