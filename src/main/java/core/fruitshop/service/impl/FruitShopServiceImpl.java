package core.fruitshop.service.impl;

import core.fruitshop.model.FruitTransaction;
import core.fruitshop.service.DataHandler;
import core.fruitshop.service.FileReader;
import core.fruitshop.service.FileWriter;
import core.fruitshop.service.FruitShopService;
import core.fruitshop.service.ReportCreator;
import core.fruitshop.service.strategy.OperationHandler;
import core.fruitshop.service.strategy.impl.OperationStrategyImpl;
import java.util.List;
import java.util.Map;

public class FruitShopServiceImpl implements FruitShopService {
    private final FileReader fileReader;
    private final DataHandler dataHandler;
    private final ReportCreator reportCreator;
    private final FileWriter fileWriter;

    public FruitShopServiceImpl(Map<FruitTransaction.Operation, OperationHandler> map) {
        this.fileReader = new FileReaderImpl();
        this.dataHandler = new DataHandlerImpl(new OperationStrategyImpl(map));
        this.reportCreator = new ReportCreatorImpl();
        this.fileWriter = new FileWriterImpl();
    }

    @Override
    public void createDayReport(String fromFile, String toFile) {
        List<String> dataFromFile = fileReader.readFromFile(fromFile);
        dataHandler.processData(dataFromFile);
        String report = reportCreator.createReport();
        fileWriter.writeToFile(report, toFile);
    }
}
