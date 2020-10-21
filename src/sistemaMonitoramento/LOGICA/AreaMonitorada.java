package sistemaMonitoramento.LOGICA;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import sistemaMonitoramento.DAO.IUnidadeDAO;
import sistemaMonitoramento.DAO.UnidadeMonitoramentoDAO;
import sistemaMonitoramento.DAO.UnidadeMonitoramentoSQL;
import sistemaMonitoramento.UTILITIES.Localizacao;

public class AreaMonitorada {

	private Integer id;
	private String name;
	private IUnidadeDAO unidade;


	public AreaMonitorada(int id, String name) throws SQLException {
		this.id = id;
		this.name = name;
		unidade = new UnidadeMonitoramentoSQL();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "areaMonitorada ID = " + id + " name = " + name;
	}

	public void validarUnidades(Localizacao destinoFinal, boolean cameraVideo, boolean termometro, boolean medidorCO2,
			boolean medidorMetano) throws Exception {
		List<UnidadeMonitoramento> listaAuxiliar = new ArrayList<UnidadeMonitoramento>();
		for (UnidadeMonitoramento id : this.unidade.getUnidades()) {
			if (id.hasConfigMin(cameraVideo, termometro, medidorCO2, medidorMetano)) {
				listaAuxiliar.add(id);
			}
		}
		unidadeProxima(listaAuxiliar, destinoFinal);
	}

	public void unidadeProxima(List<UnidadeMonitoramento> listaAuxiliar, Localizacao destinoFinal) throws Exception {

		Collections.sort(listaAuxiliar, new OrdenarUnidades(destinoFinal, listaAuxiliar.get(0)));
		this.unidade.monitorar(destinoFinal, listaAuxiliar.get(0));
	}
	
	public void addUnidadeEuclidiana(Integer id, boolean cameraVideo, boolean termometro, boolean medidorCO2,
			boolean medidorMetano, Localizacao localizacao) throws Exception {
			this.unidade.addUnidadeEuclidiana(id, cameraVideo, termometro, medidorCO2, medidorMetano, localizacao);

	}
	
	public void addUnidadeManhattan(Integer id, boolean cameraVideo, boolean termometro, boolean medidorCO2,
			boolean medidorMetano, Localizacao localizacao) throws Exception {
			this.unidade.addUnidadeManhattan(id, cameraVideo, termometro, medidorCO2, medidorMetano, localizacao);
	}
	
	public List<UnidadeMonitoramento> getUnidades() throws Exception {
		return unidade.getUnidades();
	}


}
