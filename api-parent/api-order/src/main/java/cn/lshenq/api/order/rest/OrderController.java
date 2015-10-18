package cn.lshenq.api.order.rest;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

	@RequestMapping(method = RequestMethod.GET, value = "/orders")
	@ResponseBody
	public HttpEntity<Order> getOrders(
			@RequestParam(value = "orderState", required = false, defaultValue = "1") String orderState) {

		Order order = new Order(orderState);
		order.add(linkTo(methodOn(OrderController.class).getOrders(orderState)).withSelfRel());

		return new ResponseEntity<Order>(order, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/orders/{orderNo}")
	@ResponseBody
	public HttpEntity<Order> getOrderByNo(@PathVariable String orderNo) {

		Order order = new Order(orderNo);
		order.add(linkTo(methodOn(OrderController.class).getOrderByNo(orderNo)).withSelfRel());

		return new ResponseEntity<Order>(order, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/order")
	@ResponseBody
	public HttpEntity<Order> updateOrder(@ModelAttribute Order order) {
		return new ResponseEntity<Order>(order, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/order")
	@ResponseBody
	public HttpEntity<Order> addOrder(@ModelAttribute Order order) {
		return new ResponseEntity<Order>(order, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/orders/{orderNo}")
	@ResponseBody
	public String cancelOrder(@PathVariable String orderNo) {
		return "redirect:/orders";
	}

}
