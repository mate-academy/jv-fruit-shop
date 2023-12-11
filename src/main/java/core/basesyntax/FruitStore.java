package core.basesyntax;

import java.util.HashMap;
import java.util.Map;


public class FruitStore {
    private final Map<String, Integer> fruitInventory = new HashMap<>();

    public void supplyFruit(String fruit, int quantity) {
        fruitInventory.put(fruit, fruitInventory.getOrDefault(fruit, 0) + quantity);
    }

    public void returnFruit(String fruit, int quantity) {
        fruitInventory.put(fruit, fruitInventory.getOrDefault(fruit, 0) + quantity);
    }

    public void balanceFruit() {
        for (Map.Entry<String, Integer> entry : fruitInventory.entrySet()) {
            System.out.println(entry.getKey() + "," + entry.getValue());
        }
    }

    public void sellFruit(String fruit, int quantity) {
        fruitInventory.put(fruit, fruitInventory.getOrDefault(fruit, 0) - quantity);
    }




    public Map<String, Integer> getFruitInventory() {
        return fruitInventory;
    }


}

//Your tasks are:
//
//read data from the CSV file
//process these data
//generate a report based on processed data
//write a report to a new CSV file
//There are four activities at the store:
//
//    b - balance, the remnants of fruits at the beginning of the working day
//    s - supply, means you are receiving new fruits from suppliers
//    p - purchase, means someone has bought some fruit
//    r - return, means someone who has bought the fruits now returns them back
//Let's check details of all types of activities:
//
//Balance. Fruit balance at the beginning of the work shift. The following line in the file will look like:
//
//   b,banana,100
//The line above means there are 100 bananas at the beginning of the work shift.
//
//Supply. You are accepting new fruits from suppliers. The following line in the file will look like:
//
//   s,banana,100
//The line above means you receive 100 bananas.
//
//Purchase. Buyers can visit your shop and buy some fruits. In this case, you will have the following line in the file:
//
//   p,banana,13
//The line above means someone has bought 13 bananas.
//
//Return. Buyers can return you some fruits. In this case, you will have the following line in the file:
//
//   r,banana,10
//The line above means someone has returned you 10 bananas.
//
//Input file example
//    type,fruit,quantity
//    b,banana,20
//    b,apple,100
//    s,banana,100
//    p,banana,13
//    r,apple,10
//    p,apple,20
//    p,banana,5
//    s,banana,50
