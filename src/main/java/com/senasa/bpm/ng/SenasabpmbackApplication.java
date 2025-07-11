package com.senasa.bpm.ng;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@EnableScheduling
@SpringBootApplication
public class SenasabpmbackApplication {

	public static void main(String[] args) {
	}
	@PostConstruct
	public void init() {TimeZone.setDefault(TimeZone.getTimeZone("America/Lima"));}
}
