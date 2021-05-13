package core.basesyntax.operationswithfile;

import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;

public class MappingStrategyImpl implements MappingStrategy {
    @Override
    public ColumnPositionMappingStrategy setColumnMapping() {
        ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
        strategy.setType(Transaction.class);
        String[] columns = new String[] {"operationType", "name", "count"};
        strategy.setColumnMapping(columns);
        return strategy;
    }
}
