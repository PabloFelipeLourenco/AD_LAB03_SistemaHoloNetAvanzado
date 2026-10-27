/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ut4.pruebas;

/**
 *
 * @author pablo
 */
import java.util.List;
import ut4.modelo.Nave;
import ut4.util.HibernateUtil;

public class AD_LAB03_SistemaHoloNetAvanzado {

    public static void main(String[] args) {
        try {
            // Desafío 1: muestra las naves del Imperio.
            System.out.println("=== DESAFIO 1: SENSOR TACTICO ===");

            List<Nave> naves = HoloNetControl.obtenerNavesPorBandoPlaneta("Imperio");

            for (Nave nave : naves) {
                System.out.println("Nave: " + nave.getNombre()
                        + " | Estado: " + nave.getEstadoSistema());
            }

            // Desafío 2: muestra las naves críticas y sus planetas.
            System.out.println("\n=== DESAFIO 2: FLOTA CRITICA ===");

            List<Nave> navesCriticas = HoloNetControl.obtenerFlotaCriticaConPlaneta();

            for (Nave nave : navesCriticas) {
                System.out.println("Nave: " + nave.getNombre()
                        + " | Estado: " + nave.getEstadoSistema()
                        + " | Planeta: "
                        + nave.getPlanetaOrigen().getNombre());
            }

            // Desafío 3: muestra el reporte de naves y planetas.
            System.out.println("\n=== DESAFIO 3: REPORTE DE ALISTAMIENTO ===");

            List<Object[]> reporte = HoloNetControl.obtenerReportePlanetasAsignados();

            for (Object[] fila : reporte) {
                System.out.println("Nave: " + fila[0]
                        + " | Planeta: " + fila[1]);
            }

        } catch (Exception e) {
            System.err.println("Error al ejecutar el laboratorio: " + e.getMessage());
            e.printStackTrace();
        } finally {
            HibernateUtil.shutdown();
        }
    }
}
