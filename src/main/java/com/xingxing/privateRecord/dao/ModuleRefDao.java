package com.xingxing.privateRecord.dao;

import java.util.List;

import com.xingxing.privateRecord.domain.ModuleRefDo;

public interface ModuleRefDao {

	/**
	 * 查询模板集合
	 * @return
	 */
	public List<ModuleRefDo> selectModuleList();
	
	/**
	 * 根据模板编号查询名言集合
	 * @param modIdd
	 * @return
	 */
	public List<ModuleRefDo> selectWisdomListById(String modIdd);
}
