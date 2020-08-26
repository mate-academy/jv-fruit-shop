package core.basesyntax;

import com.opencsv.bean.CsvToBeanBuilder;
import core.basesyntax.exception.CsvFileException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LocalCsvFileReader implements CsvFileReader {
    private static final Logger logger = LoggerFactory.getLogger(LocalCsvFileReader.class);
    private final String filePath;

    public LocalCsvFileReader(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<Transaction> readTransactions() {
        try (FileReader fileReader = new FileReader(filePath)) {
            return new CsvToBeanBuilder<Transaction>(fileReader)
                    .withType(Transaction.class).build().parse();
        } catch (FileNotFoundException e) {
            logger.error(e.getMessage(), e);
            throw new CsvFileException("File not found", e);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            throw new CsvFileException("Can't read the file", e);
        }
    }
}
