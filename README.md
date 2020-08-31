# JUnit practice

Your task is to implement the following requirements and cover at least 80% of your code with JUnit tests.
All input data will be passed in the file in CSV format.

## Fruit Store
Let's imagine that we have a fruit store and every day in the store there are a number of activities:

```text
    bl - balance, remnants of fruits for yesterday
    s - supply, means you are receiving a new fruits from suppliers
    b - buy, means someone bought a fruit
    r - return, means someone who have bought the fruits now returns you it
```

Let's check in details all types of activities:
1. Balance. Yesterday's fruit remnants. The following line in the file will look like:
    
    ```text
       bl,banana,100  
    ```
   The line above means there are 100 bananas left in the warehouse after yesterday's shift. 
   Balance information is always at the beginning of the file.
1. Supply. You are accepting a new fruits from suppliers. The following line in the file will look like:
    
    ```text
       s,banana,100     
    ```
   The line above means you receive a 100 bananas.
1. Buy. Buyers can visit your shop and buy some fruits. In this case you will have the following line in the file:
    
    ```text
       b,banana,13  
    ```
   The line above means someone bought a 13 bananas.
1. Return. Buyers can return you some fruits. In this case you will have the following line in the file:
    
    ```text
       r,banana,10   
    ```
   The line above means someone return you a 10 bananas.

### Input file example
```text
    type,fruit,quantity
    bl,banana,20
    bl,apple,100
    s,banana,100
    b,banana,13
    r,apple,10 
    b,apple,20 
    b,banana,5 
    s,banana,50
```

### Expecting output file example
Our task is to check yesterday's activities and generate a report for tomorrow.
We are expecting to see how many fruits are available today after work shift in your Fruit store. 
Let's process input file to get the next result:
```text
    fruit,quantity
    banana,152
    apple,90
```
   The line above means you have 152 bananas, and 90 apples in your Fruit store after work shift. 

IMPORTANT:
If the file has mistakes, you should throw an exception. Example of incorrect input file:
```
    type,fruit,quantity
    bl,banana,20
    b,banana,30 // Buyers will not be able to buy 30 bananas, because they are only 20 units in stock.
    s,banana,50 
```
or
```
    type,fruit,quantity
    bl,banana,20
    b,banana,-10 // Buyers will not be able to buy -10 bananas. -10 is incorrect input.
    s,banana,50 
```
ADVANCED:
- Keep in mind Open-Closed Principle (from SOLID) when you will do this task.
