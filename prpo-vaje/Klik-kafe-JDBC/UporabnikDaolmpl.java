
public class UporabnikDaolmpl implements BaseDao{
	public Connection getConnection() {
		Context initCtx = new InitialContext();
        DataSource ds = (DataSource) initCtx.lookup("java:/PostgresDS");
        Connection connection = ds.getConnection();
	}

	public Entiteta vrni(int id);

	public void vstavi(Entiteta ent);

	public void odstrani(int id);

	public void posodobi(Entiteta ent);

	public List<Entiteta> vrniVse();
}
