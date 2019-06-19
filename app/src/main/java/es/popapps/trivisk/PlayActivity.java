package es.popapps.trivisk;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PlayActivity extends AppCompatActivity {

    RecyclerView rvGames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        rvGames = findViewById(R.id.rvGames);

        rvGames.setHasFixedSize(true);

        // use a linear layout manager
        rvGames.setLayoutManager(new LinearLayoutManager(this));

        // specify an adapter with the list to show
        GamesAdapter mAdapter = new GamesAdapter(getData());
        rvGames.setAdapter(mAdapter);

    }

    private List<GamesModel> getData(){
        GamesModel game1 = new GamesModel();
        game1.setGameName("Partida Animales");

        GamesModel game2 = new GamesModel();
        game2.setGameName("Partida Arte");

        GamesModel game3 = new GamesModel();
        game3.setGameName("Partida Coches");

        GamesModel game4 = new GamesModel();
        game4.setGameName("Partida Series");

        List<GamesModel> listaPartidas = new ArrayList<>();
        listaPartidas.add(game1);
        listaPartidas.add(game2);
        listaPartidas.add(game3);
        listaPartidas.add(game4);

        return listaPartidas;
    }


}
