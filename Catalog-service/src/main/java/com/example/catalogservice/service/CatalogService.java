package com.example.catalogservice.service;

import com.example.catalogservice.jpa.CatalogEntity;
import org.springframework.stereotype.Repository;

public interface CatalogService {
    Iterable<CatalogEntity> getAllCatalogs();
}
