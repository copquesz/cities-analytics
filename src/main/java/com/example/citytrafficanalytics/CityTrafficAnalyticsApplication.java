package com.example.citytrafficanalytics;

import com.example.citytrafficanalytics.model.CityAnalytic;
import com.example.citytrafficanalytics.service.CityAnalyticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@SpringBootApplication
public class CityTrafficAnalyticsApplication implements CommandLineRunner {

    @Autowired
    private CityAnalyticService service;

    public static void main(String[] args) {
        SpringApplication.run(CityTrafficAnalyticsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        // PaRãmetro para trazer um número randômico de veículos até ...
        int vehicleLowCity = 500;
        int vehicleMediaCity = 1500;
        int vehicleHighCity = 3000;

        // PaRãmetro para trazer um número randômico de acidentes até ...
        int accidenttLowCity = 10;
        int accidenttMediaCity = 15;
        int accidenttHighCity = 50;

        Random random = new Random();

        // Popula dados
        CityAnalytic saoPaulo = new CityAnalytic(1L, "São Paulo", random.nextInt(vehicleHighCity), random.nextInt(accidenttHighCity));
        CityAnalytic saoJoseDoRioPreto = new CityAnalytic(2L, "São José do Rio Preto", random.nextInt(vehicleMediaCity), random.nextInt(accidenttMediaCity));
        CityAnalytic ourinhos = new CityAnalytic(3L, "Ourinhos", random.nextInt(vehicleMediaCity), random.nextInt(accidenttMediaCity));
        CityAnalytic rioDeJaneiro = new CityAnalytic(4L, "Rio de Janeiro", random.nextInt(vehicleHighCity), random.nextInt(accidenttHighCity));
        CityAnalytic bragancaPaulista = new CityAnalytic(5L, "Bragança Paulista", random.nextInt(vehicleMediaCity), random.nextInt(accidenttMediaCity));
        CityAnalytic buzio = new CityAnalytic(6L, "Búzios", random.nextInt(vehicleMediaCity), random.nextInt(accidenttMediaCity));
        CityAnalytic lambari = new CityAnalytic(7L, "Lambari", random.nextInt(vehicleLowCity), random.nextInt(accidenttLowCity));

        // Atribui os dados em um vetor
        List<CityAnalytic> cities = Arrays.asList(saoPaulo, saoJoseDoRioPreto, ourinhos, rioDeJaneiro, bragancaPaulista, buzio, lambari);
        this.service.setAnalystics(cities);

        // Imprime as estatisticas
        this.service.getLowestAccidentRate();
        this.service.getHighestAccidentRate();
        this.service.getMeanVehiclesWithAllCity();
        this.service.getMeanAccident(2000);
    }
}
