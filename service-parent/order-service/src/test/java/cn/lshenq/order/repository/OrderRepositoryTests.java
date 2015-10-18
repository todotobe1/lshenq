package cn.lshenq.order.repository;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.lshenq.order.OrderApplication;
import cn.lshenq.order.domain.Order;
import cn.lshenq.order.domain.OrderDataState;
import cn.lshenq.order.domain.OrderPayState;
import cn.lshenq.order.domain.OrderState;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = OrderApplication.class)
public class OrderRepositoryTests {

	@Autowired
	OrderRepository repository;

	@Test
	public void saveOrders() {
		Order order = new Order();
		order.setBuyId(111111L);
		order.setBookingId(11111L);
		order.setCrtTime(new Date());
		order.setDataState(OrderDataState.VALID);
		order.setDriverId(null);
		order.setOrderNo("O1111111");
		order.setOrderPayState(OrderPayState.UNPAY);
		order.setOrderState(OrderState.UNDO);
		order.setUpdTime(new Date());
		repository.save(order);
	}
	
	@Test
	public void findsFirstPageOfOrders() {

		Page<Order> orders = this.repository.findAll(new PageRequest(0, 10));
		assertThat(orders.getTotalElements(), is(greaterThan(1L)));
	}
}
