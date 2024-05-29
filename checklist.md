## Common mistakes (jv-fruit-shop)

#### Don't begin class or method implementation with empty line. 
Remove all redundant empty lines, be careful :)

#### Follow SOLID rules
Please design your classes according to the SOLID principles. Make your classes simple, reusable and focused on a single problem.
In this case you will save a lot of time when you need to add/modify existing functionality in the future.

#### Make your services independent and call them in main() method
All services should be independent. 
We shouldn't have Strategy and call its methods in CsvFileReaderService, or we shouldn't have CsvFileWriterService and call its methods in the Strategy class.

Let's create `Main` class with `main()` method to show how the program works.
Make all services independent and call them in the right order in `main()` method step by step (the result of previous service method should be the input for next one)

#### Don't keep all logic in a single package
You can use packages to make the structure of the code better, so let's do it. Gather classes with same 
purpose/common logic in a corresponding package.

Your project structure should consist the following packages:
- `resources` for holding Storage
- `model` for holding models like Fruit (if necessary)
- `service` for holding services, like Writer, Reader, Parser and so on
- `service.impl` for holding implementations of services
- `strategy` for holding handlers for different operations (you are expected to apply Strategy pattern)

#### VCS usage
Remember about the informative commit and PR naming. Person that is outside of context of your work progress should understand
what feature/functional you have added.

#### Don't ignore exceptions in try-catch blocks
Don't leave `e.printStackTrace()` or `System.out.println(e.getMessage())` in the catch blocks. 
Let's rethrow a RuntimeException with an **informative** message and exception object.

- Good:   
    ```java
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't find file by path: " + filePath, e);
        }
    ```
  
#### try-with-resources
Remember, if you are using classes that implement an AutoCloseable interface, we should use it with try-with-resources.

#### Follow the encapsulation principle
Hide inner class elements with the help of access modifiers. It's a bad practice to make your class exposed.

#### Use data structures from the Collection framework
In order to represent fruit storage you may use already existing data structures, think of the one that will be 
the most suitable for your needs.

#### Place the input and output files into the `src/main/resources` folder.

#### Avoid hardcode in your solution
* Use hardcoded values only in the Main class and/or test classes.  
    
- Bad:  
    ```java
    public class ReaderServiceImpl implements ReaderService {
       public List<String> readFromFile() {
          File file = new File("src/main/resources/file.txt");
          ...
       }
    }
    ```     
- Good:  
    ```java
    public class ReaderServiceImpl implements ReaderService {
       public List<String> readFromFile(String filePath) {
          File file = new File(filePath);
          ...
       }
    }
    ```

#### Do not use the absolute path to a resource. Everyone who pulls your project should be able to run it. 
Please provide the relative path to a resource instead. 
 
- Bad:  
    ```java
    readerService.readFromFile("C:/Users/.../my-project/src/main/resources/file.txt");
    ```  
    
- Good:  
    ```java
    readerService.readFromFile("src/main/resources/file.txt");
    ```
      
#### Avoid using switch-cases and if-else constructions. It is recommended to use the Strategy pattern instead. 
In the `main()` method you can pass the strategy map into the service that chooses the correct strategy for each operation.

- Example:  
    ```java
    public static void main(String[] args){
        // create and fill the strategy map
        FruitService fruitService = new FruitServiceImpl(operationStrategies);
    }
    ```  

#### Be attentive with [class](https://mate-academy.github.io/style-guides/java/java.html#s5.2.2-class-names) and [method](https://mate-academy.github.io/style-guides/java/java.html#s5.2.3-method-names) naming. 

#### Handling Purchase operation.
Check result balance before saving it in the Storage - it should be positive. Throw `RuntimeException` in case the balance is negative.
