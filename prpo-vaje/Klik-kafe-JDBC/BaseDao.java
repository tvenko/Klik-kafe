import java.sql.Connection;
import java.sql.SQLException;

public interface BaseDao {
	
	public Connection getConnection() throws SQLException;

	public Uporabnik vrni(int id, Connection con);

	public void vstavi(Entiteta ent);

	public void odstrani(int id);

	public void posodobi(Entiteta ent);

	public List<Entiteta> vrniVse();
}
