package com.achooapi.achoo_api_java.model.repository;

import com.achooapi.achoo_api_java.model.entity.Api;
import com.achooapi.achoo_api_java.model.entity.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CollectionRepository extends JpaRepository<Collection, String>, JpaSpecificationExecutor<Collection> {
}
