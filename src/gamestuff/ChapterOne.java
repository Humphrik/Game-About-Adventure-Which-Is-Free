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
			if(input.contains("freeag") && !input.contains("i hate freeag")){
				game.userInput.setText("I love dicks!");
			}
			input = input.replaceAll("the ", "");
			input = input.replaceAll("my ", "");
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
						String[] correctedInput = { "attack", newInput[1], "with", "fists" };
						commands.input = correctedInput;
						commands.attack();
					}
				} else if (newInput[0].equals("drop") || newInput[0].equals("put") || newInput[0].equals("let")) {
					commands.drop();
				} else if (newInput[0].equals("throw") || newInput[0].equals("toss") || newInput.equals("chuck")) {
					if (newInput.length > 2) {
						int j = 2;
						String[] correctedInput;
						if (newInput[2].equals("at")) {
							j = 1;
							correctedInput = new String[2];
						} else {
							correctedInput = new String[3];
						}
						for (int i = 0; i <= j; i++) {
							correctedInput[i] = newInput[i];
						}
						commands.input = correctedInput;
					}
					commands.toss();
				} else if (newInput[0].equals("open")) {
					commands.open();
				} else if (newInput[0].equals("enter") || (newInput[0].equals("go")
						&& (newInput[1].equals("through") || newInput[1].equals("into")))) {
					commands.enter();
				} else if (newInput[0].equals("close") || newInput[0].equals("shut")) {
					commands.close();
				} else if (newInput[0].equals("give") || newInput[0].equals("feed")){
					commands.give();
				} else {
					game.printMessage("You don't know how to do that.");
				}
			} catch (ArrayIndexOutOfBoundsException er) {
				game.printMessage("You must be more specific.");
			}
		}
	}
}
