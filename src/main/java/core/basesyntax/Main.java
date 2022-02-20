package core.basesyntax;

import core.basesyntax.models.TransactionDto;
import core.basesyntax.services.FileReader;
import core.basesyntax.services.FileWriter;
import core.basesyntax.services.OperationHandler;
import core.basesyntax.services.Parser;
import core.basesyntax.services.ReportMaker;
import core.basesyntax.services.Validator;
import core.basesyntax.services.impl.FileReaderImpl;
import core.basesyntax.services.impl.FileWriterImpl;
import core.basesyntax.services.impl.ParserImpl;
import core.basesyntax.services.impl.ReportMakerImpl;
import core.basesyntax.services.impl.ValidatorImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.List;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/data.csv";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/report.csv";

    public static void main(String[] args) {
        FileReader fileReader = new FileReaderImpl();
        Validator validator = new ValidatorImpl();
        Parser<TransactionDto> parser = new ParserImpl(validator);
        OperationStrategy operationStrategy = new OperationStrategyImpl();
        FileWriter fileWriter = new FileWriterImpl();
        ReportMaker reportMaker = new ReportMakerImpl();
        List<String> lines = fileReader.read(INPUT_FILE_PATH);
        List<TransactionDto> transactions = parser.parse(lines);
        for (TransactionDto transactionDto : transactions) {
            String operation = transactionDto.getOperation();
            OperationHandler operationHandler = operationStrategy.getOperationHandler(operation);
            operationHandler.apply(transactionDto);
        }
        String report = reportMaker.createReport();
        fileWriter.write(OUTPUT_FILE_PATH, report);
    }
}
