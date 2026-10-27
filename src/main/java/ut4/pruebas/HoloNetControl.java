/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ut4.pruebas;

/**
 *
 * @author pablo
 */
import java.util.List;
import ut4.modelo.Nave;
import ut4.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class HoloNetControl {

    // Obtiene las naves de un bando que no están en mantenimiento.
    public static List<Nave> obtenerNavesPorBandoPlaneta(String bando) {
        String hql = "FROM Nave n INNER JOIN n.planetaOrigen p "
                + "WHERE p.afiliacion = :bandoRef "
                + "AND n.estadoSistema != 'Mantenimiento'";

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Nave> query = session.createQuery(hql, Nave.class);
            query.setParameter("bandoRef", bando);
            return query.getResultList();
        }
    }

    // Obtiene las naves críticas cargando también su planeta.
    public static List<Nave> obtenerFlotaCriticaConPlaneta() {
        String hql = "FROM Nave n INNER JOIN FETCH n.planetaOrigen "
                + "WHERE n.estadoSistema = 'Critico'";

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Nave> query = session.createQuery(hql, Nave.class);
            return query.getResultList();
        }
    }

    // Obtiene el nombre de cada nave y el de su planeta, si tiene.
    public static List<Object[]> obtenerReportePlanetasAsignados() {
        String hql = "SELECT n.nombre, p.nombre "
                + "FROM Nave n LEFT JOIN n.planetaOrigen p";

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Object[]> query = session.createQuery(hql, Object[].class);
            return query.getResultList();
        }
    }
}
