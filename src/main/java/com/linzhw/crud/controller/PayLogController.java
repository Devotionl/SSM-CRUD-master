package com.linzhw.crud.controller;
import java.util.List;

import com.linzhw.crud.bean.TbPayLog;
import com.linzhw.crud.service.PayLogService;
import com.linzhw.crud.utils.PageResult;
import com.linzhw.crud.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/payLog")
public class PayLogController {

	@Autowired
	private PayLogService payLogService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<TbPayLog> findAll(){
		return payLogService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult findPage(int page, int rows){
		return payLogService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param payLog
	 * @return
	 */
	@RequestMapping("/add")
	public Result add(@RequestBody TbPayLog payLog){
		try {
			payLogService.add(payLog);
			return new Result(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}
	
	/**
	 * 修改
	 * @param payLog
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody TbPayLog payLog){
		try {
			payLogService.update(payLog);
			return new Result(true, "修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "修改失败");
		}
	}	
	
	/**
	 * 获取实体
	 * @param id
	 * @return
	 */
	@RequestMapping("/findOne")
	public TbPayLog findOne(String id){
		return payLogService.findOne(id);		
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public Result delete(String [] ids){
		try {
			payLogService.delete(ids);
			return new Result(true, "删除成功"); 
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "删除失败");
		}
	}
	
		/**
	 * 查询+分页
	 * @param brand
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/search")
	public PageResult search(@RequestBody TbPayLog payLog, int page, int rows  ){
		return payLogService.findPage(payLog, page, rows);		
	}
	
}
