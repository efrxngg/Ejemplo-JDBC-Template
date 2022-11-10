/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spring.netbeans.prueba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.netbeans.prueba.dao.DaoUsuarioRepository;
import com.spring.netbeans.prueba.domain.Usuario;


@RestController
@CrossOrigin("*")
@RequestMapping("/users")
public class ApiController {
    
    @Autowired
    private DaoUsuarioRepository daoUsuarioRepository;

    @GetMapping(value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Usuario> listar() {
        return daoUsuarioRepository.getAll();
    }
}
