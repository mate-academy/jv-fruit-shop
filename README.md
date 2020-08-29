# JUnit practice

Your task is to implement the following requirements and cover at least 80% of your code with JUnit tests.
All input data will be passed in the file in CSV format.

## Fruit Store
Let's imagine you have a fruit store. 
There are three type of fruitDtos in your fruit store:

```text
    s - supply, means you are receiving a new fruits from suppliers
    b - buy, means someone bought a fruit
    r - return, means someone who have bought the fruits now returns you it
```

Let's check in details all types of fruitDtos:
1. Supply. You are accepting a new fruit from suppliers. The following line in the file will look like:
    
    ```text
       s,banana,100,2020-10-17     
    ```
   The line above means you receive a 100 bananas, and their expiration date is 17-th October 2020.
1. Buy. Buyers can visit your shop and buy some fruits. In this case you will have the following line in the file:
    
    ```text
       b,banana,13,2020-10-15     
    ```
   The line above means someone bought a 13 bananas. Date of purchase is 15-th October 2020.
1. Return. Buyers can return you some fruits. In this case you will have the following line in the file:
    
    ```text
       r,banana,10,2020-10-17     
    ```
   The line above means someone return you a 10 bananas, and their expiration date is 17-th October 2020.


### Input file example
```text
    type,fruit,quantity,date
    s,banana,100,2020-10-17
    b,banana,13,2020-10-15
    r,banana,10,2020-10-17 
```

### Expecting output file example
We are expecting to see how many fruits are available in your Fruit store after the file processing. For example:
```text
    fruit,quantity
    banana,97
    orange,147
    apple,29
```
   The line above means you have 97 bananas, 147 oranges and 29 apples in your Fruit store.

ADVANCED:
- Keep in mind Open-Closed Principle (from SOLID) when you will do this task
