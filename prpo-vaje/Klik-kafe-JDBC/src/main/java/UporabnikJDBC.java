
public class UporabnikJDBC extends EntitetaJDBC {
	private String username;
	private String name;
	private String surname;
	private double latitude;
	private double longitude;
	private String email;
	
	public UporabnikJDBC() {
		this.name = null;
	}
	
	//Constructor for listing everything in UporabnikDaolmpl
	public UporabnikJDBC(int new_id, String new_username, String new_name, String new_surname, String new_email, double new_latitude, double new_long) {
		this.setId(new_id);
		this.username = new_username;
		this.name = new_name;
		this.surname = new_surname;
		this.email = new_email;
		this.latitude = new_latitude;
		this.longitude = new_long;
	}
	
	//GETTER methods
	public String getAll() {
		return this.username + " " + this.name + " " + this.surname + " " + this.email;
	}
	
	/**
	 * Returns the username of Uporabnik
	 * @return String
	 */
	public String getUsername() {
		return this.username;
	}
	
	/**
	 * Returns the name of Uporabnik
	 * @return String
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Returns the surname of Uporabnik
	 * @return String
	 */
	public String getSurname(){
		return this.surname;
	}
	
	/**
	 * Returns the latitudeitude of Uporabnik
	 * @return float
	 */
	public double getLatitude() {
		return this.latitude;
	}
	
	/**
	 * Returns the longtitude of Uporabnik
	 * @return float
	 */
	public double getLongitude() {
		return this.longitude;
	}
	
	/**
	 * Returns the email of Uporabnik
	 * @return String
	 */
	public String getEmail() {
		return this.email;
	}
	
	
	//SETTER methods
	/**
	 * Set the username of uporabnik
	 * @param new_username the new name for Uporanik
	 */
	public void setUsername(String new_username) {
		this.username = new_username;
	}
	
	/**
	 * Set the name of Uporabnik
	 * @param new_name the new name for Uporabnik
	 */
	public void setName(String new_name) {
		this.name = new_name;
	}
	
	/**
	 * Set the surname of Uporabnik
	 * @param new_surname	new surname for Uporabnik
	 */
	public void setSurname(String new_surname) {
		this.surname = new_surname;
	}
	
	/**
	 * Set the latitudeitude of Uporabnik
	 * @param new_latitude	the new latitudeitude for Uporabnik
	 */
	public void setLatitude(double new_latitude) {
		this.latitude = new_latitude;
	}
	
	/**
	 * Set the longtitude of Uporabnik
	 * @param new_long	the new longtitude for Uporabnik
	 */
	public void setLongitude(double new_long) {
		this.longitude = new_long;
	}
	
	/**
	 * Set the email of Uporabnik
	 * @param new_email	the new email for Uporabnik
	 */
	public void setEmail(String new_email) {
		this.email = new_email;
	}
}
