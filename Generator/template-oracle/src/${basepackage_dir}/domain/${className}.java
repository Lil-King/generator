<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.domain;

import java.util.Date;
import java.io.Serializable;
import com.ebiz.ssi.domain.BaseDomain;

public class ${className} extends BaseDomain implements Serializable {

	private static final long serialVersionUID = -1L;
	
<#list table.columns as column>

	/**
	 * ${column.columnAlias}
	 */
	private ${column.javaType} ${column.columnNameLower};
</#list>

	public ${className}() {
	}
<@generateJavaColumns/>

<#macro generateJavaColumns>
	<#list table.columns as column>
	
	public void set${column.columnName?cap_first}(${column.javaType} ${column.columnName}) {
		this.${column.columnName} = ${column.columnName};
	}

	public ${column.javaType} get${column.columnName?cap_first}() {
		return this.${column.columnName};
	}
	</#list>
</#macro>

}