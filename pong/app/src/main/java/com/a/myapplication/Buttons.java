package com.a.myapplication;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;

public class Buttons {
	Bitmap bmp;
	Point pos;
	Point size;


	public Buttons(Point pos, Point size, Bitmap bmp) {
		this.pos = pos;
		this.size = size;
		this.bmp = bmp;
		//this.bmp = Bitmap.createScaledBitmap(bmp,size.x, size.y, false);

	}

	//public boolean clicked(int clickPos[]){
	//	if(clickPos[0]> pos.x && clickPos[0]< pos.x +size.x){
	//		if(clickPos[1]> pos.y && clickPos[1]< pos.y +size.y){

	//			return true;
	//		}
	//	}
	//	return false;

	//}

	public boolean clicked(int x, int y){
		if(x > pos.x && x < pos.x +size.x){
			if(y > pos.y && y < pos.y +size.y){
				System.out.println("key clicked" );

				return true;
			}
		}
		return false;
	}

	public void draw(Canvas canvas) {
		//bmp = Bitmap.createScaledBitmap(bmp,size.x, size.y, false);
		canvas.drawBitmap(bmp, pos.x, pos.y, null); // 24 is the height of image
	}


	public void setBmp(Bitmap bmp) {
		this.bmp = bmp;
	}

	public Bitmap getBmp() {
		return bmp;
	}

	public void setPos(Point pos) {
		this.pos = pos;
	}

	public Point getPos() {
		return pos;
	}

	public void setSize(Point size) {
		this.size = size;
	}

	public Point getSize() {
		return size;
	}
}
