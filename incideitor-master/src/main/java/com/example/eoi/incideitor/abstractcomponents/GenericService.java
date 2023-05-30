package com.example.eoi.incideitor.abstractcomponents;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Interfaz genérica para servicios CRUD.
 *
 * <p>Esta interfaz define los métodos básicos para realizar operaciones de consulta, creación, actualización y eliminación de entidades.
 * Es parametrizada para que pueda ser utilizada con diferentes tipos de repositorios.</p>
 *
 * <p>Los principios de programación de Spring Boot que se aplican con esta interfaz incluyen:</p>
 * <ul>
 *     <li>Inversión de control (IoC): La interfaz sigue el principio de Inversión de Control al permitir que los detalles de implementación
 *     sean proporcionados por clases concretas que la implementan.</li>
 *     <li>Inyección de dependencias (DI): Utiliza inyección de dependencias para obtener el repositorio necesario para acceder a los datos
 *     de la entidad. Esto permite la separación de responsabilidades y facilita la prueba y la flexibilidad de intercambio de implementaciones.</li>
 *     <li>Principio de abstracción: Abstrae las operaciones CRUD comunes en un contrato genérico, lo que permite que se reutilice en diferentes
 *     partes de la aplicación sin conocer los detalles específicos de la implementación.</li>
 * </ul>
 *
 * @param <T> El tipo de entidad gestionado por el servicio.
 */
public interface GenericService<T> {

    /**
     * Obtiene una entidad por su identificador.
     *
     * @param id El identificador de la entidad.
     * @return La entidad correspondiente al identificador, o null si no se encuentra.
     */
    T getById(Object id);

    /**
     * Crea una nueva entidad.
     *
     * @param entity La entidad a crear.
     * @return La entidad creada.
     */
    T create(T entity);

    /**
     * Actualiza una entidad existente.
     *
     * @param "id"     El identificador de la entidad a actualizar.
     * @param entity La entidad actualizada.
     * @return La entidad actualizada.
     */
    T update(T entity);

    /**
     * Elimina una entidad por su identificador.
     *
     * @param id El identificador de la entidad a eliminar.
     */
    void delete(Object id);

    /**
     * Obtiene todas las entidades.
     *
     * @return Una lista de todas las entidades.
     */
    List<T> listAll();

    /**
     * Obtiene el repositorio asociado al servicio.
     *
     * @return El repositorio utilizado para acceder a los datos de la entidad.
     */
    JpaRepository<T, ?> getRepository();
}

