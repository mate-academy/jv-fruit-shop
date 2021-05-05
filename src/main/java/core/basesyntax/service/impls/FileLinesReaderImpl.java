package core.basesyntax.service.impls;

import core.basesyntax.service.FileLinesReader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileLinesReaderImpl implements FileLinesReader {

    @Override
    public List<String> dataFromFile(String fileName) {
        List<String> inputFileLines = new ArrayList<>();
        try (BufferedReader linesReader = new BufferedReader(new FileReader(fileName))) {
            linesReader.readLine();
            String line;

            while ((line = linesReader.readLine()) != null) {
                inputFileLines.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error while opening file:  " + fileName, e);
        }
        return inputFileLines;
    }
}
