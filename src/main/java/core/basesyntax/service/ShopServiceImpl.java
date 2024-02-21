package core.basesyntax.service;

import core.basesyntax.dao.StorageDao;
import java.io.File;

public class ShopServiceImpl implements ShopService {
    private ShopServiceStrategy strategy;
    private FileReader fileReader;
    private CsvConverter csvConverter;
    private FileMaster fileMaster;
    private StorageDao stDao;

    public ShopServiceImpl(ShopServiceStrategy strategy,
                           FileReader fileReader, CsvConverter csvConverter,
                           FileMaster fileMaster, StorageDao stDao) {
        this.strategy = strategy;
        this.fileReader = fileReader;
        this.csvConverter = csvConverter;
        this.fileMaster = fileMaster;
        this.stDao = stDao;
    }

    public String readAndConvert(File fromFile) {
        String dataToConvert = fileReader.readFile(fromFile);
        return csvConverter.convertCsv(dataToConvert);
    }

    public void processData(String inputData) {
        strategy.handleData(inputData);
    }

    public File createReport(File fromFile) {
        return fileMaster.addFile(fromFile);
    }

    public File writeReportToFile(File blankDestinationFile) {
        String contentToWrite = stDao.checkStorage();
        String outputPath = blankDestinationFile.getPath();
        return fileMaster.writeReport(outputPath, contentToWrite);
    }
}
