

public class Main {

	public static void main(String[] args) {
		World world = new World();
		world.WorldLoop();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.exit(0);
	}

}

//ascii text in the titles made using https://texteditor.com/ascii-art/