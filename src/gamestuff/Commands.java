package gamestuff;

public class Commands {
	boolean hasDog = false;
	boolean hasBat = false;
	boolean dogDistracted = false;
	private int wallStare = 0;
	String[] input;

	public void look() {
		try {
			if ((input.length == 3 && (input[1].equals("at") || input[1].equals("around") || input[2].equals("dog")))
					|| (input.length <= 2) || (input.length == 4 && input[3].equals("dog"))) {
				if (input[1].equals("at") && !input[2].equals(null)) {
					input[1] = input[2];
				}
				if ((input[0].equals("look") && input[1].equals("around")) || (input[1].equals("room"))) {
					game.printMessage("You look around.");
					game.printMessage("There is a single door in the room guarded by a large dog.");
					game.printMessage("There is a baseball bat next to one of the walls.");
					game.printMessage("However, the baseball bat is also guarded by a small dog.");
				} else if (input[1].equals("small") || input[1].equals("smalldog") || input[1].equals("tinkles")) {
					if (hasDog) {
						game.printMessage("She's asleep.");
					} else {
						game.printMessage("It is a chubby, yet vicious chihuahua named Tinkles");
						game.printMessage("It looks mean, but you can tell she just wants to be loved.");
					}
				} else if (input[1].equals("large") || input[1].equals("largedog")) {
					game.printMessage("The dog is too scary too look in the eyes...");
					game.printMessage("...This is a scary dog...");
					game.printMessage("...You are scared.");
				} else if (input[1].equals("dog")) {
					game.printMessage("Which dog?");
				} else if (input[1].equals("bat") || input[1].equals("baseball") || input[1].equals("baseballbat")) {
					game.printMessage("It is a wooden bat.");
					if (hasDog) {
						game.printMessage("It looks very professional.");
					} else {
						game.printMessage("A small dog is sitting on top of it.");
					}
				} else if (input[1].equals("door")) {
					if (dogDistracted) {
						game.printMessage("The door is no longer being gaurded.");
					} else {
						game.printMessage("The only exit to the room.");
						game.printMessage("There is a large dog standing in the way.");
					}
				} else if (input[1].equals("self") || input[1].equals("myself") || input[1].equals("me")) {
					game.printMessage("You look down at yourself");
					game.printMessage("You can't help but feel a little dissapointed.");
				} else if (input[1].equals("wall")) {
					game.printMessage("You look at the wall.");
					if (wallStare == 0) {
						game.printMessage("It does not notice you.");
					} else if (wallStare > 0 && wallStare <= 5) {
						game.printMessage("...");
					} else {
						game.printMessage("The wall stares back.");
						game.printMessage("You feel woozy...");
						game.changeHealth(-20);
					}
					wallStare++;
				} else {
					game.printMessage("You don't know how to do that.");
				}
			} else {
				game.printMessage("You cannot do that");
			}
		} catch (ArrayIndexOutOfBoundsException er) {
			game.printMessage("You cannot do that.");

		}
	}

	public void take() {
		try {
			if ((input.length == 3 && (input[1].equals("up") || input[2].equals("dog"))) || (input.length <= 2)
					|| (input.length == 4 && input[3].equals("dog"))) {
				if (input[1].equals("up") && !input[2].equals(null)) {
					input[1] = input[2];
				}
				if (input[1].equals("small") || input[1].equals("smalldog") || input[1].equals("tinkles")) {
					if (hasDog) {
						game.printMessage("You take out the dog and give her a gentle pat on the head.");
						game.printMessage("She likes it.");
					} else {
						game.printMessage("You scoop up the small dog with blinding speed.");
						game.printMessage("She is too shocked to resist.");
						game.printMessage("You add the dog to your inventory.");
						game.HUD.setText(game.HUD.getText().replaceAll("none", "-Small Dog"));
						hasDog = true;
					}
				} else if (input[1].equals("large") || input[1].equals("largedog")) {
					game.printMessage("You have little intent of approaching that beast.");
				} else if (input[1].equals("dog")) {
					game.printMessage("Which dog?");
				} else if (input[1].equals("bat") || input[1].equals("baseball") || input[1].equals("baseballbat")) {
					if (hasBat) {
						game.printMessage("You already have the bat");
					} else if (hasDog && !hasBat) {
						game.printMessage("You take the now ungaurded bat and add it to your inventory.");
						game.HUD.append("\n-Baseball Bat");
					} else {
						game.printMessage("You try to take the bat, but the small dog nips your hand away.");
						game.printMessage("She leaves a red scratch mark on you.");
						game.changeHealth(-1);
					}
				} else if (input[1].equals("self") || input[1].equals("myself") || input[1].equals("me")) {
					game.printMessage("...");
				} else {
					game.printMessage("You don't know  how to do that");
				}
			} else {
				game.printMessage("You cannot do that.");
			}
		} catch (ArrayIndexOutOfBoundsException er) {
			game.printMessage("You cannot do that.");
		}
	}

	public void walk() {
		try {
			if ((input.length == 3 && (input[1].equals("to") || input[2].equals("dog"))) || (input.length <= 2)
					|| (input.length == 4 && input[3].equals("dog"))) {
				if (input[1].equals("up") && !input[2].equals(null)) {
					input[2] = input[1];
				}
			}
			if (input[1].equals("small") || input[1].equals("smalldog") || input[1].equals("tinkles")) {
				if (hasDog) {
					game.printMessage("You are already holding the dog!");
				} else {
					game.printMessage("You try to approach the small dog.");
					game.printMessage("It bites you.");
					game.changeHealth(-1);
				}
			} else if (input[1].equals("large") || input[1].equals("largedog")) {
				game.printMessage("You would rather leave it be for now.");
			} else if (input[1].equals("dog")) {
				game.printMessage("Which dog?");
			} else if (input[1].equals("bat") || input[1].equals("baseball") || input[1].equals("baseballbat")) {
				if (hasBat) {
					game.printMessage("You are already holding the bat!");
				} else if (hasDog && !hasBat) {
					game.printMessage("You are able to approach that bat because you have the dog now.");
				} else {
					game.printMessage("You approach the bat, but the small dog bites you before you can reach it.");
					game.changeHealth(-1);
				}
			} else if (input[1].equals("door")) {
				if (dogDistracted) {
					game.printMessage("You are at the door. This is it...");

				} else {
					game.printMessage("The large dog growls at you before you take your second step.");
				}
			} else {
				game.printMessage("You don't know how to do that.");
			}
		} catch (ArrayIndexOutOfBoundsException er) {
			game.printMessage("You cannot do that.");
		}
	}
}
