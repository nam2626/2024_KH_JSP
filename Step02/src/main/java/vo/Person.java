package vo;

public class Person {
	private String name;
	private int age;
	//필드 초기화하는 생성자
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	//set/get
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	//toString
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	
}






