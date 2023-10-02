package core.basesyntax;

import core.basesyntax.db.FruitDao;
import core.basesyntax.db.FruitStorageInMap;
import core.basesyntax.db.OperationHandler;
import core.basesyntax.db.OperationHandlerBalance;
import core.basesyntax.db.OperationHandlerPurchase;
import core.basesyntax.db.OperationHandlerReturn;
import core.basesyntax.db.OperationHandlerSupply;
import core.basesyntax.db.OperationStrategy;
import core.basesyntax.db.OperationStrategyImpl;
import core.basesyntax.model.Operation;
import core.basesyntax.model.OperationType;
import core.basesyntax.service.DataParser;
import core.basesyntax.service.DataParserImpl;
import core.basesyntax.service.DataReader;
import core.basesyntax.service.DataReaderCsv;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.ReportGeneratorImpl;
import core.basesyntax.service.ReportWriter;
import core.basesyntax.service.ReportWriterCsv;
import java.util.HashMap;
import java.util.Map;

public class FruitShop {
    private static final String DATA_FILE_NAME = "src/main/resources/data.csv";
    private static final String REPORT_FILE_NAME = "src/main/resources/report.csv";

    public static void main(String[] args) {
        // Initialization
        Map<OperationType, OperationHandler> strategies = new HashMap<>();
        strategies.put(OperationType.BALANCE, new OperationHandlerBalance());
        strategies.put(OperationType.SUPPLY, new OperationHandlerSupply());
        strategies.put(OperationType.PURCHASE, new OperationHandlerPurchase());
        strategies.put(OperationType.RETURN, new OperationHandlerReturn());
        OperationStrategy operationStrategy = new OperationStrategyImpl(strategies);
        FruitDao fruitDb = new FruitStorageInMap();

        // Read data
        DataReader dataReader = new DataReaderCsv();
        String[] data = dataReader.read(DATA_FILE_NAME);

        // Parse & put in DB
        DataParser dataParser = new DataParserImpl();
        for (int i = 1; i < data.length; i++) {
            String entry = data[i];
            Operation operation = dataParser.parse(entry);
            OperationHandler operationHandler = operationStrategy.get(operation.getOperationType());
            operationHandler.makeChanges(fruitDb, operation.getFruit(), operation.getCount());
        }

        // Generate report
        ReportGenerator reportGenerator = new ReportGeneratorImpl(fruitDb);
        String[] report = reportGenerator.generate();

        // Write report to file
        ReportWriter reportWriter = new ReportWriterCsv();
        reportWriter.write(report, REPORT_FILE_NAME);
    }
}
