package core.basesyntax;

import core.basesyntax.dao.FruitDaoService;
import core.basesyntax.dao.FruitDaoServiceImp;
import core.basesyntax.dto.CsvFruitRecordsValidator;
import core.basesyntax.dto.FruitRecordParser;
import core.basesyntax.dto.FruitRecordsValidator;
import core.basesyntax.dto.Operator;
import core.basesyntax.dto.ParseService;
import core.basesyntax.dto.handlers.BalanceOperationHandler;
import core.basesyntax.dto.handlers.OperationsHandler;
import core.basesyntax.dto.handlers.PurchaseOperationHandler;
import core.basesyntax.dto.handlers.ReturnOperationHandler;
import core.basesyntax.dto.handlers.SupplyOperationHandler;
import core.basesyntax.files.CSvFileService;
import core.basesyntax.files.FileService;
import core.basesyntax.models.FruitRecord;
import core.basesyntax.storage.Storage;
import java.util.List;
import java.util.Map;

public class HelloWorld {
    private static final String destFile = "src\\main"
            + "\\java\\core\\basesyntax\\source\\storage.csv";
    private static final String sourceFile = "src\\main"
            + "\\java\\core\\basesyntax\\source\\data.csv";

    public static void main(String[] args) {
        FileService fileService = new CSvFileService();
        String dataFromFileSource = fileService.readData(sourceFile);
        Operator operator = new Operator();
        operatorInitialization(operator);
        FruitRecordsValidator validator = new CsvFruitRecordsValidator();
        validator.testForValid(dataFromFileSource,operator);
        ParseService parseService = new FruitRecordParser();
        List<FruitRecord> fruitRecords = parseService
                .parseFromCsv(dataFromFileSource);
        FruitDaoService storageService = new FruitDaoServiceImp(new Storage());

        operator.doAllOperation(fruitRecords, storageService);
        String dataToWrite = parseService
                .parseIntoCsv(storageService.get());
        fileService.writeData(dataToWrite, destFile);
    }

    private static Operator operatorInitialization(Operator operator) {
        Map<Character, OperationsHandler> typesOfOperations = operator.getTypesOfOperations();
        typesOfOperations.put('b', new BalanceOperationHandler());
        typesOfOperations.put('p', new PurchaseOperationHandler());
        typesOfOperations.put('r', new ReturnOperationHandler());
        typesOfOperations.put('s', new SupplyOperationHandler());
        return operator;
    }
}
