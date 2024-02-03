package br.com.fabiobatoni.primeiroprojetospringboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;


@RestController
@RequestMapping("/primeiraController")
public class PrimeiraController {
  
  @GetMapping("/primeiroMetodo/{id}")
  public String primeiroMetodo(@PathVariable String id) {
    return "O Parametro e: " + id;
  }

  @GetMapping("/metodoComQueryParams")
  public String metodoComQueryParams(@RequestParam String id) {
    return "O Parametro com metodoComQueryParams: " + id;
  }

  @GetMapping("/metodoComQueryParams2")
  public String metodoComQueryParams2(@RequestParam Map<String, String> allParams) {
    return "O Parametro com metodoComQueryParams: " + allParams.entrySet();
  }

  @PostMapping("/metodoComBodyParams")
  public String metodoComBodyParams(@RequestBody Usuario usuario) {
    return "metodoComBodyParams: " + usuario.username;
  }

  @PostMapping("/metodoComHeaders")
  public String metodoComHeaders(@RequestHeader("name") String name) {
    return "metodoComBodyParams: " + name;
  }

  @PostMapping("/metodoComListHeaders")
  public String metodoComListHeaders(@RequestHeader Map<String, String> headers) {
    return "metodoComBodyParams: " + headers.entrySet();
  }

  @GetMapping("/metodoResponseEntity/{id}")
  public ResponseEntity<Object> metodoResponseEntity(@PathVariable Long id){
    var usuario = new Usuario("fabiobatoni");
    if(id > 5){
      return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }
    return ResponseEntity.badRequest().body("Numero menor que 5");
  }

  record Usuario(String username){

  }
  
}
