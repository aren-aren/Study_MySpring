package com.moveone.app.ioc;

import org.springframework.stereotype.Component;

public class LeftArm extends Arm {

	@Override
	public void act() {
		System.out.println("왼 팔");
		
	}
}
