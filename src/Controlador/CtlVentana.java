/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Categorias;
import Modelo.CategoriasOfrecidas;
import Modelo.Departamentos;
import Modelo.Municipios;
import Modelo.Ofertas;
import Modelo.Productos;
import Modelo.Proveedores;
import Modelo.Subastas;
import com.toedter.calendar.JDateChooser;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JTable;
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
    CtlSubasta gestionSubasta;
    CtlCategoriaOfrecida gestionCateOfrecida;

    public CtlVentana() {
        gestionCategoria = new CtlCategoria();
        gestiondepto = new CtlDepartamento();
        gestionmun = new CtlMunicipio();
        gestionProducto = new CtlProducto();
        gestionSubasta = new CtlSubasta();
        gestionCateOfrecida = new CtlCategoriaOfrecida();
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

    public boolean verificarDatosEnvioSolicitd(JList nombre, JDateChooser fechaE, JDateChooser fechaF, JSpinner cant, JTextArea des) {
        return nombre.getSelectedIndex() == -1 || fechaE.getDate() == null || fechaF.getDate() == null || Integer.parseInt(cant.getValue() + "") == 0
                || des.getText().isEmpty();
    }

    public boolean verificarDatosEnvioOferta(JTextField oferta, JTextArea detalles) {
        return oferta.getText().isEmpty() || detalles.getText().isEmpty();
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
     *
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
     *
     * @return un modelo de informacion
     */
    public DefaultTableModel listarProductos() {
        List<Productos> producto = gestionProducto.list();
        DefaultTableModel temporal;
        String nombreColumnas[] = {"Codigo", "Nombre", "Descripción", "Categoria"};
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

    public void cambiarEstadoSubastas(List<Subastas> sub) {
        for (int i = 0; i < sub.size(); i++) {
            gestionSubasta.update(sub.get(i).getCodigosubasta(),
                    sub.get(i).getCantidadproductos(), false,
                    sub.get(i).getFechainicio(),
                    sub.get(i).getFechafinal(),
                    sub.get(i).getFechaentrega(),
                    sub.get(i).getDescripcion(),
                    sub.get(i).getEmpresariosCedula().getCedula(),
                    sub.get(i).getProductosCodigo().getCodigo());
        }
    }

    /**
     * Verifica la oferta menor del arraylist llegado
     *
     * @param ofertas, estrucutra que contiene los valores de ofertas
     * @return la oferta menor
     */
    public double verificarOfertaMenor(List<Ofertas> ofertas) {
        double ofertamenor = ofertas.get(0).getValor();
        for (int i = 0; i < ofertas.size(); i++) {
            if (ofertas.get(i).getValor() < ofertamenor) {
                ofertamenor = ofertas.get(i).getValor();
            }
        }
        return ofertamenor;

    }

    public CtlMunicipio getGestionmun() {
        return gestionmun;
    }

    public void setGestionmun(CtlMunicipio gestionmun) {
        this.gestionmun = gestionmun;
    }

    /**
     * genera la fecha actual del sistema
     *
     * @return la fecha
     */
    public Date generarFechaActual() {
        Calendar fechaHora = Calendar.getInstance();
        Date fecha = fechaHora.getTime();
        return fecha;
    }

    /**
     * Validar la seleccion de una solicitd en la tabla
     *
     * @param jTSubastas, tabla de la cual se selecciona
     * @return
     */
    public boolean validarSeleccionSolicitud(JTable jTSubastas) {
        for (int i = 0; i < jTSubastas.getRowCount(); i++) {
            if (jTSubastas.isRowSelected(i)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Validar la seleccion de una solicitd en la tabla
     *
     * @param jTOfertas, tabla de la cual se selecciona
     * @return
     */
    public boolean validarSeleccionOferta(JTable jTOfertas) {
        for (int i = 0; i < jTOfertas.getRowCount(); i++) {
            if (jTOfertas.isRowSelected(i)) {
                return true;
            }
        }
        return false;
    }

    /**
     * lista las ofertas
     *
     * @param oferta
     * @return un modelo de informacion
     */
    public DefaultTableModel listarOfertasSubasta(List<Ofertas> oferta) {
        DefaultTableModel temporal;
        String nombreColumnas[] = {"Codigo", "Valor", "Fecha Oferta", "Proveedor", "Codigo Subasta"};
        temporal = new DefaultTableModel(new Object[][]{}, nombreColumnas) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        for (int i = 0; i < oferta.size(); i++) {
            temporal.addRow(new Object[]{
                oferta.get(i).getCodigooferta(),
                oferta.get(i).getValor(),
                oferta.get(i).getFechaoferta(),
                oferta.get(i).getProveedoresCedula().getNombrecompleto(),
                oferta.get(i).getSubastasCodigosubasta().getCodigosubasta(),});
        }
        return temporal;
    }

    public List<CategoriasOfrecidas> listarAreasRegistradas(JTable areas, Proveedores pro) {
        List<CategoriasOfrecidas> cateOfrecida = gestionCateOfrecida.list(pro.getCedula());
        DefaultTableModel temporal;
        String nombreColumnas[] = {"Codigo Categoria", "Nombre"};
        temporal = new DefaultTableModel(new Object[][]{}, nombreColumnas) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        for (int i = 0; i < cateOfrecida.size(); i++) {
            temporal.addRow(new Object[]{
                cateOfrecida.get(i).getCategorias().getCodigo(),
                cateOfrecida.get(i).getCategorias().getNombre(),});
        }
        areas.setModel(temporal);
        return cateOfrecida;
    }

    public void cargarSubastasProveedorArea(JTable subastas, List<CategoriasOfrecidas> codigoArea, Proveedores pro) {
        List<Subastas> subasta = gestionSubasta.listSubastasArea(codigoArea, pro.getCedula());
        DefaultTableModel temporal;
        String nombreColumnas[] = {"Codigo Subasta", "Cantidad", "Estado",
            "Fecha Inicio", "Fecha Final", "Fecha Entrega", "Producto", "Categoria", "Empresario"};
        temporal = new DefaultTableModel(new Object[][]{}, nombreColumnas) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        for (int i = 0; i < subasta.size(); i++) {
            temporal.addRow(new Object[]{
                subasta.get(i).getCodigosubasta(),
                subasta.get(i).getCantidadproductos(),
                estado(subasta.get(i).getEstado()),
                subasta.get(i).getFechainicio(),
                subasta.get(i).getFechafinal(),
                subasta.get(i).getFechaentrega(),
                subasta.get(i).getProductosCodigo().getNombreproducto(),
                subasta.get(i).getProductosCodigo().getCategoriasCodigo().getNombre(),
                subasta.get(i).getEmpresariosCedula().getNombrecompleto()
            });
        }
        subastas.setModel(temporal);
    }

    /**
     * lista las subastas
     *
     * @param cedula
     * @return un modelo de informacion
     */
    public DefaultTableModel listarSubastas(String cedula) {
        List<Subastas> subasta = gestionSubasta.list(cedula);
        DefaultTableModel temporal;
        String nombreColumnas[] = {"Codigo Subasta", "Cantidad", "Estado",
            "Fecha Inicio", "Fecha Final", "Fecha Entrega", "Producto"};
        temporal = new DefaultTableModel(new Object[][]{}, nombreColumnas) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        for (int i = 0; i < subasta.size(); i++) {
            temporal.addRow(new Object[]{
                subasta.get(i).getCodigosubasta(),
                subasta.get(i).getCantidadproductos(),
                estado(subasta.get(i).getEstado()),
                subasta.get(i).getFechainicio(),
                subasta.get(i).getFechafinal(),
                subasta.get(i).getFechaentrega(),
                subasta.get(i).getProductosCodigo().getNombreproducto(),});
        }
        return temporal;

    }

    /**
     * lista las subastas
     *
     * @param ofe
     * @return un modelo de informacion
     */
    public DefaultTableModel listarSubastasProParticipo(List<Ofertas> ofe, double valor) {
        DefaultTableModel temporal;
        String nombreColumnas[] = {"Codigo Subasta", "Cantidad",
            "Fecha Inicio", "Fecha Final", "Fecha Entrega", "Producto", "Categoria", "Empresario", "Resultado"};
        temporal = new DefaultTableModel(new Object[][]{}, nombreColumnas) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        for (int i = 0; i < ofe.size(); i++) {
            if (!ofe.get(i).getSubastasCodigosubasta().getEstado()) {
                if (valor == ofe.get(i).getValor()) {
                    temporal.addRow(new Object[]{
                        ofe.get(i).getSubastasCodigosubasta().getCodigosubasta(),
                        ofe.get(i).getSubastasCodigosubasta().getCantidadproductos(),
                        ofe.get(i).getSubastasCodigosubasta().getFechainicio(),
                        ofe.get(i).getSubastasCodigosubasta().getFechafinal(),
                        ofe.get(i).getSubastasCodigosubasta().getFechaentrega(),
                        ofe.get(i).getSubastasCodigosubasta().getProductosCodigo().getNombreproducto(),
                        ofe.get(i).getSubastasCodigosubasta().getProductosCodigo().getCategoriasCodigo().getNombre(),
                        ofe.get(i).getSubastasCodigosubasta().getEmpresariosCedula().getNombrecompleto(), "Gano",});
                } else if (valor != ofe.get(i).getValor()) {
                    temporal.addRow(new Object[]{
                        ofe.get(i).getSubastasCodigosubasta().getCodigosubasta(),
                        ofe.get(i).getSubastasCodigosubasta().getCantidadproductos(),
                        ofe.get(i).getSubastasCodigosubasta().getFechainicio(),
                        ofe.get(i).getSubastasCodigosubasta().getFechafinal(),
                        ofe.get(i).getSubastasCodigosubasta().getFechaentrega(),
                        ofe.get(i).getSubastasCodigosubasta().getProductosCodigo().getNombreproducto(),
                        ofe.get(i).getSubastasCodigosubasta().getProductosCodigo().getCategoriasCodigo().getNombre(),
                        ofe.get(i).getSubastasCodigosubasta().getEmpresariosCedula().getNombrecompleto(), "Perdio",});
                }
            }
        }
        return temporal;

    }

    public String estado(boolean estado) {
        if (estado) {
            return "Activo";
        } else {
            return "Desactivo";
        }
    }

    public String generarFechaActualCadena() {
        Calendar fechaHora = Calendar.getInstance();
        Date fecha = fechaHora.getTime();
        String[] datos = fecha.toString().split(" ");
        String mes = toStringMes(datos[1]);
        String dia = datos[2];
        String año = datos[5];
        String fe = dia + "/" + mes + "/" + año;
        return fe;
    }

    /**
     * configura el mes en letras a numeros
     *
     * @param mes, mes en letras
     * @return el mes en numeros
     */
    public String toStringMes(String mes) {
        String mesNum = mes;
        switch (mes) {
            case "Ene":
                mesNum = "01";
                break;
            case "Feb":
                mesNum = "02";
                break;
            case "Mar":
                mesNum = "03";
                break;
            case "Abr":
                mesNum = "04";
                break;
            case "May":
                mesNum = "05";
                break;
            case "Jun":
                mesNum = "06";
                break;
            case "Jul":
                mesNum = "07";
                break;
            case "Ago":
                mesNum = "08";
                break;
            case "Sep":
                mesNum = "9";
                break;
            case "Oct":
                mesNum = "10";
                break;
            case "Nov":
                mesNum = "11";
                break;
            case "Dic":
                mesNum = "12";
                break;
        }
        return mesNum;
    }

}
