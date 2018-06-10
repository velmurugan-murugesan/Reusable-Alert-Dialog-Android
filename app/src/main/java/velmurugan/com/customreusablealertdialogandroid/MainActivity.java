package velmurugan.com.customreusablealertdialogandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnShowDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShowDialog = findViewById(R.id.btnShowDialog);
        btnShowDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyAlertDialog myAlertDialog = new MyAlertDialog(MainActivity.this);
                myAlertDialog.setAlertTitle(getString(R.string.delete));
                myAlertDialog.setAlertIcon(getResources().getDrawable(R.drawable.ic_info_black_24dp));
                myAlertDialog.setAlertDesciption(getResources().getString(R.string.desc));
                myAlertDialog.setMiddleButtonText(getString(R.string.ok));

                myAlertDialog.setOnActionListener(new MyAlertDialog.DialogActionListener() {
                    @Override
                    public void onAction(View view) {

                        switch (view.getId()){
                            case R.id.btn_left:
                                Toast.makeText(getApplicationContext(),"left",Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.btn_right:
                                Toast.makeText(getApplicationContext(),"right",Toast.LENGTH_SHORT).show();
                                break;
                        }

                    }
                });
                myAlertDialog.show();
            }
        });
    }
}
