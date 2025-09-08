package com.mycompany.poeevents1;

import java.util.ArrayList;
import java.util.Scanner;

public class PoeEventS1 {
    static Scanner scanner = new Scanner(System.in);
    public static ArrayList<EventModel> eventList = new ArrayList<>();
    public static Event eventController = new Event();

    public static void main(String[] args) {
        System.out.println("\nCULTURAL EVENTS MANAGEMENT – 2025");
        System.out.println("**********************************");
        System.out.print("Enter (1) to launch or any other key to exit: ");
        String start = scanner.nextLine();

        if (!start.equals("1")) {
            System.out.println("Exiting application...");
            return;
        }

        while (true) {
            eventController.showMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    eventController.captureEvent(scanner);
                    break;
                case "2":
                    System.out.print("Enter the event ID to search: ");
                    String searchId = scanner.nextLine();
                    EventModel found = eventController.searchEventById(searchId);
                    if (found != null) {
                        System.out.println("\nEVENT ID: " + found.EventId);
                        System.out.println("EVENT NAME: " + found.EventName);
                        System.out.println("EVENT TYPE: " + found.EventType);
                        System.out.println("EVENT DATE: " + found.EventDate);
                        System.out.println("EVENT LOCATION: " + found.EventLocation);
                    } else {
                        System.out.println("Event with ID: " + searchId + " not found!");
                    }
                    break;
                case "3":
                    System.out.print("Enter the event ID to update: ");
                    String updateId = scanner.nextLine();
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new type: ");
                    String newType = scanner.nextLine();
                    System.out.print("Enter new date: ");
                    String newDate = scanner.nextLine();
                    System.out.print("Enter new location: ");
                    String newLocation = scanner.nextLine();

                    boolean updated = eventController.updateEventById(updateId, newName, newType, newDate, newLocation);
                    if (updated) {
                        System.out.println("Event updated successfully!");
                    } else {
                        System.out.println("Event ID not found!");
                    }
                    break;
                case "4":
                    System.out.print("Enter the event ID to delete: ");
                    String deleteId = scanner.nextLine();
                    boolean deleted = eventController.deleteEventById(deleteId);
                    if (deleted) {
                        System.out.println("Event with ID: " + deleteId + " deleted!");
                    } else {
                        System.out.println("Event ID not found!");
                    }
                    break;
                case "5":
                    eventController.printReport();
                    break;
                case "6":
                    System.out.println("Exiting application...");
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
