package core.basesyntax.dao;

import core.basesyntax.service.works.WorkWithStorage;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FruitDaoImpl implements FruitDao {
    private static final String READ_EXCEPTION_MESSAGE = "Can`t read from file ";
    private static final String WRITE_EXCEPTION_MESSAGE = "Can`t write to file ";
    private WorkWithStorage workWithStorage;

    public FruitDaoImpl(WorkWithStorage workWithStorage) {
        this.workWithStorage = workWithStorage;
    }

    @Override
    public void readFromDb(String filePath) {
        List<String> infoFromDb;
        try {
            infoFromDb = Files.readAllLines(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException(READ_EXCEPTION_MESSAGE + filePath, e);
        }
        workWithStorage.writeToStorage(infoFromDb);
    }

    @Override
    public void writeToReport(String reportPath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(reportPath))) {
            writer.write(workWithStorage.generateReport());
        } catch (IOException e) {
            throw new RuntimeException(WRITE_EXCEPTION_MESSAGE + reportPath, e);
        }
    }

}
