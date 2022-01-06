#Mancala/Kalaha Game REST application

### What the app does ?
This app exposes REST endpoint for the client to connect and display the mancala board.
The number of pits & stones are configurable

### Idealogy !
This uses Chain of Responsibility Design pattern to execute game rules sequentially.
For simplicity player state management is done in client/browser side.

For now this uses 3 main rules for the playthrough. This pattern allows any new potential rule without affecting the existing rule scope

### Requirements
- JDK 11 or above

### Running the application:
1. Clone and perform `mvn clean install`(maven 3+)
2. Start application `mvn spring-boot:run` or use Intellij's spring boot run configuration
3. Application runs at default 8080 port. Check by accessing `/load` endpoint to fetch initial board setting

Clone and run the client side/Angular app to play the game using this endpoint for rules.

### Application structure
```
├───src
│   ├───main
│   │   ├───java
│   │   │   └───mancala
│   │   │        ├───constants  # Application constants
│   │   │        ├───controller # Rest Controllers for the app
│   │   │        ├───model      # Domain model
│   │   │        ├───rules      # Game rules are specified here
│   │   │        ├───service    # Game rule engine along with rules orderering
│   │   │        └───util       # Static util which application might need
│   │   └───resources
│   │       ├───static
│   │       └───templates

```
