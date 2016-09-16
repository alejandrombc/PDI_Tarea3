package tarea3_pdi;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class Histograma {
    public int[][] Crear_histograma(BufferedImage chosen_picture){
        Color colorAuxiliar;
        int Auxiliar[][], i, j;
        Auxiliar = new int[4][256];
        
        for(i = 0; i < chosen_picture.getWidth(); i++ ){
            for(j = 0; j < chosen_picture.getHeight(); j++ ){
                colorAuxiliar = new Color(chosen_picture.getRGB(i, j));
                Auxiliar[0][colorAuxiliar.getRed()]+=1;
                Auxiliar[1][colorAuxiliar.getGreen()]+=1;
                Auxiliar[2][colorAuxiliar.getBlue()]+=1;
                Auxiliar[3][(int)((float)(colorAuxiliar.getRed() + colorAuxiliar.getGreen() + colorAuxiliar.getBlue()) / 3.0)]+=1;
            }
        }
        return Auxiliar;
    }
}
