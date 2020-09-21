package modelos;

import utilities.Localizacao;

public class UnidadeEuclidiana extends UnidadeMonitoramento {
	
	
	//calcular distancia
	
	public Double calcularDistancia(Localizacao destino){
		
		double latitude;
		double longitude;
		
		latitude = this.getLocalizacao().getLatitude() - destino.getLatitude();
		longitude = this.getLocalizacao().getLongitude() - destino.getLongitude();
		
		return Math.sqrt(Math.pow(latitude, 2) + Math.pow(longitude, 2));
		
		
		
	}

}
