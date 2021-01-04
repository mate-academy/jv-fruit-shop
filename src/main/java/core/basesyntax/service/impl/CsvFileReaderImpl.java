package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.CsvFileReader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvFileReaderImpl implements CsvFileReader {
    @Override
    public List<TransactionDto> readData(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            List<TransactionDto> transactionDtos = new ArrayList<>();
            String value = reader.readLine();
            while (value != null) {
                String[] transaction = value.split(",");
                if (transaction[0].equals("type")) {
                    value = reader.readLine();
                    continue;
                }
                TransactionDto transactionDto = new TransactionDto();
                Fruit fruit = new Fruit();
                fruit.setName(transaction[1]);
                transactionDto.setFruit(fruit);
                transactionDto.setOperation(Operation.fromString(transaction[0])); //
                transactionDto.setQuantity(Integer.valueOf(transaction[2]));
                transactionDtos.add(transactionDto);
                value = reader.readLine();
            }
            return transactionDtos;
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from the file " + fileName, e);
        }
    }
}
