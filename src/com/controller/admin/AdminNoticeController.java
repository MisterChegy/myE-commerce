package com.controller.admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.po.Notice;
import com.service.admin.AdminNoticeService;
@Controller
@RequestMapping("/adminNotice")
public class AdminNoticeController extends BaseController{
	@Autowired
	private AdminNoticeService adminNoticeService;
	@RequestMapping("/toAddNotice")
	public String toAddNotice(Model model) {
		model.addAttribute("notice", new Notice());
		return "admin/addNotice";
	}
	@RequestMapping("/addNotice")
	public String addNotice(@ModelAttribute Notice notice) {
		return adminNoticeService.addNotice(notice);
	}
	@RequestMapping("/deleteNoticeSelect")
	public String deleteNoticeSelect(Model model) {
		return adminNoticeService.deleteNoticeSelect(model);
	}
	@RequestMapping("/selectANotice")
	public String selectANotice(Model model, Integer id) {
		return adminNoticeService.selectANotice(model, id);
	}
	@RequestMapping("/deleteNotice")
	public String deleteNotice(Integer id) {
		return adminNoticeService.deleteNotice(id);
	}
}
