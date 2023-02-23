package core.basesyntax;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.dao.FruitsDaoImpl;
import core.basesyntax.operations.OperationHandler;
import core.basesyntax.operations.OperationStrategy;
import core.basesyntax.operations.OperationStrategyImpl;
import core.basesyntax.operations.impl.BalanceHandler;
import core.basesyntax.operations.impl.PurchaseHandler;
import core.basesyntax.operations.impl.ReturnHandler;
import core.basesyntax.operations.impl.SupplyHandler;
import core.basesyntax.service.CsvFileDataHandler;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.impl.CsvFileDataHandlerImpl;
import core.basesyntax.service.impl.CsvFileReaderImpl;
import core.basesyntax.service.impl.FileWriterImpl;
import core.basesyntax.service.impl.ReportCreatorImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        FruitsDao fruitsDao = new FruitsDaoImpl();
        Map<String, OperationHandler> operations = new HashMap<>();
        operations.put("b", new BalanceHandler(fruitsDao));
        operations.put("s", new SupplyHandler(fruitsDao));
        operations.put("r", new ReturnHandler(fruitsDao));
        operations.put("p", new PurchaseHandler(fruitsDao));
        OperationStrategy operationStrategy = new OperationStrategyImpl(operations);
        List<String> readData = new CsvFileReaderImpl().readData("src/main/resources/file.csv");
        CsvFileDataHandler csvFileDataHandler = new CsvFileDataHandlerImpl(operationStrategy);
        csvFileDataHandler.processData(readData);
        ReportCreator reportCreator = new ReportCreatorImpl(fruitsDao);
        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.writeReport("src/main/resources/report.csv",
                reportCreator.createReport(),
                csvFileDataHandler.HEADER);

    }
}
