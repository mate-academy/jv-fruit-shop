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
import core.basesyntax.service.workwithfile.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitMain {
    public static void main(String[] args) {
        FileReader fileReader = new FileReaderImpl();
        List<String> readerList = fileReader.readFromFile("shop_operations.csv");
        FruitRecordDtoParser fruitRecordDtoParser = new FruitRecordDtoParserImpl();
        List<FruitRecordDto> fruitRecordDtos = fruitRecordDtoParser.parse(readerList);
        FruitOperation addOperation = new AddOperation();
        FruitOperation removeOperation = new RemoveOperation();
        Map<OperationType,FruitOperation> fruitOperationMap = new HashMap<>();
        fruitOperationMap.put(OperationType.b, addOperation);
        fruitOperationMap.put(OperationType.p, removeOperation);
        fruitOperationMap.put(OperationType.s, addOperation);
        fruitOperationMap.put(OperationType.r, addOperation);
        SaveDataToStorage saveDataToStorage = new SaveDataToStorageImpl();
        saveDataToStorage.saveData(fruitRecordDtos,fruitOperationMap);
        Report reported = new ReportImpl();
        String report = reported.report(saveDataToStorage);
        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.writeData(report,"save_report.csv");


    }

}
