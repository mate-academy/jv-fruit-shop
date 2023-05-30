package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DailyReportFileReader;
import core.basesyntax.service.FruitTransactionParser;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class DailyReportFileReaderImpl implements DailyReportFileReader {
    @Override
    public List<FruitTransaction> readDailyReport(Path filePath) {
        FruitTransactionParser fruitTransactionParser = new FruitTransactionParserImpl();
        try {
            return Files.lines(filePath)
                    .map(fruitTransactionParser::parseTransaction)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file: " + filePath, e);

        }
    }
}
