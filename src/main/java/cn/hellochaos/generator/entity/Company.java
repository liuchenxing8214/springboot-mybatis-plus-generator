package cn.hellochaos.generator.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author root
 * @since 2023-01-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Company extends Model<Company> {

    private static final long serialVersionUID = 1L;

    private long id;

    private String companyNo;

    private String companyName;

    private Date publishedDate;

    private String delFlag;


    @Override
    protected Serializable pkVal() {
        return null;
    }

}
