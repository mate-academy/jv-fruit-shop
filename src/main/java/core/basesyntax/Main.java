package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CalculateService;
import core.basesyntax.service.DataParseService;
import core.basesyntax.service.FileReadService;
import core.basesyntax.service.ReportMakerService;
import core.basesyntax.service.WriteDataToFileService;
import core.basesyntax.service.impl.CalculateServiceImpl;
import core.basesyntax.service.impl.DataParseServiceImpl;
import core.basesyntax.service.impl.FileReadServiceImpl;
import core.basesyntax.service.impl.ReportMakerServiceImpl;
import core.basesyntax.service.impl.WriteDataToFileServiceImpl;
import core.basesyntax.strategy.OperationHandlerImpl;
import core.basesyntax.strategy.StoreActivities;
import core.basesyntax.strategy.impl.BalanceActivity;
import core.basesyntax.strategy.impl.PurchaseActivity;
import core.basesyntax.strategy.impl.ReturnActivity;
import core.basesyntax.strategy.impl.SupplyActivity;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FROM_FILE_PATH =
            "src//main//java//core//basesyntax//resources//beforeReport.csv";
    private static final String TO_FILE_PATH =
            "src//main//java//core//basesyntax//resources//report.csv";

    public static void main(String[] args) {
        FileReadService fileReadService = new FileReadServiceImpl();
        DataParseService dataParseService = new DataParseServiceImpl();
        Map<FruitTransaction.Operation, StoreActivities> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceActivity());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseActivity());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyActivity());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN,
                new ReturnActivity());
        OperationHandlerImpl handler = new OperationHandlerImpl(operationHandlerMap);
        CalculateService calculateService = new CalculateServiceImpl(handler);
        ReportMakerService reportMakerService = new ReportMakerServiceImpl();
        WriteDataToFileService writeDataToFileService = new WriteDataToFileServiceImpl();

        List<String> readData = fileReadService.readDataFromFile(FROM_FILE_PATH);
        List<FruitTransaction> parsedData = dataParseService.getParsedData(readData);
        calculateService.calculate(parsedData);
        String report = reportMakerService.makeReport(Storage.getStorage());
        writeDataToFileService.writeReport(report, TO_FILE_PATH);
    }
}
