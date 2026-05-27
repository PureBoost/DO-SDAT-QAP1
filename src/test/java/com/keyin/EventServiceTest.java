package com.keyin;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EventServiceTest {

    @Test
    public void TestAddAttendee() {

        Event event = new Event("Concert", 2);

        boolean result = event.addAttendee(new Attendee("John Doe", "JohnDoe@example.com"));

        assertTrue(result);
    }

    @Test
    public void TestDuplicateAttendee() {

        Event event = new Event("Movie", 2);

        event.addAttendee(new Attendee("John Doe", "JohnDoe@example.com"));
        boolean result = event.addAttendee(new Attendee("John Doe", "JohnDoe@example.com"));

        assertFalse(result);
    }

    @Test
    public void TestCapacity() {

        Event event = new Event("Play", 2);

        event.addAttendee(new Attendee("John Doe", "JohnDoe@example.com"));
        event.addAttendee(new Attendee("Jane Doe", "JaneDoe@example.com"));
        boolean result = event.addAttendee(new Attendee("Bob Doe", "BobDoe@example.com"));

        assertFalse(result);
    }

    @Test
    public void TestRemoveAttendee() {

        Event event = new Event("Concert", 2);

        Attendee attendee = new Attendee("John Doe", "JohnDoe@example.com");

        event.addAttendee(attendee);

        boolean result = event.removeAttendee(attendee);

        assertTrue(result);
    }

    @Test
    public void TestRemoveAttendeeNotFound() {

        Event event = new Event("Concert", 2);

        Attendee attendee = new Attendee("John Doe", "JohnDoe@example.com");

        boolean result = event.removeAttendee(attendee);

        assertFalse(result);
    }

    @Test
    public void TestFindEventByName() {

        EventService service = new EventService();

        Event event = new Event("Concert", 2);

        service.addEvent(event);

        Event result = service.findEventByName("Concert");

        assertEquals(event, result);
    }

    @Test
    public void TestFindEventByNameNotFound() {

        EventService service = new EventService();

        Event result = service.findEventByName("Fake Event");

        assertNull(result);
    }

    @Test
    public void TestGetEventName() {

        Event event = new Event("Concert", 2);

        assertEquals("Concert", event.getEventName());
    }

    @Test
    public void TestAttendeeListSizeAfterAddAttendee() {

        Event event = new Event("Concert", 2);

        event.addAttendee(new Attendee("John", "john@example.com"));

        assertEquals(1, event.getAttendees().size());
    }

    @Test
    public void TestAttendeeListSizeAfterRemove() {

        Event event = new Event("Concert", 2);

        Attendee attendee = new Attendee("John", "john@example.com");

        event.addAttendee(attendee);

        event.removeAttendee(attendee);

        assertEquals(0, event.getAttendees().size());
    }
}
