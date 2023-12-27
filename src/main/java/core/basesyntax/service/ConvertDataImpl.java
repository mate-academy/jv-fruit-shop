package core.basesyntax.service;

import core.basesyntax.Operation;
import java.util.ArrayList;
import java.util.Scanner;

public class ConvertDataImpl implements ConvertData {
    @Override
    public ArrayList<FruitTransaction> convert(String data) {
        ArrayList<FruitTransaction> fruitTransactionList = new ArrayList<FruitTransaction>();
        try {
            Scanner scanner = new Scanner(data);
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }
            while (scanner.hasNextLine()) {
                String record = scanner.nextLine();
                String[] line = record.split(",");
                Operation operation = Operation.getOperationFromCode(line[0]);
                FruitTransaction transaction = new FruitTransaction(operation, line[1], Integer.parseInt(line[2]));
                fruitTransactionList.add(transaction);
            }
            scanner.close();
        } catch (NullPointerException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return fruitTransactionList;
    }
}
