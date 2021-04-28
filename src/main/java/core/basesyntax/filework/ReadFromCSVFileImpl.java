package core.basesyntax.filework;

import core.basesyntax.exceptions.ReadFromFileException;
import core.basesyntax.model.Fruit;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFromCSVFileImpl implements ReadFromFile {
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
                parseToFruit(line.split(COMA));
            }
        } catch (IOException e) {
            throw new ReadFromFileException("Can't rad from file");
        }
    }

    private void parseToFruit(String[] line) {
        Fruit newFruit = new Fruit(Fruit.Type.valueOf(line[0]),
                line[1], Integer.parseInt(line[2]));
        AfterReadListStorage.fruitStore.add(newFruit);
    }
}
