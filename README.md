# Event Booking System

A simple Java console application for managing events and attendees.

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

The project includes 10 JUnit tests. Run tests with:

```bash
mvn test
```