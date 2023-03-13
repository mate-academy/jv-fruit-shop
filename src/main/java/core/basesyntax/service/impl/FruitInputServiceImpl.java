package core.basesyntax.service.impl;

import core.basesyntax.db.FruitTransactionDao;
import core.basesyntax.db.impl.FruitTransactionDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.ParserService;
import core.basesyntax.service.ReaderService;

import java.util.List;

public class FruitInputServiceImpl implements FruitService {

        private final ReaderService reader = new ReaderServiceImpl();
        private final ParserService fruitTransactionParser = new ParserServiceImpl();
        private final FruitTransactionDao fruitTransactionDao = new FruitTransactionDaoImpl();

        public void processFile(String path) {
            List<String> records = reader.read(path);
            List<FruitTransaction> fruitTransactions = fruitTransactionParser.parse(records);
            fruitTransactionDao.saveAll(fruitTransactions);
        }






}
