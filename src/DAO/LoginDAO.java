/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controlador.CtlEmpresario;
import Controlador.CtlAdministrador;
import Controlador.CtlProveedor;

/**
 *
 * @author Santiago Gaviria Oliveros
 */
public class LoginDAO {

    CtlEmpresario empresario;
    CtlProveedor proveedor;
    CtlAdministrador admininistrador;

    public LoginDAO() {
        empresario = new CtlEmpresario();
        proveedor = new CtlProveedor();
        admininistrador = new CtlAdministrador();
    }

    public String ingresar(String nickname, String contrasenia) {
        String tipo = "";
        try {
            if (empresario.searchLogin(nickname, contrasenia) != null) {
                tipo = "Empresario";
            } else if (proveedor.searchLogin(nickname, contrasenia) != null) {
                tipo = "Proveedor";
            } else if (admininistrador.searchLogin(nickname, contrasenia) != null) {
                tipo = "Administrador";
            }
            return tipo;
        } catch (Exception e) {
            return tipo;
        }
    }

}
