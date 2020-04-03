package com.tudou.fastec.example;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.tudou.fastec.latte.activities.ProxyActivity;
import com.tudou.fastec.latte.app.Latte;
import com.tudou.fastec.latte.delegates.LatteDelegate;

public class ExampleActivity extends ProxyActivity {


    @Override
    public LatteDelegate setRootDelegate() {
        return new ExampleDelegate();
    }
}
