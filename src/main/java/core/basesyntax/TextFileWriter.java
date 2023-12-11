package core.basesyntax;

public class TextFileWriter implements FileWriter{
    @Override
    public void writeToFile(String content, String filePath) {
        System.out.println("Writing to text file: " + content);
    }
}
