package core.basesyntax.service.filewriter;

import core.basesyntax.dao.TransactionDao;
import core.basesyntax.dao.TransactionDaoImpl;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileWriterImpl implements FileWriter {
    private final TransactionDao transactionDao;

    public FileWriterImpl(TransactionDao transactionDao) {
        this.transactionDao = transactionDao;
    }

    @Override
    public void writeToFile(String reportFileName) {
        File fileName = new File(reportFileName);
        try {
            Files.write(fileName.toPath(), transactionDao.getAll().getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can not write to file" + fileName,e);
        }
    }
}
