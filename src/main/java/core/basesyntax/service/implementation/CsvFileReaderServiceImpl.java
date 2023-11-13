package core.basesyntax.service.implementation;

import core.basesyntax.service.CsvFileReaderService;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvFileReaderServiceImpl implements CsvFileReaderService {

    private static final String HEADER_INPUT_FILE = "type,fruit,quantity";

    @Override
    public List<String> readFrom(String inputFile) {
        List<String> linesInputFile = new ArrayList<>();
        if (inputFile == null || inputFile.length() == 0) {
            throw new RuntimeException("File " + inputFile + " is empty");
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));
            String line = bufferedReader.readLine();
            while (line != null) {
                linesInputFile.add(line);
                line = bufferedReader.readLine();
            }
            linesInputFile.remove(HEADER_INPUT_FILE);
            return linesInputFile;
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't find file " + inputFile, e);
        } catch (IOException e) {
            throw new RuntimeException("File " + inputFile + " is not supported");
        }
    }
}
