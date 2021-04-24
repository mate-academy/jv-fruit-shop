package core.basesyntax.service;

import core.basesyntax.dao.ProductDao;
import core.basesyntax.dao.ProductDaoImpl;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CsvWriterImpl implements CsvWriter {
    private static final String TITLE = "fruit, quantity";
    private static final String ERROR_MESSAGE = "Can't write to file in this path";
    private final ProductDao productDao;

    public CsvWriterImpl(ProductDaoImpl productDao) {
        this.productDao = productDao;
    }

    @Override
    public void writeToFile(String path) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writer.write(TITLE + System.lineSeparator());
            for (String line : productDao.getAll()) {
                writer.write(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(ERROR_MESSAGE + " " + path, e);
        }
    }
}
