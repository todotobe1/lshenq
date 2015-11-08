
package cn.lshenq.order.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import cn.lshenq.base.domain.AbstractEntity;

@Entity
@Table(name = "t_order")
public class OrderEntity extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long orderId;

	@Column(nullable = false)
	private String orderNo;

	@Column(nullable = false)
	private String bookingNo;

	@Column(nullable = true)
	private String driverNo;

	@Column(nullable = false)
	private Long buyId;

	@Column(nullable = true)
	private String amount;

	@Column(nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private OrderState orderState;

	@Column(nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private OrderPayState orderPayState;

	@Column(name = "order_data_state", nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private OrderDataState dataState;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getBookingNo() {
		return bookingNo;
	}

	public void setBookingNo(String bookingNo) {
		this.bookingNo = bookingNo;
	}

	public String getDriverNo() {
		return driverNo;
	}

	public void setDriverNo(String driverNo) {
		this.driverNo = driverNo;
	}

	public Long getBuyId() {
		return buyId;
	}

	public void setBuyId(Long buyId) {
		this.buyId = buyId;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public OrderState getOrderState() {
		return orderState;
	}

	public void setOrderState(OrderState orderState) {
		this.orderState = orderState;
	}

	public OrderPayState getOrderPayState() {
		return orderPayState;
	}

	public void setOrderPayState(OrderPayState orderPayState) {
		this.orderPayState = orderPayState;
	}

	public OrderDataState getDataState() {
		return dataState;
	}

	public void setDataState(OrderDataState dataState) {
		this.dataState = dataState;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
