package nattawut.lab.navdrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.TypefaceProvider;

public class loginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TypefaceProvider.registerDefaultIconSets();
        setContentView(R.layout.activity_login);

        final EditText username = findViewById(R.id.edtUsername);
        final EditText password = findViewById(R.id.edtPassword);
        BootstrapButton btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login(username.getText().toString(), password.getText().toString());
            }
        });

    }

    private void login(String username, String password) {
        // ถ้า username และ password = "admin"
        if (username.equals(("admin")) && password.equals(("admin"))) {
            // สร้างตัวแปร Intent เก็บคำสั่งไปหน้า MainActivity
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);

            // Clear Top ของ Stack เพราะว่าเมื่อ Login เสร็จแล้ว เมื่อกดปุ่ม back
            // จะไม่กลับไปที่หน้า Login อีกครั้ง
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

            // ไปที่ Activity ในตัวแปรภายใน Parameter (คือ intent ที่เก็บคำสั่งบรรทัดที่ 25)
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(), " Login Fail ", Toast.LENGTH_LONG).show();
        }
    }
}
