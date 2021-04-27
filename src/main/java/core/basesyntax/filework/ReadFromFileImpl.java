package core.basesyntax.filework;

import core.basesyntax.exceptions.ReadFromFileException;
import core.basesyntax.model.Fruit;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFromFileImpl implements ReadFromFile {
    private static final String COMA = ",";

    @Override
    public void readFromFile(String pathToFile) {
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(pathToFile))) {
            br.readLine();
            while (true) {
                if ((line = br.readLine()) == null) {
                    break;
                }
                convertToFruit(line.split(COMA));
            }
        } catch (IOException e) {
            throw new ReadFromFileException("Can't rad from file");
        }
    }

    private void convertToFruit(String[] line) {
        Fruit newFruit = new Fruit();
        newFruit.setActionType(Fruit.Type.valueOf(line[0]));
        newFruit.setFruitName(line[1]);
        newFruit.setQuantity(Integer.parseInt(line[2]));
        AfterReadListStorage.fruitStore.add(newFruit);
    }
}
