package com.controller.before;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.service.before.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController extends BaseBeforeController{
	@Autowired
	private OrderService orderService;
	/**
	 * 提交订单
	 */
	@RequestMapping("/orderSubmit")
	public String orderSubmit(Model model, HttpSession session,Double amount) {
		return orderService.orderSubmit(model, session, amount);
	}
	/**
	 * 支付订单
	 */
	@RequestMapping("/pay")
	public String pay(Integer ordersn) {
		return orderService.pay(ordersn);
	}
}
