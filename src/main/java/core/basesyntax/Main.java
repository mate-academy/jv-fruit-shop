package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operation.BalanceOperationHandler;
import core.basesyntax.operation.OperationHandler;
import core.basesyntax.operation.PurchaseOperationHandler;
import core.basesyntax.operation.ReturnOperationHandler;
import core.basesyntax.operation.SupplyOperationHandler;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.TransactionsGetter;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.DataProcessor;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.service.impl.TransactionsGetterImpl;
import core.basesyntax.service.impl.OperationStrategyImpl;
import core.basesyntax.service.impl.DataProcessorImpl;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.FileWriterImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/input.csv";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/output.csv";
    private final Storage storage = new Storage();
    private final FruitDao fruitDao = new FruitDaoImpl(storage);
    private final Map<FruitTransaction.Operation, OperationHandler> handlerMap
            = createHandlerMap();
    private final FileReader fileReader = new FileReaderImpl();
    private final TransactionsGetter transactionsGetter = new TransactionsGetterImpl();
    private final OperationStrategy operationStrategy = new OperationStrategyImpl(handlerMap);
    private final DataProcessor dataProcessor = new DataProcessorImpl(operationStrategy);
    private final ReportGenerator reportGenerator = new ReportGeneratorImpl();
    private final FileWriter fileWriter = new FileWriterImpl();

    public void main() {
        String dataFromFile = getDataFromFile(INPUT_FILE_PATH);
        List<FruitTransaction> fruitTransactions = createFruitTransactionList(dataFromFile);
        processingData(fruitTransactions);
        String stringReport = createReport();
        writeToFile(stringReport, OUTPUT_FILE_PATH);
    }

    private String getDataFromFile(String inputFileName) {
        return fileReader.readFromFile(inputFileName);
    }

    private List<FruitTransaction> createFruitTransactionList(String data) {
        return transactionsGetter.getTransactions(data);
    }

    private void processingData(List<FruitTransaction> fruitTransactions) {
        dataProcessor.processData(fruitTransactions);
    }

    private String createReport() {
        return reportGenerator.createReport(fruitDao);
    }

    private void writeToFile(String outputData, String outputFileName) {
        fileWriter.writeToFile(outputData, outputFileName);
    }

    private Map<FruitTransaction.Operation, OperationHandler> createHandlerMap() {
        Map<FruitTransaction.Operation, OperationHandler> handlerMap = new HashMap<>();
        handlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler(fruitDao));
        handlerMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler(fruitDao));
        handlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler(fruitDao));
        handlerMap.put(FruitTransaction.Operation.RETURN, new ReturnOperationHandler(fruitDao));
        return handlerMap;
    }
}
