package br.com.filipepinato.meusgames.dao;

import com.activeandroid.query.Select;

import java.util.List;

import br.com.filipepinato.meusgames.models.Game;

public class GameDAO {
    public List<Game> findAll(){
        return new Select()
                .from(Game.class)
                .orderBy("titulo ASC")
                .execute();
    }
}
