package core.basesyntax.read;

import core.basesyntax.dao.OrderDao;
import core.basesyntax.dao.OrderDaoImpl;
import core.basesyntax.db.Storage;
import core.basesyntax.operation.Supply;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileService {
    public void readFromFile(String filePath) {
        try (BufferedReader bf = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = bf.readLine()) != null) {
                String[] arr1 = line.split(",");
                String type = arr1[0];
                String fruit = arr1[1];
                int quantity = Integer.parseInt(arr1[2]);
//                Supply supply = new Supply(fruit,quantity);
//                Storage.orders.add(supply);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
