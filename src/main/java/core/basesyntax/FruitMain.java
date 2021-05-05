package core.basesyntax;

import core.basesyntax.model.dto.FruitRecordDto;
import core.basesyntax.service.FruitOperation;
import core.basesyntax.service.FruitRecordDtoParser;
import core.basesyntax.service.SaveDataToStorage;
import core.basesyntax.service.impl.AddOperation;
import core.basesyntax.service.impl.FruitRecordDtoParserImpl;
import core.basesyntax.service.impl.RemoveOperation;
import core.basesyntax.service.impl.SaveDataToStorageImpl;
import core.basesyntax.service.operations.OperationType;
import core.basesyntax.service.workwithfile.FileReader;
import core.basesyntax.service.workwithfile.FileReaderImpl;
import core.basesyntax.service.workwithfile.FileWriter;
import core.basesyntax.service.workwithfile.FileWriterImpl;
import core.basesyntax.service.workwithfile.Report;
import core.basesyntax.service.workwithfile.ReportImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitMain {
    public static void main(String[] args) {
        FileReader fileReader = new FileReaderImpl();
        List<String> readerList = fileReader.readFromFile("src/main/resources/shop_operations.csv");
        FruitRecordDtoParser fruitRecordDtoParser = new FruitRecordDtoParserImpl();
        FruitOperation addOperation = new AddOperation();
        FruitOperation removeOperation = new RemoveOperation();
        Map<String,FruitOperation> fruitOperationMap = new HashMap<>();
        fruitOperationMap.put(OperationType.BALANCE.getOperation(), addOperation);
        fruitOperationMap.put(OperationType.PURCHASE.getOperation(), removeOperation);
        fruitOperationMap.put(OperationType.SUPPLY.getOperation(), addOperation);
        fruitOperationMap.put(OperationType.RETURN.getOperation(), addOperation);
        List<FruitRecordDto> fruitRecordDtos = fruitRecordDtoParser.parse(readerList);
        SaveDataToStorage saveDataToStorage = new SaveDataToStorageImpl();
        saveDataToStorage.saveData(fruitRecordDtos,fruitOperationMap);
        Report reported = new ReportImpl();
        String report = reported.report(saveDataToStorage);
        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.writeData(report,"src/main/resources/save_report.csv");
    }
}
