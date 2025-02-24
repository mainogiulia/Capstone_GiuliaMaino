package it.epicode.Capstone.reservation;

import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Locale;

@Component
@Order(2)
public class ReservationRunner implements CommandLineRunner {
    private final ReservationRepository reservationRepository;

    public ReservationRunner(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    Faker faker = new Faker(new Locale("it"));

    public void run(String... args) throws Exception {
        if (reservationRepository.count() == 0) {

            for (int i = 0; i < 10; i++) {
                Reservation reservation = new Reservation();

                reservation.setReservationDate(LocalDate.now().plusDays(faker.number().numberBetween(2, 120)));

                int[] minutes = {0, 15, 30, 45};
                int randomMinute = minutes[faker.number().numberBetween(0, minutes.length)];
                LocalTime reservationTime = LocalTime.of(faker.number().numberBetween(18, 22), randomMinute);
                reservation.setReservationTime(reservationTime);

                reservation.setNumberOfGuests(faker.number().numberBetween(1, 15));
                reservation.setCustomerName(faker.name().fullName());
                reservation.setEmail(faker.internet().emailAddress());
                reservation.setCancellationCode(faker.regexify("[A-Z0-9]{10}"));

                reservationRepository.save(reservation);
            }
        }
    }
}
