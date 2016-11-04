/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Modelo.Categorias;
import Modelo.Departamentos;
import Modelo.Municipios;
import Modelo.Productos;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Santiago Gaviria Oliveros
 */
public class CtlVentana {

    CtlCategoria gestionCategoria;
    CtlProducto gestionProducto;
    CtlDepartamento gestiondepto;
    CtlMunicipio gestionmun;

    public CtlVentana() {
        gestionCategoria = new CtlCategoria();
        gestiondepto = new CtlDepartamento();
        gestionmun = new CtlMunicipio();
        gestionProducto = new CtlProducto();
    }

    /**
     * Verifica los datos de registro
     *
     * @param nomCompleto, nombre completo
     * @param cedula, nombre del proveedor
     * @param depto, direccion del proveedor
     * @param direccion, correo del proveedor
     * @param nomEntidad, nombre de la entidad en que trabaja
     * @param nick, nickname
     * @param pass, password
     * @return true si esta valido de lo contrario false
     */
    public boolean verificarDatosGuardar(JTextField nomCompleto,
            JTextField cedula, JComboBox depto,
            JTextField direccion, JTextField nomEntidad, JTextField nick,
            JTextField pass) {
        return nomCompleto.getText().isEmpty()
                || cedula.getText().isEmpty()
                || depto.getSelectedIndex() == 0
                || direccion.getText().isEmpty()
                || nomEntidad.getText().isEmpty()
                || nick.getText().isEmpty()
                || pass.getText().isEmpty();
    }

    public boolean verificarDatosIngreso(JTextField usuario, JPasswordField password) {
        return usuario.getText().isEmpty() || password.getText().isEmpty();
    }

    public boolean verificarDatosRegistroCategoria(JTextField nombre, JTextArea descripcion) {
        return nombre.getText().isEmpty() || descripcion.getText().isEmpty();
    }

    public boolean verificarDatosRegistroProducto(JTextField nomProducto, JComboBox cate, JTextArea des) {
        return nomProducto.getText().isEmpty() || cate.getSelectedIndex() == 0 || des.getText().isEmpty();
    }

    public void cargarCategorias(JComboBox cate) {
        List<Categorias> categorias = gestionCategoria.list();
        cate.removeAllItems();
        cate.addItem("Seleccione una categoria");
        for (int i = 0; i < categorias.size(); i++) {
            cate.addItem(categorias.get(i).getNombre());
        }
    }

    public void cargarDeptos(JComboBox comboDepto) {
        comboDepto.removeAllItems();
        comboDepto.addItem("Seleccione una opción");
        List<Departamentos> deptos = gestiondepto.list();
        for (int i = 0; i < deptos.size(); i++) {
            comboDepto.addItem(deptos.get(i).getNombre());
        }
    }

    public void cargarMunicipios(String depto, JComboBox comboMun) {
        comboMun.removeAllItems();
        comboMun.addItem("Seleccione una opción");
        List<Municipios> municipios = gestionmun.list(depto);
        for (int i = 0; i < municipios.size(); i++) {
            comboMun.addItem(municipios.get(i).getNombre());
        }
    }

    /**
     * lista las categorias
     * @return un modelo de informacion
     */
    public DefaultTableModel listarCategorias() {
        List<Categorias> cate = gestionCategoria.list();
        DefaultTableModel temporal;
        String nombreColumnas[] = {"Codigo", "Nombre", "Descripción"};
        temporal = new DefaultTableModel(new Object[][]{}, nombreColumnas) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        for (int i = 0; i < cate.size(); i++) {
            temporal.addRow(new Object[]{
                cate.get(i).getCodigo(),
                cate.get(i).getNombre(),
                cate.get(i).getDescripcion()
            });
        }
        return temporal;

    }
    
    
    /**
     * lista los Productos
     * @return un modelo de informacion
     */
    public DefaultTableModel listarProductos() {
        List<Productos> producto = gestionProducto.list();
        DefaultTableModel temporal;
        String nombreColumnas[] = {"Codigo", "Nombre", "Descripción","Categoria"};
        temporal = new DefaultTableModel(new Object[][]{}, nombreColumnas) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        for (int i = 0; i < producto.size(); i++) {
            temporal.addRow(new Object[]{
                producto.get(i).getCodigo(),
                producto.get(i).getNombreproducto(),
                producto.get(i).getDescripcion(),
                producto.get(i).getCategoriasCodigo().getNombre()
            });
        }
        return temporal;

    }

    public CtlMunicipio getGestionmun() {
        return gestionmun;
    }

    public void setGestionmun(CtlMunicipio gestionmun) {
        this.gestionmun = gestionmun;
    }
    
    

}
