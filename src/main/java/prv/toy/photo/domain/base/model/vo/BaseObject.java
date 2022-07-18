package prv.toy.photo.domain.base.model.vo;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.sql.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;
import prv.toy.photo.common.Util;

@Data
public class BaseObject {

	@Autowired private Util util;

	private long oid;
	private Date createdAt;

	public void build(Map<String, Object> map) {
		Class<?> myClass = this.getClass();
		if (map == null) return;

		// for (String key : map.keySet()) {
		// 	Field f = null;
		// 	Object val = null;
		// 	try {
		// 		f = myClass.getDeclaredField(key);
		// 		val = map.get(key);

		// 		if (Modifier.isFinal(f.getModifiers())) continue;

		// 		f.setAccessible(true);
		// 		f.set(this, val);
		// 	} catch (NoSuchFieldException e) {
		// 		System.out.println("NoSuchFieldException");
		// 	} catch (SecurityException e) {
		// 		System.out.println("SecurityException");
		// 	} catch(IllegalAccessException | IllegalArgumentException e ) {
		// 		System.out.println("IllegalAccessException / IllegalArgumentException");
		// 	}finally {
		// 		if (f != null) {
		// 			f.setAccessible(false);
		// 		}
		// 	}
		// }

		Field[] myFields = myClass.getDeclaredFields();
		Field[] superFields = myClass.getSuperclass().getDeclaredFields();

		Field[] newFields = new Field[myFields.length + superFields.length];

		System.arraycopy(myFields, 0, newFields, 0, myFields.length);
		System.arraycopy(superFields, 0, newFields, myFields.length, superFields.length);
		
		for (Field f : newFields) {
			String fName = f.getName();
			
			try {
				f.setAccessible(true);
				f.set(this, map.get(fName));
			} catch (IllegalArgumentException e) {
			} catch (IllegalAccessException e) {
			} finally {
				if (f != null) {
					f.setAccessible(false);
				}
			}
			
		}
	}
}
