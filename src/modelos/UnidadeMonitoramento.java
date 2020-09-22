package modelos;

import utilities.Localizacao;

public abstract class UnidadeMonitoramento {
	
	private Integer id;
	private boolean cameraVideo;
	private boolean	termometro;
	private boolean medidorCO2;
	private boolean medidorMetano;
	private Localizacao localizacao;
	
	public UnidadeMonitoramento() {		
	}
	
	public UnidadeMonitoramento(Integer id, boolean cameraVideo, boolean termometro, boolean medidorCO2,
			boolean medidorMetano, Localizacao localizacao) {
		this.id = id;
		this.cameraVideo = cameraVideo;
		this.termometro = termometro;
		this.medidorCO2 = medidorCO2;
		this.medidorMetano = medidorMetano;
		this.localizacao = localizacao;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isCameraVideo() {
		return cameraVideo;
	}

	public void setCameraVideo(boolean cameraVideo) {
		this.cameraVideo = cameraVideo;
	}

	public boolean isTermometro() {
		return termometro;
	}

	public void setTermometro(boolean termometro) {
		this.termometro = termometro;
	}

	public boolean isMedidorCO2() {
		return medidorCO2;
	}

	public void setMedidorCO2(boolean medidorCO2) {
		this.medidorCO2 = medidorCO2;
	}

	public boolean isMedidorMetano() {
		return medidorMetano;
	}

	public void setMedidorMetano(boolean medidorMetano) {
		this.medidorMetano = medidorMetano;
	}

	public Localizacao getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(Localizacao localizacao) {
		this.localizacao = localizacao;
	}

	public Integer getId() {
		return id;
	}
	
	
	public boolean hasConfigMin(boolean cameraVideo, boolean termometro, boolean medidorCO2,
								boolean medidorMetano) {
		if((this.cameraVideo == cameraVideo) && (this.termometro == termometro) && (this.medidorCO2 ==
			medidorCO2) && (this.medidorMetano == medidorMetano)) {
			return true;
		}else {
			return false;
		}
	}
	
	
	public boolean podeMover(Localizacao destino) {
		if(this.getLocalizacao() != null && destino != null) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean moverUnidade(Localizacao destino) {
		if(this.podeMover(destino)) {
			this.setLocalizacao(destino);
			return true;
		}else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "UnidadeMonitoramento [id=" + id + ", cameraVideo=" + cameraVideo + ", termometro=" + termometro
				+ ", medidorCO2=" + medidorCO2 + ", medidorMetano=" + medidorMetano + ", localizacao=" + localizacao
				+ "]";
	}
	
	public abstract Double calcularDistancia(Localizacao destino);
	
	

}
