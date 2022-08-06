package co.develhope.CRUDexercise.repositories;

import co.develhope.CRUDexercise.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> { //si mette long perché è il tipo della chiave primaria in car(id)
}
