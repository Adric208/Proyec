package org.example.Modelo;

import org.example.Persistencia.PrincesasDAO;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloTablaPrincesas implements TableModel {
    public static final int COLUMNS = 6;
    private ArrayList<Princesas> datos;
    private PrincesasDAO princesasDAO;

    public ModeloTablaPrincesas() {
        datos = new ArrayList<>();
        princesasDAO = new PrincesasDAO();
    }

    public ModeloTablaPrincesas(ArrayList<Princesas> datos) {

        this.datos = datos;
        princesasDAO = new PrincesasDAO();
    }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMNS;
    }

    @Override
    public String getColumnName(int columnIndex) {
        String nombreCol = "";
        switch (columnIndex){
            case 0:
                return "Id";

            case 1:
                return "Nombre";

            case 2:
                return "Edad";

            case 3:
                return "Principe";

            case 4:
                return "Lug. del cuento";

            case 5:
                return "Url Foto";

        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {

        switch (columnIndex){
            case 0:
                return Integer.class;

            case 1:
                return String.class;

            case 2:
                return String.class;

            case 3:
                return String.class;

            case 4:
                return String.class;

            case 5:
                return String.class;


        }
        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Princesas tpm = datos.get(rowIndex);
        switch (columnIndex){
            case 0:
                return tpm.getId();
            case 1:
                return tpm.getNombre();
            case 2:
                return tpm.getEdad();
            case 3:
                return tpm.getPrincipe();
            case 4:
                return tpm.getLugar();
            case 5:
                return tpm.getUrl();

        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0:
                datos.get(rowIndex).setNombre((String)aValue);
                break;
            case 1:
                datos.get(rowIndex).setEdad((String) aValue);
                break;
            case 2:
                datos.get(rowIndex).setPrincipe((String)aValue);
                break;
            case 3:
                datos.get(rowIndex).setLugar((String)aValue);
                break;
            case 4:
                datos.get(rowIndex).setUrl((String)aValue);
                break;
        }
    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }

    public ArrayList<Princesas> getDatos() {
        return datos;
    }

    public void setDatos(ArrayList<Princesas> datos) {
        this.datos = datos;
    }

    public PrincesasDAO getPrincesasDAO() {
        return princesasDAO;
    }

    public void setPrincesasDAO(PrincesasDAO princesasDAO) {
        this.princesasDAO = princesasDAO;
    }

    public void cargarTablas() {
        try {
            datos = princesasDAO.obtenerTodo();
        } catch (SQLException sqle) {
            System.out.println("Error");
        }
    }
    public boolean agregarPrincesa(Princesas princesas) {
        boolean resultado = false;
        try {
            int ulID = 0;
            if (!datos.isEmpty()) {
                Princesas ulprin = datos.get(datos.size() - 1);
                ulID = ulprin.getId();
            }
            int nuevoId = ulID + 1;
            princesas.setId(nuevoId);
            if (princesasDAO.insertar(princesas)) {
                datos.add(princesas);
                resultado = true;
            }
        } catch (SQLException sqle) {
            System.out.println("Error: " + sqle.getMessage());
        }
        return resultado;
    }

    public boolean modPrincesas(Princesas princesas){
        boolean resultado = true;
        try {
            if (princesasDAO.update(princesas)){
                resultado = true;
            } else{
                resultado = false;
            }
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
        return resultado;
    }

    public boolean deletPrincesas(String id) {
        boolean resultado = false;
        try {
            if (princesasDAO.delete(id)) {
                resultado = true;
            } else {
                resultado = false;
            }
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
        return resultado;
    }

    public Princesas getPrincesaAtIndex(int index) {
        if (index >= 0 && index < datos.size()) {
            return datos.get(index);
        } else {
            return null;
        }
    }
    }
