package com.service.before;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.dao.OrderDao;
import com.po.Order;
import com.util.MyUtil;
@Service("orderService")
@Transactional
/**
 * ���������������ĸ��²������˴�����ʹ���������
 */
public class OrderServiceImpl implements OrderService{
	@Autowired
	private OrderDao orderDao;
	/**
	 * �����ύ��������������
	 */
	
	public String orderSubmit(Model model, HttpSession session, Double amount) {
		Order order = new Order();
		order.setAmount(amount);
		order.setBusertable_id(MyUtil.getUserId(session));
		//���ɶ�����������������order
		orderDao.addOrder(order);
		//���ɶ�������
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ordersn", order.getId());
		map.put("uid", MyUtil.getUserId(session));
		orderDao.addOrderDetail(map);
		//������Ʒ���
		//������Ʒ���1.��ѯ��Ʒ���������Ա���¿��ʹ��
		List<Map<String, Object>> list = orderDao.selectGoodsShop(MyUtil.getUserId(session));
		//������Ʒ���2.������Ʒ���������¿��
		for (Map<String, Object> map2 : list) {
			orderDao.updateStore(map2);
		}
		//��չ��ﳵ
		orderDao.clear(MyUtil.getUserId(session));
		model.addAttribute("ordersn", order.getId());
		return "before/orderdone";
	}
	
	public String pay(Integer ordersn) {
		orderDao.pay(ordersn);
		return "before/paydone";
	}

}
