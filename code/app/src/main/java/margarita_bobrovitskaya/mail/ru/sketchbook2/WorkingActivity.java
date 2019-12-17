package margarita_bobrovitskaya.mail.ru.sketchbook2;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class WorkingActivity extends AppCompatActivity implements View.OnClickListener {

//    int mColor = Color.RED;
//    int mWidth = 5;

//    DrawView holst;
/*
    ImageView btnClose2;
    ImageView btnClear;
    ImageView btnSave;
    ImageView btnTools;
    ImageView btnLeftArrow;
    ImageView btnRightArrow;

    ImageView btnRed;
    ImageView btnOrange;
    ImageView btnYellow;
    ImageView btnGreen;
    ImageView btnBlue;
    ImageView btnDarkBlue;
    ImageView btnViolet;
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_working);
        setContentView(new DrawView(this));
//        holst = (DrawView) findViewById(R.id.drawView);

/*
        btnClose2 = (ImageView) findViewById(R.id.close2_btn);
        btnClear = (ImageView) findViewById(R.id.clear_btn);
        btnSave = (ImageView) findViewById(R.id.save_btn);
        btnTools = (ImageView) findViewById(R.id.tools_btn);
        btnLeftArrow = (ImageView) findViewById(R.id.left_arrow_btn);
        btnRightArrow = (ImageView) findViewById(R.id.right_arrow_btn);

        btnRed = (ImageView) findViewById(R.id.red_btn);
        btnOrange = (ImageView) findViewById(R.id.orange_btn);
        btnYellow = (ImageView) findViewById(R.id.yellow_btn);
        btnGreen = (ImageView) findViewById(R.id.green_btn);
        btnBlue = (ImageView) findViewById(R.id.blue_btn);
        btnDarkBlue = (ImageView) findViewById(R.id.darkblue_btn);
        btnViolet = (ImageView) findViewById(R.id.violet_btn);

                //Загружаем  холст
   /*    String mai = getIntent().getStringExtra("log"); // Логическая переменная из MainActivity которая определяет нужно загружать картинку из памяти или нет
        if (mai.equals("1")){
            Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
            photoPickerIntent.setType("image/*");
            startActivityForResult(photoPickerIntent, GALLERY_REQUEST);

        }
        */


        /*

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
       */

    }

    //загрузка картинки
    /*
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

     */

    @Override
    public void onClick(View v) {
        /*
        switch (v.getId()) {
            // нажимаем иконку закрыть
            case R.id.close2_btn: {
                this.onDestroy();
            }
            break;
            case R.id.clear_btn: {

                holst.bitmap.eraseColor(Color.WHITE);

            }
            break;
            case R.id.save_btn: {
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
            case R.id.tools_btn: {

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
            case R.id.left_arrow_btn: {
                originator.getState();
            }
            break;
            case R.id.right_arrow_btn: {
                originator.getState();
                caretaker.setMemento(originator.saveState());

            }
            break;

            case R.id.red_btn: {
                mColor = Color.RED;
            }
            break;
            case R.id.orange_btn: {
                mColor = 0xFF9900;
            }
            break;
            case R.id.yellow_btn: {
                mColor = Color.YELLOW;
            }
            break;
            case R.id.green_btn: {
                mColor = Color.GREEN;
            }
            break;
            case R.id.blue_btn: {
                mColor = 0x00FFFF;
            }
            break;
            case R.id.darkblue_btn: {
                mColor = 0x2b78e4;
            }
            break;
            case R.id.violet_btn: {
                mColor = 0x9900FF;
            }
            break;


        }

        //сохраняем картинку
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

        */
    }
/*
    @Override
    protected void onDestroy(){
        super.onDestroy();
    }
    */
}
