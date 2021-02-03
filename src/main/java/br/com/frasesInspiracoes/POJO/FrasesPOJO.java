package br.com.frasesInspiracoes.POJO;

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


@JsonPropertyOrder({ "id", "autor", "frase"})
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class FrasesPOJO {
	

	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("autor")
	private String autor;
	
	@JsonProperty("frase")
	private String frase;
	

	
	public static FrasesPOJO create (Frases frases) {
		return new ModelMapper().map(frases, FrasesPOJO.class);
	}


}
