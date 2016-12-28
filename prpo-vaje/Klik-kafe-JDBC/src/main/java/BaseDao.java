import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


public interface BaseDao {
	
	public Connection getConnection() throws SQLException;

	public UporabnikJDBC vrni(int id, Connection con);

	public void vstavi(EntitetaJDBC ent);

	public void odstrani(int id);

	public void posodobi(EntitetaJDBC ent);

	public List<EntitetaJDBC> vrniVse();
}
