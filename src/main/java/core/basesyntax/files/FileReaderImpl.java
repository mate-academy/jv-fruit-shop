package core.basesyntax.files;

import core.basesyntax.service.FruitService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReaderImpl implements FileReader {
    private static final String READ_EXCEPTION_MESSAGE = "Can`t read from file ";
    private FruitService fruitService;

    public FileReaderImpl(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @Override
    public void readFromInputFile(String filePath) {
        List<String> infoFromDb;
        try {
            infoFromDb = Files.readAllLines(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException(READ_EXCEPTION_MESSAGE + filePath, e);
        }
        fruitService.writeToStorage(infoFromDb);
    }
}
