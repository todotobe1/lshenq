package cn.lshenq.api.order;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import com.mangofactory.swagger.plugin.EnableSwagger;

import cn.lshenq.order.OrderApplication;

@EnableSwagger
@SpringBootApplication
public class ApiOrderApplication {
	public static void main(String[] args) throws Exception {
		new SpringApplicationBuilder().sources(OrderApplication.class)
				.child(ApiOrderApplication.class).run(args);
	}
}
