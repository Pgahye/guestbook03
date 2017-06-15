package com.jx372.guestbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.jx372.guestbook.dao.guestBookDao;
import com.jx372.guestbook.vo.guestBookVo;



@Controller
public class GuestbookController {
	
	@Autowired
	private guestBookDao guestBookDao; 
	
	
	

	@RequestMapping({"/","/list"})
	public String list(Model model){
		
		List<guestBookVo> list=guestBookDao.getList();
		model.addAttribute("list", list);
		
		//for(guestBookVo vo : list){
			
			//System.out.println(vo);
		//}
		
		return  "/WEB-INF/views/index.jsp";
	}
	
	@RequestMapping("/deleteform/{no}")
	public String deleteform(Model model, @PathVariable("no") Long no){
		
		
		model.addAttribute("no", no);
		
		
		return "/WEB-INF/views/deleteform.jsp";
	}

	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insert(@ModelAttribute guestBookVo vo){
		
		guestBookDao.insert(vo);
		
		return "redirect:/";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String delete(@ModelAttribute guestBookVo vo){
		
		guestBookDao.delete(vo);
		
		return "redirect:/";
	}
	
}
