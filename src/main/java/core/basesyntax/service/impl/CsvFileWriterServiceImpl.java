package core.basesyntax.service.impl;

import core.basesyntax.dao.ProductDaoService;
import core.basesyntax.service.CsvFileWriterService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class CsvFileWriterServiceImpl implements CsvFileWriterService {
    private ProductDaoService productDaoService;

    public CsvFileWriterServiceImpl(ProductDaoService productDaoService) {
        this.productDaoService = productDaoService;
    }

    @Override
    public void writeToFile(String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            Files.write(file.toPath(), productDaoService.getAllData().getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can`t write to file with name: " + file.getName());
        }
    }
}
