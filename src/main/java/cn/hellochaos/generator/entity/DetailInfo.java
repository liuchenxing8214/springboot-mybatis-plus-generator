package cn.hellochaos.generator.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author root
 * @since 2023-01-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class DetailInfo extends Model<DetailInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * um
     */
    private String um;

    /**
     * 类型
     */
    private String type;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 工资
     */
    private Double salary;


    @Override
    protected Serializable pkVal() {
        return null;
    }

}
