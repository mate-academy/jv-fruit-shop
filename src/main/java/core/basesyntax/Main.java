package core.basesyntax;

import core.basesyntax.dao.ReadFromAndWriteToFileDaoImpl;
import core.basesyntax.dao.ReadFromFileDao;
import core.basesyntax.dao.WriteToFileDao;
import core.basesyntax.db.FruitDb;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.CheckDataService;
import core.basesyntax.service.ConverterDataToFruitTransactionService;
import core.basesyntax.service.ConverterDayReportMapToStringService;
import core.basesyntax.service.DayReportCalculatorService;
import core.basesyntax.service.impl.CheckDataServiceImpl;
import core.basesyntax.service.impl.ConverterDataToFruitTransactionServiceImpl;
import core.basesyntax.service.impl.ConverterDayReportMapToStringServiceImpl;
import core.basesyntax.service.impl.DayReportCalculatorServiceImpl;
import core.basesyntax.service.impl.OperationStrategyImpl;
import core.basesyntax.service.strategy.BalanceOperationHandler;
import core.basesyntax.service.strategy.OperationHandler;
import core.basesyntax.service.strategy.PurchaseOperationHandler;
import core.basesyntax.service.strategy.ReturnOperationHandler;
import core.basesyntax.service.strategy.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static final String DAY_ACTIVITY_CSV
            = "src/main/resources/dayActivities.csv";
    public static final String DAY_REPORT_CSV
            = "src/main/resources/dayReport.csv";
    public static final String REPORT_TITLE = "fruit,quantity";
    public static final String DATA_FILE_TITLE = "type,fruit,quantity";
    private static ReadFromFileDao readFromFileDao;
    private static CheckDataService checkDataService;
    private static ConverterDataToFruitTransactionService convertDataToFruitTransactionService;
    private static DayReportCalculatorService dayReportCalculatorService;
    private static FruitDb fruitDb;
    private static ConverterDayReportMapToStringService converterDayReportMapToStringService;
    private static WriteToFileDao writeToFileDao;
    private static final Map<Operation, OperationHandler> operationHandlerMap = new HashMap<>();

    static {
        operationHandlerMap.put(Operation.BALANCE, new BalanceOperationHandler());
        operationHandlerMap.put(Operation.SUPPLY, new SupplyOperationHandler());
        operationHandlerMap.put(Operation.PURCHASE, new PurchaseOperationHandler());
        operationHandlerMap.put(Operation.RETURN, new ReturnOperationHandler());
    }

    public static void main(String[] args) {
        ReadFromAndWriteToFileDaoImpl readAndWriteFileDao =
                new ReadFromAndWriteToFileDaoImpl();

        readFromFileDao = readAndWriteFileDao;
        checkDataService = new CheckDataServiceImpl();
        convertDataToFruitTransactionService =
                new ConverterDataToFruitTransactionServiceImpl();
        dayReportCalculatorService = new DayReportCalculatorServiceImpl(
                new OperationStrategyImpl(operationHandlerMap));
        fruitDb = new FruitDb();
        converterDayReportMapToStringService =
                new ConverterDayReportMapToStringServiceImpl();
        writeToFileDao = readAndWriteFileDao;

        List<String> dataFromFileList =
                readFromFileDao.readFromFile(DAY_ACTIVITY_CSV);

        checkDataService.checkData(dataFromFileList);

        List<FruitTransaction> fruitTransactionList =
                convertDataToFruitTransactionService
                        .convertToFruitTransaction(dataFromFileList);

        Map<String, Integer> dayReportMap =
                dayReportCalculatorService.reportCalculator(fruitTransactionList);

        checkDataService.checkingDataMapBeforeSavingToDb(dayReportMap);

        fruitDb.setBalanceMap(dayReportMap);

        Map<String, Integer> balanceMapFromDB = fruitDb.getBalanceMap();

        String dayReportString =
                converterDayReportMapToStringService.convertReportToString(balanceMapFromDB);

        writeToFileDao.writeToFile(DAY_REPORT_CSV, dayReportString);
    }
}
