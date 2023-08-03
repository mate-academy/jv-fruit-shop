package core.basesyntax;

import core.basesyntax.filedata.DataConvertor;
import core.basesyntax.filedata.DataConvertorImpl;
import core.basesyntax.filedata.FileReader;
import core.basesyntax.filedata.FileReaderImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.report.ReportRecorder;
import core.basesyntax.report.ReportRecorderImpl;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.FruitShopServiceImpl;
import core.basesyntax.service.strategy.BalanceOperationHandler;
import core.basesyntax.service.strategy.OperationHandler;
import core.basesyntax.service.strategy.PurchaseOperationHandler;
import core.basesyntax.service.strategy.ReturnOperationHandler;
import core.basesyntax.service.strategy.SupplyOperationHandler;
import core.basesyntax.storage.FruitStorage;
import core.basesyntax.writer.FileWriter;
import core.basesyntax.writer.FileWriterImpl;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static final String FROM_FILE_NAME = "src/main/resources/input.csv";
    public static final String TO_FILE_NAME = "src/main/resources/report/report.csv";

    public static void main(String[] args) {
        FileReader fileReader = new FileReaderImpl();
        DataConvertor dataConvertor = new DataConvertorImpl();
        FruitShopService fruitShopService = new FruitShopServiceImpl(initMap());
        ReportRecorder reportRecorder = new ReportRecorderImpl();
        FileWriter fileWriter = new FileWriterImpl();

        String[] fileData = fileReader.readFromFile(new File(FROM_FILE_NAME));
        List<FruitTransaction> fruitTransactions = dataConvertor.convertData(fileData);
        fruitShopService.processAll(fruitTransactions);
        List<String> storageData = reportRecorder.getStorageData(FruitStorage.storageMap);
        fileWriter.writeToFile(storageData, TO_FILE_NAME);
    }

    private static Map<FruitTransaction.Operation, OperationHandler> initMap() {
        Map<FruitTransaction.Operation, OperationHandler> strategyMap = new HashMap<>();
        strategyMap.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler());
        strategyMap.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler());
        strategyMap.put(FruitTransaction.Operation.RETURN, new ReturnOperationHandler());
        strategyMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler());
        return strategyMap;
    }
}
