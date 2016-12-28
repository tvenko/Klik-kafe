
public abstract class EntitetaJDBC implements java.io.Serializable {
	private int id;
	
	/**
	 * Returns the id from the db object Entiteta
	 * @return id	the id from Entiteta
	 */
	public int getId() {
		return this.id;
	}
	
	/**
	 * Updates the id from Entiteta to the new_id specified
	 * @param new_id	the new id for Entiteta
	 */
	public void setId(int new_id) {
		this.id = new_id;
	}
	
}
