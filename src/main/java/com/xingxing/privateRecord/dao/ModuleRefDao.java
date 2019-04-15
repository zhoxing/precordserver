package com.xingxing.privateRecord.dao;

import java.util.List;

import com.xingxing.privateRecord.domain.ModuleRefDo;
import com.xingxing.privateRecord.qo.WisdomCondition;

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
	
	/**
	 * 查询名言集合
	 * @param wisdomCondition
	 * @return
	 */
	public List<ModuleRefDo> selectWisdomList(WisdomCondition wisdomCondition);
	
	/**
	 * 新增或修改名言
	 * @param wisdomCondition
	 */
	public void mergeDataForWisdom(WisdomCondition wisdomCondition);
}
