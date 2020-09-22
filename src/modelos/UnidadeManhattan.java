package modelos;

import utilities.Localizacao;

public class UnidadeManhattan extends UnidadeMonitoramento {
	
	public UnidadeManhattan(Integer id, boolean cameraVideo, boolean termometro, boolean medidorCO2,
			boolean medidorMetano, Localizacao localizacao) {
		super(id, cameraVideo, termometro, medidorCO2, medidorMetano, localizacao);
	}
	
	@Override
	public Double calcularDistancia(Localizacao destino) {

		double latitude;
		double longitude;

		latitude = this.getLocalizacao().getLatitude() - destino.getLatitude();
		longitude = this.getLocalizacao().getLongitude() - destino.getLongitude();

		return Math.abs(latitude) + Math.abs(longitude);

	}

}
