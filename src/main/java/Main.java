import model.FruitTransaction;
import service.CsvFileReaderService;
import service.ProcessCsvDataService;
import service.impl.CsvFileReaderServiceImpl;
import service.impl.ProcessCsvDataServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CsvFileReaderService service = new CsvFileReaderServiceImpl();
        List<String> list = service.readFromCsvFile("input_file.csv");
        System.out.println(list);

        ProcessCsvDataService service1 = new ProcessCsvDataServiceImpl();
        List<FruitTransaction> fruitTransactions = service1.processData(list);
        for (FruitTransaction fruitTrans: fruitTransactions) {
            System.out.print(fruitTrans.getOperation());
            System.out.print(fruitTrans.getFruit());
            System.out.print(fruitTrans.getQuantity());
            System.out.println();
        }
    }
}
