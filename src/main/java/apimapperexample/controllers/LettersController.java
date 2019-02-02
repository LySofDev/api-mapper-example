/**
 * 
 */
package apimapperexample.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import apimapperexample.models.LetterFrequencyReport;
import apimapperexample.repositories.LettersRepository;

/**
 * @author esteban
 *
 */
@RestController
@RequestMapping("/letters")
public class LettersController {
	
	@Autowired
	private LettersRepository letters;

	@GetMapping(value = "/{letter}", produces = "application/json")
	public LetterFrequencyReport getLetterFrequencyReport(@PathVariable final String letter) {
		return this.letters.getLetterFrequencyReport(letter);
	}
}
