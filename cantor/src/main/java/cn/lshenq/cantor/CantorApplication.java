
package cn.lshenq.cantor;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CantorApplication implements CommandLineRunner {


	@Override
	public void run(String... args) throws Exception {
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(CantorApplication.class, args);
	}

}
