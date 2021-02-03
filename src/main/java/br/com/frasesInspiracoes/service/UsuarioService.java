package br.com.frasesInspiracoes.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.frasesInspiracoes.POJO.UsuarioPOJO;
import br.com.frasesInspiracoes.entity.Usuario;
import br.com.frasesInspiracoes.exception.ResourceNotFoundException;
import br.com.frasesInspiracoes.repository.FrasesRepository;
import br.com.frasesInspiracoes.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	private final UsuarioRepository usuarioRepository;
	private final FrasesRepository frasesRepository;
	
	@Autowired
	public UsuarioService(UsuarioRepository usuarioRepository, FrasesRepository frasesRepository) {
		this.usuarioRepository = usuarioRepository;
		this.frasesRepository = frasesRepository;
	}
	
	private UsuarioPOJO convertToUsuarioPOJO(Usuario usuario) {
		return UsuarioPOJO.create(usuario);
	}
	
	public UsuarioPOJO create(UsuarioPOJO usuarioPOJO) {
		UsuarioPOJO usurPOJO = UsuarioPOJO.create(usuarioRepository.save(Usuario.create(usuarioPOJO)));
		return usurPOJO;
	}
	
	
	public Page<UsuarioPOJO> findAll(Pageable pageable) {
		var page = usuarioRepository.findAll(pageable);
		return page.map(this::convertToUsuarioPOJO);
	}
	
	public UsuarioPOJO findById(Long id) {
		var entity = usuarioRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Não encontrado"));
		return UsuarioPOJO.create(entity);
	}
	
	public UsuarioPOJO update(UsuarioPOJO usuarioPOJO) {
		final Optional<Usuario> optionalUsuario = usuarioRepository.findById(usuarioPOJO.getId());
		if(!optionalUsuario.isPresent()) {
			new ResourceNotFoundException("Não encontrado");
		}
		return UsuarioPOJO.create(usuarioRepository.save(Usuario.create(usuarioPOJO)));
		
	}
	
	public void Delete(Long id) {
		var entity = usuarioRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Não Encontrado"));
		usuarioRepository.delete(entity);
	}
	
	

}
