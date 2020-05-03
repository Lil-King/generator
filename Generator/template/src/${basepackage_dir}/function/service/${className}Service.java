<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
<#assign date = "2015-03-20">
<#assign author = "WangMengzhong">
<#assign mail = "821501431@qq.com">

package ${basepackage}.function.service;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

//import com.iflytek.qb.util.UuidUtil;

import ${basepackage}.function.bean.${className};
import ${basepackage}.function.dao.${className}Dao;

import com.iflytek.qb.common.base.util.PageInfo;

@Service
public class ${className}Service {
	
	@Resource
	private ${className}Dao ${classNameLower}Dao;
	
	public int insert${className}(${className} t) {
		//String uuid = UuidUtil.getRandomUUID();
		return this.${classNameLower}Dao.insertEntity(t);
	}
	
	public int update${className}(${className} t) {
		return this.${classNameLower}Dao.updateEntity(t);
	}
    
	public int delete${className}(${className} t) {
		return this.${classNameLower}Dao.deleteEntity(t);
	}
    
	public ${className} select${className}(${className} t) {
		return this.${classNameLower}Dao.selectEntity(t);
	} 
	
	public int select${className}Count(${className} t) {
		return this.${classNameLower}Dao.selectCount(t);
	}
    
	public List<${className}> select${className}List(${className} t) {
		return this.${classNameLower}Dao.selectEntityList(t);
	}

	public PageInfo<${className}> select${className}Page(${className} t,PageInfo<${className}> page) {
		return this.${classNameLower}Dao.selectEntityPage(t, page);
	}

}
