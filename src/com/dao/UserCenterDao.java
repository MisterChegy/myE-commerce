package com.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository("userCenterDao")
@Mapper
public interface UserCenterDao {
	public List<Map<String, Object>> myOrder(Integer bid);
	public List<Map<String, Object>> myFocus(Integer bid);
	public List<Map<String, Object>> orderDetail(Integer ordersn);
}
