package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataHandler;
import core.basesyntax.service.DataReader;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.ReportWriter;
import core.basesyntax.service.strategy.OperationHandler;
import core.basesyntax.service.strategy.impl.OperationStrategyImpl;
import java.util.List;
import java.util.Map;

public class FruitShopServiceImpl implements FruitShopService {
    private final DataReader dataReader;
    private final DataHandler dataHandler;
    private final ReportCreator reportCreator;
    private final ReportWriter reportWriter;

    public FruitShopServiceImpl(Map<FruitTransaction.Operation, OperationHandler> map) {
        this.dataReader = new DataReaderImpl();
        this.dataHandler = new DataHandlerImpl(new OperationStrategyImpl(map));
        this.reportCreator = new ReportCreatorImpl();
        this.reportWriter = new ReportWriterImpl();
    }

    @Override
    public void createDayReport(String fromFile, String toFile) {
        List<String> dataFromFile = dataReader.readData(fromFile);
        dataHandler.processData(dataFromFile);
        String report = reportCreator.createReport();
        reportWriter.writeReport(report, toFile);
    }
}
