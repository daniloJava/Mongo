package br.com.mongo.JDBC;

import java.util.List;
import java.util.Map;

import com.mongodb.DBObject;

/**Interface para o Dao
 * 
 * 
 * @author tapower
 *
 */
public interface DaoInterface {

	void gravar(Map<String, Object> mapaEntidade);

    void atualiza(Map<String, Object> mapaQuery, Map<String, Object> mapaEntidade);

    void remove(Map<String, Object> mapaEntidade);

    List<DBObject> recuperaTudo();

    List<DBObject> recuperaPorID(Map<String, Object> idValor);

    DBObject findOne(Map<String, Object> mapaEntidade);
	
}
