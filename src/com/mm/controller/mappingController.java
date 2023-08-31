package com.mm.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mm.dao.MapDetailsDao;
import com.mm.model.mapping_details;
import com.mm.service.JsonGenerator;

@Controller
public class mappingController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView map_detail_admin(Model model, HttpServletRequest request,
			HttpServletResponse response) {	
		 
		MapDetailsDao daoObj = new MapDetailsDao();
		//ArrayList<HashMap> AL = daoObj.getSmallCarouselDetails();
		//HashMap HM = new HashMap();
		//HM.put("table_value", AL);
		
	
		//return new ModelAndView("SmallCarouselAdmin","result",HM);
		return new ModelAndView("MappingAdmin");
	}

	/*@RequestMapping(value = "/SmallCarouseAddrow", method = RequestMethod.POST)
	public ModelAndView addrow(
			@ModelAttribute mapping_details mapping_details,
			BindingResult bindingResult
			) {
		
		String re_direcion_path = "redirect:/small_carousel_admin";
		MapDetailsDao daoObj = new MapDetailsDao();
		//String return_status = daoObj.addrowValue();
		
		return new ModelAndView(re_direcion_path);
		}*/

	@RequestMapping(value = "/mappingUpdate", method = RequestMethod.POST)
	public ModelAndView mappingUpdate(
			@RequestParam(value = "slno", required = false) String[] slno,
			@RequestParam(value = "url", required = false) String [] url,
			@RequestParam(value = "des", required = false) String [] des,
			
			HttpServletRequest request
			) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8"); 
		System.out.println("IN CONTROLLER>>>>>>>>>"+slno[0]);
		
		String re_direcion_path = "redirect:/";
		
		MapDetailsDao daoObj = new MapDetailsDao();
		System.out.println("UPDATION STARTED>>>>>>>>>");
		
	    JsonGenerator obj = new JsonGenerator();
	    obj.JsonGenerator(slno,url,des);
		return new ModelAndView(re_direcion_path);
	}
	
}