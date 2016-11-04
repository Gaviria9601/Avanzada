/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import javax.swing.AbstractListModel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
 
/**
 *
 * @author Santiago Gaviria Oliveros
 */
public class FiltrarLista extends JList{
    private CampoFiltro campoFiltro;
    private int DEFAULT_FIELD_WIDTH = 20;
 
    public FiltrarLista() {
        super();
        setModel(new FiltroModel());
        campoFiltro = new CampoFiltro(DEFAULT_FIELD_WIDTH);
    }
     
    public void setModel(ListModel m)
    {
        if(!(m instanceof FiltroModel))
            throw new IllegalArgumentException();
        super.setModel(m);
    }
     
    public void agregarItem(Object e)
    {
        ((FiltroModel)getModel()).agregarElemento(e);
    }
    
    public JTextField getCampoFiltro() {
        return campoFiltro;
    }
     
    class FiltroModel extends AbstractListModel{
         
        ArrayList items;
        ArrayList FiltradoItems;
 
        public FiltroModel() {
            super();
            items = new ArrayList();
            FiltradoItems = new ArrayList();
        }
         
         
        @Override
        public int getSize() {
            return FiltradoItems.size();
        }
 
        @Override
        public Object getElementAt(int index) {
            if(index<FiltradoItems.size())
            {
                return FiltradoItems.get(index);
            }else
                return null;
        }
         
        public void agregarElemento(Object o)
        {
            items.add(o);
            refiltrar();
        }
         
        public void refiltrar()
        {
            FiltradoItems.clear();
            String texto = getCampoFiltro().getText().toUpperCase();
            for(int i=0; i<items.size();i++)
            {
                if(items.get(i).toString().indexOf(texto,0)!=-1)
                {
                    FiltradoItems.add(items.get(i));
                }
            }
            fireContentsChanged(this,0,getSize());
        }
                 
         
    }
     
     
    class CampoFiltro extends JTextField implements DocumentListener {
        public CampoFiltro (int width) {
            super(width);
            getDocument().addDocumentListener (this);
        }       
        @Override
        public void insertUpdate(DocumentEvent e) {
           ((FiltroModel)getModel()).refiltrar();
        }
        @Override
        public void removeUpdate(DocumentEvent e) {
            ((FiltroModel)getModel()).refiltrar();
        }
        @Override
        public void changedUpdate(DocumentEvent e) {
            ((FiltroModel)getModel()).refiltrar();
        }
    }
     
}