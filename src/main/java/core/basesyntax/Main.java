package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.dto.FruitRecordDto;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.FruitOperation;
import core.basesyntax.service.FruitRecordParser;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.impl.AddOperation;
import core.basesyntax.service.impl.BalanceOperation;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.FileWriterImpl;
import core.basesyntax.service.impl.FruitRecordParserImpl;
import core.basesyntax.service.impl.OperationType;
import core.basesyntax.service.impl.PurchaseOperation;
import core.basesyntax.service.impl.ReportCreatorCsvImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FILE_FROM = "src/main/resources/shop_operations.csv";
    private static final String FILE_TO = "src/main/resources/report_after_work.csv";

    public static void main(String[] args) {
        FruitOperation balanceOperation = new BalanceOperation();
        FruitOperation returnOperation = new AddOperation();
        FruitOperation supplyOperation = new AddOperation();
        FruitOperation purchaseOperation = new PurchaseOperation();

        Map<OperationType, FruitOperation> operationHandlers = new HashMap<>();
        operationHandlers.put(OperationType.BALANCE, balanceOperation);
        operationHandlers.put(OperationType.RETURN, returnOperation);
        operationHandlers.put(OperationType.SUPPLY, supplyOperation);
        operationHandlers.put(OperationType.PURCHASE, purchaseOperation);

        FileReader fileReader = new FileReaderImpl();
        FruitRecordParser fruitRecordParser = new FruitRecordParserImpl();
        List<FruitRecordDto> dtos = fruitRecordParser.parse(fileReader.readFile(FILE_FROM));
        for (FruitRecordDto dto : dtos) {
            operationHandlers.get(dto.getOperationType()).apply(dto);
        }

        ReportCreator reportMaker = new ReportCreatorCsvImpl();
        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.writeFile(FILE_TO, reportMaker.createReport(Storage.fruits));
    }
}
