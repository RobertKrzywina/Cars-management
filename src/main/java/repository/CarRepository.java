package repository;

import model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface CarRepository extends JpaRepository<Car ,Long> {

    List<Car> findAllByOrderByIdAsc();

    List<Car> findAllByOrderByBrandAsc();

    List<Car> findAllByOrderByYearAsc();

    List<Car> findAllByOrderByYearDesc();

    List<Car> findAllByOrderByPriceAsc();

    List<Car> findAllByOrderByPriceDesc();
}