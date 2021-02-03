//package br.com.frasesInspiracoes.POJO;
//
//
//
//import org.modelmapper.ModelMapper;
//
//import com.fasterxml.jackson.annotation.JsonProperty;
//import com.fasterxml.jackson.annotation.JsonPropertyOrder;
//
//import br.com.frasesInspiracoes.entity.Usuario;
//import br.com.frasesInspiracoes.entity.UsuarioFrase;
//import lombok.AllArgsConstructor;
//import lombok.EqualsAndHashCode;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import lombok.ToString;
//
//
//@JsonPropertyOrder({ "id", "idfrase", "usuario" })
//@Getter
//@Setter
//@ToString
//@NoArgsConstructor
//@AllArgsConstructor
//@EqualsAndHashCode(callSuper = false)
//public class UsuarioFrasePOJO  {
//	
//	
//
//	@JsonProperty("id")
//	private Long id;
//	
//	@JsonProperty("idfrase")
//	private Integer idfrases;	
//
//	@JsonProperty("usuario")
//	private Usuario usuario;
//	
//	public static UsuarioFrasePOJO create(UsuarioFrase usuarioFrase) {
//		return new ModelMapper().map(usuarioFrase, UsuarioFrasePOJO.class);
//	}
//}
