package core.basesyntax;


import core.basesyntax.service.FruitFileReader;
import core.basesyntax.service.impl.FruitFileReaderImpl;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {
    public static void main(String[] args) {
        FruitFileReader string = new FruitFileReaderImpl();
        System.out.println(string.readFile("src/main/resources/fruitts.csv"));
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
