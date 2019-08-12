package com.artemchep.basics_git;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.artemchep.basics_git.ui.postadd.PostAddFragment;
import com.artemchep.basics_git.ui.postlist.ListFragment;

public class MainActivity extends AppCompatActivity implements AddData, OnOpen {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentLayout, new ListFragment(this))
                .commit();
    }

    @Override
    public void onAddDataPost() {

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentLayout, new ListFragment(this))
                .commit();

    }

    @Override
    public void onOpenFrag() {

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentLayout, new PostAddFragment(this))
                .commit();
    }
}