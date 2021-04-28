package core.basesyntax.service.files;

import core.basesyntax.dao.FruitDao;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FruitServiceImpl implements FruitService {
    private static final String READ_EXCEPTION_MESSAGE = "Can`t read from file ";
    private static final String WRITE_EXCEPTION_MESSAGE = "Can`t write to file ";
    private FruitDao fruitDao;

    public FruitServiceImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void readFromDb(String filePath) {
        List<String> infoFromDb;
        try {
            infoFromDb = Files.readAllLines(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException(READ_EXCEPTION_MESSAGE + filePath, e);
        }
        fruitDao.writeToStorage(infoFromDb);
    }

    @Override
    public void writeToReport(String reportPath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(reportPath))) {
            writer.write(fruitDao.generateReport());
        } catch (IOException e) {
            throw new RuntimeException(WRITE_EXCEPTION_MESSAGE + reportPath, e);
        }
    }

}
