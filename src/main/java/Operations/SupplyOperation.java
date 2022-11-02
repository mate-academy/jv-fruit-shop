package Operations;

import DAO.DAOFruit;
import core.basesyntax.FruitTransaction;

public class SupplyOperation  implements OperationHandler {
        private final DAOFruit fruitDao;

    public SupplyOperation(DAOFruit fruitDao) {
            this.fruitDao = fruitDao;
        }

        @Override
        public void handle(FruitTransaction fruitTransaction) {
            int amountFromStorage = fruitDao.getAmountOfFruit(fruitTransaction.getFruit());
            fruitDao.addFruits(fruitTransaction.getFruit(),
                    amountFromStorage + fruitTransaction.getAmount());
        }
}
