package com.jiayifan.po;

import java.util.List;

/**
 * 包装类型
 * @author 贾一帆
 *
 */
public class UserQueryVo {
	//传入多个id
	private List<Integer> ids;
	//在这里包装所需要的查询条件
	//用户查询条件
	private UserCustom userCustom;
	//可以包装其他查询条件，订单，商品

	public UserCustom getUserCustom() {
		return userCustom;
	}

	public void setUserCustom(UserCustom userCustom) {
		this.userCustom = userCustom;
	}

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}
}
