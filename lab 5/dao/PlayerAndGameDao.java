package dao;

import model.Player;
import model.PlayerAndGame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PlayerAndGameDao {
    public void add(PlayerAndGame playerAndGame) {

        Connection con = DBConn.conn();		//连接
        PreparedStatement pstmt = null;	//使用预编译语句
        ResultSet rs = null;	//获取的结果集
        try {

            String sql = "INSERT INTO playerandgame(`game_id`, `player_id`, `playing_date`, `score`)  VALUES(?,?,?,?)"; //设置的预编译语句格式
            pstmt = con.prepareStatement(sql);
//            pstmt.setInt(1, playerAndGame.getPlayer_game_id());
            pstmt.setInt(1, playerAndGame.getGame_id());
            pstmt.setInt(2, playerAndGame.getPlayer_id());
            pstmt.setDate(3, playerAndGame.getPlaying_date());
            pstmt.setInt(4, playerAndGame.getScore());
            pstmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            //关闭资源,倒关
           DBConn.close();
        }


    }

    public PlayerAndGame findByid(int id) {

        Connection con = DBConn.conn();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {


            String sql = "SELECT * FROM playerandgame WHERE player_game_id=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, id);

            rs = pstmt.executeQuery();
            if(rs == null) {
                return null;
            }
            if(rs.next()) {
                PlayerAndGame playerAndGame = new PlayerAndGame();
                playerAndGame.setPlayer_game_id(rs.getInt(1));
                playerAndGame.setGame_id(rs.getInt(2));
                playerAndGame.setPlaying_date(rs.getDate(3));
                playerAndGame.setScore(rs.getInt(4));
                return playerAndGame;
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            //关闭资源,倒关
            DBConn.close();
        }
    }

    public List<PlayerAndGame> findAll() {

        List<PlayerAndGame> playerAndGameList = new ArrayList<>();
        Connection con = DBConn.conn();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {


            String sql = "SELECT * FROM playerandgame";
            pstmt = con.prepareStatement(sql);


            rs = pstmt.executeQuery();
            if(rs == null) {
                return null;
            }
            if(rs.next()) {
                PlayerAndGame playerAndGame = new PlayerAndGame();
                playerAndGame.setPlayer_game_id(rs.getInt(1));
                playerAndGame.setGame_id(rs.getInt(2));
                playerAndGame.setPlayer_id(rs.getInt(3));
                playerAndGame.setPlaying_date(rs.getDate(4));
                playerAndGame.setScore(rs.getInt(5));
                playerAndGameList.add(playerAndGame);
            }
            return playerAndGameList;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            //关闭资源,倒关
            DBConn.close();
        }
    }
}
