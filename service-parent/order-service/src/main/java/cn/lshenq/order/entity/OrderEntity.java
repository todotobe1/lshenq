
package cn.lshenq.order.entity;

import java.io.Serializable;
import java.util.Date;

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
	private Long bookingId;

	@Column(nullable = true)
	private Long driverId;

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

	@Column(nullable = false)
	private Date crtTime;

	@Column(nullable = false)
	private Date updTime;

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

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public Long getDriverId() {
		return driverId;
	}

	public void setDriverId(Long driverId) {
		this.driverId = driverId;
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

	public Date getCrtTime() {
		return crtTime;
	}

	public void setCrtTime(Date crtTime) {
		this.crtTime = crtTime;
	}

	public Date getUpdTime() {
		return updTime;
	}

	public void setUpdTime(Date updTime) {
		this.updTime = updTime;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
