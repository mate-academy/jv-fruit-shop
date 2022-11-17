package core.basesyntax.dao;

import static core.basesyntax.db.Storage.storage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WorkWithFile implements IStorageDao {
    private static final String PATH_INPUT = "src/main/resources/input.csv";
    private static final String PATH_OUTPUT = "src/main/resources/output.csv";
    private static final String HEADER = "fruit,quantity" + System.lineSeparator();

    @Override
    public List<String> getData() {
        List<String> operations = new ArrayList<>();
        String tmp;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(PATH_INPUT))) {
            while ((tmp = bufferedReader.readLine()) != null) {
                operations.add(tmp);
            }
        } catch (IOException e) {
            throw new RuntimeException("File not found " + e);
        }
        return operations;
    }

    @Override
    public void putData() {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(PATH_OUTPUT))) {
            bufferedWriter.write(HEADER);
            for (Map.Entry<String, Integer> entry: storage.entrySet()) {
                bufferedWriter.write(entry.getKey() + ","
                                       + entry.getValue() + System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException("File not found " + e);
        }
    }
}
