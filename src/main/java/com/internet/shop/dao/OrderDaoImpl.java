package com.internet.shop.dao;

import com.internet.shop.lib.Dao;
import com.internet.shop.models.Order;
import java.util.List;
import java.util.Optional;

@Dao
public class OrderDaoImpl implements OrderDao {
    @Override
    public Order create(Order order) {
        return null;
    }

    @Override
    public Optional<Order> get(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Order> getAll() {
        return null;
    }

    @Override
    public Order update(Order order) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
