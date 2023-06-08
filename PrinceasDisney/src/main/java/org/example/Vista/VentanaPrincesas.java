package org.example.Vista;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincesas extends JFrame {
    private JLabel lblId;
    private JLabel lblNombre;
    private JLabel lblEdad;
    private JLabel lblPrincipe;
    private JLabel lblLugar;
    private JLabel lblUrl;
    private JTextField txtId;
    private JTextField txtNombre;
    private JTextField txtEdad;
    private JTextField txtPrincipe;
    private JTextField txtLugar;
    private JTextField txtUrl;
    private JLabel lblNombre1;
    private JLabel lblEdad1;
    private JLabel lblPrincipe1;
    private JLabel lblLugar1;
    private JLabel lblUrl1;
    private JTextField txtNombre1;
    private JTextField txtEdad1;
    private JTextField txtPrincipe1;
    private JTextField txtLugar1;
    private JTextField txtUrl1;
    private JButton btnAgregar;
    private JButton btnCargar;
    private JButton btnEliminar;
    private JButton btnActualizar;
    private JScrollPane scrollPane;
    private GridLayout layout;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private JTable tablaPrincesas;
    private JLabel lblImagenPrin;

    public VentanaPrincesas(String title) throws HeadlessException {
        super(title);
        this.setSize(1300,1000);
        layout = new GridLayout(2,2);
        this.getContentPane().setLayout(layout);

        //panel1
        panel1 = new JPanel(new FlowLayout());
        panel1.setBackground(new Color(231, 220, 144));

        lblId = new JLabel("ID:");

        lblNombre = new JLabel("Nombre:");

        lblEdad = new JLabel("Edad:");

        lblPrincipe = new JLabel("Principe:");

        lblLugar = new JLabel("Lugar:");

        lblUrl = new JLabel("Url");


        txtId = new JTextField(3);

        txtId.setText("0");

        txtId.setEnabled(false);


        txtNombre = new JTextField(10);

        txtEdad = new JTextField(3);

        txtPrincipe = new JTextField(10);

        txtLugar = new JTextField(15);

        txtUrl = new JTextField(20);

        btnAgregar = new JButton("Agregar");


        panel1.add(lblNombre);
        panel1.add(txtNombre);

        panel1.add(lblEdad);
        panel1.add(txtEdad);

        panel1.add(lblPrincipe);
        panel1.add(txtPrincipe);

        panel1.add(lblLugar);
        panel1.add(txtLugar);

        panel1.add(lblUrl);
        panel1.add(txtUrl);

        panel1.add(btnAgregar);



        //panel2
        panel2 = new JPanel(new FlowLayout());
        panel2.setBackground(new Color(134, 231, 192, 237));

        btnCargar = new JButton("Cargar");
        panel2.add(btnCargar);

        tablaPrincesas = new JTable();

        scrollPane = new JScrollPane(tablaPrincesas);
        panel2.add(scrollPane);


        //panel3
        panel3 = new JPanel(new FlowLayout());
        panel3.setBackground(new Color(123, 152, 241));

        lblImagenPrin = new JLabel("....");
        this.panel3.add(lblImagenPrin);


        //panel4
        panel4 = new JPanel(new FlowLayout());
        panel4.setBackground(new Color(184, 133, 255));

        lblNombre1 = new JLabel("Nombre:");

        lblEdad1 = new JLabel("Edad:");

        lblPrincipe1 = new JLabel("Principe:");

        lblLugar1 = new JLabel("Lugar:");

        lblUrl1 = new JLabel("Url");

        txtNombre1 = new JTextField(10);

        txtEdad1 = new JTextField(3);

        txtPrincipe1 = new JTextField(10);

        txtLugar1 = new JTextField(15);

        txtUrl1 = new JTextField(20);

        btnEliminar = new JButton("Eliminar");

        btnActualizar = new JButton("Actualizar");
        panel4.add(lblNombre1);
        panel4.add(txtNombre1);

        panel4.add(lblEdad1);
        panel4.add(txtEdad1);

        panel4.add(lblPrincipe1);
        panel4.add(txtPrincipe1);

        panel4.add(lblLugar1);
        panel4.add(txtLugar1);

        panel4.add(lblUrl1);
        panel4.add(txtUrl1);

        panel4.add(btnEliminar);

        panel4.add(btnActualizar);

        this.getContentPane().add(panel1,0);
        this.getContentPane().add(panel2,1);
        this.getContentPane().add(panel3,2);
        this.getContentPane().add(panel4,3);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public JLabel getLblNombre1() {
        return lblNombre1;
    }

    public void setLblNombre1(JLabel lblNombre1) {
        this.lblNombre1 = lblNombre1;
    }

    public JLabel getLblEdad1() {
        return lblEdad1;
    }

    public void setLblEdad1(JLabel lblEdad1) {
        this.lblEdad1 = lblEdad1;
    }

    public JLabel getLblPrincipe1() {
        return lblPrincipe1;
    }

    public void setLblPrincipe1(JLabel lblPrincipe1) {
        this.lblPrincipe1 = lblPrincipe1;
    }

    public JLabel getLblLugar1() {
        return lblLugar1;
    }

    public void setLblLugar1(JLabel lblLugar1) {
        this.lblLugar1 = lblLugar1;
    }

    public JLabel getLblUrl1() {
        return lblUrl1;
    }

    public void setLblUrl1(JLabel lblUrl1) {
        this.lblUrl1 = lblUrl1;
    }

    public JTextField getTxtNombre1() {
        return txtNombre1;
    }

    public void setTxtNombre1(JTextField txtNombre1) {
        this.txtNombre1 = txtNombre1;
    }

    public JTextField getTxtEdad1() {
        return txtEdad1;
    }

    public void setTxtEdad1(JTextField txtEdad1) {
        this.txtEdad1 = txtEdad1;
    }

    public JTextField getTxtPrincipe1() {
        return txtPrincipe1;
    }

    public void setTxtPrincipe1(JTextField txtPrincipe1) {
        this.txtPrincipe1 = txtPrincipe1;
    }

    public JTextField getTxtLugar1() {
        return txtLugar1;
    }

    public void setTxtLugar1(JTextField txtLugar1) {
        this.txtLugar1 = txtLugar1;
    }

    public JTextField getTxtUrl1() {
        return txtUrl1;
    }

    public void setTxtUrl1(JTextField txtUrl1) {
        this.txtUrl1 = txtUrl1;
    }

    public JLabel getLblImagenPrin() {
        return lblImagenPrin;
    }

    public void setLblImagenPrin(JLabel lblImagenPrin) {
        this.lblImagenPrin = lblImagenPrin;
    }

    public JButton getBtnActualizar() {
        return btnActualizar;
    }

    public void setBtnActualizar(JButton btnActualizar) {
        this.btnActualizar = btnActualizar;
    }

    public JTable getTablaPrincesas() {
        return tablaPrincesas;
    }

    public void setTablaPrincesas(JTable tablaPrincesas) {
        this.tablaPrincesas = tablaPrincesas;
    }

    public JLabel getLblId() {
        return lblId;
    }

    public void setLblId(JLabel lblId) {
        this.lblId = lblId;
    }

    public JLabel getLblNombre() {
        return lblNombre;
    }

    public void setLblNombre(JLabel lblNombre) {
        this.lblNombre = lblNombre;
    }

    public JLabel getLblEdad() {
        return lblEdad;
    }

    public void setLblEdad(JLabel lblEdad) {
        this.lblEdad = lblEdad;
    }

    public JLabel getlblprincipe() {
        return lblPrincipe;
    }

    public void setLblPrincipe(JLabel lblPrincipe) {
        this.lblPrincipe = lblPrincipe;
    }

    public JLabel getLblLugar() {
        return lblLugar;
    }

    public void setLblLugar(JLabel lblLugar) {
        this.lblLugar = lblLugar;
    }

    public JLabel getLblUrl() {
        return lblUrl;
    }

    public void setLblUrl(JLabel lblUrl) {
        this.lblUrl = lblUrl;
    }

    public JTextField getTxtId() {
        return txtId;
    }

    public void setTxtId(JTextField txtId) {
        this.txtId = txtId;
    }

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(JTextField txtNombre) {
        this.txtNombre = txtNombre;
    }

    public JTextField getTxtEdad() {
        return txtEdad;
    }

    public void setTxtEdad(JTextField txtEdad) {
        this.txtEdad = txtEdad;
    }

    public JTextField getTxtPrincipe() {
        return txtPrincipe;
    }

    public void setTxtPrincipe(JTextField txtPrincipe) {
        this.txtPrincipe = txtPrincipe;
    }

    public JTextField getTxtLugar() {
        return txtLugar;
    }

    public void setTxtLugar(JTextField txtLugar) {
        this.txtLugar = txtLugar;
    }

    public JTextField getTxtUrl() {
        return txtUrl;
    }

    public void setTxtUrl(JTextField txtUrl) {
        this.txtUrl = txtUrl;
    }

    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    public void setBtnAgregar(JButton btnAgregar) {
        this.btnAgregar = btnAgregar;
    }

    public JButton getBtnCargar() {
        return btnCargar;
    }

    public void setBtnCargar(JButton btnCargar) {
        this.btnCargar = btnCargar;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public void setBtnEliminar(JButton btnEliminar) {
        this.btnEliminar = btnEliminar;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    @Override
    public GridLayout getLayout() {
        return layout;
    }

    public void setLayout(GridLayout layout) {
        this.layout = layout;
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    public JPanel getPanel2() {
        return panel2;
    }

    public void setPanel2(JPanel panel2) {
        this.panel2 = panel2;
    }

    public JPanel getPanel3() {
        return panel3;
    }

    public void setPanel3(JPanel panel3) {
        this.panel3 = panel3;
    }

    public JPanel getPanel4() {
        return panel4;
    }

    public void setPanel4(JPanel panel4) {
        this.panel4 = panel4;
    }


    public void limpiar(){
        txtLugar.setText("");
        txtNombre.setText("");
        txtPrincipe.setText("");
        txtUrl.setText("");
        txtEdad.setText("");

    }
}
