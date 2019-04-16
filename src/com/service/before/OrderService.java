package com.service.before;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
public interface OrderService {
	public String orderSubmit(Model model, HttpSession session,Double amount);
	public String pay(Integer ordersn);
}
