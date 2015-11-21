
package cn.lshenq.order.entity;

public enum OrderState {
	UNDO("UNDO"), CANCEL("CANCEL"), HELD("HELD"), DONE("DONE");
	
	private final String value;

	private OrderState(String v) {
		this.value = v;
	}

	public String toString() {
		return this.value;
	}

	public static OrderState get(String str) {
		for (OrderState e : values()) {
			if (e.toString().equals(str)) {
				return e;
			}
		}
		return null;
	}
}
