package cn.lshenq.api.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

import cn.lshenq.order.entity.OrderEntity;
import cn.lshenq.order.service.OrderService;

@Api(value = "order-api", description = "订单CURD操作", position = 1)
@RestController
@CrossOrigin(maxAge = 1800)
@ExposesResourceFor(OrderEntity.class)
@RequestMapping(value = "/orders")
public class OrderController {

	@Autowired
	OrderService orderService;

	@RequestMapping("/frcs")
    public CsrfToken csrf(CsrfToken token) {
        return token;
    }
	
	@ApiOperation(value = "订单查询", notes = "根据订单号查询订单", position = 2)
	@RequestMapping(method = RequestMethod.GET, value = "/{orderNo}")
	@ResponseBody
	public ResponseEntity<OrderEntity> getOrderByNo(@PathVariable String orderNo) {
		OrderEntity orderEntity = (OrderEntity) orderService.findEntityByNo(orderNo);
		return new ResponseEntity<OrderEntity>(orderEntity, HttpStatus.OK);
	}

	@ApiOperation(value = "订单新增", notes = "订单新增", position = 3)
	@RequestMapping(method = RequestMethod.POST, value = "/post")
	@ResponseBody
	public ResponseEntity<OrderEntity> addOrder(@ModelAttribute("order") OrderEntity order) {
		OrderEntity orderEntity = (OrderEntity) orderService.saveEntity(order);
		return new ResponseEntity<OrderEntity>(orderEntity, HttpStatus.OK);
	}

	@ApiOperation(value = "订单删除", notes = "订单删除", position = 4)
	@RequestMapping(method = RequestMethod.DELETE, value = "/{orderNo}")
	@ResponseBody
	public String cancelOrder(@PathVariable String orderNo) {
		return "redirect:/orders";
	}

}
