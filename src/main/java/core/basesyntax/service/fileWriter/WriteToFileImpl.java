package core.basesyntax.service.fileWriter;

import core.basesyntax.dao.TransactionDao;
import core.basesyntax.dao.TransactionDaoImpl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class WriteToFileImpl implements WriteToFile {
    private static final TransactionDao transactionDao = new TransactionDaoImpl();

    @Override
    public void writeToFile() {
        File file = new File("src/main/resources/report.csv");
        try {
            Files.write(file.toPath(), transactionDao.getAll().getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can not write to file");
        }
    }
}
