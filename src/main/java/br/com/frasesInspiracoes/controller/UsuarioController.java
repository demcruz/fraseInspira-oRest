package br.com.frasesInspiracoes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.frasesInspiracoes.POJO.UsuarioPOJO;
import br.com.frasesInspiracoes.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	private final UsuarioService usuarioService;

	@Autowired
	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	@PostMapping(produces = { "application/json", "application/xml", "application/x-yaml" }, consumes = {
			"application/json", "application/xml", "application/x-yaml" })
	public UsuarioPOJO create(@RequestBody UsuarioPOJO usuarioPOJO) {
		UsuarioPOJO usurPOJO = usuarioService.create(usuarioPOJO);
		return usurPOJO;
	}

	@GetMapping(produces = { "application/json", "application/xml", "application/x-yaml" })
	public ResponseEntity<?> findAll(@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "limit", defaultValue = "12") int limit,
			@RequestParam(value = "direction", defaultValue = "asc") String direction) {
		var sortDirection = "desc".equalsIgnoreCase(direction) ? Direction.DESC : Direction.ASC;

		Pageable pageable = PageRequest.of(page, limit, Sort.by(sortDirection, "nome"));
		
		Page<UsuarioPOJO> usuarioPOJO = usuarioService.findAll(pageable);
		
		return new ResponseEntity<> (usuarioPOJO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}", produces = {"application/json","application/xml","application/x-yaml"})
	public UsuarioPOJO findById(@PathVariable("id") Long id) {
		UsuarioPOJO usuarioPOJO = usuarioService.findById(id);
		return usuarioPOJO;
	}
	
	@PutMapping(produces = { "application/json", "application/xml", "application/x-yaml" }, consumes = {
			"application/json", "application/xml", "application/x-yaml" })
	public UsuarioPOJO update(@RequestBody UsuarioPOJO usuarioPOJO) {
		UsuarioPOJO usuPOJO = usuarioService.update(usuarioPOJO);
		
		return usuPOJO;
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id")Long id){
		usuarioService.Delete(id);
		return ResponseEntity.ok().build();	
	}
	
}
