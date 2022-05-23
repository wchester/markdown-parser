//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse1 {

    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then read link upto next )
        int currentIndex = 0;
        while(currentIndex < markdown.length()) {
            int imgFinder = markdown.indexOf("!", currentIndex);
            int openBracket = markdown.indexOf("[", currentIndex);
            if(openBracket < 0){
                return toReturn;
            }

            int closeBracket = markdown.indexOf("]", openBracket);
            if(closeBracket < 0){
                return toReturn;
            }

            int openParen = markdown.indexOf("(", closeBracket);
            if(openParen < 0){
                return toReturn;
            }
            
            if(openParen - closeBracket > 1){
                return toReturn;
            }

            int closeParen = markdown.indexOf(")", openParen);
            if(closeParen < 0){
                return toReturn;
            }

            if (imgFinder != openBracket - 1){
                toReturn.add(markdown.substring(openParen + 1, closeParen));      
            }
            currentIndex = closeParen + 1;
            int nextLink = markdown.indexOf("[", currentIndex);
            if(nextLink < 0){
                return toReturn;
            }   
  
        }
        return toReturn;
    }


    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
	    System.out.println(links);
    }
}
