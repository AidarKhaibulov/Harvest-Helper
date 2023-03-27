package rest.hh.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rest.hh.models.Culture;
import rest.hh.services.CultureService;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/cultures")
@RequiredArgsConstructor
public class CultureController {
    private final CultureService cultureService;

    /**
     *  <h2>1st group realization</h2> Глоссарий советов - как и когда правильно сажать разные культуры
     *
     * @return tips for provided culture
     */
    @GetMapping("/getTips/{id}")
    public ResponseEntity<String> getTips(@PathVariable Long id) {
        Culture culture;
        try {
            culture=cultureService.findById(id).orElseThrow();
        }
        catch (NoSuchElementException e){
            System.out.println("Not found such a culture");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(culture.getTips());
    }
    /**
     *  <h2>1st group realization</h2> Таблица с диапазонами благоприятного времени посадки культур
     *
     * @return optimal time for provided culture
     */
    @GetMapping("/getOptimalTime/{id}")
    public ResponseEntity<String> getOptimalTime(@PathVariable Long id) {
        Culture culture;
        try {
            culture=cultureService.findById(id).orElseThrow();
        }
        catch (NoSuchElementException e){
            System.out.println("Not found such a culture");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(culture.getOptimalTime());
    }

}
