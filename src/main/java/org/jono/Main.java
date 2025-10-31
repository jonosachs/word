package org.jono;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Dictionary dict = new Dictionary("src/main/resources/words.txt");

        Target target = new Target(dict.getRandomWord());

        Game game = new Game(dict, );

    }
}