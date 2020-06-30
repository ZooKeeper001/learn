package com.alibaba.study;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * springboot的war启动入口
 *
 * @author:  huangtt(bleuhtt@163.com)
 * @date:  2019-07-09
 * @version:  1.0
 */
public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(StudyApplication.class);
	}

}
