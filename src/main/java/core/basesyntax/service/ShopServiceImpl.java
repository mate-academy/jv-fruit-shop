package core.basesyntax.service;

import core.basesyntax.dao.StorageDaoImpl;
import java.io.File;

public class ShopServiceImpl implements ShopService {
    private ShopServiceStrategy strategy;
    private StorageDaoImpl stDao;
    private CSvReader csvReader;

    public ShopServiceImpl(ShopServiceStrategy strategy,
                           StorageDaoImpl stDao, CSvReader csvReader) {
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
