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
import core.basesyntax.services.CsvFileDataHandler;
import core.basesyntax.services.FileWriter;
import core.basesyntax.services.ReportCreator;
import core.basesyntax.services.impl.CsvFileDataHandlerImpl;
import core.basesyntax.services.impl.CsvFileReaderImpl;
import core.basesyntax.services.impl.FileWriterImpl;
import core.basesyntax.services.impl.ReportCreatorImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String PATH_FROM_FILE
            = "src/main/java/core/basesyntax/resources/file.csv";
    private static final String PATH_TO_FILE
            = "src/main/java/core/basesyntax/resources/report.csv";

    public static void main(String[] args) {
        FruitDao fruitsDao = new FruitDaoImpl();
        Map<String, OperationHandler> operations = new HashMap<>();
        operations.put("b", new BalanceHandler(fruitsDao));
        operations.put("s", new SupplyHandler(fruitsDao));
        operations.put("r", new ReturnHandler(fruitsDao));
        operations.put("p", new PurchaseHandler(fruitsDao));
        OperationStrategy operationStrategy = new OperationStrategyImpl(operations);
        List<String> readData = new CsvFileReaderImpl()
                .readData(PATH_FROM_FILE);
        CsvFileDataHandler csvFileDataHandler = new CsvFileDataHandlerImpl(operationStrategy);
        csvFileDataHandler.processData(readData);
        ReportCreator reportCreator = new ReportCreatorImpl(fruitsDao);
        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.writeReport(PATH_TO_FILE,
                reportCreator.createReport(),
                csvFileDataHandler.HEADER);
    }
}
