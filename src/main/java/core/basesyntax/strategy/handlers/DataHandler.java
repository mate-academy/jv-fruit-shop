package core.basesyntax.strategy.handlers;

/**This interface defines the contract for processing the data.
 *  It takes a String data as input and returns the processed data as a String.
 *  Implementations of this interface will handle the different types of activities
 *  (balance, supply, purchase, return)
 *  and update the fruit inventory accordingly**/
public interface DataHandler {
    void processData(String fruit, int quantity);
}
