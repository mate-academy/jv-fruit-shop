package core.basesyntax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Operation;
import service.FileService;
import service.FruitService;
import service.OperationHandler;
import service.ReportService;
import service.Strategy;
import service.TransactionDtoParse;
import service.Validator;
import service.impl.BalanceOperation;
import service.impl.FileServiceImpl;
import service.impl.FruitServiceImpl;
import service.impl.PurchaseOperation;
import service.impl.ReportServiceImpl;
import service.impl.ReturnOperation;
import service.impl.StrategyImpl;
import service.impl.SupplyOperation;
import service.impl.TransactionDto;
import service.impl.TransactionDtoParseImpl;
import service.impl.ValidatorImpl;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/inputFile";
    private static final String REPORT_FILE_PATH = "src/main/resources/reportFile";

    public static void main(String[] args) {
        Map<String, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(Operation.BALANCE.getOperation(), new BalanceOperation());
        operationHandlerMap.put(Operation.PURCHASE.getOperation(), new PurchaseOperation());
        operationHandlerMap.put(Operation.RETURN.getOperation(), new ReturnOperation());
        operationHandlerMap.put(Operation.SUPPLY.getOperation(), new SupplyOperation());
        FileService fileService = new FileServiceImpl();
        Strategy strategy = new StrategyImpl(operationHandlerMap);
        Validator validator = new ValidatorImpl();
        List<String> inputValues = fileService.readFromFile(INPUT_FILE_PATH);
        TransactionDtoParse transactionDtoParse = new TransactionDtoParseImpl(validator);
        List<TransactionDto> parsedData = transactionDtoParse.parseData(inputValues);
        FruitService transactionData = new FruitServiceImpl(strategy);
        transactionData.saveDataToDb(parsedData);
        ReportService valueReport = new ReportServiceImpl();
        fileService.writeToReportFile(valueReport.getReport(), REPORT_FILE_PATH);
    }
}
