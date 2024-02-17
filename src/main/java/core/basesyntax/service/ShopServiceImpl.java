package core.basesyntax.service;

import core.basesyntax.dao.StorageDaoImpl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ShopServiceImpl implements ShopService{
    private ShopServiceStrategy strategy;
    private StorageDaoImpl stDao;

    public ShopServiceImpl(ShopServiceStrategy strategy, StorageDaoImpl stDao) {
        this.strategy = strategy;
        this.stDao = stDao;
    }

    private String readFile(String fromFileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fromFileName))) {
            StringBuilder data = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                data.append(line).append(System.lineSeparator());
            }
            return data.toString().trim();
        } catch (IOException e) {
            throw new RuntimeException("Error reading from file", e);
        }
    }

    @Override
    public File report(String fromFileName) {
        stDao.addFile();
        strategy.acceptFile(fromFileName);
        return stDao.createReport();
    }
}
