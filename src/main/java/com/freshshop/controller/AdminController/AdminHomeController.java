package com.freshshop.controller.AdminController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.freshshop.constant.FreshShopConstants;
import com.freshshop.model.ContactUs;
import com.freshshop.repository.ContactUsRepository;
import com.freshshop.service.ContactUsService;

@Controller
@RequestMapping("/admin")
public class AdminHomeController {

	@Autowired
	ContactUsRepository contactUsRepository;
	@Autowired
	ContactUsService contactUsService;

	@GetMapping("/viewOpenMessage/{page}")
	public String showFormOpenMessage(Model model, @PathVariable("page") int page,
			@RequestParam("sortField") String sortField, @RequestParam("sortDir") String sortDir,
			@RequestParam("searchName") String searchName) {
		Page<ContactUs> msgPage = null;
		if (searchName.equals("none") || searchName.equals("")) {
			msgPage = contactUsService.findsMessagesWithOpenStatus(page, sortField, sortDir);
			searchName = "";
		}else {
			msgPage = contactUsService.findsMessagesWithOpenStatusAndName(page, sortField, sortDir, searchName);
		}
		List<ContactUs> listMsg = msgPage.getContent();
		model.addAttribute("currentPage", page);
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("searchName", searchName);
		model.addAttribute("totalPages", msgPage.getTotalPages());
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
		model.addAttribute("listMsg", listMsg);
		return "Admin/admin-OpenMsg.html";
	}

	@GetMapping("/viewCloseMessage/{page}")
	public String showFormCloseMessage(Model model, @PathVariable("page") int page,
			@RequestParam("sortField") String sortField, @RequestParam("sortDir") String sortDir) {
		Page<ContactUs> msgPage = contactUsService.findsMessagesWithCloseStatus(page, sortField, sortDir);
		List<ContactUs> listMsg = msgPage.getContent();
		model.addAttribute("currentPage", page);
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("totalPages", msgPage.getTotalPages());
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
		model.addAttribute("listMsg", listMsg);
		return "Admin/admin-CloseMsg.html";
	}

	@RequestMapping(value = "/closeMsg", method = RequestMethod.GET)
	public String closeMessage(@RequestParam("msgId") int msgId, @RequestParam("currentPage") int currentPage,
			@RequestParam("sortField") String sortField, @RequestParam("sortDir") String sortDir) {
		contactUsService.updateMsgStatus(msgId, FreshShopConstants.CLOSE);
		return "redirect:/admin/viewOpenMessage/" + currentPage + "?sortField=" + sortField + "&sortDir=" + sortDir;
	}

	@RequestMapping(value = "/openMsg", method = RequestMethod.GET)
	public String openMessage(@RequestParam("msgId") int msgId, @RequestParam("currentPage") int currentPage,
			@RequestParam("sortField") String sortField, @RequestParam("sortDir") String sortDir) {
		contactUsService.updateMsgStatus(msgId, FreshShopConstants.OPEN);
		return "redirect:/admin/viewCloseMessage/" + currentPage + "?sortField=" + sortField + "&sortDir=" + sortDir;
	}

}