package core.basesyntax;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FruitDao {
    FruitBalance fruitBalance = new FruitBalance();

    public boolean readCSV() { //method for reading data from file && change fruit balance
        try {
            File report = new File("report.csv");
            Scanner scanner = new Scanner(report);

            if (scanner.hasNextLine()) {    //skip the header line
                scanner.nextLine();
            }

            while (scanner.hasNextLine()) {
                String record = scanner.nextLine();
                String[] data = record.split(",");
                Operation operation = Operation.getOperationFromCode(data[0]);
                FruitTransaction transaction = new FruitTransaction(operation, data[1], Integer.parseInt(data[2]));
                updateBalance(transaction);
            }
            //System.out.println(fruitBalance.getAppleBalance() + "\n" + fruitBalance.getBananaBalance());
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return true;
    }

    public boolean updateBalance(FruitTransaction transaction) {
        String code = transaction.getOperation().getCode();
        if (transaction.getFruit().equals("apple")) {
            switch (code) {
                case "b":
                    fruitBalance.setAppleBalance(transaction.getQuantity());
                    break;
                case "s":
                case "r":
                    fruitBalance.setAppleBalance(fruitBalance.getAppleBalance() + transaction.getQuantity());
                    break;
                case "p":
                    fruitBalance.setAppleBalance(fruitBalance.getAppleBalance() - transaction.getQuantity());
                    break;
                default:
                    throw new RuntimeException("You entered the wrong symbol!");
            }
        } else if (transaction.getFruit().equals("banana")) {
            switch (code) {
                case "b":
                    fruitBalance.setBananaBalance(transaction.getQuantity());
                    break;
                case "s":
                case "r":
                    fruitBalance.setBananaBalance(fruitBalance.getBananaBalance() + transaction.getQuantity());
                    break;
                case "p":
                    fruitBalance.setBananaBalance(fruitBalance.getBananaBalance() - transaction.getQuantity());
                    break;
                default:
                    throw new RuntimeException("You entered the wrong symbol!");
            }
        }
        return true;
    }
}


