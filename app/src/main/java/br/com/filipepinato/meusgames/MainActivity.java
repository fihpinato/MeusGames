package br.com.filipepinato.meusgames;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.github.clans.fab.FloatingActionButton;

import java.util.ArrayList;

import br.com.filipepinato.meusgames.adapter.GameAdapter;
import br.com.filipepinato.meusgames.dao.GameDAO;
import br.com.filipepinato.meusgames.model.Game;
import br.com.filipepinato.meusgames.model.Genero;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvMeusGames;
    private GameAdapter mAdapter;
    private FloatingActionButton fMenu;

    private Genero generoSelecionado;

    private GameDAO gameDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fMenu = (FloatingActionButton) findViewById(R.id.fMenu);
        gameDao = new GameDAO();
        inicializaLista ();
        carregaMeusGames();
    }

    private void inicializaLista() {
        rvMeusGames = (RecyclerView) findViewById(R.id.rvMeusGames);
        mAdapter = new GameAdapter(this, new ArrayList<Game>());
        rvMeusGames.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rvMeusGames.setItemAnimator(new DefaultItemAnimator());
        rvMeusGames.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        rvMeusGames.setAdapter(mAdapter);
    }

    private void carregaMeusGames() {
        mAdapter.add(gameDao.findAll());
        mAdapter.notifyDataSetChanged();
    }
}
