import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;
import javax.sql.DataSource;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.InitialContext;


public class UporabnikDaolmpl implements BaseDao{
	
	public Connection getConnection() throws SQLException {
		Connection con = null;
		try{
			Context initCtx = new InitialContext();
			//Context envCtx = (Context)initCtx.lookup("java:/comp/env/");
            DataSource ds = (DataSource)initCtx.lookup("java:/PostgresDS");
            con = ds.getConnection();
		} catch(NamingException e) {
			 System.out.println("JDBC vir ne obstaja!");
			 e.printStackTrace();
		}
		return con;
	}

	public Uporabnik vrni(int id, Connection con) {
		PreparedStatement ps = null;
		Uporabnik usr = new Uporabnik();
		try {
			String sql = "SELECT * FROM Public.\"Uporabnik\" WHERE id = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				usr.set(rs.getInt("id"));
				usr.setName(rs.getString("name"));
				usr.setSurname(rs.getString("surname"));
 				usr.setEmail(rs.getString("email"));
 				usr.setLatitude(rs.getDouble("latitude"));
 				usr.setLongitude(rs.getDouble("longitude"));
 				usr.setUsername(rs.getString("username"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return usr;
	}
	
	public int vstavi(Uporabink user, Connection con) {
		PreparedStatement ps = null;
		int rows_affected = -1;
		try {
			String sql = "INSERT INTO Public.\"Uporabnik\" (id, name, surname, email, latitude, longitude, username)"
					+ " VALUES (?, ?, ?, ?, ?, ?, ?)";
			ps = con.prepareStatement(sql);
			ps.setInt(1, user.get());
			ps.setString(2, user.getName());
			ps.setString(3, user.getSurname());
			ps.setString(4, user.getEmail());
			ps.setDouble(5, user.getLat());
			ps.setDouble(6, user.setLong());
			ps.setString(7, user.getUsername());
			
			rows_affected = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rows_affected;
	}
	
	public int odstrani(Uporabnik user, Conncetion con) {
		PreparedStatement ps = null;
		int rows_affected = -1;
		try {
			String sql = "DELETE FROM Public.\"Uporabnik\" WHERE id = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, user.get());

			rows_affected = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rows_affected;
	}
	
	public ArrayList<Uporabnik> vrniVse(Connection con) {
		PreparedStatement ps = null;
		ArrayList<Uporabnik> user_list = new ArrayList<Uporabnik>();
		try {
			String sql = "SELECT * FROM Public.\"Uporabnik\"";
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			String name, surname, email, username;
			double lat, longit;
			int id;
			while (rs.next()) {
				id = rs.getInt("id");
				name = rs.getString("name");
				surname = rs.getString("surname");
 				email = rs.getString("email");
				lat = rs.getDouble("latitude");
 				longit = rs.getDouble("longitude");
 				username = rs.getString("username");
				user_list.add(new Uporabnik(id, username, name, surname, email, lat, longit));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return user_list;
	}
}
