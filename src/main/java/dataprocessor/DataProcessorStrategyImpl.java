package dataprocessor;

import java.util.HashMap;
import java.util.Map;

public class DataProcessorStrategyImpl implements DataProcessorStrategy {
    private final Map<ProcessSchema, DataProcessor> dataProcessorMap;

    public DataProcessorStrategyImpl() {
        dataProcessorMap = new HashMap<>();
        dataProcessorMap.put(ProcessSchema.REMNANTS, new RemnantsDataProcessor());
        dataProcessorMap.put(ProcessSchema.GOODSFLOW, null);
        dataProcessorMap.put(ProcessSchema.RESULT, null);
    }

    @Override
    public DataProcessor getDataProcessor(ProcessSchema schema) {
        return dataProcessorMap.get(schema);
    }
}
