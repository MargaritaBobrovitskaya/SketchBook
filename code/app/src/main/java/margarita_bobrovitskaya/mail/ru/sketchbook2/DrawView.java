package margarita_bobrovitskaya.mail.ru.sketchbook2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;

public class DrawView extends View  {
    private Bitmap bitmap;      //Экран

    private Paint p;            //Перо
    Path path;
    int color = Color.RED;
    int width = 5;
    boolean drag = false;
    float x=50, y=50;

    public DrawView(Context context) {
        super(context);

        p = new Paint();
        path = new Path();
        bitmap = Bitmap.createBitmap(300, 300, Bitmap.Config.RGB_565);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        //цвет кисти
        p.setColor(color);
        //толщина кисти
        p.setStrokeWidth(width);
        if (path != null) {
            canvas.drawPath(path, p);
          //  canvas.restore();
        }
 //       invalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
    //    float evX = event.getX();
    //    float evY = event.getY();

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                drag = true;
                path.moveTo(event.getX(), event.getY());
                break;
            case MotionEvent.ACTION_MOVE:
                if(drag){
                   path.lineTo(event.getX(), event.getY());
                }
                break;
            case MotionEvent.ACTION_UP:
                drag = false;
                path.lineTo(event.getX(), event.getY());
                break;
        }
        invalidate();
        return true;
    }
}



