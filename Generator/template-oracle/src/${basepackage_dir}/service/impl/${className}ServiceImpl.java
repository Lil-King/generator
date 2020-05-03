<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import ${basepackage}.dao.${className}Dao;
import ${basepackage}.domain.${className};
import ${basepackage}.service.${className}Service;


@Service
public class ${className}ServiceImpl implements ${className}Service {

	@Resource
	private ${className}Dao ${classNameLower}Dao;

	public Long create(${className} t) {
		return this.${classNameLower}Dao.insertEntity(t);
	}

	public ${className} get(${className} t) {
		return this.${classNameLower}Dao.selectEntity(t);
	}

	public Long getCount(${className} t) {
		return this.${classNameLower}Dao.selectEntityCount(t);
	}

	public List<${className}> getList(${className} t) {
		return this.${classNameLower}Dao.selectEntityList(t);
	}

	public int modify(${className} t) {
		return this.${classNameLower}Dao.updateEntity(t);
	}

	public int remove(${className} t) {
		return this.${classNameLower}Dao.deleteEntity(t);
	}

	public PageInfo<${className}> getPaginatedList(${className} t) {
		return this.${classNameLower}Dao.selectEntityPaginatedList(t);
	}

}
