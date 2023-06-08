package org.example.Controlador;

import org.example.Modelo.ModeloTablaPrincesas;
import org.example.Modelo.Princesas;
import org.example.Persistencia.PrincesasDAO;
import org.example.Vista.VentanaPrincesas;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;

public class ControladorPrincesas extends MouseAdapter {
    private VentanaPrincesas view;
    private ModeloTablaPrincesas modelo;
    private PrincesasDAO princesasDAO;

    public ControladorPrincesas(VentanaPrincesas view) {
        this.view = view;

        this.modelo = new ModeloTablaPrincesas();

        this.princesasDAO = new PrincesasDAO();


        this.view.getTablaPrincesas().setModel(modelo);

        this.view.getBtnAgregar().addMouseListener(this);

        this.view.getTablaPrincesas().addMouseListener(this);

        this.view.getBtnEliminar().addMouseListener(this);

        this.view.getBtnActualizar().addMouseListener(this);

        this.view.getBtnCargar().addMouseListener(this);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.view.getBtnCargar()) {
            modelo.cargarTablas();
            this.view.getTablaPrincesas().setModel(modelo);
            this.view.getTablaPrincesas().updateUI();
        }

        if (e.getSource() == this.view.getBtnAgregar()) {
            System.out.println("Boton agregar presionado");
            try {
                String nombre = vacioNombre(this.view.getTxtNombre().getText());
                String edad = vacioEdad(this.view.getTxtEdad().getText());
                String principe = vacioPrincipe(this.view.getTxtPrincipe().getText());
                String lugar = vacioLugar(this.view.getTxtLugar().getText());
                String url = vacioUrl(this.view.getTxtUrl().getText());

                Princesas princesas = new Princesas();
                princesas.setId(0);
                princesas.setNombre(nombre);
                princesas.setEdad(edad);
                princesas.setPrincipe(principe);
                princesas.setLugar(lugar);
                princesas.setUrl(url);


                if (modelo.agregarPrincesa(princesas)) {
                    JOptionPane.showMessageDialog(view, "Agregado Exitosamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                    this.view.getTablaPrincesas().updateUI();
                } else {
                    JOptionPane.showMessageDialog(view, "No se pudo agregar a la tabla", "Erros insert", JOptionPane.ERROR_MESSAGE);
                }
                this.view.limpiar();
            }catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(view, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                this.view.limpiar();}
        }

        if (e.getSource() == this.view.getTablaPrincesas()) {
            System.out.println("Evento sobre tabla");
            int index = this.view.getTablaPrincesas().getSelectedRow();
            Princesas tmp = modelo.getPrincesaAtIndex(index);
            try {
                ImageIcon imagenPrincesa = tmp.getImagenPrincesa();
                if (imagenPrincesa != null) {
                    this.view.getLblImagenPrin().setIcon(imagenPrincesa);
                } else {
                    this.view.getLblImagenPrin().setIcon(null);
                    System.out.println("Error en la imagen");
                }
            } catch (MalformedURLException mfue) {
                System.out.println("Error, no se pudo obtener la imagen: " + mfue.toString());
                this.view.getLblImagenPrin().setIcon(null);
            }
            this.view.getTxtNombre1().setText(tmp.getNombre());
            this.view.getTxtEdad1().setText(tmp.getEdad());
            this.view.getTxtPrincipe1().setText(tmp.getPrincipe());
            this.view.getTxtLugar1().setText(tmp.getLugar());
            this.view.getTxtUrl1().setText(tmp.getUrl());
        }

        if (e.getSource() == this.view.getBtnActualizar()) {
            System.out.println("Evento sobre boton Actualizar");
            int rowIndex = this.view.getTablaPrincesas().getSelectedRow();
            Princesas tmp = modelo.getPrincesaAtIndex(rowIndex);
            Princesas princesas = new Princesas();
            princesas.setNombre(this.view.getTxtNombre1().getText());
            princesas.setEdad(this.view.getTxtEdad1().getText());
            princesas.setPrincipe(this.view.getTxtPrincipe1().getText());
            princesas.setLugar(this.view.getTxtLugar1().getText());
            princesas.setUrl(this.view.getTxtUrl1().getText());
            princesas.setId(tmp.getId());
            if (modelo.modPrincesas(princesas)) {
                JOptionPane.showMessageDialog(view, "Se realizo la modificacion", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                modelo.cargarTablas();
                this.view.getTablaPrincesas().setModel(modelo);
                this.view.getTablaPrincesas().updateUI();
            } else {
                JOptionPane.showMessageDialog(view, "Error al modificar", "Error al Insertar", JOptionPane.ERROR_MESSAGE);
            }
            this.view.getTablaPrincesas().updateUI();
        }

        if (e.getSource() == this.view.getBtnEliminar()) {
            ModeloTablaPrincesas temp = new ModeloTablaPrincesas();
            int index = this.view.getTablaPrincesas().getSelectedRow();
            Princesas tmp = modelo.getPrincesaAtIndex(index);
            if (temp.deletPrincesas(Integer.toString(tmp.getId()))) {
                JOptionPane.showMessageDialog(view, "Eliminacion exitosa", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                modelo.cargarTablas();
                this.view.getTablaPrincesas().updateUI();
                this.view.limpiar();
            } else {
                JOptionPane.showMessageDialog(view, "Error al eliminar", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        this.view.limpiar();

    }

    private String vacioNombre(String nombre) {
        if (nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("No puedes dejar vacio el campo Nombre");
        }
        return nombre;
    }
    private String vacioEdad(String edad) {
        if (edad.trim().isEmpty()) {
            throw new IllegalArgumentException("No puedes dejar vacio el campo Edad");
        }
        return edad;
    }
    private String vacioPrincipe(String principe) {
        if (principe.trim().isEmpty()) {
            throw new IllegalArgumentException("No puedes dejar vacio el campo Principe");
        }
        return principe;
    }
    private String vacioLugar(String lugar) {
        if (lugar.trim().isEmpty()) {
            throw new IllegalArgumentException("No puedes dejar vacio el campo Lugar");
        }
        return lugar;
    }
    private String vacioUrl(String url) {
        if (url.trim().isEmpty()) {
            throw new IllegalArgumentException("No puedes dejar vacio el campo URl");
        }
        return url;
    }
}
