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
			input = input.replaceAll("the", "");
			String[] newInput = input.split(" ");
			commands.input = newInput;
			try {
				if ((newInput[0].equals("look") && (newInput[1].equals("at") || newInput[1].equals("around")))
						|| newInput[0].equals("observe") || newInput[0].equals("examine")) {
					commands.look();
				} else if (newInput[0].equals("take") || newInput[0].equals("pick") || newInput[0].equals("grab")
						|| newInput[0].equals("steal") || newInput[0].equals("get")) {
					commands.take();
				} else if (((newInput[0].equals("walk") || newInput[0].equals("go")) && newInput[1].equals("to"))
						|| newInput[0].equals("approach")) {
					commands.walk();
				} else if (((newInput[0].equals("attack") || newInput[0].equals("fight") || newInput[0].equals("kill")
						|| newInput[0].equals("murder") || newInput[0].equals("strike")
						|| newInput[0].equals("hit")))) {
					commands.attack();
				} else if (newInput[0].equals("punch") || newInput[0].equals("kick")) {
					if (newInput.length == 3) {
						String[] correctedInput = { "attack", newInput[1], newInput[2], "with", "fists" };
						commands.input = correctedInput;
						commands.attack();
					} else if (newInput.length == 2) {
						String[] correctedInput = { "attack", newInput[1], "with", "fists"};
						commands.input = correctedInput;
						commands.attack();
					}
				} else if (newInput[0].equals("drop") || newInput[0].equals("put")|| newInput[0].equals("let")){
					commands.drop();
				}
			} catch (ArrayIndexOutOfBoundsException er) {
				game.printMessage("You cannot do that");
			}
		}
	}
}
