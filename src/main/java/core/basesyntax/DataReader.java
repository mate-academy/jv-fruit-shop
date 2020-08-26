package core.basesyntax;

import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class DataReader {

    public List<Transaction> transactionList(String filePath) {
        List<Transaction> items;

        try (CSVReader reader = new CSVReader(new FileReader(filePath), ';')) {
            ColumnPositionMappingStrategy<Transaction> beanStrategy
                    = new ColumnPositionMappingStrategy<>();
            beanStrategy.setType(Transaction.class);
            beanStrategy.setColumnMapping("type", "fruit", "quantity", "date");
            CsvToBean<Transaction> csvToBean = new CsvToBean<>();
            items = csvToBean.parse(beanStrategy, reader);
        } catch (IOException e) {
            throw new RuntimeException("Such file not found!");
        }
        return items;
    }
}
