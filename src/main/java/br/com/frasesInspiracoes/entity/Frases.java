package br.com.frasesInspiracoes.entity;

import java.io.Serializable;

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


import br.com.frasesInspiracoes.POJO.FrasesPOJO;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name = "TB_frases")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Frases implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6514400017843221994L;
	
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column (name = "autor", nullable = false, length = 30)
	private String autor;
	
	@Column( name ="frase", nullable = false, length = 100)
	private String frase;
	
	
	
	
	public static Frases create (FrasesPOJO frasesPOJO) {
		return new ModelMapper().map(frasesPOJO, Frases.class);
	}

	

}
