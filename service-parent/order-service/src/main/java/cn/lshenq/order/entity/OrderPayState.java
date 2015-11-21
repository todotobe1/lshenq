
package cn.lshenq.order.entity;

public enum OrderPayState {
	UNPAY("UNPAY"), PAYED("PAYED");
	
	private final String value;

	private OrderPayState(String v) {
		this.value = v;
	}

	public String toString() {
		return this.value;
	}

	public static OrderPayState get(String str) {
		for (OrderPayState e : values()) {
			if (e.toString().equals(str)) {
				return e;
			}
		}
		return null;
	}
}
