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

    public String readAndConvert(String fromFileName) {
        return csvReader.readFile(fromFileName);
    }

    public void processData(String inputData) {
        strategy.handleData(inputData);
    }

    public String createReport(String fromFileName) {
        return stDao.addFile(fromFileName);
    }

    public File writeReport(String outputPath) {
        return stDao.writeReport(outputPath);
    }
}
