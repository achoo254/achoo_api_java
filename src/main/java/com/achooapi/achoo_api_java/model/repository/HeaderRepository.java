package com.achooapi.achoo_api_java.model.repository;

import com.achooapi.achoo_api_java.model.entity.Api;
import com.achooapi.achoo_api_java.model.entity.Header;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface HeaderRepository extends JpaRepository<Header, String>, JpaSpecificationExecutor<Header> {
}
