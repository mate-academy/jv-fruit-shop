package core.basesyntax;

import core.basesyntax.dto.FruitDto;
import core.basesyntax.services.FileReaderService;
import core.basesyntax.services.FileWriterService;
import core.basesyntax.services.Report;
import core.basesyntax.services.Transaction;
import core.basesyntax.services.implementation.FileReaderImpl;
import core.basesyntax.services.implementation.FileWriterImpl;
import core.basesyntax.services.implementation.ReportImpl;
import core.basesyntax.services.implementation.TransactionImpl;
import core.basesyntax.services.operations.OperationBalance;
import core.basesyntax.services.operations.OperationHandler;
import core.basesyntax.services.operations.OperationPurchase;
import core.basesyntax.services.operations.OperationSupply;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FILE_FOR_READ = "src/main/resources/fruits.csv";
    private static final String FILE_FOR_WRITE = "src/main/resources/report.csv";

    public static void main(String[] args) {
        Map<String, OperationHandler> handlerOperations = new HashMap<>();
        handlerOperations.put("p", new OperationPurchase());
        handlerOperations.put("s", new OperationSupply());
        handlerOperations.put("b", new OperationBalance());
        handlerOperations.put("r", new OperationSupply());

        FileReaderService fileReaderService = new FileReaderImpl();
        List<String> infoFromFile = fileReaderService.read(FILE_FOR_READ);

        Transaction transaction = new TransactionImpl();
        List<FruitDto> fruitDtos = transaction.parseFruits(infoFromFile);
        for (FruitDto fruitDto : fruitDtos) {
            OperationHandler operationHandler = handlerOperations
                    .get(fruitDto.getTypeOfOperation());
            operationHandler.apply(fruitDto);
        }
        Report report = new ReportImpl();
        String reportInfo = report.makeReport();

        FileWriterService fileWriterService = new FileWriterImpl();
        fileWriterService.write(reportInfo, FILE_FOR_WRITE);
    }
}
