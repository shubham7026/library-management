package com.ind.lms.services.implementation;

import com.ind.lms.models.TacoOrder;
import com.ind.lms.repository.interfaces.OrderRepository;
import com.ind.lms.services.interfaces.ITacoOrderApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TacoOrderApplicationService implements ITacoOrderApplicationService {

    private final OrderRepository orderRepository;

    @Override
    public void createOrder(TacoOrder tacoOrder) {
        orderRepository.save(tacoOrder);
    }
}
