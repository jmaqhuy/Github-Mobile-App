package com.example.githubbrowser.homepage;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.githubbrowser.R;

import java.util.concurrent.atomic.AtomicBoolean;

public class ProjectActivity extends AppCompatActivity {

    private AtomicBoolean isfirstItem1 = new AtomicBoolean(true);
    private AtomicBoolean isfirstItem2 = new AtomicBoolean(true);
    private AtomicBoolean isfirstItem6 = new AtomicBoolean(true);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_project);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ImageButton searchButton = findViewById(R.id.search_button_project);
        ImageButton backButton = findViewById(R.id.backButton_project);
        TextView textView = findViewById(R.id.text_project);
        EditText editText = findViewById(R.id.edit_text_project);

        searchButton.setOnClickListener(view -> {
            Toast.makeText(getApplicationContext(),R.string.search,Toast.LENGTH_SHORT).show();
            editText.setVisibility(View.VISIBLE);
            textView.setVisibility(View.GONE);
            editText.getText();
        });
        backButton.setOnClickListener(view ->
        {
            Toast.makeText(getApplicationContext(), R.string.back, Toast.LENGTH_SHORT).show();
            onBackPressed();
        });
        Spinner spinner1 = findViewById(R.id.open_menu_project);
        Spinner spinner2 = findViewById(R.id.Created_menu_project);
        Spinner spinner6 = findViewById(R.id.Sort_menu_project);

        String[] items1 = {"All projects", "Created by me"};
        String[] items2 = {"Open", "Closed", "Template"};
        String[] items6 = {"Sort: Most recently viewed","Sort: Least recently viewed","Sort: Updated . Newest","Sort: Updated . Oldest","Sort: Created . Newest","Sort: Created . Oldest","Sort: Title . A-Z","Sort: Title .Z-A"};
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items1);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items2);
        ArrayAdapter<String> adapter6 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items6);

        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_item);
        adapter6.setDropDownViewResource(android.R.layout.simple_spinner_item);

        spinner1.setAdapter(adapter1);
        spinner2.setAdapter(adapter2);
        spinner6.setAdapter(adapter6);

        setupSpinnerListener(spinner1, items1,isfirstItem1);
        setupSpinnerListener(spinner2,items2,isfirstItem2);
        setupSpinnerListener(spinner6,items6,isfirstItem6);
    }
    public void setupSpinnerListener(Spinner spinner, String[] items,final AtomicBoolean isfirstselection) {
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (!isfirstselection.get()) {
                    String selectedItem = items[i];
                    Toast.makeText(getApplicationContext(), "Spinner: " + selectedItem, Toast.LENGTH_SHORT).show();
                } else {
                    isfirstselection.set(false);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}