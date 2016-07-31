package br.com.mongo.modelo;

import java.util.HashMap;
import java.util.Map;
import com.mongodb.DBObject;

/**Metodos que utiliza a conversao da classe endereco
* pea um Obejto pessoa convere para um MAPA
* e pega uma MAPA para Objeto Pessoa
* 
*/
public class PessoaConversor {

	public Map<String, Object> converterToMap(Pessoa pessoa) {
		Map<String, Object> mapPessoa = new HashMap<String, Object>();
        mapPessoa.put("Nome", pessoa.getNome());
        mapPessoa.put("Id", pessoa.getId());
        mapPessoa.put("idade", pessoa.getIdade());
        mapPessoa.put("Endereco", 
                new EnderecoConversor().converterToMap(pessoa.getEnd())
        );

        return mapPessoa;
    }

    public Pessoa converterToPessoa(DBObject dbo) {
        Pessoa pessoa = new Pessoa();
        pessoa.setId((String) dbo.get("Id"));
        pessoa.setNome((String) dbo.get("Nome"));
        pessoa.setIdade((Integer) dbo.get("idade"));
        pessoa.setEnd(new EnderecoConversor().converterToEndereco(
                (HashMap<String, Object>) dbo.get("Endereco"))
        );

        return pessoa;
    }
	
	
	
}
