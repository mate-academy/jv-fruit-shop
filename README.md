# Fruit shop
Let's imagine that we have a fruit store. Every day in the store there are a number of activities, 
information about which is recorded in a file during the day.
The current input file is sent to the program in CSV format (it is recommended to use standard libraries for parsing).

Your tasks are:
- read data from the CSV file
- process these data 
- generate a report based on processed data
- write a report to a new CSV file

There are four activities at the store:
```text
    b - balance, the remnants of fruits at the beginning of the working day
    s - supply, means you are receiving new fruits from suppliers
    p - purchase, means someone has bought some fruit
    r - return, means someone who has bought the fruits now returns them back
```

Let's check details of all types of activities:
1. Balance. Fruit balance at the beginning of the work shift. The following line in the file will look like:
    
    ```text
       b,banana,100  
    ```
   The line above means there are 100 bananas at the beginning of the work shift. 
1. Supply. You are accepting new fruits from suppliers. The following line in the file will look like:
    
    ```text
       s,banana,100     
    ```
   The line above means you receive 100 bananas.
1. Purchase. Buyers can visit your shop and buy some fruits. In this case, you will have the following line in the file:
    
    ```text
       p,banana,13  
    ```
   The line above means someone has bought 13 bananas.
1. Return. Buyers can return you some fruits. In this case, you will have the following line in the file:
    
    ```text
       r,banana,10   
    ```
   The line above means someone has returned you 10 bananas.

### Input file example
```text
    type,fruit,quantity
    b,banana,20
    b,apple,100
    s,banana,100
    p,banana,13
    r,apple,10 
    p,apple,20 
    p,banana,5 
    s,banana,50
```

### Expecting report file example
We are expecting to see how many fruits are available today after the work shift in your Fruit store. 
```text
    fruit,quantity
    banana,152
    apple,90
```
The line above means you have 152 bananas, and 90 apples in your Fruit store after the work shift.

**Hint: Think about creating some FruitTransaction model to store info from file line for more convenient data processing 
(this is only a recommendation, you can use other classes/approaches to solve this task at your discretion):**
```java
public class FruitTransaction {
  private Operation operation;
  private String fruit;
  private int quantity;

  // getters, setters, ...
  
  public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private String code;

    Operation(String code) {
      this.code = code;
    }

    public String getCode() {
      return code;
    }
  }
}
```

#### [Try to avoid these common mistakes while solving task](./checklist.md)

<details>
  <summary>Additional tips (IMPORTANT: before viewing create a solution architecture and check it against these tips)</summary>
 
 ![FruitShop Schema](https://mate-academy-images.s3.eu-central-1.amazonaws.com/Fruit_Shop_1_c3855912d4.png)

You are presented with a diagram describing an algorithm for the creation of a project structure. Your task is to implement it.

While carrying out this task, please pay attention to the following points:

All services should be invoked from the main() method. In each service, you should have a method that returns a specific type of data 
and passes this data to the method of the next service. In this way, your services will be independent of each other and
your solution will adhere to SOLID principles. Moreover, such methods are easier to test. 
Think about what types of data the methods in each of the services should return.
Remember the SOLID principles, think about which ones you might not be adhering to and how to fix this:
- Single Responsibility - does each class/method perform one function?
- Open/Closed - think about it, if there is a need to add functionality, will you need to change the logic of the class/methods?
- Interface segregation - review your code, do you have interfaces that should be divided into smaller ones?
- Liskov substitution - for example, imagine that you have a class S, which is a subtype of class T. 
- Make sure you can replace class S with class T without changing the desired properties of the program.
- Dependency Inversion - make sure that high-level modules do not depend on low-level modules. 
- Both should depend on abstractions. Also, abstractions should not depend on details. Details should depend on abstractions.

Bad practice example:
````
public class UserService {
  private UserDaoImpl userDaoImpl = new UserDaoImpl();
  
  public ArrayList<User> getAll() {
      return userDaoImpl.getAll();
  }
}
````
Good practice example:
````
public class UserServiceImpl implements UserService {
  private UserDao userDao = new UserDaoImpl();
  
  @Override
  public List<User> getAll() {
      return userDao.getAll();
  }
}
````
Better:
````
public class UserServiceImpl implements UserService {
   private final UserDao userDao; //let's not depend on certain implementations here

   public UserServiceImpl(UserDao userDao) {
      this.userDao = userDao;
   }

   @Override
   public List<User> getAll() {
      return userDao.getAll();
   }
}
````
Don't forget that your code will need to be tested, so try to anticipate all invalid input data and handle it in advance.
For example:
1. Incorrect file path
2. Incorrect data in the input file, for example, quantity less than zero or incorrect strategy
3. Null parameters
4. Providing the right names for your classes, methods, and variables is important. You can find examples here: [Link](https://mate-academy.github.io/style-guides/java/java.html#s5-naming)

</details>
