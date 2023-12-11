import org.example.Main;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testProcessJsonFile() {
        String inputFileName = "src/inputoutput/input_file.json";
        String outputFileName = "output.json";

        try {
            Main.main(new String[]{inputFileName, outputFileName});
        } catch (Exception e) {
            e.printStackTrace();
            fail("Exception occurred: " + e.getMessage());
        }
    }

    @Test
    void testProcessCsvFile() {
        // Assuming you have a test.csv file for testing
        String inputFileName = "src/inputoutput/input_file-1.csv";
        String outputFileName = "output.csv";

        assertDoesNotThrow(() -> Main.main(new String[]{inputFileName, outputFileName}));
        // Add additional assertions if needed
    }

    @Test
    void testProcessXmlFile() {
        // Assuming you have a test.xml file for testing
        String inputFileName = "src/inputoutput/input_file.xml";
        String outputFileName = "output.xml";

        assertDoesNotThrow(() -> Main.main(new String[]{inputFileName, outputFileName}));
        // Add additional assertions if needed
    }

    @Test
    void testUnsupportedFileFormat() {
        // Assuming you have a test.txt file for testing
        String inputFileName = "src/inputoutput/text.txt";
        String outputFileName = "output.txt";

        assertDoesNotThrow(() -> Main.main(new String[]{inputFileName, outputFileName}));
        // Add additional assertions if needed
    }
}
