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
@TableName("Mrole")
@ApiModel(value="Mrole对象", description="")
public class Mrole extends Model<Mrole> {

    private static final long serialVersionUID = 1L;

    @TableId("MRid")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long MRid;

    @TableField("Rid")
    private Long Rid;

    @TableField("MGid")
    private Long MGid;


    @Override
    protected Serializable pkVal() {
        return this.MRid;
    }

}
