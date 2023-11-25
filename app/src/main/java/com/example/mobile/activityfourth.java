package com.example.mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class activityfourth extends AppCompatActivity {
    private EditText editText;
    private ListView listView;

    private Bundle savedInstanceState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activityfourth);

        // получаем экземпляр элемента ListView
        ListView listView = (ListView) finalize(R.id.listView);
        final EditText editText = (EditText) finalize(R.id.editText);

        // Создаём пустой массив для хранения имен котов
        final ArrayList<String> orderNames = new ArrayList<>();
        // Создаём адаптер ArrayAdapter, чтобы привязать массив к ListView
        final ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, orderNames);
        // Привяжем массив через адаптер к ListView
        listView.setAdapter(adapter);

        // Прослушиваем нажатия клавиш
        editText.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN)
                    if (keyCode == KeyEvent.KEYCODE_ENTER) {
                        orderNames.add(0, editText.getText().toString());
                        adapter.notifyDataSetChanged();
                        editText.setText("");
                        return true;
                    }
                return false;
            }
        });
    }

    private Object finalize(int listView) {
        return null;
    }

}


