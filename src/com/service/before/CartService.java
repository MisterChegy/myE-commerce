package com.service.before;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

public interface CartService {
	public String focus(Model model,Integer id, HttpSession session);
	public String putCart(Model model,Integer shoppingnum, Integer id, HttpSession session);
	public String selectCart(Model model, HttpSession session);
	public String deleteAgoods(Integer id,HttpSession session);
	public String clear(HttpSession session);
	public String orderConfirm(Model model, HttpSession session);
}
