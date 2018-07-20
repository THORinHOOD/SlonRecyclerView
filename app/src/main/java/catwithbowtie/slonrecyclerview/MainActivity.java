package catwithbowtie.slonrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Element> elements;
    private RecyclerView recycler;
    private ElementsAdapter adapter;

    private EditText editText;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        elements = new ArrayList<Element>();
        recycler = (RecyclerView) findViewById(R.id.list);
        editText = (EditText) findViewById(R.id.editText);
        btn = (Button) findViewById(R.id.add_btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Element el = new Element(elements.size(), editText.getText().toString());
                elements.add(el);
                adapter.notifyDataSetChanged();
            }
        });

        adapter = new ElementsAdapter(elements);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recycler.setLayoutManager(layoutManager);
        recycler.setItemAnimator(new DefaultItemAnimator());
        recycler.setAdapter(adapter);
    }
}
