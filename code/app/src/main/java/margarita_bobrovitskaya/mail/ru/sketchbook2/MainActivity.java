package margarita_bobrovitskaya.mail.ru.sketchbook2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView btnClose;                    // кнопка Закрыть приложение
    ImageView btnLoad;                     // кнопка Загрузить сохраненую картинку
    ImageView btnAdd;                      // кнопка Открыть новую картинку

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnClose = (ImageView) findViewById(R.id.close_btn);
        btnLoad = (ImageView) findViewById(R.id.load_btn);
        btnAdd = (ImageView) findViewById(R.id.add_btn);

        btnClose.setOnClickListener(this);
        btnLoad.setOnClickListener(this);
        btnAdd.setOnClickListener(this);

    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            // Закрыть приложение
            case R.id.close_btn:
                  this.onDestroy();
                  break;
            // Загрузить сохраненую картинку
            case R.id.load_btn:

                /*
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


*/

                break;
            // Открыть новую картинку
            case R.id.add_btn:
                startActivity(new Intent(MainActivity.this, WorkingActivity.class));
                break;

            default:
                break;
        }

    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
    }
}
