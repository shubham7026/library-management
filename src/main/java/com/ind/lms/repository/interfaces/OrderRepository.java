package com.ind.lms.repository.interfaces;

import com.ind.lms.models.TacoOrder;

public interface OrderRepository {
    TacoOrder submitOrder(TacoOrder tacoOrder);
}
