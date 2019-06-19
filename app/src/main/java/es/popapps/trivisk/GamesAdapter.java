package es.popapps.trivisk;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class GamesAdapter extends RecyclerView.Adapter<GamesAdapter.MyGameRow> {

    private List<GamesModel> userModelList;

    public GamesAdapter(List<GamesModel> gamesModelList) {  // Constructor
        this.userModelList = gamesModelList;
    }

    @Override
    public MyGameRow onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.game_list_row, parent, false);
        MyGameRow viewHolder = new MyGameRow(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyGameRow holder, int position) {  // Pinta celda
        String incomingTitle = userModelList.get(position).getGameName();  // Obtengo el String que quiero pintar en la celda
        holder.name.setText(incomingTitle);
    }

    @Override
    public int getItemCount() {  // Tamaño de la Lista (RecyclerView)
        return userModelList.size();
    }

    static class MyGameRow extends RecyclerView.ViewHolder {  // Crea mi vista celda, la cual tiene un TextView
        private TextView name;

        MyGameRow(View v) {
            super(v);
            name = v.findViewById(R.id.tvTitle);
        }
    }

}
