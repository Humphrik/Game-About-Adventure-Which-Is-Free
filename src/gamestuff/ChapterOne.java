package gamestuff;

public class ChapterOne extends Thread {
	Commands commands = new Commands();

	public void run() {
		game.printMessage("You have been awake for several hours in a room screwing\naround.");
		while (true) {
			game.printMessage("\nWhat do you do?");
			decisionOne();
		}

	}

	public void decisionOne() {
		try {
			Thread.sleep((long) 100000000000000.0);
		} catch (InterruptedException e) {
			String input = game.inputText.toLowerCase();
			String[] newInput = input.split(" ");
			commands.input = newInput;
			try {
				if ((newInput[0].equals("look") && (newInput[1].equals("at") || newInput[1].equals("around")))
						|| newInput[0].equals("observe") || newInput[0].equals("examine")) {
					commands.look();
				} else if (newInput[0].equals("take") || newInput[0].equals("pick") || newInput[0].equals("grab") || newInput[0].equals("steal")){
					commands.take();
				} else if (((newInput[0].equals("walk") || newInput[0].equals("go")) && newInput[1].equals("to")) || newInput[0].equals("approach")){
					commands.walk();
				}
			} catch (ArrayIndexOutOfBoundsException er) {
				game.printMessage("You cannot do that");
			}
		}
	}
}
