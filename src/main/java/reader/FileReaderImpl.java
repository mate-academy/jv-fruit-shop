package reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderImpl implements FileReader {

    @Override
    public List<String> read(String fileIn) {
        List<String> linesIn = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new java.io.FileReader(fileIn))) {
            String line;
            while ((line = br.readLine()) != null) {
                linesIn.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("file cannot be read " + fileIn, e);
        }
        return linesIn;
    }
}
