package core.basesyntax;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    Map<String, Integer> fruits = new HashMap<>();

    public void supplyFruit(String fruit, int quantity) {
        fruits.put(fruit, fruits.getOrDefault(fruit, 0) + quantity);
    }


    public void purchaseFruit(String fruit, int quantity) {
        fruits.put(fruit, fruits.getOrDefault(fruit, 0) - quantity);
    }

    public void returnFruit(String fruit, int quantity) {
        fruits.put(fruit, fruits.getOrDefault(fruit, 0) + quantity);
    }


    public Map<String, Integer> getFruits() {
        return fruits;
    }


    public void getBalance(String fruit) {

    }
}

//Fruit shop
//Let's imagine that we have a fruit store. Every day in the store there are a number of activities, information about which is recorded in a file during the day. The current input file is sent to the program in CSV format (it is recommended to use standard libraries for parsing).
//
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
//Expecting report file example
//We are expecting to see how many fruits are available today after the work shift in your Fruit store.
//
//    fruit,quantity
//    banana,152
//    apple,90
//The line above means you have 152 bananas, and 90 apples in your Fruit store after the work shift.
//
//Hint: Think about creating some FruitTransaction model to store info from file line for more convenient data processing (this is only a recommendation, you can use other classes/approaches to solve this task at your discretion):
//
//public class FruitTransaction {
//  private Operation operation;
//  private String fruit;
//  private int quantity;
//
//  // getters, setters, ...
//
//  public enum Operation {
//    BALANCE("b"),
//    SUPPLY("s"),
//    PURCHASE("p"),
//    RETURN("r");
//
//    private String code;
//
//    Operation(String code) {
//      this.code = code;
//    }
//
//    public String getCode() {
//      return code;
//    }
//  }
//}
//Try to avoid these common mistakes while solving task
//Additional tips (IMPORTANT: before viewing create a solution architecture and check it against these tips)
