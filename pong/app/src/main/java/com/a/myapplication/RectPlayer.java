package com.a.myapplication;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;

public class RectPlayer implements GameObject {

	// private Rect rect;
	private int color;


	private int height = 90;
	private int width = 320;
	private Point pos;
	private Point lastPos;
	//private point point= new Point(0,0);


	public RectPlayer(Point pos, Point size, int color) {
		this.height = size.y;
		this.width = size.x;
		this.pos = new Point(pos);
		this.lastPos = new Point(pos);
		// this.rect = new Rect(x, y, color);
		this.color = color;
		//this.rect.width();
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}


	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	@Override
	public void draw(Canvas canvas) {
		Paint paint = new Paint();
		paint.setColor(color);

		canvas.drawRect(pos.x, pos.y, pos.x + width, pos.y + height, paint);
	}


	public boolean clicked(int x, int y){
		if(x > pos.x && x < pos.x + width){
			if(y > pos.y && y < pos.y + height){
				System.out.println("key clicked" );

				return true;
			}
		}
		return false;
	}

	public void setPos(Point pos){
		this.lastPos = this.pos;
		this.pos = pos;

	}
	public Point getPos(){
		return pos;
	}
	@Override
	public void update() {


	}


}
