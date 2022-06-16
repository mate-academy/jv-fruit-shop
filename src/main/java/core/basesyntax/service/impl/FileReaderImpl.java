package core.basesyntax.service.impl;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.OperationStrategy;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class FileReaderImpl implements FileReaderService {
    @Override
    public void read(File input, OperationStrategy operationStrategy) {
        try (CSVReader reader = new CSVReader(new FileReader(input))) {
            Iterator<String[]> iterator = reader.readAll().iterator();
            String[] passHead = iterator.next(); // first not needed push to iterator
            while (iterator.hasNext()) {
                String[] line = iterator.next();
                operationStrategy.getOperationHandler(line[0])
                        .execute(line[1], Integer.parseInt(line[2]));
            }
        } catch (CsvException e) {
            throw new RuntimeException("became wrong format, not csv file", e);
        } catch (FileNotFoundException f) {
            throw new RuntimeException("file not fount", f);
        } catch (IOException i) {
            throw new RuntimeException("cant close properly the file", i);
        }
    }
}
