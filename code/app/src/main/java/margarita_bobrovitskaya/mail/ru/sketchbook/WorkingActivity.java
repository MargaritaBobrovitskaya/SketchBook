package margarita_bobrovitskaya.mail.ru.sketchbook;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WorkingActivity extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener {
    static final  int GALLERY_REQUEST = 1;  // КОНСТАНТА ДЛЯ ИНТЕНТА ГАЛЕРЕИ

    ImageView holst;          // Холст

    ImageView btnClose2;      // Иконка закрытия
    ImageView btnClear;       // Иконка очистки экрана
    ImageView btnSave;        // Иконка сохранения картинки
    ImageView btnTools;       // Иконка инструменты
    ImageView btnLeftArrow;   // Иконка отмены последнего действия
    ImageView btnRightArrow;  //Иконка повторного действия

    ImageView btnRed;         // Иконка красного цвета
    ImageView btnOrange;      // Иконка оранжевого цвета
    ImageView btnYellow;      // Иконка желтого цвета
    ImageView btnGreen;       // Иконка зеленого цвета
    ImageView btnBlue;        // Иконка голубого цвета
    ImageView btnDarkBlue;    // Иконка синего цвета
    ImageView btnViolet;      // Иконка фиолетового цвета

    String name ="";           // Имя сохраняемого файла
    int mColor = Color.RED;    // Цвет пера
    int mWidth = 1;             //Ширина пера

    // Классы паттерна мементо
    Originator originator;
    Caretaker caretaker;


  //  DrawView mDrawView = new DrawView(this, mColor, mWidth, );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.working_activity);
       // setContentView(new DrawView(this, mColor, mWidth, 0, 0));

        holst = (ImageView) findViewById(R.id.holst);

        btnClose2 = (ImageView) findViewById(R.id.close2_btn);
        btnClear = (ImageView) findViewById(R.id.clear_btn);
        btnSave = (ImageView) findViewById(R.id.save_btn);
        btnTools = (ImageView) findViewById(R.id.tools_btn);
        btnLeftArrow = (ImageView) findViewById(R.id.leftArrow_btn);
        btnRightArrow = (ImageView) findViewById(R.id.rightArrow_btn);

        btnRed = (ImageView) findViewById(R.id.red_btn);
        btnOrange = (ImageView) findViewById(R.id.orange_btn);
        btnYellow = (ImageView) findViewById(R.id.yellow_btn);
        btnGreen = (ImageView) findViewById(R.id.green_btn);
        btnBlue = (ImageView) findViewById(R.id.blue_btn);
        btnDarkBlue = (ImageView) findViewById(R.id.darkblue_btn);
        btnViolet = (ImageView) findViewById(R.id.violet_btn);
        //Загружаем  холст
        String mai = getIntent().getStringExtra("log"); // Логическая переменная из MainActivity которая определяет нужно загружать картинку из памяти или нет
        if (mai.equals("1")){
            Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
            photoPickerIntent.setType("image/*");
            startActivityForResult(photoPickerIntent, GALLERY_REQUEST);
        }
        //обработка прикосновениями экрана
        holst.setOnTouchListener(this);
        // Присваиваем обраблтчик кнопкам
        btnClose2.setOnClickListener(this);
        btnClear.setOnClickListener(this);
        btnSave.setOnClickListener(this);
        btnTools.setOnClickListener(this);
        btnLeftArrow.setOnClickListener(this);
        btnRightArrow.setOnClickListener(this);

        btnRed.setOnClickListener(this);
        btnOrange.setOnClickListener(this);
        btnYellow.setOnClickListener(this);
        btnGreen.setOnClickListener(this);
        btnBlue.setOnClickListener(this);
        btnDarkBlue.setOnClickListener(this);
        btnViolet.setOnClickListener(this);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);

        Bitmap bitmap = null;


        switch(requestCode) {
            case GALLERY_REQUEST:
                if(resultCode == RESULT_OK){
                    Uri selectedImage = imageReturnedIntent.getData();
                    try {
                        bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), selectedImage);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    holst.setImageBitmap(bitmap);
                }
        }
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            // нажимаем иконку закрыть
            case R.id.close2_btn: {
                this.onDestroy();
            }
                break;
            // нажимаем иконку очистить экран
            case R.id.clear_btn: {
                DrawView mDrawView = new DrawView(this, mColor, mWidth,0,0);
                mDrawView.bitmap.eraseColor(Color.WHITE);
                holst.setImageBitmap(mDrawView.bitmap);
            }
                break;
            // нажимаем иконку сохранить картинку
            case R.id.save_btn:{
                Button saveButton = (Button) findViewById(R.id.save_button);
                EditText nameImage = (EditText) findViewById(R.id.editText);   //введем имя файла

                Dialog dialogSave = new Dialog(WorkingActivity.this);
                dialogSave.setContentView(R.layout.load_dialog_layout);
                dialogSave.show();
                name = nameImage.getText().toString();
                saveButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       SavePicture(holst.getDrawingCache(), name);
                    }
                });

            }
                break;
            // нажимаем иконку открыть окно инструментов
            case R.id.tools_btn:{
                SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
                ImageView pen = (ImageView) findViewById(R.id.pen_btn);
                ImageView eraser = (ImageView) findViewById(R.id.eraser_btn);
                Dialog dialogTools = new Dialog(WorkingActivity.this);
                dialogTools.setContentView(R.layout.tools_dialog_layout);
                dialogTools.show();
                seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        mWidth = seekBar.getProgress();
                    }
                });

                pen.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mColor = Color.RED;
                    }
                });

                eraser.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mColor = Color.WHITE;
                    }
                });
            }
                break;
            // нажимаем иконку отмены последнего действия
            case R.id.leftArrow_btn:{
                originator.getState();
            }
                break;
            // нажимаем иконку повторения действия
            case R.id.rightArrow_btn:{
                originator.getState();
                caretaker.setMemento(originator.saveState());
            }
                break;
            // нажимаем иконку красного цвета
            case R.id.red_btn:{
                mColor = Color.RED;
            }
                break;
            // нажимаем иконку оранжевого цвета
            case R.id.orange_btn:{
                mColor = 0xFF9900;
            }
                break;
            // нажимаем иконку желтого цвета
            case R.id.yellow_btn:{
                mColor = Color.YELLOW;
            }
                break;
            // нажимаем иконку зеленого цвета
            case R.id.green_btn:{
                mColor = Color.GREEN;
            }
                break;
            // нажимаем иконку голубого цвета
            case R.id.blue_btn:{
                mColor = 0x00FFFF;
            }
                break;
            // нажимаем иконку синего цвета
            case R.id.darkblue_btn:{
                mColor = 0x2b78e4;
            }
            break;
            // нажимаем иконку фиолетового цвета
            case R.id.violet_btn:{
                mColor = 0x9900FF;
            }
            break;
        }

    }



    private String SavePicture(Bitmap bmp, String str)
    {
        OutputStream fOut = null;
        try {
            File dest = new File(getGalleryPath()+str);
            dest.mkdirs();
            File file = new File(getGalleryPath()+str, System.currentTimeMillis()/1000 +".jpg"); // создать уникальное имя для файла основываясь на дате сохранения
            fOut = new FileOutputStream(file);

            bmp.compress(Bitmap.CompressFormat.JPEG, 85, fOut); // сохранять картинку в jpeg-формате с 85% сжатия.
            fOut.flush();
            fOut.close();
            MediaStore.Images.Media.insertImage(getContentResolver(), file.getAbsolutePath(), file.getName(), file.getName()); // регистрация в фотоальбоме

        }
        catch (Exception e) // здесь необходим блок отслеживания реальных ошибок и исключений, общий Exception приведен в качестве примера
        {
            return e.getMessage();
        }
        return "";
    }
    private static String getGalleryPath() {
        return  Environment.getExternalStorageDirectory() + "/";
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        if(event.getAction() == MotionEvent.ACTION_MOVE){
          //  new DrawView(this, mColor,mWidth, x, y);
            originator = new Originator();
            caretaker = new Caretaker();
        }
        return true;
    }

    class DrawView extends View {

        Bitmap bitmap;      //Экран

        Paint p;            //Перо
        int color;
        int width;
        float x, y;

        public DrawView(Context context, int color, int width, float x, float y) {
            super(context);

            this.color = color;
            this.width = width;
            this.x = x;
            this.y = y;
            bitmap = Bitmap.createBitmap(300, 300, Bitmap.Config.RGB_565);
            p = new Paint();

        }

        @Override
        protected void onDraw(Canvas canvas) {
            //цвет кисти
            p.setColor(color);
            //толщина кисти
            p.setStrokeWidth(width);
            canvas.drawPoint(x, y, p);
            invalidate();
        }

    }
}
