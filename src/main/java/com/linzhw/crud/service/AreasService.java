package com.linzhw.crud.service;
import java.util.List;

import com.linzhw.crud.bean.TbAreas;
import com.linzhw.crud.bean.TbAreasExample;
import com.linzhw.crud.dao.TbAreasMapper;
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
public class AreasService {

	@Autowired
	private TbAreasMapper areasMapper;
	
	/**
	 * 查询全部
	 */

	public List<TbAreas> findAll() {
		return areasMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */

	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<TbAreas> page=   (Page<TbAreas>) areasMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */

	public void add(TbAreas areas) {
		areasMapper.insert(areas);		
	}

	
	/**
	 * 修改
	 */

	public void update(TbAreas areas){
		areasMapper.updateByPrimaryKey(areas);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */

	public TbAreas findOne(Integer id){
		return areasMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */

	public void delete(Integer[] ids) {
		for(int id:ids){
			areasMapper.deleteByPrimaryKey(id);
		}		
	}
	
	

	public PageResult findPage(TbAreas areas, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		TbAreasExample example=new TbAreasExample();
		TbAreasExample.Criteria criteria = example.createCriteria();
		
		if(areas!=null){			
						if(areas.getAreaid()!=null && areas.getAreaid().length()>0){
				criteria.andAreaidLike("%"+areas.getAreaid()+"%");
			}
			if(areas.getArea()!=null && areas.getArea().length()>0){
				criteria.andAreaLike("%"+areas.getArea()+"%");
			}
			if(areas.getCityid()!=null && areas.getCityid().length()>0){
				criteria.andCityidLike("%"+areas.getCityid()+"%");
			}
	
		}
		
		Page<TbAreas> page= (Page<TbAreas>)areasMapper.selectByExample(example);		
		return new PageResult(page.getTotal(), page.getResult());
	}
	
}
