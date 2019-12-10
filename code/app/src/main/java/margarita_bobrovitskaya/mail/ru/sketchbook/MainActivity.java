package margarita_bobrovitskaya.mail.ru.sketchbook;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.FileInputStream;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView btnClose;                 // Иконка закрытия
    ImageView btnLoad;                  // Иконка загрузки картинки
    ImageView btnAdd;                   // Иконка открытия окна с рабочей поверхностью

    String i = "0";                          // иконка загрузки картинки не нажата
    boolean b = false;                  // кнопка loadButton не включена


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        btnClose = (ImageView) findViewById(R.id.close_btn);
        btnLoad = (ImageView) findViewById(R.id.load_btn);
        btnAdd = (ImageView) findViewById(R.id.add_btn);

        // Присваиваем обраблтчик кнопкам
        btnClose.setOnClickListener(this);
        btnLoad.setOnClickListener(this);
        btnAdd.setOnClickListener(this);

        if (b) {
            Intent intentLoad = new Intent(this, WorkingActivity.class);
            intentLoad.putExtra(i, "log");
            startActivity(intentLoad);
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
            case R.id.close_btn: {
                this.onDestroy();
            }
                break;
            // нажимаем иконку загрузки картинки
            case R.id.load_btn: {
                i = "1";
                Button loadButton = (Button) findViewById(R.id.button_load);
                Dialog dialogLoad = new Dialog(MainActivity.this);
                dialogLoad.setContentView(R.layout.load_dialog_layout);
                dialogLoad.show();
                loadButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       b=true;
                    }
                });


            }
                break;
            // нажимаем иконку открытия окна с рабочей поверхностью
            case R.id.add_btn:{
                Intent intent = new Intent(this, WorkingActivity.class);
                startActivity(intent);
            }
                break;
        }

    }


}
