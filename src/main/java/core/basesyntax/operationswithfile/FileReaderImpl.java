package core.basesyntax.operationswithfile;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderImpl implements FileReader {
    private MappingStrategy mappingStrategy = new MappingStrategyImpl();

    @Override
    public ArrayList getOperations(String csvFileName) {
        CsvToBean csv = new CsvToBean();
        List list;
        ColumnPositionMappingStrategy columnPositionMappingStrategy
                = mappingStrategy.setColumnMapping();
        try (CSVReader csvReader = new CSVReader(new java.io.FileReader(csvFileName),
                ',', '"', 1)) {
            list = csv.parse(columnPositionMappingStrategy, csvReader);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found!");
        } catch (IOException e) {
            throw new RuntimeException("Parsing filed!");
        }
        return (ArrayList) list;
    }

}
