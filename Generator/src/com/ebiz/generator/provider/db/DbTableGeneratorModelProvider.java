package com.ebiz.generator.provider.db;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.ebiz.generator.IGeneratorModelProvider;
import com.ebiz.generator.provider.db.model.Table;


public class DbTableGeneratorModelProvider implements IGeneratorModelProvider {
	Table table;

	public DbTableGeneratorModelProvider(Table table) {
		super();
		this.table = table;
	}

	public String getDisaplyText() {
		return table.toString();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void mergeFilePathModel(Map model) throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {
		model.putAll(BeanUtils.describe(table));
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void mergeTemplateModel(Map model) {
		model.put("table", table);
	}

}
