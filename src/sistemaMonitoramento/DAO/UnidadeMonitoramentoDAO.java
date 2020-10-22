package sistemaMonitoramento.DAO;

import java.util.ArrayList;
import java.util.List;

import sistemaMonitoramento.LOGICA.UnidadeEuclidiana;
import sistemaMonitoramento.LOGICA.UnidadeManhattan;
import sistemaMonitoramento.LOGICA.UnidadeMonitoramento;
import sistemaMonitoramento.UTILITIES.Localizacao;

public class UnidadeMonitoramentoDAO implements IUnidadeDAO {
	
	private List<UnidadeMonitoramento> unidades = new ArrayList<>();
	
	
	//return
	public List<UnidadeMonitoramento> getUnidades() {
		return unidades;
	}

	public void setUnidades(List<UnidadeMonitoramento> unidades) {
		this.unidades = unidades;
	}	
	
	
	//add
	public void addUnidadeEuclidiana(Integer id, boolean cameraVideo, boolean termometro, boolean medidorCO2,
			boolean medidorMetano, int latitude, int longitude) {
                        Localizacao localizacao = new Localizacao(latitude, longitude);
			UnidadeEuclidiana unidadeAux = new UnidadeEuclidiana(id, cameraVideo, termometro, medidorCO2, medidorMetano, localizacao);
			this.unidades.add(unidadeAux);
	}
	
	public void addUnidadeManhattan(Integer id, boolean cameraVideo, boolean termometro, boolean medidorCO2,
			boolean medidorMetano, int latitude, int longitude) {
                        Localizacao localizacao = new Localizacao(latitude, longitude);
			UnidadeManhattan unidadeAux = new UnidadeManhattan(id, cameraVideo, termometro, medidorCO2, medidorMetano, localizacao);
			this.unidades.add(unidadeAux);
	}

	//update
	
	public void atualizarPosicao(Localizacao posicao, UnidadeMonitoramento unidade) {
		 unidade.setLocalizacao(posicao);
	}
	

}
