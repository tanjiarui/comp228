package dao;

import model.Game;
import model.Player;
import model.PlayerAndGame;

import java.sql.Date;
import java.util.List;

public class test {
    public static void main(String[] args) {
//        GameDao gameDao = new GameDao();
//        Game game = new Game();
//        game.setGame_title("aaa");
//        gameDao.add(game);
//        game = gameDao.findByid(1);
//        System.out.println(game.getGame_title());


//        PlayerDao playerDao = new PlayerDao();
//        Player player = new Player();
//        player.setFirst_name("xxxx");
//        player.setLast_name("zz");
//        player.setPostal_code("1231");
//        player.setAddress("ssss");
//        player.setPhone_number("2313113");
//        player.setProvince("qweqwe");
//        playerDao.add(player);
//        playerDao.update(player);
//        player = playerDao.findByid(2);
//        System.out.println(player.getFirst_name());
//        System.out.println(gameDao.findAll().get(1).getGame_title());


        PlayerAndGameDao playerAndGameDao = new PlayerAndGameDao();
        PlayerAndGame playerAndGame = new PlayerAndGame();
        playerAndGame.setGame_id(1);
        playerAndGame.setPlayer_id(2);
        playerAndGame.setScore(90);
        java.util.Date now = new java.util.Date();
        Date date = new Date(now.getTime());
        playerAndGame.setPlaying_date(date);
        playerAndGameDao.add(playerAndGame);
    }
}
