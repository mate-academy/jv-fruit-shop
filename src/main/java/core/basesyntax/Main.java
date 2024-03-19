package core.basesyntax;


import core.basesyntax.service.interfaces.FruitFileReader;
import core.basesyntax.service.impl.FruitFileReaderImpl;

import java.util.List;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {
    public static void main(String[] args) {
     FruitFileReader reader = new FruitFileReaderImpl();

        List<String> fileString = reader.readFile("src/main/resources/fruitts.csv");
       System.out.println(fileString);

//        FruitOperationProcessor processor = new FruitOperationProcessor();
//        processor.processOperations(fileString);


        /* FileFruitReader (exception no file)  return string
        Class fruit.of(name, quantity)
        Parse (string) - return HashMap <operation, fruit> : Exeption quantity< 0 invalid data
        db -> HashMap(Hashmap)
        getBalance (Hashmap.quantity) -> fruit + quantity -> return Hashmap -> db
        save to db?
        getSupply (Hashmap.quantity) - > fruit + quantity + ->  return Hashmap
        getPurchase (Hashmap.quantity) - > fruit + quantity - ->  return Hashmap
        getRefunds (Hashmap.quantity) - > fruit + quantity + ->  return Hashmap
        CalculationFruitCheck (Hashmap) - > if fruit, quantity <0 -> throw Exception
        createReport(hashmap) -> string
//        FileSaver(string)  -> File.cvs or exeption cannot save]

    } */
        // HINT: In the `public static void main(String[] args)` it is better to create instances of your classes,

    }
}
