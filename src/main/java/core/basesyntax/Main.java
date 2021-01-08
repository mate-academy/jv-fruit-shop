package core.basesyntax;

import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.MyFileReader;
import core.basesyntax.service.MyFileWriter;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.impl.MyFileReaderCsvImpl;
import core.basesyntax.service.impl.MyFileWriterCsvImpl;
import core.basesyntax.service.impl.ParseCsvImpl;
import core.basesyntax.stratege.BalanceStrategy;
import core.basesyntax.stratege.OperationStrategy;
import core.basesyntax.stratege.PurchaseStrategy;
import core.basesyntax.stratege.ReturnStrategy;
import core.basesyntax.stratege.SupplyStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String NAME_FILE = "src/main/resources/fruit-shop.csv";
    private static final String NAME_FILE_FOR_REPORT = "src/main/resources/report-fruit-shop.csv";
    private static Map<Operation, OperationStrategy> operationMap = new HashMap<>();

    public static void main(String[] args) {
        MyFileReader myFileReaderCsv = new MyFileReaderCsvImpl();
        List<String> fruitsFromFile = myFileReaderCsv.readFromFile(NAME_FILE);
        ParseCsvImpl parseCsvImpl = new ParseCsvImpl();
        List<TransactionDto> transactionDtoList = parseCsvImpl.parse(fruitsFromFile);
        operationMap = addAllOperationsToMap(operationMap);
        FruitService fruitService = new FruitServiceImpl(operationMap);
        fruitService.selectOperationAndWriteToStorage(transactionDtoList);
        MyFileWriter myFileWriter = new MyFileWriterCsvImpl();
        String dataForWrite = fruitService.prepareDataForReport();
        myFileWriter.writeToFile(NAME_FILE_FOR_REPORT, dataForWrite);
    }

    private static Map<Operation, OperationStrategy> addAllOperationsToMap(Map<Operation,
            OperationStrategy> mapForAddingOperation) {
        mapForAddingOperation.put(Operation.BALANCE, new BalanceStrategy());
        mapForAddingOperation.put(Operation.SUPPLY, new SupplyStrategy());
        mapForAddingOperation.put(Operation.RETURN, new ReturnStrategy());
        mapForAddingOperation.put(Operation.PURCHASE, new PurchaseStrategy());
        return mapForAddingOperation;
    }
}
