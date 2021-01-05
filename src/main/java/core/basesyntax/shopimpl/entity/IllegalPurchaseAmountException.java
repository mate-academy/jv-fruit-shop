package core.basesyntax.shopimpl.entity;

public class IllegalPurchaseAmountException extends Exception {
    
    public IllegalPurchaseAmountException() {
    
    }
    
    public IllegalPurchaseAmountException(String message){
        super(message);
    }
}
