package br.com.mongo.modelo;

import java.util.HashMap;
import java.util.Map;

/**Metodos que utiliza a conversao da classe endereco
 * pea um Obejto Endereco convere para um MAPA
 * e pega uma MAPA para Objeto Endereco
 * 
 * @author Danilo Silva
 *
 */
public class EnderecoConversor {

	public Map<String, Object> converterToMap(Endereco end) {
        Map<String, Object> mapPhone = new HashMap<String, Object>();
        mapPhone.put("Cidade", end.getCidade());
        mapPhone.put("Cep", end.getCep());
        mapPhone.put("Rua", end.getRua());

        return mapPhone;
    }

    public Endereco converterToEndereco(HashMap<String, Object> hashMap) {
        Endereco end = new Endereco();
        end.setRua((String) hashMap.get("Rua"));
        end.setCep((String) hashMap.get("Cep"));
        end.setCidade((String) hashMap.get("Cidade"));
        
        return end;
    }
	
}
