package com.example.citytrafficanalytics.service;

import com.example.citytrafficanalytics.model.CityAnalytic;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Lucas Copque
 * @since 01/12/2021
 */

@Service
public class CityAnalyticService {

    private List<CityAnalytic> cities = new ArrayList<>();

    /**
     * Exibe qual o menor índice de acidentes de trânsito e qual a cidade.
     */
    public void getLowestAccidentRate() {
        System.err.println("\n\n...::: Imprimindo cidade com menor índice de acidentes :::...");
        CityAnalytic result = this.cities.stream().sorted(Comparator.comparingInt(CityAnalytic::getAccidents)).findFirst().get();
        System.err.println(String.format("Índice: %s\tCidade: %s", result.getAccidents(), result.getCity()));
    }

    /**
     * Exibe qual o maior índice de acidente e qual a cidade.
     */
    public void getHighestAccidentRate() {
        System.err.println("\n\n...::: Imprimindo cidade com maior índice de acidentes :::...");
        CityAnalytic result = this.cities.stream().sorted(Comparator.comparingInt(CityAnalytic::getAccidents).reversed()).findFirst().get();
        System.err.println(String.format("Índice: %s\tCidade: %s", result.getAccidents(), result.getCity()));
    }

    /**
     * Exibe a média de veículos nas cidades juntas.
     */
    public void getMeanVehiclesWithAllCity() {
        System.err.println("\n\n...::: Imprimindo média de veículos nas cidades :::...");
        AtomicInteger vehicles = new AtomicInteger();
        Integer cities = this.cities.size();
        this.cities.forEach(cityAnalytic -> {
            vehicles.addAndGet(cityAnalytic.getVehicles());
        });
        int mean = vehicles.get() / cities;
        System.err.println(String.format("Total de Veículos: %s\nTotal de Cidades: %s\nMédia: %s", vehicles, cities, mean));
    }

    /**
     * Exibe a média de acidentes de trânsito em cidade com menos veículos que o informado como parâmetro
     * @param vehicles Nº de veículos utilizado como parâmetro para incluir a cidade nas estatísticas.
     *                 A cidade deve possui menos veículos que o informado para ser inclusva na esatística.
     *
     */
    public void getMeanAccident(Integer vehicles) {
        System.err.println("\n\n...::: Imprimindo média de acidadentes nas cidades com menos de " + vehicles + " veículos :::...");
        AtomicInteger accidentes = new AtomicInteger();
        AtomicInteger cities = new AtomicInteger();
        this.cities.forEach(cityAnalytic -> {
            if(cityAnalytic.getVehicles() < vehicles) {
                accidentes.addAndGet(cityAnalytic.getVehicles());
                cities.incrementAndGet();
            }
        });
        int mean = accidentes.get() / cities.get();
        System.err.println(String.format("Total de Acidentes: %s\nTotal de Cidades: %s\nMédia: %s", accidentes.get(), cities.get(), mean));
    }

    public void setAnalystics(List<CityAnalytic> cities) {
        this.cities = cities;
        this.printCities();
    }

    public void printCities() {
        System.err.println("\n\n...::: Imprimindo Fake Índices :::...");
        this.cities.forEach(System.out::println);
    }
}
