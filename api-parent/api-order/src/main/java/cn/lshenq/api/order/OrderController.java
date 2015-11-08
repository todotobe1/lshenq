package cn.lshenq.api.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.lshenq.order.entity.OrderEntity;
import cn.lshenq.order.service.OrderService;

@RestController
@ExposesResourceFor(OrderEntity.class)
@RequestMapping(value = "/orders")
public class OrderController {

	@Autowired
	OrderService orderService;

	@RequestMapping("/")
	public String helloWorld() {
		return "lshenq-web is running.";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{orderNo}")
	@ResponseBody
	public ResponseEntity<OrderEntity> getOrderByNo(@PathVariable String orderNo) {
		OrderEntity orderEntity = (OrderEntity) orderService.findEntityByNo(orderNo);
		return new ResponseEntity<OrderEntity>(orderEntity, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<OrderEntity> saveOrder(@RequestBody OrderEntity order) {
		OrderEntity orderEntity = (OrderEntity) orderService.saveEntity(order);
		return new ResponseEntity<OrderEntity>(orderEntity, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{orderNo}")
	@ResponseBody
	public String cancelOrder(@PathVariable String orderNo) {
		return "redirect:/orders";
	}

}
