package reflection;

import java.lang.reflect.Field;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Modifier;
import java.lang.reflect.Array;
import java.util.ArrayList;

@SuppressWarnings("rawtypes")
public class ObjectAnalyzer {
	private ArrayList<Object> visited = new ArrayList<>();
	
	/**
	 * Converts object to string representation that lists all fields.
	 * @param obj an object.
	 * @return A string with object's class name and all fields.
	 */
	public String toString (Object obj)throws ReflectiveOperationException {
		if(obj == null) return "null";
		if(visited.contains(obj)) return "...";
		visited.add(obj);
		
		Class cls = obj.getClass();
		if(cls == String.class) return (String)obj; 
		
		if(cls.isArray()) {
			String res = cls.getComponentType() + "[]{";
			for(int i = 0; i < Array.getLength(obj); i++) {
				if(i > 0) res += ",";
				Object val = Array.get(obj,i);
				if(cls.getComponentType().isPrimitive()) res += val;
				else res+=toString(val);
			}
			return res + "}";
		}
		String res = cls.getName();
		do {
			res+="[";
			Field[] fields = cls.getDeclaredFields();
			AccessibleObject.setAccessible(fields, true);
			
			for(Field fld: fields) {
				if(!Modifier.isStatic(fld.getModifiers())) {
					if(!res.endsWith("[")) res += ",";
					res += fld.getName() + "=";
					Class t = fld.getType();
					Object val = fld.get(obj);
					if(t.isPrimitive()) {res += val;}
					else {res += toString(val);}
				}
			}
			res += "]";
			cls = cls.getSuperclass();
		}
		while(cls!=null && cls != Object.class);
		return res;
	}
}
