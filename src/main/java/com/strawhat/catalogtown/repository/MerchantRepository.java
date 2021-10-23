package com.strawhat.catalogtown.repository;

import com.strawhat.catalogtown.model.entity.MerchantEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MerchantRepository extends CrudRepository<MerchantEntity, Long> {

  Optional<MerchantEntity> findByName(String name);

  Optional<MerchantEntity> findByCode(String code);
}
