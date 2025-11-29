Word
====

Word is a lightweight Wordle-style playground used to experiment with SOLID design, interface-driven architecture, and encapsulation. Gameplay stays intentionally minimal so the emphasis remains on the component boundaries and the way 
responsibilities are split.

Implementation Highlights
-------------------------
- Domain core: `Word`, `GuessResult`, and `LetterHint` capture the rules and enable deterministic hint calculation.
- Orchestration: `Game` manages state, `GameEngine` coordinates validation and hinting, and `GameController` ties UI to the engine.
- Dependency seams: the `Dictionary` interface plus `WordSelector` and `HintCalculator` abstractions let you swap sources and strategies.
- Configuration: `GameFactory` wires dependencies so the bootstrapper (`Main`) simply composes objects.
- Presentation: `GameUI` hides the console implementation; alternate UIs can bind to the controller with no domain changes.

Project Layout
--------------
```
src/main/java/org/word
├── Main.java                 // Bootstrap wiring for the default console game
├── config/GameConfig.java    // Tunable constants (word format, attempt limit, etc.)
├── config/GameFactory.java   // Builds Game + GameEngine instances
├── dictionary/*              // Dictionary abstraction + concrete sources
├── game/*                    // Game state, engine, and controller
├── ui/*                      // Console UI implementation
└── word/*                    // Domain objects (Word, hints, calculators, selectors)
```

Build & Run
-----------
1. Install Java 22 and Maven 3.9+.
2. Clone the repository and move into the project root.
3. Build everything with:
   ```
   mvn clean package
   ```
4. Run the console UI:
   ```
   java -cp target/guess-1.0-SNAPSHOT.jar org.word.Main
   ```

Extending the Playground
------------------------
- **Custom dictionaries:** Implement `Dictionary` or tweak `DictionaryFromFile` to load text files, databases, or APIs.
- **Different hint logic:** Provide your own `HintCalculator` if you want alternate scoring rules.
- **New UIs:** Swap out `ConsoleGameUI` for a GUI or web front-end; only the `GameUI` interface needs to be satisfied.
- **Game variations:** `GameConfig` centralizes limits such as word length and guess count to make rule changes easy.

Testing
-------
JUnit 5 and Mockito are configured in `pom.xml`. Place unit tests under `src/test/java` and execute them with:
```
mvn test
```
This space intentionally leaves plenty of room to add tests around the dictionary, hint calculator, controllers, or any experiments you create.

Next Steps
----------
The project is purposely small to keep experiments focused. Potential follow-ups include persisting game history, exploring dependency injection frameworks (e.g., Dagger or Spring) with the existing seams, or implementing alternative hint strategies (hard mode, adaptive scoring, etc.).

**README generated using Codex.