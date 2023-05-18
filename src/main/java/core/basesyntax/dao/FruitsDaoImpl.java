package core.basesyntax.dao;

import core.basesyntax.model.FruitTransaction;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FruitsDaoImpl implements FruitsDao {
    private static final String SEPARATOR = ",";
    private static final int FIRST_ELEMENT = 0;
    private static final int SECOND_ELEMENT = 1;
    private static final int THIRD_ELEMENT = 2;

    @Override
    public List<FruitTransaction> getFruitsData(String fromFile) {
        try (BufferedReader fileReader = new BufferedReader(new FileReader((fromFile)))) {
            List<FruitTransaction> fruitsData = new ArrayList<>();
            String lineFromFile = fileReader.readLine();
            while (lineFromFile != null) {
                String[] lineParts = lineFromFile.split(SEPARATOR);
                FruitTransaction fruitTransaction = new FruitTransaction();
                fruitTransaction.setOperation(FruitTransaction.Operation
                        .fromCode(lineParts[FIRST_ELEMENT]));
                fruitTransaction.setFruit(lineParts[SECOND_ELEMENT]);
                fruitTransaction.setQuantity(Integer.parseInt(lineParts[THIRD_ELEMENT]));
                fruitsData.add(fruitTransaction);
                lineFromFile = fileReader.readLine();
            }
            return fruitsData;
        } catch (IOException ex) {
            throw new RuntimeException("Can't read the file: " + fromFile, ex);
        }
    }

    @Override
    public void writeToFile(String fruitReport, String toFile) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(toFile))) {
            bufferedWriter.write(fruitReport);
        } catch (IOException ex) {
            throw new RuntimeException("Can't write to file: " + toFile, ex);
        }
    }
}
