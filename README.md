# Word

A small Java 22 project that explores the mechanics behind a Wordle-style word guessing game.  
The `Game` class selects a hidden five-letter word from a dictionary and evaluates each guess, returning per-letter hints that mark letters as correct (right letter, right place), present (right letter, wrong place), or incorrect.

## Requirements
- Java 22 or later
- Maven 3.9 or later

## Build
```bash
mvn package
```

## Run
The sample entry point in `org.jono.Main` plays two hard-coded guesses and prints the target word and the hint trail. Run it from the project root so the relative path to `src/main/resources/words.txt` resolves correctly:

```bash
java -cp target/guess-1.0-SNAPSHOT.jar org.jono.Main
```

Sample output (target word varies each run):

```
target: melon
[HintDto[letter=a, result=INCORRECT], HintDto[letter=p, result=PRESENT], HintDto[letter=p, result=INCORRECT], HintDto[letter=l, result=PRESENT], HintDto[letter=e, result=PRESENT]]
[HintDto[letter=m, result=CORRECT], HintDto[letter=e, result=CORRECT], HintDto[letter=l, result=CORRECT], HintDto[letter=o, result=CORRECT], HintDto[letter=n, result=CORRECT]]
```

## Project Layout
- `src/main/java/org/jono/`  
  Core game types:
  - `Game` orchestrates guesses and hint generation.
  - `Word`, `Guess`, and `Target` model immutable five-letter words.
  - `Hint` and `HintDto` compute per-character evaluations using `Eval`.
  - `Dictionary` abstracts word sources; `WordsFromFile` reads from a file.
- `src/main/resources/words.txt`  
  Default list of candidate target words, one per line.
- `pom.xml`  
  Minimal Maven descriptor targeting Java 22.

## Customising
- Replace or extend `src/main/resources/words.txt` with your own five-letter words.
- Wire in another `Dictionary` implementation (e.g., database, API) by passing it to `Game`.
- Build a user interface or CLI loop around `Game.submitGuess` to turn this into a playable experience.

## Other
This README was generated with Codex.