import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.ArrayList;

import org.junit.*;

public class MarkdownParseTest1 {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    } 

    @Test
    public void LinksTest() throws IOException{
        String fileContent = Files.readString(Path.of("./test-file.md"));
        assertEquals(List.of("https://something.com", "some-thing.html"), MarkdownParse1.getLinks(fileContent));
    }

    @Test
    public void Links2Test() throws IOException{
        String fileContent = Files.readString(Path.of("./2test.md"));
        assertEquals(List.of("https://google.com", "bruh.com"), MarkdownParse1.getLinks(fileContent));
    }

    @Test
    public void Links3Test() throws IOException{
        String fileContent = Files.readString(Path.of("./3test.md"));
        assertEquals(List.of("youtube.com"), MarkdownParse1.getLinks(fileContent));
    }

    @Test
    public void Links4Test() throws IOException{
        String fileContent = Files.readString(Path.of("./4test.md"));
        assertEquals(List.of("bruhmoment.com"), MarkdownParse1.getLinks(fileContent));
    }
    
    @Test
    public void File1Test() throws IOException{
        String fileContent = Files.readString(Path.of("./test-file.md"));
        assertEquals(List.of("https://something.com", "some-thing.html"), MarkdownParse1.getLinks(fileContent));
    }
    
    @Test
    public void File2Test() throws IOException{
        String fileContent = Files.readString(Path.of("./test-file2.md"));
        assertEquals(List.of("https://something.com", "some-page.html"), MarkdownParse1.getLinks(fileContent));
    }
    @Test
    public void File3Test() throws IOException{
        String fileContent = Files.readString(Path.of("./test-file3.md"));
        assertEquals(List.of(), MarkdownParse1.getLinks(fileContent));
    }
    @Test
    public void File4est() throws IOException{
        String fileContent = Files.readString(Path.of("./test-file4.md"));
        assertEquals(List.of(), MarkdownParse1.getLinks(fileContent));
    }
    @Test
    public void File5Test() throws IOException{
        String fileContent = Files.readString(Path.of("./test-file5.md"));
        assertEquals(List.of(), MarkdownParse1.getLinks(fileContent));
    }
    
    @Test
    public void File6Test() throws IOException{
        String fileContent = Files.readString(Path.of("./test-file6.md"));
        assertEquals(List.of(), MarkdownParse1.getLinks(fileContent));
    }
    @Test
    public void File7Test() throws IOException{
        String fileContent = Files.readString(Path.of("./test-file7.md"));
        assertEquals(List.of(), MarkdownParse1.getLinks(fileContent));
    }
    @Test
    public void File8est() throws IOException{
        String fileContent = Files.readString(Path.of("./test-file8.md"));
        assertEquals(List.of("a link on the first line"), MarkdownParse1.getLinks(fileContent));
    }

    @Test
    public void writeup8Test1() throws IOException{
        Path fileName = Path.of("writeup8test1.md");
        String content = Files.readString(fileName);
        ArrayList testArray = new ArrayList<>(1);
        testArray.add("`google.com");
        assertEquals(testArray, MarkdownParse1.getLinks(content));
    }

    @Test
    public void writeup8Test2() throws IOException{
        Path fileName = Path.of("writeup8test2.md");
        String content = Files.readString(fileName);
        ArrayList testArray = new ArrayList<>(3);
        testArray.add("a.com");
        testArray.add("a.com(())");
        testArray.add("example.com");
        assertEquals(testArray, MarkdownParse1.getLinks(content));
    }

    @Test
    public void writeup8Test3() throws IOException{
        Path fileName = Path.of("writeup8test3.md");
        String content = Files.readString(fileName);
        ArrayList testArray = new ArrayList<>(1);
        testArray.add("https://sites.google.com/eng.ucsd.edu/cse-15l-spring-2022/schedule");
        assertEquals(testArray, MarkdownParse1.getLinks(content));
    }
}