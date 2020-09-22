package modelos;


import utilities.Localizacao;

public class UnidadeEuclidiana extends UnidadeMonitoramento {
	
	public UnidadeEuclidiana(Integer id, boolean cameraVideo, boolean termometro, boolean medidorCO2,
			boolean medidorMetano, Localizacao localizacao) {
		super(id, cameraVideo, termometro, medidorCO2, medidorMetano, localizacao);
	}
	
	@Override	
	public Double calcularDistancia(Localizacao destino){
		
		double latitude;
		double longitude;
		
		latitude = this.getLocalizacao().getLatitude() - destino.getLatitude();
		longitude = this.getLocalizacao().getLongitude() - destino.getLongitude();
		
		return Math.sqrt(Math.pow(latitude, 2) + Math.pow(longitude, 2));		
	}
	
}
