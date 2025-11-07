## Word Guessing Playground

This project is a tiny Wordle-style playground I wrote mainly to experiment with encapsulation. Every concept in the game—dictionary access, the hidden target word, guesses, and hint evaluation—is wrapped in its own type so I could practice keeping responsibilities separated and data guarded behind clear APIs. The result is a lightweight core that can be driven from a CLI (see `ExampleMain`) or tested in isolation.

### Highlights
- **Encapsulated domain objects** – `Word` is the sealed base type, while `Guess` and `Target` specialize behavior (e.g., `Target` masks its value externally).
- **Isolated hint logic** – `Hint` consumes `Target` + `Guess` and produces immutable `HintDto` records with `Eval` results (`CORRECT`, `PRESENT`, `INCORRECT`), mirroring Wordle feedback.
- **Dictionary abstraction** – `Dictionary` powers the game; `WordsFromFile` is the current implementation that validates five-letter words from a file before exposing a random target.
- **Testable design** – Core behaviors are covered with JUnit/Mockito tests under `src/test/java/org/jono`, keeping experiments safe.

### Project Layout
```
src/
  main/
    java/org/jono/   # Game, Word hierarchy, hint logic, CLI example
    resources/       # Sample dictionary (words.txt)
  test/java/org/jono # Unit tests for core types
pom.xml              # Maven config (Java 22, JUnit 5)
```

### Run It
1. Build:
   ```bash
   mvn clean package
   ```
2. Use the demo entry point (after packaging, replace `app.jar` with your artifact name):
   ```bash
   java -cp target/guess-1.0-SNAPSHOT.jar org.jono.ExampleMain \
     --dict src/main/resources/words.txt \
     --guesses apple,melon
   ```
   Arguments:
   - `--dict/-d`: path to a newline-delimited list of five-letter words.
   - `--guesses/-g`: comma-separated guesses (up to five per game).
   - `--help/-h`: usage info.

`Main` is intentionally empty so I can wire the game into other front-ends later (CLI, GUI, or tests) without changing the core logic.

### Testing
```bash
mvn test
```
The suite covers dictionary loading, guess validation, hint evaluation, and the game controller to ensure the encapsulated components keep behaving as expected while I iterate.

### Next Ideas
1. Add a proper CLI/GUI front-end.
2. Support dependency injection for dictionary sources (e.g., remote APIs).
3. Track win/loss stats or persist completed games for later analysis.

*README written using Codex.