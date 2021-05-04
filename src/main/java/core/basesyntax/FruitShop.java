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
import core.basesyntax.operationswithfile.Operation;
import java.util.ArrayList;
import java.util.HashMap;

public class FruitShop {
    public static void main(String[] args) {
        String csvFileName = "src\\main\\java\\resources\\operations.csv";
        FileReader fileReader = new FileReaderImpl();
        ArrayList<Operation> operationArrayList = fileReader.getOperations(csvFileName);
        OperationTypeValidator operationTypeValidator = new OperationTypeValidatorImpl();
        operationTypeValidator.validation(operationArrayList);
        ProductsList productsList = new ProductsListImpl();
        HashMap balance = productsList.getProductList(operationArrayList);
        CountOperation countOperation = new CountOperationImpl();
        HashMap count = countOperation.getCount(balance, operationArrayList);
        String newCsvFileName = "src\\main\\java\\resources\\output.csv";
        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.getNewFile(balance, newCsvFileName);
        System.out.println(count.toString());
    }
}
