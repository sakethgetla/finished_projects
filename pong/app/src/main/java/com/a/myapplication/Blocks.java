package com.a.myapplication;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;

public class Blocks implements GameObject {
	
	private Point pos;
	private Point size;
	private int color;
	private boolean visible = true;

	public Blocks(Point pos, Point size, int color){
		this.pos = new Point(pos);
		this.size = size;
		this.color = color;
	}
	public void setPos(Point pos) {
		this.pos = pos;
	}

	public Point getPos() {
		return pos;
	}
	public void setColor(int color){
		this.color = color;
	}
	public void setVisible(boolean vis){
		this.visible = vis;
	}
	public boolean getVisible(){
		return this.visible;
	}
	@Override
	public void draw(Canvas canvas) {
		if (this.visible){
			Paint paint = new Paint();
			paint.setColor(color);
			canvas.drawRect(pos.x, pos.y, pos.x + size.x, pos.y + size.y, paint);
		}
	}

	public void setSize(Point size) {
		this.size = size;
	}

	public Point getSize() {
		return size;
	}
	public void update(){
	}
}
