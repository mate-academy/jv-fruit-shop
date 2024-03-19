package core.basesyntax.exception;

public class DataFileCorrupted extends RuntimeException{
   public DataFileCorrupted(String message) {
        super(message);
   }
}
