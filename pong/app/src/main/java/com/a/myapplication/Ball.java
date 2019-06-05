package com.a.myapplication;

import android.graphics.*;
//import android.graphics.Paint;
//import android.graphics.Point;
//import android.graphics.Rect;

public class Ball implements GameObject {
	
	private Point pos;
	private Point lastPos;
	private Point vel;
	private int size;
	private int color;

	public Ball(Point pos, Point vel, int size, int color){
		//this.pos = pos;
		this.lastPos = new Point(pos);
		this.pos = new Point(pos);
		this.vel = new Point(vel);
		this.size = size;
		this.color = color;
	}
	public void setPos(Point pos) {
		this.pos = pos;
	}

	public Point getLastPos() {
		return lastPos;
	}
	public Point getPos() {
		return pos;
	}
	public Point getVel() {
		return vel;
	}

	public void changeVelX(){
		vel.x *= (-1);
	}

	public void changeVelY(){
		vel.y *= (-1);
	}
	public void setVelX(int velx ){
		this.vel.x = velx;
	}
	public void setVelY(int vely ){
		this.vel.y = vely;
	}

	public void setPosX(int posx ){
		this.pos.x = posx;
	}

	public void setPosY(int posy ){
		this.pos.y = posy;
	}
	@Override
	public void draw(Canvas canvas) {
		Paint paint = new Paint();
		paint.setColor(color);
		//canvas.drawCircle(pos.x - (size/2), pos.y - (size/2), size, paint);
		canvas.drawCircle(pos.x, pos.y, size, paint);
		paint.setColor(Color.rgb(0, 255, 0));
		canvas.drawCircle(pos.x, pos.y, (size/2), paint);
	}

	public void setVel(Point vel) {
		this.vel = vel;
	}
	public void setSize(int size) {
		this.size = size;
	}

	public int getSize() {
		return size;
	}

	public void update(){
		lastPos = pos;
		pos.x += vel.x;
		pos.y += vel.y;
	}
}
