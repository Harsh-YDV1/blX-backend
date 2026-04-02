package com.bharat.legacyexplorer.controller;

import com.bharat.legacyexplorer.model.*;
import com.bharat.legacyexplorer.service.HeritageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HeritageSiteController {
    private final HeritageService heritageService;

    public HeritageSiteController(HeritageService heritageService) {
        this.heritageService = heritageService;
    }

    @GetMapping("/sites")
    public List<HeritageSite> getSites() { return heritageService.getSites(); }

    @PostMapping("/sites")
    public HeritageSite addSite(@RequestBody HeritageSite site) { return heritageService.addSite(site); }

    @DeleteMapping("/sites/{id}")
    public void deleteSite(@PathVariable Long id) { heritageService.deleteSite(id); }

    @GetMapping("/traditions")
    public List<Tradition> getTraditions() { return heritageService.getTraditions(); }

    @PostMapping("/traditions")
    public Tradition addTradition(@RequestBody Tradition item) { return heritageService.addTradition(item); }

    @DeleteMapping("/traditions/{id}")
    public void deleteTradition(@PathVariable Long id) { heritageService.deleteTradition(id); }

    @GetMapping("/guides")
    public List<Guide> getGuides() { return heritageService.getGuides(); }

    @PostMapping("/guides")
    public Guide addGuide(@RequestBody Guide item) { return heritageService.addGuide(item); }

    @DeleteMapping("/guides/{id}")
    public void deleteGuide(@PathVariable Long id) { heritageService.deleteGuide(id); }

    @GetMapping("/state-symbols")
    public List<StateSymbol> getStateSymbols() { return heritageService.getStateSymbols(); }

    @PostMapping("/state-symbols")
    public StateSymbol addStateSymbol(@RequestBody StateSymbol item) { return heritageService.addStateSymbol(item); }

    @DeleteMapping("/state-symbols/{id}")
    public void deleteStateSymbol(@PathVariable Long id) { heritageService.deleteStateSymbol(id); }
}
