package cn.itcast.annotation;

public @interface MyAnno {
	
	int age();
	String name();
	String work() default "computer";
	
	People per();//√∂æŸ¿‡
	MyAnno2 anno2();
	
	String[] s();
}
