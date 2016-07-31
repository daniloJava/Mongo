import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;


import com.mongodb.DBObject;

import br.com.mongo.JDBC.Dao;
import br.com.mongo.modelo.Endereco;
import br.com.mongo.modelo.Pessoa;
import br.com.mongo.modelo.PessoaConversor;


public class Teste {
	
	@Test
	public void testeComMongoAdiciona(){
		Endereco end = new Endereco("Rua dois", "carapicuba", "06315013");
		Pessoa pessoa = new Pessoa("001", "Osvaldo", 22, end);
		Pessoa pessoa2 = new Pessoa("002", "Juquinha", 22, end);
		Dao<Pessoa> dao = new Dao<Pessoa>(Pessoa.class);
		PessoaConversor convertPess = new PessoaConversor();
		List<DBObject> list = new ArrayList<DBObject>();
		Map<String, Object> pessoaMap = convertPess.converterToMap(pessoa);
		Map<String, Object> pessoaMap2 = convertPess.converterToMap(pessoa2);
		
		dao.gravar(pessoaMap);
		dao.remove(pessoaMap);
		dao.atualiza((Map<String, Object>) dao.findOne(pessoaMap), pessoaMap2);
		
		list = dao.recuperaTudo();
		for (DBObject dbObject : list) {
			System.out.println(dbObject);
		}
		
	}
	
}
