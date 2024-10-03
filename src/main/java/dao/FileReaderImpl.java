package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.FruitTransaction;
import model.OperationType;

public class FileReaderImpl implements dao.FileReader {

    @Override
    public List<FruitTransaction> readFile(String fileName) {
        List<FruitTransaction> transactions = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            br.readLine();

            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                OperationType operation = OperationType.fromCode(data[0]);
                String fruit = data[1];
                int quantity = Integer.parseInt(data[2]);

                FruitTransaction transaction = new FruitTransaction(operation, fruit, quantity);
                transactions.add(transaction);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error while reading file " + fileName, e);
        }
        return transactions;
    }
}
