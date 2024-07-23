package test.java.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import main.java.utils.FileCacheUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.TreeSet;

public class FileCacheUtilsTest {

    private static final String FILE_PATH = "./test-data/primes.txt";
    private File tempFile;
    private TreeSet<Integer> primeList;

    @Before
    public void setUp() throws IOException {
        // Create a directory for test files
        File dir = new File("./test-data");
        if (!dir.exists()) {
            dir.mkdirs();
        }

        // Create a temporary file for testing
        tempFile = new File(FILE_PATH);
        if (tempFile.exists()) {
            tempFile.delete(); // Ensure the file does not already exist
        }

        // Set the file path in FileCacheUtils
        FileCacheUtils.filePath = tempFile.getPath();

        // Initialize the primeList
        primeList = new TreeSet<>();
    }

    @After
    public void tearDown() {
        // Delete the temporary file after tests
        if (tempFile.exists()) {
            tempFile.delete();
        }
    }

    @Test
    public void testLoadFileData() throws IOException {
        // Prepare test data
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile))) {
            bw.write("2\n3\n5\n7\n");
        }

        // Load data into primeList
        boolean result = FileCacheUtils.loadFileData(primeList);

        // Verify the result
        assertTrue(result);
        assertEquals(4, primeList.size());
        assertTrue(primeList.contains(2));
        assertTrue(primeList.contains(3));
        assertTrue(primeList.contains(5));
        assertTrue(primeList.contains(7));
    }

    @Test
    public void testWriteFileData() throws IOException {
        // Prepare test data
        primeList.add(2);
        primeList.add(3);
        primeList.add(5);
        primeList.add(7);

        // Write data to file
        boolean result = FileCacheUtils.writeFileData(primeList);

        // Verify the result
        assertTrue(result);

        // Read back the data from the file
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(tempFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                contentBuilder.append(line).append("\n");
            }
        }

        // Verify the content
        String content = contentBuilder.toString();
        assertEquals("2\n3\n5\n7\n", content);
    }

    @Test
    public void testFormatOutput() {
        // Prepare test data
        primeList.add(2);
        primeList.add(3);
        primeList.add(5);
        primeList.add(7);

        // Get formatted output
        String result = FileCacheUtils.formatOutput(primeList);

        // Verify the result
        assertEquals("Contents of Cache: 2, 3, 5, 7", result);
    }
}
