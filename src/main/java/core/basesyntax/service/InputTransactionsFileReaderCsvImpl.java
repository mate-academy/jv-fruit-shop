package core.basesyntax.service;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import core.basesyntax.model.FruitTransaction;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class InputTransactionsFileReaderCsvImpl implements InputTransactionsFileReader {
    @Override
    public List<FruitTransaction> read(String fileName) {
        System.out.println("Reading " + fileName + " ...");
        List<FruitTransaction> fruitTransactions;
        Path myPath = Paths.get(fileName);
        try (BufferedReader br = Files.newBufferedReader(myPath, StandardCharsets.UTF_8)) {
            HeaderColumnNameMappingStrategy<FruitTransaction> strategy
                    = new HeaderColumnNameMappingStrategy<>();
            strategy.setType(FruitTransaction.class);
            CsvToBean<FruitTransaction> csvToBean = new CsvToBeanBuilder<FruitTransaction>(br)
                    .withMappingStrategy(strategy)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            fruitTransactions = csvToBean.parse();
        } catch (IOException e) {
            throw new RuntimeException("Error during reading data of Transactions from file "
                    + fileName, e);
        }
        return fruitTransactions;
    }
}
