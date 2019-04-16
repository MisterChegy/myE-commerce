package com.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository("cartDao")
@Mapper
public interface CartDao {
	public int focus(Map<String, Object> map);
	public List<Map<String, Object>> isFocus(Map<String, Object> map);
	public List<Map<String, Object>> isPutCart(Map<String, Object> map);
	public int putCart (Map<String, Object> map);
	public int updateCart (Map<String, Object> map);
	public List<Map<String, Object>> selectCart(Integer id);
	public int deleteAgoods (Map<String, Object> map);
	public int clear(Integer id);
}
