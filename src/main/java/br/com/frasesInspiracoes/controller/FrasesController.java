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

import br.com.frasesInspiracoes.POJO.FrasesPOJO;
import br.com.frasesInspiracoes.service.FrasesService;

@RestController
@RequestMapping("/frases")
public class FrasesController {

		private final FrasesService frasesService;
		
		@Autowired
		public FrasesController(FrasesService frasesService) {
			this.frasesService = frasesService;
		}
		
		@PostMapping(produces = { "application/json", "application/xml", "application/x-yaml" }, consumes = {
				"application/json", "application/xml", "application/x-yaml" })
		public FrasesPOJO create (@RequestBody FrasesPOJO frasesPOJO) {
			FrasesPOJO frasPOJO = frasesService.create(frasesPOJO);
			return frasPOJO;
		}
		
		@GetMapping(produces = {"application/json","application/xml","application/x-yaml"})
		public ResponseEntity<?> findAll(@RequestParam(value = "page", defaultValue = "0") int page,
				@RequestParam(value = "limit", defaultValue = "12") int limit,
				@RequestParam(value = "direction", defaultValue = "asc") String direction){
			var sortDirection = "desc".equalsIgnoreCase(direction) ? Direction.DESC : Direction.ASC;
			
			Pageable pageable = PageRequest.of(page, limit, Sort.by(sortDirection, "nome"));
			
			Page<FrasesPOJO> frasesPOJO = frasesService.findAll(pageable);
			
			return new ResponseEntity<> (HttpStatus.OK);		
			
		}
		
		@GetMapping(value = "/{id}", produces = {"application/json","application/xml","application/x-yaml"})
		public FrasesPOJO FindById(@PathVariable("id") Long id) {
			FrasesPOJO frasesPOJO = frasesService.findById(id);
			return frasesPOJO;
		}
		
		
		@PutMapping(produces = { "application/json", "application/xml", "application/x-yaml" }, consumes = {
				"application/json", "application/xml", "application/x-yaml" })
		public FrasesPOJO update(@RequestBody FrasesPOJO frasesPOJO) {
			FrasesPOJO frasPOJO = frasesService.update(frasesPOJO);
			return frasPOJO;
		}
		
		
		
		@DeleteMapping("/{id}")
		public ResponseEntity<?> delete(@PathVariable("id")Long id){
			frasesService.Delete(id);
			return ResponseEntity.ok().build();
			
		}
}
