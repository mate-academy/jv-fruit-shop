package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataHandler;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.strategy.OperationHandler;
import core.basesyntax.service.strategy.impl.OperationStrategyImpl;
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
