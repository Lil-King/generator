import com.ebiz.generator.GeneratorFacade;
import com.ebiz.generator.PropertiesProvider;

public class GeneratorMain {
	
	public static void main(String[] args) throws Exception {
		

		GeneratorFacade g = new GeneratorFacade();
		g.clean();
		//g.printAllTableNames(); 
		// g.generateByAllTable();
		// String tableNames = "USER_INFO"Introducer;
		// for (String tableName : tableNames.split(",")) {
		// g.generateByTable(tableName);
		// }
		
		g.generateByTable("WWAB_YW_ATTACHMENT");
		Runtime.getRuntime().exec("cmd.exe /c start " + PropertiesProvider.getProperties().getProperty("outRoot"));// 鎵撳紑鏂囦欢澶�

	}
}
