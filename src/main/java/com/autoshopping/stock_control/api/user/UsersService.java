package com.autoshopping.stock_control.api.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersService {

    @Autowired
    private UsersRepository rep;

    public Iterable<Users>getUsers() { return rep.findAll();}
    public Optional<Users>getUsersById(Integer id) { return rep.getUsersById(id);}


    /*Criando um novo usuario*/
    public Users insert(Users user){return rep.save(user);}

    /*Atualizando um usuario*/
    public Users update(Users user, Integer id) {
        Optional<Users>optional=getUsersById(id);{
            if(optional.isPresent()){
                Users update=optional.get();
                rep.save(user);

                return user;
            }else{
                throw new RuntimeException("Não foi possivel atualizar o usuário. ");
            }
        }
    }

    /*Deletando um usuário*/
    public boolean delete(Integer id){
        if(getUsersById(id).isPresent()){
            rep.deleteById(String.valueOf(id));
            return true;
        }
        return false;
    }



}
