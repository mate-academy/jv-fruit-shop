package core.fruitshop.service.impl;

import core.fruitshop.service.DataHandler;
import core.fruitshop.service.FileReader;
import core.fruitshop.service.FileWriter;
import core.fruitshop.service.FruitShopService;
import core.fruitshop.service.ReportCreator;
import java.util.List;

public class FruitShopServiceImpl implements FruitShopService {
    private final FileReader fileReader;
    private final DataHandler dataHandler;
    private final ReportCreator reportCreator;
    private final FileWriter fileWriter;

    public FruitShopServiceImpl(FileReaderImpl fileReaderImpl, DataHandlerImpl dataHandlerImpl,
            ReportCreatorImpl reportCreatorImpl, FileWriterImpl fileWriterImpl) {
        this.fileReader = fileReaderImpl;
        this.dataHandler = dataHandlerImpl;
        this.reportCreator = reportCreatorImpl;
        this.fileWriter = fileWriterImpl;
    }

    @Override
    public void createDayReport(String fromFile, String toFile) {
        List<String> dataFromFile = fileReader.readFromFile(fromFile);
        dataHandler.processData(dataFromFile);
        String report = reportCreator.createReport();
        fileWriter.writeToFile(report, toFile);
    }
}
