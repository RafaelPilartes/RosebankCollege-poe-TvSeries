package com.mycompany.poeevents1;

import java.util.ArrayList;
import java.util.Scanner;

public class Event {
    static ArrayList<EventModel> eventList = new ArrayList<>();
    
    // ---- Métodos auxiliares ---- //
    public static EventModel searchEventById(String id) {
        for (EventModel event : eventList) {
            if (event.EventId.equals(id)) {
                return event;
            }
        }
        return null;
    }

    public static boolean updateEventById(String id, String name, String type, String date, String location) {
        for (EventModel event : eventList) {
            if (event.EventId.equals(id)) {
                event.EventName = name;
                event.EventType = type;
                event.EventDate = date;
                event.EventLocation = location;
                return true;
            }
        }
        return false;
    }

    public static boolean deleteEventById(String id) {
        for (EventModel event : eventList) {
            if (event.EventId.equals(id)) {
                eventList.remove(event);
                return true;
            }
        }
        return false;
    }

    // ---- Interação ---- //
    public static void showMenu() {
        System.out.println("\nCULTURAL EVENTS – 2025");
        System.out.println("(1) Capture a new event");
        System.out.println("(2) Search for an event");
        System.out.println("(3) Update an event");
        System.out.println("(4) Delete an event");
        System.out.println("(5) Print events report");
        System.out.println("(6) Exit Application");
        System.out.print("Enter your choice: ");
    }

    public static void captureEvent(Scanner scanner) {
        EventModel event = new EventModel();

        System.out.print("Enter the event ID: ");
        event.EventId = scanner.nextLine();

        System.out.print("Enter the event name: ");
        event.EventName = scanner.nextLine();

        System.out.print("Enter the event type: ");
        event.EventType = scanner.nextLine();

        System.out.print("Enter the event date: ");
        event.EventDate = scanner.nextLine();

        System.out.print("Enter the event location: ");
        event.EventLocation = scanner.nextLine();

        eventList.add(event);
        System.out.println("Event registered successfully!");
    }

    public static void printReport() {
        System.out.println("\nCultural Events Report – 2025");
        System.out.println("===================================");

        if (eventList.isEmpty()) {
            System.out.println("No events registered.");
        } else {
            for (EventModel event : eventList) {
                System.out.println("ID: " + event.EventId);
                System.out.println("Name: " + event.EventName);
                System.out.println("Type: " + event.EventType);
                System.out.println("Date: " + event.EventDate);
                System.out.println("Location: " + event.EventLocation);
                System.out.println("-----------------------------------");
            }
        }
    }
}
