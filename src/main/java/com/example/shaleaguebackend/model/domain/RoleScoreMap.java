package com.example.shaleaguebackend.model.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
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
@TableName("RoleScoreMap")
@ApiModel(value="RoleScoreMap对象", description="")
public class RoleScoreMap extends Model<RoleScoreMap> {

    private static final long serialVersionUID = 1L;

    @TableField("lordScore")
    private Integer lordScore;

    @TableField("courtierScore")
    private Integer courtierScore;

    @TableField("rebelScore")
    private Integer rebelScore;

    @TableField("traitorScore")
    private Integer traitorScore;


    @Override
    protected Serializable pkVal() {
        return null;
    }

}
