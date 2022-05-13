package start;


import api.FlightRepository;
import domain.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/flight")
public class FlightController {
    private static final String template = "Hello, %s!";
    @Autowired
    private FlightRepository flightRepository;

    @RequestMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        System.out.println("nu");
        return String.format(template, name);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Flight> getAll(){
        System.out.println("Get all flights ...");
        return flightRepository.getAll();
    }

    @RequestMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) throws SQLException {
        System.out.println("Find by id ...");
        Optional<Flight> optionalFlight = flightRepository.findByID(id);
        if (optionalFlight.isPresent()) {
            return new ResponseEntity<>(optionalFlight.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>("Flight not found", HttpStatus.NOT_FOUND);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Flight add(@RequestBody Flight flight){
        System.out.println("Add flight ...");
        System.out.println(flight);
        flightRepository.add(flight);
        return flight;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Flight update(@RequestBody Flight flight) {
        System.out.println("Updating flight ...");
        flightRepository.update(flight, flight);
        return flight;
    }

    @RequestMapping(value="/{id}", method= RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable Long id){
        System.out.println("Deleting flight with id ... " + id);
        try {
            flightRepository.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex){
            return new ResponseEntity<>("Flight not found", HttpStatus.NOT_FOUND);
        }
    }
}
