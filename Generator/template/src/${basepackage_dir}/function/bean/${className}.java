<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 

package ${basepackage}.function.bean;

import java.io.Serializable;
import com.iflytek.qb.common.base.bean.BasicBean;
import org.apache.ibatis.type.Alias;

@Alias("${className}")
public class ${className} extends BasicBean implements Serializable {

	private static final long serialVersionUID = -1L;
	
<#list table.columns as column>

	/**
	 * ${column.columnAlias}
	 */
	private ${column.javaType} ${column.columnNameLower};
</#list>

	public ${className}() {
	}
	
	public ${className}(Integer id) {
		//this.id = id;
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