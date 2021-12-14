package dao;

import model.Player;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PlayerDao {
        public void add(Player player) {

            Connection con = DBConn.conn();		//连接
            PreparedStatement pstmt = null;	//使用预编译语句
            ResultSet rs = null;	//获取的结果集
            try {
                String sql = "INSERT INTO player(first_name, last_name, address, postal_code, province, phone_number) VALUES(?,?,?,?,?,?)"; //设置的预编译语句格式
                pstmt = con.prepareStatement(sql);
//                pstmt.setInt(1, player.getPlayer_id());
                pstmt.setString(1, player.getFirst_name());
                pstmt.setString(2, player.getLast_name());
                pstmt.setString(3, player.getAddress());
                pstmt.setString(4,player.getPostal_code());
                pstmt.setString(5,player.getPhone_number());
                pstmt.setString(6,player.getProvince());
                pstmt.executeUpdate();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }finally {
                //关闭资源,倒关
                DBConn.close();

            }


        }

        public Player findByid(int id) {

            Connection con = DBConn.conn();
            PreparedStatement pstmt = null;
            ResultSet rs = null;
            try {
                String sql = "SELECT * FROM player WHERE player_id=?";
                pstmt = con.prepareStatement(sql);
                pstmt.setInt(1, id);

                rs = pstmt.executeQuery();
                if(rs == null) {
                    return null;
                }
                if(rs.next()) {
                    Player player = new Player();
                    player.setPlayer_id(rs.getInt("player_id"));
                    player.setFirst_name(rs.getString("first_name"));
                    player.setLast_name(rs.getString("last_name"));
                    player.setAddress(rs.getString("address"));
                    player.setPostal_code(rs.getString("postal_code"));
                    player.setPhone_number(rs.getString("phone_number"));
                    player.setProvince(rs.getString("province"));
                    return player;
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

    public List<Player> findAll() {
        List<Player> playerList = new ArrayList<>();
        Connection con = DBConn.conn();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM player";
            pstmt = con.prepareStatement(sql);


            rs = pstmt.executeQuery();

            while (rs.next()) {
                Player player = new Player();
                player.setPlayer_id(rs.getInt("player_id"));
                player.setFirst_name(rs.getString("first_name"));
                player.setLast_name(rs.getString("last_name"));
                player.setAddress(rs.getString("address"));
                player.setPostal_code(rs.getString("postal_code"));
                player.setPhone_number(rs.getString("phone_number"));
                player.setProvince(rs.getString("province"));
               playerList.add(player);
            }
            return playerList;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            //关闭资源,倒关
            DBConn.close();
        }
    }
        public boolean update(Player player){

            Connection con = DBConn.conn();		//连接
            PreparedStatement pstmt = null;	//使用预编译语句
            ResultSet rs = null;	//获取的结果集
            try {
                String sql = "update player SET first_name=?, last_name=?,address=?,postal_code=?,province=?,phone_number=? WHERE player_id=?"; //设置的预编译语句格式
                pstmt = con.prepareStatement(sql);
                pstmt.setString(1, player.getFirst_name());
                pstmt.setString(2, player.getLast_name());
                pstmt.setString(3, player.getAddress());
                pstmt.setString(4,player.getPostal_code());
                pstmt.setString(5,player.getPhone_number());
                pstmt.setString(6,player.getProvince());
                pstmt.setInt(7, player.getPlayer_id());
                pstmt.executeUpdate();
                return true;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }finally {
                //关闭资源,倒关
               DBConn.close();
            }
        }
}
