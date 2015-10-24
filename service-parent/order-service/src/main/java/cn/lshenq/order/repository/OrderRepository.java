
package cn.lshenq.order.repository;

import org.springframework.stereotype.Repository;

import cn.lshenq.base.repository.BaseRepository;
import cn.lshenq.order.entity.OrderEntity;

@Repository
public interface OrderRepository extends BaseRepository<OrderEntity, Long> {
	
}
