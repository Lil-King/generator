<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.service;

import java.util.List;
import ${basepackage}.domain.${className};

public interface ${className}Service {

	Long create(${className} t);

	int modify(${className} t);

	int remove(${className} t);

	${className} get(${className} t);

	List<${className}> getList(${className} t);

	Long getCount(${className} t);

	PageInfo<${className}> getPaginatedList(${className} t);

}
