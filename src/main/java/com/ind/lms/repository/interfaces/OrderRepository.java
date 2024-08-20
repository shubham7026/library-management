package com.ind.lms.repository.interfaces;

import com.ind.lms.models.Ingredient;
import com.ind.lms.models.TacoOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<TacoOrder, Long> {
   /* TacoOrder submitOrder(TacoOrder tacoOrder);*/
}
