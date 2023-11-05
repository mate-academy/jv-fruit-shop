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
import core.basesyntax.service.CreatereReport;
import core.basesyntax.service.GetterTransactions;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.ProcessorData;
import core.basesyntax.service.ReaderFromFile;
import core.basesyntax.service.WriterToFile;
import core.basesyntax.service.impl.CreatereReportImpl;
import core.basesyntax.service.impl.GetterTransactionsImpl;
import core.basesyntax.service.impl.OperationStrategyImpl;
import core.basesyntax.service.impl.ProcessorDataImpl;
import core.basesyntax.service.impl.ReaderFromFileImpl;
import core.basesyntax.service.impl.WriterToFileImpl;
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
    private final ReaderFromFile readerFromFile = new ReaderFromFileImpl();
    private final GetterTransactions getterTransactions = new GetterTransactionsImpl();
    private final OperationStrategy operationStrategy = new OperationStrategyImpl(handlerMap);
    private final ProcessorData processorData = new ProcessorDataImpl(operationStrategy);
    private final CreatereReport createreReport = new CreatereReportImpl();
    private final WriterToFile writerToFile = new WriterToFileImpl();

    public void main() {
        String dataFromFile = getDataFromFile(INPUT_FILE_PATH);
        List<FruitTransaction> fruitTransactions = createFruitTransactionList(dataFromFile);
        processingData(fruitTransactions);
        String stringReport = createReport();
        writeToFile(stringReport, OUTPUT_FILE_PATH);
    }

    private String getDataFromFile(String inputFileName) {
        return readerFromFile.readFromFile(inputFileName);
    }

    private List<FruitTransaction> createFruitTransactionList(String data) {
        return getterTransactions.getTransactions(data);
    }

    private void processingData(List<FruitTransaction> fruitTransactions) {
        processorData.processData(fruitTransactions);
    }

    private String createReport() {
        return createreReport.createReport(fruitDao);
    }

    private void writeToFile(String outputData, String outputFileName) {
        writerToFile.writeToFile(outputData, outputFileName);
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
