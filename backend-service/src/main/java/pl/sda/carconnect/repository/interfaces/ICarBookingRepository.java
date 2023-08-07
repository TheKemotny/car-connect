package pl.sda.carconnect.repository.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.carconnect.domain.CarBooking;

public interface ICarBookingRepository extends JpaRepository<CarBooking, Long> {
}
