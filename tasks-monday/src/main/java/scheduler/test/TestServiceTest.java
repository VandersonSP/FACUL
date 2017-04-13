package scheduler.test;

import net.sf.corn.httpclient.HttpResponse;
import org.junit.Test;
import scheduler.Service;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestServiceTest {

//    @Test
//    public void xadrez() {
//        try {
//            BigDecimal g = BigDecimal.ZERO;
//            int q;
//            for (q = 0; q <= 63; q = q + 1) {
//                g = g.add(new BigDecimal(Math.pow(2, q)));
//            }
//            System.out.print(g);
//        } catch (Exception e) {
////            System.out.print(e);18446744073709551615
//        }
//    }

    private Service service = new Service();

    @Test
    public void testParticionamentoClassesEquivalencia() throws Exception {
        String aux = "1.jpg , 2.jpg, 3.jpg, 4.jpg, 5.jpg ";
        int res = service.findAmountJpg(aux);
        assertEquals(5, res);
    }

    @Test
    public void testAnaliseValorLimite() throws Exception {
        String aux = " ssssssssssssssss";
        int res = service.findAmountJpg(aux);
        assertEquals(0, res);
        try {
            boolean isError = false;
            int code = 200;
            String message = "";
            HttpResponse response = new HttpResponse(code, aux, message, null, null);
            String result = service.get(response);
            assertEquals(" Nenhuma imagem .jpg foi encontrada na pagina!", result);
        } catch (Exception e) {
            System.out.print(e);
        }
    }

    @Test
    public void testGrafoCausaEfeito() throws Exception {
        String aux20 = "1.jpg , 2.jpg, 3.jpg, 4.jpg, 5.jpg ,1.jpg , 2.jpg, 3.jpg, 4.jpg, 5.jpg 1.jpg , 2.jpg, 3.jpg, 4.jpg, 5.jpg ,1.jpg , 2.jpg, 3.jpg, 4.jpg, 5.jpg ";
        String aux10 = "1.jpg , 2.jpg, 3.jpg, 4.jpg, 5.jpg ,1.jpg , 2.jpg, 3.jpg, 4.jpg, 5.jpg ";
        String aux5 = "1.jpg , 2.jpg, 3.jpg, 4.jpg, 5.jpg  ";
        String aux4 = "1.jpg , 2.jpg, 3.jpg, 4.jpg ";
        String aux2 = "1.jpg , 2.jpg ";
        String aux1 = "1.jpg ";
        boolean isError = false;
        boolean resaserttrue = false;
        int code = 200;
        String message = "";
        String result = "";
        int res = 0;


        try {
            HttpResponse response = new HttpResponse(code, aux20, message, null, null);
            result = service.get(response);
        } catch (Exception e) {
            System.out.print(e);
        }
        res = service.findAmountJpg(aux20);
        resaserttrue = res > 10;
        assertTrue(resaserttrue);
        assertEquals("Pagina Pesada", result);


        try {
            HttpResponse response = new HttpResponse(code, aux10, message, null, null);
            result = service.get(response);
        } catch (Exception e) {
            System.out.print(e);
        }
        res = service.findAmountJpg(aux10);
        resaserttrue = res > 5 && res <= 10;
        assertTrue(resaserttrue);
        assertEquals("Pagina um Pouco carregada", result);

        try {
            HttpResponse response = new HttpResponse(code, aux5, message, null, null);
            result = service.get(response);
        } catch (Exception e) {
            System.out.print(e);
        }
        res = service.findAmountJpg(aux5);
        resaserttrue = res > 2 && res <= 5;
        assertTrue(resaserttrue);
        assertEquals("Pagina Comum", result);


        try {
            HttpResponse response = new HttpResponse(code, aux4, message, null, null);
            result = service.get(response);
        } catch (Exception e) {
            System.out.print(e);
        }
        res = service.findAmountJpg(aux4);
        resaserttrue = res > 2 && res <= 5;
        assertTrue(resaserttrue);
        assertEquals("Pagina Comum", result);


        try {
            HttpResponse response = new HttpResponse(code, aux2, message, null, null);
            result = service.get(response);
        } catch (Exception e) {
            System.out.print(e);
        }
        res = service.findAmountJpg(aux2);
        resaserttrue = res <= 2;
        assertTrue(resaserttrue);
        assertEquals("Pagina Basica", result);

        try {
            HttpResponse response = new HttpResponse(code, aux1, message, null, null);
            result = service.get(response);
        } catch (Exception e) {
            System.out.print(e);
        }
        res = service.findAmountJpg(aux1);
        resaserttrue = res <= 2;
        assertTrue(resaserttrue);
        assertEquals("Pagina Basica", result);
    }


}