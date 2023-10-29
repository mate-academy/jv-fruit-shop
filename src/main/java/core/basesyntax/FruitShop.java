package core.basesyntax;

import core.basesyntax.db.FruitStorageDao;
import core.basesyntax.db.FruitStorageDaoImpl;
import core.basesyntax.model.Operation;
import core.basesyntax.model.OperationType;
import core.basesyntax.service.DataParser;
import core.basesyntax.service.DataReader;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.ReportWriter;
import core.basesyntax.service.impl.DataParserImpl;
import core.basesyntax.service.impl.DataReaderCsv;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.service.impl.ReportWriterCsv;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationHandlerBalance;
import core.basesyntax.strategy.OperationHandlerPurchase;
import core.basesyntax.strategy.OperationHandlerReturn;
import core.basesyntax.strategy.OperationHandlerSupply;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.HashMap;
import java.util.Map;

public class FruitShop {
    private static final String DATA_FILE_NAME = "src/main/resources/data.csv";
    private static final String REPORT_FILE_NAME = "src/main/resources/report.csv";
    private static final int OFFSET = 1;

    public static void main(String[] args) {
        // Initialization
        Map<OperationType, OperationHandler> strategies = new HashMap<>();
        strategies.put(OperationType.BALANCE, new OperationHandlerBalance());
        strategies.put(OperationType.SUPPLY, new OperationHandlerSupply());
        strategies.put(OperationType.PURCHASE, new OperationHandlerPurchase());
        strategies.put(OperationType.RETURN, new OperationHandlerReturn());
        OperationStrategy operationStrategy = new OperationStrategyImpl(strategies);
        FruitStorageDao fruitDb = new FruitStorageDaoImpl();

        // Read data
        DataReader dataReader = new DataReaderCsv();
        String[] data = dataReader.read(DATA_FILE_NAME);

        // Parse & put in DB
        DataParser dataParser = new DataParserImpl();
        for (int i = OFFSET; i < data.length; i++) {
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
