package com.example.demo.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.P_Food;
import com.example.demo.entity.P_FoodPaging;
import com.example.demo.entity.P_Hospital;
import com.example.demo.entity.P_HospitalPaging;
import com.example.demo.service.MapDAO;
import com.example.demo.service.InsertData;

@RestController
public class PetMapController {

	@Autowired
	private InsertData hospitalData;
	
	@Autowired
	private MapDAO hdao;
	
	
	@RequestMapping("main.do")
	public ModelAndView main( HttpServletRequest request ) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName( "main" );
		
		return modelAndView;
	}
	
	@RequestMapping("p_hospital.do")
	public ModelAndView p_hospital( HttpServletRequest request ) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName( "p_hospital" );
		
		return modelAndView;
	}
	
	@RequestMapping("p_food.do")
	public ModelAndView p_food( HttpServletRequest request ) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName( "p_food" );
		
		return modelAndView;
	}
	
	@RequestMapping("p_register.do")
	public ModelAndView p_register( HttpServletRequest request ) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName( "p_register" );
		
		return modelAndView;
	}
	
	@RequestMapping("p_hair.do")
	public ModelAndView p_hair( HttpServletRequest request ) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName( "p_hair" );
		
		return modelAndView;
	}
	
	// ajax 검색 리스트 가져오기 + pagination
	// hospital
	@RequestMapping("SearchListAjax.do")
	public ArrayList<P_HospitalPaging> SearchListAjax(HttpServletRequest request) {
		
		int cpage = 1;
		if( request.getParameter( "cpage" ) != null && !request.getParameter( "cpage" ).equals( "" ) ) {
			cpage = Integer.parseInt( request.getParameter( "cpage" ) );
		}
		
		P_HospitalPaging Lists = new P_HospitalPaging();
		Lists.setCpage(cpage);
		
		String input_address = request.getParameter("input_address");
		
		Lists = hdao.Search_paging_list(Lists, input_address);
		
		ArrayList<P_HospitalPaging> addressList = new ArrayList<P_HospitalPaging>();
		addressList.add(Lists);
		
		return addressList;
	}
	
	// food
	@RequestMapping("foodSearchAjax.do")
	public ArrayList<P_FoodPaging> foodSearchAjax(HttpServletRequest request) {
		
		int cpage = 1;
		if( request.getParameter( "cpage" ) != null && !request.getParameter( "cpage" ).equals( "" ) ) {
			cpage = Integer.parseInt( request.getParameter( "cpage" ) );
		}
		
		P_FoodPaging Lists = new P_FoodPaging();
		Lists.setCpage(cpage);
		
		String input_address = request.getParameter("input_address");
		String select_category = request.getParameter("select_category");
		//System.out.println(select_category);
		
		if(select_category.equals("카페") || select_category.equals("식당") ) {
			Lists = hdao.Food_category_paging_list(Lists, input_address, select_category);
		} else {
			Lists = hdao.Food_paging_list(Lists, input_address);
		}
		
		ArrayList<P_FoodPaging> addressList = new ArrayList<P_FoodPaging>();
		addressList.add(Lists);
		
		return addressList;
	}
	
	// 마커에 찍을 리스트 출력하는 ajax
	//hospital
	@RequestMapping("SearchAllAjax.do")
	public ArrayList<P_Hospital> SearchAllAjax(HttpServletRequest request) {
		String input_address = request.getParameter("input_address");
		ArrayList<P_Hospital> List = hdao.Search_all_list(input_address);
		
		return List;
	}
	//food
	@RequestMapping("FoodAllAjax.do")
	public ArrayList<P_Food> FoodAllAjax(HttpServletRequest request) {
		String input_address = request.getParameter("input_address");
		String select_category = request.getParameter("select_category");
		//System.out.println(select_category);
		ArrayList<P_Food> List;
		if(select_category.equals("카페") || select_category.equals("식당") ) {
			List = hdao.Food_category_all_list(input_address, select_category);
		} else {
			List = hdao.Food_all_list(input_address);			
		}
		return List;
	}
	
	// json 데이터 넣기
	@RequestMapping("insert.do")
		public ModelAndView insert_hospital( HttpServletRequest request ) {
			ModelAndView modelAndView = new ModelAndView();
			hospitalData.InsertHospitalData();
			modelAndView.setViewName( "insert" );
			
			return modelAndView;
	}
	@RequestMapping("insertfood.do")
	public ModelAndView insert_food( HttpServletRequest request ) {
		ModelAndView modelAndView = new ModelAndView();
		hospitalData.InsertPetData();
		modelAndView.setViewName( "insert" );
		
		return modelAndView;
}

}
