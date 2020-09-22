package utilities;

public class Localizacao {
	
	private Integer longitude;
	private Integer latitude;
	
	public Localizacao(Integer longitude, Integer latitude) {
		this.longitude = longitude;
		this.latitude = latitude;
	}
	
	public Integer getLongitude() {
		return longitude;
	}
	public void setLongitude(Integer longitude) {
		this.longitude = longitude;
	}
	public Integer getLatitude() {
		return latitude;
	}
	public void setLatitude(Integer latitude) {
		this.latitude = latitude;
	}

	@Override
	public String toString() {
		return "[longitude=" + longitude + ", latitude=" + latitude + "]";
	}
	
	
	
}
