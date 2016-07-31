package br.com.mongo.JDBC;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Dao<T> implements DaoInterface {

	private Class<T> persistentClass;
	private DBCollection dbCollection;
	
	/**COntrutor para inicializar o data Base 
	 * e a classe para persistir os dados
	 * 
	 * @param persistentClass
	 */
	public Dao(Class<T> persistentClass) {
		super();
		this.persistentClass = persistentClass;
		this.dbCollection = MongoConnection.getInstance().getDB().getCollection(persistentClass.getSimpleName());
	
	}
	
	/**Recupera a coleção
	 * 
	 * @return
	 */
	public DBCollection getDbCollection() {
        return dbCollection;
    }
	
	/**Grava no banco de dados atravez de um Mapa
	 * 
	 */
	@Override
	public void gravar(Map<String, Object> mapaEntidade) {
		
		//Cria um documento diretamente com todas os atributos
		BasicDBObject document = new BasicDBObject(mapaEntidade);
        
		dbCollection.insert(document);
        
		System.out.println("Gravado :> " + document);
	}
	
	/**Realiza um update
	 * 
	 */
	@Override
	public void atualiza(Map<String, Object> mapaQuery, Map<String, Object> mapaEntidade) {
		//Cria um documento com o que será substituido
		BasicDBObject query = new BasicDBObject(mapaQuery);
		
		//Cria um documento diretamente com todas os atributos
        BasicDBObject entity = new BasicDBObject(mapaEntidade);
        
        dbCollection.update(query, entity);
        
	}

	
	/**Metodo para remover um documento
	 * 
	 */
	@Override
	public void remove(Map<String, Object> mapaEntidade) {
		//Cria um documento com o que será removido
		BasicDBObject entity = new BasicDBObject(mapaEntidade);

       dbCollection.remove(entity);

	}
	
	/**Lista dodos os registros do banco
	 * 
	 */
	@Override
	public List<DBObject> recuperaTudo() {
		//Cria uma lista
		List<DBObject> list = new ArrayList<DBObject>();
		
		//procura todos os objetos da coleção
        DBCursor cursor = dbCollection.find();
        
        //caminha registro por registro e armazena na Lista
        while (cursor.hasNext()) {
            list.add(cursor.next());
        }

        return list;
	}
	
	/**Metodo que recupera por Id.
	 * 
	 */
	@Override
	public List<DBObject> recuperaPorID(Map<String, Object> idValor) {
		
		List<DBObject> list = new ArrayList<DBObject>();
		
        DBCursor cursor = dbCollection.find(new BasicDBObject(idValor));

        while (cursor.hasNext()) {
            list.add(cursor.next());
        }

        return list;
	}
	
	@Override
	public DBObject findOne(Map<String, Object> mapaEntidade) {
		BasicDBObject query = new BasicDBObject(mapaEntidade);

        return dbCollection.findOne(query);
	}
	
	

}
