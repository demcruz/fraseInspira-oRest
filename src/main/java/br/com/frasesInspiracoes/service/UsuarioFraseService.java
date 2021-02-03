//package br.com.frasesInspiracoes.service;
//
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Service;
//
//import br.com.frasesInspiracoes.POJO.UsuarioFrasePOJO;
//import br.com.frasesInspiracoes.entity.UsuarioFrase;
//import br.com.frasesInspiracoes.exception.ResourceNotFoundException;
//import br.com.frasesInspiracoes.repository.UsuarioFraseRepository;
//
//@Service
//public class UsuarioFraseService {
//	
//	private final UsuarioFraseRepository usuarioFraseRepository;
//	
//	@Autowired
//	public UsuarioFraseService(UsuarioFraseRepository usuarioFraseRepository) {
//		this.usuarioFraseRepository = usuarioFraseRepository;
//	}
//	
//	private UsuarioFrasePOJO convertToUsuarioFrasePOJO(UsuarioFrase usuarioFrase) {
//		return UsuarioFrasePOJO.create(usuarioFrase);
//	}
//	
//	public UsuarioFrasePOJO create(UsuarioFrasePOJO usuarioFrasePOJO) {
//		UsuarioFrasePOJO usurFrase = UsuarioFrasePOJO.create(usuarioFraseRepository.save(UsuarioFrase.create(usuarioFrasePOJO)));
//		return usurFrase;
//	}
//	
//	public Page<UsuarioFrasePOJO> findAll(Pageable pageable){
//		var page = usuarioFraseRepository.findAll(pageable);
//		return page.map(this::convertToUsuarioFrasePOJO);
//	}
//	
//	public UsuarioFrasePOJO findById(Long id) {
//		var entity = usuarioFraseRepository.findById(id)
//			.orElseThrow(() -> new ResourceNotFoundException("Não Encontrado"));
//			return UsuarioFrasePOJO.create(entity);
//		
//	}
//	
//	public UsuarioFrasePOJO update(UsuarioFrasePOJO usuarioFrasePOJO) {
//		final Optional<UsuarioFrase> optionalUsuarioFrase = usuarioFraseRepository.findById(usuarioFrasePOJO.getId());
//		if(!optionalUsuarioFrase.isPresent()) {
//			new ResourceNotFoundException("Não encontrado");
//		}
//		return UsuarioFrasePOJO.create(usuarioFraseRepository.save(UsuarioFrase.create(usuarioFrasePOJO)));
//	}
//	
//	public void Delete(Long id) {
//		var entity = usuarioFraseRepository.findById(id)
//				.orElseThrow(() -> new ResourceNotFoundException("Não Encontrado"));
//		usuarioFraseRepository.delete(entity);
//	}
//
//}
