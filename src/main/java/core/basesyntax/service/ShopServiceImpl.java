package core.basesyntax.service;

import java.io.File;

public class ShopServiceImpl implements ShopService {
    private ShopServiceStrategy strategy;
    private CsvReader csvReader;
    private CsvConverter csvConverter;
    private FileMaster fileMaster;

    public ShopServiceImpl(ShopServiceStrategy strategy,
                           CsvReader csvReader, CsvConverter csvConverter,
                           FileMaster fileMaster) {
        this.strategy = strategy;
        this.csvReader = csvReader;
        this.csvConverter = csvConverter;
        this.fileMaster = fileMaster;
    }

    public String readAndConvert(String fromFileName) {
        String dataToConvert = csvReader.readFile(fromFileName);
        return csvConverter.convertCsv(dataToConvert);
    }

    public void processData(String inputData) {
        strategy.handleData(inputData);
    }

    public String createReport(String fromFileName) {
        return fileMaster.addFile(fromFileName);
    }

    public File writeReportToFile(String outputPath) {
        return fileMaster.writeReport(outputPath);
    }
}
