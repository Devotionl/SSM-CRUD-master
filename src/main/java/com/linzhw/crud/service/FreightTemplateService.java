package com.linzhw.crud.service;
import java.util.List;

import com.linzhw.crud.bean.TbFreightTemplate;
import com.linzhw.crud.bean.TbFreightTemplateExample;
import com.linzhw.crud.dao.TbFreightTemplateMapper;
import com.linzhw.crud.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import org.springframework.stereotype.Service;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class FreightTemplateService {

	@Autowired
	private TbFreightTemplateMapper freightTemplateMapper;
	
	/**
	 * 查询全部
	 */

	public List<TbFreightTemplate> findAll() {
		return freightTemplateMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */

	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<TbFreightTemplate> page=   (Page<TbFreightTemplate>) freightTemplateMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */

	public void add(TbFreightTemplate freightTemplate) {
		freightTemplateMapper.insert(freightTemplate);		
	}

	
	/**
	 * 修改
	 */

	public void update(TbFreightTemplate freightTemplate){
		freightTemplateMapper.updateByPrimaryKey(freightTemplate);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */

	public TbFreightTemplate findOne(Long id){
		return freightTemplateMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */

	public void delete(Long[] ids) {
		for(Long id:ids){
			freightTemplateMapper.deleteByPrimaryKey(id);
		}		
	}
	
	

	public PageResult findPage(TbFreightTemplate freightTemplate, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		TbFreightTemplateExample example=new TbFreightTemplateExample();
		TbFreightTemplateExample.Criteria criteria = example.createCriteria();
		
		if(freightTemplate!=null){			
						if(freightTemplate.getSellerId()!=null && freightTemplate.getSellerId().length()>0){
				criteria.andSellerIdLike("%"+freightTemplate.getSellerId()+"%");
			}
			if(freightTemplate.getIsDefault()!=null && freightTemplate.getIsDefault().length()>0){
				criteria.andIsDefaultLike("%"+freightTemplate.getIsDefault()+"%");
			}
			if(freightTemplate.getName()!=null && freightTemplate.getName().length()>0){
				criteria.andNameLike("%"+freightTemplate.getName()+"%");
			}
			if(freightTemplate.getSendTimeType()!=null && freightTemplate.getSendTimeType().length()>0){
				criteria.andSendTimeTypeLike("%"+freightTemplate.getSendTimeType()+"%");
			}
	
		}
		
		Page<TbFreightTemplate> page= (Page<TbFreightTemplate>)freightTemplateMapper.selectByExample(example);		
		return new PageResult(page.getTotal(), page.getResult());
	}
	
}
