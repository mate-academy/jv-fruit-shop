package service.impl;

import activity.impl.Balance;
import activity.impl.Purchase;
import activity.impl.Return;
import activity.impl.Supply;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Reader {
    public void read(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                String activity = values[0];
                String fruit = values[1];
                int amount = Integer.parseInt(values[2]);

                switch (activity) {
                    case "b":
                        Balance balance = new Balance();
                        balance.accept(fruit, amount);
                        break;

                    case "s":
                        Supply supply = new Supply();
                        supply.accept(fruit, amount);
                        break;

                    case "p":
                        Purchase purchase = new Purchase();
                        purchase.accept(fruit, amount);
                        break;

                    case "r":
                        Return returnActivity = new Return();
                        returnActivity.accept(fruit, amount);
                        break;

                    default:
                        throw new RuntimeException("No such activity");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Cannot read file");
        }
    }
}
