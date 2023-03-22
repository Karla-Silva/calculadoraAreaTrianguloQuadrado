package service;

import model.Quadrado;
import model.Triangulo;

public class CalculadoraService {
    public int somar(int a, int b) {
        return a+b;
    }

    public int subtrair(int a, int b) {
        return a-b;
    }

    public int dividir(int a, int b) {
        return a/b;
    }

    public int multiplicar(int a, int b) {
        return a*b;
    }

    public double calcularArea(Object figuraGeometrica) {
        double area;
        if(figuraGeometrica.getClass().getName()=="model.Triangulo"){
            Triangulo triangulo = (Triangulo) figuraGeometrica;
            area = (triangulo.getAltura()*triangulo.getBase()/2);
        }else {
            Quadrado quadrado = (Quadrado) figuraGeometrica;
            area = (quadrado.getLado()*quadrado.getLado());
        }
        return area;
    }

    // Caso seja de area igual, retorna null
    public Triangulo trianguloDeMenorArea(Triangulo triangulo1, Triangulo triangulo2) {
        double area1 = calcularArea(triangulo1);
        double area2 = calcularArea(triangulo2);
        if(area1<area2){
            return triangulo1;
        } else if (area2<area1) {
            return triangulo2;
        } else {
            return null;
        }
    }

    public Quadrado quadradoDeMenorArea(Quadrado quadrado1, Quadrado quadrado2) {
        double area1 = calcularArea(quadrado1);
        double area2 = calcularArea(quadrado2);
        if(area1<area2){
            return quadrado1;
        } else if (area2<area1) {
            return quadrado2;
        } else {
            return null;
        }
    }

}
