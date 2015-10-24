package cn.lshenq.order.repository;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.lshenq.order.OrderApplication;
import cn.lshenq.order.entity.OrderDataState;
import cn.lshenq.order.entity.OrderEntity;
import cn.lshenq.order.entity.OrderPayState;
import cn.lshenq.order.entity.OrderState;
import cn.lshenq.order.service.OrderService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = OrderApplication.class)
public class OrderServiceTests {

	@Autowired
	OrderService orderService;

//	@Test
	public void saveOrders() {
		OrderEntity order = new OrderEntity();
		order.setBuyId(111111L);
		order.setBookingId(11111L);
		order.setCrtTime(new Date());
		order.setDataState(OrderDataState.VALID);
		order.setDriverId(null);
		order.setOrderNo("O1111111");
		order.setOrderPayState(OrderPayState.UNPAY);
		order.setOrderState(OrderState.UNDO);
		order.setUpdTime(new Date());
		orderService.saveEntity(order);
	}
	
//	@Test
	public void findAllOrders() {
		assertThat(new Long(orderService.findAllEntity().size()), is(greaterThan(1L)));
	}
	
	@Test
	public void findAllOrdersByIds() {
		Set<Long> ids = new HashSet<Long>();
		ids.add(1L);
		System.out.println(orderService.findAllEntity(ids));
	}
}
