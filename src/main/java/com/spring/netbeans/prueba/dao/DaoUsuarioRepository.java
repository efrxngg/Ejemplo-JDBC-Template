/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spring.netbeans.prueba.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.spring.netbeans.prueba.domain.Usuario;
import com.spring.netbeans.prueba.interfaces.DaoUsuario;

/**
 *
 * @author Usuario
 */
@Component
public class DaoUsuarioRepository implements DaoUsuario {

    private JdbcTemplate plantilla;
    
    public DaoUsuarioRepository(DataSource dataSource) {
        this.plantilla = new JdbcTemplate(dataSource);
    }

    @Override
    @Transactional
    public void create(Usuario obj) {
        var sql = "insert into usuario values(?,?,?,?,?,?)";
        plantilla.update(sql, obj.getUsuario(), obj.getPasword(), obj.getNombres(),
                obj.getApellidos(), obj.getFecha(), obj.getEstado());
    }

    @Override
    public List<Usuario> getAll() {
        var sql = "select * from usuarios";
        return plantilla.query(sql, new BeanPropertyRowMapper<>(Usuario.class));
    }

    @Override
    public Usuario getOne(String user) {
        return plantilla.queryForObject("select * from usuario where usuario=?", new BeanPropertyRowMapper<>(Usuario.class), user);
    }

    @Override
    @Transactional
    public void delete(String user) {
        plantilla.update("delete from usuario where usuario=?", user);
    }
 
    @Override
    @Transactional
    public void update(Usuario obj) {
        var sql = "update usuario set password=?,nombres=?,apellidos=? where usuario=?";
        plantilla.update(sql, obj.getPasword(), obj.getNombres(),
                obj.getApellidos(), obj.getUsuario());
    }

}
