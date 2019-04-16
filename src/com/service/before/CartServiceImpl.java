package com.service.before;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.dao.CartDao;
import com.util.MyUtil;

@Service("cartService")
@Transactional
public class CartServiceImpl implements CartService{
	@Autowired
	private CartDao cartDao;
	@Override
	public String focus(Model model, Integer id, HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("uid", MyUtil.getUserId(session));
		map.put("gid", id);
		List<Map<String, Object>> list = cartDao.isFocus(map);
		if(list.size() > 0) {
			model.addAttribute("msg", "已关注该商品！");
		}else {
			int n = cartDao.focus(map);
			if(n > 0)
				model.addAttribute("msg", "成功关注该商品！");
			else
				model.addAttribute("msg", "关注失败！");
		}
		return "forward:/goodsDetail?id=" + id;
	}
	@Override
	public String putCart(Model model, Integer shoppingnum, Integer id, HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("uid", MyUtil.getUserId(session));
		map.put("gid", id);
		map.put("shoppingnum", shoppingnum);
		//是否已添加购物车
		List<Map<String, Object>> list = cartDao.isPutCart(map);
		if(list.size() > 0)
			cartDao.updateCart(map);
		else
			cartDao.putCart(map);
		return "forward:/cart/selectCart";
	}
	@Override
	public String selectCart(Model model, HttpSession session) {
		List<Map<String, Object>> list = cartDao.selectCart(MyUtil.getUserId(session));
		double sum = 0;
		for (Map<String, Object> map : list) {
			sum = sum + (Double)map.get("smallsum");
		}
		model.addAttribute("total", sum);
		model.addAttribute("cartlist", list);
		return "before/cart";
	}
	@Override
	public String deleteAgoods(Integer id, HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("uid", MyUtil.getUserId(session));
		map.put("gid", id);
		cartDao.deleteAgoods(map);
		return "forward:/cart/selectCart";
	}
	@Override
	public String clear(HttpSession session) {
		cartDao.clear(MyUtil.getUserId(session));
		return "forward:/cart/selectCart";
	}
	@Override
	public String orderConfirm(Model model, HttpSession session) {
		List<Map<String, Object>> list = cartDao.selectCart(MyUtil.getUserId(session));
		double sum = 0;
		for (Map<String, Object> map : list) {
			sum = sum + (Double)map.get("smallsum");
		}
		model.addAttribute("total", sum);
		model.addAttribute("cartlist", list);
		return "before/orderconfirm";
	}

}
