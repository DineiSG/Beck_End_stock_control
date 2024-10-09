package com.autoshopping.stock_control.api.usuario;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsersController {

        @Autowired
        private UsersService service;

        /*Buscando todos os usuarios*/
        @GetMapping
        public ResponseEntity<Iterable<Users>> get(){return ResponseEntity.ok(service.getUsers()); }

        /*Buscando usuarios pelo id*/
        @GetMapping("/{id}")
        public ResponseEntity get(@PathVariable("id") Integer id){
            Optional<Users> user=service.getUsersById(id);
            return user
                    .map(Users->ResponseEntity.ok(user))
                    .orElse(ResponseEntity.notFound().build());
        }

        /*Adicionando um novo usuario*/
        @PostMapping
        public ResponseEntity post(@RequestBody Users user){
            Users novoUsuario= service.insert(user);
            return ResponseEntity.ok("Usuario cadastrado com sucesso");
        }

        /*Atualizando os dados de um usuario*/
        @PutMapping({"/{id}"})
        public ResponseEntity put(@PathVariable("id") Integer id, @RequestBody Users user ){
            Users atualizarUsuario=service.update(user, id);
            return ResponseEntity.ok("Dados do usuário atualizados com sucesso");
        }

        @DeleteMapping("/{id}")
        public ResponseEntity delete(@PathVariable("id") Integer id){
            boolean ok=service.delete(id);
            return ok?
                    ResponseEntity.ok("Usuario excluido com sucesso."):
                    ResponseEntity.notFound().build();
        }



}
