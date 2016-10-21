package com.groupfive.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController {
	@RequestMapping("/")
	public ModelAndView index(HttpServletRequest request, ModelAndView mv){
		mv.setViewName("index");
		return mv;
	}//endModelAndView index
	
	@RequestMapping("/home")
	public ModelAndView home(HttpServletRequest request, ModelAndView mv){
		mv.setViewName("home");
		return mv;
	}//endModelAndView Developer Home
	
	@RequestMapping("/edituser")
	public ModelAndView edituser(HttpServletRequest request, ModelAndView mv){
		mv.setViewName("edituser");
		return mv;
	}//endModelAndView Developer edituser
	
	@RequestMapping("/addlater")
	public ModelAndView addlater(HttpServletRequest request, ModelAndView mv){
		mv.setViewName("addlater");
		return mv;
	}//endModelAndView addlater
	
	@RequestMapping("/getdisplay")
	public ModelAndView getdisplay(HttpServletRequest request, ModelAndView mv){
		mv.setViewName("getdisplay");
		return mv;
	}//endModelAndView getdisplay
	
	@RequestMapping("/developercontact")
	public ModelAndView developercontact(HttpServletRequest request, ModelAndView mv){
		mv.setViewName("developercontact");
		return mv;
	}//endModelAndView developercontact

	
	@RequestMapping("/sitemap")
	public ModelAndView sitemap(HttpServletRequest request, ModelAndView mv){
		mv.setViewName("sitemap");
		return mv;
	}//endModelAndView sitemap
	
	@RequestMapping("/services")
	public ModelAndView services(HttpServletRequest request, ModelAndView mv){
		mv.setViewName("services");
		return mv;
	}//endModelAndView services


	@RequestMapping("/hudlocator")
    public ModelAndView hudlocator(HttpServletRequest request, ModelAndView mv){
        mv.setViewName("hudlocator");
        return mv;
    }//endModelAndView hudlocator


	@RequestMapping("/manageprofile")
    public ModelAndView manageprofile(HttpServletRequest request, ModelAndView mv){
        mv.setViewName("manageprofile");
        return mv;
    }//endModelAndView manageprofile
	
	@RequestMapping("/admin")
    public ModelAndView admin(HttpServletRequest request, ModelAndView mv){
        mv.setViewName("admin");
        return mv;
    }//endModelAndView admin

	@RequestMapping("/about")
    public ModelAndView about(HttpServletRequest request, ModelAndView mv){
        mv.setViewName("about");
        return mv;
    }//endModelAndView about

}//end class