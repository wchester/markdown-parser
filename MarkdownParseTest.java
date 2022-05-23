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
        assertEquals(testArray, MarkdownParse.getLinks(content));
    }

    @Test
    public void parenteseTest() throws IOException{
        Path fileName = Path.of("test_make_fail.md");
        String content = Files.readString(fileName);
        ArrayList testArray = new ArrayList<>(2);
        testArray.add("https://something.com");
        assertEquals(testArray, MarkdownParse.getLinks(content));
    }

    @Test
    public void writeup8Test1() throws IOException{
        Path fileName = Path.of("writeup8test1.md");
        String content = Files.readString(fileName);
        ArrayList testArray = new ArrayList<>(1);
        testArray.add("`google.com");
        assertEquals(testArray, MarkdownParse.getLinks(content));
    }

    @Test
    public void writeup8Test2() throws IOException{
        Path fileName = Path.of("writeup8test2.md");
        String content = Files.readString(fileName);
        ArrayList testArray = new ArrayList<>(3);
        testArray.add("a.com");
        testArray.add("a.com(())");
        testArray.add("example.com");
        assertEquals(testArray, MarkdownParse.getLinks(content));
    }

    @Test
    public void writeup8Test3() throws IOException{
        Path fileName = Path.of("writeup8test3.md");
        String content = Files.readString(fileName);
        ArrayList testArray = new ArrayList<>(1);
        testArray.add("https://sites.google.com/eng.ucsd.edu/cse-15l-spring-2022/schedule");
        assertEquals(testArray, MarkdownParse.getLinks(content));
    }
}