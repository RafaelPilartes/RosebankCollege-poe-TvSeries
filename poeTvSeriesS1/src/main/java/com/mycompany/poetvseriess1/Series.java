package com.mycompany.poetvseriess1;

import java.util.ArrayList;
import java.util.Scanner;

public class Series {
    static ArrayList<SeriesModel> seriesList = new ArrayList<>();

    // Show the menu
    public static void showMenu() {
        System.out.println("(1) Capture a new series");
        System.out.println("(2) Search for a series");
        System.out.println("(3) Update series age restriction");
        System.out.println("(4) Delete a series");
        System.out.println("(5) Print series report – 2025");
        System.out.println("(6) Exit Application");
        System.out.print("Enter your choice: ");
    }

    // Validate age (use in capture/update)
    public static boolean isValidAge(String ageInput) {
        try {
            int age = Integer.parseInt(ageInput);
            return age >= 2 && age <= 18;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Capture new series
    public void captureSeries(Scanner scanner) {
        SeriesModel series = new SeriesModel();

        System.out.println("\n CAPTURE A NEW SERIES");
        System.out.println("*************************");
        System.out.print("Enter the series ID: ");
        series.SeriesId = scanner.nextLine();

        System.out.print("Enter the series name: ");
        series.SeriesName = scanner.nextLine();

        System.out.print("Enter the series age restriction: ");
        
        while (true) {
            String ageInput = scanner.nextLine();

            try {
                if (isValidAge(ageInput)) {
                    series.SeriesAge = ageInput;
                    break;
                } else {
                    System.out.println("You have entered an incorrect series age!!!");
                    System.out.print("Re-enter the series age: ");    

                }
            } catch (NumberFormatException e) {
                System.out.println("You have entered a non-number series age!!!");
            }
        }

        System.out.print("Enter the number of episodes: ");
        series.SeriesNumberOfEpisodes = scanner.nextLine();

        seriesList.add(series);
        System.out.println("Series processed successfully!!");
    }

    public static SeriesModel searchSeriesById(String id) {
        for (SeriesModel series : seriesList) {
            if (series.SeriesId.equals(id)) {
                return series;
            }
        }
        return null;
    }

    public static boolean updateSeriesById(String id, String newName, String newAge, String newEpisodes) {
        for (SeriesModel series : seriesList) {
            if (series.SeriesId.equals(id)) {
                series.SeriesName = newName;
                series.SeriesAge = newAge;
                series.SeriesNumberOfEpisodes = newEpisodes;
                return true;
            }
        }
        return false;
    }

    public static boolean deleteSeriesById(String id) {
        for (SeriesModel series : seriesList) {
            if (series.SeriesId.equals(id)) {
                seriesList.remove(series);
                return true;
            }
        }
        return false;
    }

    // Report
    public void printReport() {
        System.out.println("\nSeries Report – 2025");
        System.out.println("==========================");

        if (seriesList.isEmpty()) {
            System.out.println("No series have been added.");
        } else {
            for (SeriesModel series : seriesList) {
                System.out.println("\nSeries: " + series.SeriesId);
                System.out.println("---------------------");
                System.out.println("ID: " + series.SeriesId);
                System.out.println("Name: " + series.SeriesName);
                System.out.println("Age: " + series.SeriesAge);
                System.out.println("Episodes: " + series.SeriesNumberOfEpisodes);
                System.out.println("---------------------");
            }
        }
    }
}
