<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
<#assign path = "demo"> 

package ${basepackage}.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ${basepackage}.function.bean.${className};
import ${basepackage}.function.service.${className}Service;

import com.iflytek.qb.common.base.controller.SpringBasicController;

import com.iflytek.qb.common.util.JsonResult;

//import com.iflytek.uaac.client.service.UaacService;
//import com.iflytek.uaac.common.domain.UserInfo;
import com.iflytek.qb.common.base.util.PageInfo;
import com.iflytek.qb.common.base.util.LogHelper;


@Controller
@RequestMapping("${path}/${classNameLower}")
public class ${className}Controller extends SpringBasicController{
		@Autowired
		private ${className}Service ${classNameLower}Service;
		//@Autowired
		//private UaacService uaacService;
	
		/**
		* @Title: postList
		* @Description: 进入列表页
		* @param request
		* @param model
		* @return String
		*/
		@RequestMapping(value = "/list", method = RequestMethod.POST)
		@ResponseBody
		public PageInfo<${className}> postList(${className} t,PageInfo<${className}> page, Model model,HttpSession session) {				        
			try{
				//UserInfo userInfo = uaacService.getCurrentUserInfo(session);
				//page = {classNameLower}Service.select${className}Page(page,t,userInfo);
				page = ${classNameLower}Service.select${className}Page(t,page);
			}catch(Exception e){
				LogHelper.getLogger().error("列表请求出错", e);
			}
	        return page;
		}
		
		/**
		* @Title: getList
		* @Description:进入列表页
		* @param request
		* @param model
		* @return String
		*/
		@RequestMapping(value = "/list", method = RequestMethod.GET)
		public String getList(Model model)  {		
	 		return getPathList();
		}


		/**
		* @Title: add
		* @Description: 进入添加页面
		* @param request
		* @param model
		* @return String
		*/
		@RequestMapping("add")
		public String add(HttpServletRequest request, Model model) {
			return getPathAdd();
		}

		/**
		* @Title: add
		* @Description: Ajax保存添加数据
		* @param entity
		* @return JsonResult
		*/
		@RequestMapping(value = "add", method = RequestMethod.POST)
		public @ResponseBody
		JsonResult add(${className} t) {
			try {
				${classNameLower}Service.insert${className}(t);
				return new JsonResult(true,"保存成功",t);
			} catch (Exception ex) {
				LogHelper.getLogger().error("添加系统配置时出错", ex);
				return new JsonResult(false,"保存失败",t);
			}
		}

		/**
		* @Title: update
		* @Description: 进入修改页面
		* @param id
		* @param model
		* @return String
		*/
		@RequestMapping("update")
		public String update(Integer id, Model model) {
			${className} t = new ${className}(id);					
			t = ${classNameLower}Service.select${className}(t);
			model.addAttribute("model", t);
			
			return getPathUpdate();
		}

		/**
		* @Title: update
		* @Description: Ajax保存修改信息
		* @param entity
		* @return JsonResult
		*/
		@RequestMapping(value = "update", method = RequestMethod.POST)
		public @ResponseBody
		JsonResult update(${className} t) {
			try {
				${classNameLower}Service.update${className}(t);
				return new JsonResult(true,"更新成功",t);
			} catch (Exception ex) {
				LogHelper.getLogger().error("更新系统配置时出错", ex);
				return new JsonResult(false,"更新失败",t);
			}
		}
		
		
		/**
		* @Title: delete
		* @Description: Ajax删除
		* @param id
		* @return JsonResult
		*/
		@RequestMapping(value = "delete", method = RequestMethod.POST)
		public @ResponseBody
		JsonResult delete(Integer id) {
			try {
				${className} t = new ${className}(id);			
				${classNameLower}Service.delete${className}(t);
				return new JsonResult(true,"删除成功");
			} catch (Exception ex) {
				LogHelper.getLogger().error("删除系统配置时出错", ex);
				return new JsonResult(false,"删除失败");
			}
		}

		/**
		* @Title: batchDelete
		* @Description: Ajax批量删除
		* @param ids
		* @return JsonResult
		*/
		@RequestMapping(value = "batchdelete", method = RequestMethod.POST)
		public @ResponseBody
		JsonResult batchDelete(String ids) {
			try {
				${className} t = new ${className}();
				t.getMap().put("pks", ids.split(","));
				${classNameLower}Service.delete${className}(t);
				return new JsonResult(true, "批量删除成功！");
			}catch (Exception ex) {
				LogHelper.getLogger().error("批量删除系统配置时出错", ex);
				return new JsonResult(false, "批量删除系统配置时出错！");
			}
		}

		
		
		@Override
		public String getFModulePath() {
			return "${path}";
		}

		@Override
		public String getModulePath() {
			return "${classNameLower}";
		}

	}
