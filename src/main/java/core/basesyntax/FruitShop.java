package core.basesyntax;

import core.basesyntax.countingoperations.CountOperation;
import core.basesyntax.countingoperations.CountOperationImpl;
import core.basesyntax.createproductslist.ProductsList;
import core.basesyntax.createproductslist.ProductsListImpl;
import core.basesyntax.datavalidation.OperationTypeValidator;
import core.basesyntax.datavalidation.OperationTypeValidatorImpl;
import core.basesyntax.operationswithfile.FileReader;
import core.basesyntax.operationswithfile.FileReaderImpl;
import core.basesyntax.operationswithfile.FileWriter;
import core.basesyntax.operationswithfile.FileWriterImpl;
import core.basesyntax.operationswithfile.Transaction;
import java.util.List;
import java.util.Map;

public class FruitShop {
    private static final String CSV_FILE_NAME = "src\\main\\java\\resources\\operations.csv";
    private static final String NEW_CSV_FILE = "src\\main\\java\\resources\\output.csv";

    public static void main(String[] args) {
        FileReader fileReader = new FileReaderImpl();
        List<Transaction> transactionList = fileReader.getOperations(CSV_FILE_NAME);
        OperationTypeValidator operationTypeValidator = new OperationTypeValidatorImpl();
        operationTypeValidator.validation(transactionList);
        ProductsList productsList = new ProductsListImpl();
        Map<String, Integer> balance = productsList.getProductList(transactionList);
        CountOperation countOperation = new CountOperationImpl();
        Map<String, Integer> count = countOperation.getCount(balance, transactionList);
        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.getNewFile(balance, NEW_CSV_FILE);
        System.out.println(count.toString());
    }
}
