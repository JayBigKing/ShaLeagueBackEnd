package com.example.shaleaguebackend.model.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
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
 * @since 2021-12-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("MilitaryGeneral")
@ApiModel(value="MilitaryGeneral对象", description="")
public class MilitaryGeneral extends Model<MilitaryGeneral> {

    private static final long serialVersionUID = 1L;

    @TableId("MGid")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long MGid;

    @TableField("MGname")
    private String MGname;

    @TableField("MGcountry")
    private String MGcountry;


    @Override
    protected Serializable pkVal() {
        return this.MGid;
    }

}
