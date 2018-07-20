package catwithbowtie.slonrecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ElementsAdapter extends RecyclerView.Adapter<ElementsAdapter.ElementHolder> {

    private ArrayList<Element> elements;

    public class ElementHolder extends RecyclerView.ViewHolder {
        public TextView title, content;
        public Button button;

        public ElementHolder(final View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            content = (TextView) itemView.findViewById(R.id.content);
            button = (Button) itemView.findViewById(R.id.button);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(itemView.getContext(), title.getText().toString(), Toast.LENGTH_LONG).show();
                }
            });
        }
    }

    public ElementsAdapter(ArrayList<Element> elements) {
        this.elements = elements;
    }

    @Override
    public ElementHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.element, parent, false);
        return new ElementHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ElementHolder holder, int position) {
        Element el = elements.get(position);
        holder.title.setText("Card : " + el.getId());
        holder.content.setText(el.getContent());
    }

    @Override
    public int getItemCount() {
        return elements.size();
    }
}
