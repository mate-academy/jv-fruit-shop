package core.basesyntax;

import core.basesyntax.files.FileReaderServiceImpl;
import core.basesyntax.files.FileWriterService;
import core.basesyntax.files.FileWriterServiceImpl;
import core.basesyntax.service.DataInputParser;
import core.basesyntax.service.DataInputParserImpl;
import core.basesyntax.service.DataOutputParser;
import core.basesyntax.service.DataOutputParserImpl;
import core.basesyntax.service.FruitTransaction;
import core.basesyntax.service.OperationProcess;
import core.basesyntax.service.OperationProcessImpl;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FileReaderServiceImpl fileReaderService = new FileReaderServiceImpl();
        DataInputParser dataParser = new DataInputParserImpl();
        List<String> dataFromFile = fileReaderService
                .readFromFile("src\\main\\java\\core\\basesyntax\\test.csv");
        List<FruitTransaction> fruitTransactionList = dataParser.parseData(dataFromFile);
        System.out.println(fruitTransactionList);
        OperationProcess operationProcess = new OperationProcessImpl();
        operationProcess.processData(fruitTransactionList);
        DataOutputParser dataOutputParser = new DataOutputParserImpl();
        String report = dataOutputParser.parseData();
        FileWriterService fileWriterService = new FileWriterServiceImpl();
        fileWriterService.write(report, "dailyReport");
    }
}
