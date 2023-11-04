package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operation.*;
import core.basesyntax.service.*;
import core.basesyntax.service.impl.*;

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


    public void main() {
        String dataFromFile = getDataFromFile(INPUT_FILE_PATH);
        List<FruitTransaction> fruitTransactions = createFruitTransactionList(dataFromFile);
        processingData(fruitTransactions);
        String stringReport = createReport();
        writeToFile(stringReport, OUTPUT_FILE_PATH);
    }

    private String getDataFromFile(String inputFileName) {
        ReaderFromFile readerFromFile = new ReaderFromFileImpl();
        return readerFromFile.readFromFile(inputFileName);
    }

    private List<FruitTransaction> createFruitTransactionList(String data) {
        CreatereObjectsList createreObjectsList = new CreatereObjectsListImpl();
        return createreObjectsList.getObjectList(data);
    }

    private void processingData(List<FruitTransaction> fruitTransactions) {
        OperationStrategy operationStrategy = new OperationStrategyImpl(handlerMap);
        ProcessorData processorData = new ProcessorDataImpl(operationStrategy);
        processorData.processData(fruitTransactions);
    }

    private String createReport() {
        CreatereReport createreReport = new CreatereReportImpl();
        return createreReport.createReport(fruitDao);
    }

    private void writeToFile(String outputData, String outputFileName) {
        WriterToFile writerToFile = new WriterToFileImpl();
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
