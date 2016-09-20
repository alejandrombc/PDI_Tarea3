package tarea3_pdi;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import static java.lang.Math.*;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;

class JControlador {
    private final JInterfaz rolMenu;
    private final OpenFile of;
    private int Cantidad_grados = 0;
    private int Grados_actuales = 0;
    private boolean es_accion = false;
    private int pasos = 0;
    private int Tipo_imagen = 0;
    public BufferedImage actual;
    public BufferedImage undo_redo;
    public BufferedImage rotada;
    public JControlador (){
       rolMenu = new JInterfaz (this);
       of = new OpenFile();
       rolMenu.setVisible(true);
    }
    public void SeleccionarOpcion (int a) throws IOException{
        int heigth, width, i, j, aux, aux_2, aux_width, aux_heigth, temp;
        BufferedImage picture_2;
        switch (a){
            case 1: //Abrir Archivo
            of.PickMe();
            if(of.chosen_picture != null){
                pasos = 0;
                es_accion = false;
                Grados_actuales = 0;
                actual = of.chosen_picture;
                undo_redo = of.chosen_picture;
                rotada = of.chosen_picture;
                Cantidad_grados = 0;
                Tipo_imagen = 0;
                rolMenu.setValues(of.chosen_picture);
                rolMenu.setEneabled_B();
                rolMenu.colocar_datos(of.chosen_picture.getWidth(), of.chosen_picture.getHeight(), of.tamano, of.nombre);
                try {
                    SeleccionarOpcion(9);
                } catch (IOException ex) {
                    Logger.getLogger(JControlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;      
            case 2: //Guardar Archivo
                int pasos_nuevo = pasos;
                while (pasos_nuevo != 0){
                    if(pasos_nuevo > 0){
                       bilineal(actual.getWidth()/2,actual.getHeight()/2, 2);
                       pasos_nuevo--;
                    }else{
                       bilineal(actual.getWidth()*2,actual.getHeight()*2, 2);
                       pasos_nuevo++;
                    }
                }
                heigth = of.chosen_picture.getHeight();
                width = of.chosen_picture.getWidth();
                picture_2 = new BufferedImage(width, heigth, BufferedImage.TYPE_INT_RGB);
                picture_2 = of.chosen_picture;
                of.chosen_picture = actual;
                es_accion = false;
                of.saveImage();
                of.chosen_picture = picture_2;
                pasos = 0;
            break;
            case 3: //Espejo Horizontal
                heigth = actual.getHeight();
                width = actual.getWidth();
                picture_2 = new BufferedImage(width, heigth, BufferedImage.TYPE_INT_RGB);
                aux = width - 1;
                for(i = 0; i < heigth; i++){
                    for(j = 0; j < width; j++){
                        temp = actual.getRGB(aux, i);
                        picture_2.setRGB(j, i, temp);
                        aux--;
                    }
                     aux = width - 1;
                }
                rolMenu.cambiar_undo();
                es_accion = true;
                undo_redo = actual;
                actual = picture_2;
                rolMenu.setValues(actual);
                if(Tipo_imagen == 2) rotacion(0, 2);
            break;
            case 4: //Espejo Vertical
                heigth = actual.getHeight();
                width = actual.getWidth();
                picture_2 = new BufferedImage(width, heigth, BufferedImage.TYPE_INT_RGB);
                aux = heigth - 1;
                for(i = 0; i < heigth; i++){
                    for(j = 0; j < width; j++){
                        temp = actual.getRGB(j, aux);
                        picture_2.setRGB(j, i, temp);
                    }
                    aux--;
                }
                es_accion = true;
                rolMenu.cambiar_undo();
                undo_redo = actual;
                actual = picture_2;
                rolMenu.setValues(actual);
                if(Tipo_imagen == 2) rotacion(0, 2);
            break;
            case 5: //Negativo
                int rgb;
                Color myWhite;
                heigth = actual.getHeight();
                width = actual.getWidth();
                myWhite = new Color(255, 255, 255);
                rgb = myWhite.getRGB();
                picture_2 = new BufferedImage(width, heigth, BufferedImage.TYPE_INT_RGB);
                for(i = 0; i < width; i++){
                    for(j = 0; j < heigth; j++){
                        aux = rgb - actual.getRGB(i, j);
                        picture_2.setRGB(i, j, aux);
                    }
                }
                es_accion = true;
                rolMenu.cambiar_undo();
                undo_redo = actual;
                actual = picture_2;
                rolMenu.setValues(actual);
                if(Tipo_imagen == 2) rotacion(0, 2);
                try {
                    SeleccionarOpcion(9);
                } catch (IOException ex) {
                    Logger.getLogger(JControlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            break;
            case 6:
                heigth = actual.getHeight();
                width = actual.getWidth();
                picture_2 = new BufferedImage(heigth, width, BufferedImage.TYPE_INT_RGB);
                aux_width = 0;
                aux_heigth = width - 1;
                for(i = 0; i < width; i++){
                    for(j = 0; j < heigth; j++){
                        temp = actual.getRGB(i, j);
                        picture_2.setRGB(aux_width, aux_heigth, temp);
                        aux_width++;
                    }
                    aux_heigth--;
                    aux_width = 0;
                }
                rotada = picture_2;
            break;
            case 9: //Histograma
                Histograma MyHistograma = new Histograma();
                int[][] histograma = MyHistograma.Crear_histograma(actual);
                for (i = 0; i < 4; i++) {
                    int[] histogramaCanal = new int[256];
                    System.arraycopy(histograma[i], 0, histogramaCanal, 0, histograma[i].length);
                    switch(i){
                        case 0:
                            rolMenu.Crear_Grafica(histogramaCanal, Color.red, 0, "Red");
                            break;
                        case 1:
                            rolMenu.Crear_Grafica(histogramaCanal, Color.green, 1, "Green");
                            break;
                        case 2:
                            rolMenu.Crear_Grafica(histogramaCanal, Color.blue, 2, "Blue");
                            break;
                        case 3:
                            rolMenu.Crear_Grafica(histogramaCanal, Color.gray, 3, "RGB");
                            break;
                    }
                }
            break;
        }
    }
    
    void brillo(int valor){
        int heigth, width, i, j, temp, r, g, b;
        BufferedImage picture_2;
        Color true_color;
        if(Tipo_imagen == 0) Tipo_imagen = 1;
        heigth = actual.getHeight();
        width = actual.getWidth();
        picture_2 = new BufferedImage(width, heigth, BufferedImage.TYPE_INT_RGB);
        
        for(i = 0; i < width; i++){
            for(j = 0; j < heigth; j++){
                Color c = new Color(actual.getRGB(i, j),true);
                r = c.getRed() +  valor;
                g = c.getGreen() + valor;
                b = c.getBlue() + valor;
                if(r > 255) r = 255;
                
                if(g > 255) g = 255;
                                
                if(b > 255) b = 255;
                
                if(r < 0) r = 0;
                
                if(g < 0) g = 0;
                                
                if(b < 0) b = 0;
                
                true_color = new Color(r,g,b);
                temp = true_color.getRGB();
                picture_2.setRGB(i, j, temp);
            }
        }
        es_accion = true;
        rolMenu.cambiar_undo();
        undo_redo = actual;
        actual = picture_2;
        rolMenu.setValues(actual);
        if(Tipo_imagen == 2) rotacion(0, 2);

        try {
            SeleccionarOpcion(9);
        } catch (IOException ex) {
            Logger.getLogger(JControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void umbralizacion(int valor){
        int heigth, width, i, j, temp, r, g, b;
        BufferedImage picture_2;
        Color true_color;
        if(Tipo_imagen == 0) Tipo_imagen = 1;
        heigth = actual.getHeight();
        width = actual.getWidth();
        picture_2 = new BufferedImage(width, heigth, BufferedImage.TYPE_INT_RGB);
        
        if(valor < 0) valor = 0;
        
        for(i = 0; i < width; i++){
            for(j = 0; j < heigth; j++){
                Color c = new Color(actual.getRGB(i, j),true);
                r = c.getRed();
                g = c.getGreen();
                b = c.getBlue();

                if(((r + g + b) /3)> valor){ r = 255; g = 255; b = 255; }else{
                    r = 0; g = 0; b = 0;
                }

                true_color = new Color(r,g,b);
                temp = true_color.getRGB();
                picture_2.setRGB(i, j, temp);
            }
        }
        es_accion = true;
        undo_redo = actual;
        actual = picture_2;
        rolMenu.cambiar_undo();
        rolMenu.setValues(actual);
        if(Tipo_imagen == 2) rotacion(0, 2);
        
        try {
            SeleccionarOpcion(9);
        } catch (IOException ex) {
            Logger.getLogger(JControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void contraste(int valor){
        int heigth, width, i, j, temp, r, g, b;
        BufferedImage picture_2;
        float factor_contraste;
        Color true_color;
        if(Tipo_imagen == 0) Tipo_imagen = 1;
       
        heigth = actual.getHeight();
        width = actual.getWidth();
        picture_2 = new BufferedImage(width, heigth, BufferedImage.TYPE_INT_RGB);
        factor_contraste = (float)(259*(valor + 255))/(float)(255*(259 - valor));
        
        for(i = 0; i < width; i++){
            for(j = 0; j < heigth; j++){
                Color c = new Color(actual.getRGB(i, j),true);
                r = (int) (factor_contraste*(c.getRed() - 128) + 128);
                g = (int) (factor_contraste*(c.getGreen() - 128) + 128);
                b = (int) (factor_contraste*(c.getBlue() - 128) + 128);

                if(r > 255) r = 255;
                
                if(g > 255) g = 255;

                if(b > 255) b = 255;

                if(r < 0) r = 0;

                if(g < 0) g = 0;

                if(b < 0) b = 0;

                true_color = new Color(r,g,b);
                temp = true_color.getRGB();
                picture_2.setRGB(i, j, temp);
            }
        }
        
        undo_redo = actual;
        actual = picture_2;
        es_accion = true;
        rotada = actual;
        rolMenu.cambiar_undo();
        rolMenu.setValues(actual);
        if(Tipo_imagen == 2) rotacion(0, 2);
      
        try {
            SeleccionarOpcion(9);
        } catch (IOException ex) {
            Logger.getLogger(JControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void ecualizar(){
        int heigth, width, i, j, histograma[][], histogramaR[], histogramaG[], histogramaB[], red, green, blue, newPixel;
        int histogramaR_reemplazo[], histogramaG_reemplazo[], histogramaB_reemplazo[], acum_r, acum_g, acum_b;
        float factor;
        BufferedImage histogramEQ;
        Histograma MyHistograma;
        if(Tipo_imagen == 0) Tipo_imagen = 1;
        heigth = actual.getHeight();
        width = actual.getWidth();
        
        MyHistograma = new Histograma();
        histograma = MyHistograma.Crear_histograma(actual);
        
        histogramaR = new int[256];
        histogramaG = new int[256];
        histogramaB = new int[256];
        
        histogramaR_reemplazo = new int[256];
        histogramaG_reemplazo = new int[256];
        histogramaB_reemplazo = new int[256];
        
        System.arraycopy(histograma[0], 0, histogramaR, 0, histograma[0].length);
        System.arraycopy(histograma[1], 0, histogramaG, 0, histograma[1].length);
        System.arraycopy(histograma[2], 0, histogramaB, 0, histograma[2].length);
        
        for(i=0; i<256; i++) histogramaR_reemplazo[i] = 0;
        for(i=0; i<256; i++) histogramaG_reemplazo[i] = 0;
        for(i=0; i<256; i++) histogramaB_reemplazo[i] = 0;
        
        factor = (float) ((255.0)/(width*heigth));
        acum_r = 0; acum_g = 0; acum_b = 0;
        
        for(i = 0; i < 256; i++){
            acum_r += histogramaR[i];
            histogramaR_reemplazo[i] = (int) (acum_r * factor);
            
            if(histogramaR_reemplazo[i] > 255) histogramaR_reemplazo[i] = 255;
            
            acum_g += histogramaG[i];
            histogramaG_reemplazo[i] = (int) (acum_g * factor);
            
            if(histogramaG_reemplazo[i] > 255) histogramaG_reemplazo[i] = 255;
           
            acum_b += histogramaB[i];
            histogramaB_reemplazo[i] = (int) (acum_b * factor);
            
            if(histogramaB_reemplazo[i] > 255) histogramaB_reemplazo[i] = 255;
        }
        
        //Asignacion a la imagen
        histogramEQ = new BufferedImage(width, heigth, BufferedImage.TYPE_INT_RGB);
        
        for(i = 0; i < width; i++) {
            for(j = 0; j < heigth; j++) {
                red = new Color(actual.getRGB (i, j)).getRed();
                green = new Color(actual.getRGB (i, j)).getGreen();
                blue = new Color(actual.getRGB (i, j)).getBlue();
 
                red = histogramaR_reemplazo[red];
                green = histogramaG_reemplazo[green];
                blue = histogramaB_reemplazo[blue];
                
                Color c = new Color(red, green, blue);
                newPixel = c.getRGB();
                histogramEQ.setRGB(i, j, newPixel);
            }
        }
 
        rolMenu.setValues(histogramEQ);
        undo_redo = actual;
        rolMenu.cambiar_undo();
        es_accion = true;
        actual = histogramEQ;
        if(Tipo_imagen == 2) rotacion(0, 2);
        try {
            SeleccionarOpcion(9);
        } catch (IOException ex) {
            Logger.getLogger(JControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
         
    void bilineal (int ancho_nuevo, int alto_nuevo, int tipo)
    {
        BufferedImage picture_2;
        int h, w;
        if(tipo == 3){
            h = of.chosen_picture.getHeight(); w = of.chosen_picture.getWidth();
        }else{
            h = actual.getHeight(); w = actual.getWidth();
        }
        if((alto_nuevo>60 || ancho_nuevo>60)&&(alto_nuevo<5698 || ancho_nuevo<5698)){
            if(tipo == 1){
                pasos++;
            }
            if(tipo == 2){
                pasos--;
            }
            if(tipo == 3){
                pasos = 0;
            }
            int[] pixels = new int[h*w];
            int aux_i = 0;
            for( int i = 0; i < h; i++ ){
                    for( int j = 0; j < w; j++ ){
                        if(tipo == 3) pixels[aux_i] = of.chosen_picture.getRGB( j, i );
                        else pixels[aux_i] = actual.getRGB( j, i );
                        aux_i++;
                    }
            }
            int[] temp = new int[ancho_nuevo*alto_nuevo] ;
            int a, b, c, d, x, y, index ;
            float x_ratio = ((float)(w-1))/ancho_nuevo ;
            float y_ratio = ((float)(h-1))/alto_nuevo ;
            float x_diff, y_diff, blue, red, green ;
            int offset = 0 ;
            for (int i=0;i<alto_nuevo;i++) {
                for (int j=0;j<ancho_nuevo;j++) {
                    x = (int)(x_ratio * j) ;
                    y = (int)(y_ratio * i) ;
                    x_diff = (x_ratio * j) - x ;
                    y_diff = (y_ratio * i) - y ;
                    index = (y*w+x) ;                
                    a = pixels[index] ;
                    b = pixels[index+1] ;
                    c = pixels[index+w] ;
                    d = pixels[index+w+1] ;

                    blue = (a&0xff)*(1-x_diff)*(1-y_diff) + (b&0xff)*(x_diff)*(1-y_diff) +
                           (c&0xff)*(y_diff)*(1-x_diff)   + (d&0xff)*(x_diff*y_diff);

                    green = ((a>>8)&0xff)*(1-x_diff)*(1-y_diff) + ((b>>8)&0xff)*(x_diff)*(1-y_diff) +
                            ((c>>8)&0xff)*(y_diff)*(1-x_diff)   + ((d>>8)&0xff)*(x_diff*y_diff);

                    red = ((a>>16)&0xff)*(1-x_diff)*(1-y_diff) + ((b>>16)&0xff)*(x_diff)*(1-y_diff) +
                          ((c>>16)&0xff)*(y_diff)*(1-x_diff)   + ((d>>16)&0xff)*(x_diff*y_diff);

                    temp[offset++] = 
                            0xff000000 | 
                            ((((int)red)<<16)&0xff0000) |
                            ((((int)green)<<8)&0xff00) |
                            ((int)blue) ;
                }
            }
            picture_2 = new BufferedImage(ancho_nuevo, alto_nuevo, BufferedImage.TYPE_INT_RGB);
            aux_i = 0;
            for( int i = 0; i < alto_nuevo; i++ ){
                    for( int j = 0; j < ancho_nuevo; j++ ){
                        picture_2.setRGB(j, i, temp[aux_i]);
                        aux_i++;
                    }
            }
            undo_redo = actual;
            rolMenu.cambiar_undo();
            es_accion = true;
            actual = picture_2 ;
            if(tipo == 3){
                of.chosen_picture = picture_2;
                rolMenu.colocar_datos(of.chosen_picture.getWidth(), of.chosen_picture.getHeight(), of.tamano, of.nombre);
            }
            rolMenu.setValues(actual);
            if(Tipo_imagen == 2) rotacion(0, 2);
        }
    }
    
    void nearest(int ancho_nuevo,int alto_nuevo, int tipo) {
        BufferedImage picture_2;
        int h, w;
        if(tipo == 3){
            h = of.chosen_picture.getHeight(); w = of.chosen_picture.getWidth();
        }else{
            h = actual.getHeight(); w = actual.getWidth();
        }
        
        if((alto_nuevo>60 || ancho_nuevo>60)&&(alto_nuevo<5698 || ancho_nuevo<5698)){
            if(tipo == 1){
                pasos++;
            }
            if(tipo == 2){
                pasos--;
            }
            if(tipo == 3){
                pasos = 0;
            }
            int[] pixels = new int[h*w];
            int aux_i = 0;
            for( int i = 0; i < h; i++ ){
                    for( int j = 0; j < w; j++ ){
                        if(tipo == 3) pixels[aux_i] = of.chosen_picture.getRGB( j, i );
                        else pixels[aux_i] = actual.getRGB( j, i );
                        aux_i++;
                    }
            }
            int[] temp = new int[ancho_nuevo*alto_nuevo] ;
            int x_ratio = (int)((w<<16)/ancho_nuevo) +1;
            int y_ratio = (int)((h<<16)/alto_nuevo) +1;
            int x2, y2 ;
            for (int i=0;i<alto_nuevo;i++) {
                for (int j=0;j<ancho_nuevo;j++) {
                    x2 = ((j*x_ratio)>>16) ;
                    y2 = ((i*y_ratio)>>16) ;
                    temp[(i*ancho_nuevo)+j] = pixels[(y2*w)+x2] ;
                }                
            }                
            picture_2 = new BufferedImage(ancho_nuevo, alto_nuevo, BufferedImage.TYPE_INT_RGB);
            aux_i = 0;
            for( int i = 0; i < alto_nuevo; i++ ){
                    for( int j = 0; j < ancho_nuevo; j++ ){
                        picture_2.setRGB(j, i, temp[aux_i]);
                        aux_i++;
                    }
            }
            undo_redo = actual;
            actual = picture_2;
            
            rolMenu.cambiar_undo();
            rotada = picture_2;
            es_accion = true;
            if(tipo == 3){
                of.chosen_picture = picture_2;
                rolMenu.colocar_datos(of.chosen_picture.getWidth(), of.chosen_picture.getHeight(), of.tamano, of.nombre);
            }
            rolMenu.setValues(actual);
            if(Tipo_imagen == 2) rotacion(0, 2);
          }
    }
    
    void rotacion(int angulo, int tipo){
        if(angulo != 0){
            es_accion = false;
            Grados_actuales = angulo;
        }
      
        if(tipo == 1)
            Tipo_imagen = 2;
        
        Cantidad_grados+=angulo;
        if(Cantidad_grados > 360){
            Cantidad_grados-=360;
            rotada = actual;
        }
        if(Cantidad_grados < 90){
            rotada = actual;
        }
        if(!es_accion) undo_redo = actual;
        
        angulo = Cantidad_grados;
        
        System.out.println("CANT DE GRADOS EN ROTACION: "+Cantidad_grados);
        System.out.println("CANT DE GRADOACTUAL EN ROTACION: "+Grados_actuales);

        int cantidad = 0;
        while(angulo >= 90){
            cantidad +=1;
            angulo -= 90;
        }
        int casos = 0;
        while(cantidad != 0){
            if (casos != 0) {
                int heigth, width, i, j, aux_width, aux_heigth, temp;
                BufferedImage picture_2;
                heigth = rotada.getHeight();
                width = rotada.getWidth();
                picture_2 = new BufferedImage(heigth, width, BufferedImage.TYPE_INT_RGB);
                aux_width = 0;
                aux_heigth = width - 1;
                for(i = 0; i < width; i++){
                    for(j = 0; j < heigth; j++){
                        temp = rotada.getRGB(i, j);
                        picture_2.setRGB(aux_width, aux_heigth, temp);
                        aux_width++;
                    }
                    aux_heigth--;
                    aux_width = 0;
                }
                
                rotada = picture_2;
                
            }else{
            try {
                SeleccionarOpcion(6);
            } catch (IOException ex) {
                Logger.getLogger(JControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
            casos ++;

            }
            cantidad -=1;
        }
        double sen = Math.sin(Math.toRadians(angulo));
        double tan = Math.tan(Math.toRadians(angulo/2));
        
        int i, j, x2 = 0, y2 = 0, temp;
        int h = rotada.getHeight(); int w = rotada.getWidth();
        int dist = (int)(Math.ceil(Math.sqrt((h*h)+(w*w))));

        
        BufferedImage picture_2;
      
        picture_2 = new BufferedImage(dist, dist, BufferedImage.TYPE_INT_RGB);
        Color blanco = new Color(238, 238, 238);
        int rgb = blanco.getRGB();
        for(i = 0; i < dist; i++){
            for(j = 0; j < dist; j++){
                picture_2.setRGB(i, j, rgb);
            }
        }
        int x0= (int)(Math.floor((w)/2));
        int y0= (int)(Math.floor((h)/2));
        for(i = 0; i < w; i++){
                for(j = 0; j < h; j++){ 
                    temp = rotada.getRGB(i, j);
                    
                    x2 = (int)((i-x0) - tan*(y0-j));
                    y2 = (int)(y0-j);
                    
                    y2 = (int)((sen*x2) + y2);
                    
                    x2 = (int)((x2) - tan*(y2))+((dist/2));
                    y2 = (int)(-y2)+((dist/2));
                    
                    if(x2 < dist && y2 < dist && x2 > -1 && y2 > -1) picture_2.setRGB(x2, y2, temp);
                    x2 = 0;
                    y2 = 0;
                }
                
        }
        rotada = picture_2;
        rolMenu.cambiar_undo();
        rolMenu.setValues(rotada);
    }
 
    void undo(){
        actual = of.chosen_picture;
        undo_redo = of.chosen_picture;
        rolMenu.setValues(actual);
        rolMenu.cambiar_undo();
        Cantidad_grados = 0;
        es_accion = true;
        Tipo_imagen = 1;
        try {
            SeleccionarOpcion(9);
        } catch (IOException ex) {
            Logger.getLogger(JControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    void aplicacion_convolucion(int tam, double[][] matriz_convolucion){
       int height = actual.getHeight();
       int width = actual.getWidth();
       if(Tipo_imagen == 0) Tipo_imagen = 1;
       if(height > tam && width > tam){
       BufferedImage picture_2;
       
       picture_2 = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
       
        for(int x = 0; x < width; x++)
            for(int y = 0; y < height; y++)
            {
              double red = 0.0, green = 0.0, blue = 0.0;

              for(int filterX = 0; filterX < tam; filterX++)
                for(int filterY = 0; filterY < tam; filterY++)
                {
                  int imageX = ((x - tam / 2 + filterX + width) % width);
                  int imageY = ((y - tam / 2 + filterY + height) % height);
                  Color c = new Color(actual.getRGB(imageX, imageY),true);
                  
                  red += c.getRed() * matriz_convolucion[filterX][filterY];
                  green += c.getGreen() * matriz_convolucion[filterX][filterY];;
                  blue += c.getBlue() * matriz_convolucion[filterX][filterY];;
                }
              
              Color myColor = new Color(min(max((int)red,0),255), min(max((int)green,0),255), min(max((int)blue,0),255));
              int temp = myColor.getRGB();
              picture_2.setRGB(x, y, temp);
            }
        
        undo_redo = actual;
        es_accion = true;
        rolMenu.cambiar_undo();
        actual = picture_2;
        rolMenu.setValues(actual);
        if(Tipo_imagen == 2) rotacion(0, 2);
        try {
            SeleccionarOpcion(9);
        } catch (IOException ex) {
            Logger.getLogger(JControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      }
    }
 
    void box_blur(int tam){
       double [][] matriz_convolucion = new double[tam][tam];
       double factor = 1.0/pow(tam,2);
       for (int i = 0; i < tam; i ++){
           for(int j = 0; j < tam; j ++){
               matriz_convolucion[i][j] = factor;
           }
       }
       aplicacion_convolucion(tam, matriz_convolucion);
    }
    
     int[][] transpuesta (int a [][], int n, int m){   
        int i, j;
        int[][] b = new int[m][n];
        for (i = 0 ; i < m ; i++)
        {
            for (j = 0 ; j < n ; j++){
                b[i][j] = a [j][i]; 
            }
        }
        
        return b;
    }
    
    void gaussian_blur(int tam){
       double [][] matriz_convolucion = new double[tam][tam];
       double media = tam/2;
       double sum = 0.0;
       double desv_std = 1.0;
       double Pi = 3.14159265359;
       for (int i = 0; i < tam; i ++){
           for(int j = 0; j < tam; j ++){
            matriz_convolucion[i][j] = exp( -0.5 * (pow((i-media)/desv_std, 2.0) + pow((j-media)/desv_std,2.0)) )
              / (2 * Pi);
                sum += matriz_convolucion[i][j];
           }
       }
       
       for (int i = 0; i < tam; ++i)
         for (int j = 0; j < tam; ++j)
            matriz_convolucion[i][j] /= sum;
       
       aplicacion_convolucion(tam, matriz_convolucion);  
    }
    
    void gaussian_blur_discrete(int tam){
        double factor = 0.25; //Factor para multiplicar
        int limit = tam-3; //Limite de veces que se sacara el arreglo
        int [][] pascal_triangle = new int [tam][1]; //Arreglo de pascal
        int [][] aux = new int [tam][1]; //Auxiliar que tendra el anterior
        int tope = 4; //Tope inicial (Ya que inicio en la 3era iteracion del triangulo)
        aux[0][0] = 1; aux[1][0] = 2; aux[2][0] = 1; 
        pascal_triangle[0][0] = 1; pascal_triangle[1][0] = 2; pascal_triangle[2][0] = 1; 
        for(int i = 0; i < limit; i++){ 
            for(int j = 0; j < tope; j++){
                if(j == 0){ //Si es la primera pongo 1
                    pascal_triangle[j][0] = 1;
                }else if(j == tope-1){ //Si es la ultima pongo 1 guardo mi nuevo aux
                    pascal_triangle[j][0] = 1;
                    for (int k = 0; k < tope; k++ ) {
                        aux[k][0] = pascal_triangle[k][0];
                    }
                }else{ //Si no es ninguna sumo el anterior con el actual de aux
                    pascal_triangle[j][0] = aux[j-1][0] + aux[j][0];
                }
            }
            factor = factor * 0.5;
            tope++; //Lo hare de nuevo asi que tengo un nuevo tope
        }
        //Trnaspongo el arreglo para su multiplicacion
        int [][] pascal_triangle_trans = transpuesta(pascal_triangle, tam, 1);
        double[][] pascal_matrix = new double[tam][tam];
        factor = factor * factor;
        //Multiplico ambas matrices con el factor para tener el kernel
        for (int i = 0; i < pascal_triangle.length; i++){
            for (int j = 0; j < pascal_triangle_trans[0].length; j++){
               for (int k = 0; k < pascal_triangle[0].length; k++){
                  pascal_matrix[i][j] += pascal_triangle[i][k] * pascal_triangle_trans[k][j];
                }
               pascal_matrix[i][j] = pascal_matrix[i][j] * factor;
            }
        }
        
        aplicacion_convolucion(tam, pascal_matrix);  
    }
    
    void undo_redo(int opcion){
        if(opcion == 1){
            if(Tipo_imagen == 0) Tipo_imagen = 1;
            if(!es_accion){
                Cantidad_grados = Cantidad_grados - Grados_actuales;
                if(Cantidad_grados < 0) Cantidad_grados = 360 + Cantidad_grados;
            }
            BufferedImage temp;
            int width = actual.getWidth();
            int heigth = actual.getHeight();
            temp = new BufferedImage(width, heigth, BufferedImage.TYPE_INT_RGB);
            temp = actual;
            actual = undo_redo;
            undo_redo = temp;
            rolMenu.setValues(actual);
            if(Tipo_imagen == 2) rotacion(0, 2);
            try {
                SeleccionarOpcion(9);
            } catch (IOException ex) {
                Logger.getLogger(JControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            if(Tipo_imagen == 0) Tipo_imagen = 1;
            if(!es_accion){
                Cantidad_grados = Cantidad_grados + Grados_actuales;
                if(Cantidad_grados > 360) Cantidad_grados = Cantidad_grados - 360;
            }
            BufferedImage temp;
            int width = actual.getWidth();
            int heigth = actual.getHeight();
            temp = new BufferedImage(width, heigth, BufferedImage.TYPE_INT_RGB);
            temp = undo_redo;
            undo_redo = actual;
            actual = temp;
            rolMenu.setValues(actual);
            if(Tipo_imagen == 2) rotacion(0, 2);
            try {
                SeleccionarOpcion(9);
            } catch (IOException ex) {
                Logger.getLogger(JControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    void kernel_personalizado(JTable matriz, double divisor, int tam){
        double [][] matriz_de_convolucion = new double[tam][tam];
        try{
            for (int i = 0; i < tam; i++){
                for (int j = 0; j < tam; j++){
                    matriz_de_convolucion[i][j] = Double.parseDouble(matriz.getValueAt(i, j).toString())*divisor;
                }
            }

            aplicacion_convolucion(tam, matriz_de_convolucion);
        }catch(NumberFormatException exp){
            JOptionPane.showConfirmDialog(null, "Solo numeros, porfavor", "ERROR", JOptionPane.CANCEL_OPTION);
        }
    }
        
    BufferedImage greyscale(){
        int height = actual.getHeight();
        int width = actual.getWidth();
        BufferedImage picture_2;
       
       picture_2 = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
       
        for(int i=0; i<height; i++){
         
            for(int j=0; j<width; j++){
            
               Color c = new Color(actual.getRGB(j, i));
               int red = (int)(c.getRed() * 0.299);
               int green = (int)(c.getGreen() * 0.587);
               int blue = (int)(c.getBlue() *0.114);
               Color newColor = new Color(red+green+blue,
               
               red+green+blue,red+green+blue);
               
               picture_2.setRGB(j,i,newColor.getRGB());
            }
         }
        
        return picture_2;
         
    }
    
    void aplicacion_bordes(int tam, double[][] matriz_1, double[][] matriz_2){
       double red_1 = 0.0, red_2 = 0.0, green_1 = 0.0, green_2 = 0.0, blue_1 = 0.0, blue_2 = 0.0, red_f = 0.0, green_f = 0.0, blue_f = 0.0;
       int height = actual.getHeight();
       int width = actual.getWidth();
       if(Tipo_imagen == 0) Tipo_imagen = 1;
       if(height > tam && width > tam){
       BufferedImage picture_2, picture_auxiliar;
       
       picture_2 = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
       picture_auxiliar = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
       picture_auxiliar = greyscale();
        for(int x = 0; x < width; x++)
            for(int y = 0; y < height; y++)
            {
              red_1 = 0.0; red_2 = 0.0; green_1 = 0.0; green_2 = 0.0; blue_1 = 0.0; blue_2 = 0.0;

                for(int filterX = 0; filterX < tam; filterX++)
                    for(int filterY = 0; filterY < tam; filterY++)
                    {
                        int imageX = ((x - tam / 2 + filterX + width) % width);
                        int imageY = ((y - tam / 2 + filterY + height) % height);
                        Color c = new Color(picture_auxiliar.getRGB(imageX, imageY),true);

                        red_1 += c.getRed() * matriz_1[filterX][filterY];
                        green_1 += c.getGreen() * matriz_1[filterX][filterY];
                        blue_1 += c.getBlue() * matriz_1[filterX][filterY];

                        red_2 += c.getRed() * matriz_2[filterX][filterY];
                        green_2 += c.getGreen() * matriz_2[filterX][filterY];
                        blue_2 += c.getBlue() * matriz_2[filterX][filterY];
                      }
                red_f = sqrt(pow((float)abs(red_1),2.0) + pow((float)abs(red_2),2.0));
                green_f = sqrt(pow((float)abs(green_1),2.0) + pow((float)abs(green_2),2.0));
                blue_f = sqrt(pow((float)abs(blue_1),2.0) + pow((float)abs(blue_2),2.0));
                
                Color myColor = new Color((int)min((float) red_f,255), (int)min((float) green_f,255), (int)min((float) blue_f,255));
                int temp = myColor.getRGB();

                picture_2.setRGB(x, y, temp);
            }
        es_accion = true;
        undo_redo = actual;
        actual = picture_2;
        rolMenu.cambiar_undo();
        rolMenu.setValues(actual); 
        if(Tipo_imagen == 2) rotacion(0, 2);
        try {
            SeleccionarOpcion(9);
        } catch (IOException ex) {
            Logger.getLogger(JControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      }
    }

    void prewitt_operator(int tam){
       double [][] matriz_1 = new double[tam][tam], matriz_2 = new double[tam][tam];
       double factor = -Math.floor(tam/2.0);
       
        for (int i = 0; i < tam; i ++){
            for(int j = 0; j < tam; j ++)
            {
                matriz_1[j][i] = factor;
                matriz_2[i][j] = factor;
            }
              
            factor++;
        }
        
        aplicacion_bordes(tam, matriz_1, matriz_2);
    }
    
    void sobel_operator(int tam){
       double [][] matriz_1 = new double[tam][tam], matriz_2 = new double[tam][tam];
       double factor = -Math.floor(tam/2.0);
       int i, j, mitad = (tam / 2);
       
       
        for(j = tam - 1; j >= 0; j --)
        {
            if(j == mitad)
                factor = 0;
            
            if(j < mitad)
                factor++;
            
            for (i = 0; i < tam; i ++)
            {
                matriz_1[i][j] = factor;
                matriz_2[j][i] = factor;
              
                if(j > mitad)
                    if(i < mitad)
                        factor--;
                    else
                        factor++;
                else
                    if(j < mitad)
                        if(i < mitad)
                            factor++;
                        else
                            if(i != tam -1)
                                factor--;
            }
        }
 
        aplicacion_bordes(tam, matriz_1, matriz_2);
    }

    void perfilado(int tam){
        double [][] matriz_1 = new double[tam][tam];
        int i, j, mitad = (tam / 2);
       
       
         for (i = 0; i < tam; i ++){
            for(j = 0; j < tam; j ++)
            {
                if(i == mitad && j == mitad)
                    matriz_1[j][i] = (pow(tam, 2.0));
                else  
                    matriz_1[j][i] = (-1);
               
            }
        }
     
        aplicacion_convolucion(tam, matriz_1);
    }
    
}

