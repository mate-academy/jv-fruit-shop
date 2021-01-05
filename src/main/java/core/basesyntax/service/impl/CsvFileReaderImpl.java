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
    public static Integer ZERO = 0;
    public static Integer ONE = 1;
    public static Integer TWO = 2;

    @Override
    public List<TransactionDto> readData(String fileName) {
        List<TransactionDto> transactionDtos = new ArrayList<>();
        List<String[]> strings;
        try (CSVReader reader = new CSVReader(new java.io.FileReader(fileName))) {
            strings = reader.readAll();
        } catch (IOException | CsvException e) {
            throw new RuntimeException("Can't parse this file " + fileName);
        }
        for (int i = 1; i < strings.size(); i++) {
            transactionDtos.add(new TransactionDto(Operation.fromString(strings.get(i)[ZERO]),
                    new Fruit(strings.get(i)[ONE]), Integer.parseInt(strings.get(i)[TWO])));
        }
        return transactionDtos;
    }
}
