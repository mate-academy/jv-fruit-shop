package core.basesyntax.service.impl;

import core.basesyntax.db.dao.StorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ReadService;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadServiceImpl implements ReadService {
    private StorageDaoImpl storageDao;
    @Override
    public void readFromFile(String filePath) {
        File file = new File(filePath);
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String value = bufferedReader.readLine();
            while (value != null) {
                storageDao.add(parseString(value));
                value = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't find file ", e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
    }
    private FruitTransaction parseString(String value) {
        String[] values = value.split(",");
        return new FruitTransaction(FruitTransaction.Operation.valueOf(values[0]),
                values[1], Integer.parseInt(values[3]));
    }
}
