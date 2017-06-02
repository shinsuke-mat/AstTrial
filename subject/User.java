package jp.ac.osakau.ast.example;

public class Example {
	private String name;
	private int age;

	public Example() {
		this("", 0);
	}
	public Example(String name, int age) {
		this.setName(name);
		this.setAge(age);
	}
	
	public void testMethod(int n) {
		if (n > 0) {
			System.out.println("x");
			int x = 0;
		} else {
			System.out.println("???");
		}
		for (int i = 0; i > 10; i++) {
			System.out.println("y");
		}
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	// test comment
	public void setAge(int age) {
		if (age < 0) {
			age = 0;
		}
		this.age = age;
	}

}
