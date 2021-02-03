package br.com.frasesInspiracoes.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;
import org.springframework.format.annotation.DateTimeFormat;

import br.com.frasesInspiracoes.POJO.UsuarioPOJO;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "TB_usuario")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Usuario implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1431293508388487148L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome" )
	private String nome;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "email")
	private String email;	
	
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	@Column(name = "data", nullable = false)
	private Date data;		

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Frases> frase = new ArrayList<Frases>();
	
	 
	
	public static Usuario create(UsuarioPOJO usuarioPOJO) {
		return new ModelMapper().map(usuarioPOJO, Usuario.class);
	}
	

}
