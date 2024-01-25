package core.basesyntax.service.readfromfileservice.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.chosefruitoperationservice.impl.FruitOperationStrategyImpl;
import core.basesyntax.service.readfromfileservice.ReadFromFileService;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFromFileCsvServiceImpl implements ReadFromFileService {
    public List<FruitTransaction> readFromCsvFile(String filePath) {
        List<FruitTransaction> dataFromFile = new ArrayList<>();
        FruitOperationStrategyImpl fruitOperationStrategy = new FruitOperationStrategyImpl();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String value = bufferedReader.readLine();
            value = bufferedReader.readLine();
            while (value != null) {
                String[] valueArray = value.split(",");
                FruitTransaction fruitTransaction = new FruitTransaction();
                fruitTransaction.setOperation(fruitOperationStrategy
                        .getOperation(valueArray[0].trim()).getOperation());
                fruitTransaction.setFruit(valueArray[1]);
                fruitTransaction.setQuantity(Integer.parseInt(valueArray[2]));
                dataFromFile.add(fruitTransaction);
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file " + e);
        }
        return dataFromFile;
    }
}
