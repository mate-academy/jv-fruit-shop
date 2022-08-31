package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
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
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.FileWriterImpl;
import core.basesyntax.service.impl.ReportCreatorImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String PATH_FROM_FILE
            = "src/main/resources/file.csv";
    private static final String PATH_TO_FILE
            = "src/main/resources/report.csv";

    public static void main(String[] args) {
        FruitDao fruitsDao = new FruitDaoImpl();
        Map<String, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put("b", new BalanceHandler(fruitsDao));
        operationHandlers.put("s", new SupplyHandler(fruitsDao));
        operationHandlers.put("r", new ReturnHandler(fruitsDao));
        operationHandlers.put("p", new PurchaseHandler(fruitsDao));
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);
        List<String> readData = new FileReaderImpl()
                .readData(PATH_FROM_FILE);
        CsvFileDataHandler csvFileDataHandler = new CsvFileDataHandlerImpl(operationStrategy);
        csvFileDataHandler.processData(readData);
        ReportCreator reportCreator = new ReportCreatorImpl(fruitsDao);
        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.writeReport(PATH_TO_FILE,
                reportCreator.createReport());
    }
}
