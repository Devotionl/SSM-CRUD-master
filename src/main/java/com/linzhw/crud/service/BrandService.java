package com.linzhw.crud.service;
import java.util.List;

import com.linzhw.crud.bean.TbBrand;
import com.linzhw.crud.bean.TbBrandExample;
import com.linzhw.crud.dao.TbBrandMapper;
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
public class BrandService {

	@Autowired
	private TbBrandMapper brandMapper;
	
	/**
	 * 查询全部
	 */

	public List<TbBrand> findAll() {
		return brandMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */

	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<TbBrand> page=   (Page<TbBrand>) brandMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */

	public void add(TbBrand brand) {
		brandMapper.insert(brand);		
	}

	
	/**
	 * 修改
	 */

	public void update(TbBrand brand){
		brandMapper.updateByPrimaryKey(brand);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */

	public TbBrand findOne(Long id){
		return brandMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */

	public void delete(Long[] ids) {
		for(Long id:ids){
			brandMapper.deleteByPrimaryKey(id);
		}		
	}
	

	public PageResult findPage(TbBrand brand, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		TbBrandExample example=new TbBrandExample();
		TbBrandExample.Criteria criteria = example.createCriteria();
		
		if(brand!=null){			
						if(brand.getName()!=null && brand.getName().length()>0){
				criteria.andNameLike("%"+brand.getName()+"%");
			}
			if(brand.getFirstChar()!=null && brand.getFirstChar().length()>0){
				criteria.andFirstCharLike("%"+brand.getFirstChar()+"%");
			}
	
		}
		
		Page<TbBrand> page= (Page<TbBrand>)brandMapper.selectByExample(example);		
		return new PageResult(page.getTotal(), page.getResult());
	}
	
}
