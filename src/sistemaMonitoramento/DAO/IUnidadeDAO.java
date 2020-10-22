package sistemaMonitoramento.DAO;

import java.util.List;

import sistemaMonitoramento.LOGICA.UnidadeEuclidiana;
import sistemaMonitoramento.LOGICA.UnidadeManhattan;
import sistemaMonitoramento.LOGICA.UnidadeMonitoramento;
import sistemaMonitoramento.UTILITIES.Localizacao;

public interface IUnidadeDAO {
	
	//return
		public List<UnidadeMonitoramento> getUnidades() throws Exception;	
	
		
		
	//add
		public void addUnidadeEuclidiana(Integer id, boolean cameraVideo, boolean termometro, boolean medidorCO2,
				boolean medidorMetano, int latitude, int longitude) throws Exception;
		
		public void addUnidadeManhattan(Integer id, boolean cameraVideo, boolean termometro, boolean medidorCO2,
				boolean medidorMetano, int latitude, int longitude) throws Exception;
	//update
		
		public void atualizarPosicao(Localizacao posicao, UnidadeMonitoramento unidade) throws Exception;


}
