package com.bharat.legacyexplorer.service;

import com.bharat.legacyexplorer.model.*;

import com.bharat.legacyexplorer.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeritageService {
    private final HeritageSiteRepository siteRepo;
    private final TraditionRepository traditionRepo;
    private final GuideRepository guideRepo;
    private final StateSymbolRepository symbolRepo;

    public HeritageService(HeritageSiteRepository siteRepo, TraditionRepository traditionRepo,
                           GuideRepository guideRepo, StateSymbolRepository symbolRepo) {
        this.siteRepo = siteRepo;
        this.traditionRepo = traditionRepo;
        this.guideRepo = guideRepo;
        this.symbolRepo = symbolRepo;
    }

    public List<HeritageSite> getSites() { return siteRepo.findAll(); }
    public HeritageSite addSite(HeritageSite site) { return siteRepo.save(site); }
    public void deleteSite(Long id) { siteRepo.deleteById(id); }

    public List<Tradition> getTraditions() { return traditionRepo.findAll(); }
    public Tradition addTradition(Tradition item) { return traditionRepo.save(item); }
    public void deleteTradition(Long id) { traditionRepo.deleteById(id); }

    public List<Guide> getGuides() { return guideRepo.findAll(); }
    public Guide addGuide(Guide item) { return guideRepo.save(item); }
    public void deleteGuide(Long id) { guideRepo.deleteById(id); }

    public List<StateSymbol> getStateSymbols() { return symbolRepo.findAll(); }
    public StateSymbol addStateSymbol(StateSymbol item) { return symbolRepo.save(item); }
    public void deleteStateSymbol(Long id) { symbolRepo.deleteById(id); }
}
