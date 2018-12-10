package com.xingxing.privateRecord;

import org.apache.log4j.Logger;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan(value = {"com.xingxing.privateRecord.controller","com.xingxing.privateRecord.service","com.xingxing.privateRecord.init"}) 
@MapperScan("com.xingxing.privateRecord.dao")
@EnableCaching
@EnableSwagger2
public class Application extends SpringBootServletInitializer{
	
    private static Logger log= Logger.getLogger(Application.class);
    
    //打包,在根目录下命令输入mvn clean package
	@Override
	protected SpringApplicationBuilder configure(
			SpringApplicationBuilder builder) {
		return builder.sources(Application.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		log.info("启动完成");
	}
}
