package com.component.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity(name = "test_picture")
@Table(name = "test_picture")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TestPicture {
    //id
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private Long id;
    //关联id
    private Long assetId;
    //图片名称
    private String pictureName;
    //base64
    private String base;
    //二进制
    private byte[] bytesPicture;

    private String reserved1;
    private String reserved2;
}
