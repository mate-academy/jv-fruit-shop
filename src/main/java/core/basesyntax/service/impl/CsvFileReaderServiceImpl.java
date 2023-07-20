package core.basesyntax.service.impl;

import core.basesyntax.service.impl.service.ActivityTypeStrategy;
import core.basesyntax.service.impl.service.CsvFileReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CsvFileReaderServiceImpl implements CsvFileReaderService {
    private static final String PATH_TO_FILE = "src/main/resources/";
    private static final String COMA_DELIMITER = ",";
    private static final int TYPE_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String EXCEPTION_INFO =
            "Cannot read file! "
                    + "Check if file has correct name or correct its extension which is .csv";
    private static final String FILE_EXTENSION = ".csv";
    private ActivityTypeStrategy activityTypeStrategy;

    public CsvFileReaderServiceImpl(ActivityTypeStrategy activityTypeStrategy) {
        this.activityTypeStrategy = activityTypeStrategy;
    }

    @Override
    public List<String> readData(String fromFile) {
        List<String> lines;
        try {
            lines = Files.readAllLines(Path.of(PATH_TO_FILE + fromFile + FILE_EXTENSION));
        } catch (IOException e) {
            throw new RuntimeException(EXCEPTION_INFO, e);
        }
        return lines;
    }
}
