package core.basesyntax.service.impl;

import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.CsvFileReader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvFileReaderImpl implements CsvFileReader {
    @Override
    public List<TransactionDto> readDate(String fileName) {
        List<TransactionDto> transactionDtoList = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String row;
            while ((row = bufferedReader.readLine()) != null) {
                String[] split = row.split(",");
                ParseTransactionImpl parseTransaction = new ParseTransactionImpl();
                transactionDtoList.add(parseTransaction.parseDateFromFile(split));
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file", e);
        }
        return transactionDtoList;
    }
}
