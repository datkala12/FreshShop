package com.freshshop.controller.GlobalController;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class AppErrorController implements ErrorController {
	@GetMapping("/error")
	public ModelAndView handleError(Model model, HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("User/error.html");
		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		if (status != null) {
			Integer errorCode = Integer.valueOf(status.toString());
			if (errorCode == HttpStatus.FORBIDDEN.value()) {
				modelAndView.addObject("errorMsg", "You have encountered 403 Error");
			}
			if (errorCode == HttpStatus.NOT_FOUND.value()) {
				modelAndView.addObject("errorMsg", "You have encountered 404 Error");
			}
		}
		return modelAndView;
	}
}
