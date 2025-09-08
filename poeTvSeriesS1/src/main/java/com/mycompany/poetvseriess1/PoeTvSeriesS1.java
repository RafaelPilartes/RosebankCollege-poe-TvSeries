package com.mycompany.poetvseriess1;

import java.util.ArrayList;
import java.util.Scanner;

public class PoeTvSeriesS1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Series seriesController = new Series();

        // Tela inicial
        System.out.println("\nLATEST SERIES – 2025");
        System.out.println("*************************");
        System.out.print("Enter (1) to launch or any other key to exit: ");
        String start = scanner.nextLine();

        if (!start.equals("1")) {
            System.out.println("Exiting application...");
            return;
        }

        while (true) {
            seriesController.showMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    seriesController.captureSeries(scanner);
                    break;
                case "2":
                    System.out.print("Enter the series ID to search: ");
                    String searchId = scanner.nextLine();
                    SeriesModel found = seriesController.searchSeriesById(searchId);
                    if (found != null) {
                        System.out.println("\nSERIES ID: " + found.SeriesId);
                        System.out.println("SERIES NAME: " + found.SeriesName);
                        System.out.println("SERIES AGE RESTRICTION: " + found.SeriesAge);
                        System.out.println("SERIES NUMBER OF EPISODES: " + found.SeriesNumberOfEpisodes);
                    } else {
                        System.out.println("Series with Series ID: " + searchId + " was not found!");
                    }
                    break;
                case "3":
                    System.out.print("Enter the series ID to update: ");
                    String updateId = scanner.nextLine();
                    System.out.print("Enter the series name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter the series age restriction: ");
                    String newAge = scanner.nextLine();
                    System.out.print("Enter the number of episodes: ");
                    String newEpisodes = scanner.nextLine();

                    boolean updated = seriesController.updateSeriesById(updateId, newName, newAge, newEpisodes);
                    if (updated) {
                        System.out.println("Series updated successfully!");
                    } else {
                        System.out.println("Series ID not found!");
                    }
                    break;
                case "4":
                    System.out.print("Enter the series ID to delete: ");
                    String deleteId = scanner.nextLine();
                    boolean deleted = seriesController.deleteSeriesById(deleteId);
                    if (deleted) {
                        System.out.println("Series with Series ID: " + deleteId + " WAS deleted!");
                    } else {
                        System.out.println("Series ID not found!");
                    }
                    break;
                case "5":
                    seriesController.printReport();
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