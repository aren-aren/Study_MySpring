package com.moveone.app.ioc;

import org.springframework.stereotype.Component;

public class RightArm extends Arm {

	@Override
	public void act() {
		System.out.println("오른 팔");
		
	}
	
}
