package core.basesyntax.service;

import core.basesyntax.dao.StorageDao;

public class ShopServiceImpl implements ShopService {
    private ShopServiceStrategy strategy;
    private CsvFileReader csvFileReader;
    private CsvConverter csvConverter;
    private CsvWriter csvWriter;
    private StorageDao stDao;

    public ShopServiceImpl(ShopServiceStrategy strategy,
                           CsvFileReader csvFileReader, CsvConverter csvConverter,
                           CsvWriter csvWriter, StorageDao stDao) {
        this.strategy = strategy;
        this.csvFileReader = csvFileReader;
        this.csvConverter = csvConverter;
        this.csvWriter = csvWriter;
        this.stDao = stDao;
    }

    public void report(String inputPath, String outputPath) {
        String dataToConvert = csvFileReader.readFile(inputPath);
        var convertedToClassObj = csvConverter.convertToRecord(dataToConvert);
        strategy.processDataFromObj(convertedToClassObj);
        String contentToWrite = stDao.getStorageContents();
        csvWriter.writeReportToFile(outputPath, contentToWrite);
    }
}

