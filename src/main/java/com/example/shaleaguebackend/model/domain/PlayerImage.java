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
 * @since 2021-11-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("PlayerImage")
@ApiModel(value="PlayerImage对象", description="")
public class PlayerImage extends Model<PlayerImage> {

    private static final long serialVersionUID = 1L;

    @TableField("Sid")
    private Long Sid;

    @TableField("imgUrl")
    private String imgUrl;


    @Override
    protected Serializable pkVal() {
        return null;
    }

}
