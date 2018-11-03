package repository;

import model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car ,Long> {
    @Query("SELECT c.id, c.brand, c.engine, c.model, c.price, c.year FROM Car c")
    List<Car> findAllCarsWithoutOwner();

    List<Car> findAllByOrderByIdAsc();

    List<Car> findAllByOrderByBrandAsc();

    List<Car> findAllByOrderByYearAsc();

    List<Car> findAllByOrderByYearDesc();

    List<Car> findAllByOrderByPriceAsc();

    List<Car> findAllByOrderByPriceDesc();
}