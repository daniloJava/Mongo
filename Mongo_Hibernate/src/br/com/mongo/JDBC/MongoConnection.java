package br.com.mongo.JDBC;

import com.mongodb.DB;
import com.mongodb.Mongo;



/**Utilizando o padrão Singleton, só pra deixar padão que 
 * a classe não seja herdada e o objeto criado seja pelo metodo statico.
 * é padrão.!
 * 
 * @author tapower
 *
 */
public class MongoConnection {

    private static final String HOST = "localhost";
    private static final int PORTA = 27017;
    private static final String NOME_DO_BANCO = "testemongodb";

    private static MongoConnection uniConection;

    private Mongo mongo;
    private DB db;

    private MongoConnection() {
        //construtor privado
    }

    /**Garante que sempre terá uma instancia criada.
     * 
     * @return MongoConnection - uma unica conexão. 
     */
    public static synchronized MongoConnection getInstance() {
        if (uniConection == null) {
        	uniConection = new MongoConnection();
        }
        return uniConection;
    }

    /**Vai retornaar sempre um objeto com a conexão do data base
     * do mongo, caso ele tambem não existe, ele irá criar um tambem
     * 
     * @return DB - data Base 
     */
    public DB getDB() {
        if (mongo == null) {
            mongo = new Mongo(HOST, PORTA);
			db = mongo.getDB(NOME_DO_BANCO);
        }
        return db;
    }
}