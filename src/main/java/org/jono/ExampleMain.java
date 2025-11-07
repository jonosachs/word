package org.jono;


public class ExampleMain {
    public static void main(String[] args) {
        String dictPath = null;
        String guesses = null;

        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "--dict", "-d" -> dictPath = args[++i];
                case "--guesses", "-g" -> guesses = args[++i];
                case "--help", "-h" -> { printHelp(); return; }
                default -> System.out.println("Unknown option: " + args[i]);
            }
        }

        if (dictPath == null || guesses == null) {
            System.out.println("Missing arguments");
            return;
        }

        String[] guessesSplit = guesses.split(",");

        Game game = new Game(new WordsFromFile(dictPath));

        for  (String guess : guessesSplit) {
            game.submitGuess(guess);
        }

        System.out.print("\nTarget: ");
        System.out.println(game.getTarget());

        System.out.print("\nGuesses: ");
        System.out.println(game.getGuesses());

        System.out.println("\nHints:");
        for (int i = 0; i < game.getHintsHistory().size(); i++) {
            System.out.println(i+1 + " " + game.getHintByIndex(i));
        }
    };

    private static void printHelp() {
        System.out.println("""
                Usage:
                    java -jar app.jar --dict <path> --guesses apple,melon
                
                Options:
                    --dict, -d       Path to dictionary
                    --guesses, -g    Comma-separated guesses (up to 5)
                    --help, -h       Show help
                
                """);
    }




}
