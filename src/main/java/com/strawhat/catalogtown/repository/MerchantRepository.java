package com.strawhat.catalogtown.repository;

import com.strawhat.catalogtown.model.entity.MerchantEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantRepository extends CrudRepository<MerchantEntity, Long> {
}
