package tarea3_pdi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.*;
import org.jdesktop.swingx.prompt.PromptSupport;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

public class JInterfaz extends javax.swing.JFrame {
    private final JControlador rolMenu;
    JTable matriz_kernel;
    JTextField divisor;
    public JInterfaz(JControlador C) {
        initComponents();
        Kernel_aplicar = new JButton("Aplicar");
        Kernel_aplicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Kernel_aplicarActionPerformed(evt);
            }
        });
        PInterfaz F = new PInterfaz();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        this.add(F,BorderLayout.CENTER);
        this.pack();
        this.rolMenu = C;
        this.jButton1.setEnabled(false);
        this.aplicar_filtro.setEnabled(false);
        this.jButton2.setEnabled(false);
        this.jButton3.setEnabled(false);
        this.jButton4.setEnabled(false);
        this.escalar.setEnabled(false);
        this.jButton5.setEnabled(false);
        this.jButton7.setEnabled(false);
        this.aplicar.setEnabled(false);
        this.undo.setEnabled(false);
        this.zoomin.setEnabled(false);
        this.undo_1.setEnabled(false);
        this.zoomout.setEnabled(false);
        this.efecto.setEnabled(false);
        this.dimensiones.setEnabled(false);
        this.tamano.setEnabled(false);
        this.bits.setEnabled(false);
        this.nombre.setEnabled(false);
        Color c = new Color(0,0,0);
        this.dimensiones.setDisabledTextColor(c);
        this.bits.setDisabledTextColor(c);
        this.tamano.setDisabledTextColor(c);
        this.nombre.setDisabledTextColor(c);
        PromptSupport.setPrompt("Angulo", angulo);
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        Red = new javax.swing.JPanel();
        Green = new javax.swing.JPanel();
        Blue = new javax.swing.JPanel();
        RGB = new javax.swing.JPanel();
        slider = new javax.swing.JSlider();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        dimensiones = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        bits = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tamano = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        zoomin = new javax.swing.JButton();
        zoomout = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jLabel1 = new javax.swing.JLabel();
        interpolacion = new javax.swing.JComboBox<>();
        escalar = new javax.swing.JButton();
        ancho = new javax.swing.JTextField();
        alto = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        angulo = new javax.swing.JTextField();
        undo = new javax.swing.JButton();
        efecto = new javax.swing.JComboBox<>();
        aplicar = new javax.swing.JButton();
        matriz = new javax.swing.JComboBox<>();
        aplicar_filtro = new javax.swing.JButton();
        filtro = new javax.swing.JComboBox<>();
        undo_1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Derecha.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/rotate-left-circular-arrow-interface-symbol.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/mirror-horizontally (1).png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/mirror-horizontally.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/automatic-white-balance.png"))); // NOI18N
        jButton5.setPreferredSize(new java.awt.Dimension(99, 41));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/open-file-button.png"))); // NOI18N
        jButton6.setText("Abrir");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/save.png"))); // NOI18N
        jButton7.setText("Guardar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jTabbedPane1.setPreferredSize(new java.awt.Dimension(610, 203));

        Red.setPreferredSize(new java.awt.Dimension(606, 110));

        javax.swing.GroupLayout RedLayout = new javax.swing.GroupLayout(Red);
        Red.setLayout(RedLayout);
        RedLayout.setHorizontalGroup(
            RedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 605, Short.MAX_VALUE)
        );
        RedLayout.setVerticalGroup(
            RedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 132, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("R", Red);

        javax.swing.GroupLayout GreenLayout = new javax.swing.GroupLayout(Green);
        Green.setLayout(GreenLayout);
        GreenLayout.setHorizontalGroup(
            GreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 605, Short.MAX_VALUE)
        );
        GreenLayout.setVerticalGroup(
            GreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 132, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("G", Green);

        Blue.setPreferredSize(new java.awt.Dimension(600, 175));

        javax.swing.GroupLayout BlueLayout = new javax.swing.GroupLayout(Blue);
        Blue.setLayout(BlueLayout);
        BlueLayout.setHorizontalGroup(
            BlueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 605, Short.MAX_VALUE)
        );
        BlueLayout.setVerticalGroup(
            BlueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 132, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("B", Blue);

        javax.swing.GroupLayout RGBLayout = new javax.swing.GroupLayout(RGB);
        RGB.setLayout(RGBLayout);
        RGBLayout.setHorizontalGroup(
            RGBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 605, Short.MAX_VALUE)
        );
        RGBLayout.setVerticalGroup(
            RGBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 132, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("RGB", RGB);

        slider.setMaximum(255);
        slider.setMinimum(-255);
        slider.setValue(0);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel2.setText("-255");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel3.setText("   255");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel4.setText("Dimensiones:");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel5.setText("Bits:");

        bits.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bitsActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel6.setText("Tamano:");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel7.setText("0");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/360-degrees.png"))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel9.setText("Nombre:");

        zoomin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/zoom-in.png"))); // NOI18N
        zoomin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zoominActionPerformed(evt);
            }
        });

        zoomout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/zoom-out.png"))); // NOI18N
        zoomout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zoomoutActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jScrollPane1.setViewportView(jLabel1);

        interpolacion.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        interpolacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nearest", "Bilinear" }));

        escalar.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        escalar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ruler.png"))); // NOI18N
        escalar.setText("  Escalar");
        escalar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escalarActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel10.setText("Ancho");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel11.setText("Alto");

        angulo.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N

        undo.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        undo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/back-arrow.png"))); // NOI18N
        undo.setText("ORIGINAL");
        undo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                undoActionPerformed(evt);
            }
        });

        efecto.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        efecto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Brillo", "Contraste", "Ecualizacion", "Umbralizacion" }));
        efecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                efectoActionPerformed(evt);
            }
        });

        aplicar.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        aplicar.setText("Aplicar");
        aplicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aplicarActionPerformed(evt);
            }
        });

        matriz.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        matriz.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "3x3", "5x5", "7x7", "9x9", "11x11", "13x13", "15x15" }));

        aplicar_filtro.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        aplicar_filtro.setText("Aplicar");
        aplicar_filtro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aplicar_filtroActionPerformed(evt);
            }
        });

        filtro.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        filtro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Box", "Gaussiano(Normal)", "Gaussiano(Discreto)", "Prewitt", "Sobel", "Perfilado", "Personalizado" }));
        filtro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtroActionPerformed(evt);
            }
        });

        undo_1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        undo_1.setText("UNDO");
        undo_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                undo_1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dimensiones, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bits, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tamano, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(escalar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                    .addComponent(interpolacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(107, 107, 107))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(93, 93, 93)
                                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(slider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                            .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jButton4))
                                                            .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                            .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(angulo))
                                                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                        .addComponent(zoomin, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(zoomout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(efecto, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(aplicar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(matriz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(16, 16, 16)
                                                .addComponent(filtro, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(aplicar_filtro)))
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(ancho, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(alto, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel11)
                                .addGap(71, 71, 71))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(undo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(undo_1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(dimensiones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(bits, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(tamano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                            .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(angulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(efecto)
                            .addComponent(aplicar, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(slider, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(matriz)
                            .addComponent(aplicar_filtro, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                            .addComponent(filtro))
                        .addGap(30, 30, 30)
                        .addComponent(interpolacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(zoomin)
                            .addComponent(zoomout)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(escalar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ancho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(alto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(undo, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(undo_1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(angulo.getText().equals("")){
            //Vacio el input
        }else{
            int ang = Integer.parseInt(angulo.getText());
            if(ang>0 && ang<360 ){
             rolMenu.rotacion(360-ang, 1);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public void cambiar_undo(){
        String text = this.undo_1.getText();
        if(text == "REDO"){
            this.undo_1.setText("UNDO");
        }
    }
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(angulo.getText().equals("")){
            //Vacio el input
        }else{
            int ang = Integer.parseInt(angulo.getText());
            if(ang>0 && ang<360 ){
            rolMenu.rotacion(ang, 1);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try {
            rolMenu.SeleccionarOpcion(1);
        } catch (IOException ex) {
            Logger.getLogger(JInterfaz.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        try {
            rolMenu.SeleccionarOpcion(2);
        } catch (IOException ex) {
            Logger.getLogger(JInterfaz.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            rolMenu.SeleccionarOpcion(3);
        } catch (IOException ex) {
            Logger.getLogger(JInterfaz.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            rolMenu.SeleccionarOpcion(4);
        } catch (IOException ex) {
            Logger.getLogger(JInterfaz.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            rolMenu.SeleccionarOpcion(5);
        } catch (IOException ex) {
            Logger.getLogger(JInterfaz.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void bitsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bitsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bitsActionPerformed

    private void zoominActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zoominActionPerformed
       if (interpolacion.getSelectedItem().toString() == "Nearest"){
           rolMenu.nearest(rolMenu.actual.getWidth()*2, rolMenu.actual.getHeight()*2, 1);
       }else{
           rolMenu.bilineal(rolMenu.actual.getWidth()*2, rolMenu.actual.getHeight()*2, 1);
       }
        
    }//GEN-LAST:event_zoominActionPerformed

    private void zoomoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zoomoutActionPerformed
       if (interpolacion.getSelectedItem().toString() == "Nearest"){
            rolMenu.nearest(rolMenu.actual.getWidth()/2, rolMenu.actual.getHeight()/2, 2);
       }else{
            rolMenu.bilineal(rolMenu.actual.getWidth()/2, rolMenu.actual.getHeight()/2, 2);
       }
    }//GEN-LAST:event_zoomoutActionPerformed

    private void escalarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_escalarActionPerformed
        if(ancho.getText().equals("") || alto.getText().equals("") ){ 
            //Vacio el input
        }else{
            int anc = Integer.parseInt(ancho.getText());
            int alt = Integer.parseInt(alto.getText());
            if(anc >= 1 && alt >= 1){
                if (interpolacion.getSelectedItem().toString() == "Nearest"){
                   rolMenu.nearest(anc, alt, 3);
                }else{
                   rolMenu.bilineal(anc, alt, 3);
                }
            }
        }
    }//GEN-LAST:event_escalarActionPerformed

    private void undoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_undoActionPerformed
        rolMenu.undo();
    }//GEN-LAST:event_undoActionPerformed

    private void aplicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aplicarActionPerformed
       String seleccion = (String) efecto.getSelectedItem();
       int valor = slider.getValue();
       if(seleccion == "Brillo"){
           rolMenu.brillo(valor);
       }else if(seleccion == "Contraste"){
           rolMenu.contraste(valor);
       } else if(seleccion == "Umbralizacion"){
           rolMenu.umbralizacion(valor);
       }else{
           rolMenu.ecualizar();
       }
    }//GEN-LAST:event_aplicarActionPerformed

    private void efectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_efectoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_efectoActionPerformed

    private void Kernel_aplicarActionPerformed(ActionEvent e) {
        double divisor_real;
        try {
        divisor_real = Double.parseDouble(divisor.getText());
        rolMenu.kernel_personalizado(matriz_kernel, divisor_real, matriz_kernel.getRowCount());
        }catch(NumberFormatException exp){
            JOptionPane.showConfirmDialog(null, "Solo numeros, porfavor", "ERROR", JOptionPane.CANCEL_OPTION);
        }
    }
    
    private void filtroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtroActionPerformed
        String filtros = (String) filtro.getSelectedItem();
        if( filtros == "Personalizado"){
            aplicar_filtro.setText("Editar ");
        }else{
            aplicar_filtro.setText("Aplicar");
        }
    }//GEN-LAST:event_filtroActionPerformed

    private void aplicar_filtroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aplicar_filtroActionPerformed
        String filtros = (String) filtro.getSelectedItem();
        String tam = (String) matriz.getSelectedItem();
        int tamano_real = 0;
            if(tam.length() <= 3){
                tamano_real = Character.getNumericValue(tam.charAt(0)); 
            }else{
                String real; 
                real = new StringBuilder().append(tam.charAt(0)).append(tam.charAt(1)).toString();
                tamano_real = Integer.parseInt(real);
            }
        if(null != filtros)switch (filtros) {
            case "Box":
                rolMenu.box_blur(tamano_real);
                break;
            case "Gaussiano(Discreto)":
                rolMenu.gaussian_blur_discrete(tamano_real);
                break;
            case "Gaussiano(Normal)":
                rolMenu.gaussian_blur(tamano_real);
                break;
            case "Personalizado":
                // Creo los frames y eso //
                JFrame frame = new JFrame();
                JPanel main_panel = new JPanel();
                main_panel.setLayout(new BoxLayout(main_panel, BoxLayout.Y_AXIS));
                JPanel panel = new JPanel(); //Tendra la matriz
                // Creo una tabla segun el tamano //
                panel.setLayout(new GridLayout());  
                matriz_kernel = new JTable(tamano_real, tamano_real);
                //Inicializo la tabla con puros 0
                for(int i = 0; i < tamano_real ; i++){
                    for(int j = 0; j < tamano_real ; j++){
                        matriz_kernel.setValueAt('0',i,j);
                    }
                }
                panel.add(matriz_kernel);
                main_panel.add(panel); //Anado los textfield al panel
                JPanel panel2 = new JPanel(); //Tendra el divisor y el boton de Aplicar
                panel2.setLayout(new FlowLayout()); 
                panel2.add(new JLabel("Divisor:"));
                divisor = new JTextField();
                divisor.setColumns(5);
                panel2.add(divisor);
                panel2.add(Kernel_aplicar); //Kernel es una variable privada a la clase
                main_panel.add(panel2); //Anado el panel nuevo al principal
                frame.add(main_panel); //Anado el main_panel al frame
                frame.setSize(60*tamano_real,60*tamano_real);
                frame.setTitle("Kernel "+tamano_real+"x"+tamano_real);
                frame.setVisible(true);
                break;
            case "Prewitt":
                rolMenu.prewitt_operator(tamano_real);
                break;
            case "Sobel":
                rolMenu.sobel_operator(tamano_real);
                break;
            default:
                rolMenu.perfilado(tamano_real);
                break;
        }
            
    }//GEN-LAST:event_aplicar_filtroActionPerformed

    
    private void undo_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_undo_1ActionPerformed
        String text = this.undo_1.getText();
        if(text == "UNDO"){
            rolMenu.undo_redo(1);
            this.undo_1.setText("REDO");
        }else{
            rolMenu.undo_redo(0);
            this.undo_1.setText("UNDO");
        }
    }//GEN-LAST:event_undo_1ActionPerformed

    public static void main(String args[]) {
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Blue;
    private javax.swing.JPanel Green;
    private javax.swing.JPanel RGB;
    private javax.swing.JPanel Red;
    private javax.swing.JTextField alto;
    private javax.swing.JTextField ancho;
    private javax.swing.JTextField angulo;
    private javax.swing.JButton aplicar;
    private javax.swing.JButton aplicar_filtro;
    private javax.swing.JTextField bits;
    private javax.swing.JTextField dimensiones;
    private javax.swing.JComboBox<String> efecto;
    private javax.swing.JButton escalar;
    private javax.swing.JComboBox<String> filtro;
    private javax.swing.JComboBox<String> interpolacion;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JComboBox<String> matriz;
    private javax.swing.JTextField nombre;
    private javax.swing.JSlider slider;
    private javax.swing.JTextField tamano;
    private javax.swing.JButton undo;
    private javax.swing.JButton undo_1;
    private javax.swing.JButton zoomin;
    private javax.swing.JButton zoomout;
    // End of variables declaration//GEN-END:variables
    private JButton Kernel_aplicar;
    
    public void setValues(BufferedImage chosen_picture) {
        Image dimg = chosen_picture;
        this.jLabel1.setIcon(new ImageIcon(dimg));
    }
    
    public void setEneabled_B() {
        this.jButton1.setEnabled(true);
        this.aplicar.setEnabled(true);
        this.jButton2.setEnabled(true);
        this.aplicar_filtro.setEnabled(true);
        this.undo.setEnabled(true);
        this.jButton3.setEnabled(true);
        this.jButton4.setEnabled(true);
        this.jButton5.setEnabled(true);
        this.jButton7.setEnabled(true);
        this.zoomin.setEnabled(true);
        this.zoomout.setEnabled(true);
        this.undo_1.setEnabled(true);
        this.escalar.setEnabled(true);
        this.efecto.setEnabled(true);
    }
    
    public void colocar_datos(int ancho, int alto, float tam, String nombre){
        String  dim = ancho + "x" + alto;
        this.dimensiones.setText(dim);
        this.tamano.setText(Float.toString(tam)+" Mb");
        this.bits.setText("24");
        this.nombre.setText(nombre);
    }
    
    public void Crear_Grafica(int[] histograma,Color colorBarras, int caso, String Tipo){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        String serie = "Numero de pixeles";
        for (int i = 0; i < histograma.length; i++){
            dataset.addValue(histograma[i], serie, "" + i);
        }
        JFreeChart chart = ChartFactory.createBarChart("Histograma " + Tipo, null, null,dataset, PlotOrientation.VERTICAL, true, true, false);
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setSeriesPaint(0, colorBarras);
        chart.setAntiAlias(true);
        chart.setBackgroundPaint(new Color(226, 245, 245));
        switch (caso) {
            case 0:
                this.Red.removeAll();
                this.Red.repaint();
                this.Red.setLayout(new java.awt.BorderLayout());
                this.Red.add(new ChartPanel(chart));
                this.Red.validate();
            break;
            case 1:
                this.Green.removeAll();
                this.Green.repaint();
                this.Green.setLayout(new java.awt.BorderLayout());
                this.Green.add(new ChartPanel(chart));
                this.Green.validate();
            break;
            case 2:
                this.Blue.removeAll();
                this.Blue.repaint();
                this.Blue.setLayout(new java.awt.BorderLayout());
                this.Blue.add(new ChartPanel(chart));
                this.Blue.validate();
            break;
            case 3:
                this.RGB.removeAll();
                this.RGB.repaint();
                this.RGB.setLayout(new java.awt.BorderLayout());
                this.RGB.add(new ChartPanel(chart));
                this.RGB.validate();
            break;
        }
    }
}
