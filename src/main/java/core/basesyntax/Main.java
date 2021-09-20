package core.basesyntax;

//
import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportMaker;
import core.basesyntax.service.TransactionDto;
import core.basesyntax.service.fileService.ReadFromFile;
import core.basesyntax.service.fileService.WriteToFile;
import core.basesyntax.service.operationTypes.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 1. Read file
// 2. convert file to storage
// 3. read report

public class Main {
    private static final String TO_FILE_NAME = "result.csv";
    private static final String FROM_FILE_NAME = "fruitsData.csv";
    public static void main(String[] args) {
        Map<String, OperationTypeHandler> strategy = new HashMap<>();
        strategy.put(String.valueOf(Operations.r), new ReturnOperationHandler());
        strategy.put(String.valueOf(Operations.b), new BalanceOperationHandler());
        strategy.put(String.valueOf(Operations.p), new PurchaseOperationHandler());
        strategy.put(String.valueOf(Operations.s), new SupplyOperationHandler());
        OperationStrategy operationStrategyMap = new OperationStrategyImpl(strategy);
        TransactionDto transactionDto = new TransactionDto();
        ReportMaker reportMaker = new ReportMaker();
        ReadFromFile readFromFile = new ReadFromFile();
        WriteToFile writeToFile = new WriteToFile();
        List<String> data =  readFromFile.read(FROM_FILE_NAME);
        transactionDto.convertFromListToDb(data, operationStrategyMap);
        String report = reportMaker.make(Storage.fruits);
        writeToFile.writeToCsv(report, TO_FILE_NAME);
    }
}
