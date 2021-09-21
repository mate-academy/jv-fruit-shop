package core.basesyntax;

import core.basesyntax.dao.DAoService;
import core.basesyntax.dao.DAoServiceImp;
import core.basesyntax.dto.Operator;
import core.basesyntax.dto.handlers.BalanceOperationHandler;
import core.basesyntax.dto.handlers.OperationsHandler;
import core.basesyntax.dto.handlers.PurchaseOperationHandler;
import core.basesyntax.dto.handlers.ReturnOperationHandler;
import core.basesyntax.dto.handlers.SupplyOperationHandler;
import core.basesyntax.fileManager.CSvFileService;
import core.basesyntax.fileManager.FileService;
import core.basesyntax.models.FruitRecord;
import core.basesyntax.dto.CSvParseService;
import core.basesyntax.dto.ParseService;
import core.basesyntax.storage.Storage;

import java.util.List;
import java.util.Map;

/**
 * Feel free to remove this class and create your own.
 */
public class HelloWorld {
    private final static String destFile = "D:\\Programming\\MATE_ACCADEMY\\jv-fruit-shop\\src\\main" +
            "\\java\\core\\basesyntax\\source\\storage.csv";
    private final static String sourceFile = "D:\\Programming\\MATE_ACCADEMY\\jv-fruit-shop\\src\\main" +
            "\\java\\core\\basesyntax\\source\\data.csv";

    public static void main(String[] args) {
        FileService fileService = new CSvFileService();
        String readeDataFromFileSource = fileService.readeDataFromFileSource(
                new StringBuilder().append(sourceFile).toString());
        ParseService parseService = new CSvParseService();
        List<FruitRecord> fruitRecords = parseService.convertStringDataIntoFruitRecordList(readeDataFromFileSource);
        DAoService storageService = new DAoServiceImp(new Storage());

        Operator operator = new Operator();
        operator = operatorInitialization(operator);

        operator.doAllOperation(fruitRecords,storageService);

        String dataToWrite = parseService.convertStorageDataIntoWritableString(storageService.getSetOfFruitsInStorage());

        fileService.writeReportToFile(dataToWrite,destFile);
        System.out.println();
    }

    private static Operator operatorInitialization(Operator operator){
        Map<Character, OperationsHandler> typesOfOperations = operator.getTypesOfOperations();
        typesOfOperations.put('b', new BalanceOperationHandler());
        typesOfOperations.put('p', new PurchaseOperationHandler());
        typesOfOperations.put('r', new ReturnOperationHandler());
        typesOfOperations.put('s', new SupplyOperationHandler());
        return operator;
    }
}