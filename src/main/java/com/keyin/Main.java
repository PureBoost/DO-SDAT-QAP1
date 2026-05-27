package com.keyin;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        EventService eventService = new EventService();

        while (true){

            System.out.println("--- Event Booking System ---");
            System.out.println("1. Create Event");
            System.out.println("2. Add Attendee");
            System.out.println("3. Remove Attendee");
            System.out.println("4. View Events");
            System.out.println("5. Exit");
            System.out.println("Enter your choice: ");

            int choice = input.nextInt();
            input.nextLine();

            System.out.println();

            if (choice == 1){

                System.out.println("Please enter the name of the event you want to create: ");
                String name = input.nextLine();

                System.out.println("Please enter the capacity of the event: ");
                int capacity = input.nextInt();
                input.nextLine();

                Event event = new Event(name, capacity);
                eventService.addEvent(event);

                System.out.println("Event created successfully!");
            }

            else if (choice == 2) {

                System.out.println("Please enter the name of the attendee you want to add: ");
                String name = input.nextLine();

                System.out.println("Please enter the email of the attendee: ");
                String email = input.nextLine();

                System.out.println("Please enter the name of the event: ");
                String eventName = input.nextLine();

                Attendee attendee = new Attendee(name, email);

                Event event = eventService.findEventByName(eventName);

                if (event != null) {

                    boolean result = event.addAttendee(attendee);

                    if (result) {
                        System.out.println("Attendee added successfully!");
                    }
                    else {
                        System.out.println("Event full or duplicate attendee.");
                    }

                }
                else {
                    System.out.println("Event not found!");
                }
            }

            else if (choice == 3){

                System.out.println("Please enter the name of the event: ");
                String eventName = input.nextLine();

                Event event = eventService.findEventByName(eventName);

                if (event != null) {

                    System.out.println("Enter the email of the attendee you want to remove: ");
                    String attendeeEmail = input.nextLine();

                    Attendee temp = new Attendee("", attendeeEmail);

                    boolean result = event.removeAttendee(temp);

                    if (result) {
                        System.out.println("Attendee removed successfully!");
                    }
                    else {
                        System.out.println("Attendee not found!");
                    }

                }
                else {
                    System.out.println("Event not found!");
                }
            }

            else if (choice == 4) {

                for (Event event : eventService.getEvents()) {

                    System.out.println("Event: " + event.getEventName());

                    for (Attendee attendee : event.getAttendees()) {
                        System.out.println("- " + attendee.getName());
                    }

                    System.out.println();
                }
            }

            else if (choice == 5){
                System.out.println("Bye!");
                break;
            }

            else {
                System.out.println("Invalid choice!");
            }

            System.out.println();
        }

        input.close();
    }
}
