package com.naughtychild.jetpack.databinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.naughtychild.jetpack.R;
import com.naughtychild.jetpack.databinding.bean.Book;

public class BindingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityBindingBindingImpl bindingBinding = DataBindingUtil.setContentView(this, R.layout.activity_binding);

        Book book = new Book("book_name", "author");
        EventHandler eventHandler = new EventHandler(this);
        bindingBinding.setBook(book);
        bindingBinding.setEventHandler(eventHandler);

    }
    class EventHandler {
        private Context context;
        public EventHandler(Context context) {
            this.context = context;
        }
        public void toast(View view) {
            Toast.makeText(context, "lalala", Toast.LENGTH_SHORT).show();
        }
    }
}