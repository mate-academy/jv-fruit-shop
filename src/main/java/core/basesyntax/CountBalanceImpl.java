package core.basesyntax;

import core.basesyntax.service.CountFruits;

public class CountBalanceImpl implements CountFruits {

    public int countFruit(String operation, String sourse, String fruit) {
        String[] array1 = sourse.split("\n");
        int balance = 0;
        for (int i = 0; i < array1.length; i++) {
            String[] array = array1[i].split(",");
            if (array[0].equals(operation)) {
                if (array[1].equals(fruit)) {
                    balance += Integer.parseInt(array[2]);
                }
            }
        }
        return balance;
    }
}
