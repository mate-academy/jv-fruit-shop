package dao;

import static model.FruitTransaction.Operation.fromCode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.FruitTransaction;

public class CsvDataReaderImpl implements CsvDataReader {
    @Override
    public List<FruitTransaction> readDataFromFile(String filePath) {
        List<FruitTransaction> data = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                FruitTransaction.Operation type = fromCode(row[0]);
                String fruit = row[1];
                int quantity = Integer.parseInt(row[2]);

                data.add(new FruitTransaction(type, fruit, quantity));
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file " + filePath, e);
        }
        return data;
    }
}
