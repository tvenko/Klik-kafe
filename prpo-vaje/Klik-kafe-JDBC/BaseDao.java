
public interface BaseDao {
	
	public Connection getConnection();

	public Entiteta vrni(int id);

	public void vstavi(Entiteta ent);

	public void odstrani(int id);

	public void posodobi(Entiteta ent);

	public List<Entiteta> vrniVse();
}
