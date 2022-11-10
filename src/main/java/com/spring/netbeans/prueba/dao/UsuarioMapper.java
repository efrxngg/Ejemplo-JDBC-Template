package com.spring.netbeans.prueba.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

import com.spring.netbeans.prueba.domain.Usuario;

public class UsuarioMapper implements RowMapper<Usuario> {

    @Override
    @Nullable
    public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
        var user = new Usuario();
        user.setUsuario(rs.getString("usuario"));
        user.setPasword(rs.getString("password"));
        user.setNombres(rs.getString("nombres"));
        user.setApellidos(rs.getString("apellidos"));
        return user;
    }

}
