package core.basesyntax.transaction.handler;

import core.basesyntax.transaction.FruitTransaction;
import core.basesyntax.transaction.Transaction;
//TODO: Залишити OperationHandler інтерфейс; реалізації повинні отримувати Transaction
// (інжектований) через ShopService/Processor, а не створювати новий всередині FruitTransaction.
//TODO: В хендлерах робити перевірки: purchase має кидати помилку якщо недостатньо
// (не дозволяти негативний баланс).

public interface OperationHandler {
    void handle(FruitTransaction ft, Transaction tx);
}
