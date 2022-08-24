package core.basesyntax.readdata;

import core.basesyntax.DataBase;
import core.basesyntax.FruitTransaction;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DataReadingImpl implements DataReading {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public void readData() {
        try (BufferedReader reader = new BufferedReader(new FileReader(DataBase.FILE_NAME))) {
            String line = null;
            FruitTransaction data = null;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] strings = line.split(",");
                data = new FruitTransaction(strings[OPERATION_INDEX].replaceAll(" ", ""),
                    strings[FRUIT_INDEX], Integer.parseInt(strings[QUANTITY_INDEX]));
                DataBase.transitions.add(data);
            }

        } catch (IOException e) {
            throw new RuntimeException("Can't read fata from file: " + DataBase.FILE_NAME, e);
        }
    }
}
