//package br.com.frasesInspiracoes.controller;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.domain.Sort.Direction;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import br.com.frasesInspiracoes.POJO.UsuarioFrasePOJO;
//import br.com.frasesInspiracoes.service.UsuarioFraseService;
//
//@RestController
//@RequestMapping("/frasesUsuario")
//public class UsuarioFraseController {
//	
//	private final UsuarioFraseService usuarioFraseService;
//	
//	@Autowired
//	private UsuarioFraseController(UsuarioFraseService usuarioFraseService) {
//		this.usuarioFraseService = usuarioFraseService;
//	}
//	
//	
//	@PostMapping(produces = { "application/json", "application/xml", "application/x-yaml" }, consumes = {
//			"application/json", "application/xml", "application/x-yaml" })
//	public UsuarioFrasePOJO create(@RequestBody UsuarioFrasePOJO usuarioFrasePOJO) {
//		UsuarioFrasePOJO usurFraPOJO = usuarioFraseService.create(usuarioFrasePOJO);
//		
//		return usurFraPOJO;
//	}
//	
//	@GetMapping(produces = {"application/json","application/xml","application/x-yaml"})
//	public ResponseEntity<?> findAll(@RequestParam(value = "page", defaultValue = "0") int page,
//			@RequestParam(value = "limit", defaultValue = "12") int limit,
//			@RequestParam(value = "direction", defaultValue = "asc") String direction){
//		
//		var sortDirection = "desc".equalsIgnoreCase(direction) ? Direction.DESC : Direction.ASC;
//		
//		Pageable pageable = PageRequest.of(page, limit, Sort.by(sortDirection, "nome"));
//		
//		Page<UsuarioFrasePOJO> usuarioFrasePOJO = usuarioFraseService.findAll(pageable);
//				
//		return new ResponseEntity<>(HttpStatus.OK);
//	}
//	
//	@GetMapping(value = "/{id}", produces = {"application/json","application/xml","application/x-yaml"})
//	public UsuarioFrasePOJO findById(@PathVariable("id") Long id) {
//		UsuarioFrasePOJO usuarioFrasePOJO = usuarioFraseService.findById(id);
//		return usuarioFrasePOJO;
//	}
//	
//	@PutMapping(produces = { "application/json", "application/xml", "application/x-yaml" }, consumes = {
//			"application/json", "application/xml", "application/x-yaml" })
//	public UsuarioFrasePOJO update(@RequestBody UsuarioFrasePOJO usuarioFrasePOJO) {
//		UsuarioFrasePOJO usurFraPOJO = usuarioFraseService.update(usuarioFrasePOJO);
//		
//		return usurFraPOJO;
//	}
//	
//	@DeleteMapping("/{id}")
//	public ResponseEntity<?> delete(@PathVariable("id")Long id){
//		usuarioFraseService.Delete(id);
//		return ResponseEntity.ok().build();
//	}
//	
//	
//	
//	
//}
