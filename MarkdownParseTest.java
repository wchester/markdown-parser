import static org.junit.Assert.*;
import org.junit.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void linkTest() throws IOException{
        Path fileName = Path.of("test-file.md");
        String content = Files.readString(fileName);
        ArrayList testArray = new ArrayList<>(2);
        ArrayList failArray = new ArrayList<>();
        testArray.add("https://something.com");
        testArray.add("some-thing.html");
        assertEquals(failArray, MarkdownParse.getLinks(content));
    }
}