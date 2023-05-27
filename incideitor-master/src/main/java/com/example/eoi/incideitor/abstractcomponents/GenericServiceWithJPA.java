package com.example.eoi.incideitor.abstractcomponents;

import com.eoi.ejemplospringboot.errorcontrol.exceptions.MiEntidadNoEncontradaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Servicio genérico para entidades utilizando Spring Data JPA.
 *
 * <p>Esta clase abstracta proporciona una implementación base para los servicios que trabajan con entidades utilizando Spring Data JPA.
 * Está parametrizada para que pueda ser utilizada con diferentes tipos de entidades y repositorios.</p>
 *
 * <p>Los principios de programación de Spring Boot que se aplican con esta clase incluyen:</p>
 * <ul>
 *     <li>Inversión de control (IoC): La clase sigue el principio de Inversión de Control al permitir que los detalles de implementación
 *     sean proporcionados por clases concretas que la extienden.</li>
 *     <li>Inyección de dependencias (DI): Utiliza inyección de dependencias para obtener el repositorio necesario para acceder a los datos
 *     de la entidad. Esto permite la separación de responsabilidades y facilita la prueba y la flexibilidad de intercambio de implementaciones.</li>
 *     <li>Principio de abstracción: Proporciona una abstracción común para operaciones CRUD comunes en los servicios que trabajan con
 *     entidades, permitiendo la reutilización de código y la consistencia en la implementación de servicios.</li>
 * </ul>
 *
 * @param <T> El tipo de entidad gestionado por el servicio.
 * @param <ID> El tipo de dato utilizado como identificador de la entidad.
 */
public abstract class GenericServiceWithJPA<T, ID> implements GenericService<T> {

    @Autowired
    protected JpaRepository<T, ID> repository;

    /**
     * Obtiene todas las entidades.
     *
     * @return Una lista de todas las entidades.
     */
    @Override
    public List<T> listAll() {
        return repository.findAll();
    }


    /**
     * Obtiene el repositorio asociado al servicio.
     *
     * @return El repositorio utilizado para acceder a los datos de la entidad.
     */
    @Override
    public JpaRepository<T, ?> getRepository() {
        return repository;
    }

    /**
     * Obtiene una entidad por su identificador.
     *
     * @param id El identificador de la entidad.
     * @return La entidad correspondiente al identificador, o null si no se encuentra.
     */
    @Override
    public T getById(Object id) {
        return repository.findById((ID) id).orElseThrow(MiEntidadNoEncontradaException::new);
    }

    /**
     * Crea una nueva entidad.
     *
     * @param entity La entidad a crear.
     * @return La entidad creada.
     */
    @Override
    public T create(T entity) {
        return repository.saveAndFlush((T) entity);
    }

    /**
     * Actualiza una entidad existente.
     *
     * @param id     El identificador de la entidad a actualizar.
     * @param entity La entidad actualizada.
     * @return La entidad actualizada.
     */
    @Override
    public T update(T entity) {

        return repository.saveAndFlush(
                (T)entity
        );

    }

    /**
     * Elimina una entidad por su identificador.
     *
     * @param id El identificador de la entidad a eliminar.
     */
    @Override
    public void delete(Object id) {

        repository.deleteById((ID) id);
    }
}

