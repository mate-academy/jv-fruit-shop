package core.basesyntax;

import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.CsvParserService;
import core.basesyntax.service.ValidatorService;
import core.basesyntax.service.impl.CsvParserServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ShopServiceImpl;
import core.basesyntax.service.impl.ValidatorServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.AddOperationHandler;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.PurchaseOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/inputFile.csv";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/outputFile.csv";

    public static void main(String[] args) {
        List<String> dataFromFile = new ReaderServiceImpl().readFromFile(INPUT_FILE_PATH);
        ValidatorService<String> validatorService = new ValidatorServiceImpl();
        CsvParserService<TransactionDto> parserService = new CsvParserServiceImpl(validatorService);

        Map<String, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put("b", new AddOperationHandler());
        operationHandlerMap.put("r", new AddOperationHandler());
        operationHandlerMap.put("s", new AddOperationHandler());
        operationHandlerMap.put("p", new PurchaseOperationHandler());

        List<TransactionDto> transactionDtoList = parserService.parse(dataFromFile);
        for (TransactionDto transactionDto : transactionDtoList) {
            String operation = transactionDto.getOperation();
            OperationHandler operationHandler = operationHandlerMap.get(operation);
            operationHandler.apply(transactionDto);
        }

        List<String> report = new ShopServiceImpl().createReport();
        new WriterServiceImpl().writeToFile(OUTPUT_FILE_PATH, report);
    }
}
