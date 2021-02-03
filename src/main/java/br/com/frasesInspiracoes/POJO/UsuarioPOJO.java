package br.com.frasesInspiracoes.POJO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.modelmapper.ModelMapper;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import br.com.frasesInspiracoes.entity.Frases;
import br.com.frasesInspiracoes.entity.Usuario;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@JsonPropertyOrder({ "id", "nome", "password", "email", "frases", "data" })
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioPOJO  {
	

	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("nome")
	private String nome;
	
	@JsonProperty("password")
	private String password;
	
	@JsonProperty("email")
	private String email;
	
	@JsonProperty("frases")
	private List<FrasesPOJO> frase = new ArrayList<FrasesPOJO>();
	
	@JsonProperty("data")
	private Date data;
	
	public static UsuarioPOJO create (Usuario usuario) {
		return new ModelMapper().map(usuario, UsuarioPOJO.class);
	}

}
