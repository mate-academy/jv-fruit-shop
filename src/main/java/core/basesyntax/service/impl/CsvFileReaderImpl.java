package core.basesyntax.service.impl;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvFileReaderImpl implements FileReader {
    @Override
    public List<TransactionDto> readData(String fileName) {
        List<TransactionDto> transactionDtos = new ArrayList<>();
        Operation operation;
        List<String[]> strings;
        try {
            CSVReader reader = new CSVReader(new java.io.FileReader(fileName));
            strings = reader.readAll();
        } catch (IOException | CsvException e) {
            throw new RuntimeException("Can't parse this file " + fileName);
        }
        for (int i = 1; i < strings.size(); i++) {
            transactionDtos.add(new TransactionDto(Operation.fromString(strings.get(i)[0]),
                    new Fruit(strings.get(i)[1]), Integer.parseInt(strings.get(i)[2])));
        }
        return transactionDtos;
    }
}
