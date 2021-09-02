package com.example.algorithm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//spring项目动入口类
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		 ThreadLocal<Singleton> threadLocal = new ThreadLocal<>();
		 threadLocal.set(new Singleton());
	}

}
