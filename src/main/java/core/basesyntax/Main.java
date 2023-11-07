package core.basesyntax;

import core.basesyntax.dao.BalanceOperation;
import core.basesyntax.dao.FruitOperation;
import core.basesyntax.dao.HandleOperationsFromListImpl;
import core.basesyntax.dao.Operation;
import core.basesyntax.dao.PurchaseOperation;
import core.basesyntax.dao.ReturnOperation;
import core.basesyntax.dao.SupplyOperation;
import core.basesyntax.service.FileServiceImpl;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final String READ_FILE_NAME = "file.csv";
    private static final String WRITE_FILE_NAME = "report_file.csv";

    public static void main(String[] args) {
        Map<Operation, FruitOperation> operationMap = new HashMap<>();
        operationMap.put(Operation.BALANCE, new BalanceOperation());
        operationMap.put(Operation.SUPPLY, new SupplyOperation());
        operationMap.put(Operation.RETURN, new ReturnOperation());
        operationMap.put(Operation.PURCHASE, new PurchaseOperation());

        FileServiceImpl fileService = new FileServiceImpl();
        HandleOperationsFromListImpl stringToDB = new HandleOperationsFromListImpl();

        fileService.createReport(stringToDB.getMapReport(fileService
                .readFromFile(READ_FILE_NAME), operationMap), WRITE_FILE_NAME);
    }
}
