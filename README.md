# Event Booking System

A simple Java console application for managing events and attendees.

## Dependencies

- JUnit 5 (`org.junit.jupiter:junit-jupiter:5.10.2`) — pulled from Maven Central via `pom.xml`.
- Maven Surefire Plugin (`org.apache.maven.plugins:maven-surefire-plugin`) used to run tests in CI.

## Features

- Create events with a name and capacity
- Add attendees to events
- Prevent duplicate attendees (by email)
- Enforce event capacity limits
- Remove attendees from events
- Search for events by name

## Tech Stack

- Java
- Maven
- JUnit 5

## Project Structure

- `Event` - Handles event data and attendee logic
- `Attendee` - Represents a person attending an event
- `EventService` - Stores and manages events
- `Main` - Console menu system

## How to Run

1. Clone the repository
2. Open in IntelliJ
3. Run `Main.java`

## Tests

The project includes 10 JUnit tests.
- **TestAddAttendee:** Validates adding a single attendee succeeds.
- **TestDuplicateAttendee:** Ensures duplicate registrations (same email) are rejected.
- **TestCapacity:** Verifies the event enforces capacity limits.
- **TestRemoveAttendee:** Confirms removing an existing attendee succeeds.
- **TestRemoveAttendeeNotFound:** Removing a non-existent attendee returns false.
- **TestFindEventByName:** Finds an event previously added to the service.
- **TestFindEventByNameNotFound:** Searching for a missing event returns null.
- **TestGetEventName:** Validates the event name getter.
- **TestAttendeeListSizeAfterAddAttendee:** Ensures attendee list size increases after add.
- **TestAttendeeListSizeAfterRemove:** Ensures attendee list size decreases after remove.
Run tests with:

```bash
mvn test
```

## Clean Code Examples

Here are three examples from this project showing clean code practices:

- **Single Responsibility:** `Event` encapsulates event data and attendee management in one place. See [src/main/java/com/keyin/Event.java](src/main/java/com/keyin/Event.java) for the implementation.

- **Meaningful Names:** Methods like `addAttendee()` and `removeAttendee()` clearly express intent; class names `Event`, `Attendee`, and `EventService` are domain-focused. See [src/main/java/com/keyin/EventService.java](src/main/java/com/keyin/EventService.java).

- **Small, testable methods / explicit return values:** `addAttendee()` returns a `boolean` to indicate success/failure rather than throwing for expected business conditions, making behavior easier to test. See [src/main/java/com/keyin/Event.java](src/main/java/com/keyin/Event.java).

## GitHub Actions

- Added after inital commit
- https://github.com/pureboost/DO-SDAT-QAP1/actions/workflows/maven.yml


## Branching & PR Evidence

1. Create a feature branch locally and push it: `git checkout -b feature/add-tests` then `git push -u origin feature/add-tests`.
2. Open a Pull Request on GitHub targeting `main` and merge via the PR flow.
3. Add screenshots or links to the merged PR(s) here with a short note. Example:

- **PR:** screenshot: `screenshots/pr.png`
- **BRANCH:** screenshot: `screenshots/branch.png`