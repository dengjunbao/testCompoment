package com.component.test.dao;
import com.component.test.entity.TestPicture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TestPictureDao extends JpaRepository<TestPicture,Long> {


    List<TestPicture> findByAssetId(Long assetId);
}
