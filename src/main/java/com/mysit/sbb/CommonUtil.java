package com.mysit.sbb;

import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonUtil {
	// CommonUtil : 빈(Bean) / 객체 등록, 스프링 프레임워크에 객체가 등록됨
		// @Controller		: 컨트롤러
		// @Service			: 서비스
		// @Configuration	: 설정
		// @Componont		: 그 외 객체화
		// @Repository		: 
	
	public String markdown(String markdown) {
        Parser parser = Parser.builder().build();
        Node document = parser.parse(markdown);
        HtmlRenderer renderer = HtmlRenderer.builder().build();
        return renderer.render(document);
    }
}
