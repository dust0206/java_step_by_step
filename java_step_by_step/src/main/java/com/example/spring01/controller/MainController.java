package com.example.spring01.controller;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring01.model.PointDTO;
import com.example.spring01.model.ProductDTO;

@Controller // 콘트롤러 bean
public class MainController {

	// url과 method 매핑 - ( http://localhost:8080/spring01/ )
	@RequestMapping("/")
	public String main(Model model) {	// Model 데이터 저장소 역할
		model.addAttribute("message", "welcome!");	// key-message 변수명, value  구조
		// main.jsp로 포워드 - servlet-context.xml의 영향을 받아서 간략하게 할수 있다
		return "main";
	}
	
	@RequestMapping("multi_table.do")
	public String gugu(Model model) {
		return "test/multi_table";		// views/test/multi_table.jsp
	}
	
	
	// @RequestParam : 파라미터를 정의하는 어노테이션
	@RequestMapping("table_result.do")
	public String gugu_result(@RequestParam(defaultValue = "3") int num, Model model) {
		
		String result = "";
		for(int i = 1; i <= 9; i++) {
			result += num + " x " + i + " = " + (num * i)  + "<br/>";
		}
		
		model.addAttribute("result", result);
		return "test/table_result";
	}
	
	@RequestMapping("point.do")
	public String point() {
		
		return "test/point";
	}
	
	// @RequestParam : 개별변수 => 4개의 변수라 4개의 Param이 필요
	// @@ModelAttribute - 객체
	@RequestMapping("point_result.do")
	public String point_result(@ModelAttribute PointDTO dto , Model model) {
		dto.setTotal(dto.getKor()+ dto.getEng() + dto.getMat());
		String avg = String.format("%.2f", dto.getTotal() / 3.0);
		dto.setAverage(Double.parseDouble(avg));
		model.addAttribute("dto", dto);
		return "test/point_result";
	}
	/*
	 1. request.setCharacterEncoding("UTF-8"); 
	 2. 한글처리 : web.xml 
 	<!-- 한글설정 -->	
 	<filter>		
 		<filter-name>encoding</filter-name>		
 		<filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>		
 		<init-param>			
	 		<param-name>encoding</param-name>			
 			<param-value>UTF-8</param-value>		
 		</init-param>	
 	</filter>	
	<filter-mapping>		
 		<filter-name>encoding</filter-name>		
 		<url-pattern>/*</url-pattern>	
	</filter-mapping>	
	 <!-- 한글설정 END -->
	 */
	
	@RequestMapping("point_1.do")
	public String point_1() {
		
		return "test/point_1";
	}
	
	// HttpServletRequest로 데이터 가져오기
	@RequestMapping("point_result_1.do")
//	public String point_result_1(HttpServletRequest request, Model model) {
	public String point_result_1(HttpServletRequest request, Model model) {
		PointDTO dto = new PointDTO();
		String name = request.getParameter("name");
		int kor = Integer.parseInt(request.getParameter("kor"));
		int eng = Integer.parseInt(request.getParameter("eng"));
		int mat = Integer.parseInt(request.getParameter("mat"));
		dto.setName(name);
		dto.setKor(kor);
		dto.setEng(eng);
		dto.setMat(mat);
		dto.setTotal(kor+eng+mat);
		String avg = String.format("%.2f", dto.getTotal() / 3.0);
		dto.setAverage(Double.parseDouble(avg));
		System.out.println("이름 : " + dto.getName());
		System.out.println("국어 : " + dto.getKor());
		System.out.println("영어 : " + dto.getEng());
		System.out.println("수학 : " + dto.getMat());
		model.addAttribute("dto", dto);
		return "test/point_result";
	}
	@RequestMapping("point_2.do")
	public String point_2() {
		
		return "test/point_2";
	}
	
	// HttpServletRequest로 데이터 가져오기
	@RequestMapping("point_result_2.do")
	public String point_result_1(@RequestParam() String name,@RequestParam() int kor,@RequestParam() int eng,@RequestParam() int mat, Model model) {
		PointDTO dto = new PointDTO();
		dto.setName(name);
		dto.setKor(kor);
		dto.setEng(eng);
		dto.setMat(mat);
		dto.setTotal(kor+eng+mat);
		String avg = String.format("%.2f", dto.getTotal() / 3.0);
		dto.setAverage(Double.parseDouble(avg));
		System.out.println("이름 : " + dto.getName());
		System.out.println("국어 : " + dto.getKor());
		System.out.println("영어 : " + dto.getEng());
		System.out.println("수학 : " + dto.getMat());
		model.addAttribute("dto", dto);
		return "test/point_result";
	}
	
	// forward : 자료를 출력하기전에 저장하고 출력페이지로 이동
	// redirect : 처리가 완료후 다른 url로 이동
	
	@RequestMapping("move.do")
	public String move() throws Exception {
		// encode(문자열, 문자셋)
		String name = URLEncoder.encode("김철수", "utf-8");
//		return "redirect:/result.do?name=" + name + "&age=20";
//		String name = "김철수";
		
		// URL에 한글, 특수문자 제한
		return "redirect:/result.do?name=" + name + "&age=20";
	}
	
	@RequestMapping("result.do")
	public String result(Model model, @RequestParam(defaultValue = "noname") String name, @RequestParam(defaultValue = "10") int age) throws Exception  {
		name = URLDecoder.decode(name, "utf-8");
		model.addAttribute("name",name);
		model.addAttribute("age", age);
		return "test/result";
	}
	
	// ModelAndView
	// Model : 데이터 저장소
	// View : 출력 페이지
	@RequestMapping("mav.do")
	public ModelAndView  mav( ) {
		Map<String, Object> map = new HashMap<>();
		map.put("dto", new ProductDTO("pen", 1000));
		
		// new ModelAndView(view, key, value) 
		// 		- view : 보여주는 이동할 url page 주소
		//		- key	: 키
		// 		- value :  값
		return new ModelAndView("test/mav_result", "map", map);
	}
	
	@RequestMapping("ajax.do")
	public String ajax() {
		return "test/ajax";	// ajax.jsp로 포워드
	}
	
	/*
	 	라이브러리를 추가 해야 한다.(pom.xml) - javascript에 비동기식으로 json 형식의 데이터 보내기
	 	(error message - No converter found for return value of type)
	  	jackson-annotations
	  	jackson-databind
	  	jackson-mapper-asl
	 */
	// 페이지로 이동이 아니라 데이터 자체를 리턴해야 하기 때문에
	// @ResponseBody 라는 어노테이션을 써야 한다
	
	// @ResponseBody - 데이터 자체를 리턴한다 => json 형식
	// { "name":"TV, "price",500000 }의 형식으로 데이터 전달
	@RequestMapping("background.do")
	public @ResponseBody ProductDTO background() {
		ProductDTO dto = new ProductDTO("TV", 500000);
		return dto;	// 데이터 자체를 리턴
	}
	
	
	 
}
