package com.component.dao;
import com.component.entity.TestPicture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TestPictureDao extends JpaRepository<TestPicture,Long> {


    List<TestPicture> findByAssetId(Long assetId);
}
