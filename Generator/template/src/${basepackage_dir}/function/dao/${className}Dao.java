<#assign className = table.className>
package ${basepackage}.function.dao;

import org.springframework.stereotype.Repository;
import com.iflytek.qb.common.base.dao.imp.BasicDaoImp;
import ${basepackage}.function.bean.${className};

@Repository
public class ${className}Dao extends BasicDaoImp<${className}> {

}