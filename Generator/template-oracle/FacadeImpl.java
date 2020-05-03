<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 

@Resource
${className}Service ${classNameLower}Service;

public ${className}Service get${className}Service() {
	return ${classNameLower}Service;
}
generator-insert-location