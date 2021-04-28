package com.companyname.fruitshop.service.interfaces;

import com.companyname.fruitshop.model.Operation;

public interface OperationStrategy {
    OperationHandler get(Operation operation);
}
