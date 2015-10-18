
package cn.lshenq.order.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import cn.lshenq.order.domain.Order;

interface OrderRepository extends Repository<Order, Long> {
	Order save(Order order);
	
	Page<Order> findAll(Pageable pageable);
}
