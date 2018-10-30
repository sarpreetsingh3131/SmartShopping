package org.store.query.service.service;

import org.store.domain.service.dao.StoreDao;
import org.store.domain.service.model.Store;
import org.store.domain.service.repository.StoreRepository;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class StoreQueryService {

    private StoreRepository storeRepository;

    public StoreQueryService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    public List<StoreDao> findAll() {
        List<Store> stores = this.storeRepository.findAll();
        List<StoreDao> storeDaos = new LinkedList<>();
        stores.forEach(store -> storeDaos.add(new StoreDao(store.getUserId(), store)));
        return storeDaos;
    }

    public StoreDao findByUserId(String userId) {
        Store store = Optional
                .of(this.storeRepository.findByUserId(userId))
                .orElseThrow(() -> new NoSuchElementException("No store with userId = " + userId));
        return new StoreDao(store.getUserId(), store);
    }

    public void save(Store store) {
        this.storeRepository.save(store);
    }

    public void delete(String id) {
        this.storeRepository.delete(id);
    }

    public void deleteAll() {
        this.storeRepository.deleteAll();
    }
}
