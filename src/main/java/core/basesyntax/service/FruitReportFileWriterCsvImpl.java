package core.basesyntax.service;

import com.opencsv.CSVWriter;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import core.basesyntax.model.FruitItem;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FruitReportFileWriterCsvImpl implements FruitReportFileWriter {
    @Override
    public void write(String fileName, List<FruitItem> fruitItems) {
        System.out.println("Writing " + fileName + " ...");
        Path myPath = Paths.get(fileName);
        try (BufferedWriter bw = Files.newBufferedWriter(myPath, StandardCharsets.UTF_8)) {
            HeaderColumnNameMappingStrategy<FruitItem> strategy
                    = new HeaderColumnNameMappingStrategy<>();
            strategy.setType(FruitItem.class);
            StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(bw)
                    .withMappingStrategy(strategy)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                    .build();
            beanToCsv.write(fruitItems);
        } catch (CsvRequiredFieldEmptyException e) {
            throw new RuntimeException("Error: Csv Required Field is Empty.", e);
        } catch (CsvDataTypeMismatchException e) {
            throw new RuntimeException("Error: Csv Data Type Mismatch.", e);
        } catch (IOException e) {
            throw new RuntimeException("Error during writing report to file " + fileName, e);
        }
    }
}

