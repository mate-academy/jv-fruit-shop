package core.basesyntax;

import core.basesyntax.service.DataProcess;
import core.basesyntax.service.FruitTransaction;
import core.basesyntax.service.operation.BalanceOperationHandler;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.PurchaseOperationHandler;
import core.basesyntax.service.operation.ReturnOperationHandler;
import core.basesyntax.service.operation.SupplyOperationHandler;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> operationServiceMap = new HashMap<>();
        operationServiceMap.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler());
        operationServiceMap.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler());
        operationServiceMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler());
        operationServiceMap.put(FruitTransaction.Operation.RETURN, new ReturnOperationHandler());
        DataProcess dataProcess = new DataProcess(operationServiceMap);
        String fileFrom = "inputFile.scv";
        String data = "type,fruit,quantity\n"
                + "b,banana,20\n"
                + "b,apple,100\n"
                + "s,banana,100\n"
                + "p,banana,13\n"
                + "r,apple,10\n"
                + "p,apple,20\n"
                + "p,banana,5\n"
                + "s,banana,50";

        try {
            Files.write(new File(fileFrom).toPath(), data.getBytes());
        } catch (IOException e) {
            throw new RuntimeException();
        }

        String fileTo = "outputFile.scv";
        dataProcess.processReport(fileFrom, fileTo);
    }

}
