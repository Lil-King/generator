<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
package ${basepackage}.dao;

import com.rz.common.dao.EntityDao;
import ${basepackage}.domain.${className};

public interface ${className}Dao extends EntityDao<${className}> {

}