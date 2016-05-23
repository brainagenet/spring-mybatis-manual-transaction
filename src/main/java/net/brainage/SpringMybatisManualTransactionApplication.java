package net.brainage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("net.brainage.example.mapper")
public class SpringMybatisManualTransactionApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMybatisManualTransactionApplication.class, args);
	}
}
