package cn.lshenq.order.repository;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.Assert;

import cn.lshenq.order.OrderApplication;
import cn.lshenq.order.entity.OrderDataState;
import cn.lshenq.order.entity.OrderEntity;
import cn.lshenq.order.entity.OrderPayState;
import cn.lshenq.order.entity.OrderState;

//@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = OrderApplication.class)
public class OrderRepositoryTests {

	@Autowired
	OrderRepository repository;

//	@Test
	public void saveOrders() {
		OrderEntity order = new OrderEntity();
		order.setBuyId("111111");
		order.setBookingNo("000001");
		order.setDataState(OrderDataState.VALID);
		order.setDriverNo(null);
		order.setOrderNo("00111111");
		order.setOrderPayState(OrderPayState.UNPAY);
		order.setOrderState(OrderState.UNDO);
		repository.save(order);
	}
	
//	@Test
	public void findsFirstPageOfOrders() {

		Page<OrderEntity> orders = this.repository.findAll(new PageRequest(0, 10));
		assertThat(orders.getTotalElements(), is(greaterThan(1L)));
	}
	
//	@Test
	public void findByNo() {
		OrderEntity entity = this.repository.findEntityByOrderNo("O1111111");
		Assert.notNull(entity);
	}
}
