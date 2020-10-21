package sistemaMonitoramento.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import sistemaMonitoramento.LOGICA.UnidadeEuclidiana;
import sistemaMonitoramento.LOGICA.UnidadeManhattan;
import sistemaMonitoramento.LOGICA.UnidadeMonitoramento;
import sistemaMonitoramento.UTILITIES.Localizacao;

public class UnidadeMonitoramentoSQL implements IUnidadeDAO {

	private static String SAVE_DATA = "INSERT INTO LISTA_UNIDADES(ID,LATITUDE,LONGITUDE,CAMERA_VIDEO,TERMOMETRO,MEDIDOR_CO2,MEDIDOR_METANO,MODELO_MAQUINA) \r\n"
			+ "Values (?,?,?,?,?,?,?,?)";
	private static String GET_UNIDADES = "SELECT * FROM LISTA_UNIDADES";
	private static String UPDATE_UNIDADES = "UPDATE LISTA_UNIDADES \r\n"
			+ "SET LATITUDE = ?, LONGITUDE = ? \r\n"
			+ "WHERE id = ?";

	public UnidadeMonitoramentoSQL() throws SQLException {
		DriverManager.registerDriver(new org.h2.Driver());
	}

	public Connection getConnection() throws SQLException {

		Connection connection = DriverManager.getConnection("jdbc:h2:~/dataMonitoramento");
		return connection;
	}

	@Override
	public List<UnidadeMonitoramento> getUnidades() throws SQLException {
		List<UnidadeMonitoramento> unidades = new ArrayList<UnidadeMonitoramento>();
		Statement ps = this.getConnection().createStatement();
		if(ps.execute(GET_UNIDADES)){
			ResultSet resultado = ps.getResultSet();
			while(resultado.next()) {
				int id = resultado.getInt("ID");
				int latitude = resultado.getInt("LATITUDE");
				int longitude = resultado.getInt("LONGITUDE");
				boolean cameraVideo = resultado.getBoolean("CAMERA_VIDEO");
				boolean termometro = resultado.getBoolean("TERMOMETRO");
				boolean medidorCO2 = resultado.getBoolean("MEDIDOR_CO2");
				boolean medidorMetano = resultado.getBoolean("MEDIDOR_METANO");
				int modeloMaquina = resultado.getInt("MODELO_MAQUINA");
				
				if(modeloMaquina == 1) {
					unidades.add(new UnidadeEuclidiana(id,cameraVideo,termometro,medidorCO2, medidorMetano, new Localizacao(latitude, longitude)));
				}else {
					unidades.add(new UnidadeManhattan(id,cameraVideo,termometro,medidorCO2, medidorMetano, new Localizacao(latitude, longitude)));
				}
			}
		}
				ps.close();
				return unidades;
	}


	@Override
	public void addUnidadeEuclidiana(Integer id, boolean cameraVideo, boolean termometro, boolean medidorCO2,
			boolean medidorMetano, Localizacao localizacao) throws SQLException {
			PreparedStatement ps = this.getConnection().prepareStatement(SAVE_DATA);
			ps.setInt(1, id);
			ps.setInt(2, localizacao.getLatitude());
			ps.setInt(3, localizacao.getLongitude());
			ps.setBoolean(4, cameraVideo);
			ps.setBoolean(5, termometro);
			ps.setBoolean(6, medidorCO2);
			ps.setBoolean(7, medidorCO2);
			ps.setInt(8, 1);
			ps.executeUpdate();
			ps.close();
	}

	@Override
	public void addUnidadeManhattan(Integer id, boolean cameraVideo, boolean termometro, boolean medidorCO2,
			boolean medidorMetano, Localizacao localizacao) throws SQLException {
			PreparedStatement ps = this.getConnection().prepareStatement(SAVE_DATA);
			ps.setInt(1, id);
			ps.setInt(2, localizacao.getLatitude());
			ps.setInt(3, localizacao.getLongitude());
			ps.setBoolean(4, cameraVideo);
			ps.setBoolean(5, termometro);
			ps.setBoolean(6, medidorCO2);
			ps.setBoolean(7, medidorCO2);
			ps.setInt(8, 2);
			ps.executeUpdate();
			ps.close();

	}

	@Override
	public void monitorar(Localizacao posicao, UnidadeMonitoramento unidade) throws SQLException {
			PreparedStatement ps = this.getConnection().prepareStatement(UPDATE_UNIDADES);
			ps.setInt(1, posicao.getLatitude());
			ps.setInt(2, posicao.getLongitude());
			ps.setInt(3, unidade.getId());
			ps.executeUpdate();
			ps.close();
	}

}
