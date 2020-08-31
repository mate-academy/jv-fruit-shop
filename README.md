# JUnit practice

Your task is to implement the following requirements and cover at least 80% of your code with JUnit tests.
All input data will be passed in the file in CSV format.

## Fruit Store
Let's imagine you have a fruitPackageDTO store. 
There are three type of operations in your fruitPackageDTO store:

```text
    s - supply, means you are receiving a new fruitPackageDTOS from suppliers
    b - buy, means someone bought a fruitPackageDTO
    r - return, means someone who have bought the fruitPackageDTOS now returns you it
```

Let's check in details all types of operations:
1. Supply. You are accepting a new fruitPackageDTO from suppliers. The following line in the file will look like:
    
    ```text
       s,banana,100,2020-10-17     
    ```
   The line above means you receive a 100 bananas, and their expiration date is 17-th October 2020.
1. Buy. Buyers can visit your shop and buy some fruitPackageDTOS. In this case you will have the following line in the file:
    
    ```text
       b,banana,13,2020-10-15     
    ```
   The line above means someone bought a 13 bananas. Date of purchase is 15-th October 2020.
1. Return. Buyers can return you some fruitPackageDTOS. In this case you will have the following line in the file:
    
    ```text
       r,banana,10,2020-10-17     
    ```
   The line above means someone return you a 10 bananas, and their expiration date is 17-th October 2020.


### Input file example
```text
    type,fruitPackageDTO,quantity,date
    s,banana,100,2020-10-17
    b,banana,13,2020-10-15
    r,banana,10,2020-10-17 
```

### Expecting output file example
We are expecting to see how many fruitPackageDTOS are available in your Fruit store after the file processing. For example:
```text
    fruitPackageDTO,quantity
    banana,97
    orange,147
    apple,29
```
   The line above means you have 97 bananas, 147 oranges and 29 apples in your Fruit store.

ADVANCED:
- Keep in mind Open-Closed Principle (from SOLID) when you will do this task
