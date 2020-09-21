package modelos;

import utilities.Localizacao;

public class UnidadeManhattan extends UnidadeMonitoramento {

	public Double calcularDistancia(Localizacao destino) {

		double latitude;
		double longitude;

		latitude = this.getLocalizacao().getLatitude() - destino.getLatitude();
		longitude = this.getLocalizacao().getLongitude() - destino.getLongitude();

		return Math.abs(latitude) + Math.abs(longitude);

	}

}
