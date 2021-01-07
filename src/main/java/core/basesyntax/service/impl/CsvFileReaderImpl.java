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
    public List<TransactionDto> readFile(String fileRead) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileRead))) {
            List<TransactionDto> transactionList = new ArrayList<>();
            String stringLine = reader.readLine();
            while (stringLine != null) {
                if (stringLine.contains("type")) {
                    stringLine = reader.readLine();
                    continue;
                }

                String[] fields = stringLine.split(",");
                TransactionDto transactionDto = new TransactionDto();
                transactionDto.setOperation(Operation.fromString(fields[0]));
                transactionDto.setFruit(new Fruit(fields[1]));
                transactionDto.setAmount(Integer.parseInt(fields[2]));
                transactionList.add(transactionDto);
                stringLine = reader.readLine();
            }
            return transactionList;
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file " + fileRead, e);
        }
    }
}
