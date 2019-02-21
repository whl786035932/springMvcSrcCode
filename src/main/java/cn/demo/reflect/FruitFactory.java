package cn.demo.reflect;

public class FruitFactory {
	private Fruit fruit;
	
	public static Fruit getInstance(String className) {
		if("Apple".equals(className)) {
			return new Apple();
		}
		if("Orange".equals(className)){
			return new Orange();
		}
		return null;
	}
	
	public static Fruit getInstance_className(String className){
		try {
			Object newInstance = Class.forName(className).newInstance();
			return (Fruit) newInstance;
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
