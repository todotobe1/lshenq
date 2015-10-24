package cn.lshenq.order.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.lshenq.base.domain.AbstractEntity;
import cn.lshenq.base.repository.BaseRepository;
import cn.lshenq.base.service.impl.BaseServiceImpl;
import cn.lshenq.order.repository.OrderRepository;
import cn.lshenq.order.service.OrderService;

@Service("orderService")
public class OrderServiceImpl extends BaseServiceImpl implements OrderService {

	@Autowired
	OrderRepository orderRepository;

	public BaseRepository<AbstractEntity, Long> getRepository() {
		return (BaseRepository)orderRepository;
	}

}
