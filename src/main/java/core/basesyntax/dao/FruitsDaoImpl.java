package core.basesyntax.dao;

import core.basesyntax.model.FruitTransaction;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FruitsDaoImpl implements FruitsDao {
    private static final int FIRST_ELEMENT = 0;
    private static final int SECOND_ELEMENT = 1;
    private static final int THIRD_ELEMENT = 2;
    private List<FruitTransaction> fruitsData;

    public FruitsDaoImpl() {
        fruitsData = new ArrayList<>();
    }

    @Override
    public List<FruitTransaction> getFruitsData(String fromFile) {
        try (BufferedReader fileReader = new BufferedReader(new FileReader((fromFile)))) {
            String lineFromFile = fileReader.readLine();
            while (lineFromFile != null) {
                String[] lineParts = lineFromFile.split(",");
                FruitTransaction fruitTransaction = new FruitTransaction();
                fruitTransaction.setOperation(FruitTransaction.Operation
                        .fromCode(lineParts[FIRST_ELEMENT]));
                fruitTransaction.setFruit(lineParts[SECOND_ELEMENT]);
                fruitTransaction.setQuantity(Integer.parseInt(lineParts[THIRD_ELEMENT]));
                fruitsData.add(fruitTransaction);
                lineFromFile = fileReader.readLine();
            }
            return fruitsData;
        } catch (IOException cat) {
            throw new RuntimeException("Can't read the file!" + cat);
        }
    }
}
