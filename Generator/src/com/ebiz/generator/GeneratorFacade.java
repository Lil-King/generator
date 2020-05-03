package com.ebiz.generator;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.ebiz.generator.provider.db.DbTableFactory;
import com.ebiz.generator.provider.db.DbTableGeneratorModelProvider;
import com.ebiz.generator.provider.db.model.Table;
import com.ebiz.generator.provider.java.JavaClassGeneratorModelProvider;
import com.ebiz.generator.provider.java.model.JavaClass;

public class GeneratorFacade {

	public GeneratorFacade() {
	}

	public void printAllTableNames() throws Exception {
		List<Table> tables = DbTableFactory.getInstance().getAllTables();
		System.out.println("\n----打印数据库中的全部表的名称----");
		for (int i = 0; i < tables.size(); i++) {
			String sqlName = ((Table) tables.get(i)).getSqlName();
			//System.out.println("g.generateByTable(\"" + sqlName + "\");");
			System.out.println("create table " + sqlName + " as select * from test_suoyi." + sqlName + ";");
		}
	}

	public void generateByAllTable() throws Exception {
		List<Table> tables = DbTableFactory.getInstance().getAllTables();
		for (int i = 0; i < tables.size(); i++) {
			generateByTable(tables.get(i).getSqlName());
		}
	}

	public void generateByTable(String tableName) throws Exception {
		Generator g = createGeneratorForDbTable();
		Table table = DbTableFactory.getInstance().getTable(tableName);
		g.generateByModelProvider(new DbTableGeneratorModelProvider(table));
	}

	@SuppressWarnings("rawtypes")
	public void generateByClass(Class clazz) throws Exception {
		Generator g = createGeneratorForJavaClass();
		g.generateByModelProvider(new JavaClassGeneratorModelProvider(new JavaClass(clazz)));
	}

	public void clean() throws IOException {
		Generator g = createGeneratorForDbTable();
		g.clean();
	}

	public Generator createGeneratorForDbTable() {
		Generator g = new Generator();
		g.setTemplateRootDir(new File("template").getAbsoluteFile());
		g.outRootDir = PropertiesProvider.getProperties().getProperty("outRoot");
		return g;
	}

	private Generator createGeneratorForJavaClass() {
		Generator g = new Generator();
		g.setTemplateRootDir(new File("template/javaclass").getAbsoluteFile());
		g.outRootDir = PropertiesProvider.getProperties().getProperty("outRoot");
		return g;
	}
}
