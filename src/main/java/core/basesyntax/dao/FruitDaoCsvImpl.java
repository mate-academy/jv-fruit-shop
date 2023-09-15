package core.basesyntax.dao;

import core.basesyntax.model.FruitTransaction;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FruitDaoCsvImpl implements FruitDao {
    public static final String FILE_NAME = "src/main/resources/fruits.csv";
    private static final String FILE_REPORT = "src/main/resources/report.csv";

    @Override
    public void writeToFile(String report) {

        try (FileWriter writer = new FileWriter(FILE_REPORT);
                BufferedWriter bwr = new BufferedWriter(writer)) {
            bwr.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write file " + FILE_REPORT);
        }
    }

    @Override
    public List<FruitTransaction> readFromFileToArray() {
        List<String[]> strings = new ArrayList<>();
        try {
            strings = Files.readAllLines(Path.of(FILE_NAME))
                    .stream()
                    .map(words -> words.split(","))
                    .collect(Collectors.toList());

        } catch (IOException e) {
            throw new RuntimeException("Error reading file " + FILE_NAME);
        }
        List<FruitTransaction> listOfFruitTrsacion = new ArrayList<>();

        for (String[] el : strings) {
            FruitTransaction fruitTransaction = new FruitTransaction();
            for (int i = 0; i < el.length; i += 3) {
                switch (el[i]) {
                    case "b":
                        fruitTransaction.setOperation(FruitTransaction.Operation.BALANCE);
                        break;
                    case "s":
                        fruitTransaction.setOperation(FruitTransaction.Operation.SUPPLY);
                        break;
                    case "p":
                        fruitTransaction.setOperation(FruitTransaction.Operation.PURCHASE);
                        break;
                    case "r":
                        fruitTransaction.setOperation(FruitTransaction.Operation.RETURN);
                        break;
                    default:
                        break;
                }
                fruitTransaction.setFruit(el[i + 1]);
                fruitTransaction.setQuantity(Integer.parseInt(el[i + 2]));

            }
            listOfFruitTrsacion.add(fruitTransaction);

        }
        return listOfFruitTrsacion;
    }
}
