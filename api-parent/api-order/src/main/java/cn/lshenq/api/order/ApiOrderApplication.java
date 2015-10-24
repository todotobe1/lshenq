package cn.lshenq.api.order;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import cn.lshenq.order.OrderApplication;

@SpringBootApplication
public class ApiOrderApplication {
	public static void main(String[] args) throws Exception {
		new SpringApplicationBuilder().showBanner(false).sources(OrderApplication.class)
				.child(ApiOrderApplication.class).run(args);
	}
}
