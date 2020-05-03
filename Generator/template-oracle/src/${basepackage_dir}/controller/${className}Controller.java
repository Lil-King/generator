<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ${basepackage}.domain.${className};

import com.rz.bddq.csc.domain.${className};
import com.rz.common.controller.SpringBasicController;
import com.rz.common.utils.*;

@Controller
@RequestMapping("module/${classNameLower}")
public class ${className}Controller extends SpringBasicController{
		/**
		* @Title: listGet
		* @Description: 进入列表页
		* @param request
		* @param model
		* @return String
		*/
		@RequestMapping("list")
		public String listGet(HttpServletRequest request, Model model) {
			getList(request, model);
			
			return getPathList();
		}
		
		/**
		* @Title: dataList
		* @Description: 获取列表数据
		* @param request
		* @param model
		* @return String
		*/
		@RequestMapping(value = "datalist", method = RequestMethod.POST)
		public String dataList(HttpServletRequest request, Model model)  {
			getList(request, model);
	 		return getPath("data_list");
		}

		/**
		* @Title: getList
		* @Description: 获取列表数据
		* @param request
		* @param model
		*/
		private void getList(HttpServletRequest request, Model model){
			int pageIndex = WebUtil.getInt(request, "page_index", 1);
			//String qymc = WebUtil.getString(request, "qymc", "");
			
			${className} param = new ${className}();
			//param.getMap().put("qymc", qymc);
			PageInfo<${className}> pageInfo = super.getFacade().get${className}Service().getPaginatedList(param,
					pageIndex, PageInfo.DefultSize);
			List<${className}> list = pageInfo.getData();

			model.addAttribute("pageIndex", pageIndex);
			model.addAttribute("list", list);
			model.addAttribute("pageInfo", pageInfo);
			model.addAttribute("url", "systemconfiguration/list.do");
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
		JsonResult add(${className} entity) {
			try {

				super.getFacade().get${className}Service().create(entity);
				return new JsonResult(true, "添加成功！");
			} catch (Exception ex) {
				LogHelper.getLogger().error("添加系统配置时出错", ex);
				return new JsonResult(false, "添加系统配置时出错！");
			}
		}

		/**
		* @Title: update
		* @Description: 进入添加页面
		* @param id
		* @param model
		* @return String
		*/
		@RequestMapping("update")
		public String update(Long id, Model model) {
			${className} param = new ${className}();
			param.setId(id);
			
			${className} entity = super.getFacade().get${className}Service().get(param);
			model.addAttribute("model", entity);
			
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
		JsonResult update(${className} entity) {
			try {
				super.getFacade().get${className}Service().modify(entity);
				return new JsonResult(true, "更新成功！");
			} catch (Exception ex) {
				LogHelper.getLogger().error("更新系统配置时出错", ex);
				return new JsonResult(false, "更新系统配置时出错！");
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
		JsonResult delete(Long id) {
			try {
				${className} param = new ${className}();
				param.setId(id);
				super.getFacade().get${className}Service().remove(param);
				return new JsonResult(true, "删除成功！");
			} catch (DataIntegrityViolationException ex) {
				return new JsonResult(false, "该系统配置下有关联的信息，无法删除！");
			} catch (Exception ex) {
				LogHelper.getLogger().error("删除系统配置时出错", ex);
				return new JsonResult(false, "删除系统配置时出错！");
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
				${className} entity = new ${className}();
				entity.getMap().put("pks", ids.split(","));
				super.getFacade().get${className}Service().remove(entity);
				return new JsonResult(true, "批量删除成功！");
			} catch (DataIntegrityViolationException ex) {
				return new JsonResult(false, "该系统配置下有关联的信息，无法删除！");
			} catch (Exception ex) {
				LogHelper.getLogger().error("批量删除系统配置时出错", ex);
				return new JsonResult(false, "批量删除系统配置时出错！");
			}
		}

		@RequestMapping("view")
		public String view(Long id, Model model) {
			${className} param = new ${className}();
			param.setId(id);
			
			${className} entity = super.getFacade().get${className}Service().get(param);
			model.addAttribute("model", entity);
			return getPathView();
		}
		
		@Override
		public String getFModulePath() {
			return "csc";
		}

		@Override
		public String getModulePath() {
			return "${classNameLower}";
		}

	}
