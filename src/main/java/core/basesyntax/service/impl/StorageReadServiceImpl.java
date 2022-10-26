package core.basesyntax.service.impl;

import core.basesyntax.service.DataService;
import core.basesyntax.service.StorageReadService;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class StorageReadServiceImpl implements StorageReadService {
    private static final String EXCEPTION_MESSAGE = "Can't read this file ";
    private DataService dataService = new DataServiceImpl();

    @Override
    public void readData(File file) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                dataService.proceedData(line);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(EXCEPTION_MESSAGE + file);
        }
    }
}
