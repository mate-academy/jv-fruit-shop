package core.basesyntax;

import core.basesyntax.fruitshop.model.OperationType;
import core.basesyntax.fruitshop.model.TransactionDto;
import core.basesyntax.fruitshop.service.FileReaderService;
import core.basesyntax.fruitshop.service.FileReaderServiceImpl;
import core.basesyntax.fruitshop.service.FileWriterService;
import core.basesyntax.fruitshop.service.FileWriterServiceImpl;
import core.basesyntax.fruitshop.service.FruitShopServiceImpl;
import core.basesyntax.fruitshop.service.TransactionDtoService;
import core.basesyntax.fruitshop.service.TransactionDtoServiceImpl;
import core.basesyntax.fruitshop.service.operation.BalanceOperationHandler;
import core.basesyntax.fruitshop.service.operation.OperationHandler;
import core.basesyntax.fruitshop.service.operation.PurchaseOperationHandler;
import core.basesyntax.fruitshop.service.operation.ReturnOperationHandler;
import core.basesyntax.fruitshop.service.operation.SupplyOperationHandler;
import core.basesyntax.fruitshop.storage.Storage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        FileReaderService readerService = new FileReaderServiceImpl();
        TransactionDtoService service = new TransactionDtoServiceImpl();
        List<String> stringList = readerService.readFile("src//main//resources//fruitShop.csv");
        service.createDto(stringList);
        Map<OperationType, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(OperationType.BALANCE, new BalanceOperationHandler());
        operationHandlerMap.put(OperationType.SUPPLY, new SupplyOperationHandler());
        operationHandlerMap.put(OperationType.PURCHASE, new PurchaseOperationHandler());
        operationHandlerMap.put(OperationType.RETURN, new ReturnOperationHandler());
        List<TransactionDto> transactionDtoList = new ArrayList<>(Storage.transactionList);
        for (TransactionDto transaction : transactionDtoList) {
            OperationHandler operationHandler = operationHandlerMap
                    .get(transaction.getOperationType());
            operationHandler.applyOperation(transaction);
        }
        String fruitShopReport = new FruitShopServiceImpl().createReport();
        String fruitShopReportFile = "src//main//resources//reportFile.csv";
        FileWriterService fileWriterService = new FileWriterServiceImpl();
        fileWriterService.writeToFile(fruitShopReport, fruitShopReportFile);
    }
}
