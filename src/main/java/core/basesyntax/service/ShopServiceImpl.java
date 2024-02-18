package core.basesyntax.service;

import core.basesyntax.dao.StorageDaoImpl;
import java.io.File;


public class ShopServiceImpl implements ShopService{
    private ShopServiceStrategy strategy;
    private StorageDaoImpl stDao;
    private CSVReader csvReader;

    public ShopServiceImpl(ShopServiceStrategy strategy, StorageDaoImpl stDao, CSVReader csvReader) {
        this.strategy = strategy;
        this.stDao = stDao;
        this.csvReader = csvReader;
    }

    @Override
    public File report(String fromFileName) {
        stDao.addFile();
        String readData = csvReader.readFile(fromFileName);
        strategy.handleData(readData);
        return stDao.writeReport();
    }
}
