package com.linzhw.crud.service;
import java.util.List;

import com.linzhw.crud.bean.TbCities;
import com.linzhw.crud.bean.TbCitiesExample;
import com.linzhw.crud.dao.TbCitiesMapper;
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
public class CitiesService  {

	@Autowired
	private TbCitiesMapper citiesMapper;
	
	/**
	 * 查询全部
	 */

	public List<TbCities> findAll() {
		return citiesMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */

	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<TbCities> page=   (Page<TbCities>) citiesMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */

	public void add(TbCities cities) {
		citiesMapper.insert(cities);		
	}

	
	/**
	 * 修改
	 */

	public void update(TbCities cities){
		citiesMapper.updateByPrimaryKey(cities);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */

	public TbCities findOne(Integer id){
		return citiesMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */

	public void delete(Integer[] ids) {
		for(Integer id:ids){
			citiesMapper.deleteByPrimaryKey(id);
		}		
	}
	
	

	public PageResult findPage(TbCities cities, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		TbCitiesExample example=new TbCitiesExample();
		TbCitiesExample.Criteria criteria = example.createCriteria();
		
		if(cities!=null){			
						if(cities.getCityid()!=null && cities.getCityid().length()>0){
				criteria.andCityidLike("%"+cities.getCityid()+"%");
			}
			if(cities.getCity()!=null && cities.getCity().length()>0){
				criteria.andCityLike("%"+cities.getCity()+"%");
			}
			if(cities.getProvinceid()!=null && cities.getProvinceid().length()>0){
				criteria.andProvinceidLike("%"+cities.getProvinceid()+"%");
			}
	
		}
		
		Page<TbCities> page= (Page<TbCities>)citiesMapper.selectByExample(example);		
		return new PageResult(page.getTotal(), page.getResult());
	}
	
}
