package com.keyin;

import java.util.ArrayList;
import java.util.List;

public class Event {

    private String eventName;
    private int capacity;
    private List<Attendee> attendees;

    public Event(String eventName, int capacity) {
        this.eventName = eventName;
        this.capacity = capacity;
        this.attendees = new ArrayList<>();
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Attendee> getAttendees() {
        return attendees;
    }

    public boolean addAttendee(Attendee attendee) {

        if (attendees.size() >= capacity) {
            return false;
        }

        for (Attendee a : attendees) {
            if (a.getEmail().equals(attendee.getEmail())) {
                return false;
            }
        }

        attendees.add(attendee);
        return true;
    }

    public boolean removeAttendee(Attendee attendee) {

        for (Attendee a : attendees) {
            if (a.getEmail().equals(attendee.getEmail())) {
                attendees.remove(a);
                return true;
            }
        }

        return false;
    }
}
