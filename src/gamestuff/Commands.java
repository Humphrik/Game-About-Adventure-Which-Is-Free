package gamestuff;

public class Commands {
	boolean hasDog = false;
	boolean hasBat = false;
	boolean dogDistracted = false;
	boolean doorOpen = false;
	private int wallStare = 0;
	String[] input;

	public void look() {
		try {
			if ((input.length == 3 && (input[1].equals("at") || input[1].equals("around") || input[2].equals("dog")
					|| input[2].equals("bat"))) || (input.length <= 2)
					|| (input.length == 4 && input[3].equals("dog") || input[3].equals("bat"))) {
				if (input[1].equals("at") && !input[2].equals(null)) {
					input[1] = input[2];
				}
				if ((input[0].equals("look") && input[1].equals("around")) || (input[1].equals("room"))) {
					game.printMessage("You look around.");
					game.printMessage("There is a single door in the room.");
					if (dogDistracted) {
						game.printMessage("The large dog guarding it is now distracted.");
					} else {
						game.printMessage("It is being guarded by a large dog.");
					}
					if (!hasBat && !dogDistracted) {
						game.printMessage("There is a baseball bat next to one of the walls.");
					}
					if (!hasDog) {
						game.printMessage("However, the baseball bat is guarded by a small dog.");
					}
				} else if (input[1].equals("small") || input[1].equals("smalldog") || input[1].equals("little")
						|| input[1].equals("littledog") || input[1].equals("tinkles")) {
					if (hasDog) {
						game.printMessage("She's fallen asleep, but is still growling.");
					} else {
						game.printMessage("It is a chubby, yet vicious chihuahua named Tinkles");
						game.printMessage("It looks mean, but you can tell she just wants to be loved.");
					}
				} else if (input[1].equals("large") || input[1].equals("largedog") || input[1].equals("big")
						|| input[1].equals("bigdog")) {
					game.printMessage("The dog is too scary too look in the eyes...");
					game.printMessage("...This is a scary dog...");
					game.printMessage("...You are scared.");
				} else if (input[1].equals("dog")) {
					game.printMessage("Which dog?");
				} else if (input[1].equals("bat") || input[1].equals("baseball") || input[1].equals("baseballbat")) {
					if (!dogDistracted) {
						game.printMessage("It is a wooden bat.");
						if (hasDog) {
							game.printMessage("It looks very professional.");
						} else {
							game.printMessage("A small dog is sitting on top of it.");
						}
					} else {
						game.printMessage("The bat is currently being mauled by a dog.");
					}
				} else if (input[1].equals("door")) {
					if (dogDistracted) {
						game.printMessage("The door is no longer being guarded.");
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
					game.printMessage("You cannot look at that.");
				}
			} else {
				game.printMessage("You cannot look at that.");
			}
		} catch (ArrayIndexOutOfBoundsException er) {
			game.printMessage("What are you looking at?.");

		}
	}

	public void take() {
		try {
			if ((input.length == 3 && (input[1].equals("up") || input[2].equals("dog") || input[2].equals("bat")))
					|| (input.length <= 2) || (input.length == 4 && input[3].equals("dog") || input[3].equals("bat"))
					|| (input.length == 6 && input[5].equals("bat"))) {
				if (input[1].equals("up") && !input[2].equals(null)) {
					input[1] = input[2];
				}
				if (input[1].equals("small") || input[1].equals("smalldog") || input[1].equals("little")
						|| input[1].equals("littledog") || input[1].equals("tinkles")) {
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
				} else if (input[1].equals("large") || input[1].equals("largedog") || input[1].equals("big")
						|| input[1].equals("bigdog") || input[1].equals("big") || input[1].equals("bigdog")) {
					game.printMessage("You have little intent of approaching that beast.");
				} else if (input[1].equals("dog")) {
					game.printMessage("Which dog?");
				} else if (input[1].equals("bat") || input[1].equals("baseball") || input[1].equals("baseballbat")) {
					if (dogDistracted) {
						game.printMessage("It belongs to the large dog now.");
					} else if (hasBat) {
						game.printMessage("You already have the bat");
					} else if (hasDog && !hasBat) {
						game.printMessage("You take the now unguarded bat and add it to your inventory.");
						game.HUD.append("\n-Baseball Bat");
						hasBat = true;
					} else {
						game.printMessage("You try to take the bat, but the small dog nips your hand away.");
						game.printMessage("She leaves a red scratch mark on you.");
						game.changeHealth(-1);
					}
				} else if (input[1].equals("self") || input[1].equals("myself") || input[1].equals("me")) {
					game.printMessage("...");
				} else {
					game.printMessage("You cannot take that.");
				}
			} else {
				game.printMessage("You cannot take that");
			}
		} catch (ArrayIndexOutOfBoundsException er) {
			game.printMessage("What are you taking?");
		}
	}

	public void walk() {
		try {
			if ((input.length == 3 && (input[1].equals("to") || input[2].equals("dog")) || input[2].equals("bat"))
					|| (input.length <= 2) || (input.length == 4 && input[3].equals("dog") || input[3].equals("bat"))) {
				if (input[1].equals("to") && !input[2].equals(null)) {
					input[1] = input[2];
				}
				if (input[1].equals("small") || input[1].equals("smalldog") || input[1].equals("little")
						|| input[1].equals("littledog") || input[1].equals("tinkles")) {
					if (hasDog) {
						game.printMessage("You are already holding the dog!");
					} else {
						game.printMessage("You try to approach the small dog.");
						game.printMessage("It bites you.");
						game.changeHealth(-1);
					}
				} else if (input[1].equals("large") || input[1].equals("largedog") || input[1].equals("big")
						|| input[1].equals("bigdog")) {
					game.printMessage("You would rather leave it be for now.");
				} else if (input[1].equals("dog")) {
					game.printMessage("Which dog?");
				} else if (input[1].equals("bat") || input[1].equals("baseball") || input[1].equals("baseballbat")) {
					if (dogDistracted) {
						game.printMessage("There is a big dog in the way");
					} else if (hasBat) {
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
					game.printMessage("You cannot approach that.");
				}
			} else {
				game.printMessage("You cannot approach that.");
			}
		} catch (ArrayIndexOutOfBoundsException er) {
			game.printMessage("What are you approaching?");
		}
	}

	public void attack() {
		boolean useBat = false;
		boolean useFists = false;
		boolean invalidWeapon = false;
		try {

			if (input.length == 4 || (input.length == 5 && input[2].equals("dog") || input[4].equals("bat"))
					|| (input.length == 6 && input[5].equals("bat"))) {
				if (input[3].equals("with") || input[3].equals("using")) {
					input[3] = input[4];
				}
				if (input[3].equals("bat") || input[3].equals("baseball") || input[3].equals("baseballbat")) {
					if (hasBat) {
						useBat = true;
					} else {
						game.printMessage("You don't have a bat");
					}
				} else if (input[3].contains("fist") || input[3].contains("hand") || input[3].contains("feet")) {
					useFists = true;
				} else {
					invalidWeapon = true;
				}
				if (invalidWeapon) {
					game.printMessage("That is not a valid weapon!");
				} else if (useFists) {
					if (input[1].equals("small") || input[1].equals("smalldog") || input[1].equals("little")
							|| input[1].equals("littledog") || input[1].equals("tinkles")) {
						if (!hasDog) {
							game.printMessage("You try to strike the dog, but she is too fast.");
							game.printMessage("She latches on to you with her jaw and refuses to let go.");
							game.printMessage("It looks like you are stuck with her for now.");
							game.changeHealth(-10);
							game.HUD.setText(game.HUD.getText().replaceAll("none", "-Small Dog"));
							hasDog = true;
						} else {
							game.printMessage("You are still holding the dog!");
						}
					} else if (input[1].equals("large") || input[1].equals("largedog") || input[1].equals("big")
							|| input[1].equals("bigdog")) {
						game.printMessage("You muster up the strength to fight the dog.");
						game.printMessage("It fights you off with ease.");
						game.changeHealth(-25);
					} else if (input[1].equals("self") || input[1].equals("myself") || input[1].equals("me")) {
						game.printMessage("You hit yourself in the stomach. It stings a little");
						game.changeHealth(-5);
					} else if (input[1].equals("dog")) {
						game.printMessage("Which dog?");
					} else {
						game.printMessage("What are you attacking?");
					}
				} else if (useBat) {
					if (input[1].equals("small") || input[1].equals("smalldog") || input[1].equals("little")
							|| input[1].equals("littledog") || input[1].equals("tinkles")) {
						game.printMessage("You are still holding the dog!");
					} else if (input[1].equals("large") || input[1].equals("largedog") || input[1].equals("big")
							|| input[1].equals("bigdog")) {
						game.printMessage(
								"You close your eyes and start swinging wildly in the large\ndog's direction");
						game.printMessage("When you open your eyes, you realize you are nowhere near\n the dog.");
						game.printMessage("The large dog look excited by your swinging.");
					} else if (input[1].equals("self") || input[1].equals("myself") || input[1].equals("me")) {
						game.printMessage("You give yourself a nice bump on the head with the bat.");
						game.changeHealth(-25);
					} else if (input[1].equals("dog")) {
						game.printMessage("Which dog?");
					} else {
						game.printMessage("What are you attacking?");
					}
				}

			} else {
				if (input[1].equals("self") || input[1].equals("myself") || input[1].equals("me")
						|| input[2].equals("dog")) {
					game.printMessage("With what?");
				} else if (input[1].equals("dog")) {
					game.printMessage("Which dog?");
				} else {
					game.printMessage("What are you attacking?");
				}
			}
		} catch (ArrayIndexOutOfBoundsException er) {
			if (input[1].equals("self") || input[1].equals("myself") || input[1].equals("me")
					|| input[2].equals("dog")) {
				game.printMessage("With what?");
			} else if (input[1].equals("dog")) {
				game.printMessage("Which dog?");
			} else {
				game.printMessage("What are you attacking?");
			}
		}

	}

	public void drop() {
		try {
			if ((input.length == 5
					|| input.length == 4 && input[0].equals("let") && input[1].equals("go") && input[2].equals("of"))
					|| (input.length == 4 || input.length == 3 && input[0].equals("put") && input[1].equals("down"))
					|| (input.length == 3 || input.length == 2 && input[0].equals("drop"))) {

				if (input[input.length - 2].equals("small") || input[input.length - 2].equals("little")
						|| input[input.length - 1].equals("smalldog") || input[input.length - 1].equals("littledog")
						|| input[input.length - 1].equals("tinkles")) {
					if (hasDog) {
						game.printMessage("You would rather let it rest.");
					} else {
						game.printMessage("You don't have any dogs.");
					}
				} else if (input[input.length - 1].equals("bat") || input[input.length - 1].equals("baseballbat")) {
					if (hasBat) {
						game.printMessage("You place the bat on the ground and give it a pat.");
						String removeInv = game.HUD.getText();
						game.HUD.setText(removeInv.replaceAll("\n-Baseball Bat", ""));
						hasBat = false;
					} else {
						game.printMessage("You don't have a bat.");
					}
				} else {
					game.printMessage("You are not holding that.");
				}
			} else {
				game.printMessage("You cannot drop that.");
			}
		} catch (ArrayIndexOutOfBoundsException er) {
			game.printMessage("You cannot do that.");
		}
	}

	public void toss() {
		try {
			if (input[input.length - 1].equals("smalldog") || input[input.length - 1].equals("littledog")
					|| input[input.length - 1].equals("tinkles") || input[input.length - 2].equals("small")
					|| input[input.length - 2].equals("little")) {
				if (hasDog) {
					game.printMessage("You throw the small dog.");
					game.printMessage("She flies back to you like a boomerang.");
				} else {
					game.printMessage("You don't have a dog.");
				}
			} else if (input[input.length - 1].equals("bat") || input[input.length - 1].equals("baseballbat")) {
				if (hasBat) {
					game.printMessage("You throw the bat.");
					game.printMessage("Suddenly, the large dog jump up and chases it!");
					game.printMessage("The door is not being guarded any more!");
					String removeInv = game.HUD.getText();
					game.HUD.setText(removeInv.replaceAll("\n-Baseball Bat", ""));
					hasBat = false;
					dogDistracted = true;
				} else {
					game.printMessage("You don't have a bat.");
				}
			} else if (input[input.length - 1].equals("self") || input[input.length - 1].equals("myself")
					|| input[input.length - 1].equals("me")) {
				game.printMessage("You throw yourself on to the floor");
				game.printMessage("The large dog takes this opportunity to eat you.");
				game.changeHealth(-100);
			} else if (input[input.length - 1].equals("dog") && !input[input.length - 2].equals("large")) {
				game.printMessage("Which dog?");
			} else {
				game.printMessage("You cannot throw that.");
			}
		} catch (ArrayIndexOutOfBoundsException er) {
			game.printMessage("What are you throwing?");
		}
	}

	public void open() {
		try {
			if (input.length == 2 && input[1].equals("door")) {
				if (doorOpen) {
					game.printMessage("The door is already open!");
				} else if (dogDistracted) {
					game.printMessage("The door is now opened");
					doorOpen = true;
				} else {
					game.printMessage("There is a dog in the way.");
				}
			} else {
				game.printMessage("You can't open that.");
			}
		} catch (ArrayIndexOutOfBoundsException er) {
			game.printMessage("What are you opening?");
		}

	}

	public void enter() {
		try {
			if (input.length == 2 && input[0].equals("enter") || (input.length == 3 && input[0].equals("go"))) {
				if (input[input.length - 1].equals("door")) {
					if (doorOpen && dogDistracted) {
						game.printMessage("You go through the door!\n");
						game.printMessage("-------------------");
						game.printMessage("YOU HAVE ESCAPED!!!");
						game.printMessage("-------------------");
						game.userInput.setEnabled(false);
						while (true) {
						}
					} else if (!dogDistracted) {
						game.printMessage("There is a dog in the way.");
					} else {
						game.printMessage("You run into the closed door like an idiot.");
						game.changeHealth(-10);
					}
				} else {
					game.printMessage("You cannot go through that.");
				}
			} else {
				game.printMessage("You cannot go through that.");
			}
		} catch (ArrayIndexOutOfBoundsException er) {
			game.printMessage("What are you entering?");
		}
	}

	public void close() {
		try {
			if (input.length == 2 && input[1].equals("door")) {
				if (doorOpen) {
					game.printMessage("You close the door... for some reason.");
					doorOpen = false;
				} else {
					game.printMessage("The door is already closed.");
				}
			} else {
				game.printMessage("You cannot close that.");
			}
		} catch (ArrayIndexOutOfBoundsException er) {
			game.printMessage("What are you opening?");
		}
	}

	public void give() {
		try {
			if (((input[1].equals("smalldog") || (input[1].equals("small") && input[2].equals("dog"))
					|| input[1].equals("littledog") || (input[1].equals("little") && input[2].equals("dog"))
					|| input[1].equals("tinkles")))) {
				if ((input[2].equals("to") ^ input[3].equals("to"))) {
					if (input.length <= 6
							&& (input[input.length - 2].equals("large") && input[input.length - 1].equals("dog"))
							|| input[input.length - 1].equals("largedog") || input[input.length - 1].equals("bigdog")) {
						if (hasDog) {
							game.printMessage("You place the small dog in front of the larger one.");
							game.printMessage("They sniff each other for a minute, then suddenly turn on you!");
							game.printMessage("The dogs have teamed up to defeat you!");
							game.HUD.setText(game.HUD.getText().replaceAll("-Small Dog", "none"));
							game.changeHealth(-100);
						} else {
							game.printMessage("You don't have a dog!");
						}
					} else {
						game.printMessage("You cannot give that to that.");
					}
				} else {
					game.printMessage("What are you giving to?");
				}
			} else {
				game.printMessage("You cannot give that.");
			}
		} catch (ArrayIndexOutOfBoundsException er) {
			game.printMessage("What are you giving to?");
		}
	}

}
