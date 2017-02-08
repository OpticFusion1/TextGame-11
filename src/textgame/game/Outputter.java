package textgame.game;

public final class Outputter {
	public static void writeln(String output) {
		System.out.println(output);
	}

	public static void write(String output) {
		System.out.print(output);
	}
	
	public static void showValidCommands() {
		System.out.println("Valid commands are 'show', 'go', 'talk', 'inspect', 'give', 'take', 'pick'");
	}
}
