package com.example.dangineering.gettyair;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.dangineering.gettyair.network.GettyRepository;
import com.example.dangineering.gettyair.recycler.ModelAdapter;
import com.example.dangineering.gettyair.network.respmodel.Image;
import com.example.dangineering.gettyair.network.respmodel.Resp;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements CustomView {

    GettyRepository.ApiService apiService;

    // UI elements
    @Bind(R.id.edit_text)
    EditText editText;

    @Bind(R.id.date_start)
    DatePicker start;

    @Bind(R.id.date_end)
    DatePicker end;

    @Bind(R.id.search_btn)
    Button search;

    @Bind(R.id.list)
    RecyclerView recyclerView;

    ModelAdapter modelAdapter;

    // presenter
    Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        presenter = new Presenter(this);

        //recycler
        modelAdapter = new ModelAdapter();
        recyclerView.setAdapter(modelAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }


    @OnClick(R.id.search_btn)
    void validate() {
        presenter.onSearch(editText.getText().toString(), start.getYear(), start.getMonth(), start.getDayOfMonth(),
            end.getYear(), end.getMonth(), end.getDayOfMonth()
        );
    }


    @Override
    public void add(List<Image> imageList) {
        modelAdapter.setData(imageList);
    }

    @Override
    public void showError(String msg) {
        Snackbar.make(findViewById(android.R.id.content), msg, Snackbar.LENGTH_LONG).show();
    }
}
