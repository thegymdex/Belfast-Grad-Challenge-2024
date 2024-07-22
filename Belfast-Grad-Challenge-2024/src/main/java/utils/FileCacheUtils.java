package main.java.utils;

import java.io.*;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class FileCacheUtils {

    private static final String filePath = "./data/primes.txt";

    // method to load file data into cache
    public static boolean loadFileData(TreeSet<Integer> primeList) {

        // Check if the file exists
        File file = new File(filePath);

        if (!file.exists()) {
            System.out.println("ERROR - File cannot be read from as it does not exist!" );
            return false;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                int number = Integer.parseInt(line);
                primeList.add(number);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    // method to write cache data into file
    public static boolean writeFileData (TreeSet<Integer> primeList) {

        // using try-with resources I learned from placement
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (int element : primeList) {
                System.out.println(element);
                bw.write(Integer.toString(element));
                bw.newLine();
            }
        }
        catch (IOException ex) {
            System.out.println("ERROR - " + ex);
            return false;
        }
        return true;
    }

    // method to format the output of cache
    public static String formatOutput (TreeSet<Integer> primeList) {

        // starting to learn streams - wanted to give it a go!
        return primeList.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(", ", "Contents of Cache: ", ""));
    }
}
