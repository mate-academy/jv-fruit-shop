package core.basesyntax.service.readfromfileservice.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.readfromfileservice.ReadFromFileService;
import core.basesyntax.service.separateservice.ParsingTransactionService;
import core.basesyntax.service.separateservice.impl.ParsingTransactionServiceImpl;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFromFileCsvServiceImpl implements ReadFromFileService {
    public List<FruitTransaction> readFromCsvFile(String filePath) {
        List<FruitTransaction> dataFromFile = new ArrayList<>();
        ParsingTransactionService parsingTransactionService = new ParsingTransactionServiceImpl();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String value = bufferedReader.readLine();
            value = bufferedReader.readLine();
            while (value != null) {
                parsingTransactionService.parsingTransaction(dataFromFile, value);
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file " + e);
        }
        return dataFromFile;
    }
}
