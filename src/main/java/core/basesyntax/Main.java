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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        final String pathToFile = "src//main//resources//fruitShop.csv";
        final String fruitShopReportFile = "src//main//resources//reportFile.csv";
        Map<OperationType, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(OperationType.BALANCE, new BalanceOperationHandler());
        operationHandlerMap.put(OperationType.SUPPLY, new SupplyOperationHandler());
        operationHandlerMap.put(OperationType.PURCHASE, new PurchaseOperationHandler());
        operationHandlerMap.put(OperationType.RETURN, new ReturnOperationHandler());
        FileReaderService readerService = new FileReaderServiceImpl();
        TransactionDtoService dtoService = new TransactionDtoServiceImpl();
        List<String> activities = readerService.readFile(pathToFile);
        List<TransactionDto> transaction = dtoService.createDto(activities);
        FruitShopServiceImpl fruitShopService = new FruitShopServiceImpl(operationHandlerMap);
        fruitShopService.applyOperationsOnTransactionDto(transaction);
        FileWriterService fileWriterService = new FileWriterServiceImpl();
        fileWriterService.writeToFile(fruitShopService.createReport(), fruitShopReportFile);
    }
}
