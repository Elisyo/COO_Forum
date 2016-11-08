package src.persistence;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Map;

public class DataMapper <T>{
	Map<String,Class<?>> fields;
	String table;
	Class<?> maClasse;
	private static Connection c;
	
	public DataMapper(String table, Map<String, Class<?>> fields, Class<?> maClasse){
		this.table=table;
		this.fields=fields;
		this.maClasse=maClasse;
	}
	
	void insert(T p) throws Exception{
		// Prepared statement ...
		String req = "insert into " + table + " values";
		PreparedStatement ps = c.prepareStatement(req);
		
		boolean first = true;
		for(Map.Entry<String, Class<?>> e : fields.entrySet()){
			if(!first){
				req+=",";
				first = false;
			}
			req+="?";
		}
		int i=0;
		for(Map.Entry<String, Class<?>> e : fields.entrySet()){
			i++;
			//toto => getToto
			String key = e.getKey(); // nom du champ
			String name = "get"+ key.substring(0, 1).toUpperCase() + key.substring(1);
			Method m = maClasse.getMethod(name);
			Object r = m.invoke(p);
			if(e.getValue() != r.getClass()){
				// bug !
			}
			if(e.getValue() == String.class){
				// ps.setString(i, (String) r)
				System.out.println();
			}else{ // integer
				// ps.setInt(i, (Integer) r)
			}
		}
	}
	// à faire pour update et delete
	// grâce à ça, on n'a plus qu'un seul dataMapper !!!
	
}
