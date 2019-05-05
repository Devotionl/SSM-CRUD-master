package com.linzhw.crud.service;
import java.util.List;

import com.linzhw.crud.bean.TbProvinces;
import com.linzhw.crud.bean.TbProvincesExample;
import com.linzhw.crud.dao.TbProvincesMapper;
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
public class ProvincesService{

	@Autowired
	private TbProvincesMapper provincesMapper;
	
	/**
	 * 查询全部
	 */

	public List<TbProvinces> findAll() {
		return provincesMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */

	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<TbProvinces> page=   (Page<TbProvinces>) provincesMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */

	public void add(TbProvinces provinces) {
		provincesMapper.insert(provinces);		
	}

	
	/**
	 * 修改
	 */

	public void update(TbProvinces provinces){
		provincesMapper.updateByPrimaryKey(provinces);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */

	public TbProvinces findOne(Integer id){
		return provincesMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */

	public void delete(Integer[] ids) {
		for(Integer id:ids){
			provincesMapper.deleteByPrimaryKey(id);
		}		
	}
	
	

	public PageResult findPage(TbProvinces provinces, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		TbProvincesExample example=new TbProvincesExample();
		TbProvincesExample.Criteria criteria = example.createCriteria();
		
		if(provinces!=null){			
						if(provinces.getProvinceid()!=null && provinces.getProvinceid().length()>0){
				criteria.andProvinceidLike("%"+provinces.getProvinceid()+"%");
			}
			if(provinces.getProvince()!=null && provinces.getProvince().length()>0){
				criteria.andProvinceLike("%"+provinces.getProvince()+"%");
			}
	
		}
		
		Page<TbProvinces> page= (Page<TbProvinces>)provincesMapper.selectByExample(example);		
		return new PageResult(page.getTotal(), page.getResult());
	}
	
}
