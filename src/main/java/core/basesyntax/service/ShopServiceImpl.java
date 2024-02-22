package core.basesyntax.service;

import core.basesyntax.dao.StorageDao;
import java.io.File;

public class ShopServiceImpl implements ShopService {
    private ShopServiceStrategy strategy;
    private CsvFileReader csvFileReader;
    private CsvConverter csvConverter;
    private FileWriter fileWriter;
    private StorageDao stDao;
    private FileService fileService;

    public ShopServiceImpl(ShopServiceStrategy strategy,
                           CsvFileReader csvFileReader, CsvConverter csvConverter,
                           FileWriter fileWriter, StorageDao stDao, FileService fileService) {
        this.strategy = strategy;
        this.csvFileReader = csvFileReader;
        this.csvConverter = csvConverter;
        this.fileWriter = fileWriter;
        this.stDao = stDao;
        this.fileService = fileService;
    }

    public File report(String inputPath, String outputPath) {
        String dataToConvert = csvFileReader.readFile(inputPath);
        var convertedToClassObj = csvConverter.convertToRecord(dataToConvert);
        strategy.processDataFromObj(convertedToClassObj);
        String contentToWrite = stDao.checkStorage();
        fileService.createBlankFile(outputPath);

        return fileWriter.writeReportToFile(outputPath, contentToWrite);
    }
}

