package sistemaMonitoramento.LOGICA;

import java.util.Comparator;

import sistemaMonitoramento.UTILITIES.Localizacao;

public class OrdenarUnidades implements Comparator<UnidadeMonitoramento>{
	
	private Localizacao destino;
	private UnidadeMonitoramento unidade;

	public OrdenarUnidades(Localizacao destino, UnidadeMonitoramento unidade) {
		this.destino = destino;
		this.unidade = unidade;
	}

	public Localizacao getDestino() {
		return destino;
	}

	public void setDestino(Localizacao destino) {
		this.destino = destino;
	}

	public UnidadeMonitoramento getUnidade() {
		return unidade;
	}

	public void setUnidade(UnidadeMonitoramento unidade) {
		this.unidade = unidade;
	}

	public int compare(UnidadeMonitoramento o1, UnidadeMonitoramento o2) {
		
			if(o1.calcularDistancia(this.destino) > o2.calcularDistancia(this.destino)) {
				return 1;
			}else if(o1.calcularDistancia(this.destino) < o2.calcularDistancia(this.destino)){
				return -1;				
			}else {
				return 0;
			}
	}
	
}
