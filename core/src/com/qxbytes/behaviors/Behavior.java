package com.qxbytes.behaviors;

import com.qxbytes.entities.Entity;

public abstract class Behavior {
	Entity entity;

	public abstract void doBehavior();
	public void addEntity (Entity e) {
		this.entity = e;
	}
	public Entity getEntity() {
		if (entity == null)
			try {
				throw new Exception("Behavior must be assigned an entity; Entity constructor must be faulty");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return entity;
	}
	public void setEntity(Entity entity) {
		this.entity = entity;
	}
	
}
