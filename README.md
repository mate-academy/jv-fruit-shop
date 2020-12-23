# Fruit shop

Let's imagine that we have a fruit store. Every day in the store there are a number of activities, 
information about which is recorded in a file during the day.
The current input file is sent to the program in CSV format (recommended to use standard libraries for parsing).

Your task is:
- validate the data in the file
- generate a report based on the input file.

There are a four activities at the store:
```text
    b - balance, the remnants of fruits at the beginning of the working day
    s - supply, means you are receiving a new fruits from suppliers
    p - purchase, means someone bought a fruit
    r - return, means someone who have bought the fruits now returns them to you
```

Let's check in details all types of activities:
1. Balance. Fruit balance at the beginning of the work shift. The following line in the file will look like:
    
    ```text
       b,banana,100  
    ```
   The line above means there are 100 bananas at the beginning of the work shift. 
   Balance information is always at the beginning of the file (other cases should not be checked).
1. Supply. You are accepting a new fruits from suppliers. The following line in the file will look like:
    
    ```text
       s,banana,100     
    ```
   The line above means you receive a 100 bananas.
1. Purchase. Buyers can visit your shop and buy some fruits. In this case you will have the following line in the file:
    
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
We are expecting to see how many fruits are available today after work shift in your Fruit store. 
```text
    fruit,quantity
    banana,152
    apple,90
```
The line above means you have 152 bananas, and 90 apples in your Fruit store after work shift. 


### Validation
If the file has mistakes, you should throw an exception. Example of incorrect input file:
```text
    type,fruit,quantity
    b,banana,20
    p,banana,30 // Buyers will not be able to buy 30 bananas, because they are only 20 units in stock.
    s,banana,50 
```
or
```text
    type,fruit,quantity
    b,banana,20
    p,banana,-10 // Buyers will not be able to buy -10 bananas. -10 is incorrect input.
    s,banana,50 
```

#### [Try to avoid these common mistakes while solving task](https://mate-academy.github.io/jv-program-common-mistakes/java-core/solid/fruit-shop.html)
