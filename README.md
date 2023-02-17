# Магазин фруктов
Представим, что у нас есть фруктовый магазин. Каждый день в магазине происходит ряд активностей, информация о которых записывается в файл в течение дня. Текущий входной файл передается в программу в формате CSV (для парсинга рекомендуется использовать стандартные библиотеки).

Ваши задачи:

* прочитать данные из CSV-файла
* обрабатывать эти данные
* сформировать отчет на основе обработанных данных
* записать отчет в новый файл csv
  В магазине есть четыре вида деятельности:
  b - остаток, остатки плодов на начало рабочего дня
  s - поставка, означает, что вы получаете новые фрукты от поставщиков
  p - покупка, означает, что кто-то купил фрукты
  r - вернуть, означает, что тот, кто купил фрукты, теперь возвращает их обратно

Подробно рассмотрим все виды деятельности:
1. Баланс. Фруктовый баланс в начале рабочей смены. Следующая строка в файле будет выглядеть так:
   Остаток средств. Фруктовый баланс в начале рабочей смены. Следующая строка в файле будет выглядеть так:

   b,banana,100  
   Строка выше означает, что в начале рабочей смены имеется 100 бананов.

2. Поставка. Вы принимаете новые фрукты от поставщиков. Следующая строка в файле будет выглядеть так:

   s,banana,100  
   Строка выше означает, что вы получаете 100 бананов.

3. Покупка. Покупатели могут посетить ваш магазин и купить фрукты. В этом случае в файле будет следующая строка:

   p,banana,13
   Строка выше означает, что кто-то купил 13 бананов.

4. Возврат. Покупатели могут вернуть вам фрукты. В этом случае в файле будет следующая строка:

   r,banana,10

Input file example
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
Мы ожидаем увидеть, сколько фруктов доступно сегодня после рабочей смены в вашем магазине фруктов.

```text
    fruit,quantity
    banana,152
    apple,90
```

Строка выше означает, что у вас есть 152 банана и 90 яблок в вашем магазине фруктов после рабочей смены.

**Подсказка: подумайте о создании модели FruitTransaction для хранения информации из строки файла для более удобной
обработки данных.
(это только рекомендация, вы можете использовать другие классы/подходы для решения этой задачи на ваше усмотрение):**

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

    private String operation;

    Operation(String operation) {
      this.operation = operation;
    }

    public String getOperation() {
      return operation;
    }
  }
}
```

# Fruit shop
Let's imagine that we have a fruit store. Every day in the store there are a number of activities, 
information about which is recorded in a file during the day.
The current input file is sent to the program in CSV format (it is recommended to use standard libraries for parsing).

Your tasks are:
- read data from csv file
- process these data 
- generate a report based on processed data
- write report to new csv file

There are four activities at the store:
```text
    b - balance, the remnants of fruits at the beginning of the working day
    s - supply, means you are receiving new fruits from suppliers
    p - purchase, means someone has bought some fruit
    r - return, means someone who have bought the fruits now returns them back
```

Let's check in details all types of activities:
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
1. Purchase. Buyers can visit your shop and buy some fruits. In this case you will have the following line in the file:
    
    ```text
       p,banana,13  
    ```
   The line above means someone has bought 13 bananas.
1. Return. Buyers can return you some fruits. In this case you will have the following line in the file:
    
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
(this is only a recommendation, you can use other classes / approaches to solve this task at your discretion):**
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

#### [Try to avoid these common mistakes while solving task](https://mate-academy.github.io/jv-program-common-mistakes/java-core/solid/fruit-shop)
