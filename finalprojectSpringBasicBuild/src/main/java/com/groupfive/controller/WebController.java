package com.groupfive.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController {
	@RequestMapping("/index")
	public ModelAndView home(HttpServletRequest request, ModelAndView mv){
//		if(request.getParameter("name") != null){
//			mv.addObject("name", request.getParameter("name"));
//		}//end if statement
		mv.setViewName("index");
		return mv;
	}//endModelAndView Home Page
	
	@RequestMapping("/banrhome")
	public ModelAndView banrhome(HttpServletRequest request, ModelAndView mv){
//		if(request.getParameter("name") != null){
//			mv.addObject("name", request.getParameter("name"));
//		}//end if statement
		mv.setViewName("banrhome");
		return mv;
	}//endModelAndView Developer edituser
	
	@RequestMapping("/edituser")
	public ModelAndView edituser(HttpServletRequest request, ModelAndView mv){
//		if(request.getParameter("name") != null){
//			mv.addObject("name", request.getParameter("name"));
//		}//end if statement
		mv.setViewName("edituser");
		return mv;
	}//endModelAndView Developer edituser
	
	@RequestMapping("/addlater")
	public ModelAndView addlater(HttpServletRequest request, ModelAndView mv){
//		if(request.getParameter("name") != null){
//			mv.addObject("name", request.getParameter("name"));
//		}//end if statement
		mv.setViewName("addlater");
		return mv;
	}//endModelAndView addlater
	
	@RequestMapping("/getdisplay")
	public ModelAndView getdisplay(HttpServletRequest request, ModelAndView mv){
//		if(request.getParameter("name") != null){
//			mv.addObject("name", request.getParameter("name"));
//		}//end if statement
		mv.setViewName("getdisplay");
		return mv;
	}//endModelAndView getdisplay
	
	@RequestMapping("/home1")
	public ModelAndView home1(HttpServletRequest request, ModelAndView mv){
//		if(request.getParameter("name") != null){
//			mv.addObject("name", request.getParameter("name"));
//		}//end if statement
		mv.setViewName("home1");
		return mv;
	}//endModelAndView home1
	
	@RequestMapping("/developercontact")
	public ModelAndView developercontact(HttpServletRequest request, ModelAndView mv){
//		if(request.getParameter("name") != null){
//			mv.addObject("name", request.getParameter("name"));
//		}//end if statement
		mv.setViewName("developercontact");
		return mv;
	}//endModelAndView developercontact

	
	@RequestMapping("/sitemap")
	public ModelAndView sitemap(HttpServletRequest request, ModelAndView mv){
//		if(request.getParameter("name") != null){
//			mv.addObject("name", request.getParameter("name"));
//		}//end if statement
		mv.setViewName("sitemap");
		return mv;
	}//endModelAndView sitemap
	
	@RequestMapping("/services")
	public ModelAndView services(HttpServletRequest request, ModelAndView mv){
//		if(request.getParameter("name") != null){
//			mv.addObject("name", request.getParameter("name"));
//		}//end if statement
		mv.setViewName("services");
		return mv;
	}//endModelAndView services


	@RequestMapping("/PostLoginPageforWidgets")
    public ModelAndView PostLoginPageforWidgets(HttpServletRequest request, ModelAndView mv){
//        if(request.getParameter("name") != null){
//            mv.addObject("name", request.getParameter("name"));
//        }//end if statement
        mv.setViewName("PostLoginPageforWidgets");
        return mv;
    }//endModelAndView PostLoginPageforWidgets

	@RequestMapping("/sandbox")
    public ModelAndView sandbox(HttpServletRequest request, ModelAndView mv){
//        if(request.getParameter("name") != null){
//            mv.addObject("name", request.getParameter("name"));
//        }//end if statement
        mv.setViewName("sandbox");
        return mv;
    }//endModelAndView sandbox

	@RequestMapping("/manageprofile")
    public ModelAndView manageprofile(HttpServletRequest request, ModelAndView mv){
//        if(request.getParameter("name") != null){
//            mv.addObject("name", request.getParameter("name"));
//        }//end if statement
        mv.setViewName("manageprofile");
        return mv;
    }//endModelAndView manageprofile
	
	@RequestMapping("/admin")
    public ModelAndView admin(HttpServletRequest request, ModelAndView mv){
//        if(request.getParameter("name") != null){
//            mv.addObject("name", request.getParameter("name"));
//        }//end if statement
        mv.setViewName("admin");
        return mv;
    }//endModelAndView admin

	@RequestMapping("/about")
    public ModelAndView about(HttpServletRequest request, ModelAndView mv){
//        if(request.getParameter("name") != null){
//            mv.addObject("name", request.getParameter("name"));
//        }//end if statement
        mv.setViewName("about");
        return mv;
    }//endModelAndView about

}//end class
