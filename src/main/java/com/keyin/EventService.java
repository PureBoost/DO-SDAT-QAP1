package com.keyin;

import java.util.ArrayList;
import java.util.List;

public class EventService {
    private List<Event> events = new ArrayList<>();

    public void addEvent(Event event) {
        events.add(event);
    }

    public Event findEventByName(String name) {

        for (Event event : events) {
            if (event.getEventName().equals(name)) {
                return event;
            }
        }

        return null;
    }

    public List<Event> getEvents() {
        return events;
    }
}
