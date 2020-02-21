package ysn.com.demo.annotation;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import ysn.com.demo.annotation.bean.User;
import ysn.com.demo.annotation.formatter.SimpleFormatter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView resultTextView = findViewById(R.id.main_activity_result);

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        User user = new User();
        user.setName("Jack");
        try {
            user.setBorn(format.parse("1992-11-26"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        user.setAge(28);

        resultTextView.setText(SimpleFormatter.format(user));
    }
}
