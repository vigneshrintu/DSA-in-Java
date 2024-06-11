package JavaCollections;

import java.util.HashMap;

public class HashMapExample {
    public static void main(String[] args) {
        // Creating a HashMap with String keys (country) and Integer values (population)
        HashMap<String, Integer> hp = new HashMap<>();
        
        // Adding key-value pairs to the HashMap
        hp.put("USA", 328_200_000);
        hp.put("China", 1_393_000_000);
        hp.put("India", 1_366_000_000);
        
        // Retrieving and printing the population of China
        Integer chinaPopulation = hp.get("China");//null is returned if the key is not found


        // Checking if the HashMap contains the key "India"
        boolean containsIndia = hp.containsKey("India");

        // Checking if the HashMap contains the key "Russia"
        boolean containsRussia = hp.containsKey("Russia");

        // Removing the key "USA" and printing the removed population
        Integer removedPopulation = hp.remove("USA");

        // Getting and printing the size of the HashMap
        int size = hp.size();

        // Iterating through the HashMap and printing each key-value pair
        System.out.println("Iterating through the HashMap:");
        for (String country : hp.keySet()) {
            Integer population = hp.get(country);
            System.out.println("Country: " + country + ", Population: " + population);
        }

        // Clearing the HashMap
        hp.clear();
        System.out.println("HashMap after clearing: " + hp);
    }
}

