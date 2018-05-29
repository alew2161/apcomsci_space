package com.qxbytes.behaviors;

import com.qxbytes.entities.Entity;

public abstract class Behavior {
	Entity entity;
	public Behavior (Entity entity) {
		this.entity = entity;
		
	}
	public abstract void doBehavior();
}
