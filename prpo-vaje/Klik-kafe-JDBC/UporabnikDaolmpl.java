import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.resource.cci.ResultSet;

public class UporabnikDaolmpl implements BaseDao{
	
	public Connection getConnection() throws SQLException {
		
		Connection con = null;
		
		try{
			Context initCtx = new InitialContext();
            DataSource ds = (DataSource) initCtx.lookup("java:/PostgresDS");
            con = ds.getConnection();
		}catch(NamingException e){
			 System.out.println("JDBC vir ne obstaja!");
			 e.printStackTrace();
		}
		return con;
	}

	public Entiteta vrni(int id, Connection con) {
		PreparedStatement ps = null;
		try {
			String sql = "SELECT * FROM Uporabnik WHERE id = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			Entiteta ent = new Entiteta;
			if(rs.next()) {
				ent.setId(rs.getInt("id"));
				ent.setName(rs.getString("name"));
				ent.setSurname(rs.getString("surname"));
				ent.setEmail(rs.getString("email"));
				ent.setLatitude(rs.getDouble("latitude"));
				ent.setLongitude(rs.getDouble("longitude"));
				ent.setUsername(rs.getString("username"));
			}
			return ent
		} catch (SQLException e) {
			System.out.println(e.printStackTrace(););	
		}
	}

	public void vstavi(Entiteta ent) {
		PreparedStatement ps = null;
		try {
			String sql = "INSERT into Uporabnik (id, name, surname, email, latitude, longitude, username)"
					+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
			ps = con.prepareStatement(sql);
			ps.setInt(1, ent.getId());
			ps.setString(2, ent.getName());
			ps.setString(3, ent.getSurname());
			ps.setString(4, ent.getEmail());
			ps.setDouble(5, ent.getLatitude());
			ps.setDouble(6, ent.getLongitude);
			ps.setString(7, ent.getUsername());
			}	
		} catch (SQLException e) {
			System.out.println(e.printStackTrace(););
			
		}
	}

	public void odstrani(int id) {
		PreparedStatement ps = null;
		try {
			String sql = "DELETE * FROM Uporabnik WHERE id = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);			
		} catch (SQLException e) {
			System.out.println(e.printStackTrace(););
			
		}
	}

	public void posodobi(Entiteta ent) {
		PreparedStatement ps = null;
		try {
			String sql = "UPDATE Uporabnik SET name=? WHERE id=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, ent.getName());
			ps.setInt(2, ent.getId());
		} catch (SQLException e) {
			System.out.println(e.printStackTrace(););
		}
	}

	public List<Entiteta> vrniVse() {
		PreparedStatement ps = null;
		try {
			String sql = "SELECT * FROM Uporabnik";
			ps = con.prepareStatement(sql);
			
		} catch (SQLException e) {
			System.out.println(e.printStackTrace(););
		}
	}
}
