package cn.itcast.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value= {ElementType.TYPE,ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Pro {

	public String className();
	public String methodName();
}


/*
	public class ProImpl implements Pro{
		public String className{
			return "cn.itcast.annotation.Demo1";
		}
		public String methodName{
			return "show";
		}
	}
*/