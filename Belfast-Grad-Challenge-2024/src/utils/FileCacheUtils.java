package utils;

import java.util.TreeSet;
import java.util.stream.Collectors;

public class FileCacheUtils {

    private String filePath = "./data/";

    // method to load file data into cache
    public static boolean loadFileData(TreeSet<Integer> primeList) {
        // read file path
        // load string
        return true;
    }

    // method to write cache data into file
    public static boolean writeFileData (TreeSet<Integer> primeList) {
        // read file path
        // return true if successful false if not
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
