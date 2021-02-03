package br.com.frasesInspiracoes.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.frasesInspiracoes.POJO.FrasesPOJO;
import br.com.frasesInspiracoes.entity.Frases;
import br.com.frasesInspiracoes.exception.ResourceNotFoundException;
import br.com.frasesInspiracoes.repository.FrasesRepository;

@Service
public class FrasesService {
	
	private final FrasesRepository frasesRepository;

	
	@Autowired
	public FrasesService(FrasesRepository frasesRepository) {
		this.frasesRepository = frasesRepository;
	}
	
	private FrasesPOJO convertToFrasesPOJO(Frases frases ){
		return FrasesPOJO.create(frases);
	}
	
	public FrasesPOJO create (FrasesPOJO frasesPOJO) {
		FrasesPOJO frasPOJO = FrasesPOJO.create(frasesRepository.save(Frases.create(frasesPOJO)));
		return frasPOJO;		
	}
	
	public Page<FrasesPOJO> findAll(Pageable pageable){
		var page = frasesRepository.findAll(pageable);
		return page.map(this::convertToFrasesPOJO);
	}
	
	public FrasesPOJO findById(Long id) {
		var entity = frasesRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Não a frases com esse ID"));
		return FrasesPOJO.create(entity);				
	}
	
	public FrasesPOJO update(FrasesPOJO frasesPOJO) {
		final Optional<Frases> optionalFrases = frasesRepository.findById(frasesPOJO.getId());
		if(!optionalFrases.isPresent()) {
			new ResourceNotFoundException("Não encontrado");
		}
		return FrasesPOJO.create(frasesRepository.save(Frases.create(frasesPOJO)));
	}
	
	public void Delete (Long id) {
		var entity = frasesRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Não encontrado"));
		frasesRepository.delete(entity);
	}
	
	

}
