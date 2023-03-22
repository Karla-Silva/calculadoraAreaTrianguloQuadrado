package service;

import model.Quadrado;
import model.Triangulo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculadoraServiceTest {
    CalculadoraService calculadoraService = new CalculadoraService();

    int a;
    int b;

    @Before
    public void before() {
        a = 8;
        b = 2;
    }

    @Test
    public void deveSomarCorretamente() {
        //Given
        //When
        int resultado = calculadoraService.somar(a, b);

        //Then
        Assert.assertEquals(a + b, resultado);
    }


    @Test
    public void deveSubtrairCorretamente () {
        int resultado = calculadoraService.subtrair(a, b);

        Assert.assertEquals(a-b, resultado);

    }

    @Test
    public void deveDividirCorretamente () {
        int resultado = calculadoraService.dividir(a, b);

        Assert.assertEquals(a/b, resultado);
    }

    @Test
    public void deveMultiplicarCorretamente () {
        int resultado = calculadoraService.multiplicar(a, b);

        Assert.assertEquals(a*b, resultado);

    }
    @Test
    public void deveCalcularAreadoQuadradoCorretamente (){
        //Given
        Quadrado quadrado = new Quadrado();
        quadrado.setLado(a);

        //When
        double areaDoQuadrado = calculadoraService.calcularArea(quadrado);

        //Then
        Assert.assertTrue(areaDoQuadrado==a*a);
    }

    @Test
    public void deveCalcularAreaDoTrianguloCorretamente(){
        //Given
        Triangulo triangulo = new Triangulo();
        triangulo.setBase(a);
        triangulo.setAltura(b);

        //When
        double areaDoTriangulo = calculadoraService.calcularArea(triangulo);

        //Then
        Assert.assertTrue(areaDoTriangulo==a*b/2);
    }
    @Test
    public void deveRetornarOTrianguloDeMenorArea(){
        //Given
        Triangulo trianguloMenor = new Triangulo();
        Triangulo trianguloMaior = new Triangulo();

        trianguloMenor.setBase(2);
        trianguloMenor.setAltura(2);

        trianguloMaior.setBase(5);
        trianguloMaior.setAltura(5);

        //When
        Triangulo areaMenor1 = calculadoraService.trianguloDeMenorArea(trianguloMenor,trianguloMaior);
        Triangulo areaMenor2 = calculadoraService.trianguloDeMenorArea(trianguloMaior,trianguloMenor);
        Triangulo areaIgual = calculadoraService.trianguloDeMenorArea(trianguloMenor,trianguloMenor);

        //Then
        Assert.assertSame(areaMenor1,trianguloMenor);
        Assert.assertSame(areaMenor2,trianguloMenor);
        Assert.assertNull(areaIgual);
    }
    @Test
    public void deveRetornarOQuadradoDeMenorArea(){
        //Given
        Quadrado quadradoMenor = new Quadrado();
        Quadrado quadradoMaior = new Quadrado();

        quadradoMenor.setLado(2);
        quadradoMaior.setLado(5);

        //When
        Quadrado areaMenor1 = calculadoraService.quadradoDeMenorArea(quadradoMenor,quadradoMaior);
        Quadrado areaMenor2 = calculadoraService.quadradoDeMenorArea(quadradoMaior,quadradoMenor);
        Quadrado areaNull = calculadoraService.quadradoDeMenorArea(quadradoMaior,quadradoMaior);

        //Then
        Assert.assertSame(areaMenor1,quadradoMenor);
        Assert.assertSame(areaMenor2,quadradoMenor);
        Assert.assertNull(areaNull);
    }
}
