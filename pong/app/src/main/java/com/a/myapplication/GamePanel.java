package com.a.myapplication;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.Button;
import android.widget.ImageView;
import java.util.*;

import java.util.logging.Handler;

public class GamePanel extends SurfaceView implements SurfaceHolder.Callback {
	private MainThread thread;

	private RectPlayer pRect;
	//private Buttons leftKey;
	//private Buttons rightKey;
	private Point playerPoint, playerSize, btnSize;
	private final int speed = 5;
	//private Button btn;
	//private Bitmap leftKeyImg; 
	//private Bitmap rightKeyImg; 
	//private Bitmap bmp;
	private int ballSize, ballVelTot;
	private Boolean start;
	private Ball ball;
	//private Ball ball;

	ArrayList<Blocks> blockList = new ArrayList<Blocks>();
	

    //private ImageView img;


	public GamePanel(Context context) {

		super(context);

		getHolder().addCallback(this);

		thread = new MainThread(getHolder(), this);

		setFocusable(true);
		//bmp = BitmapFactory.decodeResource(getResources(), R.drawable.spacecraft1);
		//bmp = Bitmap.createScaledBitmap(bmp,240,190, false);

        //btn.setOnClickListener();
	}

	public void init() {

		start = false;

		//playerPoint.set( 0, (int) this.getHeight() - pRect.getHeight() - 10);
		//System.out.println(btnSize.x + "kjjjjjjjjjjjj " + btnSize.y);


		playerSize = new Point(this.getWidth()/3, this.getHeight()/15);
		playerPoint = new Point((int) this.getWidth()/2,  this.getHeight() - (int)(1.5* playerSize.y));
		//playerPoint = new Point( 0, 50);
		pRect = new RectPlayer(playerPoint, playerSize, Color.rgb(0, 255, 0));
		
		//rightKey = new Buttons(new Point(150, 50), btnSize, rightKeyImg);
		ballSize = 20;
		ballVelTot = 15;
		ball = new Ball(playerPoint, new Point(0,0), ballSize, Color.rgb(255, 0, 0));
		
		int totCol = 20;
		int totRow = 20;
		int blockWidth = this.getWidth()/totCol;
		int blockHeight = (this.getHeight()/(2*totRow));

		for( int N_col = 0 ; N_col < totCol ; N_col++) {
			for(int N_row = 0 ; N_row < totRow ; N_row++) {
				blockList.add(new Blocks(new Point(N_col*blockWidth, (1+N_row)*blockHeight), new Point(blockWidth, blockHeight), Color.rgb(225*(N_row%2), 255*((N_col)%2), 0)));
			}
		}


		//btnSize = new Point(this.getWidth() /8 , this.getHeight()/8);
		//System.out.println(btnSize.x + "kjjjjjjjjjjjj " + btnSize.y);
		//leftKeyImg = BitmapFactory.decodeResource(getResources(), R.drawable.marker);
		//leftKeyImg = Bitmap.createScaledBitmap(leftKeyImg, btnSize.x, btnSize.y, false);
		//leftKey = new Buttons(new Point(150, 50), btnSize, leftKeyImg);

		//rightKeyImg = BitmapFactory.decodeResource(getResources(), R.drawable.marker);
		//rightKeyImg = Bitmap.createScaledBitmap(rightKeyImg, btnSize.x, btnSize.y, false);
		//rightKey = new Buttons(new Point(50, 50), btnSize, rightKeyImg);
	}
	       /* Button leftBtn = (Button) findViewById(R.id.button);

        leftBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerPoint.x -= speed;
            }
        });
	*

	 //img = (ImageView) findViewById(R.id.imageView);

	img = new ImageView();
	img.setOnClickListener(new View.OnClickListener() {

		@Override
		public void onClick(View v) {
		    //some code
		}
	    });

	*/

    


    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {


    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        thread = new MainThread(getHolder(), this);
        thread.setRunning(true);
        thread.start();


    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;
        while (retry) {
            try {
                thread.setRunning(false);
                thread.join();

            } catch (Exception e) {
                e.printStackTrace();
            }
            retry = false;

        }
    }

    //final Handler handler = new Handler();
    //Runnable mLongPressed = new Runnable() {
    //    public void run() {
    //        Log.i("", "Long press!");
    //    }
    //};



    //@Override
    //public boolean onTouchEvent(MotionEvent event, MapView mapView){
    //    if(event.getAction() == MotionEvent.ACTION_DOWN)
    //        handler.postDelayed(mLongPressed, ViewConfiguration.getLongPressTimeout());
    //    if((event.getAction() == MotionEvent.ACTION_MOVE)||(event.getAction() == MotionEvent.ACTION_UP))
    //        handler.removeCallbacks(mLongPressed);
    //    return super.onTouchEvent(event, mapView);
    //}

    final GestureDetector gestureDetector = new GestureDetector(new GestureDetector.SimpleOnGestureListener() {
        public void onLongPress(MotionEvent e) {
            Log.e("", "Longpress detected");
        }
    });

//    public boolean onTouchEvent(MotionEvent event) {
//    };

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE:
		if (pRect.clicked((int) event.getX(), (int) event.getY())){
			//System.out.println("player clicked on bar" );
			playerPoint.x = (int) event.getX() - (pRect.getWidth()/2);
			//if (playerPoint.y > blockList.get(blockList.size()-1).getPos().y){
			//	playerPoint.y = (int) event.getY() - (pRect.getHeight()/2);
			//	if(ball.getVel().y <0){
			//		ball.setPosY(playerPoint.y); 
			//	}
			//}
			//playerPoint.y = even.getY() ;
			//pRect.setPos(playerPoint);
			//playerPoint.set((int) event.getX() - (pRect.getWidth()/2),  pRect.getPos().y);
                break;

		}

            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_HOVER_ENTER:
		if (!start){
			start = true;
			System.out.println("started>>>>>>>>>>>>>>>>>>>>>>>>>>> " );
			// check if ball Vel is equal to zero
			ball.setVel(new Point(-ballVelTot, -ballVelTot));
		}
		//if (leftKey.clicked((int) event.getX(), (int) event.getY())){

		//	System.out.println("kjakejfhkesjhfkesjfhkesjhfhejjjjjjjjjjj " );
		//}
		//if (rightKey.clicked((int) event.getX(), (int) event.getY())){
		//	System.out.println("kjakejfhkesjhfkesjfhkesjhfhejjjjjjjjjjj " );
		//}
		//if (pRect.clicked((int) event.getX(), (int) event.getY())){
		//	//System.out.println("player clicked on bar" );

		//}
                break;


        }

        //return super.onTouchEvent(event);
        //return gestureDetector.onTouchEvent(event);
        return true;
    }


	public void update() {
		pRect.setPos(playerPoint);
		ball.update();
		//pRect.update();

		for(Blocks blk: blockList){
			if(blk.getVisible()){
				if(ball.getPos().x < ball.getSize() + blk.getPos().x + blk.getSize().x && ball.getPos().x > blk.getPos().x - ball.getSize()){
					if(ball.getPos().y < ball.getSize() + blk.getPos().y + blk.getSize().y && ball.getPos().y > blk.getPos().y - ball.getSize()){
						// collision with the blocks
						blk.setVisible(false);
					}
				}
			}
		}

		if (ball.getPos().x - ball.getSize() < 0 || ball.getPos().x + ball.getSize() > this.getWidth() ) {
			ball.changeVelX();
		}
		if (ball.getPos().y - ball.getSize() < 0 || (ball.getPos().x <= pRect.getPos().x + pRect.getWidth() && ball.getPos().x > pRect.getPos().x && ball.getPos().y >= pRect.getPos().y) ){
			ball.changeVelY();
		}
	}

	    //public Picture(R.drawable.spacecraft);


    /**/
    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        canvas.drawColor(Color.GRAY);

        pRect.draw(canvas);

	Paint paint = new Paint();
	paint.setColor(Color.rgb(255, 0, 0));
	//canvas.drawArc(50, 20, 405, 400, 0, 90, false, paint);
	//paint.setColor(Color.rgb(0, 255, 0));
	//canvas.drawArc(50, 20, 105, 400, -90, 90, true, paint);
	//paint.setColor(Color.rgb(255, 0, 0));
	//canvas.drawArc(playerPoint.x, playerPoint.y - 30, playerPoint.x + pRect.getWidth(), playerPoint.y + pRect.getHeight(), 0, -180, false, paint);
	
	// make the log on the bottom curved
	
	for(Blocks blk: blockList){
		if(blk.getVisible()){
			blk.draw(canvas);
		}

	}

	ball.draw(canvas);

	//canvas.drawArc(50, 105, 100, 0, 50, 40);
        //btn.view.Bitmap


	//leftKey.draw(canvas);
          //pic = R.drawable.spacecraft;

       // BitmapDrawable drawable = new BitmapDrawable(getResources(), bmp);
       // drawable.setAlpha(100);
       // drawable.
       //  bmp.setHasAlpha(true);
       // bmp.setWidth(50);
       /* Paint paint = new Paint();
        paint.setColor(Color.rgb(255,0,0));
        */

         // canvas.drawARGB(10, 110, 130, 100);
        //canvas.draw
        //drawable.draw(canvas);

       // bmp = (Bitmap) drawable;
//canvas.drawBitmap(rightKey.getBmp(), rightKey.pos.x, rightKey.pos.y, null); // 24 is the height of image
       //

	//leftKey.draw(canvas);
	//rightKey.draw(canvas);
	//canvas.drawBitmap(bmp, playerPoint.x, playerPoint.y, null); // 24 is the height of image
		//canvas.drawBitmap(leftKey.getBmp(), leftKey.getPos().x, leftKey.getPos().y, null); // 24 is the height of image
		//canvas.drawBitmap(leftKey.getBmp(), leftKey.getPos().x, leftKey.getPos().y, null); // 24 is the height of image
          //canvas.drawBitmap(bmp , 50,50 - 24, null); // 24 is the height of image

        //canvas.drawPicture();
        //btn.draw(canvas);


    }

}
