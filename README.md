# Word Guess Game

Compact Java 22/Maven project that implements the core mechanics of a Wordle-style guessing game. A secret target word is drawn from a five-letter dictionary, players make guesses, and each guess earns a per-letter hint indicating whether letters are correct, present elsewhere, or absent.

- **Language/Build:** Java 22, Maven
- **Key Types:** `Game`, `Guess`, `Target`, `Hint`, `WordsFromFile`
- **Dictionary:** Plain-text list of five-letter words (`src/main/resources/words.txt`)

## Features
- Enforces five-letter alpha-only words through the shared `Word` base class.
- Provides repeatable hint evaluation via `Hint` + `HintDto` using `Eval` (`CORRECT`, `PRESENT`, `INCORRECT`).
- Supplies a file-backed dictionary implementation (`WordsFromFile`) with duplicate filtering and basic validation.
- Includes JUnit 5 test coverage for dictionary loading, hint generation, targets, and overall game flow.

## Getting Started
### Prerequisites
- Java Development Kit (JDK) 22 or newer
- Apache Maven 3.9+ (comes bundled with most modern JDK distributions or install separately)

### Build & Run
```bash
mvn clean compile
mvn exec:java -Dexec.mainClass=org.jono.Main
```
`Main` demonstrates a hard-coded playthrough: it loads the dictionary, shows the masked target, submits a couple of guesses, then prints the hint history.

### Run Tests
```bash
mvn test
```
The suite exercises the dictionary loader, hint generation logic, and overall game state management.

## Project Layout
- `src/main/java/org/jono/` – game logic (`Game`, `Hint`, etc.) and dictionary implementation.
- `src/main/resources/words.txt` – default dictionary; replace or expand with any uppercase/lowercase five-letter words (one per line).
- `src/test/java/org/jono/` – JUnit tests covering core behavior.

### Extending
- Swap in additional `Dictionary` implementations (e.g., API-backed) by implementing the interface and injecting it into `Game`.
- Wrap `Game` in a CLI or GUI by iterating over guesses and converting `HintDto` results into your preferred UI.

---
_README written using Codex (GPT-5)._ 
