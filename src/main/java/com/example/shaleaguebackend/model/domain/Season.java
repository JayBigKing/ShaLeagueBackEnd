package com.example.shaleaguebackend.model.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author jay
 * @since 2021-11-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("Season")
@ApiModel(value="Season对象", description="")
public class Season extends Model<Season> {

    private static final long serialVersionUID = 1L;

    @TableId("Sid")
    private Long Sid;

    @TableField("Sname")
    private String Sname;


    @Override
    protected Serializable pkVal() {
        return this.Sid;
    }

}
