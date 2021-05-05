package core.basesyntax.service.fileservice;

import core.basesyntax.dao.FruitDao;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class FileServiceImplForCsv implements FileService {
    private static final String HEADLINE = "fruit,quantity" + System.lineSeparator();
    private static final String WRITE_TO_FILE_EXCEPTION = "Can't write to file: ";
    private final FruitDao fruitDao;

    public FileServiceImplForCsv(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public List<String> readAllLinesFromFile(String fileName) {
        try {
            return Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Can't read file: " + fileName, e);
        }
    }

    @Override
    public String createReport(FruitDao fruitDao) {
        return HEADLINE + fruitDao.getAll().entrySet()
                .stream()
                .map(currentKey -> currentKey.getKey().getName() + ","
                        + currentKey.getValue() + System.lineSeparator())
                .collect(Collectors.joining());
    }

    @Override
    public void writeReport(String fileName) {
        try {
            Files.write(Path.of(fileName), createReport(fruitDao).getBytes());
        } catch (IOException e) {
            throw new RuntimeException(WRITE_TO_FILE_EXCEPTION + fileName, e);
        }
    }
}
