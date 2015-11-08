
package cn.lshenq.order.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cn.lshenq.base.repository.BaseRepository;
import cn.lshenq.order.entity.OrderEntity;

@Repository
public interface OrderRepository extends BaseRepository<OrderEntity, Long> {
	@Query("select o from OrderEntity o where o.orderNo = ?1")
	public OrderEntity findEntityByOrderNo(String orderNo);
}
