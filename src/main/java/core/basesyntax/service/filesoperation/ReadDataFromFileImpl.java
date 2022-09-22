package core.basesyntax.service.filesoperation;

import core.basesyntax.service.parsing.ParsingDataService;
import core.basesyntax.service.parsing.ParsingDataServiceImpl;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReadDataFromFileImpl implements ReadDataFromFile {
    private static final String ERROR_READ_MESSAGE = "Can't find file by path: ";
    private List<String> frits;

    @Override
    public void readData(String inputFile) {

        ParsingDataService parsingDataService = new ParsingDataServiceImpl();
        try {
            frits = Files.readAllLines(Path.of(inputFile));
        } catch (IOException e) {
            throw new RuntimeException(ERROR_READ_MESSAGE + inputFile);
        }
        parsingDataService.parsingFromList(frits);
    }
}
