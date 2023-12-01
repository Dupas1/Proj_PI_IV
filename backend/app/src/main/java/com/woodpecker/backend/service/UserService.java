package com.woodpecker.backend.service;

import com.woodpecker.backend.dtos.UserRequest;
import com.woodpecker.backend.dtos.UserResponse;
import com.woodpecker.backend.model.Preference;
import com.woodpecker.backend.model.Settings;
import com.woodpecker.backend.model.User;
import com.woodpecker.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    public UserResponse create(UserRequest request){

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPsw(request.getPsw());
        user.setPhone(request.getPhone());
        user.setEntryDate(new Date());
        user.setGender(request.getGender());
        repository.save(user);

        return createResponse(user);

        //poderia fazer uma try catch para tratar erro, caso venha falhar a operacao de criacao.
    }

    public UserResponse findByUid(String uid){
        return createResponse(repository.findByUid(uid));
    }

    public UserResponse update(String uid, UserRequest request){

        User user = repository.findByUid(uid);
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPsw(request.getPsw());
        user.setPhone(request.getPhone());
        user.setEntryDate(new Date());
        user.setGender(request.getGender());

        repository.save(user);
        return createResponse(user);
    }

    public boolean delete(String uid){
        try{
            repository.deleteById(uid);
            return true;
        } catch(Exception e){
            return false;
        }
    }

    public void setSettings(String uid, Settings id){
        User user = repository.findByUid(uid);
        user.setSettings(id);
        repository.save(user);
    }

    public void setPreferences(String uid, Preference id){
        User user = repository.findByUid(uid);
        user.setPreferences(id);
        repository.save(user);
    }

    private UserResponse createResponse(User user){

        UserResponse response = new UserResponse();
        response.setUid(user.getUid());
        response.setEmail(user.getEmail());
        response.setPsw(user.getPsw());
        response.setName(user.getName());
        response.setGender(user.getGender());
        response.setPhone(user.getPhone());
        response.setEntryDate(user.getEntryDate());

        return response;
    }
}
