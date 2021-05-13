package core.basesyntax.operationswithfile;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class FileReaderImpl implements FileReader {
    private static final Character SEPARATOR = ',';
    private static final Character QUOTECHAR = '"';
    private static final Integer NUMBER_OF_LINE = 1;
    private MappingStrategy mappingStrategy = new MappingStrategyImpl();

    @Override
    public List getOperations(String csvFileName) {
        CsvToBean csv = new CsvToBean();
        List operationsList;
        ColumnPositionMappingStrategy columnPositionMappingStrategy
                = mappingStrategy.setColumnMapping();
        try (CSVReader csvReader = new CSVReader(new java.io.FileReader(csvFileName),
                SEPARATOR, QUOTECHAR, NUMBER_OF_LINE)) {
            operationsList = csv.parse(columnPositionMappingStrategy, csvReader);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found!");
        } catch (IOException e) {
            throw new RuntimeException("Parsing filed!");
        }
        return operationsList;
    }

}
