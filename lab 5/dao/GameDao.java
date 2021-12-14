package dao;


import model.Game;
import model.Player;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GameDao {
    public void add(Game game) {

        Connection con = DBConn.conn();		//连接
        PreparedStatement pstmt = null;	//使用预编译语句
        ResultSet rs = null;	//获取的结果集
        try {

            String sql = "INSERT INTO game(game_title) VALUES(?)"; //设置的预编译语句格式
            pstmt = con.prepareStatement(sql);
//            pstmt.setInt(1, game.getGame_id());
            pstmt.setString(1, game.getGame_title());

            pstmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            //关闭资源,倒关
           DBConn.close();
        }


    }

    public Game findByid(int id) {

        Connection con = DBConn.conn();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {

            String sql = "SELECT * FROM game WHERE game_id=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, id);

            rs = pstmt.executeQuery();
            if(rs == null) {
                return null;
            }
            if(rs.next()) {
                Game game = new Game();
                game.setGame_id(rs.getInt(1));
                game.setGame_title(rs.getString(2));
                return game;
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

    public List<Game> findAll(){
        List<Game> gameArrayList = new ArrayList<>();
        Connection con = DBConn.conn();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {

            String sql = "SELECT * FROM game ";
            pstmt = con.prepareStatement(sql);

            rs = pstmt.executeQuery();
            if(rs == null) {
                return null;
            }
            while (rs.next()) {
                Game game = new Game();
                game.setGame_id(rs.getInt(1));
                game.setGame_title(rs.getString(2));
                gameArrayList.add(game);
            }
            return gameArrayList;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            //关闭资源,倒关
            DBConn.close();
        }
    }
}
