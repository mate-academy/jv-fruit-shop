package core.basesyntax;

import core.basesyntax.model.FruitTransfer;
import core.basesyntax.service.ConvertToFruitTransferService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.ConvertToFruitTransferServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.BalanceOperationHandler;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.PurchaseOperationHandler;
import core.basesyntax.strategy.ReturnOperationHandler;
import core.basesyntax.strategy.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static final String INPUT_FILE_PATH = "src/main/resources/fruits.csv";
    public static final String OUTPUT_FILE_PATH = "src/main/resources/output.csv";

    public static void main(String[] args) {
        ReaderService reader = new ReaderServiceImpl();
        Map<FruitTransfer.Operation, OperationHandler> operationMap = new HashMap<>();
        operationMap.put(FruitTransfer.Operation.BALANCE, new BalanceOperationHandler());
        operationMap.put(FruitTransfer.Operation.PURCHASE, new PurchaseOperationHandler());
        operationMap.put(FruitTransfer.Operation.RETURN, new ReturnOperationHandler());
        operationMap.put(FruitTransfer.Operation.SUPPLY, new SupplyOperationHandler());
        List<String> strings = reader.readFromFile(INPUT_FILE_PATH);
        ConvertToFruitTransferService convert = new ConvertToFruitTransferServiceImpl();
        for (int i = 1; i < strings.size(); i++) {
            FruitTransfer transfer = convert.toFruitTransfer(strings.get(i));
            operationMap.get(transfer.getOperation()).process(transfer);
        }
        ReportService reportService = new ReportServiceImpl();
        String report = reportService.getReport();
        WriterService writerService = new WriterServiceImpl();
        writerService.writeToFile(OUTPUT_FILE_PATH, report);
    }
}
