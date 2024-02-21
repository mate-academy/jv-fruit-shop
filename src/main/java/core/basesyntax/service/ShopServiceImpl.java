package core.basesyntax.service;

import core.basesyntax.dao.StorageDao;
import java.io.File;

public class ShopServiceImpl implements ShopService {
    private ShopServiceStrategy strategy;
    private FileReader fileReader;
    private CsvConverter csvConverter;
    private FileServise fileServise;
    private StorageDao stDao;

    public ShopServiceImpl(ShopServiceStrategy strategy,
                           FileReader fileReader, CsvConverter csvConverter,
                           FileServise fileServise, StorageDao stDao) {
        this.strategy = strategy;
        this.fileReader = fileReader;
        this.csvConverter = csvConverter;
        this.fileServise = fileServise;
        this.stDao = stDao;
    }

    public File report(String inputPath, String outputPath) {
        String dataToConvert = fileReader.readFile(inputPath);
        String dataToProcess = csvConverter.convertCsv(dataToConvert);
        strategy.handleData(dataToProcess);
        String contentToWrite = stDao.checkStorage();

        return fileServise.writeReport(outputPath, contentToWrite);
    }
}

