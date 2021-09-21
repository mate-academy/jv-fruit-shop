package core.basesyntax;

import core.basesyntax.dao.DAoService;
import core.basesyntax.dao.DAoServiceImp;
import core.basesyntax.dto.CSvFruitRecordsValidator;
import core.basesyntax.dto.CSvParseService;
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
    private static final String destFile = "D:\\Programming\\MATE_ACCADEMY\\"
            + "\\jv-fruit-shop\\src\\main"
            + "\\java\\core\\basesyntax\\source\\storage.csv";
    private static final String sourceFile = "D:\\Programming\\MATE_ACCADEMY"
            + "\\jv-fruit-shop\\src\\main"
            + "\\java\\core\\basesyntax\\source\\data.csv";

    public static void main(String[] args) {
        FileService fileService = new CSvFileService();
        String dataFromFileSource = fileService.readeDataFromFileSource(sourceFile);
        Operator operator = new Operator();
        operatorInitialization(operator);
        FruitRecordsValidator validator = new CSvFruitRecordsValidator();
        validator.testForValid(dataFromFileSource,operator);
        ParseService parseService = new CSvParseService();
        List<FruitRecord> fruitRecords = parseService
                .convertStringDataIntoFruitRecordList(dataFromFileSource);
        DAoService storageService = new DAoServiceImp(new Storage());

        operator.doAllOperation(fruitRecords, storageService);
        String dataToWrite = parseService
                .convertStorageDataIntoWritableString(storageService.getSetOfFruitsInStorage());
        fileService.writeReportToFile(dataToWrite, destFile);
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
