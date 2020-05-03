<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
package ${basepackage}.dao.ibatis;

import org.springframework.stereotype.Repository;

import com.rz.common.dao.impl.EntityDaoSqlMapImpl;
import ${basepackage}.dao.${className}Dao;
import ${basepackage}.domain.${className};

@Repository
public class ${className}DaoSqlMapImpl extends EntityDaoSqlMapImpl<${className}> implements ${className}Dao {

}

