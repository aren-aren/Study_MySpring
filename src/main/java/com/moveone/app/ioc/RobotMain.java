package com.moveone.app.ioc;

public class RobotMain {
	/*
	 * @설명 + 기능
	 * 1. 객체 생성, 클래스 선언부 위에 작성
	 * @Controller	: controller 역할
	 * @Service		: service 역할
	 * @Repository	: dao역할
	 * @Component	: 그 외 나머지
	 * 
	 * -> 만들어진 객체는 pool에 저장
	 * 
	 * 2. 객체 주입, 멤버변수 위, 생성자 위, 메서드 위에 작성
	 * @Autowired	: 주입
	 * @Inject		: 주입
	 * @Resource	: 주입
	 * 
	 * -> pool에서 같은 타입의 객체를 찾아 주입
	 */

	public static void main(String[] args) {
		/*
		 * 개발자가 직접 객체를 생성시 robot의 멤버는 의존성 주입을 받지 못함
		 * component-scan에 의해 자동으로 생성될 시에만 (프로그램 실행 시에)
		 * annotation에 의해 의존성을 주입받을 수 있음
		 * 
		 * 프로그램 실행시 component를 찾아 단 하나만 만들어 pool에 저장
		 * 	- Bean으로 Spring에서 관리( Bean : Spring에서 만든 객체 )
		 * 
		 * 만들 때 field에 Autowired가 있으면 그때 만들어 주는 듯?
		 * (직접 만들면 주입을 못받음)
		 * 
		 * Singleton : 싱글톤
		 * Application내에 객체를 하나만 만들어 관리함
		 * pool에 하나만 만들어 관리하기에 같은걸 주입 받으면 결국 같은 객체
		 * 
		 * IOC :  Inversion Of Control - 제어의 역전
		 * 객체의 생성 및 주입을 개발자가 아닌 SpringContainer에게 위임하는 것
		 * 
		 */
		//Robot robot = new Robot();
		
		
	}

}
