package core.basesyntax;

import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.*;
import core.basesyntax.service.impl.*;
import core.basesyntax.strategy.AddOperationHandler;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.Strategy;
import core.basesyntax.strategy.SubtractOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String OUTPUT_PATH = "./src/main/java/output.csv";
    private static final String INPUT_PATH = "./src/main/java/input.csv";

    public static void main(String[] args) {
        Map<String, OperationHandler> strategyMap = new HashMap<>();
        strategyMap.put("b", new AddOperationHandler());
        strategyMap.put("s", new AddOperationHandler());
        strategyMap.put("p", new SubtractOperationHandler());
        strategyMap.put("r", new AddOperationHandler());

        FileReader fileReader = new CsvFileReader();
        List<String> fromFile = fileReader.readFile(INPUT_PATH);

        Validator validator = new ValidatorImpl();
        Parser<TransactionDto> parser = new ParserImpl(validator);
        List<TransactionDto> transactionDtos = parser.parse(fromFile);

        Strategy strategy = new Strategy(strategyMap);
        for (TransactionDto transactionDto : transactionDtos) {
            OperationHandler handler = strategy.getHandler(transactionDto);
            handler.apply(transactionDto);

        }

        CreateReport createReport = new CreateReportImpl();
        FileWriter fileWriter = new CsvFileWriter();
        String report = createReport.getReport();
        fileWriter.write(OUTPUT_PATH, report);
        System.out.println(report);
    }
}
